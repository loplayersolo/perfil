package model;

import controller.Reuniao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ReuniaoDAO {

    private  int ultimoIDInserido;
    private DAO dao = new DAO();

    public boolean inserirReuniao(Reuniao reuniao) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            try (PreparedStatement novaReuniao = conexao.prepareStatement("INSERT INTO reuniao (dataReuniao, link) " +
                    "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)) {
                novaReuniao.setString(1, reuniao.getData() + " " + reuniao.getHora());
                novaReuniao.setString(2, reuniao.getLink());

               int rowsAffected = novaReuniao.executeUpdate();

                if (rowsAffected > 0) {
                    //Verdadeiro
                    ResultSet chavePrimaria = novaReuniao.getGeneratedKeys();
                    if (chavePrimaria.next()) {
                        ultimoIDInserido = chavePrimaria.getInt(1);
                    }
                    return true;
                }
                return false;

            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        } finally {

        }

    }
}
