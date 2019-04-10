package Otros;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUIs.*;

public  class Metodos 
{
	public  JPanel pnlGral = new JPanel();
	public BotonAgregar    btnAgregar   ;
	public BotonEliminar   btnEliminar  ;
	public BotonActualizar btnActualizar;
	
	
	public JPanel crearBotones(Boolean pBtnAgregar,Boolean pBtnEliminar,Boolean pBtnActualizar,int tipo,Frame padre)
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
			listenerBtnAgregar(tipo, padre);
			//btnAgregar .crear    ()
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
	
	public void listenerBtnAgregar(int tipo, Frame padre) {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipo) {
					case 1:
						GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar(padre, true);
						guiVuelos.setVisible(true);
						break;
					case 4:
						GUIAvionesAgregar guiAviones = new GUIAvionesAgregar(padre, true);
						guiAviones.setVisible(true);
						break;
					case 5:
						GUIRutasAgregar guiRutas = new GUIRutasAgregar(padre, true);
						guiRutas.setVisible(true);
						break;
					case 8:
						GUIOfertasAgregar guiOfertas = new GUIOfertasAgregar(padre, true);
						guiOfertas.setVisible(true);
						break;
				}
			}
		});
	}
	
	public void listenerBtnActualizar(int tipo, Frame padre) {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipo) {
					case 1:
						GUIVuelosAgregar guiVuelos = new GUIVuelosAgregar(padre, true);
						guiVuelos.setVisible(true);
						break;
					case 4:
						GUIAvionesAgregar guiAviones = new GUIAvionesAgregar(padre, true);
						guiAviones.setVisible(true);
						break;
				}
			}
		});	
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
