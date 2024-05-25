
package model.dao;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author heyto
 */

public class DespesaDAO {
        
        public void Create() throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.GetConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
