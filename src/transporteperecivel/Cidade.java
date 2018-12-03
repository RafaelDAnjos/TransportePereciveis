package transporteperecivel;

/**
 *
 * @Daniel
 */

public class Cidade {
    private String nome;
    private int id;

    public Cidade(String nome){
        this.nome = nome;
    }

    Cidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
