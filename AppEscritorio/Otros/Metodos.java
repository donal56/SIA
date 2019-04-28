package Otros;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	public JButton botones    [][]  ;
	public int x,y,contador,ctd;
	
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
			ResultSet rsOcupados = con.obtenerDatos(call);
			int numColumnas = rsOcupados.getMetaData().getColumnCount();
			Object[] fila = new Object[numColumnas];
			while (rsOcupados.next()) {
				for (int i = 1; i <= numColumnas; i++) 
	                fila[i - 1] = rsOcupados.getString(i);
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
		x=pX;
		y=pY;
		JPanel  panelBtn=new JPanel();
		JLabel separador;
		
		botones  = new JButton  [y][x];
		separador= new JLabel();
		contador=1;
		separador.setPreferredSize(new Dimension(10,200));
		separador.setVisible(true);
		
		String tamaño="";
		String tamaño2="";
		for (int i = -1; i < x; i++)
		{
			if(i==2)
			{
				tamaño+="50";
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
		panelBtn.setPreferredSize(new Dimension(325,1200));
		panelBtn.setOpaque(false);
		
		for (int i=0;i<y;i++)
		{
			for (int j = 0; j < x; j++) 
			{
				botones[i][j]=new JButton         (""+contador+"");
				botones[i][j].setPreferredSize(new Dimension(100,100));					
				panelBtn.add(botones[i][j],"cell"+j+" "+i);
				/*if(contador>pMax)
				{
					botones[i][j].setVisible(false);
				}*/
				contador++;
			}
		}
		return panelBtn;
	}

	public JButton[][] getBotones() {
		return botones;
	}

	public void setActionBotones(JTextField ptxt, JTextField pClase) throws SQLException 
	{
		Conexion con=new Conexion();
		ResultSet rsOcupados = con.obtenerDatos("SELECT noAsiento FROM boletos b WHERE vuelos_idVuelo=1 and b.status <>2; ");
		ResultSet rsClase    = con.obtenerDatos("SELECT asientoInicio,asientoFin FROM vuelos v INNER JOIN aviones a INNER JOIN asientosAvion aa ON v.aviones_idAvion=a.idAvion AND "
				+ "a.modelosAvion_idModelo=aa.modelosAvion_idModelo WHERE idVuelo=1 ORDER BY asientoInicio;");
		ArrayList <Integer > listaOcupados = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> listaClases   =new ArrayList<ArrayList<Integer>>();
		while (rsOcupados.next()) 
		{
			listaOcupados.add(rsOcupados.getInt(1));
		}
		listaClases.add(new ArrayList<Integer>());
		listaClases.add(new ArrayList<Integer>());
		while(rsClase.next())
		{
			listaClases.get(0).add(rsClase.getInt(1));
			listaClases.get(1).add(rsClase.getInt(2));
		}
		con.cerrarConexion();

		
		 ctd=1;
		
		for (int i = 0; i < y; i++)
		{
			for (int j = 0; j < x; j++) 
			{
				for (int j2 = 0; j2 < listaOcupados.size(); j2++) 
				{
					if(ctd==(listaOcupados.get(j2)))
					{
						botones[i][j].setEnabled(false);
					}
				}
				if (ctd<=(listaClases.get(1).get(0))) 
				{
					botones[i][j].setBackground(new Color(188,175,103));
				}
				if (ctd>=listaClases.get(0).get(1) & ctd<=listaClases.get(1).get(1)) 
				{
					botones[i][j].setBackground(new Color(71,255,78));
				}
				if (ctd>=listaClases.get(0).get(2)) 
				{
					botones[i][j].setBackground(new Color(108,112,236));
				}
				botones[i][j].addActionListener(new ActionListener() 
				{
					Integer contador2=ctd;
					public void actionPerformed(ActionEvent e) 
					{
						ptxt.setText(contador2.toString());
						if(contador2<=(listaClases.get(1).get(0)))
						{
							pClase.setText("Vip");
						}
						if (contador2>=listaClases.get(0).get(1) & contador2<=listaClases.get(1).get(1)) 
						{
							pClase.setText("Ejecutivo");
						}
						if (contador2>=listaClases.get(0).get(2)) 
						{
							pClase.setText("Turista");
						}
					}
				});
				ctd++;
			}
		}
	}

}
