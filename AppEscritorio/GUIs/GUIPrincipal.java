package GUIs;
import java.awt.BorderLayout        ;
import java.awt.Color               ;
import java.awt.Container           ;
import java.awt.Cursor              ;
import java.awt.Font                ;
import java.awt.GridLayout          ;
import java.awt.Toolkit             ;
import java.awt.event.ActionEvent   ;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon        ;
import javax.swing.JButton          ;
import javax.swing.JLabel           ;
import javax.swing.JPanel           ;
import javax.swing.SwingConstants   ;

import Otros.Ventana         ;


/*Esta GUI es la que aloja el menu principal de la aplicacción de escritorio, se extiende de una clase Ventana donde le doy formato a la 
ventana que se creara por medio del metodo crear
Modificación 1: Se le agrego el layout y el encabezado de la pagina, icono de la ventana, se le anexo el pressed a los botones*/

public class GUIPrincipal extends Ventana
{

	Container contenedorGral   ;
	JPanel    pnlEncabezado    ,
			  pnlCentro        ;
	ImageIcon icnBotones [][]  ,
			  icnPressed [][]  ,
			  icnEnca          ,
			  icnLinea         ;
	JButton   botones    [][]  ,
			  btnRegresar      ;
	JLabel    lblEncabezado    ,
	          lblLinea         ;
	GUIAviones    guiAviones   ;
	GUIVuelos     guiVuelos    ;
	GUIRutas      guiRutas     ;
	GUIDocumentos guiDocumentos;
	GUIOfertas    guiOfertas   ;
	
	static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width ;
	static int alto  = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int est;
	
	
	public GUIPrincipal()
	{
		super("Principal",ancho,alto,true);
		setAutoRequestFocus  (false      );
		setBackground        (Color.white);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPrincipal.class.getResource("/img/IcnVuelos.png")));
	}
	public void crear() 
	{
		//Formato contenedor general
		contenedorGral=new Container ()                  ;
		contenedorGral.setLayout     (new BorderLayout());
		this          .setContentPane(contenedorGral)    ;
		contenedorGral.setBackground (Color.white)       ;
		
		//Creamos las GUI
		guiAviones   =new GUIAviones();
		guiVuelos    =new GUIVuelos ();
		guiRutas     =new GUIRutas  ();
		guiDocumentos=new GUIDocumentos();
		guiOfertas   =new GUIOfertas();
		
		
		//Inicializamos los panel
		pnlEncabezado=new JPanel();
		pnlCentro    =new JPanel();   //Contenedor que se va a actualizar al presionar un boton
		
		//Se anexan al contenedor general 
		contenedorGral.add(pnlEncabezado, BorderLayout.NORTH );
		contenedorGral.add(pnlCentro    , BorderLayout.CENTER);


		//Formato para los paneles
		pnlCentro    .setLayout    (new GridLayout(2,5));
		pnlCentro    .setBackground(Color.white        );
		pnlEncabezado.setLayout    (new BorderLayout( ));
		pnlEncabezado.setBackground(Color.white        );
		
		
		//Diseño del boton de regresar
		btnRegresar  = new JButton           ("Regresar");
		btnRegresar.setBorder                (null )     ;
		btnRegresar.setOpaque                (false)     ;
		btnRegresar.setContentAreaFilled     (false)     ;
		btnRegresar.setSelectedIcon          (null)      ;
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER)                         ;
		btnRegresar.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegresar.setFont                  (new Font("Segoe UI", Font.PLAIN, 18          ));
		btnRegresar.setPressedIcon           (new ImageIcon(GUIPrincipal.class.getResource("/img/LoginBotonAceptar_Pres.png")));
		btnRegresar.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/LoginBotonAceptar.png"     )));
		
		
		//Se inserta logo del encabezado y boton
		lblEncabezado= new JLabel   ("");    
		lblLinea     = new JLabel   ("");
		icnEnca      = new ImageIcon(GUIPrincipal.class.getResource("/img/imgEncabezado.png"));
		icnLinea     = new ImageIcon(GUIPrincipal.class.getResource("/img/Linea.png"        ));
		lblEncabezado.setIcon       (icnEnca)                                                 ;
		lblLinea     .setIcon       (icnLinea)                                                ; 
		pnlEncabezado.add           (lblLinea     ,BorderLayout.SOUTH)                        ;
		pnlEncabezado.add           (lblEncabezado,BorderLayout.WEST  )                       ;
		pnlEncabezado.add           (btnRegresar  ,BorderLayout.EAST  )                       ;
		
		//Dimensionamos el array de botones,los iconos y los pressed
		botones     = new JButton  [2][5];
		icnBotones  = new ImageIcon[2][5];
		icnPressed  = new ImageIcon[2][5];
		
		//Aquí se crean todos los iconos de los botones
		icnBotones[0][0] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnVuelos.png"      ));
		icnBotones[0][1] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnReservas.png"    ));
		icnBotones[0][2] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnCheckIn.png"     ));
		icnBotones[0][3] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnAviones.png"     ));
		icnBotones[0][4] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnRutas.png"       ));
		icnBotones[1][0] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnCancelar.png"    ));
		icnBotones[1][1] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnDocumentos.png"  ));
		icnBotones[1][2] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnOfertas.png"     ));
		icnBotones[1][3] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnDevoluciones.png"));
		icnBotones[1][4] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnReportes.png"    ));
		
		//Aqui se crean todos los iconos pressed de los botones
		icnPressed[0][0] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnVuelos_pressed.png"      ));
		icnPressed[0][1] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnReservas_pressed.png"    ));
		icnPressed[0][2] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnCheckIn_pressed.png"     ));
		icnPressed[0][3] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnAviones_pressed.png"     ));
		icnPressed[0][4] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnRutas_pressed.png"       ));
		icnPressed[1][0] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnCancelar_pressed.png"    ));
		icnPressed[1][1] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnDocumentos_pressed.png"  ));
		icnPressed[1][2] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnOfertas_pressed.png"     ));
		icnPressed[1][3] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnDevoluciones_pressed.png"));
		icnPressed[1][4] =new ImageIcon(GUIPrincipal.class.getResource("/img/IcnReportes_pressed.png"    ));
		
		//Se crean, se le dan formato y se insertan botones
		
		crearBotones();
		//Este bloque ajusta los reajusta los componentes al redimensionar la ventana
		/*this.addComponentListener(new java.awt.event.ComponentAdapter() 
		{
			public void componentResized(ComponentEvent e)
			{
				 if(est>=1)
				 {
					 Icon icnEncabezado = new ImageIcon(icnEnca.getImage().getScaledInstance(lblEncabezado.getSize().width,lblEncabezado.getSize().height,java.awt.Image.SCALE_AREA_AVERAGING));
					 lblEncabezado.setIcon(icnEncabezado);
	                for (int i = 0; i < 2; i++) 
	        		{
	        			for (int j = 0; j < 5; j++)
	        			{
	        				Icon icnPrincipales= new ImageIcon(icnBotones[i][j].getImage().getScaledInstance(botones[i][j].getSize().width, botones[i][j].getSize().height,java.awt.Image.SCALE_AREA_AVERAGING));
	        				Icon icnClick      = new ImageIcon(icnPressed[i][j].getImage().getScaledInstance(botones[i][j].getSize().width, botones[i][j].getSize().height,java.awt.Image.SCALE_AREA_AVERAGING));
	        				botones[i][j].setIcon       (icnPrincipales  );
	        				botones[i][j].setPressedIcon(icnClick        );
	        				pnlCentro.add               (botones   [i][j]);  
	        			}
	        		}
				 }est++;
			}
		});*/
		btnRegresar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				crear();
			}
		});
		//Boton Vuelos
		botones[0][0].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlCentro.removeAll();
				pnlCentro.repaint();
				pnlCentro.add(guiVuelos.crear());
				pnlCentro.revalidate();
			}
		});
		//Boton Aviones
		botones[0][3].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlCentro.removeAll();
				pnlCentro.repaint();
				pnlCentro.add(guiAviones.crear());
				pnlCentro.revalidate();
			}
		});
		//Boton Documentos
		/*botones[1][1].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlCentro.removeAll();
				pnlCentro.repaint();
				pnlCentro.add(guiDocumentos.crear());
				pnlCentro.revalidate();
			}
		});*/
		//Boton Rutas
		botones[0][4].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlCentro.removeAll();
				pnlCentro.repaint();
				pnlCentro.add(guiRutas.crear());
				pnlCentro.revalidate();
			}
		});
		//Boton Ofertas
		botones[1][2].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlCentro.removeAll();
				pnlCentro.repaint();
				pnlCentro.add(guiOfertas.crear());
				pnlCentro.revalidate();
			}
		});
	}
	public void crearBotones()
	{
		pnlCentro.removeAll();
		pnlCentro.repaint();
		for (int i=0;i<2;i++)
		{
			for (int j = 0; j < 5; j++) 
			{
				botones[i][j]=new JButton         ();
				botones[i][j].setBorderPainted    (false           );   //Quitar bordes
				botones[i][j].setOpaque           (false           );   //No se muestre el area sobrante
				botones[i][j].setContentAreaFilled(false           ); 
				botones[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				botones[i][j].setIcon             (icnBotones[i][j]);
				botones[i][j].setPressedIcon      (icnPressed[i][j]);
				pnlCentro    .add                 (botones   [i][j]);
			}
		}
		pnlCentro.revalidate();
	}
}
