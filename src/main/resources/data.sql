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