
insert into capacete (nome, cor, tamanho, preco) values ('Capacete Speed', 'Azul', 56, 1050.90);
insert into capacete (nome, cor, tamanho, preco) values ('Capacete Cross Pro', 'roxo', 58, 799.50);
insert into capacete (nome, cor, tamanho, preco) values ('Capacete Touring', 'amarelo', 56, 1650.99);
insert into capacete (nome, cor, tamanho, preco) values ('Capacete Bob Style', 'verde', 60, 1399.00);


insert into marca (nome, modelo) values ('Shoei', 'M1');
insert into marca (nome, modelo) values ('LS2', 'M2');
insert into marca (nome, modelo) values ('AGV', 'M4');

insert into categoria () values ();


insert into viseira (marca, cor, tipo) values ('Arai', 'Cristal', 'Viseira');
insert into viseira (marca, cor, tipo) values ('Norisk', 'Iridium', 'Óculos');
insert into viseira (marca, cor, tipo) values ('Shoei', 'Cromada', 'Viseira');


insert into jugular () values ();

-- insert into certificacao (nome, pais, descricao) values ('Imetro', 'Brasil', 'Instituto Nacional de Metrologia, Qualidade e Tecnologia - Brasil');
-- insert into certificacao (nome, pais, descricao) values ('Sharp', 'Reino Unido', 'Safety Helmet Assessment and Rating Programme - Reino Unido');
-- insert into certificacao (nome, pais, descricao) values ('Dot', 'Estados Unidos da América', 'Department of Transportation - EUA');
-- insert into certificacao (nome, pais, descricao) values ('Snell', 'Estados Unidos da América', 'Snell Memorial Foundation - EUA');
-- insert into certificacao (nome, pais, descricao) values ('Ecc 22.06', 'Suíça', 'Economic Commission for Europe - Europa');





-- CapacetesCertificados
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 1);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 2);
-- insert into capacetes_certificados (capacete_id, certificado_id) values (1, 3);

--insert int (nome, id_capacete) values ('Fechado', 1);
--insert int (nome, id_capacete) values ('Articulado', 2);
--insert int (nome, id_capacete) values ('Aberto', 3);
--insert int (nome, id_capacete) values ('Fechado', 4);


insert into pessoa (nome) values ('Gilsiandry Carvalho');
insert into pessoa (nome) values ('Felipe Augusto');
insert into pessoa (nome) values ('Loja do Motociclista');
insert into pessoa (nome) values ('Tudo de moto');

insert into pessoafisica (id, cpf) values (1, '11111111111');
insert into pessoafisica (id, cpf) values (2, '22222222222');
insert into pessoajuridica (id, cnpj) values (1, '33333333333');
insert into pessoajuridica (id, cnpj) values (2, '44444444444');




insert into pessoa (nome) values ('Gilsiandry Carvalho');
insert into pessoa (nome) values ('Felipe Augusto');

insert into usuario(username, senha, perfil, id_pessoafisica) 
    values (
        'gilsiandry', 
        'SiM9w9cv/QHp+fZSykTmN52bUoj++hlYrZoet0hxU8eajwrdo6L5hmWoOm96rYeFQ1YyMKBKLuRE05aC5FKL/Q==',
        1,
        1);
insert into usuario(username, senha, perfil, id_pessoafisica) 
    values (
        'felipe', 
        'SiM9w9cv/QHp+fZSykTmN52bUoj++hlYrZoet0hxU8eajwrdo6L5hmWoOm96rYeFQ1YyMKBKLuRE05aC5FKL/Q==',
        2,
        2);


-- inserindo estados
insert into estado (nome, sigla, regiao) values ('Tocantins', 'TO', 2);
insert into estado (nome, sigla, regiao) values ('São Paulo', 'SP', 4);
insert into estado (nome, sigla, regiao) values ('Goiás', 'GO', 1);
insert into estado (nome, sigla, regiao) values ('Rio Grande do Sul', 'RS', 5);
insert into estado (nome, sigla, regiao) values ('Rio de Janeiro', 'RJ', 4);

-- inserindo municipios
insert into municipio (nome, id_estado) values ('Rio de Janeiro', 5);
insert into municipio (nome, id_estado) values ('São Paulo', 2);
insert into municipio (nome, id_estado) values ('Palmas', 1);
insert into municipio (nome, id_estado) values ('Gurupi', 1);


-- ENDEREÇOS

INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, cidade_id)
VALUES ('Rua A', 'Centro', '100', 'Próximo à praça', '77000-000', 1);

INSERT INTO endereco (id, logradouro, bairro, numero, complemento, cep, cidade_id)
VALUES ('Av. Goiás', 'Setor Sul', '200', NULL, '74000-000', 2);


insert into estoque (codigo, estoque, data, id_capacete) values ('111', 8, '2025-06-09', 1);
insert into estoque (codigo, estoque, data, id_capacete) values ('222', 10, '2025-01-13', 2);


insert into endereco(logradouro, bairro, numero, cep, complemento, id_cidade) values ('Av. Teotônio Segurado', 'Plano Diretor Sul', '01', '77000000', 'Loja do Borracheiro', 1);
insert into endereco(logradouro, bairro, numero, cep, complemento, id_cidade) values ('Av Ilustrativa', 'Plano Diretor Norte', '02', '77001111', 'Marquinhos Moto', 1);



-- inserindo usuario com permissao de user e de adm
insert into usuario(nome, cpf, dataNascimento, email, senha) values ('admin','12345678900','1995-03-18', 'admin@email.com', '0cctg7WgpEz7kC/AzVC+KX+bZLPXDtgJDqWWZWnmzHH+7Na2YVxYYSFPxcf7ImAjqfNckx0aT4n5qKM7WEoeEQ==');
insert into perfil_usuario(perfis, id_usuario) values (1, 1);
insert into perfil_usuario(perfis, id_usuario) values (2, 1);
insert into funcionario(id_usuario, altura) values (1, 1.78);
insert into cliente(id_usuario, datacadastro) values (1, '2024-01-16');
insert into telefone(codigoarea, numero) values ('63', '32155065');
insert into telefone(codigoarea, numero) values ('63', '32127070');
insert into telefone_usuario(id_usuario, telefones_id) values (1, 1);
insert into telefone_usuario(id_usuario, telefones_id) values (2, 2);
insert into endereco(logradouro, bairro, numero, cep, complemento, id_cidade) values ('104 Sul, Alameda 10', 'Plano Diretor Sul', '01', '77000111', 'S/C', 1);
insert into endereco_usuario(id_usuario, enderecos_id) values (1, 1);
insert into cartao(titular, numero, cvc, cpfcartao, id_cliente, modalidadecartao, datavalidade) values ('Fulano da Silva', '111 2222 3333 4444', '354', '12345678900', 1, 1, '2029-02-01');


-- inserindo usuario com permissao apenas de user
insert into usuario(nome, cpf, dataNascimento, email, senha) values ('cliente','34567891000','2005-06-28', 'cliente@email.com', '0cctg7WgpEz7kC/AzVC+KX+bZLPXDtgJDqWWZWnmzHH+7Na2YVxYYSFPxcf7ImAjqfNckx0aT4n5qKM7WEoeEQ==');
insert into perfil_usuario(perfis, id_usuario) values (2, 2);
insert into cliente(id_usuario, datacadastro) values (2, '2025-10-19');

-- inserindo usuario com permissao apenas de adm
insert into usuario(nome, cpf, dataNascimento, email, senha) values ('gerente','11223344556','1985-02-25', 'gerente@email.com', '0cctg7WgpEz7kC/AzVC+KX+bZLPXDtgJDqWWZWnmzHH+7Na2YVxYYSFPxcf7ImAjqfNckx0aT4n5qKM7WEoeEQ==');
insert into perfil_usuario(perfis, id_usuario) values (1, 3);
insert into funcionario(id_usuario, altura) values (3, 1.75);