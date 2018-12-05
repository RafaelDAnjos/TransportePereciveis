/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDBandaPorco;
import conexao.BDFuncionario;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class Adiciona {
    private int fk_Funcionario_IDfuncionario;
    private int fk_BandaPorco_ID;

    public int getFk_Funcionario_IDfuncionario() {
        return fk_Funcionario_IDfuncionario;
    }

    public void setFk_Funcionario_IDfuncionario(int fk_Funcionario_IDfuncionario) {
        this.fk_Funcionario_IDfuncionario = fk_Funcionario_IDfuncionario;
    }

    public int getFk_BandaPorco_ID() {
        return fk_BandaPorco_ID;
    }

    public void setFk_BandaPorco_ID(int fk_BandaPorco_ID) {
        this.fk_BandaPorco_ID = fk_BandaPorco_ID;
    }
    public void vinculaFuncionario(Funcionario novofuncionario){
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();
        BDFuncionario instance = new BDFuncionario();
        listaFuncionarios = instance.selectTable();
        
        for(int i =0;i<listaFuncionarios.size();i++){
            Funcionario funcionario = new Funcionario();
            funcionario = listaFuncionarios.get(i);
            
            if(funcionario.getCpf().equals(novofuncionario.getCpf())){
                    setFk_Funcionario_IDfuncionario(funcionario.getIdfuncionario());           
            }
        }
    }
    public void vinculaBandaPorco(BandaPorco novabanda){
        ArrayList<BandaPorco> listabandas = new ArrayList();
        BDBandaPorco instance = new BDBandaPorco();
        listabandas = instance.selectTable();
        
        for(int i =0;i<listabandas.size();i++){
        BandaPorco bandaporco = new BandaPorco();
        bandaporco = listabandas.get(i);
        
        if(bandaporco.getDataDeAbate().equals(novabanda.getDataDeAbate())){
        
            setFk_BandaPorco_ID(bandaporco.getId());
        }
        }
    
    
    }
}
