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
 * Clase para poder configurar la GUI de la "VentanaEliminar"
 */
public class VentanaEliminar extends JFrame
{

	//////////////// Atributos utilizados para los elementos graficos de la GUI	

	private JComboBox cmbUnidadAdministrativas;

	private JTextField txtUID;

	private JLabel labEliminar;
	private JLabel labUID;
	private JLabel labUnidadesAdministrativas;

	private JButton btnEliminar;

	// Metodo constructor de la GUI
	public VentanaEliminar(Controlador controlador, ArrayList <DistinguishedName> pUnidadesAdministrativas)
	{
		Font font = new Font("Courier", Font.BOLD, 14);

		Font fontTitulo = new Font("Courier", Font.BOLD, 34);

		setTitle("Eliminar usuario");
		setSize(600,330);
		setResizable(false);
		setLocationRelativeTo(null);

		this.getContentPane().setBackground(new Color(0,210,211));

		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand("Eliminar usuario");
		btnEliminar.addActionListener(controlador);
		btnEliminar.setEnabled(true);

		cmbUnidadAdministrativas = new JComboBox<String>();
		for (int i = 0; i < pUnidadesAdministrativas.size(); i++) 
		{
			cmbUnidadAdministrativas.addItem(pUnidadesAdministrativas.get(i).getNombreDeRuta().toUpperCase());	
		}

		txtUID = new JTextField();

		labEliminar = new JLabel("Eliminar usuario");
		labEliminar.setFont(fontTitulo);

		labUID = new JLabel("UID:");
		labUID.setFont(font);

		labUnidadesAdministrativas = new JLabel("Unidades administrativas:");
		labUnidadesAdministrativas.setFont(font);

		add(txtUID);			

		add(btnEliminar);

		add(labEliminar);	
		add(labUID);			
		add(labUnidadesAdministrativas);

		add(cmbUnidadAdministrativas);

		add(btnEliminar);

		layout.putConstraint(SpringLayout.WEST, labEliminar, 150, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labEliminar, 470, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labEliminar, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labEliminar, 60, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUID, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUID, 120, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUID, 90, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUID, 130, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtUID, 110, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtUID, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtUID, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtUID, 120, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, labUnidadesAdministrativas, 20, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUnidadesAdministrativas, 240, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUnidadesAdministrativas, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUnidadesAdministrativas, 190, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, cmbUnidadAdministrativas, 260, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, cmbUnidadAdministrativas, 540, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cmbUnidadAdministrativas, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cmbUnidadAdministrativas, 180, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, btnEliminar, 240, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnEliminar, 360, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnEliminar, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnEliminar, 260, SpringLayout.NORTH, this);

		setVisible(true);
	}
	
	//////////////// Getters y Setters de la clase "VentanaEliminar"

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

	public JLabel getLabCrear() {
		return labEliminar;
	}

	public void setLabCrear(JLabel labCrear) {
		this.labEliminar = labCrear;
	}

	public JLabel getLabUID() {
		return labUID;
	}

	public void setLabUID(JLabel labUID) {
		this.labUID = labUID;
	}

	public JLabel getLabUnidadesAdministrativas() {
		return labUnidadesAdministrativas;
	}

	public void setLabUnidadesAdministrativas(JLabel labUnidadesAdministrativas) {
		this.labUnidadesAdministrativas = labUnidadesAdministrativas;
	}

	public JButton getBtnCrear() {
		return btnEliminar;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnEliminar = btnCrear;
	}

}