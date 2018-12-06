/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDBandaPorco;
import conexao.BDDa_baixa;
import conexao.BDPedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class Da_baixa {
    private int fk_BandaPorco_ID;
    private int fk__Pedido_ID;

    public void Da_baixa() {
    }
    
    public int getFk_BandaPorco_ID() {
        return fk_BandaPorco_ID;
    }

    public void setFk_BandaPorco_ID(int fk_BandaPorco_ID) {
        this.fk_BandaPorco_ID = fk_BandaPorco_ID;
    }

    public int getFk__Pedido_ID() {
        return fk__Pedido_ID;
    }

    public void setFk__Pedido_ID(int fk__Pedido_ID) {
        this.fk__Pedido_ID = fk__Pedido_ID;
    }
    public void vinculaBandaPorco(BandaPorco novabanda){
        ArrayList<BandaPorco> listabandas = new ArrayList();
        BDBandaPorco instance = new BDBandaPorco();
        listabandas = instance.selectTable();
        
        for(int i =0;i<listabandas.size();i++){
        BandaPorco bandaporco = new BandaPorco();
        bandaporco = listabandas.get(i);
        
        if(bandaporco.getDataDeAbate().equals(novabanda.getDataDeAbate())){
        
            setFk_BandaPorco_ID(bandaporco.getId());
        }
        }
    }
    public void vinculaPedido(Pedido novopedido){
        ArrayList<Pedido>  listapedido = new ArrayList();
        BDPedido instance = new BDPedido();
        listapedido =instance.selectTable();
        
        for(int i =0;i<listapedido.size();i++){
            Pedido pedido = new Pedido();
            pedido = listapedido.get(i);
            if(novopedido.getDataDeEntrega().equals(pedido.getDataDeEntrega())){}
                if(novopedido.getFkcliente() == pedido.getFkcliente()){
                    if(novopedido.getFkfuncionario() == pedido.getFkfuncionario()){
                        if(novopedido.getNumeroBandas() == pedido.getNumeroBandas()){
                            setFk__Pedido_ID(pedido.getId());
                        }
                    }
                }
        }
    }
    
    
    public void criaBaixa(Pedido pedido){
        BDDa_baixa instanceBaixa = new BDDa_baixa();
        BDBandaPorco instanceBanda = new BDBandaPorco();
        List<BandaPorco> listBandaPorco = instanceBanda.selectTable();
        
        int bandasPedido = pedido.getNumeroBandas();
        for(int i = 0; i < listBandaPorco.size(); i++) {
            if(bandasPedido != 0) {
                if(bandasPedido > listBandaPorco.get(i).getQuantidade()) {
                    
                    Da_baixa novo = new Da_baixa();
                    novo.vinculaBandaPorco(listBandaPorco.get(i));
                    novo.vinculaPedido(pedido);
                    
                    instanceBaixa.insertTable(novo);
                    
                    
                    bandasPedido = bandasPedido - listBandaPorco.get(i).getQuantidade();
                }
                else {
                    
                }
            }
        }
        
        

    }
    
    
}
