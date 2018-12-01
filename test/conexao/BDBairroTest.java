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
import transporteperecivel.Bairro;
import transporteperecivel.Endereco;

/**
 *
 * @author rafae
 */
public class BDBairroTest {
    
    public BDBairroTest() {
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
     * Test of createTable method, of class BDBairro.
     */
    @Test
    public void testCodigo()
    {
            BDConnection.getInstance();
        
        Bairro bairro = new Bairro();
        bairro.setNome("Tabuazeiro");
        
        BDBairro BairroBD = new BDBairro();
        BairroBD.createTable();
        
        BairroBD.insertTable(bairro);
        
        ArrayList <Bairro> listBai = BairroBD.selectTable();
        assertEquals(bairro.getNome(), listBai.get(0).getNome());
        

        
    }
}
