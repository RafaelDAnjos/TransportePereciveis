/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.DBConnection;
import conexao.InsertEstoque;
import conexao.SelectEstoque;
import java.util.ArrayList;

/**
 *
 * @author rafaelda
 */
public class Estoque {
   public int numeroBandas;
   public String dataAbate;
 public void adicionarEmEstoque(){
  
     InsertEstoque estoque = new InsertEstoque();
     
     estoque.inserirEstoque(numeroBandas, dataAbate);
     
 }
 
public void deletarEmEstoque(int numBandaremover){
    SelectEstoque novoselect = new SelectEstoque();
    ArrayList<Estoque>estoque = new ArrayList();
    estoque = novoselect.selectTable();
}
public int diminuirEstoque(){
    
    
       return 0;
}
}
