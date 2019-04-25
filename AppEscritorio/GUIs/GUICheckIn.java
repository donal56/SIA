package GUIs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Otros.Conexion;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GUICheckIn 
{

	JPanel     pnlGeneral,
		       pnlCentral;
	JButton    btnBuscar ;
	JLabel     lblTitulo ,
		       lblImagen ,
		       lblTexto  ;
	JTextField txtBoleto ;
	
	public JPanel crear()
	{
		pnlGeneral= new JPanel    ();
		pnlCentral= new JPanel    ();
		btnBuscar = new JButton   ("Buscar");
		lblImagen = new JLabel    ();
		txtBoleto = new JTextField("",30);
		lblTexto  = new JLabel ("Número de boleto");
		lblTitulo = new JLabel ("Check-In",SwingConstants.CENTER);
		
		lblTitulo.setOpaque    (true       );
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont      (new Font ("Segoe UI", Font.PLAIN,70));
		lblTitulo.setForeground(new Color(0,88,143                 ));
		lblImagen.setIcon(new ImageIcon(GUIPrincipal.class.getResource("/img/icnPase.png")));
		
		btnBuscar.setBorder                (null )     ;
		btnBuscar.setOpaque                (false)     ;
		btnBuscar.setSelectedIcon          (null)      ;
		btnBuscar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setPreferredSize(new Dimension(100,50));
		btnBuscar.setBackground(Color.WHITE);
		//Agregar el ActionListener al boton Buscar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idBoleto = txtBoleto.getText();
				String query = "SELECT status FROM boletos WHERE idBoleto = '" + idBoleto + "'";
				Conexion con = new Conexion();
				try {
					ResultSet status = con.obtenerDatos(query);
					boolean existe = status.isBeforeFirst();
					if (existe) {
						status.next();
						String valor = status.getString(1);
						if (valor.equals("0")) {
							//Este query se debera ejecutar sin usar el objeto Conexion porque ese manda un mensaje de confirmacion y no queremos eso
							query = "UPDATE boletos b SET b.status = 1 WHERE idBoleto = '" + idBoleto + "'";
							Connection conn = new Conexion().getConnection();
							conn.createStatement().execute(query);
							//Crear el objeto JasperReport cargando el archivo de reporte .jasper
							JasperReport reporte = (JasperReport) JRLoader.loadObject(GUICheckIn.class.getResource("/Otros/PaseParaAbordar.jasper"));
							//Crear un HashMap para ingresar el parametro ID de boleto
							HashMap<String, Object> parametro = new HashMap<String, Object>();
							parametro.put("ID", idBoleto);
							//Crear el objeto JasperPrint que basicamente ya es el pase para abordar, dandole el reporte, el parametro y una conexion a BD
							JasperPrint doc = JasperFillManager.fillReport(reporte, parametro, conn);
							//Crear un JasperViewer para ver el pdf, pero el JasperViewer no es modal asi que se adapta a un JDialog
							JasperViewer jv = new JasperViewer(doc, false);
							JDialog dialog = new JDialog((JFrame)null, true);
							dialog.setContentPane(jv.getContentPane());
							dialog.setSize(jv.getSize());
							dialog.setTitle("Pase para abordar");
							dialog.setVisible(true);
							//Cerrar las conexiones
							if (conn != null) {
					        	conn.close();
					        	conn = null;
					        }
						} else {
							JOptionPane.showMessageDialog(null, "El boleto ya ha sido confirmado o cancelado", 
									"Check-in", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe el boleto", 
								"Check-in", JOptionPane.INFORMATION_MESSAGE);
					}
					con.cerrarConexion();
				} catch (JRException | SQLException ex) {					
					ex.printStackTrace();
				}
			}
		});
		
		lblTexto.setOpaque    (true);
		lblTexto.setBackground(new Color(0,102,177));
		lblTexto.setFont      (new Font ("Segoe UI", Font.PLAIN,40));
		lblTexto.setForeground(Color.WHITE);
		
		pnlCentral.setLayout       (new MigLayout("insets 0 20 10 20","[grow][]","[grow]40[grow][]"));
		pnlCentral.setBackground   (new Color    (0,102,177));
		pnlCentral.setPreferredSize(new Dimension(700,300));
		
		pnlCentral.add(lblImagen,"cell 1 1, center");
		pnlCentral.add(lblTexto ,"cell 0 0, span 1 2" );
		pnlCentral.add(txtBoleto,"cell 0 1, span 1 2");
		pnlCentral.add(btnBuscar,"cell 0 2, left");
		
		
		pnlGeneral.setLayout(new MigLayout("insets 10 80 10 10","[grow][grow][grow]","[grow][grow][grow]"));
		pnlGeneral.setVisible(true);
		pnlGeneral.setBackground(Color.WHITE);
		
		pnlGeneral.add(lblTitulo ,"cell 0 1"    );
		pnlGeneral.add(pnlCentral,"cell 1 1 0 0");
		return pnlGeneral;
	}
}
