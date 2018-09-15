
//É neste pacote onde teremos as operações: Criar, Apagar, Actualizar e Pesquisar 
package CRUD;

import Ajustes.Solucoes;
import BaseDados.JavaConexao;
import Classes.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author EGV
 */

public class FuncionarioUtil {
    JavaConexao Conex = new JavaConexao(); // instanciando a classe da base de dados
    Funcionarios fnc = new Funcionarios(); //instanciando a classe funcionarios, para usar seus atributos
 
    PreparedStatement ps = null;
    ResultSet rst;
    Connection con=null;
    //Metodo para gravar dados na base
    public boolean Gravar(Funcionarios fnc) throws SQLException{
        Conex.Conexao();
        
            String SQLinsersao="insert into funcionario(nome,apelido,sexo,data_nasc,bi,nuit,grau_academico,provincia,distrito,senha,usuario,perfil) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(SQLinsersao);
            ps.setString(1, fnc.getNome());
            ps.setString(2, fnc.getApelido());
            ps.setString(3, fnc.getSexo());
            ps.setString(4, Solucoes.ConverterData(fnc.getDataNasc()));
            ps.setString(5,fnc.getBi());
            ps.setInt(6, fnc.getNuit());
            ps.setString(7, fnc.getNivelacad());
            ps.setString(8, fnc.getProvincia());
            ps.setString(9, fnc.getDistrito());
            ps.setString(10, fnc.getSenha());
            ps.setString(11, fnc.getUsuario());
            ps.setString(12, fnc.getPerfil());
            ps.executeUpdate();
            int verifica = ps.executeUpdate();
            
            if(verifica>0)
                return true;
            else        
        return false;
        }
    
    
        //Aplicando os conceitos do polimorfismo
    public Funcionarios pesquisar(String Nome) throws SQLException{
       JavaConexao cone = new JavaConexao();
       
        String SQLconsulta = "select  from funcionario where nome=?";
            PreparedStatement prs =con.prepareStatement(SQLconsulta);
            prs.setString(1, Nome);
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
            fnc.setNome(rs.getString("nome"));
            fnc.setApelido(rs.getString("apelido"));
            fnc.setSexo(rs.getString("sexo"));
            fnc.setDataNasc(Solucoes.ConverterData(rs.getString("data_nasc")));
            fnc.setBi(rs.getString("bi"));
            fnc.setNuit(rs.getInt("nuit"));
            fnc.setNivelacad(rs.getString("grau_academico"));
            fnc.setProvincia(rs.getString("provincia"));
            fnc.setDistrito(rs.getString("distrito"));
            fnc.setSenha(rs.getString("senha"));
            fnc.setUsuario(rs.getString("usuario"));
            fnc.setPerfil(rs.getString("perfil"));
            }
        
        return fnc;
    }
    }