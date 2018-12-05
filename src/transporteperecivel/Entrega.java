/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDAutomovel;
import conexao.BDCliente;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class Entrega {
    private int fk_Automovel_ID;
    private int fk_Cliente_ID;

    public int getFk_Automovel_ID() {
        return fk_Automovel_ID;
    }

    public void setFk_Automovel_ID(int fk_Automovel_ID) {
        this.fk_Automovel_ID = fk_Automovel_ID;
    }

    public int getFk_Cliente_ID() {
        return fk_Cliente_ID;
    }

    public void setFk_Cliente_ID(int fk_Cliente_ID) {
        this.fk_Cliente_ID = fk_Cliente_ID;
    }
   public void vinculaAutomovel(Automovel novoautomovel){
       ArrayList<Automovel> listaautomoveis = new ArrayList();
       BDAutomovel instance = new BDAutomovel();
       listaautomoveis = instance.selectTable();
       
       for(int i =0; i<listaautomoveis.size();i++){
           Automovel automovel = new Automovel();
           automovel = listaautomoveis.get(i);
           
           if(automovel.getPlaca().equals(novoautomovel.getPlaca())){
               setFk_Automovel_ID(automovel.getId());
           
           }
       }
   }
        public void vinculaCliente(Cliente novocliente){
        ArrayList<Cliente> listacliente = new ArrayList();
        BDCliente instance = new BDCliente();
        listacliente =  instance.selectTable();
        
        
        for(int i =0;i<listacliente.size();i++){
            Cliente cliente = new Cliente();
            cliente = listacliente.get(i);
            
            if(novocliente.getCnpj().equals(cliente.getCnpj())){
                setFk_Cliente_ID(cliente.getId());
            }
        }

        }
}
