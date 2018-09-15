package BaseDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

    public class JavaConexao{      
       public PreparedStatement stat; //  Objecto Responsavel por encaminhar requisicoes para o vervidor BD
       public ResultSet rslt; //Repositório com os dados da pesquisa em base de Dados (Statement)
       //Chamar o driver
       private final String driver="com.mysql.jdbc.Driver";
       //Informações referentes a base de dados
       private  final String enderecobd="jdbc:mysql://localhost:3306/projecto_pgr1"; // localização da BD
       private  final String usuariobd="root";
       private  final String senha="";
       public static Connection con; //Responsavel por realizar a conexão
    
    public void Conexao(){              
       try {
          Class.forName(driver);
           con = DriverManager.getConnection(enderecobd, usuariobd, senha); //Reconhece a conexao apartir destes 3 parametros.
            JOptionPane.showMessageDialog(null, "Base de dados conectada Com sucesso");
       } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException("Erro na conexao",e);
       } 
    }
    
    public void fecharConexao() {  
        if(con != null){
            
            try {
                con.close();
                
                JOptionPane.showMessageDialog(null, "Base de dados Fechada");
                
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro ao fechar a Base de dados \n"+ex.getMessage());
            }
        }
         
         
        
       }
    }