/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import BaseDados.JavaConexao;
import Classes.Contacto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EGV
 */
public class ContactoUtil {
    
    JavaConexao contConex = new JavaConexao();
    Contacto cont = new Contacto();
    
    public void gravarCont(Contacto cont){
        contConex.Conexao();
        try {
            
            String SQLinsersao ="insert into contacto(nr_telefone,email) values(?,?)";
            PreparedStatement pstm = contConex.con.prepareStatement(SQLinsersao);
            pstm.setInt(1, cont.getTelefone());
            pstm.setString(2, cont.getEmail());
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contacto Cadastrado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha no Cadastro"+ex);
        }
    }
    
}
