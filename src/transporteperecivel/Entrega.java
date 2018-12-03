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
    
}
