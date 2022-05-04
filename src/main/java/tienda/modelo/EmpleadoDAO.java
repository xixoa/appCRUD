
package tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.bean.Empleado;
import tienda.conexion.Conexion;

public class EmpleadoDAO {
    public static ArrayList<Empleado> listar(){
        //variable empleado
        Empleado emp;
        //arreglo deado> e objetos empleados
        ArrayList<Empleado> empleados=new ArrayList<>();
        //instruccion sql
        String sql="select*from empleado";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm=cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs=stm.executeQuery();
            //leer resulsettset y colocar datos en el objeto empleado
            while(rs.next()){
                emp = new Empleado();
                //asignar datos del rsultset al objeto empleado 
                emp.setIdemp(rs.getInt("idempleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setPaterno(rs.getString("apepaterno"));
                emp.setMaterno(rs.getString("apematerno"));
                emp.setCargo(rs.getString("cargo"));
                //agregar objeto empleado al arreglo
                empleados.add(emp);
            }
            //cerrar objetos
            rs.close();
            cn.close();
            stm.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    
     
    
         public static void insertar(Empleado emp){
         //instruccion sql para instertar empleado
         String sql="insert into empleado(nombre,apepaterno,apematerno,cargo)values(?,?,?,?)";
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPaterno());
            ps.setString(3, emp.getMaterno());
            ps.setString(4, emp.getCargo());
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         public static void modificar(Empleado emp){
         //instruccion sql para instertar empleado
         String sql="update empleado set nombre=?,apepaterno=?,apematerno=?,cargo=? where idempleado=?";
         //conexion a la bd
         Connection cn=Conexion.abrir();
        try {
            //ejectua la sql usando la conexion cn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPaterno());
            ps.setString(3, emp.getMaterno());
            ps.setString(4, emp.getCargo());
            ps.setInt(5, emp.getIdemp());
            //ejecutar
            ps.executeUpdate();//para instert update, delete
            
            //cerrar objetos
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         
          public static void eliminar(int codigo){
         //instruccion sql para instertar empleado
         String sql="delete from empleado where idempleado=?";
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
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         
         
         
    
}
