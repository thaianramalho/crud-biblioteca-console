
CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE livros (
    id INT PRIMARY KEY auto_increment,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL
);

INSERT INTO livros (titulo, autor) VALUES ('Dom Quixote', 'Miguel de Cervantes');
INSERT INTO livros (titulo, autor) VALUES ('1984', 'George Orwell');
INSERT INTO livros (titulo, autor) VALUES ('O Senhor dos Anéis', 'J.R.R. Tolkien');
