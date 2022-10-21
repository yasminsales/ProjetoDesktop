package Projetoterra;

import ProjetoTerraViews.ManterUsuario;
import ProjetoTerraViews.ManterContinente;
import ProjetoTerraViews.ManterLogradouro;
import ProjetoTerraViews.ManterPais;
import ProjetoTerraViews.ManterCidade;
import ProjetoTerraViews.ManterPessoa;
import ProjetoTerraViews.ManterUsuarioPessoa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProjetoTerra {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario Inválido");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        Boolean continuar = true;

        while (continuar) {
            try {
                String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - UsuarioPessoa \n 4 - Logradouro \n 5 - Continente \n 6 - País \n 7 - Cidade";
                int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
                switch (num) {
                    case 0:
                        int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");

                        if (sair > 0) {
                            menu();
                        } else {
                            continuar = false;
                        }
                        break;
                    case 1:
                        ManterUsuario.menu();
                        break;
                    case 2:
                        ManterPessoa.menu();
                        break;
                    case 3:
                        ManterUsuarioPessoa.menu();
                        break;
                    case 4:
                        ManterLogradouro.menu();
                        break;
                    case 5:
                        ManterContinente.menu();
                        break;
                    case 6:
                        ManterPais.menu();
                        break;
                    case 7:
                        ManterCidade.menu();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Deu erro! " + e.getMessage());
            }
        }
    }
}
