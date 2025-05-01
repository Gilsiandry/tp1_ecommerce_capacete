-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete', 'AGV', 'Fechado', 'aa1', 'azul', 56, 1050);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete', 'X11', 'Off-Road', 'xx1', 'roxo', 58, 799);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete', 'Arai', 'Fechado', 'ii1', 'amarelo', 56, 1650);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete', 'Shoei', 'Aberto', 'ss1', 'verde', 60, 1399);
insert into capacete (nome, marca, categoria, modelo, cor, tamanho, preco) values ('Capacete', 'LS2', 'Articulado', 'll1', 'azul', 62, 999);

insert into acessorio (nome, cor) values ('viseira', 'cristal');
insert into acessorio (nome, cor) values ('Oculos Solar', 'fume');
insert into acessorio (nome, cor) values ('Oculos de Proteção', 'camaleão');
insert into acessorio (nome, cor) values ('Narigueira', 'preta');


insert into certificacao (nome, pais, descricao) values ('Imetro', 'Brasil', 'Instituto Nacional de Metrologia, Qualidade e Tecnologia - Brasil');
insert into certificacao (nome, pais, descricao) values ('Sharp', 'Reino Unido', 'Safety Helmet Assessment and Rating Programme - Reino Unido');
insert into certificacao (nome, pais, descricao) values ('Dot', 'Estados Unidos da América', 'Department of Transportation - EUA');
insert into certificacao (nome, pais, descricao) values ('Snell', 'Estados Unidos da América', 'Snell Memorial Foundation - EUA');
insert into certificacao (nome, pais, descricao) values ('Ecc 22.06', 'Suíça', 'Economic Commission for Europe - Europa');


insert into jugular (tipoFechamento) values ('D-ring');
insert into jugular (tipoFechamento) values ('Clic-Clac');
insert into jugular (tipoFechamento) values ('Micrométrico');
insert into jugular (tipoFechamento) values ('Cartucho');


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