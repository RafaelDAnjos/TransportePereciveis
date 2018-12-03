/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDAutomovel;
import conexao.BDFuncionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Tânia
 */
public class AutomovelTest {
    
    public AutomovelTest() {
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
    public void testVinculaFuncionario() {
        System.out.println("vinculaFuncionario");
        Funcionario motorista = new Funcionario();
        Automovel automovel = new Automovel();
        BDFuncionario instance2 = new BDFuncionario();
        BDAutomovel instance = new BDAutomovel();
        
        ArrayList<Funcionario>listafuncionario = new ArrayList();
        ArrayList<Automovel> listaautomovel = new ArrayList();
        
        
        instance2.createTable();
        instance.createTable();
        
        motorista.setCargaHoraria("08:00:00");
        motorista.setCpf("111");
        motorista.setNome("Rafael");
        motorista.setSenha("123456");
        
        instance2.insertTable(motorista);
        
        listafuncionario = instance2.selectTable();
        
        automovel.vinculaFuncionario(listafuncionario.get(0));
        
        instance.insertTable(automovel);
        
        listaautomovel = instance.selectTable();
        
        assertEquals(listaautomovel.get(0).getFk_funcionario_idfuncionario(),listafuncionario.get(0).getIdfuncionario());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
