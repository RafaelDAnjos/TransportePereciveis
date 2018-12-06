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

            String comando = "DROP TABLE IF EXISTS pedido CASCADE;"
                    + "CREATE TABLE pedido "
                    + "(numeroBandas INT, "
                    + "dataDeEntrega DATE, "
                    + "id SERIAL PRIMARY KEY, "
                    + "fkcliente SERIAL, "
                    + "fkfuncionario SERIAL);";
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

            String comando = "INSERT INTO pedido (numeroBandas, dataDeEntrega, fkcliente, fkfuncionario) "
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

            String comando = "DELETE FROM pedido WHERE id=" + id + ";";

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

            String sql = "UPDATE pedido SET numerobandas = " + pedido.getNumeroBandas() + ","
                    + "datadeentrega = '" + pedido.getDataDeEntrega() + "', fkcliente = " + pedido.getFkcliente() + ", fkfuncionario = " + pedido.getFkfuncionario()
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

            ResultSet rs = stmt.executeQuery("SELECT * FROM pedido ;");
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("numeroBandas"), rs.getString("dataDeEntrega"));
                pedido.setFkcliente(rs.getInt("fkcliente"));
                pedido.setFkfuncionario(rs.getInt("fkfuncionario"));
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
