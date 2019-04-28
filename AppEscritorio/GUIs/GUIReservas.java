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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Otros.Metodos;
import net.miginfocom.swing.MigLayout;

public class GUIReservas 
{
	Container contenedor  ;
	JPanel    pnlGeneral  ,
	          pnlFiltro   ,
	          pnlTitulo   ,
	          pnlCentral  ;
	JButton   btnSiguiente,
	          btnBuscar   ;
	Metodos   metodos     ;
	JTable    tabla       ;
	JScrollPane spTabla   ;
	JLabel    lblTitulo   ,
			  lblimg      ;
	GUIAsientos guiAsientos;
	

	public JPanel crear(JPanel pPanel) 
	{
		contenedor  =new Container  ();
		metodos     =new Metodos    ();
		pnlGeneral  =new JPanel     ();
		pnlFiltro   =new JPanel     ();
		pnlTitulo   =new JPanel     ();
		lblTitulo   =new JLabel     ("Reservas",SwingConstants.LEFT);
		lblimg      =new JLabel     ();
		btnBuscar   =new JButton    ();
		btnSiguiente=new JButton    ("Siguiente");
		tabla       =new JTable     ();
		spTabla     =new JScrollPane();
		pnlCentral  =pPanel;
		
		//Tabla
		tabla.setModel(new DefaultTableModel(
				new Object[][]
						{},
				new String[]
					{
						"ID","Avi\u00F3n","Fecha","Hora de salida","Hora de llegada","Origen","Destino",
						"Porcentaje de descuento","Clase Turista","Clase Ejecutivo","Clase VIP"
					}
				));

		
		//Conexion 
		metodos.llenarTabla(tabla, "CALL sp_ConsultarVuelos(5,0,'0000-00-00','','');");
		spTabla.setViewportView(tabla);
		spTabla.setPreferredSize(new Dimension(1200,400));
		
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		lblimg.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/imgVuelos.jpg")));
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new MigLayout());
		
		//Elementos del filtrado
		JLabel lblID          = new JLabel("ID"     );
		JLabel lblFecha       = new JLabel("Fecha"  );
		JLabel lblOrigen      = new JLabel("Origen" );
		JLabel lblDestino     = new JLabel("Destino");
		JTextField txtID      = new JTextField("",20);
		JTextField txtFecha   = new JTextField("",20);
		JTextField txtOrigen  = new JTextField("",20);
		JTextField txtDestino = new JTextField("",20);
		
		//Formato de los label
		lblID     .setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblFecha  .setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblOrigen .setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblDestino.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		//Se le quita el border a los text Field
		txtID     .setBorder(null);
		txtFecha  .setBorder(null);
		txtDestino.setBorder(null);
		txtOrigen .setBorder(null);
		
		//Formato de la tabla
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		//Boton buscar
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonIr.png"     )));
		btnBuscar.setOpaque(false);
		
		//Boton siguiente
		btnSiguiente.setPreferredSize(new Dimension(100,40));
		btnSiguiente.setBackground(new Color(80,200,243));
		btnSiguiente.setForeground(Color.BLACK);
		btnSiguiente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			
		//Se agregan al panel
		pnlFiltro.add(lblID       );
		pnlFiltro.add(txtID       );
		pnlFiltro.add(lblFecha    );
		pnlFiltro.add(txtFecha    );
		pnlFiltro.add(lblOrigen   );
		pnlFiltro.add(txtOrigen   );
		pnlFiltro.add(lblDestino  );
		pnlFiltro.add(txtDestino  );
		pnlFiltro.add(btnBuscar   );
		pnlFiltro.setBackground(new Color(80,200,243));
		
		//Agregamos al panel titulo el label del tituolo y los filtros
		pnlTitulo.add(lblTitulo,BorderLayout.NORTH );
		pnlTitulo.add(pnlFiltro,BorderLayout.CENTER);
		
		//Formato del panel general
		pnlGeneral.setLayout (new MigLayout("insets 10 40 10 10","[grow]","[]"));
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		tabla  .setBackground  (Color.WHITE);
		spTabla.setBackground(Color.WHITE);
		spTabla.setBorder(null);
		tabla  .setBorder(null);
		
		
		btnSiguiente.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					int indiceVuelo = tabla.getSelectedRow();
					if (indiceVuelo != -1) {
						//JOptionPane.showMessageDialog(null, indiceVuelo);
						String[] datos = new String[11];
						String[] titulos=new String[11];
						for	(int i = 0; i < 11; i++)
						{
							datos[i] = (String)tabla.getValueAt(indiceVuelo, i);
							titulos[i]=(String)tabla.getColumnName(i);
							guiAsientos =new GUIAsientos(datos,titulos);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Seleccione un vuelo");
					}
					pnlCentral.removeAll();
					pnlCentral.add(guiAsientos.crear(pPanel));
					pnlCentral.revalidate();
					
				} catch (Exception e2) {
					pnlCentral.add(crear(pnlCentral));
				}
			}
		});

		pnlGeneral.add(lblTitulo , "split 2, left");
		pnlGeneral.add(lblimg    ,"wrap, wrap"    );
		pnlGeneral.add(pnlFiltro ,"center, wrap"  );
		pnlGeneral.add(spTabla   ,"split 2, center,wrap");
		pnlGeneral.add(btnSiguiente,"right");

		return pnlGeneral;
	}
	
	
}
