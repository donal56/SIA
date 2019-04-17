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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;

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
	public GUIAvionesAgregar() {
		super(new JFrame(), true);
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
		tbl_Modelo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tbl_Modelo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre"
			}
		));
		scrollPane_Modelo.setViewportView(tbl_Modelo);
		
		JLabel lbl_AsientosTurista = new JLabel("Asientos de la clase Turista");
		lbl_AsientosTurista.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_AsientosTurista.setBounds(10, 178, 134, 14);
		pnl_Modelo.add(lbl_AsientosTurista);
		
		txtFld_TuristaInicio = new JTextField();
		txtFld_TuristaInicio.setEnabled(false);
		txtFld_TuristaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_TuristaInicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_TuristaInicio.setBackground(new Color(255, 255, 255));
		txtFld_TuristaInicio.setColumns(10);
		txtFld_TuristaInicio.setBounds(164, 175, 30, 20);
		pnl_Modelo.add(txtFld_TuristaInicio);
		
		JLabel lbl_Guion1 = new JLabel("-");
		lbl_Guion1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Guion1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion1.setBounds(204, 178, 20, 14);
		pnl_Modelo.add(lbl_Guion1);
		
		txtFld_TuristaFin = new JTextField();
		txtFld_TuristaFin.setEnabled(false);
		txtFld_TuristaFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_TuristaFin.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_TuristaFin.setBackground(new Color(255, 255, 255));
		txtFld_TuristaFin.setColumns(10);
		txtFld_TuristaFin.setBounds(234, 175, 30, 20);
		pnl_Modelo.add(txtFld_TuristaFin);
		
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
		
		JLabel lbl_AsientosVIP = new JLabel("Asientos de la clase VIP");
		lbl_AsientosVIP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_AsientosVIP.setBounds(10, 262, 134, 14);
		pnl_Modelo.add(lbl_AsientosVIP);
		
		txtFld_VIPInicio = new JTextField();
		txtFld_VIPInicio.setEnabled(false);
		txtFld_VIPInicio.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_VIPInicio.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_VIPInicio.setBackground(new Color(255, 255, 255));
		txtFld_VIPInicio.setColumns(10);
		txtFld_VIPInicio.setBounds(164, 256, 30, 20);
		pnl_Modelo.add(txtFld_VIPInicio);
		
		JLabel lbl_Guion3 = new JLabel("-");
		lbl_Guion3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Guion3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Guion3.setBounds(204, 259, 20, 14);
		pnl_Modelo.add(lbl_Guion3);
		
		txtFld_VIPFin = new JTextField();
		txtFld_VIPFin.setEnabled(false);
		txtFld_VIPFin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_VIPFin.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_VIPFin.setBackground(new Color(255, 255, 255));
		txtFld_VIPFin.setColumns(10);
		txtFld_VIPFin.setBounds(234, 256, 30, 20);
		pnl_Modelo.add(txtFld_VIPFin);
		
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
	}
}
