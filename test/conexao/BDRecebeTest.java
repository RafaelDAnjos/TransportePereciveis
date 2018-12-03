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
import transporteperecivel.Recebe;

/**
 *
 * @author rafae
 */
public class BDRecebeTest {
    
    public BDRecebeTest() {
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
     * Test of createTable method, of class BDRecebe.
     */
     @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        Recebe recebe = new Recebe();
        recebe.setFk_Cliente_ID(1);
        recebe.setFk_HorarioRecebimento_ID(1);
        
        BDRecebe recebeBD = new BDRecebe();
        recebeBD.createTable();
        
        recebeBD.insertTable(recebe);
        
        ArrayList <Recebe> listCom = recebeBD.selectTable();
        
        assertEquals(recebe.getFk_Cliente_ID(), listCom.get(0).getFk_Cliente_ID());
        assertEquals(recebe.getFk_HorarioRecebimento_ID(), listCom.get(0).getFk_HorarioRecebimento_ID());
    }
    
    @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Recebe recebe = new Recebe();
        recebe.setFk_Cliente_ID(1);
        recebe.setFk_HorarioRecebimento_ID(1);
        
        BDRecebe recebeBD = new BDRecebe();
        recebeBD.createTable();
        
        recebeBD.insertTable(recebe);
        
        recebeBD.deleteTable(recebe.getFk_Cliente_ID(),recebe.getFk_HorarioRecebimento_ID());
        
        ArrayList <Recebe> listCom = recebeBD.selectTable();

        assertEquals(0, listCom.size());
    }
    
    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        
        Recebe recebe = new Recebe();
        recebe.setFk_Cliente_ID(1);
        recebe.setFk_HorarioRecebimento_ID(1);
        
        
        BDRecebe recebeBD = new BDRecebe();
        recebeBD.createTable();
        
        recebeBD.insertTable(recebe);
        
        recebe.setFk_HorarioRecebimento_ID(2);
        
        recebeBD.updateTable(recebe);
        ArrayList <Recebe> listRec = recebeBD.selectTable();
        assertEquals(recebe.getFk_HorarioRecebimento_ID(), listRec.get(0).getFk_HorarioRecebimento_ID());
                
    }


}
