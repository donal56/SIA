package Otros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//La clase instructor contiene los objetos y metodos necesarios para realizar 
//operaciones en la base de datos de manera mas sencilla

public class Conexion {
    //Objeto que maneja la conexion
    Connection conexion = null;
    //Objeto que contendra la instruccion a realizar
    Statement declaracion = null;
    //Objeto que tendra el contenido de la consulta
    ResultSet resultado = null;
    
    //Constructor que abre la conexion con la base de datos
    public Conexion() {
    	//Nombre de usuario de la base de datos
        String usuario = "sia2019_root";
        //Contrasena del usuario de la base de datos
        String clave = "intellideskSIA";
        //String de conexion a la base de datos, lleva escrito la maquina donde
        //se encuentra la base de datos, el nombre de la base de datos, usar SSL
        //como falso, establecer la zona horaria a UTC y permitir multiples queries
        String sentencia = "jdbc:mysql://ricky.heliohost.org:3306/sia2019_db" + 
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&" +
            "allowMultiQueries=true";
        //Pasamos los parametros a la conexion
        try {
        	conexion = DriverManager.getConnection(sentencia, usuario, clave);
        	//System.out.println("Exito en la conexion");
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
    }
    
    //Metodo que realiza una operacion y que devuelve un ResultSet. Este metodo
    //se usa cada vez que se quiera obtener informacion de la base de datos,
    //tambien requiere el manejo de excepcion por parte de la clase que llame al
    //metodo. 
    public ResultSet obtenerDatos(String operacion) throws SQLException{
    	//Asigar un objeto Statement a declaracion
        declaracion = conexion.createStatement();
        //Ejecutar la operacion
        declaracion.execute(operacion);
        //Asignar a resultado el ResultSet generado en la ejecucion anterior
        resultado = declaracion.getResultSet();
        return resultado;
    }
    
    //Este metodo arroja un error con la misma logica anterior. Este metodo es 
    //usado para operaciones de insercion, modificado y borrado en la base de 
    //datos ya que no se requiere un valor de retorno
    public void realizarOperacion(String operacion) throws SQLException{
		declaracion = conexion.createStatement();
        declaracion.execute(operacion);
        //Si no hubo ningun error, se manda un mensaje de confirmacion
        JOptionPane.showMessageDialog(null, "Operacion "
                        + "realizada correctamente", "Operacion correcta", 
                        JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Metodo que cierra la conexion a la base de datos, debe ser llamado por la
    //misma clase que halla llamado a los metodos de operaciones anteriores
    public void cerrarConexion() throws SQLException{
        if (resultado != null) {
			resultado.close();
			resultado = null;
        }    
        if (declaracion != null) {
            declaracion.close();
            declaracion = null;
        }
        if (conexion != null) {
        	conexion.close();
        	conexion = null;
        }
    }
}

