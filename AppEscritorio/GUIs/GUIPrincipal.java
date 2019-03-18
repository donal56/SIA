package GUIs;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Otros.Ventana;


/*Esta GUI es la que aloja el menu principal de la aplicacción de escritorio, se extiende de una clase Ventana donde le doy formato a la 
ventana que se creara por medio del metodo crear*/
public class GUIPrincipal extends Ventana
{

	Container contenedor    ;
	JButton   btnVuelos     , //Botones
	          btnReservas   ,
	          btnCheckin    ,
	          btnAviones    ,
	          btnRutas      ,
	          btnCancelar   ,
	          btnDocumetos  ,
	          btnOfertas    ,
	          btnDevolucion ,
	          btnReportes   ;
	ImageIcon icnVuelos     , //Iconos
		      icnReservas   ,
		      icnCheckin    ,
		      icnAviones    ,
		      icnRutas      ,
		      icnCancelar   , 
		      icnDocumentos ,
		      icnOfertas    ,
		      icnDevolucion ,
		      icnReportes   ;
	
	public GUIPrincipal()
	{
		super("Principal",1366,760,true);
	}

	public void crear() 
	{
		//Formato del contenedor
		contenedor =this.getContentPane            ();
		contenedor.setLayout    (null);
		contenedor.setBackground(Color.WHITE        ); 
		
		
		//Aquí se declaran los botones 
		btnVuelos     =new JButton        ();
		btnReservas   =new JButton        ();
		btnCheckin    =new JButton        ();
		btnAviones    =new JButton        ();
		btnRutas      =new JButton        ();
		btnCancelar   =new JButton        ();
		btnDocumetos  =new JButton        ();
		btnOfertas    =new JButton        ();
		btnDevolucion =new JButton        ();
		btnReportes   =new JButton        ();
		
		//Aquí se crean todos los iconos
		icnVuelos       =new ImageIcon ("img/IconoVuelos.png"      );
		icnReservas     =new ImageIcon ("img/IconoReservas.png"    );
		icnCheckin      =new ImageIcon ("img/IconoCheck-In.png"    );
		icnAviones      =new ImageIcon ("img/IconoAviones.png"	   );
		icnRutas        =new ImageIcon ("img/IconoRutas.png"       );
		icnCancelar     =new ImageIcon ("img/IconoCancelar.png"    );
		icnDocumentos   =new ImageIcon ("img/IconoDocumentos.png"  );
		icnOfertas      =new ImageIcon ("img/IconoOfertas.png"     );
		icnDevolucion   =new ImageIcon ("img/IconoDevolucion.png"  );
		icnReportes     =new ImageIcon ("img/IconoReportes.png"    );
		
		//Aqui se agregan los iconos a los botones
		btnVuelos    .setIcon(icnVuelos    );
		btnReservas  .setIcon(icnReservas  );
		btnCheckin   .setIcon(icnCheckin   );
		btnAviones   .setIcon(icnAviones   );
		btnRutas     .setIcon(icnRutas     );
		btnCancelar  .setIcon(icnCancelar  );
		btnDocumetos .setIcon(icnDocumentos);
		btnOfertas   .setIcon(icnOfertas   );
		btnDevolucion.setIcon(icnDevolucion);
		btnReportes  .setIcon(icnReportes  );
		
		//Aqui se quitan los bordes de los botones
		btnVuelos    .setBorderPainted(false);
		btnReservas  .setBorderPainted(false);
		btnCheckin   .setBorderPainted(false);
		btnAviones   .setBorderPainted(false);
		btnRutas     .setBorderPainted(false);
		btnCancelar  .setBorderPainted(false);
		btnDocumetos .setBorderPainted(false);
		btnOfertas   .setBorderPainted(false);
		btnDevolucion.setBorderPainted(false);
		btnReportes  .setBorderPainted(false);
		

		//Aquí se agregan al contenedor
		
		contenedor.add(btnVuelos    );
		contenedor.add(btnReservas  );
		contenedor.add(btnCheckin   );
		contenedor.add(btnAviones   );
		contenedor.add(btnRutas     );
		contenedor.add(btnCancelar  );
		contenedor.add(btnDocumetos );
		contenedor.add(btnOfertas   );
		contenedor.add(btnDevolucion);
		contenedor.add(btnReportes  );
		
		//Aquí le damos posición a los botones
		//Fila de arriba
		btnVuelos  .setBounds(120 ,100,200,246);
		btnReservas.setBounds(340 ,100,200,246);
		btnCheckin .setBounds(560 ,100,200,246);
		btnAviones .setBounds(790 ,100,200,246);
		btnRutas   .setBounds(1004,100,200,246);
		//Fila de abajo
		btnCancelar   .setBounds(120 ,366,200,246 );
		btnDocumetos  .setBounds(340 ,366,200,246 );
		btnOfertas    .setBounds(560 ,366,200,246 );
		btnDevolucion .setBounds(790 ,366,200,246 );
		btnReportes   .setBounds(1004,366,200,246 );
		
		//Aqui se le dara acciones a los botones
		btnVuelos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve");
			}
		});
		btnReservas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x2");
			}
		});
		btnCheckin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x3");
			}
		});
		btnAviones.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x4");
			}
		});
		btnRutas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x5");
			}
		});
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x6");
			}
		});
		btnDocumetos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x7");
			}
		});
		btnOfertas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x8");
			}
		});
		btnDevolucion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x9");
			}
		});
		btnReportes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Si sirve x10");
			}
		});
	}
}
