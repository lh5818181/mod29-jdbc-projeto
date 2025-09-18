package br.com.project3;

import br.com.project3.dao.ClienteDAO;
import br.com.project3.domain.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private ClienteDAO clienteDAO;

    @Before
    public void setUp() throws Exception {
        clienteDAO = new ClienteDAO();
        // Limpa a tabela antes de cada teste
        clienteDAO.excluir("12345678900");
        clienteDAO.excluir("11122233344");
    }

    @After
    public void tearDown() throws Exception {
        // Limpa a tabela depois de cada teste
        clienteDAO.excluir("12345678900");
        clienteDAO.excluir("11122233344");
    }

    @Test
    public void deveCadastrarEConsultarCliente() throws Exception {
        Cliente cliente = new Cliente("João", "12345678900");
        clienteDAO.cadastrar(cliente);

        Cliente resultado = clienteDAO.consultar("12345678900");
        assertNotNull(resultado);
        assertEquals("João", resultado.getNome());
        assertEquals("12345678900", resultado.getCpf());
    }

    @Test
    public void deveAtualizarCliente() throws Exception {
        Cliente cliente = new Cliente("Maria", "11122233344");
        clienteDAO.cadastrar(cliente);

        cliente.setNome("Maria Silva");
        clienteDAO.atualizar(cliente);

        Cliente resultado = clienteDAO.consultar("11122233344");
        assertNotNull(resultado);
        assertEquals("Maria Silva", resultado.getNome());
    }

    @Test
    public void deveExcluirCliente() throws Exception {
        Cliente cliente = new Cliente("Pedro", "12345678900");
        clienteDAO.cadastrar(cliente);

        clienteDAO.excluir("12345678900");

        Cliente resultado = clienteDAO.consultar("12345678900");
        assertNull(resultado);
    }

    @Test
    public void deveBuscarTodosClientes() throws Exception {
        clienteDAO.cadastrar(new Cliente("Ana", "12345678900"));
        clienteDAO.cadastrar(new Cliente("Carlos", "11122233344"));

        List<Cliente> clientes = clienteDAO.buscarTodos();

        assertNotNull(clientes);
        assertEquals(2, clientes.size());
    }
}