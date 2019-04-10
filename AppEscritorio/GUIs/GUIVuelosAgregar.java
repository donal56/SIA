package GUIs;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

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

	
	public GUIVuelosAgregar(Frame padre, boolean modal) {
		super(padre, modal);
		
		setBounds(100, 100, 516, 481);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de vuelo");
		lbl_ID.setBounds(28, 28, 55, 14);
		getContentPane().add(lbl_ID);
		
		JLabel lbl_Fecha = new JLabel("Fecha");
		lbl_Fecha.setBounds(28, 67, 48, 14);
		getContentPane().add(lbl_Fecha);
		
		JLabel lbl_HoraSalida = new JLabel("Hora de salida");
		lbl_HoraSalida.setBounds(28, 110, 70, 14);
		getContentPane().add(lbl_HoraSalida);
		
		JLabel lbl_HoraLlegada = new JLabel("Hora de llegada");
		lbl_HoraLlegada.setBounds(28, 156, 77, 14);
		getContentPane().add(lbl_HoraLlegada);
		
		txtField_HoraLlegadaHH = new JTextField();
		txtField_HoraLlegadaHH.setBounds(115, 153, 35, 20);
		getContentPane().add(txtField_HoraLlegadaHH);
		txtField_HoraLlegadaHH.setColumns(10);
		
		txtField_HoraSalidaHH = new JTextField();
		txtField_HoraSalidaHH.setBounds(115, 107, 35, 20);
		getContentPane().add(txtField_HoraSalidaHH);
		txtField_HoraSalidaHH.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 61, 96, 20);
		getContentPane().add(dateChooser);
		
		txtField_ID = new JTextField();
		txtField_ID.setBounds(115, 25, 96, 20);
		getContentPane().add(txtField_ID);
		txtField_ID.setColumns(10);
		
		txtField_HoraSalidaMM = new JTextField();
		txtField_HoraSalidaMM.setColumns(10);
		txtField_HoraSalidaMM.setBounds(176, 107, 35, 20);
		getContentPane().add(txtField_HoraSalidaMM);
		
		txtField_HoraLlegadaMM = new JTextField();
		txtField_HoraLlegadaMM.setColumns(10);
		txtField_HoraLlegadaMM.setBounds(176, 153, 35, 20);
		getContentPane().add(txtField_HoraLlegadaMM);
		
		JLabel label = new JLabel("   :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(149, 110, 20, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("   :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(149, 156, 20, 14);
		getContentPane().add(label_1);
		
		JLabel lbl_PrecioTurista = new JLabel("Precio de clase Turista");
		lbl_PrecioTurista.setBounds(245, 28, 110, 14);
		getContentPane().add(lbl_PrecioTurista);
		
		JLabel lbl_PrecioEjecutivo = new JLabel("Precio de clase Ejecutivo");
		lbl_PrecioEjecutivo.setBounds(245, 67, 120, 14);
		getContentPane().add(lbl_PrecioEjecutivo);
		
		JLabel lbl_PrecioVIP = new JLabel("Precio de clase VIP");
		lbl_PrecioVIP.setBounds(245, 110, 120, 14);
		getContentPane().add(lbl_PrecioVIP);
		
		txtField_PrecioVIP = new JTextField();
		txtField_PrecioVIP.setColumns(10);
		txtField_PrecioVIP.setBounds(375, 107, 96, 20);
		getContentPane().add(txtField_PrecioVIP);
		
		txtField_PrecioEjecutivo = new JTextField();
		txtField_PrecioEjecutivo.setColumns(10);
		txtField_PrecioEjecutivo.setBounds(375, 64, 96, 20);
		getContentPane().add(txtField_PrecioEjecutivo);
		
		txtField_PrecioTurista = new JTextField();
		txtField_PrecioTurista.setColumns(10);
		txtField_PrecioTurista.setBounds(375, 25, 96, 20);
		getContentPane().add(txtField_PrecioTurista);
		
		JLabel lbl_Ruta = new JLabel("Ruta");
		lbl_Ruta.setBounds(28, 215, 48, 14);
		getContentPane().add(lbl_Ruta);
		
		JScrollPane scrllPane_Ruta = new JScrollPane();
		scrllPane_Ruta.setBounds(28, 230, 215, 147);
		getContentPane().add(scrllPane_Ruta);
		
		tbl_Ruta = new JTable();
		tbl_Ruta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Origen", "Destino", "Estado"
			}
		));
		scrllPane_Ruta.setViewportView(tbl_Ruta);
		
		JScrollPane scrllPane_Avion = new JScrollPane();
		scrllPane_Avion.setBounds(288, 230, 183, 147);
		getContentPane().add(scrllPane_Avion);
		
		tbl_Avion = new JTable();
		tbl_Avion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Modelo"
			}
		));
		scrllPane_Avion.setViewportView(tbl_Avion);
		
		JLabel lbl_Avion = new JLabel("Avion");
		lbl_Avion.setBounds(288, 215, 48, 14);
		getContentPane().add(lbl_Avion);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(382, 408, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(288, 408, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		setLocationRelativeTo(padre);
	}
}
