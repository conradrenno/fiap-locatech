CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    placa VARCHAR(255),
    modelo VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10, 2)
);

INSERT INTO veiculos(marca, placa, modelo, ano, cor, valor_diaria) VALUES
    ('Chevrolet', 'ABC-1234', 'celta', '2010', 'preta', 100.00);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO pessoas(nome, cpf, telefone, email) VALUES
    ('Rodrigo', '56309924589', '3499898-9898', 'rodrigo@gmail.com');