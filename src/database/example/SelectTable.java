package database.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author felipe
 */
public class SelectTable {

    public synchronized void selectTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            //c = DriverManager.getConnection("jdbc:sqlite:veiculos.db");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Funcionario;");
            while (rs.next()) {             
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                int codEnd = rs.getInt("codEnd");
                String funcao = rs.getString("funcao");

                System.out.println("CODIGO = " + codigo);
                System.out.println("NOME = " + nome);
                System.out.println("CODIGO ENDEREÇO = " + codEnd);
                System.out.println("FUNÇÃO = " + funcao);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operation done successfully");
    }
}