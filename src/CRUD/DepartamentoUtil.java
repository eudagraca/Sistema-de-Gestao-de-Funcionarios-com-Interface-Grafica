/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import BaseDados.JavaConexao;
import Classes.Departamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EGV
 */
public class DepartamentoUtil {
    JavaConexao depConex = new JavaConexao();
    Departamento dep = new Departamento();
    
    
    public void gravarDep(Departamento dep){
        depConex .Conexao();
        try {
            String SQLinsersao="insert into departamento(id_dep ,nome) values(?,?)";

            PreparedStatement pstm = depConex .con.prepareStatement(SQLinsersao);
            pstm.setString(1, dep.getCodDep());
            pstm.setString(2, dep.getNomeDep());
            
            pstm.executeUpdate(); //    responsavel por retornar Insersao / actualizacao 
             JOptionPane.showMessageDialog(null, "Contacto Cadastrado com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Departamento com sucesso");
        }
        
            
        
    }
    
}
