package modelo;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * @author Christian
 * Autor del c�digo original (Base) que se utilizo para realizar la soluci�n
 * C�digo extraido de "https://cafelojano.wordpress.com/2009/05/26/trabajando-con-un-servidor-ldap-con-java/"
 * Esta clase sufri� de modificaciones
 */

public class Conexion {

	//////////////// Atributos utilizados para la conexi�n al servidor LDAP
	
	private int ldapPort;
	private int ldapVersion;
	private LDAPConnection lc;
	private String host;
	private String usuario;
	private String contrase�a;
	private String dominio;

	/**
	 * M�todo constructor de la clase "Conexion"
	 * @param pHost (Direcci�n IP de la maquina que tiene instalada el servidor LDAP)
	 * @param pUsuario (Nombre del usuario administrador del servidor LDAP)
	 * @param pContrase�a (Contrase�a del usuario administrador del servidor LDAP)
	 * @param pDominio (Dominio del servidor LDAP)
	 */
	public Conexion(String pHost, String pUsuario, String pContrase�a, String pDominio) 
	{
		host = pHost;
		usuario = pUsuario;
		contrase�a = pContrase�a;

		String[] arregloDominio = pDominio.split("\\.");
		dominio = "dc=" + arregloDominio[0] + ",dc=" + arregloDominio[1];
	}

	/**
	 * M�todo para realizar la conexi�n al servidor LDAP
	 * @return lc (Conexi�n al servidor LDAP)
	 */
	public LDAPConnection ConexionManager() 
	{
		String usuarioConexion = "cn=" + usuario + "," + dominio;
		ldapPort = LDAPConnection.DEFAULT_PORT;
		ldapVersion = LDAPConnection.LDAP_V3;
		try 
		{
			lc = new LDAPConnection();
			lc.connect(host, ldapPort);
			System.out.println("Conectado al Servidor LDAP");
			lc.bind(ldapVersion, usuarioConexion, contrase�a.getBytes("UTF8"));
			System.out.println("Autenticado en el servidor LDAP");
			JOptionPane.showMessageDialog(null, "Conexi�n correcta" + "\n" + "LOGIN: " + usuarioConexion + "\n" + "PUERTO: " + ldapPort + "\n" + "VERSI�N: " + ldapVersion + "\n" + "HOST: " + host);
		} 
		catch (UnsupportedEncodingException ex) 
		{
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
		} 
		catch (LDAPException ex) 
		{
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
		}
		return lc;
	}

	/**
	 * M�todo para realizar la conexi�n al servidor LDAP
	 * @return lc (Conexi�n al servidor LDAP)
	 */
	public LDAPConnection ConexionUser() 
	{
		String usuarioConexion = "cn=" + usuario + "," + dominio;
		ldapPort = LDAPConnection.DEFAULT_PORT;
		ldapVersion = LDAPConnection.LDAP_V3;
		try 
		{
			lc = new LDAPConnection();
			lc.connect(host, ldapPort);
			System.out.println("Conectado al servidor LDAP");
			lc.bind(ldapVersion, usuarioConexion, contrase�a.getBytes("UTF8"));
			JOptionPane.showMessageDialog(null, "Conexi�n correcta" + "\n" + "LOGIN: " + usuarioConexion + "\n" + "PUERTO: " + ldapPort + "\n" + "VERSI�N: " + ldapVersion + "\n" + "HOST: " + host);
		} 
		catch (UnsupportedEncodingException ex) 
		{
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
		} 
		catch (LDAPException ex) 
		{
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
		}
		return lc;
	}

	/**
	 * M�todo para cortar la conexi�n al servidor LDAP
	 * @param lc (Conexi�n al servidor LDAP)
	 */
	public void CerrarConLDAP(LDAPConnection lc) 
	{
		try 
		{
			lc.disconnect();
			System.out.println("Conexion cerrada correctamente");
		} 
		catch (LDAPException ex) 
		{
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
		}

	}

	//////////////// Getters y Setters de la clase "Conexion"
	
	public String getDominio() 
	{
		return dominio;
	}

	public void setDominio(String dominio) 
	{
		this.dominio = dominio;
	}

}