package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Otros.Metodos;
import net.miginfocom.swing.MigLayout;

public class GUIOfertas 
{
	Container contenedor;
	JPanel    pnlGeneral,
	          pnlFiltro ,
	          pnlTitulo ,
	          pnlBotones;
	JButton   b         ,
	          btnBuscar ;
	Metodos   metodos   ;
	JTable    tabla     ;
	JScrollPane spTabla ;
	JLabel    lblTitulo ,
			  lblimg    ;
	

	public JPanel crear() 
	{
		contenedor=new Container();
		metodos   =new Metodos  ();
		pnlGeneral=new JPanel   ();
		pnlFiltro =new JPanel   ();
		pnlTitulo =new JPanel   ();
		lblTitulo =new JLabel   ("Ofertas",SwingConstants.CENTER);
		btnBuscar =new JButton  ();
		lblimg    =new JLabel   ();
		pnlBotones=new JPanel   ();
		
		//Tabla
		tabla  =new  JTable();
		spTabla=new JScrollPane();
				
		tabla.setModel(new DefaultTableModel(
				new Object[][]
						{},
				new String[]
					{
						"ID","Inicio","Fin","Porcentaje de descuento"
					}
				));
				
		//Conexion 
		metodos.llenarTabla(tabla, "CALL sp_ConsultarOfertas(8,0,'0000-00-00','0000-00-00',0);");
		spTabla.setViewportView(tabla);
		spTabla.setPreferredSize(new Dimension(1000,400));
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		lblimg.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnOferta.png")));
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new MigLayout());
		//pnlTitulo.setLayout(new BorderLayout()                       );
		
		
		//Elementos del filtrado
		JLabel lblID        = new JLabel("ID "   );
		JLabel lblInicio    = new JLabel("Inicio ");
		JLabel lblFin       = new JLabel("Fin "   );
		JTextField txtID    = new JTextField("",20);
		JTextField txtInicio= new JTextField("",20);
		JTextField txtFin   = new JTextField("",20);
		
		//Formato de los label
		lblID    .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblInicio.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblFin   .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		//Se le quita el border a los text Field
		txtID     .setBorder(null);
		txtInicio .setBorder(null);
		txtFin    .setBorder(null);
				
		//Formato de la tabla
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		//Boton buscar
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setOpaque                (false)     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonIr.png"     )));
			
		//Se agregan al panel
		pnlFiltro.add(lblID       );
		pnlFiltro.add(txtID       );
		pnlFiltro.add(lblInicio   );
		pnlFiltro.add(txtInicio   );
		pnlFiltro.add(lblFin      );
		pnlFiltro.add(txtFin      );
		pnlFiltro.add(btnBuscar   );
		pnlFiltro.setBackground((new Color(80,200,243)));
		
		//Agregamos al panel titulo el label del titulo y los filtros
		pnlTitulo.add(lblTitulo,BorderLayout.NORTH );
		pnlTitulo.add(pnlFiltro,BorderLayout.CENTER);
		
		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[grow]","[]"));
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		tabla.setBackground  (Color.WHITE);
		spTabla.setBackground(Color.WHITE);
		spTabla.setBorder(null);
		tabla.setBorder(null);
		pnlBotones=metodos.crearBotones(true, true, true);
		metodos.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIOfertasAgregar guiOfertas = new GUIOfertasAgregar();
				guiOfertas.setVisible(true);
			}
		});
			
		pnlGeneral.add(lblTitulo, "split 2, left");
		pnlGeneral.add(lblimg,"wrap, wrap");
		pnlGeneral.add(pnlFiltro,"center, wrap");
		pnlGeneral.add(spTabla  ,"split 2, center,wrap");
		pnlGeneral.add(pnlBotones,"split 2,center");
		return pnlGeneral;
	}

}
