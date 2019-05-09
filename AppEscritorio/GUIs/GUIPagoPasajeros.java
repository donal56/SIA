package GUIs;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class GUIPagoPasajeros extends JDialog {
	private ArrayList<String[]> infoPasajeros;
	private int numPasajeros;

	public GUIPagoPasajeros(JFrame padre, int numPasajeros) {
		super(padre, true);
		this.numPasajeros = numPasajeros;
		setBounds(100, 100, 450, 300);

		setLocationRelativeTo(null);
	}

	public ArrayList<String[]> registrarPasajeros() {
		this.setVisible(true);
		return infoPasajeros;
	}
	
	private void guardarPasajero() {		
		//Obtener el texto de los textField
		//Crear array de strings para guardar los datos de un pasajero
		//Agregar el array al ArrayList infoPasajeros
		//Limpiar textFields
		if (numPasajeros == 2) {
			//Cambiar el texto del boton
		} 
		if (numPasajeros == 1) 
			botonCancelarAccion();
		numPasajeros--;		
	}
	
	private void botonCancelarAccion() {
		this.dispose();
		( (JFrame)(this.getParent()) ).dispose();
	}
}
