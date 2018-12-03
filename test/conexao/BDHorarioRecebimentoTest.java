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
import transporteperecivel.HorarioRecebimento;

/**
 *
 * @author rafae
 */
public class BDHorarioRecebimentoTest {
    
    public BDHorarioRecebimentoTest() {
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
     * Test of createTable method, of class BDHorarioRecebimento.
     */
        @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        
        HorarioRecebimento horario = new HorarioRecebimento();
        horario.setHorarioInicio("8:00:00");
        horario.setHorarioFim("10:00:00");
        
        BDHorarioRecebimento recebeBD = new BDHorarioRecebimento();
        recebeBD.createTable();
        
        recebeBD.insertTable(horario);
        
        ArrayList <HorarioRecebimento> listHor = recebeBD.selectTable();
        System.out.println();
        //assertEquals("8:00:00", listHor.get(0).getHorarioInicio());
        assertEquals(horario.getHorarioFim(), listHor.get(0).getHorarioFim());
    }
    
    

}
