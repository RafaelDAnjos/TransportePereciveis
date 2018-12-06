package transporteperecivel;

import conexao.BDCidade;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    
    public void cadastraCidade(){
        BDCidade instance = new BDCidade();

        this.setNome(JOptionPane.showInputDialog("Digite o nome da cidade: "));

        instance.insertTable(this);
    }


     public void pegaCidadeId(){
        BDCidade instance = new BDCidade();
        List<Cidade> listCidade = instance.selectTable();
        
        for(int i = 0; i < listCidade.size(); i++) {
            if( this.getNome().equals(listCidade.get(i).getNome()) ) {
                this.setId(listCidade.get(i).getId());
            }
        }
    }
    
    
    public void deletaCidade() {
        BDCidade instance = new BDCidade();

        instance.deleteTable(getId());
    }
    
    
    public void leCidades() {
        BDCidade instance = new BDCidade();
        List<Cidade> listCidade = instance.selectTable();

        for(int i = 0; i < listCidade.size(); i++) {
            JOptionPane.showMessageDialog(null, "Nome da cidade: " + listCidade.get(i).getNome());
        }
    }
    
    
}
