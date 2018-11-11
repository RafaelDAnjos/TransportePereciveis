package transporteperecivel;

import conexao.BDEndereco;
import conexao.DBConnection;

public class Main {

    public static void main(String[] args) {

        DBConnection.getInstance();
        
        BDEndereco enderecoBD = new BDEndereco();
        enderecoBD.createTable();
        
        
        
        
        
        
}
}