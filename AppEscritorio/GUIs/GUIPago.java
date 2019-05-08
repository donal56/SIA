package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class GUIPago 
{
	JPanel  pnlGeneral  ,
	        pnlInfo     ;
	JLabel  lblTitulo   ,
	        lblDetalles ,
	        lblAdultos  ,
	        lblMenores  ,
	        lblBebes    ,
	        lblAsiento  ,
	        lblClase    ,
	        lblNAdultos ,
	        lblNMenores ,
	        lblNBebes   ,
	        lblNAsiento ,
	        lblNClase   ;
	JButton btnEfectivo ,
	        btnTarjeta  ,
	        btnPasajeros;
	JTextPane txtInfo   ,
			  txtInfo2  ;
	Font   font         ;
	String datos        ,
	       datos2       ;
	
	public JPanel crear(String pAdultos,String pMenores,String pBebe,String pAsiento,String pClase,String[] pTitulos,String[] pDatos)
	{
		datos       ="";
		datos2      ="";
		pnlGeneral  =new JPanel (            );
		pnlInfo     =new JPanel (            );
		lblTitulo   =new JLabel ("Pago"      );
		lblNAdultos =new JLabel (            );
		lblNMenores =new JLabel (            );
		lblNBebes   =new JLabel (            );
		lblNClase   =new JLabel (            );
		lblNAsiento =new JLabel (            );
		lblAdultos  =new JLabel ("No.Adultos");
		lblMenores  =new JLabel ("No.Menores");
		lblBebes    =new JLabel ("No.Bebes"  );
		lblClase    =new JLabel ("Clase"     );
		lblAsiento  =new JLabel ("No.Asiento");
		lblDetalles =new JLabel ("Detalles de la compra");
		btnEfectivo =new JButton("Efectivo"  );
		btnTarjeta  =new JButton("Tarjeta"   );
		btnPasajeros=new JButton("Agregar Pasajeros");
		txtInfo     =new JTextPane(          );
		txtInfo2    =new JTextPane(          );
		font        =new Font  ("Segoe UI", Font.PLAIN, 15);
		
		
		
		//Formato del titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		//Almacenamiento de datos 
		for (int i = 1; i < pDatos.length-4; i++) 
		{
			datos+=pTitulos[i]+": "+pDatos[i]+"\n";
		}
		datos2="No.Adultos: "+pAdultos+"\nNo.Menores: "+pMenores+"\nNo.Bebes: "+pBebe+"\nClase: "+pClase;
		//Formato del panel de la informacion
		pnlInfo.setLayout(new MigLayout("","[][]","[]20[grow]"));
		pnlInfo.setBackground(Color.WHITE);
		pnlInfo.setPreferredSize(new Dimension(300,250));
		pnlInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		lblDetalles.setFont(new Font("Segoe UI",Font.PLAIN,25));
		txtInfo .setText(datos );
		txtInfo2.setText(datos2);
		txtInfo .setEditable(false);
		txtInfo2.setEditable(false);
		//txtInfo.setPreferredSize(new Dimension(200,100));
		
		//Formato de los label
		txtInfo2.setFont(font);
		txtInfo .setFont(font);
		
		//Se anexan los elementos al panel de información
		pnlInfo.add(lblDetalles,"cell 0 0 2 0,left,wrap");
		pnlInfo.add(txtInfo2   ,"cell 0 1");
		pnlInfo.add(txtInfo    );

		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[][grow]","[grow][grow][grow]"));
		pnlGeneral.setBackground(Color.WHITE);
		
		pnlGeneral.add(lblTitulo   ,"cell 0 0,left"  );
		pnlGeneral.add(pnlInfo     ,"cell 1 1,left");
		pnlGeneral.add(btnEfectivo ,"cell 1 0,right");
		pnlGeneral.add(btnTarjeta  ,"cell 1 0");
		pnlGeneral.add(btnPasajeros,"cell 1 0");
		
		return pnlGeneral;
	}

}
