package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;

import Otros.Conexion;
import Otros.Metodos;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIOfertasAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JDateChooser dateChooser_Inicio;
	private JDateChooser dateChooser_Fin;
	private JSpinner spnnr_Descuento;
	private String ID;

	//Crear la ventana para una nueva ruta
	/**
	 * @wbp.parser.constructor
	 */
	public GUIOfertasAgregar(Frame padre) {
		super(padre, true);
		initComponents(true);
		this.setTitle("Agregar una oferta");
	}
	
	//Crear la ventana para actualizar una ruta
	public GUIOfertasAgregar(Frame padre, String[] datos) {
		super(padre, true);
		initComponents(false);
		this.setTitle("Actualizar una oferta");
		this.ID = datos[0];
		//Preparar los datos
		Metodos met = new Metodos();
		Date fechaInicio = met.obtenerFecha(datos[1]);
		Date fechaFin = met.obtenerFecha(datos[2]);
		int descuento = Integer.parseInt(datos[3]);
		//Llenar los componentes con datos
		txtFld_ID.setText(datos[0]);
		dateChooser_Inicio.setDate(fechaInicio);
		dateChooser_Fin.setDate(fechaFin);
		spnnr_Descuento.getModel().setValue(descuento);
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
	
	//Un valor true indica una nueva oferta y un false indica actualizar una existente
	private void botonAceptarAccion(boolean tipo) {
		String ID = txtFld_ID.getText();
		
		//Obtener las fechas y darles el formato apropiado para MySQL
		Date utilFechaInicio = dateChooser_Inicio.getDate();
		java.sql.Date sqlFechaInicio = new java.sql.Date(utilFechaInicio.getTime());
		String fechaInicio = sqlFechaInicio.toString();
		
		Date utilFechaFin = dateChooser_Fin.getDate();
		java.sql.Date sqlFechaFin = new java.sql.Date(utilFechaFin.getTime());
		String fechaFin = sqlFechaFin.toString();
		
		try {
			//Obtener el valor del Spinner
			spnnr_Descuento.commitEdit();
			int descuento = (int) spnnr_Descuento.getValue();
			//Crear el query considerando si es una nueva ruta o una actualizacion
			Conexion con = new Conexion();
			String query;
			if (tipo) {
				query = "INSERT INTO ofertas VALUES (" +
							ID + ", '" +
							fechaInicio + "', '" +
							fechaFin + "', " + 
							descuento + ")";
			} else {
				query = "UPDATE ofertas SET " + 
						"idOferta = " + ID + 
						", inicio = '" + fechaInicio +
						"', fin = '" + fechaFin +
						"', porcDesc = " + descuento +
						" WHERE idOferta = " + this.ID;
			}
			//Ejecutar query, cerrar la conexion y la ventana
			con.realizarOperacion(query);
			con.cerrarConexion();
			botonCancelarAccion();
		} catch (ParseException|SQLException e) {
			e.printStackTrace(); 
		}
	}
	
	private void initComponents(boolean tipo) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 266, 293);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de oferta");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(31, 30, 73, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setColumns(10);
		txtFld_ID.setBounds(124, 27, 96, 20);
		getContentPane().add(txtFld_ID);
		
		JLabel lbl_FechaInicio = new JLabel("Fecha de inicio");
		lbl_FechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_FechaInicio.setBounds(31, 75, 83, 14);
		getContentPane().add(lbl_FechaInicio);
		
		JLabel lbl_FechaFin = new JLabel("Fecha de fin");
		lbl_FechaFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_FechaFin.setBounds(31, 117, 73, 14);
		getContentPane().add(lbl_FechaFin);
		
		JLabel lbl_Descuento = new JLabel("% de descuento");
		lbl_Descuento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Descuento.setBounds(31, 155, 83, 14);
		getContentPane().add(lbl_Descuento);
		
		spnnr_Descuento = new JSpinner();
		spnnr_Descuento.setBorder(new LineBorder(new Color(70, 130, 180)));
		spnnr_Descuento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		spnnr_Descuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnnr_Descuento.setBounds(124, 152, 96, 20);
		getContentPane().add(spnnr_Descuento);
		
		dateChooser_Fin = new JDateChooser();
		dateChooser_Fin.setBounds(124, 111, 96, 20);
		dateChooser_Fin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		dateChooser_Fin.setBorder(new LineBorder(new Color(70, 130, 180)));
		getContentPane().add(dateChooser_Fin);
		
		dateChooser_Inicio = new JDateChooser();
		dateChooser_Inicio.setBounds(124, 69, 96, 20);
		dateChooser_Inicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		dateChooser_Inicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		getContentPane().add(dateChooser_Inicio);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccion(tipo);
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setPressedIcon(new ImageIcon(GUIOfertasAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Aceptar.setIcon(new ImageIcon(GUIOfertasAgregar.class.getResource("/img/Boton.png")));
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(31, 209, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIOfertasAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setIcon(new ImageIcon(GUIOfertasAgregar.class.getResource("/img/Boton.png")));
		btn_Cancelar.setOpaque(false);
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setBounds(131, 209, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		setLocationRelativeTo(null);
	}
}