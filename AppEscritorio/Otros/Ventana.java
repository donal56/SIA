package Otros;

import javax.swing.JFrame;

public abstract class Ventana extends JFrame
{
	public Ventana(String tipo)
	{
		this("Nueva ventana",tipo);
	}
	public Ventana(String pTítulo,String tipo)
	{
		this(pTítulo,600,600,tipo);
	}
	public Ventana(String pTítulo,Integer pAncho,Integer pLargo,String tipo)
	{
		this(pTítulo,pAncho,pLargo,false,tipo);
	}
	public Ventana(String pTítulo,Integer pAncho,Integer pLargo,Boolean pPrincipal,String tipo)
	{
		this(pTítulo,pAncho,pLargo,pPrincipal,-1,-1,tipo);
	}
	public Ventana(String pTítulo,Integer pAncho,Integer pLargo,Boolean pPrincipal,Integer pX,Integer pY,String tipo)
	{
		this.setTitle(pTítulo);
		this.setSize(pAncho,pLargo);
		if(pX==-1 && pY==-1)
		{
			this.setLocationRelativeTo(null);
		}
		else
		{
			this.setLocation(pX,pY);
		}
		if(pPrincipal)
		{
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else
		{
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		crear(tipo);
		this.setVisible(true);
	}
	
	public abstract void crear(String tipo);
}
