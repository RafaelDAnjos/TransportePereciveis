/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

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
    

    
}
