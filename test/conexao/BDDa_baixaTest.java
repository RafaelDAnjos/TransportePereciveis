/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transporteperecivel.Da_baixa;

/**
 *
 * @author rafae
 */
public class BDDa_baixaTest {
    
    public BDDa_baixaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTable method, of class BDDa_baixa.
     */
    @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        Da_baixa da_baixa = new Da_baixa();
        da_baixa.setFk_BandaPorco_ID(1);
        da_baixa.setFk__Pedido_ID(1);
        
        BDDa_baixa da_baixaBD = new BDDa_baixa();
        da_baixaBD.createTable();
        
        da_baixaBD.insertTable(da_baixa);
        
        ArrayList <Da_baixa> listCom = da_baixaBD.selectTable();
        
        assertEquals(da_baixa.getFk_BandaPorco_ID(), listCom.get(0).getFk_BandaPorco_ID());
        assertEquals(da_baixa.getFk__Pedido_ID(), listCom.get(0).getFk__Pedido_ID());
    }
    
    @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Da_baixa da_baixa = new Da_baixa();
        da_baixa.setFk_BandaPorco_ID(1);
        da_baixa.setFk__Pedido_ID(1);
        
        BDDa_baixa da_baixaBD = new BDDa_baixa();
        da_baixaBD.createTable();
        
        da_baixaBD.insertTable(da_baixa);
        
        da_baixaBD.deleteTable(da_baixa.getFk__Pedido_ID(), da_baixa.getFk_BandaPorco_ID());
        
        ArrayList <Da_baixa> listCom = da_baixaBD.selectTable();

        System.out.println(listCom.size());
        assertEquals(0, listCom.size());
    }
    
    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        
        Da_baixa da_baixa = new Da_baixa();
        da_baixa.setFk_BandaPorco_ID(1);
        da_baixa.setFk__Pedido_ID(1);
        
        
        BDDa_baixa da_baixaBD = new BDDa_baixa();
        da_baixaBD.createTable();
        
        da_baixaBD.insertTable(da_baixa);
        
        da_baixa.setFk_BandaPorco_ID(2);
        
        da_baixaBD.updateTable(da_baixa);
        ArrayList <Da_baixa> listDa = da_baixaBD.selectTable();
        assertEquals(da_baixa.getFk_BandaPorco_ID(), listDa.get(0).getFk_BandaPorco_ID());
                
    }


    
}
