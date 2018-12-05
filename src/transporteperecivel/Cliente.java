package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class Cliente {
    private String nomeFicticio;
    private int id;
    private String cnpj;

    public Cliente(String nomeFicticio, String cnpj) {
        this.nomeFicticio = nomeFicticio;
        this.cnpj = cnpj;
    }

    Cliente() {
    }

    public String getNomeFicticio() {
        return nomeFicticio;
    }

    public void setNomeFicticio(String nomeFicticio) {
        this.nomeFicticio = nomeFicticio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


 
    
}
