package vista;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;
import modelo.DistinguishedName;

/**
 * @author David Mauricio Valoyes Porras
 * Clase para poder configurar la GUI de la "VentanaBusqueda"
 */
public class VentanaBuscar extends JFrame
{

	//////////////// Atributos utilizados para los elementos graficos de la GUI
	
	private Checkbox chkObjectClass;
	private Checkbox chkUID;
	private Checkbox chkContraseña;
	private Checkbox chkNombre;
	private Checkbox chkApellido;
	private Checkbox chkNombreCompleto;
	private Checkbox chkTelefono;
	private Checkbox chkCorreoElectronico;
	private Checkbox chkUbicacion;
	private Checkbox chkActividad;
	private Checkbox chkRoles;

	private CheckboxGroup chkgrpGrupo;

	private JTextField txtFiltro;

	private JLabel labModificar;
	private JLabel labFiltro;
	private JLabel labAtributos;

	private JButton btnBuscarFiltro;
	private JButton btnBuscarTodos;

	// Metodo constructor de la GUI
	public VentanaBuscar(Controlador controlador)
	{
		Font font = new Font("Courier", Font.BOLD, 14);

		Font fontTitulo = new Font("Courier", Font.BOLD, 34);

		setTitle("Buscar usuario");
		setSize(590,520);
		setResizable(false);
		setLocationRelativeTo(null);

		this.getContentPane().setBackground(new Color(0,210,211));

		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		btnBuscarFiltro = new JButton("Buscar filtrado");
		btnBuscarFiltro.setActionCommand("Buscar usuario");
		btnBuscarFiltro.addActionListener(controlador);
		btnBuscarFiltro.setEnabled(true);
		
		btnBuscarTodos = new JButton("Buscar todos");
		btnBuscarTodos.setActionCommand("Buscar todos");
		btnBuscarTodos.addActionListener(controlador);
		btnBuscarTodos.setEnabled(true);

		chkObjectClass = new Checkbox("Object class", false);
		chkUID = new Checkbox("UID", chkgrpGrupo, false);
		chkNombre = new Checkbox("Nombre", false);
		chkApellido = new Checkbox("Apellido", false);
		chkNombreCompleto = new Checkbox("NombreCompleto", false);
		chkTelefono = new Checkbox("Teléfono", false);
		chkCorreoElectronico = new Checkbox("Correo electrónico", false);
		chkUbicacion = new Checkbox("Ubicación", false);
		chkActividad = new Checkbox("Actividad", false);
		chkRoles = new Checkbox("Roles", false);
		chkContraseña = new Checkbox("Contraseña", false);

		txtFiltro = new JTextField();

		labModificar = new JLabel("Buscar usuario");
		labModificar.setFont(fontTitulo);

		labFiltro = new JLabel("Filtro de busqueda:");
		labFiltro.setFont(font);

		labAtributos = new JLabel("Atributos a obtener:");
		labAtributos.setFont(font);

		add(txtFiltro);		

		add(chkObjectClass);
		add(chkUID);
		add(chkNombre);
		add(chkApellido);
		add(chkNombreCompleto);
		add(chkTelefono);
		add(chkCorreoElectronico);
		add(chkUbicacion);
		add(chkActividad);
		add(chkRoles);
		add(chkContraseña);

		add(labModificar);	
		add(labFiltro);			
		add(labAtributos);

		add(btnBuscarFiltro);
		add(btnBuscarTodos);

		layout.putConstraint(SpringLayout.WEST, labModificar, 160, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labModificar, 480, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labModificar, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labModificar, 60, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labFiltro, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labFiltro, 180, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labFiltro, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labFiltro, 140, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtFiltro, 180, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtFiltro, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtFiltro, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtFiltro, 130, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labAtributos, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labAtributos, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labAtributos, 140, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labAtributos, 180, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkObjectClass, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkObjectClass, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkObjectClass, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkObjectClass, 170, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkUID, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkUID, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkUID, 170, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkUID, 190, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkNombre, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkNombre, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkNombre, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkNombre, 210, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkApellido, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkApellido, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkApellido, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkApellido, 230, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkNombreCompleto, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkNombreCompleto, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkNombreCompleto, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkNombreCompleto, 250, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkTelefono, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkTelefono, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkTelefono, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkTelefono, 270, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkCorreoElectronico, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkCorreoElectronico, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkCorreoElectronico, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkCorreoElectronico, 290, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkUbicacion, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkUbicacion, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkUbicacion, 290, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkUbicacion, 310, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkRoles, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkRoles, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkRoles, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkRoles, 330, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, chkActividad, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkActividad, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkActividad, 330, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkActividad, 350, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, chkContraseña, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, chkContraseña, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chkContraseña, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chkContraseña, 370, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, btnBuscarFiltro, 150, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnBuscarFiltro, 270, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnBuscarFiltro, 400, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnBuscarFiltro, 440, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnBuscarTodos, 330, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnBuscarTodos, 450, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnBuscarTodos, 400, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnBuscarTodos, 440, SpringLayout.NORTH, this);

		setVisible(true);

	}
	
	//////////////// Getters y Setters de la clase "VentanaBuscar"

	public Checkbox getChkObjectClass() {
		return chkObjectClass;
	}

	public void setChkObjectClass(Checkbox chkObjectClass) {
		this.chkObjectClass = chkObjectClass;
	}

	public Checkbox getChkUID() {
		return chkUID;
	}

	public void setChkUID(Checkbox chkUID) {
		this.chkUID = chkUID;
	}

	public Checkbox getChkContraseña() {
		return chkContraseña;
	}

	public void setChkContraseña(Checkbox chkContraseña) {
		this.chkContraseña = chkContraseña;
	}

	public Checkbox getChkNombre() {
		return chkNombre;
	}

	public void setChkNombre(Checkbox chkNombre) {
		this.chkNombre = chkNombre;
	}

	public Checkbox getChkApellido() {
		return chkApellido;
	}

	public void setChkApellido(Checkbox chkApellido) {
		this.chkApellido = chkApellido;
	}

	public Checkbox getChkNombreCompleto() {
		return chkNombreCompleto;
	}

	public void setChkNombreCompleto(Checkbox chkNombreCompleto) {
		this.chkNombreCompleto = chkNombreCompleto;
	}

	public Checkbox getChkTelefono() {
		return chkTelefono;
	}

	public void setChkTelefono(Checkbox chkTelefono) {
		this.chkTelefono = chkTelefono;
	}

	public Checkbox getChkCorreoElectronico() {
		return chkCorreoElectronico;
	}

	public void setChkCorreoElectronico(Checkbox chkCorreoElectronico) {
		this.chkCorreoElectronico = chkCorreoElectronico;
	}

	public Checkbox getChkUbicacion() {
		return chkUbicacion;
	}

	public void setChkUbicacion(Checkbox chkUbicacion) {
		this.chkUbicacion = chkUbicacion;
	}

	public Checkbox getChkRoles() {
		return chkRoles;
	}

	public void setChkRoles(Checkbox chkRoles) {
		this.chkRoles = chkRoles;
	}

	public CheckboxGroup getChkgrpGrupo() {
		return chkgrpGrupo;
	}

	public void setChkgrpGrupo(CheckboxGroup chkgrpGrupo) {
		this.chkgrpGrupo = chkgrpGrupo;
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public void setTxtFiltro(JTextField txtFiltro) {
		this.txtFiltro = txtFiltro;
	}

	public JLabel getLabModificar() {
		return labModificar;
	}

	public void setLabModificar(JLabel labModificar) {
		this.labModificar = labModificar;
	}

	public JLabel getLabFiltro() {
		return labFiltro;
	}

	public void setLabFiltro(JLabel labFiltro) {
		this.labFiltro = labFiltro;
	}

	public JLabel getLabAtributos() {
		return labAtributos;
	}

	public void setLabAtributos(JLabel labAtributos) {
		this.labAtributos = labAtributos;
	}

	public JButton getBtnBuscar() {
		return btnBuscarFiltro;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscarFiltro = btnBuscar;
	}

	public Checkbox getChkActividad() {
		return chkActividad;
	}

	public void setChkActividad(Checkbox chkActividad) {
		this.chkActividad = chkActividad;
	}
}