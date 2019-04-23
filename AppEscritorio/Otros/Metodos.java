package Otros;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
	
	//Metodo para llenar las tablas dando la tabla a llenar y el query a ejecutar
	public void llenarTabla(JTable tabla, String call) {
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
	
	//Metodo que toma una fecha en string dd/mm/yy y devuelve un objeto Date que representa esa fecha 
	public Date obtenerFecha(String fecha) {
		//Obtener las subcadenas de la fecha
		String dd = fecha.substring(0, 2);
		String mm = fecha.substring(3, 5);
		String yy = fecha.substring(6);
		//Convertir las strings a int
		int day = Integer.parseInt(dd);
		int month = Integer.parseInt(mm) - 1; //0 para Enero, 1 para Febrero, etc.
		int year = Integer.parseInt(yy);
		//Crear una instancia de Calendar y darle los valores, obtener la fecha en milisegundos
		Calendar calendario = Calendar.getInstance();
		calendario.set(year, month, day);
		long milisegundos = calendario.getTimeInMillis();
		//Retornar el objeto Date creado con los milisegundos
		return new Date(milisegundos); 
	}
}
