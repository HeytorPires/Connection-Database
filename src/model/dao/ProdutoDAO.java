
package model.dao;
import model.bean.Produto;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author heyto
 */

public class ProdutoDAO {
        
        public void Create(Produto p) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.GetConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("INSERT INTO produtos (descricao, quantidade, preco) values  (?,?,?)");
                
                stmt.setString(1,p.getDescricao());
                stmt.setInt(2, p.getQuantd());
                stmt.setDouble(3, p.getPreco());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Produto salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
}
