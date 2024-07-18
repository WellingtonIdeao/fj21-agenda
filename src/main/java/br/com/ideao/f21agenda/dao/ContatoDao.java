package br.com.ideao.f21agenda.dao;

import br.com.ideao.f21agenda.model.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDao {
    private Connection connection;

    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void adicionar(Contato contato) {
        String sql = "INSERT INTO contato " +
                "(nome, email, endereco, dataNascimento) " +
                "values ( ?, ?, ?, ?)";
        try(PreparedStatement pstmt = this.connection.prepareStatement(sql)) {

            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getEmail());
            pstmt.setString(3, contato.getEndereco());
            pstmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
