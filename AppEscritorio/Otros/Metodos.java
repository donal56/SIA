package Otros;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
		
		btnAgregar.setBoton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("btnActualizar");
			}
		});
		
		
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
