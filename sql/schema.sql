CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11) UNIQUE
);

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    codigo VARCHAR(20) UNIQUE,
    preco DECIMAL(10,2)
);
