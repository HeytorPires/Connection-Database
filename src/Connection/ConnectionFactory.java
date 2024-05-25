/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

//import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author heyto
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/pires";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection GetConnection() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassCastException ex){
             //System.out.println("Driver JDBC não encontrado.");
             //ex.printStackTrace();
             throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void CloseConnection(Connection con){
       
            try {
                 if(con != null){
                con.close();
                 }
            } catch (IOException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
     public static void CloseConnection(Connection con, PreparedStatement stmt){
         
         CloseConnection(con);
         
            try {
                 if(stmt != null){
                     stmt.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
}
