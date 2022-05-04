
package tienda.bean;


public class Cliente {
    
    private int idcliente;
    private String clienteap;
    private String clientenom;
    private String clienteemail;
    private int idpais;

    public Cliente(String clienteap, String clientenom, String clienteemail, int idpais) {
        this.clienteap = clienteap;
        this.clientenom = clientenom;
        this.clienteemail = clienteemail;
        this.idpais = idpais;
    }

    public Cliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getClienteap() {
        return clienteap;
    }

    public void setClienteap(String clienteap) {
        this.clienteap = clienteap;
    }

    public String getClientenom() {
        return clientenom;
    }

    public void setClientenom(String clientenom) {
        this.clientenom = clientenom;
    }

    public String getClienteemail() {
        return clienteemail;
    }

    public void setClienteemail(String clienteemail) {
        this.clienteemail = clienteemail;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }
    
    
    
}
