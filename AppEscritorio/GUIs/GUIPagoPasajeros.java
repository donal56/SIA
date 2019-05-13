package GUIs;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIPagoPasajeros extends JDialog {
	private ArrayList<String[]> datosPasajeros;
	private int numPasajeros;
	private JTextField txtFld_ID;
	private JTextField txtFld_Nombre;
	private JTextField txtFld_Paterno;
	private JTextField txtFld_Materno;
	private JTextField txtFld_Telefono;
	JDateChooser dateChooser;
	JComboBox<String> comboBox;

	public GUIPagoPasajeros(JFrame padre, int noPasajeros) {
		super(padre, true);
		setTitle("Agregar pasajeros");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de cliente");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(24, 24, 70, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBounds(150, 21, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Nombre.setBounds(24, 66, 96, 14);
		getContentPane().add(lbl_Nombre);
		
		txtFld_Nombre = new JTextField();
		txtFld_Nombre.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Nombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Nombre.setBounds(150, 63, 96, 20);
		getContentPane().add(txtFld_Nombre);
		txtFld_Nombre.setColumns(10);
		
		JLabel lbl_Paterno = new JLabel("Apellido paterno");
		lbl_Paterno.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Paterno.setBounds(24, 106, 96, 14);
		getContentPane().add(lbl_Paterno);
		
		txtFld_Paterno = new JTextField();
		txtFld_Paterno.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Paterno.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Paterno.setBounds(150, 103, 96, 20);
		getContentPane().add(txtFld_Paterno);
		txtFld_Paterno.setColumns(10);
		
		JLabel lbl_Materno = new JLabel("Apellido materno");
		lbl_Materno.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Materno.setBounds(24, 147, 96, 14);
		getContentPane().add(lbl_Materno);
		
		txtFld_Materno = new JTextField();
		txtFld_Materno.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Materno.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Materno.setBounds(150, 144, 96, 20);
		getContentPane().add(txtFld_Materno);
		txtFld_Materno.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 184, 96, 20);
		dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		dateChooser.setBorder(new LineBorder(new Color(70, 130, 180)));
		getContentPane().add(dateChooser);
		
		JLabel lbl_FechaNC = new JLabel("Fecha de nacimiento");
		lbl_FechaNC.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_FechaNC.setBounds(24, 190, 116, 14);
		getContentPane().add(lbl_FechaNC);
		
		JLabel lbl_Telefono = new JLabel("Tel\u00E9fono");
		lbl_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Telefono.setBounds(24, 232, 70, 14);
		getContentPane().add(lbl_Telefono);
		
		txtFld_Telefono = new JTextField();
		txtFld_Telefono.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Telefono.setBounds(150, 229, 96, 20);
		getContentPane().add(txtFld_Telefono);
		txtFld_Telefono.setColumns(10);
		
		JLabel lbl_Genero = new JLabel("G\u00E9nero");
		lbl_Genero.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Genero.setBounds(24, 275, 70, 14);
		getContentPane().add(lbl_Genero);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		comboBox.setBorder(new LineBorder(new Color(70, 130, 180)));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"H", "M"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(150, 271, 96, 22);
		getContentPane().add(comboBox);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIPagoPasajeros.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setIcon(new ImageIcon(GUIPagoPasajeros.class.getResource("/img/Boton.png")));
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setBounds(24, 331, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		//Escribir el texto correspondiente en el boton
		String texto = "Siguiente";
		if (noPasajeros == 1) 
			texto = "Aceptar";
		JButton btn_Siguiente = new JButton(texto);
		btn_Siguiente.setPressedIcon(new ImageIcon(GUIPagoPasajeros.class.getResource("/img/Boton_Pres.png")));
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPasajero();
				//Si vamos a agregar al ultimo, entonces cambiamos el texto
				if (numPasajeros == 1) 
					btn_Siguiente.setText("Aceptar");				
			}
		});
		btn_Siguiente.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Siguiente.setIcon(new ImageIcon(GUIPagoPasajeros.class.getResource("/img/Boton.png")));
		btn_Siguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Siguiente.setContentAreaFilled(false);
		btn_Siguiente.setBorder(null);
		btn_Siguiente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Siguiente.setBounds(157, 331, 89, 23);
		getContentPane().add(btn_Siguiente);		
		setBounds(100, 100, 290, 415);

		numPasajeros = noPasajeros;
		datosPasajeros = new ArrayList<String[]>();
		setLocationRelativeTo(null);
	}

	//Este metodo se llama desde la GUI principal. Mientras esta ventana sea visible, no se devolvera datosPasajeros
	//Solo hasta que se cierre se devolvera datosPasajeros, pero para ese momento datosPasajeros ya tendra valores
	public ArrayList<String[]> registrarPasajeros() {
		this.setVisible(true);
		return datosPasajeros;
	}
	
	private void guardarPasajero() {		
		//Obtener todos los datos
		String ID = txtFld_ID.getText();
		String nombre = txtFld_Nombre.getText();
		String paterno = txtFld_Paterno.getText();
		String materno = txtFld_Materno.getText();
		Date utilFecha = dateChooser.getDate();
		java.sql.Date sqlFecha = new java.sql.Date(utilFecha.getTime());
		String fechaNC = sqlFecha.toString();
		String telefono = txtFld_Telefono.getText();
		String genero = (String)comboBox.getSelectedItem();
		
		//Crear array de strings para guardar los datos de un pasajero
		String[] datosPasajero = {ID, nombre, paterno, materno, fechaNC, telefono, genero};
		
		//Agregar el array al ArrayList datosPasajeros
		datosPasajeros.add(datosPasajero);
		
		//Limpiar lso datos
		txtFld_ID.setText("");
		txtFld_Nombre.setText("");
		txtFld_Paterno.setText("");
		txtFld_Materno.setText("");
		dateChooser.setDate(null);
		txtFld_Telefono.setText("");
		comboBox.setSelectedIndex(0);
				 
		//Cerrar la ventana si ya agregamos el ultimo
		if (numPasajeros == 1) 
			botonCancelarAccion();
		
		numPasajeros--;		
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
}

