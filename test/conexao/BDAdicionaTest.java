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
import transporteperecivel.Adiciona;

/**
 *
 * @author Andreas
 */
public class BDAdicionaTest {
    
    public BDAdicionaTest() {
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
     * Test of createTable method, of class BDAdiciona.
     */
    @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        Adiciona adiciona = new Adiciona();
        adiciona.setFk_BandaPorco_ID(1);
        adiciona.setFk_Funcionario_IDfuncionario(1);
        
        BDAdiciona adicionaBD = new BDAdiciona();
        adicionaBD.createTable();
        
        adicionaBD.insertTable(adiciona);
        
        ArrayList <Adiciona> listCom = adicionaBD.selectTable();
        
        assertEquals(adiciona.getFk_BandaPorco_ID(), listCom.get(0).getFk_BandaPorco_ID());
        assertEquals(adiciona.getFk_Funcionario_IDfuncionario(), listCom.get(0).getFk_Funcionario_IDfuncionario());
    }
    
    @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Adiciona adiciona = new Adiciona();
        adiciona.setFk_BandaPorco_ID(1);
        adiciona.setFk_Funcionario_IDfuncionario(1);
        
        BDAdiciona adicionaBD = new BDAdiciona();
        adicionaBD.createTable();
        
        adicionaBD.insertTable(adiciona);
        
        adicionaBD.deleteTable(adiciona.getFk_BandaPorco_ID(),adiciona.getFk_Funcionario_IDfuncionario());
        
        ArrayList <Adiciona> listCom = adicionaBD.selectTable();

        System.out.println(listCom.size());
        assertEquals(0, listCom.size());
    }
    
    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        
        Adiciona adiciona = new Adiciona();
        adiciona.setFk_BandaPorco_ID(1);
        adiciona.setFk_Funcionario_IDfuncionario(1);
        
        
        BDAdiciona adicionaBD = new BDAdiciona();
        adicionaBD.createTable();
        
        adicionaBD.insertTable(adiciona);
        
        adiciona.setFk_Funcionario_IDfuncionario(2);
        
        adicionaBD.updateTable(adiciona);
        ArrayList <Adiciona> listBai = adicionaBD.selectTable();
        assertEquals(adiciona.getFk_Funcionario_IDfuncionario(), listBai.get(0).getFk_Funcionario_IDfuncionario());
                
    }

    
    


}
