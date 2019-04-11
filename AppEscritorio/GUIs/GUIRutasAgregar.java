package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class GUIRutasAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTextField txtFld_Origen;
	private JTextField txtFld_Destino;
	private JTextField txtFld_EstadoRuta;

	/**
	 * Create the dialog.
	 */
	public GUIRutasAgregar() {
		super(new JFrame(), true);
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBounds(100, 100, 278, 293);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de ruta");
		lbl_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_ID.setBounds(36, 32, 49, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_ID.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_ID.setBounds(129, 29, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JLabel lbl_Origen = new JLabel("Origen");
		lbl_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Origen.setBounds(36, 75, 33, 14);
		getContentPane().add(lbl_Origen);
		
		txtFld_Origen = new JTextField();
		txtFld_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Origen.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Origen.setBounds(129, 72, 96, 20);
		getContentPane().add(txtFld_Origen);
		txtFld_Origen.setColumns(10);
		
		JLabel lbl_Destino = new JLabel("Destino");
		lbl_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_Destino.setBounds(36, 117, 38, 14);
		getContentPane().add(lbl_Destino);
		
		txtFld_Destino = new JTextField();
		txtFld_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_Destino.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Destino.setBounds(129, 114, 96, 20);
		getContentPane().add(txtFld_Destino);
		txtFld_Destino.setColumns(10);
		
		JLabel lbl_EstadoRuta = new JLabel("Estado de la ruta");
		lbl_EstadoRuta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lbl_EstadoRuta.setBounds(36, 159, 83, 14);
		getContentPane().add(lbl_EstadoRuta);
		
		txtFld_EstadoRuta = new JTextField();
		txtFld_EstadoRuta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtFld_EstadoRuta.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_EstadoRuta.setBounds(129, 156, 96, 20);
		getContentPane().add(txtFld_EstadoRuta);
		txtFld_EstadoRuta.setColumns(10);
		
		JButton btn_Aceptar = new JButton("Aceptar");
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
