package GUIs;

import java .awt.Color;
import java.awt.Component;
import java .awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import Otros.Metodos;
import Otros.JPanelBackground;
import net.miginfocom.swing.MigLayout;

public class GUIAsientos 
{
	String[]  datos       ;
	JPanel    pnlGeneral  , //Panel que contiene todo
	          pnlSeleccion; //Panel donde se eligen numeros de pasajeros y tipos de pasajeros
	JPanelBackground pnlAsientos ; //Panel donde se colocan los asientos
	Container contenedor  ;
	JTextPane txtDatos    ;
	JLabel    lblTitulo   ;
	String    info        ;
	String [] titulos     ;
	JButton   btnMas      ,
			  btnMenos    ;
	Metodos   metodos     ;
	Image icnAvion    ;
	public GUIAsientos(String[] pDatos,String[] pTitulos)
	{
		datos  =pDatos;
		titulos=pTitulos;
	}
	public JPanel crear()
	{
		//Segmento donde se inicializan
		pnlGeneral  =new JPanel   ();
		pnlSeleccion=new JPanel   ();
		pnlAsientos =new JPanelBackground   ();
		contenedor  =new Container();
		txtDatos    =new JTextPane();
		btnMas      =new JButton  ();
		btnMenos    =new JButton  ();
		metodos     =new Metodos  ();
		lblTitulo   =new JLabel   ("Asientos");
		info        ="";
		
		//icnAvion=new ImageIcon(GUIPrincipal.class.getResource("/img/ModeloAvion.png"      ));
		
		//Segmento de formato de titulo y color del panel
		pnlGeneral.setBackground(Color.WHITE);
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		//Se almacenan los datos en un String

		for (int i = 0; i < datos.length; i++) 
		{
			info+="    "+titulos[i]+": "+datos[i]+"\n";
		}
		//Se le da formato a la información
		txtDatos.setText(info);
		txtDatos.setEditable(false);
		txtDatos.setPreferredSize(new Dimension(250,200));
		txtDatos.setForeground(Color.WHITE);
		txtDatos.setBackground(new Color(0,88,143));
		txtDatos.setFont      (new Font("Segoe UI", Font.PLAIN, 15));
		
		//Se asigna layout al panel General
		pnlGeneral.setLayout(new MigLayout("insets 10 10 10 10","[grow][grow]",""));
		
		//Formato del panel de selección
		pnlAsientos.setLayout(new MigLayout("insets 60 170 10 10"));
		pnlAsientos.setPreferredSize(new Dimension(560, 900));
		pnlAsientos.setBackground(new ImageIcon(GUIPrincipal.class.getResource("/img/ModeloAvion.png"      )));
		pnlAsientos.add(metodos.crearAsientos(6,20)); //Tamaño de la matriz
		pnlAsientos.setAutoscrolls(true);
		
		pnlGeneral.add(lblTitulo,"wrap");
		pnlGeneral.add(txtDatos );
		pnlGeneral.add(pnlAsientos,"cell 1 0 0 2");
		
		return pnlGeneral;
	}
}
