package transporteperecivel;

import conexao.BDCidade;
import java.util.ArrayList;

/**
 *
 * @author 20161bsi0527
 */

public class Bairro {
    private String nome;
    private int id;
    private int Fk_Cidade_id;

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

    public int getFk_Cidade_id() {
        return Fk_Cidade_id;
    }

    public void setFk_Cidade_id(int Fk_Cidade_id) {
        this.Fk_Cidade_id = Fk_Cidade_id;
    }
     public void vinculaCidade(Cidade novacidade){
        ArrayList<Cidade> listaCidade = new ArrayList();
        BDCidade instance = new BDCidade();
        listaCidade = instance.selectTable();
        
        for(int i =0;i<listaCidade.size();i++){
            Cidade cidade = new Cidade();
            cidade = listaCidade.get(i);
            
            if(cidade.getNome().equals(novacidade.getNome())){
                    setFk_Cidade_id(cidade.getId());           
            }
        }
        
    }  
    
}
