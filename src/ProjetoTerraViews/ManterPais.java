
package ProjetoTerraViews;

import ProjetoTerraControllers.ControllerPais;
import ProjetoTerraModellBins.Continente;
import ProjetoTerraModellBins.Pais;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterPais {
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
        int pib = Integer.parseInt(JOptionPane.showInputDialog("Pib"));
        int idh = Integer.parseInt(JOptionPane.showInputDialog("Idh"));
        int continente_id = Integer.parseInt(JOptionPane.showInputDialog("ID do Continente"));
        Pais paisEnt = new Pais(nome, pib, idh, new Continente(continente_id)); 
        ControllerPais contcontrol = new ControllerPais();
        Pais paisSaida = contcontrol.inserir(paisEnt);
        JOptionPane.showMessageDialog(null, paisSaida.toString());
    }

    public static void alterar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        int pib = Integer.parseInt(JOptionPane.showInputDialog("Pib"));
        int idh = Integer.parseInt(JOptionPane.showInputDialog("Idh"));
        int continente_id = Integer.parseInt(JOptionPane.showInputDialog("Id do continente"));
        Pais paisEnt = new Pais(id, nome, pib, idh, new Continente(continente_id));
        ControllerPais contcontrol = new ControllerPais();
        Pais paisSaida = contcontrol.alterar(paisEnt);
        JOptionPane.showMessageDialog(null, paisSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pais paisEnt = new Pais(id);
        ControllerPais contcontrol = new ControllerPais();
        Pais paisSaida = contcontrol.buscar(paisEnt);
        JOptionPane.showMessageDialog(null, paisSaida.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pais paisEnt = new Pais(id);
        ControllerPais contcontrol = new ControllerPais();
        Pais paisSaida = contcontrol.excluir(paisEnt);
        JOptionPane.showMessageDialog(null, paisSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        //Continente conEnt = new Continente(cep); 
        ControllerPais contcontrol = new ControllerPais();
        List<Pais> listaPais = contcontrol.listar(nome);
        JOptionPane.showMessageDialog(null, listaPais.get(0).toString());        
    }
}
