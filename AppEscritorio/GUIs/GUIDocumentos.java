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

public class GUIDocumentos
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
		lblTitulo =new JLabel   ("Documentación",SwingConstants.CENTER);
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
						"ID","Peso","Cliente"
					}
				));
				
		//Conexion
		String query = "SELECT 	idDocumentacion," +
				"peso," + 
				"concat(nombre, \" \", apellidoP, \" \", apellidoM) AS pasajero " + 
				"FROM documentacion d " + 
				"INNER JOIN clientes c " + 
				"ON d.clientes_idCliente = c.idCliente";
		metodos.llenarTabla(tabla, query);
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
		JLabel lblID        = new JLabel("ID "      );
		JLabel lblPeso      = new JLabel("Peso "    );
		JLabel lblPasajero  = new JLabel("Pasajero ");
		JTextField txtID    = new JTextField("",20  );
		JTextField txtPeso  = new JTextField("",20  );
		JTextField txtPasajero   = new JTextField("",20  );
		
		//Formato de los label
		lblID    .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblPeso  .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblPasajero   .setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		//Se le quita el border a los text Field
		txtID     .setBorder(null);
		txtPeso .setBorder(null);
		txtPasajero    .setBorder(null);
				
		//Formato de la tabla
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		//Boton buscar
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setOpaque                (false)     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonIr.png"     )));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				String peso = txtPeso.getText();
				String pasajero = txtPasajero.getText();
				String query = "SELECT 	idDocumentacion," +
						"peso," + 
						"concat(nombre, \" \", apellidoP, \" \", apellidoM) AS pasajero " + 
						"FROM documentacion d " + 
						"INNER JOIN clientes c " + 
						"ON d.clientes_idCliente = c.idCliente";
				boolean queryValido = true;
				if (!ID.equals("") && peso.equals("") && pasajero.equals("")) {
					query += " WHERE idDocumentacion = " + ID;					
				} else if (ID.equals("") && !peso.equals("") && pasajero.equals("")) {
					query += " WHERE peso = " + peso;
				} else if (ID.equals("") && peso.equals("") && !pasajero.equals("")) {
					query += " HAVING pasajero = '" + pasajero + "'";
				} else if (ID.equals("") && peso.equals("") && pasajero.equals("")) {
					//No es necesario hacer nada
				} else {
					JOptionPane.showMessageDialog(null, "Opciones de filtrado incorrectas", 
							"Buscar maleta", JOptionPane.INFORMATION_MESSAGE);
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
		pnlFiltro.add(lblPeso  );
		pnlFiltro.add(txtPeso   );
		pnlFiltro.add(lblPasajero      );
		pnlFiltro.add(txtPasajero      );
		pnlFiltro.add(btnBuscar   );
		pnlFiltro.setBackground((new Color(80,200,243)));
		
		//Agregamos al panel titulo el label del tituolo y los filtros
		pnlTitulo.add(lblTitulo,BorderLayout.NORTH );
		pnlTitulo.add(pnlFiltro,BorderLayout.CENTER);
		
		//Formato del panel general
		pnlGeneral.setLayout(new MigLayout("","[grow]","[]"));
		pnlGeneral.setVisible(true)              ;
		pnlGeneral.setBackground(Color.WHITE)    ;
		
		tabla  .setBackground  (Color.WHITE);
		spTabla.setBackground  (Color.WHITE);
		spTabla.setBorder(null);
		tabla  .setBorder(null);
		pnlBotones=metodos.crearBotones(true, false, false);
		metodos.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIDocumentosAgregar guiDocumentos = new GUIDocumentosAgregar(new JFrame());
				guiDocumentos.setVisible(true);
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
