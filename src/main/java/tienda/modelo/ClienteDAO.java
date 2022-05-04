
package tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.bean.Cliente;
import tienda.bean.Pais;
import tienda.conexion.Conexion;


public class ClienteDAO {
    
   
    
    
     public static ArrayList<Cliente> listar(){
       
        Cliente cli;
        
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
       
        String sql="select*from cliente";
       
        Connection cn=Conexion.abrir();
        
        try {
            PreparedStatement stm=cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un rs
            ResultSet rs=stm.executeQuery();
            
            while(rs.next()){
                
                cli=new Cliente();
                
                cli.setIdcliente(rs.getInt("idcliente"));
                cli.setClienteap(rs.getString("apellidos"));
                cli.setClientenom(rs.getString("nombres"));
                cli.setClienteemail(rs.getString("email"));
                cli.setIdpais(rs.getInt("Idpais"));                
                
                clientes.add(cli);

            }
            //cerrar objetos
            rs.close();
            stm.close();
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
      return clientes;  
    }
     
     
     public static void insertar(Cliente cli){
        
        String sql="insert into cliente (nombres, apellidos, email, Idpais)values(?, ?, ?, ?)";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        
        try {
            //ejecutar la instruccion sql usando la conexioncn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, cli.getClientenom());
            ps.setString(2, cli.getClienteap());
            ps.setString(3, cli.getClienteemail());
            ps.setInt(4, cli.getIdpais());
            //ejecutar
            ps.executeUpdate();//para insertar, update, eliminar
            
            //cerrar objetos
            cn.close();
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void modificar(Cliente cli){
        
        String sql="update cliente set nombres=?, apellidos=?, email=?, Idpais=? where idcliente=? ";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        
        try {
            //ejecutar la instruccion sql usando la conexioncn
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setString(1, cli.getClientenom());
            ps.setString(2, cli.getClienteap());
            ps.setString(3, cli.getClienteemail());
            ps.setInt(4, cli.getIdpais());
            ps.setInt(5, cli.getIdcliente());
            //ejecutar
            ps.executeUpdate();//para insertar, update, eliminar
            
            //cerrar objetos
            cn.close();
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void eliminar(int codigo){
        
        String sql="delete from cliente where idcliente=? ";
        //conexion a la base de datos
        Connection cn=Conexion.abrir();
        
        try {
          
            PreparedStatement ps=cn.prepareStatement(sql);
            //asignar valores a los parametros
            ps.setInt(1, codigo);
            //ejecutar
            ps.executeUpdate();//para insertar, update, eliminar
            
            //cerrar objetos
            cn.close();
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    
}
