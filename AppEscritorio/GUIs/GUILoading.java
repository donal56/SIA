package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUILoading implements Runnable{
	public static JFrame frame;
	public static Thread t;

	public static void start() {
		t = new Thread(new GUILoading());
		t.start();
	}
	
	public static void stop() {
	
	}

	@Override
	public void run() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL imageURL   = cldr.getResource("img/plane_load.gif");
		JLabel label = new JLabel(new ImageIcon(imageURL));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		panel.add(label);
		panel.setBackground(new Color(45,186,209));
	   
		frame = new JFrame();
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setUndecorated(true);
		frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 500, 100, 100));
		frame.setLocationRelativeTo(null);
		frame.setOpacity(.6f);
		frame.setVisible(true);
		
	}
	
	

}
