package GUIs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import Otros.Conexion;
import net.miginfocom.swing.MigLayout;

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
							
							//send request to generate pdf
							URL pdf = sendRequestPDF(idBoleto);
			
							// build a controller
							SwingController controller = new SwingController();

							// Build a SwingViewFactory configured with the controller
							SwingViewBuilder factory = new SwingViewBuilder(controller);

							// Use the factory to build a JPanel that is pre-configured
							//with a complete, active Viewer UI.
							JPanel viewerComponentPanel = factory.buildViewerPanel();

							// add copy keyboard command
							ComponentKeyBinding.install(controller, viewerComponentPanel);

							// add interactive mouse link annotation support via callback
							controller.getDocumentViewController().setAnnotationCallback(
							      new org.icepdf.ri.common.MyAnnotationCallback(
							             controller.getDocumentViewController()));

							// Create a JFrame to display the panel in
							JFrame window = new JFrame("PASE DE ABORDAR PDF");
							window.getContentPane().add(viewerComponentPanel);
							window.pack();
							window.setVisible(true);

							// Open a PDF document to view

							controller.openDocument(pdf);
							
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
				} catch (SQLException ex) {					
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
	
	private URL sendRequestPDF(String idBoleto) {
		URL pdf = null;
		try {
			URL url = new URL("https://aeroalpes.tk/controllers/CntrlCheckin.php"); // URL to your application
			Map<String,Object> params = new LinkedHashMap<>();
			params.put("func", 1); // All parameters, also easy
			params.put("numBoleto", idBoleto);
	
			StringBuilder postData = new StringBuilder();
			// POST as urlencoded is basically key-value pairs, as with GET
			// This creates key=value&key=value&... pairs
			for (Map.Entry<String,Object> param : params.entrySet()) {
			     if (postData.length() != 0) postData.append('&');
			     postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			     postData.append('=');
			     postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}

		    // Convert string to byte array, as it should be sent
		    byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		    // Connect, easy
		    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		    // Tell server that this is POST and in which format is the data
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		    conn.setDoOutput(true);
		    conn.getOutputStream().write(postDataBytes);

		    // This gets the output from your server
		    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		    String path="";
		    for (int c; (c = in.read()) >= 0;)
		        path+=(char)c;

		    if(path.equals("send to desktop")) {
		    	//sia2019.heliohost doesn't force the unsupported https protocol
		    	pdf = new URL("http://sia2019.heliohost.org/tcpdf/pdf/"+idBoleto+".pdf");
		    }else {
		    	throw new IOException(" Server not sent the file, try again!");
		    }
		    	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al generar el boleto \n"+e, 
					"ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		return pdf;
		
	}
}
