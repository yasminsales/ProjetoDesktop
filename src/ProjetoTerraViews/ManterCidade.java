
package ProjetoTerraViews;

import ProjetoTerraControllers.ControllerCidade;
import ProjetoTerraModellBins.Cidade;
import ProjetoTerraModellBins.Pais;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterCidade {

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException{
        String nome = JOptionPane.showInputDialog("Nome");
        String capital = JOptionPane.showInputDialog("Capital?(s/n)");
        Boolean isCapital = capital == "s";
        String clima = JOptionPane.showInputDialog("Clima");
        int populacao = Integer.parseInt(JOptionPane.showInputDialog("População"));
        int pais_id = Integer.parseInt(JOptionPane.showInputDialog("ID do país"));
        Cidade cidEnt = new Cidade(nome, isCapital, clima, populacao, new Pais(pais_id)); 
        ControllerCidade cidcontrol = new ControllerCidade();
        Cidade cidSaida = cidcontrol.inserir(cidEnt);
        JOptionPane.showMessageDialog(null, cidSaida.toString());
    }
    public static void alterar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        String capital = JOptionPane.showInputDialog("Capital?(s/n)");
        Boolean isCapital = capital == "s";
        String clima = JOptionPane.showInputDialog("Clima");
        int pais_id = Integer.parseInt(JOptionPane.showInputDialog("Id do país"));
        int populacao = Integer.parseInt(JOptionPane.showInputDialog("População"));
        Cidade cidEnt = new Cidade(id, nome, isCapital, clima, populacao, new Pais(pais_id)); 
        ControllerCidade cidcontrol = new ControllerCidade();
        Cidade cidSaida = cidcontrol.alterar(cidEnt);
        JOptionPane.showMessageDialog(null, cidSaida.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cidade cidEnt = new Cidade(id);
        ControllerCidade contcontrol = new ControllerCidade();
        Cidade cidSaida = contcontrol.buscar(cidEnt);
        JOptionPane.showMessageDialog(null, cidSaida.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cidade cidEnt = new Cidade(id);
        ControllerCidade cidcontrol = new ControllerCidade();
        Cidade cidSaida = cidcontrol.excluir(cidEnt);
        JOptionPane.showMessageDialog(null, cidSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        //Continente conEnt = new Continente(cep); 
        ControllerCidade cidcontrol = new ControllerCidade();
        List<Cidade> listaCidade = cidcontrol.listar(nome);
        JOptionPane.showMessageDialog(null, listaCidade.get(0).toString());        
    }    
}
