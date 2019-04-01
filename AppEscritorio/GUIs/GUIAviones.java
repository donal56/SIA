package GUIs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Otros.Metodos;

public class GUIAviones //extends Ventana
{

	Container contenedor;
	JPanel    pnl       ;
	JButton   b         ; 
	Metodos   metodos   ;
	JButton   c         ;
	JLabel    lblTitulo ;
	

	public JPanel crear() 
	{
		contenedor=new Container();
		metodos   =new Metodos  ();
		pnl       =new JPanel   ();
		lblTitulo =new JLabel   ();
		c         =new JButton  ("Aqui va la tabla");

		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setText      ("Aviones")                           ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		
		pnl.setLayout (new BorderLayout());
		pnl.setVisible(true)              ;
		pnl.setBackground(Color.WHITE);
		
		pnl.add(lblTitulo,BorderLayout.NORTH);
		pnl.add(metodos.crearBotones(true,false,true),BorderLayout.EAST);
		pnl.add(c,BorderLayout.SOUTH)                    ;

		return pnl;
	}

}
