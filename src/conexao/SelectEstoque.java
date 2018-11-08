package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import transporteperecivel.Estoque;

/**
 *
 * @author felipe
 */
public class SelectEstoque {

    public ArrayList<Estoque> selectTable() {
        ArrayList<Estoque>estoques = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            //c = DriverManager.getConnection("jdbc:sqlite:veiculos.db");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM estoque ;");
            while (rs.next()) {
                Estoque novoestoque = new Estoque();
                novoestoque.numeroBandas = rs.getInt("numbanda");
                novoestoque.dataAbate = rs.getString("dataAbate");
                estoques.add(novoestoque);
           
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operation done successfully");
        return estoques;
    
}
}