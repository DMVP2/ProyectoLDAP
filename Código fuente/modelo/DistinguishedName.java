package modelo;

/**
 * @author David Mauricio Valoyes Porras
 * Clase para poder "Individualizar" los DN (Distinguished name) del directorio LDAP
 * Mediante esta clase se se evita que se tenga que utilizar "Hard Code" o que el usuairo del programa tenga que ingresar el DN completo al momento de agregar un usuario (Registro)
 */

public class DistinguishedName 
{

	//////////////// Atributos utilizados en la clase "DistinguishedName"
	
	private String nombreDeRuta;
	private String ruta;

	/**
	 * Método constructor de la clase "DistinguishedName"
	 * @param pNombreDeRuta (Nombre del DN creado. Este es el que se utiliza en la interfaz grafica para asi evitar mostrar todo el DN)
	 * @param pRuta (DN completo)
	 */
	public DistinguishedName(String pNombreDeRuta, String pRuta)
	{
		nombreDeRuta = pNombreDeRuta;
		ruta = pRuta;
	}

	//////////////// Getters y Setters de la clase "DistinguishedName"
	
	public String getNombreDeRuta() 
	{
		return nombreDeRuta;
	}

	public void setNombreDeRuta(String nombreDeRuta) 
	{
		this.nombreDeRuta = nombreDeRuta;
	}

	public String getRuta() 
	{
		return ruta;
	}

	public void setRuta(String ruta) 
	{
		this.ruta = ruta;
	}
}
