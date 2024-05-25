
package model.dao;
import model.bean.Produto;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author heyto
 */

public class ProdutoDAO {
        
        public void Create(Produto p) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
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
        public List<Produto> read() throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Produto> produtos = new ArrayList<>();
            
            try{
                stmt = con.prepareStatement("SELECT * FROM produtos");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Produto produto = new Produto();
                    
                    produto.setId(rs.getInt("id"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setQuantd(rs.getInt("quantidade"));
                    produto.setPreco(rs.getDouble("preco"));
                    
                    produtos.add(produto);
                }
            } catch(SQLException ex) {
              Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return produtos;
        }
        public void update(Produto p) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("UPDATE produtos SET descricao = ?, quantidade = ?, preco = ? WHERE id = ?");
                
                stmt.setString(1,p.getDescricao());
                stmt.setInt(2, p.getQuantd());
                stmt.setDouble(3, p.getPreco());
                stmt.setInt(4, p.getId());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        public void delete(Produto p) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
                
                stmt.setInt(1, p.getId());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        
}
