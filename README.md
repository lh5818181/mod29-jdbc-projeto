# Projeto JDBC com PostgreSQL e Maven

Este projeto é uma aplicação Java que demonstra a implementação de um sistema de gerenciamento de clientes e produtos, utilizando **JDBC (Java Database Connectivity)** para interagir com um banco de dados **PostgreSQL**. A estrutura do projeto segue o padrão **DAO (Data Access Object)**, separando a lógica de acesso a dados da lógica de negócio.

O projeto utiliza **Maven** para gerenciar dependências e automatizar o processo de construção.

## Tecnologias e Ferramentas

- **Linguagem:** Java 8+
- **Gerenciador de Dependências:** Apache Maven
- **Banco de Dados:** PostgreSQL
- **Conectividade:** JDBC (driver para PostgreSQL)
- **Testes:** JUnit

## Estrutura do Projeto

A aplicação está organizada nas seguintes camadas:

- `src/main/java/br/com.project3.app`: Contém a classe principal da aplicação (`Main.java`).
- `src/main/java/br.com.project3.dao`: Camada de acesso a dados (DAO), com interfaces e implementações para `Cliente` e `Produto`.
- `src/main/java/br.com.project3.domain`: Contém as classes de domínio (`Cliente.java`, `Produto.java`) que representam as entidades do negócio.
- `src/main/resources`: Armazena o arquivo de configuração de banco de dados (`application.properties`).
- `src/main/sql`: Contém os scripts SQL para a criação das tabelas e inserção de dados.
- `src/test/java/br.com.project3`: Inclui as classes de testes unitários com JUnit.

## Requisitos de Sistema

- **Java Development Kit (JDK)** versão 8 ou superior.
- **Apache Maven** instalado e configurado.
- **Servidor de Banco de Dados PostgreSQL** em execução.

## Configuração e Instalação

Siga os passos abaixo para configurar o projeto no seu ambiente de desenvolvimento:

1.  **Clone o Repositório**
    ```sh
    git clone [https://github.com/lh5818181/mod29-jdbc-projeto.git]
    cd mod29-jdbc-projeto
    ```
2.  **Configuração do Banco de Dados**
    - Certifique-se de que o servidor PostgreSQL está em execução na sua máquina. Se estiver usando o Windows, pode iniciar o serviço pelo "Gerenciador de Serviços" (`services.msc`).
    - Crie o banco de dados `vendas_online_2`:
      ```sql
      CREATE DATABASE vendas_online_2;
      ```
    - Execute os scripts SQL localizados em `src/main/sql/schema.sql` e `src/main/sql/data.sql` para criar as tabelas e popular o banco com dados iniciais.

3.  **Configuração das Propriedades de Conexão**
    - Crie o arquivo `application.properties` no diretório `src/main/resources`.
    - Adicione as seguintes propriedades, substituindo os valores pelo seu usuário e senha do PostgreSQL:
      ```properties
      jdbc.url=jdbc:postgresql://localhost:5432/vendas_online_2
      jdbc.user=postgres
      jdbc.password=admin
      ```

## Executando o Projeto

Você pode executar o projeto de duas formas:

1.  **Executar a Aplicação Principal**
    - A classe `Main.java` contém um exemplo que cadastra um cliente e um produto.
    - Rode a aplicação a partir do seu editor de código (VS Code, Eclipse, IntelliJ) ou pelo terminal.

2.  **Executar os Testes Unitários**
    - Para garantir que as operações CRUD estão funcionando corretamente, rode todos os testes usando o Maven:
    ```sh
    mvn test
    ```
    - **Resultado Esperado:** A execução deve resultar em `BUILD SUCCESS` e todos os testes devem passar (Failures: 0, Errors: 0).

## Estrutura do Código

- A classe **`ConnectionFactory.java`** gerencia a conexão com o banco de dados.
- As interfaces **`IClienteDAO`** e **`IProdutoDAO`** definem o contrato para as operações de persistência.
- As classes **`ClienteDAO`** e **`ProdutoDAO`** implementam os métodos de cadastro, consulta, atualização, exclusão e busca de todos os registros.
- As classes **`Cliente`** e **`Produto`** são as entidades de domínio.

---