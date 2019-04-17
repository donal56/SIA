package Otros;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUIs.GUIAvionesAgregar;
import GUIs.GUIOfertasAgregar;
import GUIs.GUIRutasAgregar;
import GUIs.GUIVuelosAgregar;
public  class Metodos 
{
	public  JPanel pnlGral = new JPanel();
	public BotonAgregar    btnAgregar   ;
	public BotonEliminar   btnEliminar  ;
	public BotonActualizar btnActualizar;
	
	public JPanel crearBotones(Boolean pBtnAgregar,Boolean pBtnEliminar,Boolean pBtnActualizar)

	{
		btnAgregar   =new BotonAgregar    ();
		btnEliminar  =new BotonEliminar   ();
		btnActualizar=new BotonActualizar ();
		
		
		//Condiciones para los botones
		if (pBtnAgregar==false)
		{
			btnAgregar.setVisible(false);
		}
		else
		{
			pnlGral.add(btnAgregar .crear    ());
		}
		if (pBtnEliminar==false)
		{
			btnEliminar.setVisible(false);
		}
		else
		{
			pnlGral.add(btnEliminar.crear    ());
		}
		if (pBtnActualizar==false)
		{
			btnActualizar.setVisible(false);
		}
		else
		{
			pnlGral.add(btnActualizar.crear  ());
		}
		pnlGral.setBackground(Color.white)  ;
		return pnlGral;
	}
	
	//Metodo para agregar el actionListener al boton Agregar segun el parametro dado
	public void listenerBtnAgregar(int tipo) {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipo) {
					case 1:
						GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar();
						guiVuelos.setVisible(true);
						break;
					case 4:
						GUIAvionesAgregar guiAviones = new GUIAvionesAgregar();
						guiAviones.setVisible(true);
						break;
					case 5:
						GUIRutasAgregar guiRutas = new GUIRutasAgregar();
						guiRutas.setVisible(true);
						break;
					case 8:
						GUIOfertasAgregar guiOfertas = new GUIOfertasAgregar();
						guiOfertas.setVisible(true);
						break;
				}
			}
		});
	}
	
	//Metodo para agregar el actionListener al boton Actualizar segun el parametro dado (en construccion)
	public void listenerBtnActualizar(int tipo, Frame padre) {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipo) {
					case 1:
						GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar();
						guiVuelos.setVisible(true);
						break;
					case 4:
						GUIAvionesAgregar guiAviones = new GUIAvionesAgregar();
						guiAviones.setVisible(true);
						break;
				}
			}
		});	
	}
	
	//Metodo para llenar las tablas dando la tabla a llenar y el query a ejecutar
	public void llenarTabla (JTable tabla, String call) {
		Conexion con = new Conexion();
		DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
		try {
			ResultSet resultados = con.obtenerDatos(call);
			int numColumnas = resultados.getMetaData().getColumnCount();
			Object[] fila = new Object[numColumnas];
			while (resultados.next()) {
				for (int i = 1; i <= numColumnas; i++) 
	                fila[i - 1] = resultados.getString(i);
				modeloTabla.addRow(fila);
			}
			con.cerrarConexion();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
