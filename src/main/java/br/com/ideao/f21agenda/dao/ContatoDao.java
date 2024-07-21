package br.com.ideao.f21agenda.dao;

import br.com.ideao.f21agenda.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    public List<Contato> getLista() {
        List<Contato> contatos = new ArrayList<>();

        try( PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contato")) {
            pstmt.execute();
            transformaResultSetEmContato(pstmt, contatos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }

    private void transformaResultSetEmContato(PreparedStatement pstmt, List<Contato> contatos) throws SQLException {
        try (ResultSet rs = pstmt.getResultSet()) {
            while (rs.next()) {
                Calendar data = Calendar.getInstance();
                Contato contato = new Contato();
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }
        }
    }
}
