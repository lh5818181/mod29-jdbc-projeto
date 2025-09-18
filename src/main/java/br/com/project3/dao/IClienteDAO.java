package br.com.project3.dao;

import java.util.List;
import br.com.project3.domain.Cliente;

public interface IClienteDAO {
    void cadastrar(Cliente cliente) throws Exception;

    Cliente consultar(String cpf) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    void atualizar(Cliente cliente) throws Exception;

    void excluir(String cpf) throws Exception;
}
