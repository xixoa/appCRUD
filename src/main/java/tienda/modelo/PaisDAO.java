
package tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.bean.Pais;
import tienda.conexion.Conexion;

public class PaisDAO {
    public static ArrayList<Pais> listar(){
        //variable empleado
        Pais pa;
        //arreglo deado> e objetos empleados
        ArrayList<Pais> paises=new ArrayList<>();
        //instruccion sql
        String sql="select*from pais";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm=cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs=stm.executeQuery();
            //leer resulsettset y colocar datos en el objeto empleado
            while(rs.next()){
                pa = new Pais();
                //asignar datos del rsultset al objeto empleado 
                pa.setIdpais(rs.getInt("Idpais"));
                pa.setNpais(rs.getString("pais"));
                
                //agregar objeto empleado al arreglo
               paises.add(pa);
            }
            //cerrar objetos
            rs.close();
            cn.close();
            stm.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paises;
    }
    
      
    
         public static void insertar(Pais pa){
         //instruccion sql para instertar empleado
         String sql="insert into pais(pais)values(?)";
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, pa.getNpais());
           
            
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         public static void modificar(Pais pa){
         //instruccion sql para instertar empleado
         String sql="update pais set pais=? where Idpais=?";//"update empleado set nombre=?,apepaterno=?,apematerno=?,cargo=? where idempleado=?"
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, pa.getNpais());
            ps.setInt(2, pa.getIdpais());
            
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         
          public static void eliminar(int codigo){
         //instruccion sql para instertar empleado
         String sql="delete from pais where Idpais=?";
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setInt(1, codigo);
           
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
}
