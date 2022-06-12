CREATE TABLE tb_paciente(
	id_paciente SERIAL NOT NULL PRIMARY KEY,
	nome VARCHAR(100),
	cpf VARCHAR(20),
	data_nascimento VARCHAR(20),
	sexo CHAR,
	senha VARCHAR(100)
);

CREATE TABLE tb_clinica(
	id_clinica SERIAL NOT NULL PRIMARY KEY,
	nome VARCHAR(100),
	cnpj VARCHAR(25),
	endereco VARCHAR(100)
);

CREATE TABLE tb_medico(
	id_medico SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	cpf VARCHAR(20),
	data_nascimento VARCHAR(20),
	sexo CHAR,
	senha VARCHAR(100)
);

CREATE TABLE tb_geral(
	id_geral SERIAL NOT NULL PRIMARY KEY,
	id_paciente INTEGER,
	id_clinica INTEGER,
	id_medico INTEGER,
	hora TIME WITHOUT TIME ZONE,
	col_data DATE,
	status VARCHAR(50),
	
	FOREIGN KEY (id_paciente) REFERENCES tb_paciente (id_paciente)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	FOREIGN KEY (id_clinica) REFERENCES tb_clinica (id_clinica)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	FOREIGN KEY (id_medico) REFERENCES tb_medico (id_medico)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE tb_anexo(
	id_anexo SERIAL NOT NULL PRIMARY KEY,
	col_link VARCHAR(400)	
);

CREATE TABLE tb_exame(
	id_exame SERIAL NOT NULL PRIMARY KEY,
	tipo_exame VARCHAR(100),
	descricao VARCHAR(200),
	id_geral INTEGER,
	id_anexo INTEGER,
	
	FOREIGN KEY (id_geral) REFERENCES tb_geral (id_geral)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
	
	FOREIGN KEY (id_anexo) REFERENCES tb_anexo (id_anexo)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


--PACIENTE--
insert into tb_paciente (nome, cpf, data_nascimento, sexo, senha) 
values ('Jorge Hugo Alves', '05510798270', '22/02/1989', 'M', '123');

insert into tb_paciente (nome, cpf, data_nascimento, sexo, senha) 
values ('Theo Moura', '08741125592', '16/02/1971', 'M', '123');

insert into tb_paciente (nome, cpf, data_nascimento, sexo, senha) 
values ('Alana Sandra da Paz', '05796194275', '10/04/1990', 'F', '123');

--MEDICO--
insert into tb_medico (nome, cpf, data_nascimento, sexo, senha)
values ('Anthonio Severino da Rocha', '76477753243', '24/01/1991', 'M', '123');

insert into tb_medico (nome, cpf, data_nascimento, sexo, senha)
values ('Alexandre da Luz', '250944868', '07/03/1987', 'M', '123');

insert into tb_medico (nome, cpf, data_nascimento, sexo, senha)
values ('Adriana Rodrigues', '20672327384', '20672327384', 'F', '123');

--CLINICA--
insert into tb_clinica (nome, endereco, cnpj) 
values ('Lab. Neo Quimica', 'Rua dos Pinheiros-496',  '88223446000126');

insert into tb_clinica (nome, endereco, cnpj) 
values ('Lab. Regius', 'Rua Coari 194',  '54706198000152');

insert into tb_clinica (nome, endereco, cnpj) 
values ('Lab. Osorio de Moraes', 'Rua Demeciano de Mattos Pereira 791',  '37835917000116');

--GERAL--
insert into tb_geral (col_data, hora, status, id_clinica, id_medico, id_paciente)
values ( now(), now(),'DISPONIVEL', 1, 1, 1);

insert into tb_geral (col_data, hora, status, id_clinica, id_medico, id_paciente)
values ( now(), now(),'DISPONIVEL', 2, 2, 2);

insert into tb_geral (col_data, hora, status, id_clinica, id_medico, id_paciente)
values ( now(), now(),'DISPONIVEL', 3, 3, 3);

--ANEXO--
insert into tb_anexo (col_link)
values ('vitaminaB12.pdf');

insert into tb_anexo (col_link)
values ('hemograma.pdf');

insert into tb_anexo (col_link)
values ('VitaminaD.pdf');

--EXAME--
insert into tb_exame (descricao, tipo_exame, id_geral, id_anexo) 
values ('Exame de Vitamina B12.', 'Vitamina B12', 1, 1);

insert into tb_exame (descricao, tipo_exame, id_geral, id_anexo) 
values ('Hemograma', 'Hemograma', 2, 2);

insert into tb_exame (descricao, tipo_exame, id_geral, id_anexo) 
values ('Vitamina D', 'Vitamina D', 3, 3);