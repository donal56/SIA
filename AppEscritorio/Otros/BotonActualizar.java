package Otros;

import java.awt.Cursor           ;
import javax.swing.ImageIcon     ;
import javax.swing.JButton       ;
import GUIs.GUIPrincipal         ;

public class BotonActualizar extends JButton
{
	JButton   boton     ;
	ImageIcon iconoBoton;

	public JButton crear()
	{
		boton     =new JButton  ()                 ;
		
		boton.setBorder                (null )     ;
		boton.setOpaque                (false)     ;
		boton.setContentAreaFilled     (false)     ;
		boton.setSelectedIcon          (null)      ;
		boton.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonActualizar.png"     )));
		boton.setSize(100,100);
		return boton;
	}
}
