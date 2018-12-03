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
import transporteperecivel.BandaPorco;

/**
 *
 * @author nicolas
 */
public class BDBandaPorcoTest {

    @Test
    public void testCreateInsertSelect() {
        BDBandaPorco bd = new BDBandaPorco();
        bd.createTable();

        BandaPorco porco1 = new BandaPorco("2018/12/01", 30);
        BandaPorco porco2 = new BandaPorco("2018/11/30", 60);

        bd.insertTable(porco1);
        bd.insertTable(porco2);
        
        List<BandaPorco> porcos = new ArrayList();
        porcos = bd.selectTable();
               
        assertEquals("SELECT quantidade porco1", 30, porcos.get(0).getQuantidade());
        assertEquals("SELECT data porco2", "2018-11-30", porcos.get(1).getDataDeAbate()); 
    }
    
    @Test
    public void testUpdate(){
        BDBandaPorco bd = new BDBandaPorco();
        bd.createTable();

        BandaPorco porco1 = new BandaPorco("2018/12/01", 30);
        BandaPorco porco2 = new BandaPorco("2018/11/30", 60);

        bd.insertTable(porco1);
        bd.insertTable(porco2);
        
        List<BandaPorco> porcos = new ArrayList();
        porcos = bd.selectTable();
        assertEquals("UPDATE quantidade porco1", 30, porcos.get(0).getQuantidade());
        
        porco1.setQuantidade(100);
        
        bd.updateTable(porco1, 1);
        porcos = bd.selectTable();
        
        for (int i = 0; i < porcos.size(); i++){
            if (porcos.get(i).getId() == 1){
                assertEquals("UPDATE quantidade porco1", 100, porcos.get(i).getQuantidade());
            }
        }
    }
    
    @Test
    public void testDelete(){
        BDBandaPorco bd = new BDBandaPorco();
        bd.createTable();

        BandaPorco porco1 = new BandaPorco("2018/12/01", 30);
        BandaPorco porco2 = new BandaPorco("2018/11/30", 60);

        bd.insertTable(porco1);
        bd.insertTable(porco2);
        
        List<BandaPorco> porcos = new ArrayList();
        porcos = bd.selectTable();
        
        assertEquals("DELETE Deletar porcos", 2, porcos.size());  
      
        bd.deleteTable(1);
        bd.deleteTable(2);
        
        porcos = bd.selectTable();
        assertEquals("DELETE Deletar porcos", 0, porcos.size());  
    }
    
}