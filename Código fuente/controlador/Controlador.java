package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Archivos;
import modelo.CRUD;
import modelo.Conexion;
import modelo.DistinguishedName;
import vista.VentanaBuscar;
import vista.VentanaCrear;
import vista.VentanaEliminar;
import vista.VentanaModificar;
import vista.VentanaPrincipal;

/**
 * @author David Mauricio Valoyes Porras
 * Clase para el control del programa completo
 */
public class Controlador implements ActionListener
{

	//////////////// Modelo	

	private Conexion conexion;
	private CRUD crud;
	private Archivos archivos;

	//////////////// Interfaz gráfica (GUI)

	private VentanaPrincipal ventanaPrincipal;
	private VentanaCrear ventanaCrear;
	private VentanaBuscar ventanaBuscar;
	private VentanaModificar ventanaModificar;
	private VentanaEliminar ventanaEliminar;

	//////////////// Parámetros del sistema

	private String host;
	private String usuario;
	private String contraseña;
	private String dominio;
	private ArrayList <DistinguishedName> DN;
	private File archivo;

	/**
	 * Método constructor de la clase "Controlador"
	 * Se encarga de inicializar las funciones basicas del sistema
	 * Ejecuta la paramtrización y configuración del sistema
	 */
	public Controlador()
	{
		ventanaPrincipal = new VentanaPrincipal(this);
		DN = new ArrayList<DistinguishedName>();
		archivos = new Archivos();
		try
		{
			parametrizarSistema();
			configurarSistema();
			conexion = new Conexion(host, usuario, contraseña, dominio);
			conexion.ConexionManager();
			crud = new CRUD(conexion, DN);
		}
		catch(Exception e)
		{

		}
	}

	/**
	 * Método para parametrizar el sistema
	 * Se encarga de realizar la carga del archivo de configuración
	 */
	public void parametrizarSistema()
	{
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(selectorArchivos);
		try
		{
			File archivoSeleccionado = selectorArchivos.getSelectedFile();
			archivo = archivoSeleccionado;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "El archivo no se cargo adecuadamente");
		}
	}

	/**
	 * Método para configurar el sistema
	 * Se encarga de realizar la lectura del archivo de configuración y utilizar los datos alli guardados para configurar el sistema adecuadamente
	 */
	public void configurarSistema()
	{

		ArrayList <String> datos = new ArrayList<String>();

		if(archivo != null)
		{
			datos = archivos.leerArchivo(archivo);
			ventanaPrincipal.getPanelAcciones().getBtnCrear().setEnabled(true);
			ventanaPrincipal.getPanelAcciones().getBtnBuscar().setEnabled(true);
			ventanaPrincipal.getPanelAcciones().getBtnModificar().setEnabled(true);
			ventanaPrincipal.getPanelAcciones().getBtnEliminar().setEnabled(true);
		}
		else
		{
			int respuesta = JOptionPane.showConfirmDialog(null, "No se ha ingresado archivo de configuración correctamente" + "\n" + "El sistema no puede realizar sus operaciones" + "\n" + "¿Desea volver a ingresar el archivo de configuración?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);

			if(respuesta == 0)
			{
				parametrizarSistema();
				configurarSistema();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Gracias por utilizar el administrador de directorio LDAP");
				System.exit(0);
			}

		}

		for(int i = 0; i < datos.size(); i++)
		{

			String [] parametroActual = datos.get(i).split(":");

			if(parametroActual[0].equals("Host"))
			{
				host = parametroActual[1];
			}
			else if(parametroActual[0].equals("Usuario"))
			{
				usuario = parametroActual[1];
			}
			else if(parametroActual[0].equals("Password"))
			{
				contraseña = parametroActual[1];
			}
			else if(parametroActual[0].equals("Dominio"))
			{
				dominio = parametroActual[1];
			}
			else if(parametroActual[0].equals("DN"))
			{
				String [] partesDN = parametroActual[1].split("ou=");
				partesDN[1] = partesDN[1].split(",")[0];
				DistinguishedName dnActual = new DistinguishedName(partesDN[1], parametroActual[1]);
				DN.add(dnActual);
			}
		}
	}

	/**
	 * Método para crear un usuario (Registro) en el directorio LDAP
	 * Se encarga de leer los campos de texto de la ventana y con la información alli contenida realiza la creación de un usuario
	 */
	public void crearUsuario()
	{

		//Patrón para realizar la validación del correo electrónico
		Pattern patronCorreo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		//Patrón para realizar la validación del número de celular (Posibilita la inclusión de la extensión del pais
		Pattern patronTelefono = Pattern.compile("(\\+57|0057|357)?[ -]*(3)[ -]*([0-9][ -]*){9}");
		//Patrón para realizar la validación de los nombres y apellidos de la persona
		Pattern patronNombreYApellido = Pattern.compile("^[\\p{L} .'-]+$");

		String uid = ventanaCrear.getTxtUID().getText();
		String nombre = ventanaCrear.getTxtNombre().getText();
		String apellido = ventanaCrear.getTxtApellido().getText();
		String nombreCompleto = nombre + " " + apellido;
		String contraseña = ventanaCrear.getTxtContraseña().getText();
		String correo = ventanaCrear.getTxtCorreoElectronico().getText();
		String telefono = ventanaCrear.getTxtTelefono().getText();
		String ubicacion = ventanaCrear.getTxtSala().getText();
		String actividad = ventanaCrear.getTxtTitulo().getText();
		String roles = ventanaCrear.getTxtRoles().getText();
		String unidadAdministrativa = "" + ventanaCrear.getCmbUnidadAdministrativas().getSelectedItem();

		Matcher validarCorreo = patronCorreo.matcher(correo);
		Matcher validarTelefono = patronTelefono.matcher(telefono);
		Matcher validarNombre = patronNombreYApellido.matcher(nombre);
		Matcher validarApellido = patronNombreYApellido.matcher(apellido);


		if(uid.equals("") || nombre.equals("") || apellido.equals("") || nombreCompleto.equals("") || contraseña.equals("") || correo.equals("") || telefono.equals("") || ubicacion.equals("") || actividad.equals("") || roles.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Complete todos los campos");
		}
		else
		{
			if(validarCorreo.find() == true && validarTelefono.find() && validarNombre.find() && validarApellido.find()) 
			{
				crud.Añadir(uid, nombre, apellido, nombreCompleto, correo, telefono, ubicacion, actividad, roles, contraseña, unidadAdministrativa);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente" + "\n" + "1. En los nombres y apellidos solamente se permite el uso de letras y espacios en blanco" + "\n" + "2. El correo debe poseer un formato adecuado" + "\n" + "3. Solo se permite ingresar números de teléfono celular (Se permite incluir la extensión del pais)");
			}
		}
	}

	/**
	 * Método para buscar un usuario (Registro) en el directorio LDAP mediante el uso del filtro de busqueda
	 * Se encarga de leer el campo de texto del filtro y mediante el realizar la busqueda
	 * Verifica si algun atributo fue seleccionado, en tal caso presenta los atributos que hayan sido seleccionados
	 */
	public void buscarUsuario()
	{

		String filtro = ventanaBuscar.getTxtFiltro().getText();
		ArrayList<String> atributosSeleccionados = filtrarAtributos();
		String[] atributos = new String[atributosSeleccionados.size()];
		atributos = atributosSeleccionados.toArray(atributos);

		if(filtro.equals("") == false && atributos.length != 0)
		{
			crud.Buscar(filtro, atributos);
		}
		else if(filtro.equals("") == false && atributos.length == 0)
		{
			crud.Buscar(filtro, null);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Para utilizar esta opcion debe de por lo menos incluir el filtro de busqueda");
		}
	}

	/**
	 * Método para extraer todos los usuarios (Registros) del servidor
	 * No requiere uso del filtro de busqueda
	 */
	public void buscarTodos()
	{
		crud.Buscar("",null);
	}

	/**
	 * Metodo para validar la selección de los diferentes atributos que se desean obtener en una busqueda
	 * En caso de que un atributo este seleccionado este método lo anexa a un ArrayList
	 * El ArrayList incluira todos aquellos atributos que el usuario de la aplicación desea obtener en la respuesta de su busqueda
	 * @return atributos (ArrayList con los atributos seleccionados)
	 */
	public ArrayList<String> filtrarAtributos()
	{

		ArrayList<String> atributos = new ArrayList<String>();

		if(ventanaBuscar.getChkObjectClass().getState() == true)
		{
			atributos.add("ObjectClass");
		}
		if(ventanaBuscar.getChkUID().getState() == true)
		{
			atributos.add("uid");
		}
		if(ventanaBuscar.getChkNombre().getState() == true)
		{
			atributos.add("givenname");
		}
		if(ventanaBuscar.getChkApellido().getState() == true)
		{
			atributos.add("sn");
		}
		if(ventanaBuscar.getChkNombreCompleto().getState() == true)
		{
			atributos.add("cn");
		}
		if(ventanaBuscar.getChkCorreoElectronico().getState() == true)
		{
			atributos.add("mail");
		}
		if(ventanaBuscar.getChkTelefono().getState() == true)
		{
			atributos.add("telephoneNumber");
		}
		if(ventanaBuscar.getChkUbicacion().getState() == true)
		{
			atributos.add("roomNumber");
		}
		if(ventanaBuscar.getChkRoles().getState() == true)
		{
			atributos.add("description");
		}
		if(ventanaBuscar.getChkActividad().getState() == true)
		{
			atributos.add("title");
		}
		if(ventanaBuscar.getChkContraseña().getState() == true)
		{
			atributos.add("userpassword");
		}

		return atributos;
	}

	/**
	 * Método para modificar un atributo de un usuario (Registro) del directorio LDAP
	 * Se encarga de leer:
	 * 1. El de texto del UID del usuario que se desea modificar
	 * 2. La lista desplegable para seleccionar el atributo a cambiar
	 * 3. El nuevo valor del atirbuto seleccionado
	 * 4. La lista desplegable de las diferentes unidades administrativas
	 * El método exige que se seleccione la unidad administrativa donde se ha de estar el usuario a modificar
	 */
	public void modificarUsuario()
	{

		String uid = ventanaModificar.getTxtUID().getText();
		String atributo = "" + ventanaModificar.getCmbAtributos().getSelectedItem();
		String nuevoValor = ventanaModificar.getTxtNuevoValor().getText();
		String unidadAdministrativa = "" + ventanaModificar.getCmbUnidadAdministrativas().getSelectedItem();

		String atributoElegido = seleccionarAtributo(atributo);

		if(uid.equals("") && nuevoValor.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Complete todos los campos");
		}
		else
		{
			crud.Modificar(uid, atributo, atributoElegido, nuevoValor, unidadAdministrativa);
		}
	}

	/**
	 * Método para validar la seleccion del atributo que se desea modificar
	 * @param pAtributo (Atributo seleccionado de la lista)
	 * @return atributo (Nombre real del atributo con el cual el directorio LDAP trabaja)
	 */
	public String seleccionarAtributo(String pAtributo)
	{

		String atributo = null;

		switch(pAtributo)
		{

		case "Nombre":

			atributo = "givenname";

			break;

		case "Apellido":

			atributo = "sn";

			break;

		case "Correo electronico":

			atributo = "mail";

			break;

		case "Teléfono":

			atributo = "telephonenumber";

			break;

		case "Ubicación":

			atributo = "roomNumber";

			break;

		case "Actividad":

			atributo = "title";

			break;

		case "Roles":

			atributo = "descriptión";

			break;

		case "Contraseña":

			atributo = "userpassword";

			break;

		}

		return atributo;		
	}

	/**
	 * Método para eliminar un usuario (Registro) del directorio LDAP
	 * Se encarga de leer:
	 * 1. El de texto del UID del usuario que se desea modificar
	 * 2. La lista desplegable de las diferentes unidades administrativas
	 * El método exige que se seleccione la unidad administrativa donde se ha de estar el usuario a eliminar
	 */
	public void eliminarUsuario()
	{

		String uid = ventanaEliminar.getTxtUID().getText();
		String unidadAdministrativa = "" + ventanaEliminar.getCmbUnidadAdministrativas().getSelectedItem();

		if(uid.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Complete todos los campos");
		}
		else
		{
			crud.EliminarPorUID(uid, unidadAdministrativa);
		}
	}

	/**
	 * Método ActionPermorfed
	 * Método para ejecutar las diferentes funcionalidades del sistema en función de los eventos que se generen mediante el uso de la GUI
	 * @param evento (Evento generado mediante el uso de la GUI)
	 */
	public void actionPerformed(ActionEvent evento) 
	{

		String comando = evento.getActionCommand();

		if(comando.equals("Crear"))
		{
			try 
			{
				ventanaCrear = new VentanaCrear(this, DN);

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Crear usuario"))
		{
			try 
			{
				crearUsuario();

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Buscar"))
		{
			try 
			{
				JOptionPane.showMessageDialog(null, "Para buscar un usuario existen las siguientes opciones:" + "\n" + "1. Obtener todos los registros (Para esto solamente se debe dar click en \"Buscar todos\")" + "\n" + "2. Hacer consultas y obtener todos los atributos (Para esto solamente debe de incluir un filtro, no seleccionar atributos y dar click en \"Buscar usuario\")" + "\n" + "3. Hacer consulta y obtener atributos especificos (Para esto debe incluir un filtro, seleccionar el o los atributos deseados y \"Buscar usuario\")");
				ventanaBuscar= new VentanaBuscar(this);

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Buscar usuario"))
		{
			try 
			{
				buscarUsuario();

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Buscar todos"))
		{
			try 
			{
				buscarTodos();

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Modificar"))
		{
			try 
			{
				ventanaModificar = new VentanaModificar(this, DN);

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Modificar usuario"))
		{
			try 
			{
				modificarUsuario();

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}	
		if(comando.equals("Eliminar"))
		{
			try 
			{
				ventanaEliminar = new VentanaEliminar(this, DN);

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Eliminar usuario"))
		{
			try 
			{
				eliminarUsuario();

			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}		
	}
}
