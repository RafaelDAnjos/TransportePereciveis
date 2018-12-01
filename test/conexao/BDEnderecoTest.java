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
import transporteperecivel.Endereco;

/**
 *
 * @author rafae
 */
public class BDEnderecoTest {
    
    public BDEnderecoTest() {
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
     * Teste da classe BDEndereco
     */
    @Test    
    public void testInsert()
    {
        BDConnection.getInstance();
        Endereco endereco = new Endereco();
        endereco.setDescricao("Bairro Tabuazeiro");
        endereco.setComplemento(" ");
        BDEndereco enderecoBD = new BDEndereco();
        enderecoBD.createTable();
        
        enderecoBD.insertTable(endereco);
        
        ArrayList <Endereco> listEnd = enderecoBD.selectTable();
        
        assertEquals(endereco.getDescricao(), listEnd.get(0).getDescricao());
        assertEquals(endereco.getComplemento(), listEnd.get(0).getComplemento());
    }
    
        @Test
    public void testDeletar()
    {
        BDConnection.getInstance();
        Endereco endereco = new Endereco();
        endereco.setDescricao("Tabuazeiro");
        endereco.setComplemento(" ");
        BDEndereco enderecoBD = new BDEndereco();
        enderecoBD.createTable();
        
        enderecoBD.insertTable(endereco);
        
        enderecoBD.deleteTable(endereco.getDescricao());
        ArrayList <Endereco> listEnd = enderecoBD.selectTable();
        assertEquals(0, listEnd.size());
    }
}
