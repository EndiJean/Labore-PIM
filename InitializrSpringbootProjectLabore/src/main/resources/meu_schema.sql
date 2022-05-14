CREATE TABLE tb_exame(
	id_exame int NOT NULL PRIMARY KEY,
	tipo_exame varchar(100) NOT NULL,
	descricao varchar(200)	
);

CREATE TABLE tb_paciente(
	id_paciente int NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	cpf varchar(20) NOT NULL,
	data_nascimento int NOT NULL,
	sexo char NOT NULL,
	senha varchar(100) NOT NULL
);

CREATE TABLE tb_clinica(
	id_clinica int NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	cnpj varchar(25) NOT NULL,
	endereco varchar(100) NOT NULL
);

CREATE TABLE tb_medico(
	id_medico int NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	cpf varchar(20) NOT NULL,
	data_nascimento int NOT NULL,
	sexo char NOT NULL,
	senha varchar(100) NOT NULL
);


CREATE TABLE tb_geral(
	id_geral int NOT NULL PRIMARY KEY,
	id_exame int,
	id_paciente int,
	id_clinica int,
	id_medico int,
	hora int,
	col_data int,
	status varchar(50),
	
	FOREIGN KEY (id_exame) REFERENCES tb_exame (id_exame),	
	FOREIGN KEY (id_paciente) REFERENCES tb_paciente (id_paciente),
	FOREIGN KEY (id_clinica) REFERENCES tb_clinica (id_clinica),
	FOREIGN KEY (id_medico) REFERENCES tb_medico (id_medico)
);

CREATE TABLE tb_anexo(
	id_anexo int NOT NULL PRIMARY KEY,
	col_link varchar(400),
	id_geral int,
	
	FOREIGN KEY (id_geral) REFERENCES tb_geral (id_geral)
);

-----------------------------------------

insert into tb_paciente (nome, cpf, data_nascimento, sexo, senha) values ('PACIENTE-1', '111', 0101, 'M', 'senha');
insert into tb_paciente (nome, cpf, data_nascimento, sexo, senha) values ('PACIENTE-2', '222', 0202, 'M', 'senha');

insert into tb_medico (nome, cpf, data_nascimento, sexo, senha) values ('MEDICO-1', '111', 0101, 'M', 'senha');
insert into tb_medico (nome, cpf, data_nascimento, sexo, senha) values ('MEDICO-2', '222', 0202, 'M', 'senha');

insert into tb_clinica (nome, endereco, cnpj) values ('CLINICA-1', 'ENDERECO-1',  '1010');
insert into tb_clinica (nome, endereco, cnpj) values ('CLINICA-2', 'ENDERECO-2',  '2020');

insert into tb_exame (descricao, tipo_exame) values ('DESCRICAO-1', 'TIPO-1');
insert into tb_exame (descricao, tipo_exame) values ('DESCRICAO-1', 'TIPO-2');

insert into tb_geral (col_data, hora, status, id_clinica, id_medico, id_paciente, id_exame) values ('01/01/1111', '11:11','STATUS', 1, 1, 1, 1);
insert into tb_geral (col_data, hora, status, id_clinica, id_medico, id_paciente, id_exame) values ('02/02/2222', '22:22', 'STATUS', 2, 2, 2, 2);

insert into tb_anexo (col_link, id_geral) values ('L1.pdf', 1);
insert into tb_anexo (col_link, id_geral) values ('L2.pdf', 2);

-----------------------------------------

SELECT * 
FROM tb_anexo

INNER JOIN tb_geral
ON tb_anexo.id_geral = tb_geral.id_geral

INNER JOIN tb_exame
ON tb_geral.id_exame = tb_exame.id_exame

INNER JOIN tb_clinica
ON tb_geral.id_clinica = tb_clinica.id_clinica

INNER JOIN tb_medico
ON tb_geral.id_medico = tb_medico.id_medico

INNER JOIN tb_paciente
ON tb_geral.id_paciente = tb_paciente.id_paciente;


-----------------------------------------

SELECT 
paciente.nome,
paciente.cpf,
paciente.data_nascimento,
paciente.sexo,
clinica.nome,
medico.nome,
anexo.col_link,
geral.col_data,
geral.hora,
geral.status

FROM tb_anexo anexo

INNER JOIN tb_geral geral
ON anexo.id_geral = geral.id_geral

INNER JOIN tb_exame exame
ON geral.id_exame = exame.id_exame

INNER JOIN tb_clinica clinica
ON geral.id_clinica = clinica.id_clinica

INNER JOIN tb_medico medico
ON geral.id_medico = medico.id_medico

INNER JOIN tb_paciente paciente
ON geral.id_paciente = paciente.id_paciente;