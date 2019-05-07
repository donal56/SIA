package Otros;
import java.awt.Color;

public class Aleatorio 
{
	public static Double doble(Double m�ximo)
	{
		return Math.random()*m�ximo;
	}
	public static Integer entero(Integer m�ximo)
	{
		return doble(m�ximo.doubleValue()).intValue();
	}
	public static String letra()
	{
		String[] letra={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","�","o","p","q","r","s","t","u","v","w","y","z"};
		return letra[entero(letra.length)];
	}
	public static String nombre()
	{
		String[] nombre={"Pedro","Mar�a","Juan","Miguel","Alexis","Veronica","Manuel","Jose","Francisco","Adan","Pedro","Gerardo","Danyrel","Angel","Arturo"};
		return nombre[entero(nombre.length)];
	}
	public static Color color()
	{
		Color[] color={Color.WHITE,Color.black};
		return color[entero(color.length)];
	}

}
