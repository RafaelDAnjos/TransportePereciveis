/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDAutomovel;
import conexao.BDBairro;
import conexao.BDBandaPorco;
import conexao.BDCidade;
import conexao.BDCliente;
import conexao.BDContato;
import conexao.BDFuncionario;
import conexao.BDEndereco;
import conexao.BDLogradouro;
import conexao.BDPedido;
/**
 *
 * @author Rafael
 */
public class CriarBancoDados {
    BDAutomovel tabelaautomovel = new BDAutomovel();
    BDBairro  tabelabairro = new BDBairro();
    BDBandaPorco tabelabandaporco = new BDBandaPorco();
    BDCidade tabelacidade = new BDCidade();
    BDCliente tabelacliente = new BDCliente();
    BDContato tabelacontato = new BDContato();
    BDEndereco tabelaendereco = new BDEndereco();
    BDFuncionario tabelafuncionario = new BDFuncionario();
    BDLogradouro tabelalogradouro = new BDLogradouro();
    BDPedido tabelapedido = new BDPedido();
    public CriarBancoDados(){
       tabelaautomovel.createTable();
       tabelabairro.createTable();
       tabelabandaporco.createTable();
       tabelacidade.createTable();
       tabelacliente.createTable();
       tabelacontato.createTable();
       tabelaendereco.createTable();
       tabelafuncionario.createTable();
       tabelalogradouro.createTable();
       tabelapedido.createTable();
    }
    
}
