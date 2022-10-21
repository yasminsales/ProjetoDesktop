
package ProjetoTerraViews;

import ProjetoTerraControllers.ControllerContinente;
import ProjetoTerraModellBins.Continente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterContinente {
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
        int area = Integer.parseInt(JOptionPane.showInputDialog("Área"));
        Continente conEnt = new Continente(nome,area);
        ControllerContinente contcontrol = new ControllerContinente();
        Continente conSaida = contcontrol.inserir(conEnt);
        JOptionPane.showMessageDialog(null, conSaida.toString());
    }
    
    public static void alterar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        int area = Integer.parseInt(JOptionPane.showInputDialog("Área"));
        Continente conEnt = new Continente(id, nome, area);
        ControllerContinente contcontrol = new ControllerContinente();
        Continente conSaida = contcontrol.alterar(conEnt);
        JOptionPane.showMessageDialog(null, conSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Continente conEnt = new Continente(id);
        ControllerContinente contcontrol = new ControllerContinente();
        Continente conSaida = contcontrol.buscar(conEnt);
        JOptionPane.showMessageDialog(null, conSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Continente conEnt = new Continente(id);
        ControllerContinente contcontrol = new ControllerContinente();
        Continente conSaida = contcontrol.excluir(conEnt);
        JOptionPane.showMessageDialog(null, conSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        //Continente conEnt = new Continente(cep); 
        ControllerContinente contcontrol = new ControllerContinente();
        List<Continente> listaContinente = contcontrol.listar(nome);
        JOptionPane.showMessageDialog(null, listaContinente.get(0).toString());        
    }
}