package Otros;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import GUIs.GUIPrincipal;

public class BotonEliminar extends JButton
{
	JButton boton;
	ImageIcon iconoBoton;

	public JButton crear()
	{
		boton     =new JButton  ()                                                   ;
		
		boton.setBorder                (null )     ;
		boton.setOpaque                (false)     ;
		boton.setContentAreaFilled     (false)     ;
		boton.setSelectedIcon          (null)      ;
		boton.setIcon                  (iconoBoton);
		boton.setHorizontalTextPosition(SwingConstants.CENTER)                         ;
		boton.setCursor                (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton.setIcon                  (new ImageIcon(GUIPrincipal.class.getResource("/img/icnBotonEliminar.png"     )));
		return boton;
	}
	
	@Override
	public void addActionListener(ActionListener pAction) {
		boton.addActionListener(pAction);
	}
}
