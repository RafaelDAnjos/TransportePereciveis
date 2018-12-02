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
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();

            String comando = "DROP TABLE IF EXISTS pedido CASCADE;"
                    + "CREATE TABLE pedido (numeroBandas INT, dataDeEntrega VARCHAR(10), id SERIAL);";

            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public void insertTable(Pedido pedido) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();

            String comando = "INSERT INTO pedido (numeroBandas, dataDeEntrega) "
                    + "VALUES(" + pedido.getNumeroBandas() + ",'" + pedido.getDataDeEntrega() + "');";

            stmt.executeUpdate(comando);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Insert realizado com sucesso!!");
    }

    public void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();

            String comando = "DELETE FROM pedido WHERE id=" + id + ";";

            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        System.out.println("Delete realizado com sucesso!!");
    }

    public void updateTable(int numeroBandas, String dataDeEntrega, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();

            String sql = "UPDATE pedido SET numerobandas = " + numeroBandas + ","
                    + "datadeentrega = '" + dataDeEntrega + "' WHERE id =" + id + ";";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        System.out.println("Update realizado com sucesso!!");
    }

    public synchronized ArrayList selectTable() {
        ArrayList listPedidos = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM pedido ;");
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("numeroBandas"), rs.getString("dataDeEntrega"));
                pedido.setId(rs.getInt("id"));
                listPedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Select realizado com sucesso!!");
        return listPedidos;
    }

}
