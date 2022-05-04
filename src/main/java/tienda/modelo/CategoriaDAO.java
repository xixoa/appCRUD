
package tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.bean.Categoria;
import tienda.conexion.Conexion;


public class CategoriaDAO {
    
     public static ArrayList<Categoria> listar(){
        //variable empleado
        Categoria ca;
        //arreglo deado> e objetos empleados
        ArrayList<Categoria> categorias=new ArrayList<>();
        //instruccion sql
        String sql="select*from categoria";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm=cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs=stm.executeQuery();
            //leer resulsettset y colocar datos en el objeto empleado
            while(rs.next()){
                ca = new Categoria();
                //asignar datos del rsultset al objeto empleado 
                ca.setIdcat(rs.getInt("idcategoria"));
                ca.setNcategoria(rs.getString("categoria"));
                
                //agregar objeto empleado al arreglo
               categorias.add(ca);
            }
            //cerrar objetos
            rs.close();
            cn.close();
            stm.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }
    
      
    
         public static void insertar(Categoria ca){
         //instruccion sql para instertar empleado
         String sql="insert into categoria(categoria)values(?)";
         //"insert into empleado(nombre,apepaterno,apematerno,cargo)values(?,?,?,?)";
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, ca.getNcategoria());
           
            
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         public static void modificar(Categoria ca){
         //instruccion sql para instertar empleado
         String sql="update categoria set categoria=? where idcategoria=?";//"update empleado set nombre=?,apepaterno=?,apematerno=?,cargo=? where idempleado=?"
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, ca.getNcategoria());
            ps.setInt(2, ca.getIdcat());
            
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         
          public static void eliminar(int codigo){
         //instruccion sql para instertar empleado
         String sql="delete from categoria where idcategoria=?";
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
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
}
