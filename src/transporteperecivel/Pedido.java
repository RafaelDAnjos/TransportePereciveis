package transporteperecivel;

import conexao.BDCliente;
import conexao.BDFuncionario;
import conexao.BDPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafaelda
 */

public class Pedido {
    private int numeroBandas;
    private String dataDeEntrega;
    private int id;
    private int fkcliente;
    private int fkfuncionario;
    
    public Pedido(int numeroBandas, String dataDeEntrega){
        this.numeroBandas = numeroBandas;
        this.dataDeEntrega = dataDeEntrega;
    }

    Pedido() {
    }

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    public int getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(int fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }

    public int getNumeroBandas() {
        return numeroBandas;
    }

    public void setNumeroBandas(int numeroBandas) {
        this.numeroBandas = numeroBandas;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void vinculaCliente(Cliente novocliente){
        ArrayList<Cliente> listacliente = new ArrayList();
        BDCliente instance = new BDCliente();
        listacliente =  instance.selectTable();
        
        Cliente cliente = new Cliente();
        for(int i =0;i<listacliente.size();i++){
            cliente = listacliente.get(i);
            
            if(novocliente.getCnpj().equals(cliente.getCnpj())){
                setFkcliente(cliente.getId());
            }
        }
    }


    public void vinculaFuncionario(Funcionario novofuncionario){
    ArrayList<Funcionario> listaFuncionarios = new ArrayList();
    BDFuncionario instance = new BDFuncionario();
    listaFuncionarios = instance.selectTable();
        
    Funcionario funcionario = new Funcionario();
    for(int i =0;i<listaFuncionarios.size();i++){
        funcionario = listaFuncionarios.get(i);
            
        if(funcionario.getCpf().equals(novofuncionario.getCpf())){
            setFkfuncionario(funcionario.getIdfuncionario());           
        }
    }
    }


    public void cadastraPedido(Funcionario funcionario, Cliente cliente){

    BDPedido pedidoBD = new BDPedido();

    String numBandas = JOptionPane.showInputDialog("Digite o número de bandas: ");
    int nBandas = Integer.parseInt(numBandas);

    this.setNumeroBandas(nBandas);
    this.setDataDeEntrega(JOptionPane.showInputDialog("Digite a data de entrega: "));
    this.vinculaCliente(cliente);
    this.vinculaFuncionario(funcionario);

    pedidoBD.insertTable(this);
    }


    public void alteraPedido() {
        BDPedido pedidoBD = new BDPedido();

        String resposta = JOptionPane.showInputDialog("Digite 1 para alterar o número de bandas"
                                                       + "\n2 para a data de entrega"
                                                       + "\n3 para ambos: ");
        int resp = Integer.parseInt(resposta);
        
        if(resp == 1){
            String numBandas = JOptionPane.showInputDialog("Digite o novo número de bandas: ");
            int nBandas = Integer.parseInt(numBandas);
            this.setNumeroBandas(nBandas);
        }
        
        else if(resp == 2) {
            this.setDataDeEntrega(JOptionPane.showInputDialog("Digite a nova data de entrega: "));
        }
        
        else{
            String numBandas = JOptionPane.showInputDialog("Digite o novo número de bandas: ");
            int nBandas = Integer.parseInt(numBandas);
            
            this.setNumeroBandas(nBandas);
            this.setDataDeEntrega(JOptionPane.showInputDialog("Digite a nova data de entrega: "));
        }

        pedidoBD.updateTable(this, getId());
    }

    
    public void pegaPedidoId(){
        BDPedido instance = new BDPedido();
        List<Pedido> listPedido = instance.selectTable();
        
        for(int i = 0; i < listPedido.size(); i++) {
            if( this.getNumeroBandas() == listPedido.get(i).getNumeroBandas() && this.getDataDeEntrega().equals(listPedido.get(i).getDataDeEntrega()) ) {
                this.setId(listPedido.get(i).getId());
            }
        }
    }
    
    
    public void deletaPedido() {
        BDPedido pedidoBD = new BDPedido();

        pedidoBD.deleteTable(getId());
    }
    
    public void lePedidos() {
        BDPedido pedidoBD = new BDPedido();
        List<Pedido> pedidos = pedidoBD.selectTable();

        for(int i = 0; i < pedidos.size(); i++) {
            JOptionPane.showMessageDialog(null, "Número de bandas: " + pedidos.get(i).getNumeroBandas()
                                             + "\nData de entrega: " + pedidos.get(i).getDataDeEntrega());
        }
    }

}