package GUIs;

import java.awt.Color;import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class GUICheckIn 
{

	JPanel     pnlGeneral,
		       pnlCentral;
	JButton    btnBuscar ;
	JLabel     lblTitulo ,
		       lblImagen ,
		       lblTexto  ;
	JTextField txtBoleto ;
	
	public JPanel crear()
	{
		pnlGeneral= new JPanel    ();
		pnlCentral= new JPanel    ();
		btnBuscar = new JButton   ("Buscar");
		lblImagen = new JLabel    ();
		txtBoleto = new JTextField("",30);
		lblTexto  = new JLabel ("Número de boleto");
		lblTitulo = new JLabel ("Check-In",SwingConstants.CENTER);
		
		lblTitulo.setOpaque    (true       );
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont      (new Font ("Segoe UI", Font.PLAIN,70));
		lblTitulo.setForeground(new Color(0,88,143                 ));
		lblImagen.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnPase.png")));
		
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setOpaque                (false)     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setPreferredSize(new Dimension(100,50));
		btnBuscar.setBackground(Color.WHITE);
		
		lblTexto.setOpaque    (true);
		lblTexto.setBackground(new Color(0,102,177));
		lblTexto.setFont      (new Font ("Segoe UI", Font.PLAIN,40));
		lblTexto.setForeground(Color.WHITE);
		
		
		pnlCentral.setLayout       (new MigLayout("insets 0 20 10 20","[grow][]","[grow]40[grow][]"));
		pnlCentral.setBackground   (new Color    (0,102,177));
		pnlCentral.setPreferredSize(new Dimension(700,300));
		
		pnlCentral.add(lblImagen,"cell 1 1, center");
		pnlCentral.add(lblTexto ,"cell 0 0, span 1 2" );
		pnlCentral.add(txtBoleto,"cell 0 1, span 1 2");
		pnlCentral.add(btnBuscar,"cell 0 2, left");
		
		
		pnlGeneral.setLayout(new MigLayout("insets 10 80 10 10","[grow][grow][grow]","[grow][grow][grow]"));
		pnlGeneral.setVisible(true);
		pnlGeneral.setBackground(Color.WHITE);
		
		pnlGeneral.add(lblTitulo ,"cell 0 1"    );
		pnlGeneral.add(pnlCentral,"cell 1 1 0 0");
		return pnlGeneral;
	}
}
