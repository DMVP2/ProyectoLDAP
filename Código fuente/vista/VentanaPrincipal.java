package vista;

import java.awt.GridLayout;

import javax.swing.JFrame;

import controlador.Controlador;

/**
 * @author David Mauricio Valoyes Porras
 * Clase que funciona de soporte para la GUI
 */
public class VentanaPrincipal extends JFrame
{

	//////////////// Elementos graficos principales de la GUI
	
	private PanelOperaciones panelOperaciones;

	private Controlador controlador;

	/**
	 * Método contructor de la clase principal de la GUI
	 * @param controlador (Controlador del programa. Quien reconoce los eventos generados en la GUI)
	 */
	public VentanaPrincipal(Controlador controlador)
	{
		setTitle("Administrador LDAP");
		setSize(950, 470);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridLayout(1,1));

		panelOperaciones = new PanelOperaciones(controlador);
		
		add(panelOperaciones);

		setVisible(true);
	}

	//////////////// Getters y Setters de la clase "VentanaPrincipal"
	
	public PanelOperaciones getPanelAcciones() 
	{
		return panelOperaciones;
	}

	public void setPanelAcciones(PanelOperaciones panelAcciones) 
	{
		this.panelOperaciones = panelAcciones;
	}
}
