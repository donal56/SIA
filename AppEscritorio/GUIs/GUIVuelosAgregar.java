package GUIs;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Otros.Conexion;
import Otros.Metodos;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class GUIVuelosAgregar extends JDialog {
	private JTextField txtFld_HoraLlegadaHH;
	private JTextField txtFld_HoraSalidaHH;
	private JTextField txtFld_ID;
	private JTextField txtFld_HoraSalidaMM;
	private JTextField txtFld_HoraLlegadaMM;
	private JTextField txtFld_PrecioVIP;
	private JTextField txtFld_PrecioEjecutivo;
	private JTextField txtFld_PrecioTurista;
	private JTable tbl_Ruta;
	private JTable tbl_Avion;
	private JDateChooser dateChooser;
	private String ID;
	
	//Crear la ventana para un nuevo vuelo
	/**
	 * @wbp.parser.constructor
	 */
	public GUIVuelosAgregar(Frame padre) {
		super(padre, true);
		initComponents(true);
		this.setTitle("Agregar un vuelo");
	}
	
	//Crear la ventana para actualizar un vuelo
	public GUIVuelosAgregar(Frame padre, String[] datos) {
		super(padre, true);
		initComponents(false);
		this.setTitle("Actualizar un vuelo");
		this.ID = datos[0];
		//Preparar los datos
		Metodos met = new Metodos();
		Date fecha = met.obtenerFecha(datos[2]);
		String horaSalidaHH = datos[3].substring(0, 2);
		String horaSalidaMM = datos[3].substring(3, 5);
		String horaLlegadaHH = datos[4].substring(0, 2);
		String horaLlegadaMM = datos[4].substring(3, 5);
		//Buscar y seleccionar la fila correspondiente al origen y destino entregados
		boolean encontrado = false;
        int i = 0;
        String origen;
        String destino;
        while (!encontrado) {
            origen = tbl_Ruta.getValueAt(i, 1).toString();
            destino = tbl_Ruta.getValueAt(i, 2).toString();
            if (origen.equals(datos[5]) && destino.equals(datos[6])) 
                encontrado = true;
            else 
                i++;
        }
        tbl_Ruta.changeSelection(i, 0, false, false);
        //Buscar y seleccionar la fila correspondiente al avion entregado
		encontrado = false;
		i = 0;
	    String avion;
	    while (!encontrado) {
	        avion = tbl_Avion.getValueAt(i, 0).toString();
	        if (avion.equals(datos[1])) 
	        	encontrado = true;
	        else 
	        	i++;
	    }
	    tbl_Avion.changeSelection(i, 0, false, false);
	    //Llenar los componentes con datos
	    txtFld_ID.setText(datos[0]);
	    dateChooser.setDate(fecha);
	    txtFld_HoraSalidaHH.setText(horaSalidaHH);
	    txtFld_HoraSalidaMM.setText(horaSalidaMM);
	    txtFld_HoraLlegadaHH.setText(horaLlegadaHH);
	    txtFld_HoraLlegadaMM.setText(horaLlegadaMM);
	    txtFld_PrecioTurista.setText(datos[8]);
	    txtFld_PrecioEjecutivo.setText(datos[9]);
	    txtFld_PrecioVIP.setText(datos[10]);
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
	
	private void botonAceptarAccion(boolean tipo) {
		//Obtener los valores de las TextBox
		String ID = txtFld_ID.getText();
		String horaSalidaHH = txtFld_HoraSalidaHH.getText();
		String horaSalidaMM = txtFld_HoraSalidaMM.getText();
		String horaLlegadaHH = txtFld_HoraLlegadaHH.getText();
		String horaLlegadaMM = txtFld_HoraLlegadaMM.getText();
		String precioTurista = txtFld_PrecioTurista.getText();
		String precioEjecutivo = txtFld_PrecioEjecutivo.getText();
		String precioVIP = txtFld_PrecioVIP.getText();
		
		//Obtener los valores de las tablas
		int indiceRuta = tbl_Ruta.getSelectedRow();
		int indiceAvion = tbl_Avion.getSelectedRow();
		String IDRuta = (String)tbl_Ruta.getValueAt(indiceRuta, 0);
		String IDAvion = (String)tbl_Avion.getValueAt(indiceAvion, 0);
		
		//Obtener la fecha y darle el formato apropiado para MySQL
		Date utilFecha = dateChooser.getDate();
		java.sql.Date sqlFecha = new java.sql.Date(utilFecha.getTime());
		String fecha = sqlFecha.toString();
		
		//Dar un formato a las tiempos de salida y llegada
		String horaSalida = horaSalidaHH + ":" + horaSalidaMM + ":00";
		String horaLlegada = horaLlegadaHH + ":" + horaLlegadaMM + ":00";
		
		//Compara la fecha del vuelo y las fechas de las ofertas de la BD, seleccionar la oferta correspondiente
		try {
			Conexion con = new Conexion();
			String IDOferta = "";
			ResultSet ofertas = con.obtenerDatos("SELECT idOferta FROM ofertas WHERE '" + fecha + "' > inicio AND '" + fecha + "' < fin");
			boolean hayOferta = ofertas.isBeforeFirst(); 
			if (hayOferta) {
				ofertas.next();
				IDOferta = ofertas.getString(1);
			} else 
				IDOferta = "0"; 
		
			//Crear el query y ejecutarlo, considerando si es un nuevo vuelo o una actualizacion
			String query;
			if (tipo) {
				query = "INSERT INTO vuelos VALUES (" +
							ID + ", '" +
							fecha + "', '" +
							horaSalida + "', '" +
							horaLlegada + "', " +
							IDRuta + ", " + 
							IDOferta + ", " + 
							precioTurista + ", " +
							precioEjecutivo + ", " +
							precioVIP + ", " + 
							IDAvion + ")";
			} else {
				query = "UPDATE vuelos SET " +
							"idVuelo = " + ID + 
							", fecha = '" + fecha +
							"', horaSalida = '" + horaSalida +
							"', horaLlegada = '" + horaLlegada +
							"', rutas_idRuta = " + IDRuta + 
							", ofertas_idOferta = " + IDOferta +
							", precioTurista = " + precioTurista +
							", precioEjecutivo = " + precioEjecutivo +
							", precioVIP = " + precioVIP + 
							", aviones_idAvion = " + IDAvion +
							" WHERE idVuelo = " + this.ID;
			}
			//Ejecutar query, cerrar la conexion y la ventana
			con.realizarOperacion(query);
			con.cerrarConexion();
			botonCancelarAccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void llenarTablas() {
		Metodos met = new Metodos();
		met.llenarTabla(tbl_Ruta, "CALL sp_ConsultarRutas (8,0,'','',0)");
		met.llenarTabla(tbl_Avion, "CALL sp_ConsultarAviones(8,3,'',0)");
	}
	
	@SuppressWarnings("serial")
	private void initComponents(boolean tipo) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 498, 481);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de vuelo");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(28, 28, 55, 14);
		getContentPane().add(lbl_ID);
		
		JLabel lbl_Fecha = new JLabel("Fecha");
		lbl_Fecha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Fecha.setBounds(28, 67, 48, 14);
		getContentPane().add(lbl_Fecha);
		
		JLabel lbl_HoraSalida = new JLabel("Hora de salida");
		lbl_HoraSalida.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_HoraSalida.setBounds(28, 110, 71, 14);
		getContentPane().add(lbl_HoraSalida);
		
		JLabel lbl_HoraLlegada = new JLabel("Hora de llegada");
		lbl_HoraLlegada.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_HoraLlegada.setBounds(28, 156, 78, 14);
		getContentPane().add(lbl_HoraLlegada);
		
		txtFld_HoraLlegadaHH = new JTextField();
		txtFld_HoraLlegadaHH.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_HoraLlegadaHH.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_HoraLlegadaHH.setBounds(116, 154, 35, 20);
		getContentPane().add(txtFld_HoraLlegadaHH);
		txtFld_HoraLlegadaHH.setColumns(10);
		
		txtFld_HoraSalidaHH = new JTextField();
		txtFld_HoraSalidaHH.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_HoraSalidaHH.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_HoraSalidaHH.setBounds(116, 108, 35, 20);
		getContentPane().add(txtFld_HoraSalidaHH);
		txtFld_HoraSalidaHH.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(116, 67, 96, 20);
		dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		dateChooser.setBorder(new LineBorder(new Color(70, 130, 180)));
		getContentPane().add(dateChooser);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setBounds(116, 26, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		txtFld_HoraSalidaMM = new JTextField();
		txtFld_HoraSalidaMM.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_HoraSalidaMM.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_HoraSalidaMM.setColumns(10);
		txtFld_HoraSalidaMM.setBounds(177, 108, 35, 20);
		getContentPane().add(txtFld_HoraSalidaMM);
		
		txtFld_HoraLlegadaMM = new JTextField();
		txtFld_HoraLlegadaMM.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_HoraLlegadaMM.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_HoraLlegadaMM.setColumns(10);
		txtFld_HoraLlegadaMM.setBounds(177, 154, 35, 20);
		getContentPane().add(txtFld_HoraLlegadaMM);
		
		JLabel lbl_Puntos1 = new JLabel("   :");
		lbl_Puntos1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Puntos1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Puntos1.setBounds(148, 111, 20, 14);
		getContentPane().add(lbl_Puntos1);
		
		JLabel lbl_Puntos2 = new JLabel("   :");
		lbl_Puntos2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Puntos2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Puntos2.setBounds(148, 157, 20, 14);
		getContentPane().add(lbl_Puntos2);
		
		JLabel lbl_PrecioTurista = new JLabel("Precio de clase Turista");
		lbl_PrecioTurista.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_PrecioTurista.setBounds(228, 29, 110, 14);
		getContentPane().add(lbl_PrecioTurista);
		
		JLabel lbl_PrecioEjecutivo = new JLabel("Precio de clase Ejecutivo");
		lbl_PrecioEjecutivo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_PrecioEjecutivo.setBounds(228, 70, 120, 14);
		getContentPane().add(lbl_PrecioEjecutivo);
		
		JLabel lbl_PrecioVIP = new JLabel("Precio de clase VIP");
		lbl_PrecioVIP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_PrecioVIP.setBounds(228, 111, 120, 14);
		getContentPane().add(lbl_PrecioVIP);
		
		txtFld_PrecioVIP = new JTextField();
		txtFld_PrecioVIP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_PrecioVIP.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_PrecioVIP.setColumns(10);
		txtFld_PrecioVIP.setBounds(358, 108, 96, 20);
		getContentPane().add(txtFld_PrecioVIP);
		
		txtFld_PrecioEjecutivo = new JTextField();
		txtFld_PrecioEjecutivo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_PrecioEjecutivo.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_PrecioEjecutivo.setColumns(10);
		txtFld_PrecioEjecutivo.setBounds(358, 65, 96, 20);
		getContentPane().add(txtFld_PrecioEjecutivo);
		
		txtFld_PrecioTurista = new JTextField();
		txtFld_PrecioTurista.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_PrecioTurista.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_PrecioTurista.setColumns(10);
		txtFld_PrecioTurista.setBounds(358, 26, 96, 20);
		getContentPane().add(txtFld_PrecioTurista);
		
		JLabel lbl_Ruta = new JLabel("Ruta");
		lbl_Ruta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Ruta.setBounds(28, 215, 48, 14);
		getContentPane().add(lbl_Ruta);
		
		JScrollPane scrllPane_Ruta = new JScrollPane();
		scrllPane_Ruta.setBorder(new LineBorder(new Color(70, 130, 180)));
		scrllPane_Ruta.setBounds(28, 230, 215, 147);
		getContentPane().add(scrllPane_Ruta);
		
		tbl_Ruta = new JTable();
		tbl_Ruta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_Ruta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Ruta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Origen", "Destino", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrllPane_Ruta.setViewportView(tbl_Ruta);
		
		JScrollPane scrllPane_Avion = new JScrollPane();
		scrllPane_Avion.setBorder(new LineBorder(new Color(70, 130, 180)));
		scrllPane_Avion.setBounds(271, 230, 183, 147);
		getContentPane().add(scrllPane_Avion);
		
		tbl_Avion = new JTable();
		tbl_Avion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_Avion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Avion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Modelo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrllPane_Avion.setViewportView(tbl_Avion);
		
		JLabel lbl_Avion = new JLabel("Avion");
		lbl_Avion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Avion.setBounds(271, 215, 48, 14);
		getContentPane().add(lbl_Avion);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccion(tipo);
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setPressedIcon(new ImageIcon(GUIVuelosAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Aceptar.setIcon(new ImageIcon(GUIVuelosAgregar.class.getResource("/img/Boton.png")));
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(271, 397, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccion();
			}
		});
		btn_Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cancelar.setPressedIcon(new ImageIcon(GUIVuelosAgregar.class.getResource("/img/Boton_Pres.png")));
		btn_Cancelar.setIcon(new ImageIcon(GUIVuelosAgregar.class.getResource("/img/Boton.png")));
		btn_Cancelar.setOpaque(false);
		btn_Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_Cancelar.setContentAreaFilled(false);
		btn_Cancelar.setBorder(null);
		btn_Cancelar.setBounds(365, 397, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		setLocationRelativeTo(null);
		llenarTablas();
	}
}
