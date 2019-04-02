package GUIs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
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

public class GUIAviones 
{

	Container contenedor;
	JPanel    pnlGeneral,
	          pnlFiltro ,
	          pnlTitulo ;
	JButton   b         ,
	          btnBuscar ;
	Metodos   metodos   ;
	JTable      tabla   ;
	JScrollPane spTabla ;
	JLabel    lblTitulo ;
	

	public JPanel crear(Dimension pSize) 
	{
		contenedor=new Container();
		metodos   =new Metodos  ();
		pnlGeneral=new JPanel   ();
		pnlFiltro =new JPanel   ();
		pnlTitulo =new JPanel   ();
		lblTitulo =new JLabel   ();
		btnBuscar =new JButton  ("Buscar");
		
		//Tabla
		tabla  =new  JTable();
		spTabla=new JScrollPane();
		
		tabla.setModel(new DefaultTableModel(
				new Object[][]
						{},
				new String[]
					{
						"ID","Modelo","Capacidad"
					}
				));
		
		tabla.setModel(new DefaultTableModel(
				new Object[][]
						{},
				new String[]
					{
						"ID","Modelo","Capacidad"
					}
				));
		
		//Conexion 
		metodos.llenarTabla(tabla, "CALL sp_ConsultarAviones(8,3,'',0);");
		spTabla.setViewportView(tabla);
		spTabla.revalidate();
		
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
		pnlGeneral.setSize(pSize);
		pnlGeneral.setLayout (new BorderLayout());
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		tabla.setBackground(new Color(49,153,218));
		tabla.setForeground(Color.white);
		tabla.setBorder(null);
		tabla.setEnabled(false);
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 12 ));
		
		spTabla.setBorder(null);
		
		//Se agregan los elementos al panel general
		pnlGeneral.add(pnlTitulo,BorderLayout.NORTH)                           ;
		pnlGeneral.add(metodos.crearBotones(true,false,true),BorderLayout.EAST);
		pnlGeneral.add(spTabla,BorderLayout.CENTER);

		return pnlGeneral;
	}

}
