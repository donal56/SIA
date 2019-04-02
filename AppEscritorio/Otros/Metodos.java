package Otros;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public  class Metodos 
{
	public  JPanel pnlGral = new JPanel();
	private BotonAgregar    btnAgregar   ;
	private BotonEliminar   btnEliminar  ;
	private BotonActualizar btnActualizar;
	
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
