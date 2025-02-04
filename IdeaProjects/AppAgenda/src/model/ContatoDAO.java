package model;

import controller.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContatoDAO {

    private DAO dao = new DAO();
    private int ultimoIDInserido;

    public boolean inserirContato(Contato contato) {
        try {
            Connection conexao = dao.conectar();


            //Preparar a execução da query SQL
            PreparedStatement novaContato = conexao.prepareStatement("INSERT INTO contato (nome, telefone) " + "VALUES (?,?);", Statement.RETURN_GENERATED_KEYS);
            novaContato.setString(1, contato.getNome());
            novaContato.setString(2, contato.getTelefone());

            int rowsAffected = novaContato.executeUpdate();

             if (rowsAffected > 0) {
                //Verdadeiro
                ResultSet chavePrimaria = novaContato.getGeneratedKeys();
                if (chavePrimaria.next()) {
                    ultimoIDInserido = chavePrimaria.getInt(1);
                }
                return true;
            }
            return false;


        } catch (Exception e) {
            System.out.println(e);
            return false;  //false
        }
    }
   public int getUltimoIDInserido(){
        return ultimoIDInserido;
   }
}
