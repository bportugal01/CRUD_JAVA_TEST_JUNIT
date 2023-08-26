-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Nov-2022 às 17:58
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_restaurante`
--
CREATE DATABASE IF NOT EXISTS `bd_restaurante` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_restaurante`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cardapio`
--

CREATE TABLE `cardapio` (
  `cod_prato` int(11) NOT NULL,
  `nome_prato` varchar(50) NOT NULL,
  `desc_prato` varchar(300) NOT NULL,
  `preco_prato` varchar(15) NOT NULL,
  `cod_tipoprato` int(11) NOT NULL,
  `custo_prato` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Armazenará as informações do menu do restaurante.';

--
-- Extraindo dados da tabela `cardapio`
--

INSERT INTO `cardapio` (`cod_prato`, `nome_prato`, `desc_prato`, `preco_prato`, `cod_tipoprato`, `custo_prato`) VALUES
(1, 'Salami', 'Salame italiano, mortadela com pistache, prosciutto di parma e geleia de tomates acompanhados de pães rústicos.', 'R$ 89,00', 1, 'R$ 40,00'),
(2, 'Bruschetta', 'Pão italiano com tomate uva confitado e mascarpone - Pão italiano com ragu de linguiça levemente picante, manjericão e parmesão.', 'R$ 39,00', 1, 'R$ 55,00'),
(3, 'Gnocchi', 'Nhoque de batata tostado na panela ao molho de gorgonzola, abobrinha e espinafre.', 'R$ 59,00', 3, 'R$ 35,00'),
(4, 'Tagliolini', 'Massa artesanal com ragu de cogumelos trufados e gema crua para finalizar.', 'R$ 69,00', 3, 'R$ 20,00'),
(5, 'Quadrucci', 'Massa recheada com queijo brie e muçarela de búfala, tomatinhos confitados e geleia de tomate.', 'R$ 59,00', 3, 'R$ 30,00'),
(6, 'Carbonara', 'Spaghetti de grano duro com molho carbonara de parmesão, gema caipira, guanciale e bacon.', 'R$ 79,00', 3, 'R$ 52,00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `cod_categoria` int(11) NOT NULL,
  `tipo_categoria` varchar(20) NOT NULL,
  `descricao_categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`cod_categoria`, `tipo_categoria`, `descricao_categoria`) VALUES
(1, 'Bebida', ''),
(2, 'Confeitaria', ''),
(3, 'Refeição', ''),
(4, 'Molho', ''),
(5, 'Cereais', ''),
(6, 'Enlatados', ''),
(7, 'Lacticínios', ''),
(8, 'Massas', ''),
(9, 'Sucos e Refrescos', ''),
(10, 'Pré - Prontos', ''),
(11, 'Carnes', ''),
(12, 'Vegetais', ''),
(13, 'Farináceos', ''),
(14, 'Temperos e Condiment', ''),
(15, 'Utensílios Doméstico', ''),
(16, 'Higiene Pessoal', ''),
(17, 'Limpeza', ''),
(18, 'Hortifrutigranjeiros', ''),
(19, 'Óleos e Gorduras', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `cod_fornecedores` int(11) NOT NULL,
  `nome_fornecedor` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `forma_entrega` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Armazenará as informações referentes aos fornecedores dos produtos.';

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`cod_fornecedores`, `nome_fornecedor`, `endereco`, `cnpj`, `forma_entrega`) VALUES
(1, 'Monteiro', 'R.Samaritá, 37 - São Paulo - SP', '37.579.551/0001-61', 'Retirada no local'),
(2, 'Jundiá Foods', 'Avenida Doutor Dib Sauaia Neto, 802 Alphaville Empresarial – Barueri/SP – CEP 06465-140', '30.947.056/0007-90', 'Retirada no local'),
(3, 'RICEX - Importação e Exportação', 'Av. Tamboré, 1287 - Alphaville\r\nSão Paulo - SP - CEP: 06460-000', '20.115.750/0002-27', 'Retirada no local'),
(4, 'Ditalia', 'Rua Americo Brasiliense nº 1216 Chácara Santo Antônio, Sao Paulo - SP', '24.940.098/0001-25', 'Entrega no estabelecimento'),
(5, 'Copal - Distribuidora', 'Av. Leoberto Leal, 1260 - Barreiros\r\nSão José – SC', '03.837.959/0001-74', 'Transportadora'),
(6, 'SB - Alimentos', 'Av. Clemente Rosa, 925\r\nVila Maringá - Jundiaí - SP', ' 17.933.362/0001-38', 'Transportadora'),
(7, 'Assaí Atacadista', 'Avenida Águia de Haia, 2.636 Parque das Paineiras - São Paulo São Paulo - 03694-000', '06.057.223/0001-71', 'Retirada no local'),
(8, 'Ceratti', 'Rod. SP 324, Km 79,5\r\nÁrea Industrial\r\nVinhedo - SP, 13288-003', '60.832.409/0001-04', 'Transportadora'),
(9, 'Plena Alimentos', 'R. Um, 100 - Jardim Riacho das Pedras, Contagem - MG, 32250-000', '10.198.974/0008-51', 'Transportadora');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecidos`
--

CREATE TABLE `fornecidos` (
  `cod_fornecedores` int(11) NOT NULL,
  `cod_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecidos`
--

INSERT INTO `fornecidos` (`cod_fornecedores`, `cod_produto`) VALUES
(2, 1),
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(1, 10),
(2, 11),
(3, 12),
(4, 13),
(5, 14),
(6, 15),
(7, 15),
(8, 16);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ingredientes`
--

CREATE TABLE `ingredientes` (
  `cod_ingrediente` int(11) NOT NULL,
  `cod_produto` int(11) NOT NULL,
  `cod_prato` int(11) NOT NULL,
  `qntd_receita` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ingredientes`
--

INSERT INTO `ingredientes` (`cod_ingrediente`, `cod_produto`, `cod_prato`, `qntd_receita`) VALUES
(1, 1, 3, '100g'),
(2, 1, 3, '1 Unid - 500g'),
(3, 3, 3, '1 Gema'),
(4, 4, 3, '3'),
(5, 5, 3, '150g'),
(6, 6, 4, '1 Colher de Sopa'),
(7, 7, 3, '1/4 de Xícara'),
(9, 9, 4, '1 Unidade'),
(10, 4, 4, '2 Unidades'),
(11, 10, 4, '1 Dente'),
(12, 11, 4, '1 Colher de Sopa'),
(13, 7, 4, 'Folhas (á gosto)'),
(14, 6, 4, 'Á gosto'),
(15, 12, 4, 'Fatias (opcionais)'),
(16, 13, 5, '4 Unidades'),
(17, 14, 5, '1 Xícara'),
(19, 3, 5, '1'),
(20, 8, 5, '1 Colher de Sopa'),
(22, 1, 6, '100g'),
(23, 3, 5, '1'),
(24, 1, 3, '100g'),
(26, 1, 3, '100g');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `sobrenome` varchar(60) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `nasc` varchar(15) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `user` varchar(20) NOT NULL,
  `senha` varchar(12) NOT NULL,
  `acesso` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `cel` varchar(15) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `cep` varchar(15) NOT NULL,
  `rua` varchar(20) NOT NULL,
  `num` varchar(10) NOT NULL,
  `comp` varchar(15) NOT NULL,
  `bairro` varchar(15) NOT NULL,
  `city` varchar(15) NOT NULL,
  `est` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela que armazenará as informações do login do usuário.';

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `nome`, `sobrenome`, `cpf`, `rg`, `cargo`, `nasc`, `sexo`, `user`, `senha`, `acesso`, `email`, `cel`, `tel`, `cep`, `rua`, `num`, `comp`, `bairro`, `city`, `est`) VALUES
(1, 'Débora', 'Regina', '423.430.709-20', '39.247.493-1', 'Administração', '10/04/1965', 'Feminino', 'A', '123', 'Alto', 'deh@adm_rest.com', '(11) 98149-6388', '(11) 2875-2216', '77063-538', 'Quadra T 33 Rua NS 2', '597', 'Casa 12', 'Jardim Taquari', 'São Paulo', 'SP'),
(2, 'Isabela', 'Souza Correia', '184.826.423-24', '13.167.826-7', 'Administração', '08/09/1978', 'Feminino', 'B', '456', 'Alto', 'isa@adm_rest.com', '(11) 98339-4260', '(11) 3949-6929', '77015-564', 'Quadra 403 Sul Alame', '309', 'Casa 2', 'Plano Diretor S', 'São Paulo', 'SP'),
(3, 'Gabriela', 'Souza Correia', '592.907.073-30', '32.235.949-1', 'Administradora', '09/09/1951', 'Feminino', 'gabi_gsc', 'gabis2022', 'alto', 'gabi@adm_rest.com', '(11) 98985-8012', '(11) 2976-3446', '69307-560', 'Rua da Laranjeira', '644', 'Casa 01', 'Caçari', 'São Paulo', 'SP'),
(6, 'Ana Beatriz', 'Martins Batista', '22222222222222222', '2222222222222', 'Administradora', '03/06/2005', 'Feminino', 'Ana', '123', 'Alto', 'ana@gmail.com', '(11) 99999-9999', '(11) 9999-9999', '99999999999', 'Rua Inácio', '222', 'Nenhum', 'São Miguel', 'São Paulo', 'São Paulo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `qtd` varchar(10) NOT NULL,
  `validade` varchar(10) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `esp` varchar(50) NOT NULL,
  `categoria` int(11) NOT NULL,
  `preco_custo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Armazenará as informações dos produtos utilizados na receita dos pratos.';

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `descricao`, `qtd`, `validade`, `marca`, `esp`, `categoria`, `preco_custo`) VALUES
(1, 'Salame Italiano', '1 kg', '01/10/2023', 'Seara Gourmet', 'Frios e Laticínios', 10, 'R$ 46,52 por Kilo'),
(2, ' Massa Folhada', '455g', '30/12/2022', 'Arosa', 'Pães', 10, 'R$16,69'),
(3, 'Ovos', '20 Unidade', '30/11/2022', 'Katayama', 'Ovos Tipo Jumbo', 18, 'R$ 11,99'),
(4, 'Tomate', '1 Kg', '01/11/2022', 'Italiano', 'Legumes', 12, 'R$ 5,00'),
(5, 'Queijo Minas Frescal', '1 Kg', '08/11/2022', 'Sensação de Minas', 'Frios e Laticínios', 7, 'R$ 36,90'),
(6, 'Sal', '1 Kg', '10/06/2023', 'Cisne', 'Temperos', 14, 'R$ 2,99'),
(7, 'Manjericão', 'Maço', '01/11/2022', 'Fresco', 'Temperos', 12, 'R$ 7,50'),
(8, 'Azeite de Oliva', '500 ml', '27/09/2023', 'Colavita', 'Óleo e Gordura', 19, 'R$ 59,90'),
(9, 'Pão Italiano', '1 Unidade', '27/10/2022', 'Filão', 'Pães', 10, 'R$ 9,90'),
(10, 'Alho', '1 Kg', '31/01/2023', 'Descascado', 'Legumes', 14, 'R$ 19,90'),
(11, 'Orégano', '1 Kg', '31/05/2023', 'Peruano', 'Temperos', 14, 'R$ 36,90'),
(12, 'Mussarela de Bufala', '1 Kg', '01/11/2022', 'Almeida Prato', 'Frios e Laticínios', 7, 'R$ 82,90'),
(13, 'Batata', '1 Kg', '08/11/2022', 'Batata-Inglesa', 'Legumes', 12, 'R$ 8,49'),
(14, 'Farinha de Trigo', '1 Kg', '30/03/2023', 'Cocamar', 'Farinhas', 13, 'R$ 3,35'),
(15, 'Queijo Parmesão', '1 Kg', '08/11/2022', 'Suaçi', 'Frios e Laticínios', 7, 'R$ 52,90');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE `telefone` (
  `cod_tel` int(11) NOT NULL,
  `numero_tel` varchar(15) NOT NULL,
  `cod_tipotel` int(11) NOT NULL,
  `cod_fornecedores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela que armazenará o número do telefone do fornecedor.';

--
-- Extraindo dados da tabela `telefone`
--

INSERT INTO `telefone` (`cod_tel`, `numero_tel`, `cod_tipotel`, `cod_fornecedores`) VALUES
(1, '(11) 98261-3125', 1, 1),
(2, '(11) 98241-5117', 2, 2),
(3, '(11) 92714-1325', 3, 3),
(4, '(11) 92136-2842', 4, 4),
(5, '(11) 98235-2434', 5, 5),
(6, '(11) 92345-4677', 6, 6),
(7, '(11) 92436-1448', 7, 7),
(8, '(11) 98261-4121', 8, 9),
(9, '(11) 95529-3125', 9, 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoprato`
--

CREATE TABLE `tipoprato` (
  `cod_tipoprato` int(11) NOT NULL,
  `tipo_prato` varchar(50) NOT NULL,
  `descricao_tipo` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipoprato`
--

INSERT INTO `tipoprato` (`cod_tipoprato`, `tipo_prato`, `descricao_tipo`) VALUES
(1, 'Antipasti', '(Entrada)'),
(2, 'Dolci', '(Sobremesa)'),
(3, 'Pasta', '(Prato Principal)'),
(4, 'Del Mar', '(Peixes e Frutos do Mar)'),
(5, 'Carni', '(Carnes)'),
(6, 'Contorni', '(Acompanhamentos)'),
(7, 'Bambini', '(Infantil)'),
(8, 'Bevande', '(Bebidas)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipotelefone`
--

CREATE TABLE `tipotelefone` (
  `cod_tipotel` int(11) NOT NULL,
  `operadora_tel` varchar(15) NOT NULL,
  `descricao_tel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipotelefone`
--

INSERT INTO `tipotelefone` (`cod_tipotel`, `operadora_tel`, `descricao_tel`) VALUES
(1, 'Tim', 'Comercial'),
(2, 'Tim', 'Celular'),
(3, 'Tim', 'Residencial'),
(4, 'Vivo', 'Comercial'),
(5, 'Vivo', 'Celular'),
(6, 'Vivo', 'Residencial'),
(7, 'Claro', 'Comercial'),
(8, 'Claro', 'Celular'),
(9, 'Claro', 'Residencial');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cardapio`
--
ALTER TABLE `cardapio`
  ADD PRIMARY KEY (`cod_prato`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Índices para tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`cod_fornecedores`);

--
-- Índices para tabela `ingredientes`
--
ALTER TABLE `ingredientes`
  ADD PRIMARY KEY (`cod_ingrediente`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`cod_tel`);

--
-- Índices para tabela `tipoprato`
--
ALTER TABLE `tipoprato`
  ADD PRIMARY KEY (`cod_tipoprato`);

--
-- Índices para tabela `tipotelefone`
--
ALTER TABLE `tipotelefone`
  ADD PRIMARY KEY (`cod_tipotel`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cardapio`
--
ALTER TABLE `cardapio`
  MODIFY `cod_prato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `cod_fornecedores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `cod_ingrediente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de tabela `telefone`
--
ALTER TABLE `telefone`
  MODIFY `cod_tel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `tipoprato`
--
ALTER TABLE `tipoprato`
  MODIFY `cod_tipoprato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `tipotelefone`
--
ALTER TABLE `tipotelefone`
  MODIFY `cod_tipotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
