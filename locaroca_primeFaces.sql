-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.19 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para locadora_primefaces
CREATE DATABASE IF NOT EXISTS `locadora_primefaces` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `locadora_primefaces`;

-- Copiando estrutura para tabela locadora_primefaces.cidade
CREATE TABLE IF NOT EXISTS `cidade` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `estado_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_8dh9flkr836hjyp0jblefkgx4` (`estado_codigo`),
  CONSTRAINT `FK_8dh9flkr836hjyp0jblefkgx4` FOREIGN KEY (`estado_codigo`) REFERENCES `estado` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.cidade: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` (`codigo`, `nome`, `estado_codigo`) VALUES
	(1, 'Osasco', 1),
	(2, 'Barueri', 1),
	(3, 'Rio de Janeiro', 2),
	(4, 'Balneário Camboriú', 8),
	(5, 'Curitiba', 4),
	(6, 'Rio Branco', 7),
	(7, 'Belo Horizonte', 3);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` varchar(255) NOT NULL,
  `idade` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `contato_codigo` int NOT NULL,
  `endereco_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_m98g26eiri8hgodx1phaneslk` (`contato_codigo`),
  KEY `FK_ax9efl4qq2gp03j0qf3u8me8q` (`endereco_codigo`),
  CONSTRAINT `FK_ax9efl4qq2gp03j0qf3u8me8q` FOREIGN KEY (`endereco_codigo`) REFERENCES `endereco` (`codigo`),
  CONSTRAINT `FK_m98g26eiri8hgodx1phaneslk` FOREIGN KEY (`contato_codigo`) REFERENCES `contato` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`codigo`, `cpf`, `data_nascimento`, `idade`, `nome`, `rg`, `sexo`, `contato_codigo`, `endereco_codigo`) VALUES
	(1, '239.009.058-35', '27/07/2003', 16, 'Isaac', '55.622.863-7', 'M', 2, 2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.contato
CREATE TABLE IF NOT EXISTS `contato` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.contato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` (`codigo`, `celular`, `email`, `telefone`) VALUES
	(1, '(22) 22222-2222', 'isaac@gmail.com', '(22) 2222-2222'),
	(2, '(22) 22222-2222', 'isaac@gmail.com', '(22) 2222-2222'),
	(3, '(22) 22222-2222', 'funcionario@gmail.com', '(22) 2222-2222');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` int NOT NULL,
  `cidade_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_ii7ybn7tj7onwc7waf6r59pc7` (`cidade_codigo`),
  CONSTRAINT `FK_ii7ybn7tj7onwc7waf6r59pc7` FOREIGN KEY (`cidade_codigo`) REFERENCES `cidade` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.endereco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` (`codigo`, `bairro`, `cep`, `complemento`, `logradouro`, `numero`, `cidade_codigo`) VALUES
	(1, 'Quitauna', '06.182-140', 'Bloco 23', 'Rua José Lourdes', 55, 1),
	(2, 'Quitauna', '22.222-222', 'Bloco 56', 'Rua José Lourdes', 55, 1),
	(3, 'Quitauna', '55.555-555', 'Bloco 67', 'Rua Oslindo', 55, 4);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.estado: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`codigo`, `nome`, `uf`) VALUES
	(1, 'São Paulo', 'SP'),
	(2, 'Rio de Janeiro', 'RJ'),
	(3, 'Minas Gerais', 'MG'),
	(4, 'Paraná', 'PR'),
	(5, 'Espirito Santo', 'ES'),
	(6, 'Piauí', 'PI'),
	(7, 'Acre', 'AC'),
	(8, 'Santa Catarina', 'SC'),
	(9, 'Mato Grosso', 'MT');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.filme
CREATE TABLE IF NOT EXISTS `filme` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `disponivel` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `promocao` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `valor_promocao` double DEFAULT NULL,
  `genero_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_efrf0vr4wi256pti078l23otk` (`genero_codigo`),
  CONSTRAINT `FK_efrf0vr4wi256pti078l23otk` FOREIGN KEY (`genero_codigo`) REFERENCES `genero` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.filme: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `filme` DISABLE KEYS */;
INSERT INTO `filme` (`codigo`, `disponivel`, `nome`, `promocao`, `valor`, `valor_promocao`, `genero_codigo`) VALUES
	(1, 'SIM', 'Filme1', 'SIM', 12, 0, 1),
	(2, 'SIM', 'Filme2', 'NÃO', 3, 5, 4),
	(3, 'SIM', 'Filme3', 'NÃO', 5, 0, 2);
/*!40000 ALTER TABLE `filme` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.forma_pagamento
CREATE TABLE IF NOT EXISTS `forma_pagamento` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.forma_pagamento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `forma_pagamento` DISABLE KEYS */;
INSERT INTO `forma_pagamento` (`codigo`, `descricao`) VALUES
	(1, 'Dinheiro'),
	(2, 'Cartão de débito'),
	(3, 'Cartão de crédito');
/*!40000 ALTER TABLE `forma_pagamento` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` varchar(255) NOT NULL,
  `idade` int NOT NULL,
  `login` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `contato_codigo` int NOT NULL,
  `endereco_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_4ww7n9dt4vuff39nsdld0llek` (`contato_codigo`),
  KEY `FK_jd8x7u2cr96aakqdw918f7kpf` (`endereco_codigo`),
  CONSTRAINT `FK_4ww7n9dt4vuff39nsdld0llek` FOREIGN KEY (`contato_codigo`) REFERENCES `contato` (`codigo`),
  CONSTRAINT `FK_jd8x7u2cr96aakqdw918f7kpf` FOREIGN KEY (`endereco_codigo`) REFERENCES `endereco` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.funcionario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`codigo`, `cpf`, `data_nascimento`, `idade`, `login`, `nome`, `rg`, `senha`, `sexo`, `contato_codigo`, `endereco_codigo`) VALUES
	(1, '239.009.058-35', '27/07/2003', 16, 'isaac', 'Isaac', '55.622.863-7', '123', 'M', 1, 1),
	(2, '239.009.058-35', '27/07/2003', 55, 'admin', 'Funcionario Teste', '55.622.863-7', 'admin', 'M', 3, 3);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.genero
CREATE TABLE IF NOT EXISTS `genero` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.genero: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`codigo`, `descricao`) VALUES
	(1, 'Ação'),
	(2, 'Aventura'),
	(3, 'Ficção'),
	(4, 'Comédia'),
	(5, 'Drama'),
	(6, 'Suspense'),
	(7, 'Infantil'),
	(8, 'Terror'),
	(9, 'Documentário');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.locacao
CREATE TABLE IF NOT EXISTS `locacao` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `data_devolucao` varchar(255) NOT NULL,
  `data_locacao` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `devolvido` varchar(50) NOT NULL,
  `cliente_codigo` int NOT NULL,
  `forma_pagamento_codigo` int NOT NULL,
  `funcionario_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_p4t1o8l3cgmsr4uki7gnmr0sx` (`cliente_codigo`),
  KEY `FK_6cmb297auvemnevgy1opolgk6` (`forma_pagamento_codigo`),
  KEY `FK_rgs9c3rr3t4wbfqh258whn4yg` (`funcionario_codigo`),
  CONSTRAINT `FK_6cmb297auvemnevgy1opolgk6` FOREIGN KEY (`forma_pagamento_codigo`) REFERENCES `forma_pagamento` (`codigo`),
  CONSTRAINT `FK_p4t1o8l3cgmsr4uki7gnmr0sx` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`),
  CONSTRAINT `FK_rgs9c3rr3t4wbfqh258whn4yg` FOREIGN KEY (`funcionario_codigo`) REFERENCES `funcionario` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.locacao: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` (`codigo`, `data_devolucao`, `data_locacao`, `valor`, `devolvido`, `cliente_codigo`, `forma_pagamento_codigo`, `funcionario_codigo`) VALUES
	(1, '28/04/2020', '28/04/2020', 8, 'SIM', 1, 1, 2);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;

-- Copiando estrutura para tabela locadora_primefaces.locacao_filme
CREATE TABLE IF NOT EXISTS `locacao_filme` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `filme_codigo` int NOT NULL,
  `locacao_codigo` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_6lk6kq8ws8bsm8jgpoaa3o88c` (`filme_codigo`),
  KEY `FK_4g6h8f8cr5i3owdsbtlj4jqrp` (`locacao_codigo`),
  CONSTRAINT `FK_4g6h8f8cr5i3owdsbtlj4jqrp` FOREIGN KEY (`locacao_codigo`) REFERENCES `locacao` (`codigo`),
  CONSTRAINT `FK_6lk6kq8ws8bsm8jgpoaa3o88c` FOREIGN KEY (`filme_codigo`) REFERENCES `filme` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora_primefaces.locacao_filme: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `locacao_filme` DISABLE KEYS */;
INSERT INTO `locacao_filme` (`codigo`, `filme_codigo`, `locacao_codigo`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1);
/*!40000 ALTER TABLE `locacao_filme` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
