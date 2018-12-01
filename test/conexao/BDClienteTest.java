/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import transporteperecivel.Cliente;

/**
 *
 * @author nicolas
 */
public class BDClienteTest {

    @Test
    public void testInsert() {
        BDCliente bd = new BDCliente();
        bd.createTable();

        Cliente cliente1 = new Cliente("Nicolas", "111111111111");
        Cliente cliente2 = new Cliente("Pedro", "222222222222");

        bd.insertTable(cliente1);
        bd.insertTable(cliente2);
        
        List<Cliente> Clientes = new ArrayList();
        Clientes = bd.selectTable();
               
        assertEquals("SELECT Valor cliente 1",Clientes.get(0).getNomeFicticio(), cliente1.getNomeFicticio());
        assertEquals("SELECT Valor cliente 2",Clientes.get(1).getNomeFicticio(), cliente2.getNomeFicticio()); 
    }
    
    @Test
    public void testDelete(){
        BDCliente bd = new BDCliente();
        bd.createTable();

        Cliente cliente1 = new Cliente("Nicolas", "111111111111");
        Cliente cliente2 = new Cliente("Pedro", "222222222222");

        bd.insertTable(cliente1);
        bd.insertTable(cliente2);
        
        List<Cliente> Clientes = new ArrayList();
        Clientes = bd.selectTable();
        
        bd.updateTable("Lucas", cliente1.getCnpj(), 1);
        Clientes = bd.selectTable();
        
        for (int i = 0; i < Clientes.size(); i++){
            if (Clientes.get(i).getId() == 1){
                assertEquals("UPDATE Nome cliente1", "Lucas", Clientes.get(i).getNomeFicticio());
            }
        }
    }
    
    @Test
    public void testUpdate(){
        BDCliente bd = new BDCliente();
        bd.createTable();

        Cliente cliente1 = new Cliente("Nicolas", "111111111111");
        Cliente cliente2 = new Cliente("Pedro", "222222222222");

        bd.insertTable(cliente1);
        bd.insertTable(cliente2);
        
        List<Cliente> Clientes = new ArrayList();
        Clientes = bd.selectTable();
        
        //EXEMPLO DE DELETAR PELO NOME
        for (int i = 0; i < Clientes.size(); i++){
            //USUÁRIO QUER DELETAR O PEDRO
            if ("Pedro".equals(Clientes.get(i).getNomeFicticio())){
                bd.deleteTable(Clientes.get(i).getId());
            }
            
        }
        bd.deleteTable(1);
        
        Clientes = bd.selectTable();
        assertEquals("DELETE Deletar clientes", 0, Clientes.size());  
    }
    
}