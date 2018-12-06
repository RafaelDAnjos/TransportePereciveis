package transporteperecivel;

import conexao.BDCliente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafaelda
 */

public class Cliente {
    private String nomeFicticio;
    private int id;
    private String cnpj;

    public Cliente(String nomeFicticio, String cnpj) {
        this.nomeFicticio = nomeFicticio;
        this.cnpj = cnpj;
    }

    Cliente() {
    }

    public String getNomeFicticio() {
        return nomeFicticio;
    }

    public void setNomeFicticio(String nomeFicticio) {
        this.nomeFicticio = nomeFicticio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public void registraCliente() {
        BDCliente clienteBD = new BDCliente();

        this.setNomeFicticio(JOptionPane.showInputDialog("Digite o nome fictício: "));
        this.setCnpj(JOptionPane.showInputDialog("Digite o CNPJ: "));

        clienteBD.insertTable(this);   
    }

    public void alteraCliente() {
        BDCliente clienteBD = new BDCliente();

        String resposta = JOptionPane.showInputDialog("Digite"
                                                       + "\n1 para alterar o nome fictício"
                                                       + "\n2 para o CNPJ"
                                                       + "\n3 para ambos: ");
        int resp = Integer.parseInt(resposta);
        
        if(resp == 1){
            this.setNomeFicticio(JOptionPane.showInputDialog("Digite o novo nome fictício: "));
        }
        
        else if(resp == 2) {
            this.setCnpj(JOptionPane.showInputDialog("Digite o novo CNPJ: "));
        }
        
        else{
            this.setNomeFicticio(JOptionPane.showInputDialog("Digite o novo nome fictício: "));
            this.setCnpj(JOptionPane.showInputDialog("Digite o novo CNPJ: "));
        }

        clienteBD.updateTable(this, getId());
    }

    public void deletaCliente() {
        BDCliente clienteBD = new BDCliente();

        clienteBD.deleteTable(getId());
    }
    
    public void leClientes() {
        BDCliente clienteBD = new BDCliente();
        List<Cliente> clientes = clienteBD.selectTable();

        for(int i = 0; i < clientes.size(); i++) {
            JOptionPane.showMessageDialog(null, "Nome fictício: " + clientes.get(i).getNomeFicticio()
                                             + "\nCNPJ: " + clientes.get(i).getCnpj());
        }
    }

}
