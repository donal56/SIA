package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUIRutasAgregar extends JDialog {
	private JTextField txtFld_ID;
	private JTextField txtFld_Origen;
	private JTextField txtFld_Destino;
	private JTextField txtFld_EstadoRuta;

	/**
	 * Create the dialog.
	 */
	public GUIRutasAgregar(Frame padre, boolean modal) {
		super(padre, modal);
		
		setBounds(100, 100, 278, 293);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de ruta");
		lbl_ID.setBounds(36, 32, 49, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setBounds(129, 29, 96, 20);
		getContentPane().add(txtFld_ID);
		txtFld_ID.setColumns(10);
		
		JLabel lbl_Origen = new JLabel("Origen");
		lbl_Origen.setBounds(36, 75, 33, 14);
		getContentPane().add(lbl_Origen);
		
		txtFld_Origen = new JTextField();
		txtFld_Origen.setBounds(129, 72, 96, 20);
		getContentPane().add(txtFld_Origen);
		txtFld_Origen.setColumns(10);
		
		JLabel lbl_Destino = new JLabel("Destino");
		lbl_Destino.setBounds(36, 117, 37, 14);
		getContentPane().add(lbl_Destino);
		
		txtFld_Destino = new JTextField();
		txtFld_Destino.setBounds(129, 114, 96, 20);
		getContentPane().add(txtFld_Destino);
		txtFld_Destino.setColumns(10);
		
		JLabel lbl_EstadoRuta = new JLabel("Estado de la ruta");
		lbl_EstadoRuta.setBounds(36, 159, 83, 14);
		getContentPane().add(lbl_EstadoRuta);
		
		txtFld_EstadoRuta = new JTextField();
		txtFld_EstadoRuta.setBounds(129, 156, 96, 20);
		getContentPane().add(txtFld_EstadoRuta);
		txtFld_EstadoRuta.setColumns(10);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(36, 211, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(136, 211, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		setLocationRelativeTo(padre);
	}
}
