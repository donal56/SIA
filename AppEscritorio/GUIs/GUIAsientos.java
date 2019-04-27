package GUIs;

import java .awt.Color;
import java.awt.Component;
import java .awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Otros.JPanelBackground;
import Otros.Metodos;
import net.miginfocom.swing.MigLayout;

public class GUIAsientos 
{
	String[]  datos         ;
	JPanel    pnlGeneral    , //Panel que contiene todo
	          pnlSeleccion  , //Panel donde se eligen numeros de pasajeros y tipos de pasajeros
	          pnlAvion      ;
	Container contenedor    ;
	JTextPane txtDatos      ;
	JLabel    lblTitulo     ,
			  lblPasajeros  ,
			  lblMenores    ,
			  lblAdultos    ,
			  lblBebes      ,
			  lblAsiento    ,
			  lblClase      ;
	String    info          ;
	String [] titulos       ;
	JButton   btnMas1       ,
			  btnMenos1     ,
			  btnMas2       ,
			  btnMenos2     ,
			  btnMas3       ,
			  btnMenos3     ;
	Metodos   metodos       ;
	Image     icnAvion      ;
	Integer   ctdAdultos    ,
		      ctdMenores    ,
		      ctdBebes      ;
	JScrollPane spAsientos  ;
	JTextField txtPasajeros ,
			   txtNAdultos  ,
			   txtNMenores  ,
			   txtNBebes    ,
			   txtNAsiento  ,
			   txtClase     ;
	JButton    btnSiguiente ;
	JPanelBackground pnlAsientos ; //Panel donde se colocan los asientos, se modifico para poder poder tener de fondo la imagen del avion , 
	                               //la clase JPanelBackground se encuentra en el pack Otros
	JButton[][] botones;
	int contador=0;
	public GUIAsientos(String[] pDatos,String[] pTitulos)
	{
		datos  =pDatos;
		titulos=pTitulos;
	}
	public JPanel crear()
	{
		//Segmento donde se inicializan
		info         ="";
		ctdAdultos   =0;
		ctdMenores   =0;
		ctdBebes     =0;
		pnlGeneral   =new JPanel     (  );
		pnlSeleccion =new JPanel     (  );
		pnlAvion     =new JPanel     (  );
		contenedor   =new Container  (  );
		txtDatos     =new JTextPane  (  );
		btnMas1      =new JButton    (  );
		btnMas2      =new JButton    (  );
		btnMas3      =new JButton    (  );
		btnMenos1    =new JButton    (  );
		btnMenos2    =new JButton    (  );
		btnMenos3    =new JButton    (  );
		metodos      =new Metodos    (  );
		txtPasajeros =new JTextField (10);
		txtNAdultos  =new JTextField ( 4);
		txtNMenores  =new JTextField ( 4);
		txtNBebes    =new JTextField ( 4);
		txtNAsiento  =new JTextField ( 5);
		txtClase     =new JTextField ( 5);
		spAsientos   =new JScrollPane(  );
		btnSiguiente =new JButton("Siguiente"  );
		pnlAsientos  =new JPanelBackground    ();
		lblTitulo    =new JLabel("Asientos"    );
		lblPasajeros =new JLabel("No.Pasajeros");
		lblMenores   =new JLabel("Menores"     );
		lblAdultos   =new JLabel("Adultos"     );
		lblBebes     =new JLabel("Bebes"       );
		lblAsiento   =new JLabel("No.Asiento"  );
		lblClase     =new JLabel("Clase"       );
		
		//Segmento de formato de titulo y color del panel
		lblTitulo.setOpaque     (true)                                ;
		pnlGeneral.setBackground(Color.WHITE)						  ;
		lblTitulo.setBackground (Color.WHITE)                         ;
		lblTitulo.setForeground (new Color(0,88,143))                 ;
		lblTitulo.setFont       (new Font("Segoe UI", Font.PLAIN, 80));
		
		//Se almacenan los datos en un String

		for (int i = 0; i < datos.length; i++) 
		{
			info+="    "+titulos[i]+": "+datos[i]+"\n";
		}
		//Se le da formato a la información
		txtDatos.setText         (info                                );
		txtDatos.setEditable     (false                               );
		txtDatos.setForeground   (Color.BLACK                         );
		txtDatos.setBackground   (new Color(80,200,243)               );
		txtDatos.setPreferredSize(new Dimension(280,215)              );
		txtDatos.setFont         (new Font("Segoe UI", Font.PLAIN, 20));
		
		//Se asigna layout al panel General
		pnlGeneral.setLayout(new MigLayout("insets 10 10 10 10","[grow][grow]",""));
		
		//Formato de los botones de mas y menos
		btnMas1  .setBorder(null);
		btnMenos1.setBorder(null);
		btnMas2  .setBorder(null);
		btnMenos2.setBorder(null);
		btnMas3  .setBorder(null);
		btnMenos3.setBorder(null);
		btnMas1  .setOpaque(false);
		btnMenos1.setOpaque(false);
		btnMas2  .setOpaque(false);
		btnMenos2.setOpaque(false);
		btnMas3  .setOpaque(false);
		btnMenos3.setOpaque(false);
		btnMas1  .setContentAreaFilled(false);
		btnMenos1.setContentAreaFilled(false);
		btnMas2  .setContentAreaFilled(false);
		btnMenos2.setContentAreaFilled(false);
		btnMas3  .setContentAreaFilled(false);
		btnMenos3.setContentAreaFilled(false);
		btnMas1  .setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMas.png"  )));
		btnMenos1.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMenos.png")));
		btnMas2  .setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMas.png"  )));
		btnMenos2.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMenos.png")));
		btnMas3  .setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMas.png"  )));
		btnMenos3.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnMenos.png")));
		
		//Formato de los elementos para elegir numero de pasajeros
		lblPasajeros.setFont(new Font("Segoe UI",Font.PLAIN,20));
		lblAdultos  .setFont(new Font("Segoe UI",Font.PLAIN,20));
		lblMenores  .setFont(new Font("Segoe UI",Font.PLAIN,20));
		lblBebes    .setFont(new Font("Segoe UI",Font.PLAIN,20));
		lblAsiento  .setFont(new Font("Segoe UI",Font.PLAIN,20));
		lblClase    .setFont(new Font("Segoe UI",Font.PLAIN,20));
		
		txtPasajeros.setEditable(false);
		txtNAdultos .setEditable(false);
		txtNMenores .setEditable(false);
		txtNBebes   .setEditable(false);
		txtNAsiento .setEditable(false);
		txtClase    .setEditable(false);
		
		txtPasajeros.setFont(new Font("Segoe UI",Font.PLAIN,20));
		txtNAdultos .setFont(new Font("Segoe UI",Font.PLAIN,20));
		txtNMenores .setFont(new Font("Segoe UI",Font.PLAIN,20));
		txtNBebes   .setFont(new Font("Segoe UI",Font.PLAIN,20));
		txtNAsiento .setFont(new Font("Segoe UI",Font.PLAIN,20));
		txtClase    .setFont(new Font("Segoe UI",Font.PLAIN,20));
		
		//Formato del panel de seleccion de pasajeros 
		pnlSeleccion.setLayout(new MigLayout("","[grow][grow][grow]20[grow][grow][grow]20[grow][grow][grow]","[]10[][]10[]10[]"));
		pnlSeleccion.setBackground   (Color.WHITE);
		pnlSeleccion.setPreferredSize(new Dimension(350, 300));
		
		pnlSeleccion.add(lblPasajeros,"span 4, right"     );
		pnlSeleccion.add(txtPasajeros,"span 5, left, wrap" );
		
		pnlSeleccion.add(lblAdultos,"span 3,center");
		pnlSeleccion.add(lblMenores,"span 3,center");
		pnlSeleccion.add(lblBebes  ,"span 3,center, wrap" );
		
		pnlSeleccion.add(btnMenos1     ,"cell 0 2");
		pnlSeleccion.add(txtNAdultos   ,"cell 1 2");
		pnlSeleccion.add(btnMas1       ,"cell 2 2");
		pnlSeleccion.add(btnMenos2     ,"cell 3 2");
		pnlSeleccion.add(txtNMenores   ,"cell 4 2");
		pnlSeleccion.add(btnMas2       ,"cell 5 2");
		pnlSeleccion.add(btnMenos3     ,"cell 6 2");
		pnlSeleccion.add(txtNBebes     ,"cell 7 2");
		pnlSeleccion.add(btnMas3       ,"cell 8 2");
		
		pnlSeleccion.add(lblAsiento    ,"cell 1 3,span 3, center");
		pnlSeleccion.add(txtNAsiento   ,"span 3,center");
		
		pnlSeleccion.add(lblClase,"cell 1 4, span 3,center");
		pnlSeleccion.add(txtClase,"span 3,center");
		
		
		txtNAdultos.setText(ctdAdultos.toString());
		txtNMenores.setText(ctdMenores.toString());
		txtNBebes  .setText(ctdBebes  .toString());
		
		//Botones de sumar y restar
		btnMas1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ctdAdultos++;
				txtNAdultos.setText(ctdAdultos.toString());
				sumar();
			}
		});
		btnMas2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ctdMenores++;
				txtNMenores.setText(ctdMenores.toString());
				sumar();
			}
		});
		btnMas3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ctdBebes++;
				txtNBebes.setText(ctdBebes.toString());
				sumar();
			}
		});
		btnMenos1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ctdAdultos>0)
				{
					ctdAdultos--;
					txtNAdultos.setText(ctdAdultos.toString());
					sumar();
				}
			}
		});
		btnMenos2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ctdMenores>0)
				{
					ctdMenores--;
					txtNMenores.setText(ctdMenores.toString());
					sumar();
				}
			}
		});
		btnMenos3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ctdBebes>0)
				{
					ctdBebes--;
					txtNBebes.setText(ctdBebes.toString());
					sumar();
				}
			}
		});
	    
		
		//Formato del panel de asientos
		pnlAvion=metodos.crearAsientos(6,25,250); //Filas,Columnas,Maximo de lugares
		pnlAsientos.setLayout       (new MigLayout("insets 50 210 10 10","[][]","[][][]"));
		pnlAsientos.setAutoscrolls  (true);
		pnlAsientos.add             (pnlAvion); 
		pnlAsientos.setPreferredSize(pnlAvion.getPreferredSize());
		pnlAsientos.setBackground   (new ImageIcon(GUIPrincipal.class.getResource("/img/ModeloAvion.png"      )));

		//Action listener de los botones de asientos
		try {
			metodos.setActionBotones(txtNAsiento,txtClase);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Formato del boton siguiente
		btnSiguiente.setPreferredSize(new Dimension(100,40));
		btnSiguiente.setBackground(new Color(80,200,243));
		btnSiguiente.setForeground(Color.BLACK);
		btnSiguiente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		//Formato del JScrollPane
		spAsientos.setBorder(null);
		spAsientos.setOpaque(false);
		spAsientos.setBackground(Color.WHITE);
		spAsientos.setViewportView(pnlAsientos);
		spAsientos.setPreferredSize(new Dimension(710, 900));
		
		pnlGeneral.add(lblTitulo   ,"cell 0 0, left");
		pnlGeneral.add(pnlSeleccion,"cell 0 1, left");
		pnlGeneral.add(txtDatos    ,"cell 0 2, left");
		pnlGeneral.add(spAsientos  ,"cell 1 0 0 3,wrap" );
		pnlGeneral.add(btnSiguiente,"cell 0 2, right");
		
		return pnlGeneral;
	}
	public void sumar()
	{
		txtPasajeros.setText(ctdAdultos+ctdMenores+ctdBebes+" personas");
	}
	
}
