# Sistema de Gerenciamento de Biblioteca

Este é um sistema simples de gerenciamento de biblioteca desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO), incluindo modelagem de dados, padrão MVC (Model-View-Controller), tratamento de exceções e padrão DAO (Data Access Object).

## Funcionalidades

- Adicionar um livro
- Remover um livro
- Buscar um livro por ID
- Listar todos os livros

## Estrutura do Projeto

- **Model**: Classe `Livro` que representa um livro.
- **Interface**: Interface `LivroDAO` e sua implementação `LivroDAOImpl` para operações CRUD com o banco de dados.
- **Controller**: Classe `LivroController` que gerencia a interação entre a View e o DAO.
- **View**: Classe `BibliotecaView` que representa a interface do usuário.

## Requisitos

- Java 8 ou superior
- MySQL
- Biblioteca JDBC do MySQL

## Configuração

### Banco de Dados

1. Crie o banco de dados e a tabela executando o seguinte script SQL:

    ```sql
    -- Criação do banco de dados
    CREATE DATABASE biblioteca;

    -- Selecionar o banco de dados criado
    USE biblioteca;

    -- Criação da tabela livros
    CREATE TABLE livros (
        id INT PRIMARY KEY auto_increment,
        titulo VARCHAR(255) NOT NULL,
        autor VARCHAR(255) NOT NULL
    );

    -- Inserção de alguns registros de exemplo (opcional)
    INSERT INTO livros (titulo, autor) VALUES ('Dom Quixote', 'Miguel de Cervantes');
    INSERT INTO livros (titulo, autor) VALUES ('1984', 'George Orwell');
    INSERT INTO livros (titulo, autor) VALUES 'O Senhor dos Anéis', 'J.R.R. Tolkien');
    ```

2. Configure o usuário e senha do MySQL no arquivo `LivroDAOImpl.java`:

    ```java
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "password";  // Substitua pela sua senha do MySQL
    ```

### Execução

1. Compile o projeto:

    ```bash
    javac *.java
    ```

2. Execute a aplicação:

    ```bash
    java BibliotecaView
    ```

## Exceções Personalizadas

- **DAOException**: Classe de exceção personalizada para tratar erros específicos do DAO.

## Classes Principais

### Livro

Representa um livro com os atributos `id`, `titulo` e `autor`.

### LivroDAO

Interface que define os métodos CRUD para os livros.

### LivroDAOImpl

Implementação da interface `LivroDAO` utilizando JDBC para interagir com o banco de dados MySQL.

### LivroController

Medeia a interação entre a View e o DAO. Contém métodos para adicionar, remover, buscar e listar livros.

### BibliotecaView

Representa a interface do usuário com um menu para adicionar, remover, buscar e listar livros.

## Contato

Para mais informações, entre em contato com Thaian Ramalho em thaianramalho9@gmail.com.
