package transporteperecivel;

import conexao.BDBandaPorco;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafaelda
 */

public class BandaPorco {
    private String dataDeAbate;
    private int quantidade;
    private int id;
    
    public BandaPorco(String dataDeAbate, int qnt){
        this.dataDeAbate = dataDeAbate;
        quantidade = qnt;
    }

    BandaPorco() {
    }

    public String getDataDeAbate() {
        return dataDeAbate;
    }

    public void setDataDeAbate(String dataDeAbate) {
        this.dataDeAbate = dataDeAbate;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 

    public void cadastraBandaPorco(){

        BDBandaPorco instance = new BDBandaPorco();

        String qntdBandas = JOptionPane.showInputDialog("Digite a quantidade de bandas: ");
        int qntd = Integer.parseInt(qntdBandas);

        this.setQuantidade(qntd);
        this.setDataDeAbate(JOptionPane.showInputDialog("Digite a data de abate: "));

        instance.insertTable(this);
    }


    public void pegaBandaPorcoId(){
        BDBandaPorco instance = new BDBandaPorco();
        List<BandaPorco> listBandaPorco = instance.selectTable();
        
        for(int i = 0; i < listBandaPorco.size(); i++) {
            if( this.getQuantidade() == listBandaPorco.get(i).getQuantidade() && this.getDataDeAbate().equals(listBandaPorco.get(i).getDataDeAbate()) ) {
                this.setId(listBandaPorco.get(i).getId());
            }
        }
    }
    
    
    public void deletaBandaPorco() {
        BDBandaPorco instance = new BDBandaPorco();

        instance.deleteTable(getId());
    }
    
    
    public void leBandaPorcos() {
        BDBandaPorco instance = new BDBandaPorco();
        List<BandaPorco> listBandaPorco = instance.selectTable();

        for(int i = 0; i < listBandaPorco.size(); i++) {
            JOptionPane.showMessageDialog(null, "Quantidade de bandas: " + listBandaPorco.get(i).getQuantidade()
                                              + "\nData de abate: " + listBandaPorco.get(i).getDataDeAbate());
        }
    }
    
    
}