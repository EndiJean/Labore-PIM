CREATE TABLE tb_exame(
	id_exame integer NOT NULL PRIMARY KEY,
	tipo_exame varchar(100),
	descricao varchar(200)	
);

CREATE TABLE tb_paciente(
	id_paciente integer NOT NULL PRIMARY KEY,
	nome varchar(100),
	cpf varchar(20),
	data_nascimento varchar(20),
	sexo char,
	senha varchar(100)
);

CREATE TABLE tb_clinica(
	id_clinica integer NOT NULL PRIMARY KEY,
	nome varchar(100),
	cnpj varchar(25),
	endereco varchar(100)
);

CREATE TABLE tb_medico(
	id_medico integer PRIMARY KEY,
	nome varchar(100),
	cpf varchar(20),
	data_nascimento varchar(20),
	sexo char,
	senha varchar(100)
);

CREATE TABLE tb_geral(
	id_geral integer NOT NULL PRIMARY KEY,
	id_exame integer,
	id_paciente integer,
	id_clinica integer,
	id_medico integer,
	hora time without time zone,
	col_data date,
	status varchar(50),
	
	FOREIGN KEY (id_exame) REFERENCES tb_exame (id_exame)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,	
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
	id_anexo integer NOT NULL PRIMARY KEY,
	col_link varchar(400),
	id_geral integer,
	
	FOREIGN KEY (id_geral) REFERENCES tb_geral (id_geral)MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

--PACIENTE--
insert into tb_paciente (id_paciente, nome, cpf, data_nascimento, sexo, senha) 
values (1 ,'Joao Hugo Alves', '05510798270', '22/02/1989', 'M', '123');

--MEDICO--
insert into tb_medico (id_medico, nome, cpf, data_nascimento, sexo, senha)
values (1, 'Stefany Fernanda Baptista', '76477753243', '24/01/1991', 'F', '123');

--CLINICA--
insert into tb_clinica (id_clinica, nome, endereco, cnpj) 
values (1, 'CLINICA-1', 'Rua dos Pinheiros-496',  '88223446000126');

--EXAME--
insert into tb_exame (id_exame, descricao, tipo_exame) 
values (1, 'Exame de Vitamina B12.', 'Vitamina B12');

--GERAL--
insert into tb_geral (id_geral, col_data, hora, status, id_clinica, id_medico, id_paciente, id_exame) 
values (1, now(), now(),'DISPONÍVEL', 1, 1, 1, 1);

--ANEXO--
insert into tb_anexo (id_anexo, col_link, id_geral) 
values (1, 'VitaminaB12.pdf', 1);