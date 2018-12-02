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
import transporteperecivel.Funcionario;

/**
 *
 * @author rafae
 */
public class BDFuncionarioTest {
    
    public BDFuncionarioTest() {
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
     * Test of createTable method, of class BDFuncionario.
     */
    @Test
    public void testInsert()
    {
        BDConnection.getInstance();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Andreas");
        funcionario.setCargaHoraria("08:00:00");
        funcionario.setCpf("123");
        funcionario.setSenha("123");
        BDFuncionario funcionarioBD = new BDFuncionario();
        funcionarioBD.createTable();
        
        funcionarioBD.insertTable(funcionario);
        
        ArrayList <Funcionario> listFun = funcionarioBD.selectTable();

        assertEquals(funcionario.getNome(), listFun.get(0).getNome());
        assertEquals(funcionario.getCpf(), listFun.get(0).getCpf());
        assertEquals(funcionario.getSenha(), listFun.get(0).getSenha());
        assertEquals(funcionario.getCargaHoraria(), listFun.get(0).getCargaHoraria());
    }
    
    @Test
    public void testDelete()
    {
        BDConnection.getInstance();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Andreas");
        funcionario.setCargaHoraria("08:00:00");
        funcionario.setCpf("123");
        funcionario.setSenha("123");
        BDFuncionario funcionarioBD = new BDFuncionario();
        funcionarioBD.createTable();
        
        funcionarioBD.insertTable(funcionario);
        
        
        funcionarioBD.deleteTable(1);
        ArrayList <Funcionario> listFuncionario = funcionarioBD.selectTable();
        
        assertEquals(0,listFuncionario.size());
    }

    @Test
    public void testUpdate()
    {
        BDConnection.getInstance();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Andreas");
        funcionario.setCargaHoraria("08:00:00");
        funcionario.setCpf("123");
        funcionario.setSenha("123");
        BDFuncionario funcionarioBD = new BDFuncionario();
        funcionarioBD.createTable();
        
        funcionarioBD.insertTable(funcionario);
        
        funcionario.setIdfuncionario(1);
        funcionario.setNome("teste");
        funcionarioBD.updateTable(funcionario);
        ArrayList <Funcionario> listFun = funcionarioBD.selectTable();

        assertEquals(funcionario.getNome(), listFun.get(0).getNome());
        assertEquals(funcionario.getCpf(), listFun.get(0).getCpf());
        assertEquals(funcionario.getSenha(), listFun.get(0).getSenha());
        assertEquals(funcionario.getCargaHoraria(), listFun.get(0).getCargaHoraria());
    }
}
