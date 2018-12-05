package transporteperecivel;

import conexao.BDCliente;
import conexao.BDFuncionario;
import java.util.ArrayList;

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

    Pedido() {
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
    public void vinculaCliente(Cliente novocliente){
        ArrayList<Cliente> listacliente = new ArrayList();
        BDCliente instance = new BDCliente();
        listacliente =  instance.selectTable();
        
        
        for(int i =0;i<listacliente.size();i++){
            Cliente cliente = new Cliente();
            cliente = listacliente.get(i);
            
            if(novocliente.getCnpj().equals(cliente.getCnpj())){
                setFkcliente(cliente.getId());
            }
        }


}
    
        public void vinculaFuncionario(Funcionario novofuncionario){
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();
        BDFuncionario instance = new BDFuncionario();
        listaFuncionarios = instance.selectTable();
        
        for(int i =0;i<listaFuncionarios.size();i++){
            Funcionario funcionario = new Funcionario();
            funcionario = listaFuncionarios.get(i);
            
            if(funcionario.getCpf().equals(novofuncionario.getCpf())){
                    setFkfuncionario(funcionario.getIdfuncionario());           
            }
        }
    }

}
