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

--  Clinca
INSERT INTO tb_clinica (nome, endereco, cnpj) VALUES ( 'Lab 1', 'Rua 1', '1111111111'); 
INSERT INTO tb_clinica (nome, endereco, cnpj) VALUES ( 'Lab 2', 'Rua 2', '2222222222'); 
INSERT INTO tb_clinica (nome, endereco, cnpj) VALUES ( 'Lab 3', 'Rua 3', '3333333333'); 
INSERT INTO tb_clinica (nome, endereco, cnpj) VALUES ( 'Lab 4', 'Rua 4', '4444444444'); 
INSERT INTO tb_clinica (nome, endereco, cnpj) VALUES ( 'Lab 5', 'Rua 5', '5555555555'); 

--  Medico
INSERT INTO tb_medico (nome, cpf, sexo,  data_nascimento,  senha) VALUES ( 'Dr 1', '1111111111', 'M', 01012000, '111');
INSERT INTO tb_medico (nome, cpf, sexo,  data_nascimento,  senha) VALUES ( 'Dr 2', '22222222222', 'F', 01012000, '222');
INSERT INTO tb_medico (nome, cpf, sexo,  data_nascimento,  senha) VALUES ( 'Dr 3', '33333333333', 'M', 01012000, '333');
INSERT INTO tb_medico (nome, cpf, sexo,  data_nascimento,  senha) VALUES ( 'Dr 4', '44444444444', 'F', 01012000, '444');
INSERT INTO tb_medico (nome, cpf, sexo,  data_nascimento,  senha) VALUES ( 'Dr 5', '55555555555', 'M', 01012000, '555'); 



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