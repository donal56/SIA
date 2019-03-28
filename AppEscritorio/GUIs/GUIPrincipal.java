package GUIs;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Otros.Ventana;
import java.awt.Color;
import java.awt.Toolkit;


/*Esta GUI es la que aloja el menu principal de la aplicacción de escritorio, se extiende de una clase Ventana donde le doy formato a la 
ventana que se creara por medio del metodo crear*/



/*Modificación 1: Se le agrego el layout y el encabezado de la pagina, icono de la ventana, se le anexo el pressed a los botones*/
public class GUIPrincipal extends Ventana
{

	Container contenedorGral   ;
	JPanel    pnlEncabezado    ,
			  pnlCentro        ,
			  pnlPie           ;
	ImageIcon icnBotones [][]  ,
			  icnPressed [][]  ;
	JButton   botones    [][]  ;
	JLabel    lblEncabezado    ;
	public GUIPrincipal()
	{
		super("Principal",1360,700,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPrincipal.class.getResource("/img/IconoLogin.png")));
		setAutoRequestFocus(false);
		setResizable  (false);

	}

	public void crear() 
	{

		//Formato contenedor general
		contenedorGral=new Container ()              ;
		contenedorGral.setLayout     (null)          ;
		this          .setContentPane(contenedorGral);
		contenedorGral.setBackground (Color.white)   ;
		
		//Inicializamos los panel
		pnlEncabezado=new JPanel();
		pnlCentro    =new JPanel();   //Contenedor que se va a actualizar al presionar un boton
		pnlPie       =new JPanel();
		
		
		//Se asignan tamaños absolutos a los contenedores
		pnlEncabezado.setBounds(10 , 0, 1330, 70);
		pnlCentro    .setBounds(10, 70, 1330,600);
		pnlPie       .setBounds(0 ,650, 1365, 30);

		//Formato para los paneles
		pnlCentro.setLayout(new GridLayout(2,5));
		pnlCentro.setBackground(Color.white);
		pnlEncabezado.setLayout(new GridLayout(1,2));
		pnlEncabezado.setBackground(Color.white);
		
		//Se inserta logo del encabezado y se da formato
		lblEncabezado= new JLabel   ("")                                                                     ;
		lblEncabezado.setIcon       (new ImageIcon(GUIPrincipal.class.getResource("/img/icnEncabezado.png"))); 
		pnlEncabezado.add           (lblEncabezado)                                                          ;
		
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
		for (int i=0;i<2;i++)
		{
			for (int j = 0; j < 5; j++) 
			{
				botones[i][j]=new JButton         ();
				botones[i][j].setBorderPainted    (false);              //Quitar bordes
				botones[i][j].setOpaque           (false);			    //No se muestre el area sobrante
				botones[i][j].setContentAreaFilled(false);              
				botones[i][j].setIcon             (icnBotones[i][j]);
				botones[i][j].setPressedIcon      (icnPressed[i][j]);
				pnlCentro.add                     (botones[i][j]   );
			}
		}
			
		//Agregamos los paneles al contenedor gral
		contenedorGral.add(pnlEncabezado);
		contenedorGral.add(pnlCentro    );
		contenedorGral.add(pnlPie       );
	}
}
