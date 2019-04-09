package GUIs;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;

public class GUIOfertasAgregar extends JDialog {
	private JTextField txtFld_ID;

	/**
	 * Create the dialog.
	 */
	public GUIOfertasAgregar(Frame padre, boolean modal) {
		super(padre, modal);
		
		setBounds(100, 100, 266, 293);
		getContentPane().setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID de oferta");
		lbl_ID.setBounds(31, 30, 59, 14);
		getContentPane().add(lbl_ID);
		
		txtFld_ID = new JTextField();
		txtFld_ID.setColumns(10);
		txtFld_ID.setBounds(124, 27, 96, 20);
		getContentPane().add(txtFld_ID);
		
		JLabel lbl_FechaInicio = new JLabel("Fecha de inicio");
		lbl_FechaInicio.setBounds(31, 75, 73, 14);
		getContentPane().add(lbl_FechaInicio);
		
		JLabel lbl_FechaFin = new JLabel("Fecha de fin");
		lbl_FechaFin.setBounds(31, 117, 73, 14);
		getContentPane().add(lbl_FechaFin);
		
		JLabel lbl_Descuento = new JLabel("% de descuento");
		lbl_Descuento.setBounds(31, 155, 83, 14);
		getContentPane().add(lbl_Descuento);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(31, 209, 89, 23);
		getContentPane().add(btn_Aceptar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(131, 209, 89, 23);
		getContentPane().add(btn_Cancelar);
		
		JSpinner spnnr_Descuento = new JSpinner();
		spnnr_Descuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnnr_Descuento.setBounds(124, 152, 96, 20);
		getContentPane().add(spnnr_Descuento);
		
		JDateChooser dateChooser_Fin = new JDateChooser();
		dateChooser_Fin.setBounds(124, 111, 96, 20);
		getContentPane().add(dateChooser_Fin);
		
		JDateChooser dateChooser_Inicio = new JDateChooser();
		dateChooser_Inicio.setBounds(124, 69, 96, 20);
		getContentPane().add(dateChooser_Inicio);
		
		setLocationRelativeTo(padre);
	}
}