package GUIs;

/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Otros.Metodos;*/

public class GUIDocumentos 
{
	/*Container contenedor;
	JPanel    pnlGeneral,
	          pnlFiltro ,
	          pnlTitulo ;
	JButton   b         ,
	          btnBuscar ;
	Metodos   metodos   ;
	JButton   c         ;
	JLabel    lblTitulo ;
	

	public JPanel crear() 
	{
		contenedor=new Container();
		metodos   =new Metodos  ();
		pnlGeneral=new JPanel   ();
		pnlFiltro =new JPanel   ();
		pnlTitulo =new JPanel   ();
		lblTitulo =new JLabel   ();
		c         =new JButton  ("Aqui va la tabla");
		btnBuscar =new JButton  ("Buscar");
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setText      ("Aviones")                           ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new BoxLayout(pnlFiltro,BoxLayout.X_AXIS));
		pnlTitulo.setLayout(new BorderLayout()                       );
		
		
		//Elementos del filtrado
		JLabel lblID        = new JLabel("ID   "      );
		JLabel lblModelo    = new JLabel("Modelo  "   );
		JLabel lblCapacidad = new JLabel("Capacidad  ");
		JTextField txtID    = new JTextField("");
		JTextField txtMod   = new JTextField("");
		JTextField txtCap   = new JTextField("");
		
		//Formato de los label
		lblID       .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblModelo   .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblCapacidad.setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		
		//Boton buscar
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setOpaque                (false)     ;
		btnBuscar.setContentAreaFilled     (false)     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER)                         ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setFont                  (new Font("Segoe UI", Font.PLAIN, 18          ));
		btnBuscar.setPressedIcon           (new ImageIcon(GUIPrincipal.class.getResource("/img/LoginBotonAceptar_Pres.png")));
		btnBuscar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/LoginBotonAceptar.png"     )));
			
		//Se agregan al panel
		pnlFiltro.add(lblID       );
		pnlFiltro.add(txtID       );
		pnlFiltro.add(lblModelo   );
		pnlFiltro.add(txtMod      );
		pnlFiltro.add(lblCapacidad);
		pnlFiltro.add(txtCap      );
		pnlFiltro.add(btnBuscar   );
		pnlFiltro.setBackground(Color.WHITE);
		
		//Agregamos al panel titulo el label del tituolo y los filtros
		pnlTitulo.add(lblTitulo,BorderLayout.NORTH );
		pnlTitulo.add(pnlFiltro,BorderLayout.CENTER);
		
		//Formato del panel general
		pnlGeneral.setLayout (new BorderLayout());
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		//Se agregan los elementos al panel general
		pnlGeneral.add(pnlTitulo,BorderLayout.NORTH)                           ;
		pnlGeneral.add(metodos.crearBotones(true,false,true),BorderLayout.EAST);
		pnlGeneral.add(c,BorderLayout.CENTER)                                  ;

		return pnlGeneral;
	}*/
}
