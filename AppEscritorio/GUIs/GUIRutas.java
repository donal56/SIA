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
import javax.swing.JFrame;
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

public class GUIRutas 
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
		lblTitulo =new JLabel   ("Rutas",SwingConstants.LEFT);
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
						"ID","Origen","Destino","Estado"
					}
				));
		
		//Conexion 
		metodos.llenarTabla(tabla, "CALL sp_ConsultarRutas (8,0,'','',0)");
		spTabla.setViewportView(tabla);
		spTabla.setPreferredSize(new Dimension(1000,400));
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		lblimg.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnRuta.png")));
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new MigLayout());
		//pnlTitulo.setLayout(new BorderLayout()                       );
		
		
		//Elementos del filtrado
		JLabel lblID         = new JLabel("ID "     );
		JLabel lblOrigen     = new JLabel("Origen " );
		JLabel lblDestino    = new JLabel("Destino ");
		JLabel lblEstado     = new JLabel("Estado " );
		JTextField txtID     = new JTextField("",20    );
		JTextField txtOrigen = new JTextField("",20    );
		JTextField txtDestino= new JTextField("",20    );
		JTextField txtEstado = new JTextField("",20    );
		
		//Formato de los label
		lblID     .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblOrigen .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblDestino.setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblEstado .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		
		//Se le quita el border a los text Field
		txtID     .setBorder(null);
		txtOrigen .setBorder(null);
		txtDestino.setBorder(null);
		txtEstado .setBorder(null);
		
		//Formato de la tabla
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				
		//Boton buscar
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonIr.png"     )));
		btnBuscar.setOpaque                (false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				String estado = txtEstado.getText();
				String query = "";
				boolean queryValido = true;
				if (!ID.equals("") && origen.equals("") && destino.equals("") && estado.equals("")) {
					query = "CALL sp_ConsultarRutas(1, " + ID + ", '', '', 0)";					
				} else if (ID.equals("") && !origen.equals("") && !destino.equals("") && estado.equals("")) {
					query = "CALL sp_ConsultarRutas(6, 0, '" + origen + "', '" + destino + "', 0)";
				} else if (ID.equals("") && origen.equals("") && destino.equals("") && !estado.equals("")) {
					query = "CALL sp_ConsultarRutas(7, 0, '', '', " + estado + ")";
				} else if (ID.equals("") && origen.equals("") && destino.equals("") && estado.equals("")) {
					query = "CALL sp_ConsultarRutas(8, 0, '', '', 0)";
				} else {
					JOptionPane.showMessageDialog(null, "Opciones de filtrado incorrectas", 
							"Buscar ruta", JOptionPane.INFORMATION_MESSAGE);
					queryValido = false;
				}
				if (queryValido) {
					( (DefaultTableModel)tabla.getModel() ).setRowCount(0);
					metodos.llenarTabla(tabla, query);
				}
			}
		});
		
		//Se agregan al panel
		pnlFiltro.add(lblID      );
		pnlFiltro.add(txtID      );
		pnlFiltro.add(lblOrigen  );
		pnlFiltro.add(txtOrigen  );
		pnlFiltro.add(lblDestino );
		pnlFiltro.add(txtDestino );
		pnlFiltro.add(lblEstado  );
		pnlFiltro.add(txtEstado  );
		pnlFiltro.add(btnBuscar  );
		pnlFiltro.setBackground(new Color(80,200,243));
		
		//Agregamos al panel titulo el label del tituolo y los filtros
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
		pnlBotones=metodos.crearBotones(true, false, true);
		//Agregar el ActionListener al boton Agregar
		metodos.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIRutasAgregar guiRutas = new GUIRutasAgregar(new JFrame());
				guiRutas.setVisible(true);
			}
		});
		//Agregar el ActionListener al boton Actualizar
		metodos.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener el indice de la fila seleccionada y usarlo para asignar los datos de la fila al array
				int indiceRuta = tabla.getSelectedRow();
				if (indiceRuta != -1) {
					String[] datos = new String[4];
					for	(int i = 0; i < 4; i++) 
						datos[i] = (String)tabla.getValueAt(indiceRuta, i);
					GUIRutasAgregar guiRutas = new GUIRutasAgregar(new JFrame(), datos);
					guiRutas.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un registro primero", 
							"Actualizar ruta", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
			
		pnlGeneral.add(lblTitulo, "split 2, left");
		pnlGeneral.add(lblimg,"wrap, wrap");
		pnlGeneral.add(pnlFiltro,"center, wrap");
		pnlGeneral.add(spTabla  ,"split 2, center,wrap");
		pnlGeneral.add(pnlBotones,"split 2,center");
                                 ;

		return pnlGeneral;
	}
}
