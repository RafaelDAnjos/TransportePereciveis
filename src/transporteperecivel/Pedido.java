package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class Pedido {
    private int numeroBandas;
    private String dataDeEntrega;
    private int id;

    public int getNumeroBandas() {
        return numeroBandas;
    }

    public void setNumeroBandas(int numeroBandas) {
        this.numeroBandas = numeroBandas;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
