package GUIs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class GUIDevolución 
{
	JPanel     pnlGeneral,
	           pnlCentral;
	JButton    btnCambio    ,
	           btnDevolucion;
	JLabel     lblTitulo ,
	           lblImagen ,
	           lblTexto  ;
	JTextField txtBoleto ;
	
	public JPanel crear()
	{
	pnlGeneral   = new JPanel    ();
	pnlCentral   = new JPanel    ();
	btnCambio    = new JButton   ("Cambiar");
	lblImagen    = new JLabel    ();
	txtBoleto    = new JTextField("",30);
	lblTexto     = new JLabel    ("Número de boleto");
	btnDevolucion= new JButton   ("Devolucion");
	lblTitulo    = new JLabel    ("Devolución",SwingConstants.CENTER);
	
	lblTitulo.setOpaque    (true       );
	lblTitulo.setBackground(Color.WHITE);
	lblTitulo.setFont      (new Font ("Segoe UI", Font.PLAIN,70));
	lblTitulo.setForeground(new Color(0,88,143                 ));
	lblImagen.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnPase.png")));
	
	btnCambio.setBorder                (null )     ;
	btnCambio.setOpaque                (false)     ;
	btnCambio.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCambio.setPreferredSize(new Dimension(100,50));
	btnCambio.setBackground(Color.WHITE);
	
	btnDevolucion.setBorder                (null )     ;
	btnDevolucion.setOpaque                (false)     ;
	btnDevolucion.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnDevolucion.setPreferredSize(new Dimension(100,50));
	btnDevolucion.setBackground(Color.WHITE);
	
	lblTexto.setOpaque    (true);
	lblTexto.setBackground(new Color(0,102,177));
	lblTexto.setFont      (new Font ("Segoe UI", Font.PLAIN,40));
	lblTexto.setForeground(Color.WHITE);
	
	
	pnlCentral.setLayout       (new MigLayout("insets 0 20 10 20","[grow][]","[grow]40[grow][]"));
	pnlCentral.setBackground   (new Color    (0,102,177));
	pnlCentral.setPreferredSize(new Dimension(700,320));
	
	pnlCentral.add(lblImagen,"cell 1 1, center");
	pnlCentral.add(lblTexto ,"cell 0 0, span 1 2" );
	pnlCentral.add(txtBoleto,"cell 0 1, span 1 2");
	pnlCentral.add(btnCambio,"cell 0 2, left");
	pnlCentral.add(btnDevolucion, "cell 0 2");
	
	
	pnlGeneral.setLayout(new MigLayout("insets 10 80 10 10","[grow][grow][grow]","[grow][grow][grow]"));
	pnlGeneral.setVisible(true);
	pnlGeneral.setBackground(Color.WHITE);
	
	pnlGeneral.add(lblTitulo ,"cell 0 1"    );
	pnlGeneral.add(pnlCentral,"cell 1 1 0 0");
	return pnlGeneral;
}
}
