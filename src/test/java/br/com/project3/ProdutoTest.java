package br.com.project3;

import br.com.project3.dao.ProdutoDAO;
import br.com.project3.domain.Produto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private ProdutoDAO produtoDAO;

    @Before
    public void setUp() throws Exception {
        produtoDAO = new ProdutoDAO();
        // Limpa a tabela antes de cada teste
        produtoDAO.excluir("TEC123");
        produtoDAO.excluir("MOUSE456");
        produtoDAO.excluir("MON789");
    }

    @After
    public void tearDown() throws Exception {
        // Limpa a tabela depois de cada teste
        produtoDAO.excluir("TEC123");
        produtoDAO.excluir("MOUSE456");
        produtoDAO.excluir("MON789");
    }

    @Test
    public void deveCadastrarEConsultarProduto() throws Exception {
        Produto produto = new Produto("Teclado", "TEC123", 120.00);
        produtoDAO.cadastrar(produto);

        Produto resultado = produtoDAO.consultar("TEC123");
        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNome());
        assertEquals("TEC123", resultado.getCodigo());
        assertEquals(120.00, resultado.getPreco(), 0.1);
    }

    @Test
    public void deveAtualizarProduto() throws Exception {
        Produto produto = new Produto("Mouse", "MOUSE456", 50.00);
        produtoDAO.cadastrar(produto);

        produto.setPreco(65.00);
        produtoDAO.atualizar(produto);

        Produto resultado = produtoDAO.consultar("MOUSE456");
        assertNotNull(resultado);
        assertEquals(65.00, resultado.getPreco(), 0.1);
    }

    @Test
    public void deveExcluirProduto() throws Exception {
        Produto produto = new Produto("Monitor", "MON789", 800.00);
        produtoDAO.cadastrar(produto);

        produtoDAO.excluir("MON789");

        Produto resultado = produtoDAO.consultar("MON789");
        assertNull(resultado);
    }

    @Test
    public void deveBuscarTodosProdutos() throws Exception {
        produtoDAO.cadastrar(new Produto("Teclado", "TEC123", 120.00));
        produtoDAO.cadastrar(new Produto("Mouse", "MOUSE456", 50.00));

        List<Produto> produtos = produtoDAO.buscarTodos();

        assertNotNull(produtos);
        assertEquals(2, produtos.size());
    }
}