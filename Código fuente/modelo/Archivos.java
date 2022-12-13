package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivos 
{

	//////////////// Atributos utilizados para la lectura del archivo	
	
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	/**
	 * Método para realizar la lectura de archivo de texto
	 * @param pArchivo (Archivo a leer)
	 * @return datos (ArrayList con los datos (Renglones) del archivo leido)
	 */
	public ArrayList leerArchivo(File pArchivo)
	{

		ArrayList <String> datos = new ArrayList<String>();
		try 
		{
			archivo = pArchivo;
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
			while((linea=br.readLine())!=null)
				datos.add(linea);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{                    
				if( null != fr )
				{   
					fr.close();     
				}                  
			}
			catch (Exception e2)
			{ 
				e2.printStackTrace();
			}
		}

		return datos;
	}
}

