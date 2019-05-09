package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class GUIPago 
{
	JPanel  pnlGeneral    ,
	        pnlInfo       ,
	        pnlPago       ;
	JLabel  lblTitulo     ,
	        lblDetalles   ,
	        lblNTarjeta   ,
	        lblTitular    ,
	        lblFTitular   ,
	        lblFecha      ,
	        lblCCV        ,
	        lblImagen     ,
	        lblTotal      ;
	JButton btnEfectivo   ,
	        btnTarjeta    ,
	        btnPasajeros  ;
	JTextPane  txtInfo    ,
			   txtInfo2   ;
	Font       font       ,
	           font2      ;
	String     datos      ,
	           datos2     ,
	           clase      ;
	JTextField txtNTarjeta,
			   txtTitular ,
			   txtFTitular,
			   txtFecha   ,
			   txtCCV     ;
	
	public JPanel crear(String pAdultos,String pMenores,String pBebe,String pAsiento,String pClase,String[] pTitulos,String[] pDatos)
	{
		datos       ="";
		datos2      ="";
		clase       =pClase;
		pnlGeneral  =new JPanel (            );
		pnlInfo     =new JPanel (            );
		pnlPago     =new JPanel (            );
		lblImagen   =new JLabel (            );
		lblTotal    =new JLabel ();
		lblTitulo   =new JLabel ("Pago"      );
		lblDetalles =new JLabel ("Detalles de la compra");
		lblNTarjeta =new JLabel ("No.Tarjeta"         );
		lblTitular  =new JLabel ("Nombre titular"     );
		lblFTitular =new JLabel ("Fecha de Nacimiento");
		lblFecha    =new JLabel ("Fecha de expiración");
		lblCCV      =new JLabel ("CCV"       );
		btnEfectivo =new JButton("Efectivo"  );
		btnTarjeta  =new JButton("Tarjeta"   );
		btnPasajeros=new JButton("Agregar Pasajeros");
		txtInfo     =new JTextPane (          );
		txtInfo2    =new JTextPane (          );
		txtNTarjeta =new JTextField("",15     );
		txtTitular  =new JTextField("",15     );
		txtFTitular =new JTextField("",15     );
		txtFecha    =new JTextField("",15     );
		txtCCV      =new JTextField("",15     );
		font        =new Font  ("Segoe UI", Font.PLAIN, 20);
		font2       =new Font  ("Segoe UI", Font.PLAIN ,25);
		
		
		
		//Formato del titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		//Imagen de Dinero
		lblImagen.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnDinero.png")));
		
		//Almacenamiento de datos 
		for (int i = 1; i < pDatos.length-4; i++) 
		{
			datos+=pTitulos[i]+": "+pDatos[i]+"\n";
		}
		datos2="No.Adultos: "+pAdultos+"\nNo.Menores: "+pMenores+"\nNo.Bebes: "+pBebe+"\nClase: "+pClase;
		//Formato del panel de la informacion
		pnlInfo.setLayout(new MigLayout("","[]20[]","[]20[grow]"));
		pnlInfo.setBackground(Color.WHITE);
		pnlInfo.setPreferredSize(new Dimension(400,380));
		pnlInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		lblDetalles.setFont(new Font("Segoe UI",Font.PLAIN,25));
		txtInfo .setText(datos );
		txtInfo2.setText(datos2);
		txtInfo .setEditable(false);
		txtInfo2.setEditable(false);
		//txtInfo.setPreferredSize(new Dimension(200,100));
		
		//Formato de los label
		txtInfo2   .setFont(font);
		txtInfo    .setFont(font);
		
		lblNTarjeta.setFont(font2);
		lblTitular .setFont(font2);
		lblFecha   .setFont(font2);
		lblCCV     .setFont(font2);
		lblFTitular.setFont(font2);
		
		txtInfo2   .setForeground(Color.BLACK);
		txtInfo    .setForeground(Color.BLACK);
		lblNTarjeta.setForeground(Color.WHITE);
		lblTitular .setForeground(Color.WHITE);
		lblFecha   .setForeground(Color.WHITE);
		lblCCV     .setForeground(Color.WHITE);
		lblFTitular.setForeground(Color.WHITE);
		//pnlPago.setFont(font);
		
		//Label del monto total
		if(clase.equals("Vip"))
		{
			lblTotal.setText("Total: $"+pDatos[8].toString());
			pnlInfo   .revalidate();
			pnlGeneral.revalidate();
		}else if(clase.equals("Ejecutivo"))
		{
			lblTotal.setText("Total: $"+pDatos[9].toString());
		}
		else
		{
			lblTotal.setText("Total: $"+pDatos[10].toString());
		}
		
		lblTotal.setFont(new Font("Segoe UI",Font.BOLD,30));
		//Se anexan los elementos al panel de información
		
		pnlInfo.add(lblDetalles,"cell 0 0 2 0,left,wrap");
		pnlInfo.add(txtInfo2   ,"cell 0 1");
		pnlInfo.add(txtInfo    ,"wrap");
		pnlInfo.add(lblTotal);

		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[][grow]","[grow][grow][grow]"));
		pnlGeneral.setBackground(Color.WHITE);
		
		
		//Formato del metodo de pago tarjeta
		pnlPago.setLayout(new MigLayout());
		pnlPago.setBackground(new Color(53,155,219));
		
		pnlPago.add(lblNTarjeta,"wrap");
		pnlPago.add(txtNTarjeta,"wrap");
		pnlPago.add(lblTitular ,"wrap");
		pnlPago.add(txtTitular ,"wrap");
		pnlPago.add(lblFTitular,"wrap");
		pnlPago.add(txtFTitular,"wrap");
		pnlPago.add(lblFecha   ,"wrap");
		pnlPago.add(txtFecha   ,"wrap");
		pnlPago.add(lblCCV     ,"wrap");
		pnlPago.add(txtCCV     ,"wrap");
		
		pnlPago.setVisible(false);
		
		pnlGeneral.add(lblTitulo   ,"cell 0 0,left" );
		pnlGeneral.add(pnlInfo     ,"cell 1 1,left" );
		pnlGeneral.add(btnEfectivo ,"cell 1 0,right");
		pnlGeneral.add(btnTarjeta  ,"cell 1 0"      );
		pnlGeneral.add(btnPasajeros,"cell 1 0,wrap" );
		pnlGeneral.add(pnlPago     ,"cell 1 1");
		pnlGeneral.add(lblImagen   ,"cell 1 1");
		
		
		btnTarjeta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlPago.setVisible(true);
				pnlGeneral.revalidate();
			}
		});
		btnEfectivo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlPago.setVisible(false);
			}
		});
		
		return pnlGeneral;
	}

}
