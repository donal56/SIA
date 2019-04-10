package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAvionesAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTable tbl_Modelo;
	private JTextField txtFld_TuristaInicio;
	private JTextField txtFld_TuristaFin;
	private JTextField txtFld_EjecutivoInicio;
	private JTextField txtFld_EjecutivoFin;
	private JTextField txtFld_VIPInicio;
	private JTextField txtFld_VIPFin;

	/**
	 * Create the dialog.
	 */
	public GUIAvionesAgregar(Frame padre, boolean modal) {
		super(padre, modal);
		
		setBounds(100, 100, 364, 490);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de avi\u00F3n");
		lbl_ID.setBounds(30, 30, 55, 14);
		getContentPane().add(lbl_ID);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(229, 408, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(136, 408, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setBounds(136, 27, 182, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JPanel pnl_Modelo = new JPanel();
		pnl_Modelo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modelo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_Modelo.setBounds(30, 67, 288, 330);
		getContentPane().add(pnl_Modelo);
		pnl_Modelo.setLayout(null);
		
		JScrollPane scrollPane_Modelo = new JScrollPane();
		scrollPane_Modelo.setBounds(10, 22, 268, 142);
		pnl_Modelo.add(scrollPane_Modelo);
		
		tbl_Modelo = new JTable();
		tbl_Modelo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre"
			}
		));
		scrollPane_Modelo.setViewportView(tbl_Modelo);
		
		JButton btn_NuevoModelo = new JButton("Agregar nuevo modelo");
		btn_NuevoModelo.setBounds(134, 296, 144, 23);
		pnl_Modelo.add(btn_NuevoModelo);
		
		JLabel lbl_AsientosTurista = new JLabel("Asientos de la clase Turista");
		lbl_AsientosTurista.setBounds(10, 178, 134, 14);
		pnl_Modelo.add(lbl_AsientosTurista);
		
		txtFld_TuristaInicio = new JTextField();
		txtFld_TuristaInicio.setEnabled(false);
		txtFld_TuristaInicio.setColumns(10);
		txtFld_TuristaInicio.setBounds(164, 175, 30, 20);
		pnl_Modelo.add(txtFld_TuristaInicio);
		
		JLabel lbl_Guion1 = new JLabel("-");
		lbl_Guion1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion1.setBounds(204, 178, 20, 14);
		pnl_Modelo.add(lbl_Guion1);
		
		txtFld_TuristaFin = new JTextField();
		txtFld_TuristaFin.setEnabled(false);
		txtFld_TuristaFin.setColumns(10);
		txtFld_TuristaFin.setBounds(234, 175, 30, 20);
		pnl_Modelo.add(txtFld_TuristaFin);
		
		JLabel lbl_AsientosEjecutivo = new JLabel("Asientos de la clase Ejecutivo");
		lbl_AsientosEjecutivo.setBounds(10, 219, 144, 14);
		pnl_Modelo.add(lbl_AsientosEjecutivo);
		
		txtFld_EjecutivoInicio = new JTextField();
		txtFld_EjecutivoInicio.setEnabled(false);
		txtFld_EjecutivoInicio.setColumns(10);
		txtFld_EjecutivoInicio.setBounds(164, 216, 30, 20);
		pnl_Modelo.add(txtFld_EjecutivoInicio);
		
		JLabel lbl_Guion2 = new JLabel("-");
		lbl_Guion2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion2.setBounds(204, 219, 20, 14);
		pnl_Modelo.add(lbl_Guion2);
		
		txtFld_EjecutivoFin = new JTextField();
		txtFld_EjecutivoFin.setEnabled(false);
		txtFld_EjecutivoFin.setColumns(10);
		txtFld_EjecutivoFin.setBounds(234, 216, 30, 20);
		pnl_Modelo.add(txtFld_EjecutivoFin);
		
		JLabel lbl_AsientosVIP = new JLabel("Asientos de la clase VIP");
		lbl_AsientosVIP.setBounds(10, 262, 134, 14);
		pnl_Modelo.add(lbl_AsientosVIP);
		
		txtFld_VIPInicio = new JTextField();
		txtFld_VIPInicio.setEnabled(false);
		txtFld_VIPInicio.setColumns(10);
		txtFld_VIPInicio.setBounds(164, 256, 30, 20);
		pnl_Modelo.add(txtFld_VIPInicio);
		
		JLabel lbl_Guion3 = new JLabel("-");
		lbl_Guion3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion3.setBounds(204, 259, 20, 14);
		pnl_Modelo.add(lbl_Guion3);
		
		txtFld_VIPFin = new JTextField();
		txtFld_VIPFin.setEnabled(false);
		txtFld_VIPFin.setColumns(10);
		txtFld_VIPFin.setBounds(234, 256, 30, 20);
		pnl_Modelo.add(txtFld_VIPFin);

		setLocationRelativeTo(padre);
	}
}
