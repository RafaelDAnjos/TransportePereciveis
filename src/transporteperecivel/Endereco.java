package transporteperecivel;

import conexao.BDCliente;
import conexao.BDLogradouro;
import java.util.ArrayList;

/**
 *
 * @author rafaelda
 */

public class Endereco {
    private int id;
    private int fk_logradouro_id;
    private int fk_cliente_id;
    private int numero;
    private String complemento;
    private String nome;

    public int getFk_logradouro_id() {
        return fk_logradouro_id;
    }

    public void setFk_logradouro_id(int idLogradouro) {
        this.fk_logradouro_id = idLogradouro;
    }

    public int getFk_cliente_id() {
        return fk_cliente_id;
    }

    public void setFk_cliente_id(int idBairro) {
        this.fk_cliente_id = idBairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumero()
    {
        return numero;
    }
    
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    

        public void vinculaCliente(Cliente novocliente){
        ArrayList<Cliente> listacliente = new ArrayList();
        BDCliente instance = new BDCliente();
        listacliente =  instance.selectTable();
        
        
        for(int i =0;i<listacliente.size();i++){
            Cliente cliente = new Cliente();
            cliente = listacliente.get(i);
            
            if(novocliente.getCnpj().equals(cliente.getCnpj())){
                setFk_cliente_id(cliente.getId());
            }
        }

        }
        public void vinculaLogradouro(Logradouro novoLogradouro){
            ArrayList<Logradouro> listalogradouro  = new ArrayList();
            BDLogradouro instance = new BDLogradouro();
            listalogradouro = instance.selectTable();
            
            for(int i =0;i<listalogradouro.size();i++){
                Logradouro logradouro = new Logradouro();
                logradouro = listalogradouro.get(i);
                
                if(logradouro.getDescricao().equals(novoLogradouro.getDescricao())){
                    setFk_logradouro_id(logradouro.getId());
                
                }
            }
        }
}
