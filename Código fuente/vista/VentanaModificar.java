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
 * Clase para poder configurar la GUI de la "VentanaModificar"
 */
public class VentanaModificar extends JFrame
{

	//////////////// Atributos utilizados para los elementos graficos de la GUI		

	private JComboBox cmbUnidadAdministrativas;
	private JComboBox cmbAtributos;

	private JTextField txtUID;
	private JTextField txtNuevoValor;

	private JLabel labModificar;
	private JLabel labUID;
	private JLabel labAtributos;
	private JLabel labNuevoValor;
	private JLabel labUnidadesAdministrativas;

	private JButton btnEliminar;

	// Metodo constructor de la GUI
	public VentanaModificar(Controlador controlador, ArrayList <DistinguishedName> pUnidadesAdministrativas)
	{
		Font font = new Font("Courier", Font.BOLD, 14);

		Font fontTitulo = new Font("Courier", Font.BOLD, 34);

		setTitle("Modificar usuario");
		setSize(600,450);
		setResizable(false);
		setLocationRelativeTo(null);

		this.getContentPane().setBackground(new Color(0,210,211));

		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		btnEliminar = new JButton("Modificar");
		btnEliminar.setActionCommand("Modificar usuario");
		btnEliminar.addActionListener(controlador);
		btnEliminar.setEnabled(true);

		cmbAtributos = new JComboBox<String>();
		cmbAtributos.addItem("Nombre");
		cmbAtributos.addItem("Apellido");
		cmbAtributos.addItem("Correo electronico");
		cmbAtributos.addItem("Teléfono");
		cmbAtributos.addItem("Ubicación");
		cmbAtributos.addItem("Actividad");
		cmbAtributos.addItem("Roles");
		cmbAtributos.addItem("Contraseña");

		cmbUnidadAdministrativas = new JComboBox<String>();
		for (int i = 0; i < pUnidadesAdministrativas.size(); i++) 
		{
			cmbUnidadAdministrativas.addItem(pUnidadesAdministrativas.get(i).getNombreDeRuta().toUpperCase());	
		}

		txtUID = new JTextField();
		txtNuevoValor = new JTextField();

		labModificar = new JLabel("Modificar usuario");
		labModificar.setFont(fontTitulo);

		labUID = new JLabel("UID:");
		labUID.setFont(font);

		labNuevoValor = new JLabel("Nuevo valor:");
		labNuevoValor.setFont(font);

		labAtributos = new JLabel("Atributos:");
		labAtributos.setFont(font);

		labUnidadesAdministrativas = new JLabel("Unidades administrativas:");
		labUnidadesAdministrativas.setFont(font);

		add(txtUID);			
		add(txtNuevoValor);

		add(labModificar);	
		add(labUID);			
		add(labAtributos);
		add(labNuevoValor);
		add(labUnidadesAdministrativas);

		add(cmbAtributos);
		add(cmbUnidadAdministrativas);

		add(btnEliminar);

		layout.putConstraint(SpringLayout.WEST, labModificar, 140, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labModificar, 480, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labModificar, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labModificar, 60, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUID, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUID, 120, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUID, 90, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUID, 130, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtUID, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtUID, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtUID, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtUID, 120, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labAtributos, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labAtributos, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labAtributos, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labAtributos, 190, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, cmbAtributos, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, cmbAtributos, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cmbAtributos, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cmbAtributos, 180, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labNuevoValor, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labNuevoValor, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labNuevoValor, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labNuevoValor, 250, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtNuevoValor, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtNuevoValor, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtNuevoValor, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtNuevoValor, 240, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUnidadesAdministrativas, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUnidadesAdministrativas, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUnidadesAdministrativas, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUnidadesAdministrativas, 310, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, cmbUnidadAdministrativas, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, cmbUnidadAdministrativas, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cmbUnidadAdministrativas, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cmbUnidadAdministrativas, 300, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, btnEliminar, 240, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnEliminar, 360, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnEliminar, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnEliminar, 380, SpringLayout.NORTH, this);

		setVisible(true);
	}

	//////////////// Getters y Setters de la clase "VentanaModificar"

	public JComboBox getCmbUnidadAdministrativas() {
		return cmbUnidadAdministrativas;
	}

	public void setCmbUnidadAdministrativas(JComboBox cmbUnidadAdministrativas) {
		this.cmbUnidadAdministrativas = cmbUnidadAdministrativas;
	}

	public JComboBox getCmbAtributos() {
		return cmbAtributos;
	}

	public void setCmbAtributos(JComboBox cmbAtributos) {
		this.cmbAtributos = cmbAtributos;
	}

	public JTextField getTxtUID() {
		return txtUID;
	}

	public void setTxtUID(JTextField txtUID) {
		this.txtUID = txtUID;
	}

	public JTextField getTxtNuevoValor() {
		return txtNuevoValor;
	}

	public void setTxtNuevoValor(JTextField txtNuevoValor) {
		this.txtNuevoValor = txtNuevoValor;
	}

	public JLabel getLabModificar() {
		return labModificar;
	}

	public void setLabModificar(JLabel labModificar) {
		this.labModificar = labModificar;
	}

	public JLabel getLabUID() {
		return labUID;
	}

	public void setLabUID(JLabel labUID) {
		this.labUID = labUID;
	}

	public JLabel getLabAtributos() {
		return labAtributos;
	}

	public void setLabAtributos(JLabel labAtributos) {
		this.labAtributos = labAtributos;
	}

	public JLabel getLabNuevoValor() {
		return labNuevoValor;
	}

	public void setLabNuevoValor(JLabel labNuevoValor) {
		this.labNuevoValor = labNuevoValor;
	}

	public JLabel getLabUnidadesAdministrativas() {
		return labUnidadesAdministrativas;
	}

	public void setLabUnidadesAdministrativas(JLabel labUnidadesAdministrativas) {
		this.labUnidadesAdministrativas = labUnidadesAdministrativas;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
}