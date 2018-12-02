package conexao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import transporteperecivel.Automovel;

/**
 *
 * @author Daniel
 */

public class BDAutomovelTest {

    @Test
    public void testInsert() {
        BDAutomovel bd = new BDAutomovel();
        bd.createTable();

        
        Automovel automovelA = new Automovel();
        automovelA.setRefrigerado(true);
        automovelA.setPesoMax(1000);
        automovelA.setIdModelo(437);
        automovelA.setPlaca("poo2018");
        automovelA.setIdFuncionario(123);
        automovelA.setCidade("Vitória");
        
        Automovel automovelB = new Automovel();
        automovelB.setRefrigerado(false);
        automovelB.setPesoMax(2300);
        automovelB.setIdModelo(2);
        automovelB.setPlaca("ife2020");
        automovelB.setIdFuncionario(1);
        automovelB.setCidade("Serra");

        
        bd.insertTable(automovelA);
        bd.insertTable(automovelB);
        
        
        List<Automovel> automoveis = new ArrayList();
        
        automoveis.add(automovelA);
        automoveis.add(automovelB);
               
        
        assertEquals(automoveis.get(0).isRefrigerado(), automovelA.isRefrigerado());
        Assert.assertTrue(automoveis.get(0).getPesoMax() == automovelA.getPesoMax());
        assertEquals(automoveis.get(0).getIdModelo(), automovelA.getIdModelo());
        assertEquals(automoveis.get(0).getPlaca(), automovelA.getPlaca());
        assertEquals(automoveis.get(0).getIdFuncionario(), automovelA.getIdFuncionario());
        assertEquals(automoveis.get(0).getCidade(), automovelA.getCidade());
        
        assertEquals(automoveis.get(1).isRefrigerado(), automovelB.isRefrigerado());
        Assert.assertTrue(automoveis.get(1).getPesoMax() == automovelB.getPesoMax());
        assertEquals(automoveis.get(1).getIdModelo(), automovelB.getIdModelo());
        assertEquals(automoveis.get(1).getPlaca(), automovelB.getPlaca());
        assertEquals(automoveis.get(1).getIdFuncionario(), automovelB.getIdFuncionario());
        assertEquals(automoveis.get(1).getCidade(), automovelB.getCidade());
    }
    
    @Test
    public void testUpdate(){
        BDAutomovel bd = new BDAutomovel();
        bd.createTable();

        
        Automovel automovelA = new Automovel();
        automovelA.setRefrigerado(true);
        automovelA.setPesoMax(1000);
        automovelA.setIdModelo(437);
        automovelA.setPlaca("poo2018");
        automovelA.setIdFuncionario(123);
        automovelA.setCidade("Vitória");
        
        Automovel automovelB = new Automovel();
        automovelB.setRefrigerado(false);
        automovelB.setPesoMax(2300);
        automovelB.setIdModelo(2);
        automovelB.setPlaca("ife2020");
        automovelB.setIdFuncionario(1);
        automovelB.setCidade("Serra");

        
        bd.insertTable(automovelA);
        bd.insertTable(automovelB);
        
        
        List<Automovel> automoveis = new ArrayList();
        automoveis = bd.selectTable();
        
        
        assertEquals(automoveis.get(0).isRefrigerado(), automovelA.isRefrigerado());
        Assert.assertTrue(automoveis.get(0).getPesoMax() == automovelA.getPesoMax());
        assertEquals(automoveis.get(0).getIdModelo(), automovelA.getIdModelo());
        assertEquals(automoveis.get(0).getPlaca(), automovelA.getPlaca());
        assertEquals(automoveis.get(0).getIdFuncionario(), automovelA.getIdFuncionario());
        assertEquals(automoveis.get(0).getCidade(), automovelA.getCidade());
        
        
        bd.updateTable(automovelA.isRefrigerado(), 3333, automovelA.getIdModelo(), automovelA.getPlaca(), automovelA.getIdFuncionario(), automovelA.getCidade());
        automoveis = bd.selectTable();
        
        for (int i = 0; i < automoveis.size(); i++){
            if (automoveis.get(i).getPlaca() == "poo2018"){
                
                assertEquals(automoveis.get(0).isRefrigerado(), automovelA.isRefrigerado());
                Assert.assertTrue(automoveis.get(0).getPesoMax() == automovelA.getPesoMax());
                assertEquals(automoveis.get(0).getIdModelo(), automovelA.getIdModelo());
                assertEquals(automoveis.get(0).getPlaca(), automovelA.getPlaca());
                assertEquals(automoveis.get(0).getIdFuncionario(), automovelA.getIdFuncionario());
                assertEquals(automoveis.get(0).getCidade(), automovelA.getCidade());
            }
        }
    }
    
    @Test
    public void testDelete(){
        BDAutomovel bd = new BDAutomovel();
        bd.createTable();

        
        Automovel automovelA = new Automovel();
        automovelA.setRefrigerado(true);
        automovelA.setPesoMax(1000);
        automovelA.setIdModelo(437);
        automovelA.setPlaca("poo2018");
        automovelA.setIdFuncionario(123);
        automovelA.setCidade("Vitória");
        
        Automovel automovelB = new Automovel();
        automovelB.setRefrigerado(false);
        automovelB.setPesoMax(2300);
        automovelB.setIdModelo(2);
        automovelB.setPlaca("ife2020");
        automovelB.setIdFuncionario(1);
        automovelB.setCidade("Serra");

        
        bd.insertTable(automovelA);
        bd.insertTable(automovelB);
        
        
        List<Automovel> automoveis = new ArrayList();
        automoveis = bd.selectTable();
        
        
        assertEquals(2, automoveis.size());
        
        
        for (int i = 0; i < automoveis.size(); i++){

            if ("poo2018".equals(automoveis.get(i).getPlaca())){
                bd.deleteTable(automoveis.get(i).getPlaca());
            }
            
        }
        bd.deleteTable("ife2020");
        
        
        automoveis = bd.selectTable();
        assertEquals(0, automoveis.size());  
    } 
}