package br.com.project3.dao;

import java.util.List;
import br.com.project3.domain.Produto;

public interface IProdutoDAO {
    void cadastrar(Produto produto) throws Exception;

    Produto consultar(String codigo) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    void atualizar(Produto produto) throws Exception;

    void excluir(String codigo) throws Exception;
}
