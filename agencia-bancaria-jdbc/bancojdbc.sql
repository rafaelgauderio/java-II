CREATE TABLE `bancojdbc`.`cliente` (
  `cod_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `saldo` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`cod_cliente`));

ALTER TABLE `bancojdbc`.`cliente` 
CHANGE COLUMN `cod_cliente` `codCliente` INT NOT NULL AUTO_INCREMENT ;

INSERT INTO cliente (nome, endereco, sexo, dataNascimento, saldo) VALUES
('Claudio Albuquerque', 'Rua Silva Jardim', 'M', '1992-04-21',2700.50);

CREATE TABLE `bancojdbc`.`operacoes` (
  `cod` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod`));

INSERT INTO operacoes (cod, descricao) VALUES
('1','Depósito'),
('2','Saque'),
('3','Transferência');

CREATE TABLE `bancojdbc`.`movimentacoes` (
  `num_movimento` INT NOT NULL AUTO_INCREMENT,
  `cod_cliente` INT NOT NULL,
  `cod_cliente_favorecido` INT NULL,
  `cod_operacao` INT NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `data_hora_movimento` DATETIME NOT NULL,
  PRIMARY KEY (`num_movimento`),
  INDEX `cod_cliente_fk_idx` (`cod_cliente` ASC) VISIBLE,
  INDEX `cod_cliente_fav_fk_idx` (`cod_cliente_favorecido` ASC) VISIBLE,
  INDEX `cod_operacao_fk_idx` (`cod_operacao` ASC) VISIBLE,
  CONSTRAINT `cod_cliente_fk`
    FOREIGN KEY (`cod_cliente`)
    REFERENCES `bancojdbc`.`cliente` (`codCliente`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `cod_cliente_fav_fk`
    FOREIGN KEY (`cod_cliente_favorecido`)
    REFERENCES `bancojdbc`.`cliente` (`codCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cod_operacao_fk`
    FOREIGN KEY (`cod_operacao`)
    REFERENCES `bancojdbc`.`operacoes` (`cod`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT);

INSERT INTO movimentacoes (cod_cliente, cod_cliente_favorecido, cod_operacao, valor, data_hora_movimento) VALUES
(1,2,3,500,now());





