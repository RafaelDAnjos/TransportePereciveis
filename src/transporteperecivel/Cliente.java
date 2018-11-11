/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

/**
 *
 * @author rafaelda
 */
public class Cliente {
    private String nomeEmpresa;
    private Endereco endereco;
    private String horarioEntrega;

    public Cliente() {
        this.nomeEmpresa = nomeEmpresa;
        this.endereco = endereco;
        this.horarioEntrega = horarioEntrega;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco enderecoEmpresa) {
        this.endereco = enderecoEmpresa;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }
    
    
}
