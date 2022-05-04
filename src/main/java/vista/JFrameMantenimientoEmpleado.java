
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tienda.bean.Articulo;
import tienda.bean.Categoria;
import tienda.bean.Cliente;
import tienda.bean.Empleado;
import tienda.bean.Pais;
import tienda.modelo.ArticuloDAO;
import tienda.modelo.CategoriaDAO;
import tienda.modelo.ClienteDAO;
import tienda.modelo.EmpleadoDAO;
import tienda.modelo.PaisDAO;

public class JFrameMantenimientoEmpleado extends javax.swing.JFrame {

    
    public JFrameMantenimientoEmpleado() {
        initComponents();
        setTitle("Mantenimiento");
    }
    
    void grabarEmpleado(){
     if(txtnom.getText().length()!=0 && txtapa.getText().length()!=0 && txtama.getText().length()!=0 && txtca.getText().length()!=0){   
    //crear objeto empleado
    Empleado emp=new Empleado(txtnom.getText(), txtapa.getText(), txtama.getText(), txtca.getText());
    //agregar empleado a la base de datos
    EmpleadoDAO.insertar(emp);
    listarTodosEmpleados();
    
    }else{
    mensaje("Ingrese datos del empleado");
    }
            
    }
    
   void listarTodosEmpleados(){
        String c[]={"Id","Nombre","Apellido Paterno","Apellido Materno","Cargo"};
        DefaultTableModel md=new DefaultTableModel(null,c);
        //asignar modelo a la tabla
        jTableTodosEmpleados.setModel(md);
        //agregar datos al modelo
        ArrayList<Empleado> lista=EmpleadoDAO.listar();
        for (Empleado x : lista) {
            md.addRow(new Object[]{x.getIdemp(),x.getNombre(),x.getPaterno(),x.getMaterno(),x.getCargo()});
            
        }
    }
   
   void seleccionarEmpleado(){
   //seleccionar fila de la tabla
   int reg= jTableTodosEmpleados.getSelectedRow();
   
   txtcod.setText(String.valueOf(jTableTodosEmpleados.getValueAt(reg, 0)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 0
   txtnom.setText(String.valueOf(jTableTodosEmpleados.getValueAt(reg, 1)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 1
   txtapa.setText(String.valueOf(jTableTodosEmpleados.getValueAt(reg, 2)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 2
   txtama.setText(String.valueOf(jTableTodosEmpleados.getValueAt(reg, 3)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 3
   txtca.setText(String.valueOf(jTableTodosEmpleados.getValueAt(reg, 4)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 4
 
   }
   
   void modificar(){
   //crear objeto empleado
    Empleado emp=new Empleado(txtnom.getText(), txtapa.getText(), txtama.getText(), txtca.getText());
    //asignar valor al codigo
    emp.setIdemp(Integer.parseInt(txtcod.getText()));
    //modificar empleado a la base de datos
    EmpleadoDAO.modificar(emp);
    //listar empleados
    listarTodosEmpleados();
   }
   
   void eliminar(){
   EmpleadoDAO.eliminar(Integer.parseInt(txtcod.getText()));
   listarTodosEmpleados();
   }
   
   void nuevoEmpleado(){
   txtcod.setText("");
   txtnom.setText("");
   txtapa.setText("");
   txtama.setText("");
   txtca.setText("");
   }
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   void grabarPais(){
     if(txtnom1.getText().length()!=0){   
    //crear objeto empleado
    Pais pa=new Pais(txtnom1.getText());
    //agregar empleado a la base de datos
    PaisDAO.insertar(pa);
    listarTodosPaises();
    
    }else{
    mensaje("Ingrese datos del país");
    }
            
    }
    
   void listarTodosPaises(){
        String c[]={"Id","Pais"};
        DefaultTableModel md=new DefaultTableModel(null,c);
        //asignar modelo a la tabla
        jTableTodosPaises.setModel(md);
        //agregar datos al modelo
        ArrayList<Pais> lista=PaisDAO.listar();
        for (Pais x : lista) {
            md.addRow(new Object[]{x.getIdpais(),x.getNpais()});
            
        }
    }
   
   void seleccionarPais(){
   //seleccionar fila de la tabla
   int reg= jTableTodosPaises.getSelectedRow();
   
   txtcod1.setText(String.valueOf(jTableTodosPaises.getValueAt(reg, 0)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 0
   txtnom1.setText(String.valueOf(jTableTodosPaises.getValueAt(reg, 1)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 1
  
 
   }
   
   void modificarPais(){
   //crear objeto empleado
    Pais pa=new Pais(txtnom1.getText());
    //asignar valor al codigo
    pa.setIdpais(Integer.parseInt(txtcod1.getText()));
    //modificar empleado a la base de datos
    PaisDAO.modificar(pa);
    //listar empleados
    listarTodosPaises();
   }
   
   
   void eliminarPais(){
   PaisDAO.eliminar(Integer.parseInt(txtcod1.getText()));
   listarTodosPaises();
   }
   
   void limpiarPais(){
   txtcod1.setText("");
   txtnom1.setText("");
   }
   
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    void grabarCategoria(){
     if(txtnom2.getText().length()!=0){   
    //crear objeto empleado
    Categoria ca=new Categoria(txtnom2.getText());
    //agregar empleado a la base de datos
    CategoriaDAO.insertar(ca);
    listarTodosPaises();
    
    }else{
    mensaje("Ingrese datos de la categoria");
    }
            
    }
    
   void listarTodosCategorias(){
        String c[]={"Id","Categoria"};
        DefaultTableModel md=new DefaultTableModel(null,c);
        //asignar modelo a la tabla
        jTableTodosCategorias.setModel(md);
        //agregar datos al modelo
        ArrayList<Categoria> lista=CategoriaDAO.listar();
        for (Categoria x : lista) {
            md.addRow(new Object[]{x.getIdcat(),x.getNcategoria()});
            
        }
    }
   
   void seleccionarCategoria(){
   //seleccionar fila de la tabla
   int reg= jTableTodosCategorias.getSelectedRow();
   
   txtcod2.setText(String.valueOf(jTableTodosCategorias.getValueAt(reg, 0)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 0
   txtnom2.setText(String.valueOf(jTableTodosCategorias.getValueAt(reg, 1)));// DE LA FILA SELECCIONADA MUESTRAME EL valor de la columna 1
  
 
   }
   
  
   
   void modificarCategoria(){
   //crear objeto empleado
    Categoria ca=new Categoria(txtnom2.getText());
    //asignar valor al codigo
    ca.setIdcat(Integer.parseInt(txtcod2.getText()));
    //modificar empleado a la base de datos
    CategoriaDAO.modificar(ca);
    //listar empleados
    listarTodosCategorias();
   }
   
   
   
   void eliminarCategoria(){
   CategoriaDAO.eliminar(Integer.parseInt(txtcod2.getText()));
   listarTodosCategorias();
   }
   
   void limpiarCategoria(){
   txtcod2.setText("");
   txtnom2.setText("");
   }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 void seleccionarcliente(){
        //seleccionar fila de la tabla
        int reg=jTableTodosCliente.getSelectedRow();
        txtcod3.setText(String.valueOf(jTableTodosCliente.getValueAt(reg, 0)));
        txtnom3.setText(String.valueOf(jTableTodosCliente.getValueAt(reg, 1))); 
        txtapa1.setText(String.valueOf(jTableTodosCliente.getValueAt(reg, 2))); 
        txtemailc.setText(String.valueOf(jTableTodosCliente.getValueAt(reg, 3))); 
        txtidpais.setText(String.valueOf(jTableTodosCliente.getValueAt(reg, 4))); 
    }
    
    void limpiarCliente(){
        txtcod3.setText("");
        txtnom3.setText("");
        txtapa1.setText("");
        txtemailc.setText("");
        txtidpais.setText("");
        txtnom3.requestFocus();
   
    }
    
    
    void listarCliente(){
        
        String c[]={"IdCliente","Nombres", "Apellidos", "Email", "IdPais"};
        DefaultTableModel md=new DefaultTableModel(null,c);
        //Asignar modelo a la tabla
        jTableTodosCliente.setModel(md);
        //agregar datos al modelo
        ArrayList<Cliente> lista=ClienteDAO.listar();
        for(Cliente x: lista){
            md.addRow(new Object[]{x.getIdcliente(), x.getClientenom(), x.getClienteap(), x.getClienteemail(), x.getIdpais()});
 
        }
        
    }
    
    void grabarCliente(){
        if(txtnom3.getText().length()!=0 && txtapa1.getText().length()!=0 && txtemailc.getText().length()!=0 && txtidpais.getText().length()!=0){
          
        //crear objeto eempleado
        Cliente cli=new Cliente(txtnom3.getText(), txtapa1.getText(), txtemailc.getText(), Integer.parseInt(txtidpais.getText()));
        //agrgar empleado a la base de datos
        ClienteDAO.insertar(cli);
            mensaje("Se registro cliente con exito");
        listarCliente();
        }else{
            mensaje("ingrese datos del cliente");
        }
 
    }
    
    void modificarCliente(){
        
        Cliente cli=new Cliente(txtnom3.getText(), txtapa1.getText(), txtemailc.getText(), Integer.parseInt(txtidpais.getText()));
        //asignar valor al codigo
        cli.setIdcliente(Integer.parseInt( txtcod3.getText()));
        //agrgar empleado a la base de datos
        ClienteDAO.modificar(cli);
        //listar
        listarCliente();
    }
    
    void eliminarCliente(){
        ClienteDAO.eliminar(Integer.parseInt( txtcod3.getText()));
        listarCliente();
    }   
   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   void grabarArticulos(){
        if(txtCatg.getText().length() != 0 && txtNom.getText().length() != 0 
           && txtDescp.getText().length() != 0 && txtPrecio.getText().length() != 0){
        //crear objeto Articulo
        Articulo art = new Articulo(Integer.parseInt(txtCatg.getText()), txtNom.getText(), txtDescp.getText(), Integer.parseInt(txtPrecio.getText()));
        //agregar Articulo a la base de datos
        ArticuloDAO.insertar(art);
        //listar articulo
        ListarTodosArticulos();
        }else{
            mensaje("Ingrese Datos del articulo");
        }
    }
    
    void ListarTodosArticulos(){
        String c[]={"IdArticulo","IdCategoria","Nombre","Descripcion","Precio"};
        DefaultTableModel md = new DefaultTableModel(null,c);
        //asignar modelo a la tabla
        jTableTodosArticulos.setModel(md);
        //agregar datos al modelo de tabla
        ArrayList<Articulo> Lista = ArticuloDAO.Listar();
        for (Articulo x : Lista) {
            md.addRow(new Object[]{x.getIdarticulo(),x.getIdcategoria(),x.getNombre(),x.getDescripcion(),x.getPrecio()});
        }
    }
    
    void seleccionarArticulo(){
        //seleccionar fila de la tabla
        int reg = jTableTodosArticulos.getSelectedRow();
        txtArt.setText(String.valueOf(jTableTodosArticulos.getValueAt(reg, 0)));
        txtCatg.setText(String.valueOf(jTableTodosArticulos.getValueAt(reg, 1)));
        txtNom.setText(String.valueOf(jTableTodosArticulos.getValueAt(reg, 2)));
        txtDescp.setText(String.valueOf(jTableTodosArticulos.getValueAt(reg, 3)));
        txtPrecio.setText(String.valueOf(jTableTodosArticulos.getValueAt(reg, 4)));
    }
    
    void modificarArticulo(){
        //crear objeto Articulos
        Articulo art = new Articulo(Integer.parseInt(txtCatg.getText()), txtNom.getText(), txtDescp.getText(), Integer.parseInt(txtPrecio.getText()));
        //agregar empleado a la base de datos
        art.setIdarticulo(Integer.parseInt(txtArt.getText()));
        ArticuloDAO.Modificar(art);
        //listar Articulos
        ListarTodosArticulos();
    }
 
    void eliminarArticulo(){
        ArticuloDAO.Eliminar(Integer.parseInt(txtArt.getText()));
        //listar empleados
        ListarTodosArticulos();
    }
     void limpiarArticulo(){
   txtCatg.setText("");
   txtNom.setText("");
   txtDescp.setText("");
   txtPrecio.setText("");
   }
     
     
   
   void mensaje(String msg){
       JOptionPane.showMessageDialog(this,msg);
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btngrabar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtapa = new javax.swing.JTextField();
        txtama = new javax.swing.JTextField();
        txtca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTodosEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        brnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        tbnuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btngrabar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        País = new javax.swing.JLabel();
        txtcod1 = new javax.swing.JTextField();
        txtnom1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTodosPaises = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        brnmodificar1 = new javax.swing.JButton();
        btneliminar1 = new javax.swing.JButton();
        tbnuevo1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btngrabar2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        País1 = new javax.swing.JLabel();
        txtcod2 = new javax.swing.JTextField();
        txtnom2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTodosCategorias = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        brnmodificar2 = new javax.swing.JButton();
        btneliminar2 = new javax.swing.JButton();
        tbnuevo2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btngrabar3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtArt = new javax.swing.JTextField();
        txtCatg = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtDescp = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTodosArticulos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        brnmodificar3 = new javax.swing.JButton();
        btneliminar3 = new javax.swing.JButton();
        tbnuevo3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtnom3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcod3 = new javax.swing.JTextField();
        txtapa1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtemailc = new javax.swing.JTextField();
        txtidpais = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btngrabar4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        brnmodificar4 = new javax.swing.JButton();
        btneliminar4 = new javax.swing.JButton();
        tbnuevo4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTodosCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Paterno");

        jLabel4.setText("Materno");

        jLabel5.setText("Cargo");

        txtcod.setEnabled(false);

        jTableTodosEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTodosEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTodosEmpleados);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        brnmodificar.setText("Modificar");
        brnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        tbnuevo.setText("Nuevo");
        tbnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btngrabar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnom)
                                    .addComponent(txtapa)
                                    .addComponent(txtama)
                                    .addComponent(txtca, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(tbnuevo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(brnmodificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tbnuevo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar)
                    .addComponent(jButton1)
                    .addComponent(brnmodificar)
                    .addComponent(btneliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EmpleadoCRUD", jPanel1);

        btngrabar1.setText("Grabar");
        btngrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabar1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo");

        País.setText("Nombre");

        txtcod1.setEnabled(false);

        jTableTodosPaises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTodosPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosPaisesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTodosPaises);

        jButton2.setText("Listar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        brnmodificar1.setText("Modificar");
        brnmodificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnmodificar1ActionPerformed(evt);
            }
        });

        btneliminar1.setText("Eliminar");
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });

        tbnuevo1.setText("Nuevo");
        tbnuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(País))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnom1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcod1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btngrabar1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(21, 21, 21)
                                .addComponent(brnmodificar1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbnuevo1)
                                    .addComponent(btneliminar1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(País)
                    .addComponent(txtnom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnuevo1)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar1)
                    .addComponent(brnmodificar1)
                    .addComponent(jButton2)
                    .addComponent(btngrabar1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("PaísCRUD", jPanel2);

        btngrabar2.setText("Grabar");
        btngrabar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabar2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Codigo");

        País1.setText("Nombre");

        txtcod2.setEnabled(false);

        jTableTodosCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTodosCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosCategoriasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableTodosCategorias);

        jButton3.setText("Listar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        brnmodificar2.setText("Modificar");
        brnmodificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnmodificar2ActionPerformed(evt);
            }
        });

        btneliminar2.setText("Eliminar");
        btneliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar2ActionPerformed(evt);
            }
        });

        tbnuevo2.setText("Nuevo");
        tbnuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnuevo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(País1))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnom2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcod2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btngrabar2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(21, 21, 21)
                                .addComponent(brnmodificar2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbnuevo2)
                                    .addComponent(btneliminar2))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(País1)
                    .addComponent(txtnom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnuevo2)
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar2)
                    .addComponent(brnmodificar2)
                    .addComponent(jButton3)
                    .addComponent(btngrabar2))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CategoriaCRUD", jPanel5);

        btngrabar3.setText("Grabar");
        btngrabar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabar3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Codigo");

        jLabel9.setText("IdCategoria");

        jLabel10.setText("Nombre");

        jLabel11.setText("Descripcion");

        jLabel12.setText("Precio");

        txtArt.setEnabled(false);

        jTableTodosArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTodosArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosArticulosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTodosArticulos);

        jButton4.setText("Listar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        brnmodificar3.setText("Modificar");
        brnmodificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnmodificar3ActionPerformed(evt);
            }
        });

        btneliminar3.setText("Eliminar");
        btneliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar3ActionPerformed(evt);
            }
        });

        tbnuevo3.setText("Nuevo");
        tbnuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnuevo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btngrabar3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCatg)
                                    .addComponent(txtNom)
                                    .addComponent(txtDescp)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(tbnuevo3))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton4)
                                .addGap(30, 30, 30)
                                .addComponent(brnmodificar3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCatg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tbnuevo3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDescp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar3)
                    .addComponent(jButton4)
                    .addComponent(brnmodificar3)
                    .addComponent(btneliminar3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ArticuloCRUD", jPanel6);

        jLabel13.setText("Apellidos");

        jLabel14.setText("Codigo");

        txtcod3.setEnabled(false);

        jLabel15.setText("Nombres");

        jLabel16.setText("Email");

        jLabel17.setText("Idpais");

        btngrabar4.setText("Grabar");
        btngrabar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabar4ActionPerformed(evt);
            }
        });

        jButton5.setText("Listar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        brnmodificar4.setText("Modificar");
        brnmodificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnmodificar4ActionPerformed(evt);
            }
        });

        btneliminar4.setText("Eliminar");
        btneliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar4ActionPerformed(evt);
            }
        });

        tbnuevo4.setText("Nuevo");
        tbnuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnuevo4ActionPerformed(evt);
            }
        });

        jTableTodosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTodosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosClienteMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableTodosCliente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btngrabar4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnom3)
                                    .addComponent(txtapa1)
                                    .addComponent(txtemailc)
                                    .addComponent(txtidpais, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcod3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(tbnuevo4))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton5)
                                .addGap(30, 30, 30)
                                .addComponent(brnmodificar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtcod3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtnom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtapa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tbnuevo4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtemailc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtidpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngrabar4)
                    .addComponent(jButton5)
                    .addComponent(brnmodificar4)
                    .addComponent(btneliminar4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ClienteCRUD", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnuevo3ActionPerformed
        limpiarArticulo();
    }//GEN-LAST:event_tbnuevo3ActionPerformed

    private void btneliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar3ActionPerformed
        if(jTableTodosArticulos.getSelectedRow()!=-1){
            eliminarArticulo(); }
        else{
            mensaje("Seleccione articulo de la tabla");
        }
    }//GEN-LAST:event_btneliminar3ActionPerformed

    private void brnmodificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnmodificar3ActionPerformed
        if(jTableTodosArticulos.getSelectedRow()!=-1){
            modificarArticulo(); }
        else{
            mensaje("Seleccione categoria de la tabla");
        }
    }//GEN-LAST:event_brnmodificar3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ListarTodosArticulos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableTodosArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosArticulosMouseClicked
        seleccionarArticulo();
    }//GEN-LAST:event_jTableTodosArticulosMouseClicked

    private void btngrabar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabar3ActionPerformed
        grabarArticulos();
    }//GEN-LAST:event_btngrabar3ActionPerformed

    private void tbnuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnuevo2ActionPerformed
        limpiarCategoria();
    }//GEN-LAST:event_tbnuevo2ActionPerformed

    private void btneliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar2ActionPerformed
        if(jTableTodosCategorias.getSelectedRow()!=-1){
            eliminarCategoria(); }
        else{
            mensaje("Seleccione categoria de la tabla");
        }
    }//GEN-LAST:event_btneliminar2ActionPerformed

    private void brnmodificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnmodificar2ActionPerformed
        if(jTableTodosCategorias.getSelectedRow()!=-1){
            modificarCategoria(); }
        else{
            mensaje("Seleccione categoria de la tabla");
        }
    }//GEN-LAST:event_brnmodificar2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listarTodosCategorias();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableTodosCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosCategoriasMouseClicked
        seleccionarCategoria();
    }//GEN-LAST:event_jTableTodosCategoriasMouseClicked

    private void btngrabar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabar2ActionPerformed
        grabarCategoria();
    }//GEN-LAST:event_btngrabar2ActionPerformed

    private void tbnuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnuevo1ActionPerformed
        limpiarPais();
    }//GEN-LAST:event_tbnuevo1ActionPerformed

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed
        if(jTableTodosPaises.getSelectedRow()!=-1){
            eliminarPais(); }
        else{
            mensaje("Seleccione país de la tabla");
        }
    }//GEN-LAST:event_btneliminar1ActionPerformed

    private void brnmodificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnmodificar1ActionPerformed
        if(jTableTodosPaises.getSelectedRow()!=-1){
            modificarPais(); }
        else{
            mensaje("Seleccione país de la tabla");
        }
    }//GEN-LAST:event_brnmodificar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listarTodosPaises();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableTodosPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosPaisesMouseClicked
        seleccionarPais();
    }//GEN-LAST:event_jTableTodosPaisesMouseClicked

    private void btngrabar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabar1ActionPerformed
        grabarPais();
    }//GEN-LAST:event_btngrabar1ActionPerformed

    private void tbnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnuevoActionPerformed
        nuevoEmpleado();
    }//GEN-LAST:event_tbnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(jTableTodosEmpleados.getSelectedRow()!=-1){
            eliminar(); }
        else{
            mensaje("Seleccione empleado de la tabla");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void brnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnmodificarActionPerformed
        if(jTableTodosEmpleados.getSelectedRow()!=-1){
            modificar(); }
        else{
            mensaje("Seleccione empleado de la tabla");
        }
    }//GEN-LAST:event_brnmodificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarTodosEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableTodosEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosEmpleadosMouseClicked
        seleccionarEmpleado();
    }//GEN-LAST:event_jTableTodosEmpleadosMouseClicked

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        grabarEmpleado();
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btngrabar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabar4ActionPerformed
    grabarCliente();
    }//GEN-LAST:event_btngrabar4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     listarCliente();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void brnmodificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnmodificar4ActionPerformed
       if(jTableTodosCliente.getSelectedRow()!=-1){
            modificarCliente(); }
        else{
            mensaje("Seleccione algún cliente de la tabla");
        }
    }//GEN-LAST:event_brnmodificar4ActionPerformed

    private void btneliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar4ActionPerformed
      if(jTableTodosCliente.getSelectedRow()!=-1){
            eliminarCliente(); }
        else{
            mensaje("Seleccione algún cliente de la tabla");
        }
    }//GEN-LAST:event_btneliminar4ActionPerformed

    private void tbnuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnuevo4ActionPerformed
     limpiarCliente();
    }//GEN-LAST:event_tbnuevo4ActionPerformed

    private void jTableTodosClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosClienteMouseClicked
     seleccionarcliente();
    }//GEN-LAST:event_jTableTodosClienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMantenimientoEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel País;
    private javax.swing.JLabel País1;
    private javax.swing.JButton brnmodificar;
    private javax.swing.JButton brnmodificar1;
    private javax.swing.JButton brnmodificar2;
    private javax.swing.JButton brnmodificar3;
    private javax.swing.JButton brnmodificar4;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btneliminar2;
    private javax.swing.JButton btneliminar3;
    private javax.swing.JButton btneliminar4;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btngrabar1;
    private javax.swing.JButton btngrabar2;
    private javax.swing.JButton btngrabar3;
    private javax.swing.JButton btngrabar4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableTodosArticulos;
    private javax.swing.JTable jTableTodosCategorias;
    private javax.swing.JTable jTableTodosCliente;
    private javax.swing.JTable jTableTodosEmpleados;
    private javax.swing.JTable jTableTodosPaises;
    private javax.swing.JButton tbnuevo;
    private javax.swing.JButton tbnuevo1;
    private javax.swing.JButton tbnuevo2;
    private javax.swing.JButton tbnuevo3;
    private javax.swing.JButton tbnuevo4;
    private javax.swing.JTextField txtArt;
    private javax.swing.JTextField txtCatg;
    private javax.swing.JTextField txtDescp;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtama;
    private javax.swing.JTextField txtapa;
    private javax.swing.JTextField txtapa1;
    private javax.swing.JTextField txtca;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcod1;
    private javax.swing.JTextField txtcod2;
    private javax.swing.JTextField txtcod3;
    private javax.swing.JTextField txtemailc;
    private javax.swing.JTextField txtidpais;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnom1;
    private javax.swing.JTextField txtnom2;
    private javax.swing.JTextField txtnom3;
    // End of variables declaration//GEN-END:variables
}
