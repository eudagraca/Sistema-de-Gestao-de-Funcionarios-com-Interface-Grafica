package CRUD;

import BaseDados.JavaConexao;
import Classes.Funcao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EGV
 */
public class FuncaoUtil {
    JavaConexao fucConex = new JavaConexao();
    Funcao fuc = new Funcao();
    
    public void gravarFuncao(Funcao fuc){
         fucConex.Conexao();
        
        try {
            String SQLinsersao="insert into funcao(id_funcao,funcao) values(?,?)";

            PreparedStatement pstm =  fucConex.con.prepareStatement(SQLinsersao);
            pstm.setString(1, fuc.getCodFunc());
            pstm.setString(2, fuc.getNomeFunc());
            
            pstm.executeUpdate(); //Guardando os campos recebidos.
            
            JOptionPane.showMessageDialog(null, "funcao Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "funcao nao cadastrada");
        }
        
    }
    
}
