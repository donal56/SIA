package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	Font   font       ;
	
	public JPanel crear(String pAdultos,String pMenores,String pBebe,String pAsiento,String pClase)
	{
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
		
		//Formato del panel de la informacion
		pnlInfo.setLayout(new MigLayout("","[][]","[][]"));
		pnlInfo.setBackground(Color.WHITE);
		pnlInfo.setPreferredSize(new Dimension(600,400));
		pnlInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		lblDetalles.setFont(new Font("Segoe UI",Font.PLAIN,25));
		
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
		
		//Se anexan los elementos al panel de información
		pnlInfo.add(lblDetalles,"cell 0 0,left,wrap");
		pnlInfo.add(lblAdultos ,"cell 0 1,left");
		pnlInfo.add(lblNAdultos,"wrap");
		pnlInfo.add(lblMenores ,"left");
		pnlInfo.add(lblNMenores,"wrap");
		pnlInfo.add(lblBebes   ,"left");
		pnlInfo.add(lblNBebes  ,"wrap");
		pnlInfo.add(lblAsiento ,"left");
		pnlInfo.add(lblNAsiento,"wrap");
		pnlInfo.add(lblClase   ,"left");
		pnlInfo.add(lblNClase  );
		
		
		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[grow][grow]","[grow][grow][grow]"));
		pnlGeneral.setBackground(Color.WHITE);
		
		pnlGeneral.add(lblTitulo,"cell 0 1,left"  );
		pnlGeneral.add(pnlInfo  ,"cell 1 1,center");
		
		return pnlGeneral;
	}

}
