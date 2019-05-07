package GUIs;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUILogin extends JFrame {
	private JTextField txtField_Usuario;
	private JPasswordField passField_Contrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		lbl_Usuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbl_Usuario.setBounds(233, 127, 76, 35);
		getContentPane().add(lbl_Usuario);
		
		JLabel lbl_Contrasena = new JLabel("Contrase\u00F1a");
		lbl_Contrasena.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbl_Contrasena.setBounds(195, 188, 114, 35);
		getContentPane().add(lbl_Contrasena);
		
		txtField_Usuario = new JTextField();
		txtField_Usuario.setBorder(new LineBorder(new Color(70, 130, 180)));
		txtField_Usuario.setBounds(329, 136, 145, 25);
		getContentPane().add(txtField_Usuario);
		txtField_Usuario.setColumns(10);
		
		passField_Contrasena = new JPasswordField();
		passField_Contrasena.setBorder(new LineBorder(new Color(70, 130, 180)));
		passField_Contrasena.setBounds(329, 197, 145, 25);
		getContentPane().add(passField_Contrasena);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JButton btn_Contrasena = new JButton("\u00BFNo recuerda su contrase\u00F1a?");
		btn_Contrasena.setFocusPainted(false);
		btn_Contrasena.setContentAreaFilled(false);
		btn_Contrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Contrasena.setForeground(new Color(47, 79, 79));
		btn_Contrasena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Contrasena.setBorder(null);
		btn_Contrasena.setBounds(297, 234, 177, 21);
		getContentPane().add(btn_Contrasena);

	}
}
