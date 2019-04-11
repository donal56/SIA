package GUIs;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
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

public class GUIVuelosAgregar extends JDialog {
	private JTextField txtField_HoraLlegadaHH;
	private JTextField txtField_HoraSalidaHH;
	private JTextField txtField_ID;
	private JTextField txtField_HoraSalidaMM;
	private JTextField txtField_HoraLlegadaMM;
	private JTextField txtField_PrecioVIP;
	private JTextField txtField_PrecioEjecutivo;
	private JTextField txtField_PrecioTurista;
	private JTable tbl_Ruta;
	private JTable tbl_Avion;

	
	public GUIVuelosAgregar() {
		super(new JFrame(), true);
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
		
		txtField_HoraLlegadaHH = new JTextField();
		txtField_HoraLlegadaHH.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_HoraLlegadaHH.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_HoraLlegadaHH.setBounds(116, 154, 35, 20);
		getContentPane().add(txtField_HoraLlegadaHH);
		txtField_HoraLlegadaHH.setColumns(10);
		
		txtField_HoraSalidaHH = new JTextField();
		txtField_HoraSalidaHH.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_HoraSalidaHH.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_HoraSalidaHH.setBounds(116, 108, 35, 20);
		getContentPane().add(txtField_HoraSalidaHH);
		txtField_HoraSalidaHH.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(116, 67, 96, 20);
		dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		dateChooser.setBorder(new LineBorder(new Color(70, 130, 180)));
		getContentPane().add(dateChooser);
		
		txtField_ID = new JTextField();
		txtField_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_ID.setBounds(116, 26, 96, 20);
		getContentPane().add(txtField_ID);
		txtField_ID.setColumns(10);
		
		txtField_HoraSalidaMM = new JTextField();
		txtField_HoraSalidaMM.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_HoraSalidaMM.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_HoraSalidaMM.setColumns(10);
		txtField_HoraSalidaMM.setBounds(177, 108, 35, 20);
		getContentPane().add(txtField_HoraSalidaMM);
		
		txtField_HoraLlegadaMM = new JTextField();
		txtField_HoraLlegadaMM.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_HoraLlegadaMM.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_HoraLlegadaMM.setColumns(10);
		txtField_HoraLlegadaMM.setBounds(177, 154, 35, 20);
		getContentPane().add(txtField_HoraLlegadaMM);
		
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
		
		txtField_PrecioVIP = new JTextField();
		txtField_PrecioVIP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_PrecioVIP.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_PrecioVIP.setColumns(10);
		txtField_PrecioVIP.setBounds(358, 108, 96, 20);
		getContentPane().add(txtField_PrecioVIP);
		
		txtField_PrecioEjecutivo = new JTextField();
		txtField_PrecioEjecutivo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_PrecioEjecutivo.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_PrecioEjecutivo.setColumns(10);
		txtField_PrecioEjecutivo.setBounds(358, 65, 96, 20);
		getContentPane().add(txtField_PrecioEjecutivo);
		
		txtField_PrecioTurista = new JTextField();
		txtField_PrecioTurista.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtField_PrecioTurista.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_PrecioTurista.setColumns(10);
		txtField_PrecioTurista.setBounds(358, 26, 96, 20);
		getContentPane().add(txtField_PrecioTurista);
		
		JLabel lbl_Ruta = new JLabel("Ruta");
		lbl_Ruta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Ruta.setBounds(28, 215, 48, 14);
		getContentPane().add(lbl_Ruta);
		
		JScrollPane scrllPane_Ruta = new JScrollPane();
		scrllPane_Ruta.setBorder(new LineBorder(new Color(70, 130, 180)));
		scrllPane_Ruta.setBounds(28, 230, 215, 147);
		getContentPane().add(scrllPane_Ruta);
		
		tbl_Ruta = new JTable();
		tbl_Ruta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Ruta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Origen", "Destino", "Estado"
			}
		));
		scrllPane_Ruta.setViewportView(tbl_Ruta);
		
		JScrollPane scrllPane_Avion = new JScrollPane();
		scrllPane_Avion.setBorder(new LineBorder(new Color(70, 130, 180)));
		scrllPane_Avion.setBounds(271, 230, 183, 147);
		getContentPane().add(scrllPane_Avion);
		
		tbl_Avion = new JTable();
		tbl_Avion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Avion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Modelo"
			}
		));
		scrllPane_Avion.setViewportView(tbl_Avion);
		
		JLabel lbl_Avion = new JLabel("Avion");
		lbl_Avion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Avion.setBounds(271, 215, 48, 14);
		getContentPane().add(lbl_Avion);
		
		JButton btn_Aceptar = new JButton("Aceptar");
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
	}
}
