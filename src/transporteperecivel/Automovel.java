package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class Automovel {
    private boolean refrigerado;
    private float pesoMax;
    private int idModelo;
    private String placa;
    private int idFuncionario;
    private String cidade;

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public float getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


}
