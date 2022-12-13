package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;

/**
 * @author David Mauricio Valoyes Porras
 * Clase para poder configurar la GUI principal
 */
public class PanelOperaciones extends JPanel
{
	
	//////////////// Atributos utilizados para los elementos graficos de la GUI
	
	private JLabel labTitulo;
	private JLabel labUniversidad;
	private JLabel labPrograma;
	private JLabel labCurso;
	private JLabel labMauricio;
	
	private JButton btnCrear;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private Controlador controlador;
	
	// Metodo constructor de la GUI
	public PanelOperaciones(Controlador controlador)
	{
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		this.setBackground(new Color(0,210,211));
		Font fontTitulo = new Font("Courier", Font.BOLD, 34);
		
		this.setBackground(new Color(0,210,211));
		Font font = new Font("Courier", Font.BOLD, 15);
		
		labTitulo = new JLabel("Administrador LDAP");
		labTitulo.setFont(fontTitulo);
		
		labUniversidad = new JLabel("Universidad el Bosque");
		labUniversidad.setFont(font);
		labPrograma = new JLabel("Ingeniería de Sistemas");
		labPrograma.setFont(font);
		labCurso = new JLabel("Sistemas operativos");
		labCurso.setFont(font);
		labMauricio = new JLabel("David Mauricio Valoyes Porras");
		labMauricio.setFont(font);
		
		btnCrear = new JButton("Crear");
		btnCrear.setActionCommand("Crear");
		btnCrear.addActionListener(controlador);
		btnCrear.setEnabled(false);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("Buscar");
		btnBuscar.addActionListener(controlador);
		btnBuscar.setEnabled(false);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(controlador);
		btnModificar.setEnabled(false);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(controlador);
		btnEliminar.setEnabled(false);
		
		add(labTitulo);
		add(labUniversidad);
		add(labPrograma);
		add(labCurso);
		add(labMauricio);
		add(btnCrear);
		add(btnBuscar);
		add(btnModificar);
		add(btnEliminar);
		
		layout.putConstraint(SpringLayout.WEST, labTitulo, 300, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labTitulo, 840, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labTitulo, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labTitulo, 80, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labUniversidad, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUniversidad, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUniversidad, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUniversidad, 150, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labPrograma, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labPrograma, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labPrograma, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labPrograma, 180, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labCurso, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labCurso, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labCurso, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labCurso, 210, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labMauricio, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labMauricio, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labMauricio, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labMauricio, 270, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnCrear, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnCrear, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnCrear, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnCrear, 390, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnBuscar, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnBuscar, 460, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnBuscar, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnBuscar, 390, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnModificar, 480, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnModificar, 680, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnModificar, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnModificar, 390, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnEliminar, 700, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnEliminar, 900, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnEliminar, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnEliminar, 390, SpringLayout.NORTH, this);
	}
	
	//////////////// Getters y Setters de la clase "PanelOperaciones"

	public Controlador getControlador() 
	{
		return controlador;
	}

	public void setControlador(Controlador controlador) 
	{
		this.controlador = controlador;
	}

	public JButton getBtnCrear() 
	{
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) 
	{
		this.btnCrear = btnCrear;
	}

	public JButton getBtnBuscar() 
	{
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) 
	{
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnModificar() 
	{
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) 
	{
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() 
	{
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) 
	{
		this.btnEliminar = btnEliminar;
	}
}