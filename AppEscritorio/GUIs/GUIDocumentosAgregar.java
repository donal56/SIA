package GUIs;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Otros.Conexion;
import Otros.Metodos;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUIDocumentosAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTextField txtFld_Peso;
	private JTable tbl_Cliente;

	@SuppressWarnings("serial")
	public GUIDocumentosAgregar(JFrame padre) {
		super(padre, true);
		setTitle("Agregar una maleta");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 295, 365);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de documentaci\u00F3n");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(36, 32, 103, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBounds(149, 29, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JLabel lbl_Peso = new JLabel("Peso");
		lbl_Peso.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Peso.setBounds(36, 75, 48, 14);
		getContentPane().add(lbl_Peso);
		
		txtFld_Peso = new JTextField();
		txtFld_Peso.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Peso.setBounds(149, 72, 96, 20);
		getContentPane().add(txtFld_Peso);
		txtFld_Peso.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 132, 209, 114);
		getContentPane().add(scrollPane);
		
		tbl_Cliente = new JTable();
		tbl_Cliente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Cliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tbl_Cliente);
		
		JLabel lbl_Cliente = new JLabel("Cliente");
		lbl_Cliente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Cliente.setBounds(36, 117, 48, 14);
		getContentPane().add(lbl_Cliente);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccion();
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setPressedIcon(new ImageIcon(GUIDocumentosAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Aceptar.setIcon(new ImageIcon(GUIDocumentosAgregar.class.getResource("/img/Boton.png")));
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(36, 280, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIDocumentosAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setIcon(new ImageIcon(GUIDocumentosAgregar.class.getResource("/img/Boton.png")));
		btn_Cancelar.setOpaque(false);
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setBounds(156, 281, 89, 23);
		getContentPane().add(btn_Cancelar);

		setLocationRelativeTo(null);
		llenarTabla();
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
	
	private void botonAceptarAccion() {
		//Obtener los datos
		String ID = txtFld_ID.getText();
		String peso = txtFld_Peso.getText();
		int indiceCliente = tbl_Cliente.getSelectedRow();
		String IDCliente = (String)tbl_Cliente.getValueAt(indiceCliente, 0);
		//Crear el query
		String query = "INSERT INTO documentacion VALUES (" + 
				ID + ", " + 
				peso + ", " +
				IDCliente + ")";
		//Ejecutar query, cerrar la conexion y la ventana
		try {
			Conexion con = new Conexion(); 
			con.realizarOperacion(query);
			con.cerrarConexion();
			botonCancelarAccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void llenarTabla() {
		Metodos met = new Metodos();
		String query = "SELECT idCliente, "
				+ "concat(nombre, \" \", apellidoP, \" \", apellidoM) AS pasajero "
				+ "FROM clientes";
		met.llenarTabla(tbl_Cliente, query);
	}
}
