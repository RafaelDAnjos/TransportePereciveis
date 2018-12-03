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
import transporteperecivel.Entrega;

/**
 *
 * @author rafae
 */
public class BDEntregaTest {
    
    public BDEntregaTest() {
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
     * Test of createTable method, of class BDEntrega.
     */
    @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        Entrega entrega = new Entrega();
        entrega.setFk_Automovel_ID(1);
        entrega.setFk_Cliente_ID(1);
        
        BDEntrega entregaBD = new BDEntrega();
        entregaBD.createTable();
        
        entregaBD.insertTable(entrega);
        
        ArrayList <Entrega> listCom = entregaBD.selectTable();
        
        assertEquals(entrega.getFk_Automovel_ID(), listCom.get(0).getFk_Automovel_ID());
        assertEquals(entrega.getFk_Cliente_ID(), listCom.get(0).getFk_Cliente_ID());
    }
    
    @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Entrega entrega = new Entrega();
        entrega.setFk_Automovel_ID(1);
        entrega.setFk_Cliente_ID(1);
        
        BDEntrega entregaBD = new BDEntrega();
        entregaBD.createTable();
        
        entregaBD.insertTable(entrega);
        
        entregaBD.deleteTable(entrega.getFk_Cliente_ID(), entrega.getFk_Automovel_ID());
        
        ArrayList <Entrega> listEnt = entregaBD.selectTable();

        System.out.println(listEnt.size());
        assertEquals(0, listEnt.size());
    }
    
    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        
        Entrega entrega = new Entrega();
        entrega.setFk_Automovel_ID(1);
        entrega.setFk_Cliente_ID(1);
        
        
        BDEntrega entregaBD = new BDEntrega();
        entregaBD.createTable();
        
        entregaBD.insertTable(entrega);
        
        entrega.setFk_Automovel_ID(2);
        
        entregaBD.updateTable(entrega);
        ArrayList <Entrega> listBai = entregaBD.selectTable();
        assertEquals(entrega.getFk_Automovel_ID(), listBai.get(0).getFk_Automovel_ID());
                
    }


}
