/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transporteperecivel.Pedido;

/**
 *
 * @author nicolas
 */
public class BDPedidoTest {

    @Test
    public void testCreateInsertSelect() {
        BDPedido bd = new BDPedido();
        bd.createTable();

        Pedido pedido1 = new Pedido(30, "2018/12/16");
        Pedido pedido2 = new Pedido(15, "2018/12/17");

        bd.insertTable(pedido1);
        bd.insertTable(pedido2);

        List<Pedido> pedidos = new ArrayList();
        pedidos = bd.selectTable();

        assertEquals("SELECT pedido1", 30, pedidos.get(0).getNumeroBandas());
        assertEquals("SELECT pedido2", "2018-12-17", pedidos.get(1).getDataDeEntrega());
    }

    @Test
    public void testUpdate() {
        BDPedido bd = new BDPedido();
        bd.createTable();

        Pedido pedido1 = new Pedido(30, "2018/12/16");
        Pedido pedido2 = new Pedido(15, "2018/12/17");

        bd.insertTable(pedido1);
        bd.insertTable(pedido2);

        List<Pedido> pedidos = new ArrayList();
        pedidos = bd.selectTable();
        assertEquals("UPDATE pedido", 30, pedidos.get(0).getNumeroBandas());

        pedido1.setNumeroBandas(100);
        bd.updateTable(pedido1, 1);
        pedidos = bd.selectTable();

        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == 1) {
                assertEquals("UPDATE numeroBandas pedido1", 100, pedidos.get(i).getNumeroBandas());
            }
        }
    }

    @Test
    public void testDelete() {
        BDPedido bd = new BDPedido();
        bd.createTable();

        Pedido pedido1 = new Pedido(30, "2018/12/16");
        Pedido pedido2 = new Pedido(15, "2018/12/17");

        bd.insertTable(pedido1);
        bd.insertTable(pedido2);
        
        List<Pedido> pedidos = new ArrayList();
        pedidos = bd.selectTable();
        
        assertEquals("DELETE pedido", 2, pedidos.size());
        
        bd.deleteTable(1);
        bd.deleteTable(2);
        
        pedidos = bd.selectTable();
        
        assertEquals("DELETE pedido", 0, pedidos.size());
        
        
    }
}
