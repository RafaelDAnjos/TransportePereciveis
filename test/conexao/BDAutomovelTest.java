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
import transporteperecivel.Automovel;

/**
 *
 * @author Tânia
 */
public class BDAutomovelTest {
    
    public BDAutomovelTest() {
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
     * Test of createTable method, of class BDAutomovel.
     */


    /**
     * Test of insertTable method, of class BDAutomovel.
     */
    @Test
    public void testInsertTable() {
        System.out.println("insertTable");
        Automovel automovel = new Automovel();
        automovel.setCarga_maxima(4500);
        automovel.setIsrefrigerado(true);
        automovel.setModelo("Mercedes");
        automovel.setPlaca("RAF 6666");
        automovel.setFk_cidade_id(1);
        automovel.setFk_funcionario_idfuncionario(2);
        
        
        BDAutomovel instance = new BDAutomovel();
        
        instance.createTable();
        
        instance.insertTable(automovel);
        
        ArrayList<Automovel> listaAuto = new ArrayList();
        
        listaAuto = instance.selectTable();
        
        assertEquals(1,listaAuto.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteTable method, of class BDAutomovel.
     */
    @Test
    public void testDeleteTable() {
         System.out.println("deleteTable");
        Automovel automovel = new Automovel();
        automovel.setCarga_maxima(4500);
        automovel.setIsrefrigerado(true);
        automovel.setModelo("Mercedes");
        automovel.setPlaca("RAF 6666");
        automovel.setFk_cidade_id(1);
        automovel.setFk_funcionario_idfuncionario(2);
        
        ArrayList<Automovel> listaAuto = new ArrayList(); 
        
        BDAutomovel instance = new BDAutomovel();
        
        instance.createTable();
        
        instance.insertTable(automovel);
        
        listaAuto = instance.selectTable();
        
        instance.deleteTable(listaAuto.get(0).getId());
        
        listaAuto = instance.selectTable();
        
        assertEquals(0,listaAuto.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of updateTable method, of class BDAutomovel.
     */
    @Test
    public void testUpdateTable() {
        System.out.println("updateTable");
        Automovel automovel = new Automovel();
        automovel.setCarga_maxima(4500);
        automovel.setIsrefrigerado(true);
        automovel.setModelo("Mercedes");
        automovel.setPlaca("RAF 6666");
        automovel.setFk_cidade_id(1);
        automovel.setFk_funcionario_idfuncionario(1);
 
        Automovel automovelAlterado;
        
        BDAutomovel instance = new BDAutomovel();
        instance.createTable();
        
        instance.insertTable(automovel);
        
        ArrayList<Automovel> listaAuto = new ArrayList();
        ArrayList<Automovel> listaAuto2 = new ArrayList();
        
        listaAuto = instance.selectTable();
        
        automovelAlterado = listaAuto.get(0);
        
                
        
        
        automovelAlterado.setModelo("GM");
        
        instance.updateTable(automovelAlterado);
        
        listaAuto2 = instance.selectTable();
        
        assertEquals("GM",listaAuto2.get(0).getModelo());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
