package br.com.project3.domain;

public class Produto {
    private Long id;
    private String nome;
    private String codigo;
    private Double preco;

    public Produto(String nome, String codigo, Double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
