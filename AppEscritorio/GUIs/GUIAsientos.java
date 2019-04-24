package GUIs;

import java .awt.Color;
import java.awt.Component;
import java .awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class GUIAsientos 
{
	String[]  datos       ;
	JPanel    pnlGeneral  , //Panel que contiene todo
	          pnlSeleccion; //Panel donde se eligen numeros de pasajeros y tipos de pasajeros
	Container contenedor  ;
	JTextPane txtDatos    ;
	JLabel    lblTitulo   ;
	String    info        ;
	String [] titulos     ;
	JButton   btnMas      ,
			  btnMenos    ;
	public GUIAsientos(String[] pDatos,String[] pTitulos)
	{
		datos  =pDatos;
		titulos=pTitulos;
	}
	public JPanel crear()
	{
		//Segmento donde se inicializan
		pnlGeneral=new JPanel   ();
		contenedor=new Container();
		txtDatos  =new JTextPane();
		btnMas    =new JButton  ();
		btnMenos  =new JButton  ();
		lblTitulo =new JLabel   ("Asientos");
		info      ="";
		
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
		pnlGeneral.setLayout(new MigLayout("insets 10 10 10 10","",""));
		
		//Formato de los botones
		
		
		pnlGeneral.add(lblTitulo,"cell 0 0, wrap");
		pnlGeneral.add(txtDatos );
		
		return pnlGeneral;
	}
}
