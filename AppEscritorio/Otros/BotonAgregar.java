package Otros;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import GUIs.GUIPrincipal;
public class BotonAgregar extends JButton
{
	JButton boton;
	public JButton getBoton() {
		return boton;
	}

	public void setBoton(ActionListener pAction) {
		boton.addActionListener(pAction);
	}

	ImageIcon iconoBoton;

	public JButton crear()
	{
		boton     =new JButton  ()                                                   ;
		
		boton.setBorder                (null )     ;
		boton.setOpaque                (false)     ;
		boton.setContentAreaFilled     (false)     ;
		boton.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonAñadir.png")));
		return boton;
	}
}
