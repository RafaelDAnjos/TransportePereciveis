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
import transporteperecivel.Logradouro;

/**
 *
 * @author rafaelda
 */
public class BDLogradouroTest {
   


    /**
     * Test of insertTable method, of class BDLogradouro.
     */
    @Test
    public void testInsertTable() {
        System.out.println("insertTable");
        
        Logradouro logradouro = new Logradouro();
        BDLogradouro instance = new BDLogradouro();
        instance.createTable();
        logradouro.setDescricao("AV.");
        instance.insertTable(logradouro);
        
        ArrayList<Logradouro>listaLogradouro = new ArrayList();
        
        listaLogradouro = instance.selectTable();
        
        assertEquals(1,listaLogradouro.size());
    }

    /**
     * Test of deleteTable method, of class BDLogradouro.
     */
    @Test
    public void testDeleteTable() {
        //System.out.println("deleteTable");
        Logradouro logradouro = new Logradouro();
        logradouro.setDescricao("AV.");
         
        BDLogradouro instance = new BDLogradouro(); 
         
        instance.createTable();
        
        instance.insertTable(logradouro);
        
        ArrayList<Logradouro> listaLogradouro = new ArrayList();
        
        
        listaLogradouro = instance.selectTable();
        
        instance.deleteTable(1);
        
        listaLogradouro = instance.selectTable();
        
        
        assertEquals(0,listaLogradouro.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }

 
    
}
