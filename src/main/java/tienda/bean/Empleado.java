
package tienda.bean;

public class Empleado {
    //propiedades
    private int idemp;
    private String nombre;
    private String paterno;
    private String materno;
    private String cargo;

    public Empleado(String nombre, String paterno, String materno, String cargo) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.cargo = cargo;
    }

    public Empleado() {
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
