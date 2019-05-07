package Otros;
import java.awt.Color;

public class Aleatorio 
{
	public static Double doble(Double máximo)
	{
		return Math.random()*máximo;
	}
	public static Integer entero(Integer máximo)
	{
		return doble(máximo.doubleValue()).intValue();
	}
	public static String letra()
	{
		String[] letra={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","y","z"};
		return letra[entero(letra.length)];
	}
	public static String nombre()
	{
		String[] nombre={"Pedro","María","Juan","Miguel","Alexis","Veronica","Manuel","Jose","Francisco","Adan","Pedro","Gerardo","Danyrel","Angel","Arturo"};
		return nombre[entero(nombre.length)];
	}
	public static Color color()
	{
		Color[] color={Color.WHITE,Color.black};
		return color[entero(color.length)];
	}

}
