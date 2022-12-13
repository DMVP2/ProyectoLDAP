package modelo;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * @author Christian
 * Autor del código original (Base) que se utilizo para realizar la solución
 * Código extraido de "https://cafelojano.wordpress.com/2009/05/26/trabajando-con-un-servidor-ldap-con-java/"
 * Esta clase sufrió de modificaciones
 */

public class Conexion {

	//////////////// Atributos utilizados para la conexión al servidor LDAP
	
	private int ldapPort;
	private int ldapVersion;
	private LDAPConnection lc;
	private String host;
	private String usuario;
	private String contraseña;
	private String dominio;

	/**
	 * Método constructor de la clase "Conexion"
	 * @param pHost (Dirección IP de la maquina que tiene instalada el servidor LDAP)
	 * @param pUsuario (Nombre del usuario administrador del servidor LDAP)
	 * @param pContraseña (Contraseña del usuario administrador del servidor LDAP)
	 * @param pDominio (Dominio del servidor LDAP)
	 */
	public Conexion(String pHost, String pUsuario, String pContraseña, String pDominio) 
	{
		host = pHost;
		usuario = pUsuario;
		contraseña = pContraseña;

		String[] arregloDominio = pDominio.split("\\.");
		dominio = "dc=" + arregloDominio[0] + ",dc=" + arregloDominio[1];
	}

	/**
	 * Método para realizar la conexión al servidor LDAP
	 * @return lc (Conexión al servidor LDAP)
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
			lc.bind(ldapVersion, usuarioConexion, contraseña.getBytes("UTF8"));
			System.out.println("Autenticado en el servidor LDAP");
			JOptionPane.showMessageDialog(null, "Conexión correcta" + "\n" + "LOGIN: " + usuarioConexion + "\n" + "PUERTO: " + ldapPort + "\n" + "VERSIÓN: " + ldapVersion + "\n" + "HOST: " + host);
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
	 * Método para realizar la conexión al servidor LDAP
	 * @return lc (Conexión al servidor LDAP)
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
			lc.bind(ldapVersion, usuarioConexion, contraseña.getBytes("UTF8"));
			JOptionPane.showMessageDialog(null, "Conexión correcta" + "\n" + "LOGIN: " + usuarioConexion + "\n" + "PUERTO: " + ldapPort + "\n" + "VERSIÓN: " + ldapVersion + "\n" + "HOST: " + host);
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
	 * Método para cortar la conexión al servidor LDAP
	 * @param lc (Conexión al servidor LDAP)
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