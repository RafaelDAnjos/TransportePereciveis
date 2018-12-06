package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Pedido;

/**
 *
 * @author Daniel
 */
public class BDPedido {

    public synchronized void createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();

            String comando = "DROP TABLE IF EXISTS _pedido CASCADE;"
                    + "CREATE TABLE _pedido "
                    + "(numeroBandas INT, "
                    + "dataEntrega DATE, "
                    + "id SERIAL PRIMARY KEY, "
                    + "fk_cliente_id SERIAL, "
                    + "fk_funcionario_idfuncionario SERIAL);";
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void insertTable(Pedido pedido) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();

            String comando = "INSERT INTO _pedido (numeroBandas, dataEntrega, fk_cliente_id, fk_funcionario_idfuncionario) "
                    + "VALUES(" + pedido.getNumeroBandas() + ",'" + pedido.getDataDeEntrega() + "', " + pedido.getFkcliente() + ", " + pedido.getFkfuncionario() + ");";

            stmt.executeUpdate(comando);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();

            String comando = "DELETE FROM _pedido WHERE id=" + id + ";";

            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }

    public void updateTable(Pedido pedido, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();

            String sql = "UPDATE _pedido SET numeroBandas = " + pedido.getNumeroBandas() + ","
                    + "dataEntrega = '" + pedido.getDataDeEntrega() + "', fk_cliente_id = " + pedido.getFkcliente() + ", fk_funcionario_idfuncionario = " + pedido.getFkfuncionario()
                    + " WHERE id =" + id + ";";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }

    public synchronized ArrayList selectTable() {
        ArrayList listPedidos = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            //c.setAutoCommit(false);
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM _pedido ;");
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("numeroBandas"), rs.getString("dataEntrega"));
                pedido.setFkcliente(rs.getInt("fk_cliente_id"));
                pedido.setFkfuncionario(rs.getInt("fk_funcionario_idfuncionario"));
                pedido.setId(rs.getInt("id"));
                listPedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return listPedidos;
    }

}