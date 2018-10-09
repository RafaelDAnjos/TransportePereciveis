/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
*/
package transporteperecivel;
import java.util.ArrayList;
/**
 *
 * @author 20171bsi0073
 */
public class Persistencia {
    public ArrayList<Funcionario>listaFuncionarios = new ArrayList<Funcionario>();
    public void SalvarFunc(Funcionario novoFuncionario){
        listaFuncionarios.add(novoFuncionario);
        
                }
}

