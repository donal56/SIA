package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Otros.Conexion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUIRutasAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTextField txtFld_Origen;
	private JTextField txtFld_Destino;
	private JTextField txtFld_EstadoRuta;
	private String ID;
	
	//Crear la ventana para una nueva ruta
	/**
	 * @wbp.parser.constructor
	 */
	public GUIRutasAgregar(Frame padre) {
		super(padre, true);
		initComponents(true);
		this.setTitle("Agregar una ruta");
	}
	
	//Crear la ventana para actualizar una ruta
	public GUIRutasAgregar(Frame padre, String[] datos) {
		super(padre, true);
		initComponents(false);
		this.setTitle("Actualizar una ruta");
		ID = datos[0];
		//Llenar los componentes con datos
		txtFld_ID.setText(datos[0]);
		txtFld_Origen.setText(datos[1]);
		txtFld_Destino.setText(datos[2]);
		txtFld_EstadoRuta.setText(datos[3]);
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
	
	//Un valor true indica una nueva ruta y un false indica actualizar una existente
	private void botonAceptarAccion(boolean tipo) {
		//Obtener los valores de las TextBox
		String ID = txtFld_ID.getText();
		String origen = txtFld_Origen.getText();
		String destino = txtFld_Destino.getText();
		String estadoRuta = txtFld_EstadoRuta.getText();
		
		//Crear el query considerando si es una nueva ruta o una actualizacion
		Conexion con = new Conexion();
		String query;
		if (tipo) {
			query = "INSERT INTO rutas VALUES (" +
						ID + ", '" +
						origen + "', '" +
						destino + "', " + 
						estadoRuta + ")";
		} else {
			query = "UPDATE rutas SET " + 
						"idRuta = " + ID + 
						", origen = '" + origen +
						"', destino = '" + destino +
						"', estado = " + estadoRuta +
						" WHERE idRuta = " + this.ID;
		}
		//Ejecutar query, cerrar la conexion y la ventana
		try {
			con.realizarOperacion(query);
			con.cerrarConexion();
			botonCancelarAccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents(boolean tipo) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 278, 293);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de ruta");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(36, 32, 56, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setBounds(129, 29, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JLabel lbl_Origen = new JLabel("Origen");
		lbl_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Origen.setBounds(36, 75, 38, 14);
		getContentPane().add(lbl_Origen);
		
		txtFld_Origen = new JTextField();
		txtFld_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Origen.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Origen.setBounds(129, 72, 96, 20);
		getContentPane().add(txtFld_Origen);
		txtFld_Origen.setColumns(10);
		
		JLabel lbl_Destino = new JLabel("Destino");
		lbl_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Destino.setBounds(36, 117, 45, 14);
		getContentPane().add(lbl_Destino);
		
		txtFld_Destino = new JTextField();
		txtFld_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Destino.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Destino.setBounds(129, 114, 96, 20);
		getContentPane().add(txtFld_Destino);
		txtFld_Destino.setColumns(10);
		
		JLabel lbl_EstadoRuta = new JLabel("Estado de la ruta");
		lbl_EstadoRuta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_EstadoRuta.setBounds(36, 159, 89, 14);
		getContentPane().add(lbl_EstadoRuta);
		
		txtFld_EstadoRuta = new JTextField();
		txtFld_EstadoRuta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_EstadoRuta.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_EstadoRuta.setBounds(129, 156, 96, 20);
		getContentPane().add(txtFld_EstadoRuta);
		txtFld_EstadoRuta.setColumns(10);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccion(tipo);
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setPressedIcon(new ImageIcon(GUIRutasAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Aceptar.setIcon(new ImageIcon(GUIRutasAgregar.class.getResource("/img/Boton.png")));
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(36, 207, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIRutasAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setIcon(new ImageIcon(GUIRutasAgregar.class.getResource("/img/Boton.png")));
		btn_Cancelar.setOpaque(false);
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setBounds(136, 207, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		setLocationRelativeTo(null);
	}
}
