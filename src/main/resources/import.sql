-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete Speed', 'AGV', 'Fechado', 'aa1', 'Azul', 56, 1050.90);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete Cross Pro', 'X11', 'Off-Road', 'xx1', 'roxo', 58, 799.50);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete Touring', 'Arai', 'Fechado', 'ii1', 'amarelo', 56, 1650.99);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete Bob Style', 'Shoei', 'Aberto', 'ss1', 'verde', 60, 1399.00);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete Advant', 'LS2', 'Articulado', 'll1', 'azul', 62, 999.90);

insert into acessorio (nome, cor) values ('viseira', 'cristal');
insert into acessorio (nome, cor) values ('Oculos Solar', 'fume');
insert into acessorio (nome, cor) values ('Oculos de Proteção', 'camaleão');
insert into acessorio (nome, cor) values ('Narigueira', 'preta');


insert into certificacao (nome, pais, descricao) values ('Imetro', 'Brasil', 'Instituto Nacional de Metrologia, Qualidade e Tecnologia - Brasil');
insert into certificacao (nome, pais, descricao) values ('Sharp', 'Reino Unido', 'Safety Helmet Assessment and Rating Programme - Reino Unido');
insert into certificacao (nome, pais, descricao) values ('Dot', 'Estados Unidos da América', 'Department of Transportation - EUA');
insert into certificacao (nome, pais, descricao) values ('Snell', 'Estados Unidos da América', 'Snell Memorial Foundation - EUA');
insert into certificacao (nome, pais, descricao) values ('Ecc 22.06', 'Suíça', 'Economic Commission for Europe - Europa');


insert into informacao (descricao, anoLancamento) values ('Capacete LS2 Articulado, ideal para quem busca segurança, conforto e praticidade para o uso urbano e em viagens.', 2025);
insert into informacao (descricao, anoLancamento) values ('Capacete AGV Fechado. Proteção, Estilo e Desempenho.', 2024);



insert into jugular (tipoFechamento) values ('D-ring');
insert into jugular (tipoFechamento) values ('Clic-Clac');
insert into jugular (tipoFechamento) values ('Micrométrico');
insert into jugular (tipoFechamento) values ('Cartucho');


insert into lote (codigo, dataFabricacao) values ('c1234', '2025-05-01');
insert into lote (codigo, dataFabricacao) values ('c5678', '2025-05-02');
insert into lote (codigo, dataFabricacao) values ('c9101', '2025-05-02');




-- CapacetesCertificados
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 1);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 2);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 3);

--insert into categoria (nome, id_capacete) values ('Fechado', 1);
--insert into categoria (nome, id_capacete) values ('Articulado', 2);
--insert into categoria (nome, id_capacete) values ('Aberto', 3);
--insert into categoria (nome, id_capacete) values ('Off-Road', 4);


insert into pessoa (nome) values ('Gilsiandry Carvalho');
insert into pessoa (nome) values ('Felipe Augusto');
insert into pessoa (nome) values ('Loja do Motociclista');
insert into pessoa (nome) values ('Tudo de moto');

insert into pessoafisica (id, cpf) values (1, '11111111111');
insert into pessoafisica (id, cpf) values (2, '22222222222');
insert into pessoajuridica (id, cnpj) values (1, '33333333333');
insert into pessoajuridica (id, cnpj) values (2, '44444444444');