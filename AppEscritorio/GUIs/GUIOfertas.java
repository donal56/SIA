package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;

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

import Otros.Conexion;
import Otros.Metodos;

public class GUIOfertas 
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
	Conexion  conectar;
	

	public JPanel crear(Frame padre) 
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
								"ID","Inicio","Fin"
							}
						));
				
				//Conexion 
				metodos.llenarTabla(tabla, "CALL sp_ConsultarOfertas(8,0,'0000-00-00','0000-00-00',0);");
				spTabla.setViewportView(tabla);
				spTabla.revalidate();
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setText      ("Ofertas")                           ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new BoxLayout(pnlFiltro,BoxLayout.X_AXIS));
		pnlTitulo.setLayout(new BorderLayout()                       );
		
		
		//Elementos del filtrado
		JLabel lblID        = new JLabel("ID   "   );
		JLabel lblInicio    = new JLabel("Inicio  ");
		JLabel lblFin       = new JLabel("Fin  "   );
		JTextField txtID    = new JTextField(""    );
		JTextField txtInicio= new JTextField(""    );
		JTextField txtFin   = new JTextField(""    );
		
		//Formato de los label
		lblID    .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblInicio.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblFin.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
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
		pnlFiltro.add(lblInicio   );
		pnlFiltro.add(txtInicio   );
		pnlFiltro.add(lblFin      );
		pnlFiltro.add(txtFin      );
		pnlFiltro.add(btnBuscar   );
		pnlFiltro.setBackground(Color.WHITE);
		
		//Agregamos al panel titulo el label del tituolo y los filtros
		pnlTitulo.add(lblTitulo,BorderLayout.NORTH );
		pnlTitulo.add(pnlFiltro,BorderLayout.CENTER);
		
		//Formato del panel general
		pnlGeneral.setLayout (new BorderLayout());
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		//Se agregan los elementos al panel general
		pnlGeneral.add(pnlTitulo,BorderLayout.NORTH)                           ;
		pnlGeneral.add(metodos.crearBotones(true,true,true,8,padre),BorderLayout.EAST);
		pnlGeneral.add(spTabla,BorderLayout.CENTER)                                  ;

		return pnlGeneral;
	}

}
