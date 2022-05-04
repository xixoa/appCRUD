
package tienda.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static String url="jdbc:mysql://localhost/tiendadeportes2";
    private static String usuario="root";
    private static String password="";
    private static Connection cn=null;
    
    public static Connection abrir(){
        try {
            //registrar el dirver del sql(es el que esta en la dependencia, osea el que se descargo)
            Class.forName("com.mysql.jdbc.Driver");
            //abrir conexion
            cn=DriverManager.getConnection(url, usuario, password);
        } catch (Exception ex) {
            System.out.println("Error de la conexion: "+ex.getMessage());
        }
    return cn;
    }
    
    
}
