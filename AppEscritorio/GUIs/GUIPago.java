package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class GUIPago 
{
	JPanel pnlGeneral ,
	       pnlInfo    ;
	JLabel lblTitulo  ,
	       lblDetalles,
	       lblAdultos ,
	       lblMenores ,
	       lblBebes   ,
	       lblAsiento ,
	       lblClase   ,
	       lblNAdultos,
	       lblNMenores,
	       lblNBebes  ,
	       lblNAsiento,
	       lblNClase  ;
	JTextPane txtInfo ;
	Font   font       ;
	String datos      ;
	
	public JPanel crear(String pAdultos,String pMenores,String pBebe,String pAsiento,String pClase,String[] pTitulos,String[] pDatos)
	{
		datos      ="";
		pnlGeneral =new JPanel(            );
		pnlInfo    =new JPanel(            );
		lblTitulo  =new JLabel("Pago"      );
		lblNAdultos=new JLabel(            );
		lblNMenores=new JLabel(            );
		lblNBebes  =new JLabel(            );
		lblNClase  =new JLabel(            );
		lblNAsiento=new JLabel(            );
		lblAdultos =new JLabel("No.Adultos");
		lblMenores =new JLabel("No.Menores");
		lblBebes   =new JLabel("No.Bebes"  );
		lblClase   =new JLabel("Clase"     );
		lblAsiento =new JLabel("No.Asiento");
		lblDetalles=new JLabel("Detalles de la compra");
		txtInfo    =new JTextPane(         );
		font       =new Font  ("Segoe UI", Font.PLAIN, 15);
		lblNAdultos.setText(pAdultos+"");
		lblNMenores.setText(pMenores+"");
		lblNBebes  .setText(pBebe+""   );
		lblNClase  .setText(pClase     );
		lblNAsiento.setText(pAsiento   );
		
		
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
		//Formato del panel de la informacion
		pnlInfo.setLayout(new MigLayout("","[][]","[][]"));
		pnlInfo.setBackground(Color.WHITE);
		pnlInfo.setPreferredSize(new Dimension(600,400));
		pnlInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		lblDetalles.setFont(new Font("Segoe UI",Font.PLAIN,25));
		txtInfo.setText(datos);
		txtInfo.setPreferredSize(new Dimension(200,215));
		
		//Formato de los label
		lblAdultos .setFont(font);
		lblMenores .setFont(font);
		lblBebes   .setFont(font);
		lblNAdultos.setFont(font);
		lblNMenores.setFont(font);
		lblNBebes  .setFont(font);
		lblClase   .setFont(font);
		lblNClase  .setFont(font);
		lblAsiento .setFont(font);
		lblNAsiento.setFont(font);
		txtInfo    .setFont(font);
		
		//Se anexan los elementos al panel de información
		pnlInfo.add(lblDetalles,"cell 0 0,left,wrap");
		pnlInfo.add(txtInfo    ,"cell 2 1 0 6");
		pnlInfo.add(lblAdultos ,"cell 0 1,left");
		pnlInfo.add(lblNAdultos,"cell 0 1,right");
		pnlInfo.add(lblMenores ,"cell 0 2,left");
		pnlInfo.add(lblNMenores,"cell 0 2,right");
		pnlInfo.add(lblBebes   ,"cell 0 3,left");
		pnlInfo.add(lblNBebes  ,"cell 0 3,right");
		pnlInfo.add(lblAsiento ,"cell 0 4,left");
		pnlInfo.add(lblNAsiento,"cell 0 4,right");
		pnlInfo.add(lblClase   ,"cell 0 5,left");
		pnlInfo.add(lblNClase  ,"cell 0 5,right");
		
		
		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[grow][grow]","[grow][grow][grow]"));
		pnlGeneral.setBackground(Color.WHITE);
		
		pnlGeneral.add(lblTitulo,"cell 0 1,left"  );
		pnlGeneral.add(pnlInfo  ,"cell 1 1,center");
		
		return pnlGeneral;
	}

}
