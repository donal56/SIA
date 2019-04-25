package Otros;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUIs.GUIPrincipal;
import net.miginfocom.swing.MigLayout;

public  class Metodos 
{
	public  JPanel pnlGral = new JPanel();
	public BotonAgregar    btnAgregar   ;
	public BotonEliminar   btnEliminar  ;
	public BotonActualizar btnActualizar;
	public GUIPrincipal    guiPrincipal ;
	
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
		int day   = Integer.parseInt(dd);
		int month = Integer.parseInt(mm) - 1; //0 para Enero, 1 para Febrero, etc.
		int year  = Integer.parseInt(yy);
		//Crear una instancia de Calendar y darle los valores, obtener la fecha en milisegundos
		Calendar calendario = Calendar.getInstance();
		calendario.set(year, month, day);
		long milisegundos = calendario.getTimeInMillis();
		//Retornar el objeto Date creado con los milisegundos
		return new Date(milisegundos); 
	}
	
	//Metodo que creara los botones de asiento
	public JPanel crearAsientos(int pX, int pY)
	{
		int x=pX;
		int y=pY;
		JPanel  panelBtn=new JPanel();
		JButton botones    [][]  ;
		JLabel separador;
		
		botones  = new JButton  [y][x];
		separador= new JLabel();
		int contador=1;
		separador.setPreferredSize(new Dimension(10,200));
		separador.setVisible(true);
		
		String tamaño="";
		String tamaño2="";
		for (int i = -1; i < x; i++)
		{
			if(i==2)
			{
				tamaño+="35";
			}else
			{
				tamaño+="[grow]";
			}
		}
		for (int i = -1; i < y; i++)
		{
			tamaño2+="[grow]";
		}
		//panelBtn.setLayout(new GridLayout(y,x));
		panelBtn.setLayout(new MigLayout("",tamaño,tamaño2));
		panelBtn.setPreferredSize(new Dimension(250,700));
		panelBtn.setOpaque(false);
		
		for (int i=0;i<y;i++)
		{
			for (int j = 0; j < x; j++) 
			{
				botones[i][j]=new JButton         (""+contador+"");
				botones[i][j].setPreferredSize(new Dimension(40,40));					
				panelBtn.add(botones[i][j],"cell"+j+" "+i);	
				contador++;
			}
		}
		panelBtn.setAutoscrolls(true);

		return panelBtn;
	}
}
