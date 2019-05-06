package GUIs;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Otros.Conexion;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUILogin extends JFrame {
	private JTextField txtFld_Usuario;
	private JPasswordField pssFld_Contrasena;

	private void botonAceptarAccion() {
		boolean aceptado = false;
		String usuario = txtFld_Usuario.getText();
		String contrasena = pssFld_Contrasena.getText();
		Conexion con = new Conexion();
		String query = "SELECT tipo "
				+ "FROM empleados "
				+ "WHERE usuario = '" + usuario + "' AND contrasena = AES_ENCRYPT('" + contrasena + "', 'sia2019')";
		try {
			ResultSet resultado = con.obtenerDatos(query);
			aceptado = resultado.isBeforeFirst();
			if (aceptado) {
				resultado.next();
				new GUIPrincipal(resultado.getString(1)).setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Error en la autencaci\u00F3n. Confirme que su usuario y "
						+ "contrase\u00F1a sean conrrectos.", "Autenticaci\u00F3n fallida", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public GUILogin() {
		setResizable(false);
		setTitle("Ingresar");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 510, 381);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lbl_IconoLogin = new JLabel("");
		lbl_IconoLogin.setIcon(new ImageIcon(GUILogin.class.getResource("/img/IconoLogin.png")));
		lbl_IconoLogin.setBounds(20, 101, 166, 166);
		getContentPane().add(lbl_IconoLogin);
		
		JLabel lbl_Ingresar = new JLabel("Ingresar");
		lbl_Ingresar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ingresar.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		lbl_Ingresar.setBounds(244, 22, 145, 67);
		getContentPane().add(lbl_Ingresar);
		
		JLabel lbl_Usuario = new JLabel("Usuario");
		lbl_Usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Usuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbl_Usuario.setBounds(233, 127, 76, 35);
		getContentPane().add(lbl_Usuario);
		
		JLabel lbl_Contrasena = new JLabel("Contrase\u00F1a");
		lbl_Contrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Contrasena.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbl_Contrasena.setBounds(195, 188, 114, 35);
		getContentPane().add(lbl_Contrasena);
		
		txtFld_Usuario = new JTextField();
		txtFld_Usuario.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtFld_Usuario.setBounds(329, 136, 145, 25);
		getContentPane().add(txtFld_Usuario);
		txtFld_Usuario.setColumns(10);
		
		pssFld_Contrasena = new JPasswordField();
		pssFld_Contrasena.setBorder(new LineBorder(new Color(70, 130, 180)));
		pssFld_Contrasena.setBounds(329, 197, 145, 25);
		getContentPane().add(pssFld_Contrasena);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAceptarAccion();
			}
		});
		btn_Aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setOpaque(false);
		btn_Aceptar.setContentAreaFilled(false);
		btn_Aceptar.setPressedIcon(new ImageIcon(GUILogin.class.getResource("/img/LoginBotonAceptar_Pres.png")));
		btn_Aceptar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btn_Aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Aceptar.setSelectedIcon(null);
		btn_Aceptar.setIcon(new ImageIcon(GUILogin.class.getResource("/img/LoginBotonAceptar.png")));
		btn_Aceptar.setBounds(298, 283, 97, 35);
		getContentPane().add(btn_Aceptar);
		setLocationRelativeTo(null);
	}
}
