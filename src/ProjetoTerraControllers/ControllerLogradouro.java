
package ProjetoTerraControllers;

import ProjetoTerraModellBins.Logradouro;
import ProjetoTerraModelsDaos.DaoLogradouro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ControllerLogradouro {
    static DaoLogradouro daoLog;
    
    public Logradouro inserir (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.inserir(log);
    }
    public Logradouro alterar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.alterar(log);
    }
    public List<Logradouro> listar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.listar(log);
    }
    public Logradouro excluir(Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.excluir(log);
    }
    public Logradouro buscar(Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.buscar(log);
    }
}
