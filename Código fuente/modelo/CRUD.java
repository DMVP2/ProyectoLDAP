package modelo;
import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPModification;
import com.novell.ldap.LDAPSearchResults;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Christian
 * Autor del código original (Base) que se utilizo para realizar la solución
 * Código extraido de "https://cafelojano.wordpress.com/2009/05/26/trabajando-con-un-servidor-ldap-con-java/"
 * Esta clase sufrió de modificaciones
 */

public class CRUD 
{
	
	//////////////// Atributos utilizados para la realización de las operaciones de CRUD
	
	private Conexion conexion;
	private LDAPConnection lc;

	private String dominio; 
	private ArrayList <DistinguishedName> DN;

	/**
	 * Método constructor de la clase "CRUD"
	 * @param pConexion (Conexión al servidor LDAP)
	 * @param pArrayList (ArrayList con los diferentes DN que maneja el directorio LDAP)
	 */
	public CRUD(Conexion pConexion, ArrayList pArrayList)
	{
		conexion = pConexion;
		lc = new LDAPConnection();

		DN = pArrayList;
		dominio = conexion.getDominio();
	}

	/**
	 * Método que realiza la inserción de un usuario (Registro) en el directorio LDAP
	 * @param pUID (UID del usuario a agregar)
	 * @param pNombre (Nombre del usuario a agregar)
	 * @param pApellido (Apellido del usuario a agregar)
	 * @param pNombreCompleto (Nombre completo del usuario a agregar. Cabe aclarar que este se genera automaticamente mediante el uso del nombre y del apellido)
	 * @param pCorreoElectronico (Correo electrónico del usuario a agregar)
	 * @param pTelefono (Número de teléfono del usuario a agregar)
	 * @param pRoomNumber (Ubicación del usuario a agregar)
	 * @param pTitle (Actividad del usuario a agregar)
	 * @param pRoles (Roles del usuario a agregar)
	 * @param pContraseña (Contraseña del usuario a agregar)
	 * @param pUnidadAdministrativa (Unidad administrativa a la cual pertenece el usuario a agregar)
	 */
	public void Añadir(String pUID, String pNombre, String pApellido, String pNombreCompleto, String pCorreoElectronico, String pTelefono, String pRoomNumber, String pTitle, String pRoles, String pContraseña, String pUnidadAdministrativa) 
	{
		try 
		{
			LDAPEntry usuario = Datos(pUID, pNombre, pApellido, pNombreCompleto, pCorreoElectronico, pTelefono, pRoomNumber, pTitle, pRoles, pContraseña, pUnidadAdministrativa);
			lc = conexion.ConexionManager();
			lc.add(usuario);
			conexion.CerrarConLDAP(lc);
			JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
		} 
		catch(LDAPException ex) 
		{
			if (ex.getResultCode() == 68) 
			{
				JOptionPane.showMessageDialog(null, "ERROR: El usuario ya se encuentra ingresado");
			}
			Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE,null, ex);
		}
	}

	/**
	 * Método que se encarga de crear el DN unico del usuario a agregar en el directorio LDAP
	 * Mediante este metodo se evita que se tenga que utilizar "Hard Code" o que el usuairo del programa tenga que ingresar el DN completo al momento de agregar un usuario (Registro)
	 * @param pUID (UID del usuario a agregar)
	 * @param pUnidadAdministrativa (Unidad administrativa a la cual pertenece el usuario a agregar)
	 * @param dominio (Dominio del servidor LDAP)
	 * @return resultadoDN (DN unico del usuario a agregar en el directorio LDAP)
	 */
	public String crearDN(String pUID, String pUnidadAdministrativa, String dominio)
	{
		String resultadoDN = null;

		for (int i = 0; i < DN.size(); i++) 
		{
			if(DN.get(i).getNombreDeRuta().equalsIgnoreCase(pUnidadAdministrativa))
			{
				resultadoDN = "uid=" + pUID + "," + DN.get(i).getRuta();
			}
		}

		return resultadoDN;
	}

	/**
	 * Método para la creación del conjunto de datos a agregar en el directorio LDAP
	 * Este metodo genera un objeto con los datos a agregar en un formato que es comprensible para el servidor LDAP
	 * @param pUID (UID del usuario a agregar)
	 * @param pNombre (Nombre del usuario a agregar)
	 * @param pApellido (Apellido del usuario a agregar)
	 * @param pNombreCompleto (Nombre completo del usuario a agregar. Cabe aclarar que este se genera automaticamente mediante el uso del nombre y del apellido)
	 * @param pCorreoElectronico (Correo electrónico del usuario a agregar)
	 * @param pTelefono (Número de teléfono del usuario a agregar)
	 * @param pRoomNumber (Ubicación del usuario a agregar)
	 * @param pTitle (Actividad del usuario a agregar)
	 * @param pRoles (Roles del usuario a agregar)
	 * @param pContraseña (Contraseña del usuario a agregar)
	 * @param pUnidadAdministrativa (Unidad administrativa a la cual pertenece el usuario a agregar)
	 * @return nuevoUsuario (Conjunto de datos a insertar en el directorio LDAP)
	 */
	public LDAPEntry Datos(String pUID, String pNombre, String pApellido, String pNombreCompleto, String pCorreoElectronico, String pTelefono, String pRoomNumber, String pTitle, String pRoles, String pContraseña, String pUnidadAdministrativa) 
	{
		LDAPAttributeSet atributos = new LDAPAttributeSet();
		atributos.add(new LDAPAttribute("objectclass", new String("inetOrgPerson")));
		atributos.add(new LDAPAttribute("uid", new String(pUID)));
		atributos.add(new LDAPAttribute("userpassword", new String(pContraseña)));
		atributos.add(new LDAPAttribute("givenname", new String(pNombre)));
		atributos.add(new LDAPAttribute("sn", new String(pApellido)));
		atributos.add(new LDAPAttribute("cn", new String(pNombreCompleto)));
		atributos.add(new LDAPAttribute("mail", new String(pCorreoElectronico)));
		atributos.add(new LDAPAttribute("telephonenumber", new String(pTelefono)));
		atributos.add(new LDAPAttribute("roomNumber", new String(pRoomNumber)));
		atributos.add(new LDAPAttribute("title", new String(pTitle)));
		atributos.add(new LDAPAttribute("description", new String(pRoles)));
		String dn = crearDN(pUID, pUnidadAdministrativa, dominio);
		LDAPEntry nuevoUsuario = new LDAPEntry(dn, atributos);
		return nuevoUsuario;
	}

	/**
	 * Método que realiza la busqueda del usuario (Registro) en el directorio LDAP
	 * @param pFiltro (Filtro de busqueda)
	 * @param pAtributos (Atributos a retornar en el resultado de la busqueda)
	 */
	public void Buscar(String pFiltro, String [] pAtributos) {
		LDAPSearchResults searchResults;
		String dominioDeBusqueda = dominio;
		String resultadoDeBusqueda = "";
		int searchScope = LDAPConnection.SCOPE_SUB;
		try
		{
			lc = conexion.ConexionUser();
			searchResults = lc.search(dominioDeBusqueda, searchScope, pFiltro, pAtributos, false);
			while (searchResults.hasMore())
			{
				LDAPEntry nextEntry = null;
				try 
				{
					nextEntry = searchResults.next();
				} 
				catch (LDAPException e) 
				{
					System.out.println("Error: " + e.toString());
					continue;
				}
				LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
				Iterator allAttributes = attributeSet.iterator();
				while (allAttributes.hasNext()) 
				{
					LDAPAttribute attribute = (LDAPAttribute) allAttributes.next();
					String attributeName = attribute.getName();
					Enumeration allValues = attribute.getStringValues();
					if (allValues != null) 
					{
						while (allValues.hasMoreElements())
						{
							String value = (String) allValues.nextElement();
							resultadoDeBusqueda = resultadoDeBusqueda + attributeName + ":  " + value + "\n";
						}
					}
				}
				resultadoDeBusqueda = resultadoDeBusqueda + "-------------------------------------------" + "\n";
			}
			conexion.CerrarConLDAP(lc);
		} 
		catch (LDAPException ex) 
		{
			Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE,null, ex);
		}

		if(resultadoDeBusqueda.equals("") == false)
		{
			javax.swing.JTextArea textArea = new javax.swing.JTextArea(resultadoDeBusqueda, 10,  50);
			JScrollPane sp = new JScrollPane(textArea);
			sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JOptionPane.showMessageDialog(null, sp);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No existe ningun resultado para la busqueda especificada");
		}
	}

	/**
	 * Metodo que realiza la eliminación del usuario (Registro) en el directorio LDAP
	 * @param pUID (UID del usuario a eliminar)
	 * @param pUnidadAdministrativa (Unidad administrativa a la cual pertenece el usuario a eliminar)
	 */
	public void EliminarPorUID(String pUID, String pUnidadAdministrativa)
	{
		String resultadoDN = null;

		for (int i = 0; i < DN.size(); i++) 
		{
			if(DN.get(i).getNombreDeRuta().equalsIgnoreCase(pUnidadAdministrativa))
			{
				resultadoDN = "uid=" + pUID + "," + DN.get(i).getRuta();
			}
		}

		try {
			lc = conexion.ConexionManager();
			lc.delete(resultadoDN);
			JOptionPane.showMessageDialog(null, "El usuario: " + pUID + " Fue eliminado correctamente");
			conexion.CerrarConLDAP(lc);
		} 
		catch (LDAPException e) 
		{
			if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {

				JOptionPane.showMessageDialog(null, "Error: No existe ese usuario");
			} 
			else if (e.getResultCode() == LDAPException.INSUFFICIENT_ACCESS_RIGHTS) 
			{
				JOptionPane.showMessageDialog(null, "Error: No tiene permisos suficientes para realizar esta transaccion");
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Error: " + e.toString());
			}
		}
	}

	/**
	 * Método que realiza la modificación de un atributo de un usuario (Registro) del directorio LDAP
	 * @param pUID (UID del usuario a modificar)
	 * @param pNombreAtributo (Nombre del atributo a modificar)
	 * @param pAtributo (Atributo a modificar en un formato que es comprensible para el servidor LDAP)
	 * @param pNuevoValor (Nuevo valor del atributo a modificar)
	 * @param pUnidadAdministrativa (Unidad administrativa a la cual pertenece el usuario a modificar)
	 */
	public void Modificar(String pUID, String pNombreAtributo, String pAtributo, String pNuevoValor, String pUnidadAdministrativa) 
	{

		String resultadoDN = null;

		for (int i = 0; i < DN.size(); i++) 
		{
			if(DN.get(i).getNombreDeRuta().equalsIgnoreCase(pUnidadAdministrativa))
			{
				resultadoDN = "uid=" + pUID + "," + DN.get(i).getRuta();
			}
		}

		try 
		{
			LDAPAttribute atributo;
			lc = conexion.ConexionManager();
			atributo = new LDAPAttribute(pAtributo, pNuevoValor);
			lc.modify(resultadoDN, new LDAPModification (LDAPModification.REPLACE, atributo));
			JOptionPane.showMessageDialog(null, "Atributo " + pNombreAtributo + " modificado correctamente para el usuario " + pUID);
		} 
		catch (LDAPException ex) 
		{
			if (ex.getResultCode() ==  LDAPException.INSUFFICIENT_ACCESS_RIGHTS) {

				JOptionPane.showMessageDialog(null, "Error: NO tiene permisos suficientes para realizar esta transacción");
			}
		}
	}
}