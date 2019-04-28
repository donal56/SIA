package GUIs;
import java.awt.BorderLayout			  ;
import java.awt.Color					  ;
import java.awt.Container				  ;
import java.awt.Cursor                    ;
import java.awt.Dimension                 ;
import java.awt.Font                      ;
import javax.swing.ImageIcon              ;
import javax.swing.JButton                ;
import javax.swing.JFrame                 ;
import javax.swing.JLabel                 ;
import javax.swing.JOptionPane;
import javax.swing.JPanel                 ;
import javax.swing.JScrollPane            ;
import javax.swing.JTable                 ;
import javax.swing.JTextField             ;
import javax.swing.SwingConstants         ;
import java.awt.event.ActionEvent         ;
import java.awt.event.ActionListener      ;
import javax.swing.table.DefaultTableModel;


import Otros.Metodos;
import net.miginfocom.swing.MigLayout;

public class GUIAviones 
{

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
		metodos   =new Metodos  ();
		pnlGeneral=new JPanel   ();
		pnlFiltro =new JPanel   ();
		pnlTitulo =new JPanel   ();
		lblTitulo =new JLabel   ("Aviones",SwingConstants.LEFT);
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
						"ID","Modelo","Capacidad"
					}
				));
		
		//Conexion 
		metodos.llenarTabla(tabla, "CALL sp_ConsultarAviones(8,3,'',0);");
		//metodos.llenarTabla(tabla, "Select * from aviones;");
		spTabla.setViewportView (tabla                   );
		spTabla.setPreferredSize(new Dimension(1000, 400));
		
		//Formato titulo
		lblTitulo.setOpaque    (true)                                ;
		lblTitulo.setBackground(Color.WHITE)                         ;
		lblTitulo.setFont      (new Font("Segoe UI", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(0,88,143))                 ;
		lblimg.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnAvion.png")));
		
		//Elementos en el panel filtro
		pnlFiltro.setLayout(new MigLayout());
		//pnlTitulo.setLayout(new BorderLayout()                       );
		
		
		//Elementos del filtrado
		JLabel lblID        = new JLabel("ID"       );
		JLabel lblModelo    = new JLabel("Modelo"   );
		JLabel lblCapacidad = new JLabel("Capacidad");
		JTextField txtID    = new JTextField("",20);
		JTextField txtMod   = new JTextField("",20);
		JTextField txtCap   = new JTextField("",20);
		
		
		//Formato de los label
		lblID       .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblModelo   .setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		lblCapacidad.setFont      (new Font("Segoe UI", Font.PLAIN, 30));
		
		//Se le quita el border a los text Field
		txtID .setBorder(null);
		txtMod.setBorder(null);
		txtCap.setBorder(null);
		

		//Formato de la tabla
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		//Boton buscar
		btnBuscar.setBorder       (null )     ;
		btnBuscar.setSelectedIcon (null)      ;
		btnBuscar.setCursor       (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnBuscar.setPressedIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/LoginBotonAceptar_Pres.png")));
		btnBuscar.setIcon         (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonIr.png"     )));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				String modelo = txtMod.getText();
				String capacidad = txtCap.getText();
				String query = "";
				boolean queryValido = true;
				if (!ID.equals("") && modelo.equals("") && capacidad.equals("")) {
					query = "CALL sp_ConsultarAviones(1, " + ID + ", '', 0)";					
				} else if (ID.equals("") && !modelo.equals("") && capacidad.equals("")) {
					query = "CALL sp_ConsultarAviones(4, 0, '" + modelo + "', 0)";
				} else if (ID.equals("") && modelo.equals("") && !capacidad.equals("")) {
					query = "CALL sp_ConsultarAviones(5, 0, '', " + capacidad + ")";
				} else if (ID.equals("") && modelo.equals("") && capacidad.equals("")) {
					query = "CALL sp_ConsultarAviones(8, 3, '', 0)";
				} else {
					JOptionPane.showMessageDialog(null, "Opciones de filtrado incorrectas", 
							"Buscar avi\u00F3n", JOptionPane.INFORMATION_MESSAGE);
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
		pnlFiltro.add(lblModelo   );
		pnlFiltro.add(txtMod      );
		pnlFiltro.add(lblCapacidad);
		pnlFiltro.add(txtCap      );
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

		pnlBotones=metodos.crearBotones(true, false, true); 
		//Agregar el ActionListener al boton Agregar
		metodos.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIAvionesAgregar guiAviones = new GUIAvionesAgregar(new JFrame());
				guiAviones.setVisible(true);
			}
		});
		//Agregar el ActionListener al boton Actualizar
		metodos.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener el indice de la fila seleccionada y usarlo para asignar los datos de la fila al array
				int indiceAvion = tabla.getSelectedRow();
				if (indiceAvion != -1) {
					String[] datos = new String[2];
					for	(int i = 0; i < 2; i++) 
						datos[i] = (String)tabla.getValueAt(indiceAvion, i);
					GUIAvionesAgregar guiAviones = new GUIAvionesAgregar(new JFrame(), datos);
					guiAviones.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un registro primero", 
							"Actualizar avi\u00F3n", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		pnlGeneral.add(lblTitulo ,"split 2, left"       );
		pnlGeneral.add(lblimg    ,"wrap, wrap"          );
		pnlGeneral.add(pnlFiltro ,"center, wrap"        );
		pnlGeneral.add(spTabla   ,"split 2, center,wrap");
		pnlGeneral.add(pnlBotones,"split 2,center"      );

		return pnlGeneral;
	}
}
