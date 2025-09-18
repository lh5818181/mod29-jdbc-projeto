package br.com.project3.dao;

import java.sql.*;
import java.util.*;
import br.com.project3.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void cadastrar(Cliente cliente) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO cliente (nome, cpf) VALUES (?, ?)");
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.executeUpdate();
        conn.close();
    }

    @Override
    public Cliente consultar(String cpf) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"));
        }
        conn.close();
        return cliente;
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
        List<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Cliente(rs.getString("nome"), rs.getString("cpf")));
        }
        conn.close();
        return lista;
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE cliente SET nome = ? WHERE cpf = ?");
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.executeUpdate();
        conn.close();
    }

    @Override
    public void excluir(String cpf) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
        stmt.setString(1, cpf);
        stmt.executeUpdate();
        conn.close();
    }
}
