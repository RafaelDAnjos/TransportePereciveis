/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import transporteperecivel.Cidade;

/**
 *
 * @author nicolas
 */
public class BDCidadeTest{

    @Test
    public void testCreateInsertSelect() {
        BDCidade bd = new BDCidade();
        bd.createTable();

        Cidade cidade1 = new Cidade("Vitória");
        Cidade cidade2 = new Cidade("Vila Velha");
        
        bd.insertTable(cidade1);
        bd.insertTable(cidade2);
        
        List<Cidade> cidades = new ArrayList();
        cidades = bd.selectTable();
               
        assertEquals("SELECT cidade1", "Vitória", cidades.get(0).getNome());
        assertEquals("SELECT cidade2", "Vila Velha", cidades.get(1).getNome());
    }
    
    @Test
    public void testUpdate(){
        BDCidade bd = new BDCidade();
        bd.createTable();

        Cidade cidade1 = new Cidade("Vitória");
        Cidade cidade2 = new Cidade("Vila Velha");
        
        bd.insertTable(cidade1);
        bd.insertTable(cidade2);
        
        List<Cidade> cidades = new ArrayList();
        cidades = bd.selectTable();
        assertEquals("UPDATE cidade1", "Vitória", cidades.get(0).getNome());
        
        bd.updateTable("Serra", 1);
        cidades = bd.selectTable();
        
        for (int i = 0; i < cidades.size(); i++){
            if (cidades.get(i).getId() == 1){
                assertEquals("UPDATE cidade1", "Serra", cidades.get(i).getNome());
            }
        }
    }
    
    @Test
    public void testDelete(){
        BDCidade bd = new BDCidade();
        bd.createTable();

        Cidade cidade1 = new Cidade("Vitória");
        Cidade cidade2 = new Cidade("Vila Velha");
        
        bd.insertTable(cidade1);
        bd.insertTable(cidade2);
        
        List<Cidade> cidades = new ArrayList();
        cidades = bd.selectTable();
        
        assertEquals("DELETE cidades", 2, cidades.size());  
        
        bd.deleteTable(1);
        bd.deleteTable(2);
        
        cidades = bd.selectTable();
        assertEquals("DELETE cidades", 0, cidades.size());  
    }
    
}