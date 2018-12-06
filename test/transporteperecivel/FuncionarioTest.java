/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20171bsi0073
 */
public class FuncionarioTest {
    
    public FuncionarioTest() {
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
    
    
    @Test
    public void testCadastrafuncionario() {
        System.out.println("cadastrafuncionario");
        Funcionario instance = new Funcionario();
        
        instance.DeleteFuncionario();
    }

    /**
     * Test of alterarFuncionario method, of class Funcionario.
     */
    /*@Test
    public void testAlterarFuncionario() {
        System.out.println("alterarFuncionario");
        Funcionario instance = new Funcionario();
        instance.alterarFuncionario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}