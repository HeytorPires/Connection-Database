/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author heyto
 */
public class UsuarioDAO {
  public boolean checklogin(String login, String senha) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            try{
                stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ? ");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                     check = true;
                    
                }
            } catch(SQLException ex) {
              Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }          
            return check;
        }
}
