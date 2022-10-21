
package ProjetoTerraViews;

import ProjetoTerraControllers.ControllerLogradouro;
import ProjetoTerraModellBins.Logradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterLogradouro {
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
        String endereco = JOptionPane.showInputDialog("Endereço");
        String cep = JOptionPane.showInputDialog("Cep");
        String complemento = JOptionPane.showInputDialog("Complemento");
        Logradouro logEnt = new Logradouro(endereco,cep,complemento);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.inserir(logEnt);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }
    
    public static void alterar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String endereco  = JOptionPane.showInputDialog("Endereço");
        String cep = JOptionPane.showInputDialog("Cep");
        String complemento = JOptionPane.showInputDialog("Complemento");
        Logradouro logEnt = new Logradouro(id, endereco, cep, complemento);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.alterar(logEnt);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEnt = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.buscar(logEnt);
        JOptionPane.showMessageDialog(null, logSaida.toString()); 
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEnt = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.excluir(logEnt);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String cep = JOptionPane.showInputDialog("Cep");
        Logradouro logEnt = new Logradouro(cep);
        ControllerLogradouro contLog = new ControllerLogradouro();
        List<Logradouro> listaLogradouro = contLog.listar(logEnt);
        JOptionPane.showMessageDialog(null, listaLogradouro.get(0).toString());      
    }
}
