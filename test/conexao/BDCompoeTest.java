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
import transporteperecivel.Compoe;

/**
 *
 * @author Andreas
 */
public class BDCompoeTest {
    
    public BDCompoeTest() {
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
     * Test of createTable method, of class BDCompoe.
     */
    @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        Compoe compoe = new Compoe();
        compoe.setFk_Bairro_ID(1);
        compoe.setFk_Endereco_ID(1);
        
        BDCompoe compoeBD = new BDCompoe();
        compoeBD.createTable();
        
        compoeBD.insertTable(compoe);
        
        ArrayList <Compoe> listCom = compoeBD.selectTable();
        
        assertEquals(compoe.getFk_Bairro_ID(), listCom.get(0).getFk_Bairro_ID());
        assertEquals(compoe.getFk_Endereco_ID(), listCom.get(0).getFk_Endereco_ID());
    }
    
    @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Compoe compoe = new Compoe();
        compoe.setFk_Bairro_ID(1);
        compoe.setFk_Endereco_ID(1);
        
        BDCompoe compoeBD = new BDCompoe();
        compoeBD.createTable();
        
        compoeBD.insertTable(compoe);
        
        compoeBD.deleteTable(compoe.getFk_Endereco_ID());
        
        ArrayList <Compoe> listCom = compoeBD.selectTable();

        System.out.println(listCom.size());
        assertEquals(0, listCom.size());
    }

    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        
        Compoe compoe = new Compoe();
        compoe.setFk_Bairro_ID(1);
        compoe.setFk_Endereco_ID(1);
        
        
        BDCompoe compoeBD = new BDCompoe();
        compoeBD.createTable();
        
        compoeBD.insertTable(compoe);
        
        compoe.setFk_Bairro_ID(2);
        
        compoeBD.updateTable(compoe);
        ArrayList <Compoe> listBai = compoeBD.selectTable();
        assertEquals(compoe.getFk_Bairro_ID(), listBai.get(0).getFk_Bairro_ID());
                
    }
    
}
