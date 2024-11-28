CREATE DATABASE livrariadb;

USE livrariadb;

CREATE TABLE livrosDigitais (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100),
    autor VARCHAR(100),
    lancamento DATE,
    formato VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE livrosFisicos (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100),
    autor VARCHAR(100),
    lancamento DATE,
    editora VARCHAR(100),
    disponivel INT,
    PRIMARY KEY(id)
);

INSERT INTO livrosFisicos (nome, autor, lancamento, editora, disponivel) 
VALUES 
('O Senhor dos Anéis', 'J.R.R. Tolkien', '1954-07-29', 'HarperCollins', 12),
('1984', 'George Orwell', '1949-06-08', 'Companhia das Letras', 8),
('Dom Quixote', 'Miguel de Cervantes', '1605-01-16', 'Planeta', 5),
('A Revolução dos Bichos', 'George Orwell', '1945-08-17', 'Editora Globo', 15),
('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', '1943-04-06', 'Intrínseca', 20);

INSERT INTO livrosDigitais (nome, autor, lancamento, formato) 
VALUES 
('O Senhor dos Anéis', 'J.R.R. Tolkien', '1954-07-29', 'ePub'),
('1984', 'George Orwell', '1949-06-08', 'PDF'),
('Dom Quixote', 'Miguel de Cervantes', '1605-01-16', 'MOBI'),
('A Revolução dos Bichos', 'George Orwell', '1945-08-17', 'ePub'),
('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', '1943-04-06', 'PDF');
