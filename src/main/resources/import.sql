-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into capacete (nome, marca, modelo, cor, tamanho, preco) values ('Capacete', 'AGV', 'aa1', 'azul', 56, 950);
insert into capacete (nome, marca, modelo, cor, tamanho, preco) values ('Capacete', 'X11', 'xx1', 'roxo', 58, 699);
insert into capacete (nome, marca, modelo, cor, tamanho, preco) values ('Capacete', 'Arai', 'ii1', 'amarelo', 56, 1550);
insert into capacete (nome, marca, modelo, cor, tamanho, preco) values ('Capacete', 'Shoei', 'ss1', 'verde', 60, 1299);
insert into capacete (nome, marca, modelo, cor, tamanho, preco) values ('Capacete', 'LS2', 'll1', 'azul', 62, 1099);

insert into acessorio (nome) values ('viseira')
insert into acessorio (nome) values ('Oculos Solar')
insert into acessorio (nome) values ('Oculos Proteção')
insert into acessorio (nome) values ('Narigueira')

--insert into categoria (nome, id_capacete) values ('Fechado', 1);
--insert into categoria (nome, id_capacete) values ('Articulado', 2);
--insert into categoria (nome, id_capacete) values ('Custom', 3);
--insert into categoria (nome, id_capacete) values ('Off-Road', 4);


-- Capacetes
-- insert into capacete (nome,...) values ('Capacete', ...);
-- insert into capacete (nome,...) values ('Capacete', ...);
-- insert into capacete (nome,...) values ('Capacete', ...);
-- insert into capacete (nome,...) values ('Capacete', ...);

-- Certificados
-- insert into certificacao (nome,...) values ('Imetro', ...);
-- insert into certificacao (nome,...) values ('Imetro', ...);
-- insert into certificacao (nome,...) values ('Imetro', ...);
-- insert into certificacao (nome,...) values ('Imetro', ...);

-- CapacetesCertificados
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 1);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 2);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 3);
