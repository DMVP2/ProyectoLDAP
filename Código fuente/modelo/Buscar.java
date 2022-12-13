package modelo;

import com.novell.ldap.*;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Christian
 * Autor del código original (Base) que se utilizo para realizar la solución
 * Código extraido de "https://cafelojano.wordpress.com/2009/05/26/trabajando-con-un-servidor-ldap-con-java/"
 * Esta clase sufrió de modificaciones
 */

public class Buscar 
{

	//////////////// Atributos utilizados para la busqueda en el directorio LDAP
	
	private String searchBase = null;
	private int searchScope = LDAPConnection.SCOPE_SUB;
	private String filtro;
	private LDAPSearchResults searchResults;

	/**
	 * Método para ejecutar la busqueda del servidor LDAP
	 * @param lc (Conexión al servidor LDAP)
	 * @param pFiltro (Filtro de busqueda)
	 * @param pAtributos (Atributos a retornar en el resultado de la busqueda)
	 */
	public Buscar(LDAPConnection lc, String pFiltro, String [] pAtributos)
	{
		filtro = pFiltro;
		try {
			searchResults = lc.search(searchBase, searchScope, filtro, pAtributos, false);
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
					if (allValues != null) {
						while (allValues.hasMoreElements()) {
							String value = (String) allValues.nextElement();
							System.out.println(attributeName + ":  " + value);
						}
					}
				}
				System.out.println("------------------------------");
				lc.disconnect();
			}
		} 
		catch (LDAPException ex) 
		{
			Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE,null, ex);
		}
	}

	public String getSearchBase() 
	{
		return searchBase;
	}

	public void setSearchBase(String searchBase) 
	{
		this.searchBase = searchBase;
	}
}
