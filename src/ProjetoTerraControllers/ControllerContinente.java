
package ProjetoTerraControllers;

import ProjetoTerraModellBins.Continente;
import ProjetoTerraModelsDaos.DaoContinente;
import java.sql.SQLException;
import java.util.List;

public class ControllerContinente {
    static DaoContinente daoCont;
    public Continente inserir (Continente cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoContinente(); 
        return daoCont.inserir(cont);
    }
    public Continente alterar (Continente cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoContinente(); 
        return daoCont.alterar(cont);
    }
    public List<Continente> listar (String nome) throws SQLException, ClassNotFoundException {
        daoCont = new DaoContinente(); 
        return daoCont.listar(nome);
    }
    public Continente excluir(Continente cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoContinente(); 
        return daoCont.excluir(cont);
    }
    public Continente buscar(Continente cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoContinente(); 
        return daoCont.buscar(cont);
    }
}
