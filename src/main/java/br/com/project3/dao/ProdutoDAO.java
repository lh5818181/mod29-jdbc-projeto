package br.com.project3.dao;

import java.sql.*;
import java.util.*;
import br.com.project3.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public void cadastrar(Produto produto) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO produto (nome, codigo, preco) VALUES (?, ?, ?)");
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getCodigo());
        stmt.setDouble(3, produto.getPreco());
        stmt.executeUpdate();
        conn.close();
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM produto WHERE codigo = ?");
        stmt.setString(1, codigo);
        ResultSet rs = stmt.executeQuery();
        Produto produto = null;
        if (rs.next()) {
            produto = new Produto(rs.getString("nome"), rs.getString("codigo"), rs.getDouble("preco"));
        }
        conn.close();
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM produto");
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Produto(rs.getString("nome"), rs.getString("codigo"), rs.getDouble("preco")));
        }
        conn.close();
        return lista;
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE produto SET nome = ?, preco = ? WHERE codigo = ?");
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setString(3, produto.getCodigo());
        stmt.executeUpdate();
        conn.close();
    }

    @Override
    public void excluir(String codigo) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM produto WHERE codigo = ?");
        stmt.setString(1, codigo);
        stmt.executeUpdate();
        conn.close();
    }
}
