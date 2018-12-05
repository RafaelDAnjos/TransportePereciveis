package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class BandaPorco {
    private String dataDeAbate;
    private int quantidade;
    private int id;
    
    public BandaPorco(String dataDeAbate, int qnt){
        this.dataDeAbate = dataDeAbate;
        quantidade = qnt;
    }

    BandaPorco() {
    }

    public String getDataDeAbate() {
        return dataDeAbate;
    }

    public void setDataDeAbate(String dataDeAbate) {
        this.dataDeAbate = dataDeAbate;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 

}
