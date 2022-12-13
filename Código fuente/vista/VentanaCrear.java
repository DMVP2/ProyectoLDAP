package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;
import modelo.DistinguishedName;

/**
 * @author David Mauricio Valoyes Porras
 * Clase para poder configurar la GUI de la "VentanaCrear"
 */
public class VentanaCrear extends JFrame
{

	//////////////// Atributos utilizados para los elementos graficos de la GUI	
	
	private JComboBox cmbUnidadAdministrativas;

	private JTextField txtUID;
	private JTextField txtContraseña;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreoElectronico;
	private JTextField txtTelefono;
	private JTextField txtSala;
	private JTextField txtTitulo;
	private JTextField txtRoles;

	private JLabel labCrear;
	private JLabel labUID;
	private JLabel labContraseña;
	private JLabel labNombre;
	private JLabel labApellido;
	private JLabel labCorreoElectronico;
	private JLabel labTelefono;
	private JLabel labSala;
	private JLabel labTitulo;
	private JLabel labRoles;
	private JLabel labUnidadesAdministrativas;

	private JButton btnCrear;

	// Metodo constructor de la GUI
	public VentanaCrear(Controlador controlador, ArrayList <DistinguishedName> pUnidadesAdministrativas)
	{
		Font font = new Font("Courier", Font.BOLD, 14);

		Font fontTitulo = new Font("Courier", Font.BOLD, 34);

		setTitle("Crear usuario");
		setSize(600,750);
		setResizable(false);
		setLocationRelativeTo(null);

		this.getContentPane().setBackground(new Color(0,210,211));

		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		btnCrear = new JButton("Crear");
		btnCrear.setActionCommand("Crear usuario");
		btnCrear.addActionListener(controlador);
		btnCrear.setEnabled(true);

		cmbUnidadAdministrativas = new JComboBox<String>();
		for (int i = 0; i < pUnidadesAdministrativas.size(); i++) 
		{
			cmbUnidadAdministrativas.addItem(pUnidadesAdministrativas.get(i).getNombreDeRuta().toUpperCase());	
		}

		txtUID = new JTextField();
		txtContraseña = new JTextField();
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtCorreoElectronico = new JTextField();
		txtTelefono = new JTextField();
		txtSala = new JTextField();
		txtTitulo = new JTextField();
		txtRoles = new JTextField();

		labCrear = new JLabel("Crear usuario");
		labCrear.setFont(fontTitulo);

		labUID = new JLabel("UID:");
		labUID.setFont(font);

		labContraseña = new JLabel("Contraseña:");
		labContraseña.setFont(font);

		labNombre = new JLabel("Nombres:");
		labNombre.setFont(font);

		labApellido = new JLabel("Apellidos:");
		labApellido.setFont(font);

		labCorreoElectronico = new JLabel("Correo:");
		labCorreoElectronico.setFont(font);

		labTelefono = new JLabel("Teléfono:");
		labTelefono.setFont(font);

		labSala = new JLabel("Ubicación:");
		labSala.setFont(font);

		labTitulo = new JLabel("Actividad:");
		labTitulo.setFont(font);

		labRoles = new JLabel("Roles:");
		labRoles.setFont(font);

		labUnidadesAdministrativas = new JLabel("Unidades administrativas:");
		labUnidadesAdministrativas.setFont(font);

		add(txtUID);			
		add(txtContraseña);
		add(txtNombre);
		add(txtApellido);
		add(txtCorreoElectronico);
		add(txtTelefono);
		add(txtSala);
		add(txtTitulo);
		add(txtRoles);
		add(btnCrear);

		add(labCrear);	
		add(labUID);			
		add(labContraseña);
		add(labNombre);
		add(labApellido);
		add(labCorreoElectronico);
		add(labTelefono);
		add(labSala);
		add(labTitulo);
		add(labRoles);
		add(labUnidadesAdministrativas);

		add(cmbUnidadAdministrativas);

		add(btnCrear);

		layout.putConstraint(SpringLayout.WEST, labCrear, 170, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labCrear, 450, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labCrear, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labCrear, 60, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUID, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUID, 120, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUID, 90, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUID, 130, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtUID, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtUID, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtUID, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtUID, 120, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labNombre, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labNombre, 270, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labNombre, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labNombre, 190, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtNombre, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtNombre, 260, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtNombre, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtNombre, 180, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labApellido, 290, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labApellido, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labApellido, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labApellido, 190, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtApellido, 390, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtApellido, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtApellido, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtApellido, 180, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labContraseña, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labContraseña, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labContraseña, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labContraseña, 250, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtContraseña, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtContraseña, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtContraseña, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtContraseña, 240, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labCorreoElectronico, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labCorreoElectronico, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labCorreoElectronico, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labCorreoElectronico, 310, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtCorreoElectronico, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtCorreoElectronico, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtCorreoElectronico, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtCorreoElectronico, 300, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labTelefono, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labTelefono, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labTelefono, 330, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labTelefono, 370, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtTelefono, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtTelefono, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtTelefono, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtTelefono, 360, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labSala, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labSala, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labSala, 390, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labSala, 430, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtSala, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtSala, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtSala, 400, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtSala, 420, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labTitulo, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labTitulo, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labTitulo, 450, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labTitulo, 490, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtTitulo, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtTitulo, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtTitulo, 460, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtTitulo, 480, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labRoles, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labRoles, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labRoles, 510, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labRoles, 550, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtRoles, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtRoles, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtRoles, 520, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtRoles, 540, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUnidadesAdministrativas, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUnidadesAdministrativas, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUnidadesAdministrativas, 570, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUnidadesAdministrativas, 610, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, cmbUnidadAdministrativas, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, cmbUnidadAdministrativas, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cmbUnidadAdministrativas, 580, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cmbUnidadAdministrativas, 600, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, btnCrear, 240, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnCrear, 360, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnCrear, 640, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnCrear, 680, SpringLayout.NORTH, this);

		setVisible(true);
	}
	
	//////////////// Getters y Setters de la clase "VentanaCrear"

	public JComboBox getCmbUnidadAdministrativas() {
		return cmbUnidadAdministrativas;
	}

	public void setCmbUnidadAdministrativas(JComboBox cmbUnidadAdministrativas) {
		this.cmbUnidadAdministrativas = cmbUnidadAdministrativas;
	}

	public JTextField getTxtUID() {
		return txtUID;
	}

	public void setTxtUID(JTextField txtUID) {
		this.txtUID = txtUID;
	}

	public JTextField getTxtContraseña() {
		return txtContraseña;
	}

	public void setTxtContraseña(JTextField txtContraseña) {
		this.txtContraseña = txtContraseña;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtSala() {
		return txtSala;
	}

	public void setTxtSala(JTextField txtSala) {
		this.txtSala = txtSala;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtRoles() {
		return txtRoles;
	}

	public void setTxtRoles(JTextField txtRoles) {
		this.txtRoles = txtRoles;
	}

	public JLabel getLabCrear() {
		return labCrear;
	}

	public void setLabCrear(JLabel labCrear) {
		this.labCrear = labCrear;
	}

	public JLabel getLabUID() {
		return labUID;
	}

	public void setLabUID(JLabel labUID) {
		this.labUID = labUID;
	}

	public JLabel getLabContraseña() {
		return labContraseña;
	}

	public void setLabContraseña(JLabel labContraseña) {
		this.labContraseña = labContraseña;
	}

	public JLabel getLabNombre() {
		return labNombre;
	}

	public void setLabNombre(JLabel labNombre) {
		this.labNombre = labNombre;
	}

	public JLabel getLabApellido() {
		return labApellido;
	}

	public void setLabApellido(JLabel labApellido) {
		this.labApellido = labApellido;
	}

	public JLabel getLabCorreoElectronico() {
		return labCorreoElectronico;
	}

	public void setLabCorreoElectronico(JLabel labCorreoElectronico) {
		this.labCorreoElectronico = labCorreoElectronico;
	}

	public JLabel getLabTelefono() {
		return labTelefono;
	}

	public void setLabTelefono(JLabel labTelefono) {
		this.labTelefono = labTelefono;
	}

	public JLabel getLabSala() {
		return labSala;
	}

	public void setLabSala(JLabel labSala) {
		this.labSala = labSala;
	}

	public JLabel getLabTitulo() {
		return labTitulo;
	}

	public void setLabTitulo(JLabel labTitulo) {
		this.labTitulo = labTitulo;
	}

	public JLabel getLabRoles() {
		return labRoles;
	}

	public void setLabRoles(JLabel labRoles) {
		this.labRoles = labRoles;
	}

	public JLabel getLabUnidadesAdministrativas() {
		return labUnidadesAdministrativas;
	}

	public void setLabUnidadesAdministrativas(JLabel labUnidadesAdministrativas) {
		this.labUnidadesAdministrativas = labUnidadesAdministrativas;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

}