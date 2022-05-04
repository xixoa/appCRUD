
package tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.bean.Articulo;
import tienda.conexion.Conexion;


public class ArticuloDAO {
    
     public static ArrayList<Articulo> Listar(){
        //variable Articulo
        Articulo art;
        //arreglo de obejots emplados
        ArrayList<Articulo> articulos = new ArrayList<>();
        //instruccion sql
        String sql="select* from articulo";
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            //ejercutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultset y colocar los datos en el objeto empleado
            while(rs.next()){
                art = new Articulo();
                art.setIdarticulo(rs.getInt("idarticulo"));
                art.setIdcategoria(rs.getInt("idcategoria"));
                art.setNombre(rs.getString("nombre"));
                art.setDescripcion(rs.getString("descripcion"));
                art.setPrecio(rs.getInt("precio"));
                //agregar objeto empleado al arreglo
                articulos.add(art);
            }
            //cerrar objetos
            rs.close();
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error:"+ex.getMessage());
        }
        
        
        return articulos;
    }
    
    public static void insertar(Articulo art){
        //instruccion sql para insertar
        String sql= "insert into articulo(idcategoria,nombre,descripcion,precio)values(?,?,?,?)";
        //conexion a la BD
        Connection cn = Conexion.abrir();
        try {
            //ejercutar la sql usando la conexion cn
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setInt(1, art.getIdcategoria());
            ps.setString(2, art.getNombre());
            ps.setString(3, art.getDescripcion());
            ps.setInt(4, art.getPrecio());
            //ejercutar
            ps.executeUpdate();//para insert,update,delete
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("error"+ex.getMessage());
        }
    }
    
    public static void Modificar(Articulo art){
        //instruccion sql para insertar
        String sql= "update articulo set nombre =?,descripcion =?, precio =? where idarticulo =?";
        //conexion a la BD
        Connection cn = Conexion.abrir();
        try {
            //ejercutar la sql usando la conexion cn
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, art.getNombre());
            ps.setString(2, art.getDescripcion());
            ps.setInt(3, art.getPrecio());
            ps.setInt(4, art.getIdarticulo());
            //ejercutar
            ps.executeUpdate();//para insert,update,delete
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("error"+ex.getMessage());
        }
    }
    
    public static void Eliminar(int codigo){
        //instruccion sql para insertar
        String sql= "delete from articulo where idarticulo =?";
        //conexion a la BD
        Connection cn = Conexion.abrir();
        try {
            //ejercutar la sql usando la conexion cn
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setInt(1, codigo);
            //ejercutar
            ps.executeUpdate();//para insert,update,delete
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("error"+ex.getMessage());
        }
    }
         
    
}
