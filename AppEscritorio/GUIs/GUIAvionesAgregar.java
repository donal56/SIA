package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Otros.Conexion;
import Otros.Metodos;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class GUIAvionesAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTable tbl_Modelo;
	private JTextField txtFld_VIPInicio;
	private JTextField txtFld_VIPFin;
	private JTextField txtFld_EjecutivoInicio;
	private JTextField txtFld_EjecutivoFin;
	private JTextField txtFld_TuristaInicio;
	private JTextField txtFld_TuristaFin;
	private String ID;

	//Crear la ventana para un nuevo avion
	/**
	 * @wbp.parser.constructor
	 */
	public GUIAvionesAgregar(Frame padre) {
		super(padre, true);
		initComponents(true);
		this.setTitle("Agregar un avi\u00F3n");
	}
	
	//Crear la ventana para actualizar un avion
	public GUIAvionesAgregar(Frame padre, String[] datos) {
		super(padre, true);
		initComponents(false);
		this.setTitle("Actualizar un avi\u00F3n");
		this.ID = datos[0];
		txtFld_ID.setText(datos[0]);
		//Buscar y seleccionar la fila correspondiente al modelo entregado
		boolean encontrado = false;
        int i = 0;
        String modelo;
        while (!encontrado) {
            modelo = tbl_Modelo.getValueAt(i, 0).toString();
            if (modelo.equals(datos[1])) 
                encontrado = true;
            else 
                i++;
        }
        tbl_Modelo.changeSelection(i, 0, false, false);
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
	
	//Un valor true indica una nueva oferta y un false indica actualizar una existente
	private void botonAceptarAccion(boolean tipo) {
		String ID = txtFld_ID.getText();
		int indiceModelo = tbl_Modelo.getSelectedRow();
		String IDModelo = (String)tbl_Modelo.getValueAt(indiceModelo, 0);
		//Crear el query considerando si es un nuevo avion o una actualizacion
		Conexion con = new Conexion();
		String query;
		if (tipo) {
			query = "INSERT INTO aviones VALUES (" + 
				ID + ", '" + 
				IDModelo + "')";
		} else {
			query = "UPDATE aviones SET " + 
						"idAvion = " + ID + 
						", modelosAvion_idModelo = '" + IDModelo +
						"' WHERE idAvion = " + this.ID;
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
	
	//Este metodo se ejecuta cuando se selecciona una fila de la tabla
	private void tablaSeleccionarAccion() {
		//Asegurar que solo ocurre una vez y no dos al seleccionar una fila
		if	(tbl_Modelo.getSelectionModel().getValueIsAdjusting() == false) {
			int indiceModelo = tbl_Modelo.getSelectedRow();
			String IDModelo = (String)tbl_Modelo.getValueAt(indiceModelo, 0);
			String query = "SELECT * FROM asientosAvion WHERE modelosAvion_idModelo = '" + IDModelo + "' ORDER BY asientoInicio";
			Conexion con = new Conexion();
			try {
				ResultSet asientos = con.obtenerDatos(query);
				//Llenar los TextField con los datos obtenidos
				asientos.next();
				txtFld_VIPInicio.setText(asientos.getString(3));
				txtFld_VIPFin.setText(asientos.getString(4));
				asientos.next();
				txtFld_EjecutivoInicio.setText(asientos.getString(3));
				txtFld_EjecutivoFin.setText(asientos.getString(4));
				asientos.next();
				txtFld_TuristaInicio.setText(asientos.getString(3));
				txtFld_TuristaFin.setText(asientos.getString(4));
				con.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void llenarTabla() {
		Metodos met = new Metodos();
		met.llenarTabla(tbl_Modelo, "SELECT * FROM modelosAvion");
	}
	
	@SuppressWarnings("serial")
	private void initComponents(boolean tipo) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 364, 490);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de avi\u00F3n");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(30, 30, 55, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setBounds(136, 27, 182, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JPanel pnl_Modelo = new JPanel();
		pnl_Modelo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		pnl_Modelo.setBackground(new Color(255, 255, 255));
		pnl_Modelo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(70, 130, 180)), "Modelo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_Modelo.setBounds(30, 67, 288, 330);
		getContentPane().add(pnl_Modelo);
		pnl_Modelo.setLayout(null);
		
		JScrollPane scrollPane_Modelo = new JScrollPane();
		scrollPane_Modelo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		scrollPane_Modelo.setBorder(new LineBorder(new Color(70, 130, 180)));
		scrollPane_Modelo.setBounds(10, 22, 268, 142);
		pnl_Modelo.add(scrollPane_Modelo);
		
		tbl_Modelo = new JTable();
		tbl_Modelo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				tablaSeleccionarAccion();
			}
		});
		tbl_Modelo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Modelo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Modelo.setViewportView(tbl_Modelo);
		
		JLabel lbl_AsientosVIP = new JLabel("Asientos de la clase VIP");
		lbl_AsientosVIP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_AsientosVIP.setBounds(10, 178, 134, 14);
		pnl_Modelo.add(lbl_AsientosVIP);
		
		txtFld_VIPInicio = new JTextField();
		txtFld_VIPInicio.setEnabled(false);
		txtFld_VIPInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_VIPInicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_VIPInicio.setBackground(new Color(255, 255, 255));
		txtFld_VIPInicio.setColumns(10);
		txtFld_VIPInicio.setBounds(164, 175, 30, 20);
		pnl_Modelo.add(txtFld_VIPInicio);
		
		JLabel lbl_Guion1 = new JLabel("-");
		lbl_Guion1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Guion1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion1.setBounds(204, 178, 20, 14);
		pnl_Modelo.add(lbl_Guion1);
		
		txtFld_VIPFin = new JTextField();
		txtFld_VIPFin.setEnabled(false);
		txtFld_VIPFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_VIPFin.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_VIPFin.setBackground(new Color(255, 255, 255));
		txtFld_VIPFin.setColumns(10);
		txtFld_VIPFin.setBounds(234, 175, 30, 20);
		pnl_Modelo.add(txtFld_VIPFin);
		
		JLabel lbl_AsientosEjecutivo = new JLabel("Asientos de la clase Ejecutivo");
		lbl_AsientosEjecutivo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_AsientosEjecutivo.setBounds(10, 219, 144, 14);
		pnl_Modelo.add(lbl_AsientosEjecutivo);
		
		txtFld_EjecutivoInicio = new JTextField();
		txtFld_EjecutivoInicio.setEnabled(false);
		txtFld_EjecutivoInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_EjecutivoInicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_EjecutivoInicio.setBackground(new Color(255, 255, 255));
		txtFld_EjecutivoInicio.setColumns(10);
		txtFld_EjecutivoInicio.setBounds(164, 216, 30, 20);
		pnl_Modelo.add(txtFld_EjecutivoInicio);
		
		JLabel lbl_Guion2 = new JLabel("-");
		lbl_Guion2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Guion2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion2.setBounds(204, 219, 20, 14);
		pnl_Modelo.add(lbl_Guion2);
		
		txtFld_EjecutivoFin = new JTextField();
		txtFld_EjecutivoFin.setEnabled(false);
		txtFld_EjecutivoFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_EjecutivoFin.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_EjecutivoFin.setBackground(new Color(255, 255, 255));
		txtFld_EjecutivoFin.setColumns(10);
		txtFld_EjecutivoFin.setBounds(234, 216, 30, 20);
		pnl_Modelo.add(txtFld_EjecutivoFin);
		
		JLabel lbl_AsientosTurista = new JLabel("Asientos de la clase Turista");
		lbl_AsientosTurista.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_AsientosTurista.setBounds(10, 262, 134, 14);
		pnl_Modelo.add(lbl_AsientosTurista);
		
		txtFld_TuristaInicio = new JTextField();
		txtFld_TuristaInicio.setEnabled(false);
		txtFld_TuristaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_TuristaInicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_TuristaInicio.setBackground(new Color(255, 255, 255));
		txtFld_TuristaInicio.setColumns(10);
		txtFld_TuristaInicio.setBounds(164, 256, 30, 20);
		pnl_Modelo.add(txtFld_TuristaInicio);
		
		JLabel lbl_Guion3 = new JLabel("-");
		lbl_Guion3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Guion3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion3.setBounds(204, 259, 20, 14);
		pnl_Modelo.add(lbl_Guion3);
		
		txtFld_TuristaFin = new JTextField();
		txtFld_TuristaFin.setEnabled(false);
		txtFld_TuristaFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_TuristaFin.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_TuristaFin.setBackground(new Color(255, 255, 255));
		txtFld_TuristaFin.setColumns(10);
		txtFld_TuristaFin.setBounds(234, 256, 30, 20);
		pnl_Modelo.add(txtFld_TuristaFin);
		
		JButton btn_NuevoModelo = new JButton("Nuevo modelo");
		btn_NuevoModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_NuevoModelo.setPressedIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_NuevoModelo.setIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton.png")));
		btn_NuevoModelo.setOpaque(false);
		btn_NuevoModelo.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_NuevoModelo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_NuevoModelo.setContentAreaFilled(false);
		btn_NuevoModelo.setBorder(null);
		btn_NuevoModelo.setBounds(175, 296, 89, 23);
		pnl_Modelo.add(btn_NuevoModelo);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccion(tipo);
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setPressedIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Aceptar.setIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton.png")));
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(135, 408, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setIcon(new ImageIcon(GUIAvionesAgregar.class.getResource("/img/Boton.png")));
		btn_Cancelar.setOpaque(false);
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setBounds(229, 408, 89, 23);
		getContentPane().add(btn_Cancelar);

		setLocationRelativeTo(null);
		llenarTabla();
	}
}
