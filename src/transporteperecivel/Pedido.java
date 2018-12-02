package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class Pedido {
    private int numeroBandas;
    private String dataDeEntrega;
    private int id;
    private int fkcliente;
    private int fkfuncionario;
    
    public Pedido(int numeroBandas, String dataDeEntrega){
        this.numeroBandas = numeroBandas;
        this.dataDeEntrega = dataDeEntrega;
    }

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    public int getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(int fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }

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
