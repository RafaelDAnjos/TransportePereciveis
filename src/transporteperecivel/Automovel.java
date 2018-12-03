package transporteperecivel;

/**
 *
 * @author rafaelda
 */

public class Automovel {
    private boolean isrefrigerado;
    private float carga_maxima;
    private String Modelo;
    private String placa;
    private int fk_funcionario_idfuncionario;
    private int fk_cidade_id;
    private int id;

    public boolean getIsrefrigerado() {
        return isrefrigerado;
    }

    public void setIsrefrigerado(boolean isrefrigerado) {
        this.isrefrigerado = isrefrigerado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCarga_maxima() {
        return carga_maxima;
    }

    public void setCarga_maxima(float carga_maxima) {
        this.carga_maxima = carga_maxima;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getFk_funcionario_idfuncionario() {
        return fk_funcionario_idfuncionario;
    }

    public void setFk_funcionario_idfuncionario(int fk_funcionario_idfuncionario) {
        this.fk_funcionario_idfuncionario = fk_funcionario_idfuncionario;
    }

    public int getFk_cidade_id() {
        return fk_cidade_id;
    }

    public void setFk_cidade_id(int cidade) {
        this.fk_cidade_id = cidade;
    }


}
