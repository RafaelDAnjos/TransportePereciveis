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
import transporteperecivel.Contato;

/**
 *
 * @author nicolas
 */
public class BDContatoTest {

    @Test
    public void testCreateInsertSelect() {
        BDContato bd = new BDContato();
        bd.createTable();

        Contato contato1 = new Contato("27996911212");
        Contato contato2 = new Contato("40028922");

        bd.insertTable(contato1);
        bd.insertTable(contato2);

        List<Contato> contatos = new ArrayList();
        contatos = bd.selectTable();

        assertEquals("SELECT telefone contato1", "27996911212", contatos.get(0).getTelefone());
        assertEquals("SELECT telefone contato2", "40028922", contatos.get(1).getTelefone());

    }

    @Test
    public void testUpdate() {
        BDContato bd = new BDContato();
        bd.createTable();

        Contato contato1 = new Contato("27996911212");
        Contato contato2 = new Contato("40028922");

        bd.insertTable(contato1);
        bd.insertTable(contato2);

        List<Contato> contatos = new ArrayList();
        contatos = bd.selectTable();
        assertEquals("UPDATE contato", "27996911212", contatos.get(0).getTelefone());
        
        contato1.setTelefone("27998932344");
        bd.updateTable(contato1, 1);
        contatos = bd.selectTable();

        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getId() == 1) {
                assertEquals("UPDATE telefone contato1", "27998932344", contatos.get(i).getTelefone());
            }
        }
    }

    @Test
    public void testDelete() {
        BDContato bd = new BDContato();
        bd.createTable();

        Contato contato1 = new Contato("27996911212");
        Contato contato2 = new Contato("40028922");

        bd.insertTable(contato1);
        bd.insertTable(contato2);

        List<Contato> contatos = new ArrayList();
        contatos = bd.selectTable();

        assertEquals("DELETE Deletar clientes", 2, contatos.size());

        bd.deleteTable(1);
        bd.deleteTable(2);

        contatos = bd.selectTable();
        assertEquals("DELETE Deletar contatos", 0, contatos.size());
    }
}
