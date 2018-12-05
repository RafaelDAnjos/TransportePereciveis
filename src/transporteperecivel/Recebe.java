/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDCliente;
import java.util.ArrayList;
import conexao.BDHorarioRecebimento;

/**
 *
 * @author rafae
 */
public class Recebe {
    private int fk_HorarioRecebimento_ID;
    private int fk_Cliente_ID;

    public int getFk_HorarioRecebimento_ID() {
        return fk_HorarioRecebimento_ID;
    }

    public void setFk_HorarioRecebimento_ID(int fk_HorarioRecebimento_ID) {
        this.fk_HorarioRecebimento_ID = fk_HorarioRecebimento_ID;
    }

    public int getFk_Cliente_ID() {
        return fk_Cliente_ID;
    }

    public void setFk_Cliente_ID(int fk_Cliente_ID) {
        this.fk_Cliente_ID = fk_Cliente_ID;
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
    public void vinculaHorario(HorarioRecebimento novohorario){
        ArrayList<HorarioRecebimento>listahorario = new ArrayList();
        BDHorarioRecebimento instance = new BDHorarioRecebimento();
        listahorario = instance.selectTable();
        
        
        for(int i =0;i<listahorario.size();i++){
            HorarioRecebimento horario = new HorarioRecebimento();
            horario = listahorario.get(i);
            
            if(novohorario.getHorarioInicio().equals(horario.getHorarioInicio()) && novohorario.getHorarioFim().equals(horario.getHorarioFim())){
                setFk_HorarioRecebimento_ID(horario.getID());
                
            
            }
        
        }
    
    }


}

    

