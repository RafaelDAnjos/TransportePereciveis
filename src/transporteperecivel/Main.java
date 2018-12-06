package transporteperecivel;

import conexao.BDBandaPorco;

import conexao.BDConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        while (true)
        {
            int i = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para pesquisar Produto\n"
                     + "digite 2 para registrar Pedido\n"
                     + "digite 3 para Clientes\n"
                     + "digite 4 para Calendario de entrega\n"
                     + "digite 5 para Alterar Estoque\n"
                     + "digite 6 para sair\n"));
            if(i == 1)
            {
                
            }
            else
                {
                    if(i == 2)
                    {
                    
                    
                    }
                    else
                    {
                        if(i == 3)
                        {
                        
                        
                        }
                        else
                        {
                            if(i == 4)
                            {
                            
                            
                            }
                            else
                            {
                                if(i == 5)
                                {
                                
                                
                                }
                                else
                                {
                                    if(i == 6)
                                    {
                                        break;
                                    }
                                    JOptionPane.showMessageDialog(null, "Opção escolhida invalida");
                                
                                }
                                
                            }
                        
                        }
                    }
                }
            }
    }
}