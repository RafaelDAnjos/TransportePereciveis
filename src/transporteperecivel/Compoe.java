/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDBairro;
import conexao.BDCompoe;
import conexao.BDEndereco;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class Compoe {
    private int fk_Endereco_ID;
    private int fk_Bairro_ID;

    public int getFk_Endereco_ID() {
        return fk_Endereco_ID;
    }

    public void setFk_Endereco_ID(int fk_Endereco_ID) {
        this.fk_Endereco_ID = fk_Endereco_ID;
    }

    public int getFk_Bairro_ID() {
        return fk_Bairro_ID;
    }

    public void setFk_Bairro_ID(int fk_Bairro_ID) {
        this.fk_Bairro_ID = fk_Bairro_ID;
    }
    public void vinculaEndereco(Endereco novoendereco){
        ArrayList<Endereco>listaendereco = new ArrayList();
        BDEndereco instance = new BDEndereco();
        listaendereco = instance.selectTable();
        
        for(int i=0;i<listaendereco.size();i++){
            Endereco endereco = new Endereco();
            endereco  = listaendereco.get(i);
            
            if(endereco.getNome().equals(novoendereco.getNome())){
                if(endereco.getFk_cliente_id() == novoendereco.getFk_cliente_id()){
                    if(endereco.getFk_logradouro_id() == novoendereco.getFk_logradouro_id()){
                        if(endereco.getNumero() == endereco.getNumero()){
                            
                            setFk_Endereco_ID(endereco.getId());
                        
                        }
                    }
                
                }
                
            }
        
        }
    }
    public void vinculaBairro(Bairro novobairro){
        ArrayList<Bairro> listabairro = new ArrayList();
        BDBairro instance = new BDBairro();
        listabairro = instance.selectTable();
        
        for(int i =0;i<listabairro.size();i++){
            Bairro bairro = new Bairro();
            bairro = listabairro.get(i);
            if(bairro.getNome().equals(novobairro.getNome()) ){
                setFk_Bairro_ID(bairro.getId());
            }
        }
    
    
    }
    
    public void cadastrarCompoe(){
        Bairro bairro = new Bairro();
        Cidade cidade = new Cidade();
        bairro.setNome(JOptionPane.showInputDialog("Insere Nome do bairro: "));
        cidade.setNome(JOptionPane.showInputDialog("Insira a Cidade"));
       bairro.vinculaCidade(cidade);
       this.vinculaBairro(bairro);
       
       
    
    
    }
    
    
    
}


