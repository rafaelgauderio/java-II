CREATE TABLE `mavemjpa`.`produto` (
  `id` INT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `quantidadeEstoque` DECIMAL(10) NULL,
  `preco` DECIMAL(10,2) NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
