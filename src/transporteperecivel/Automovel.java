package transporteperecivel;

import conexao.BDCidade;
import conexao.BDFuncionario;
import java.util.ArrayList;

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
    public void vinculaFuncionario(Funcionario novofuncionario){
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();
        BDFuncionario instance = new BDFuncionario();
        listaFuncionarios = instance.selectTable();
        
        for(int i =0;i<listaFuncionarios.size();i++){
            Funcionario funcionario = new Funcionario();
            funcionario = listaFuncionarios.get(i);
            
            if(funcionario.getCpf().equals(novofuncionario.getCpf())){
                    setFk_funcionario_idfuncionario(funcionario.getIdfuncionario());           
            }
        }
    }
    public void vinculaCidade(Cidade novacidade){
        ArrayList<Cidade> listaCidade = new ArrayList();
        BDCidade instance = new BDCidade();
        listaCidade = instance.selectTable();
        
        for(int i =0;i<listaCidade.size();i++){
            Cidade cidade = new Cidade();
            cidade = listaCidade.get(i);
            
            if(cidade.getNome().equals(novacidade.getNome())){
                    setFk_cidade_id(cidade.getId());           
            }
        }
        
    }


}

