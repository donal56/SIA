package GUIs;

import java.awt.BorderLayout        ;
import java.awt.Color               ;
import java.awt.Container           ;
import java.awt.Cursor              ;
import java.awt.Dimension           ;
import java.awt.Font                ;
import java.awt.event.ActionEvent   ;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon        ;
import javax.swing.JButton          ;
import javax.swing.JFrame           ;
import javax.swing.JLabel           ;
import javax.swing.JOptionPane;
import javax.swing.JPanel           ;
import javax.swing.JScrollPane      ;
import javax.swing.JTable           ;
import javax.swing.JTextField       ;
import javax.swing.SwingConstants   ;

import Otros.Conexion;
import Otros.Metodos;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class GUIVuelos 
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
	JScrollPane spTabla;
	JLabel    lblTitulo ,
			  lblimg    ;
	

	public JPanel crear() 
	{
		contenedor=new Container();
		metodos   =new Metodos  ();
		pnlGeneral=new JPanel   ();
		pnlFiltro =new JPanel   ();
		pnlTitulo =new JPanel   ();
		lblTitulo =new JLabel   ("Vuelos",SwingConstants.LEFT);
		btnBuscar =new JButton  ();
		lblimg    =new JLabel   ();
		pnlBotones=new JPanel   ();
		//Tabla
		tabla  =new  JTable     ();
		spTabla=new  JScrollPane();
		
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
		//metodos.llenarTabla(tabla,"Select * From vuelos;");
		spTabla.setViewportView(tabla);
		spTabla.setPreferredSize(new Dimension(1200,400));
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;                            ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		lblimg.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/imgVuelos.jpg")));
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new MigLayout());
		//pnlTitulo.setLayout(new BorderLayout()                       );
		
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
		lblID     .setFont      (new Font("Segoe UI", Font.PLAIN, 25));
		lblFecha  .setFont      (new Font("Segoe UI", Font.PLAIN, 25));
		lblOrigen .setFont      (new Font("Segoe UI", Font.PLAIN, 25));
		lblDestino.setFont      (new Font("Segoe UI", Font.PLAIN, 25));
		
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				String fecha = txtFecha.getText();
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				String query = "";
				boolean queryValido = true;
				if (!ID.equals("") && fecha.equals("") && origen.equals("") && destino.equals("")) {
					query = "CALL sp_ConsultarVuelos(1, " + ID + ", '0000-00-00', '', '')";					
				} else if (ID.equals("") && !fecha.equals("") && !origen.equals("") && !destino.equals("")) {
					query = "CALL sp_ConsultarVuelos(4, 0, '" + fecha + "', '" + origen + "', '" + destino + "')";
				} else if (ID.equals("") && fecha.equals("") && origen.equals("") && destino.equals("")) {
					query = "CALL sp_ConsultarVuelos(5, 0, '0000-00-00', '', '')";
				} else {
					JOptionPane.showMessageDialog(null, "Opciones de filtrado incorrectas", 
							"Buscar vuelo", JOptionPane.INFORMATION_MESSAGE);
					queryValido = false;
				}
				if (queryValido) {
					( (DefaultTableModel)tabla.getModel() ).setRowCount(0);
					metodos.llenarTabla(tabla, query);
				}
			}
		});
			
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
		pnlGeneral.setLayout(new MigLayout("","[grow]","[]"));
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		tabla.setBackground  (Color.WHITE);
		spTabla.setBackground(Color.WHITE);
		spTabla.setBorder(null);
		tabla.setBorder(null);
		pnlBotones=metodos.crearBotones(true, true, true);
		
		//Agregar el ActionListener al boton Agregar
		metodos.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar(new JFrame());
				guiVuelos.setVisible(true);
			}
		});
		//Agregar el ActionListener al boton Actualizar
		metodos.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener el indice de la fila seleccionada y usarlo para asignar los datos de la fila al array
				int indiceVuelo = tabla.getSelectedRow();
				if (indiceVuelo != -1) {
					String[] datos = new String[11];
					for	(int i = 0; i < 11; i++) 
						datos[i] = (String)tabla.getValueAt(indiceVuelo, i);
					GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar(new JFrame(), datos);
					guiVuelos.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un registro primero", 
							"Actualizar vuelo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		//Agregar el ActionListener al boton Eliminar
		metodos.btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener el indice de la fila seleccionada y usarlo para borrar el registro de la BD
				int indiceVuelo = tabla.getSelectedRow();
				if (indiceVuelo != -1) {
					//Locale locale = new Locale("es", "MX");
					//JOptionPane.setDefaultLocale(locale);
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?", 
										"Eliminar vuelo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (respuesta == JOptionPane.YES_OPTION) {
						String ID = (String)tabla.getValueAt(indiceVuelo, 0);
						String query = "DELETE FROM vuelos WHERE idVuelo = " + ID;
						Conexion con = new Conexion();
						try {
							con.realizarOperacion(query);
							con.cerrarConexion();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un registro primero", 
							"Eliminar vuelo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		pnlGeneral.add(lblTitulo , "split 2, left");
		pnlGeneral.add(lblimg    ,"wrap, wrap"    );
		pnlGeneral.add(pnlFiltro ,"center, wrap"  );
		pnlGeneral.add(spTabla   ,"split 2, center,wrap");
		pnlGeneral.add(pnlBotones,"split 2,center");

		return pnlGeneral;
	}
}