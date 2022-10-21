
package ProjetoTerraModelsDaos;

import ProjetoTerraModellBins.Continente;   
import projetoTerra.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoContinente {
    private final Connection c;
    
    public DaoContinente() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Continente excluir(Continente conEnt) throws SQLException {
        String sql = "delete from continente WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, conEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return conEnt;
    }
    
    public Continente buscar(Continente conEnt) throws SQLException {
        String sql = "select * from continente WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, conEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Continente conSaida = null;
        while (rs.next()) {
            // criando o objeto continente
            conSaida = new Continente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3));  
        }
        // adiciona o continente à lista de continentes
        stmt.close();
        return conSaida;
    }
    
    public Continente inserir(Continente conEnt) throws SQLException{
        String sql = "insert into continente " + " (nome, area)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,conEnt.getNome());
        stmt.setInt(2,conEnt.getArea());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            conEnt.setId(id); 
        }
        stmt.close();
        return conEnt;
    }
    
     public Continente alterar(Continente conEnt) throws SQLException{
        String sql = "UPDATE continente SET nome = ?, area = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,conEnt.getNome());
        stmt.setInt(2,conEnt.getArea());
        stmt.setInt(3,conEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return conEnt;
    }
     
     public List<Continente> listar(String nome) throws SQLException{
        // array armazena a lista de registros

        List<Continente> cont = new ArrayList<>();
        
        String sql = "select id, nome, area from continente where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + nome + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Continente
            Continente con = new Continente(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3));
            cont.add(con);
            // adiciona o continente à lista de continentes
        }      
        rs.close();
        stmt.close();
        return cont;
   }
}
