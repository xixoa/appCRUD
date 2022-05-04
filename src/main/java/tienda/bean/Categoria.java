
package tienda.bean;

public class Categoria {
    private int idcat;
    private String ncategoria;

    public Categoria(String ncategoria) {
        this.ncategoria = ncategoria;
    }

    public Categoria() {
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNcategoria() {
        return ncategoria;
    }

    public void setNcategoria(String ncategoria) {
        this.ncategoria = ncategoria;
    }

    
    
    
}
