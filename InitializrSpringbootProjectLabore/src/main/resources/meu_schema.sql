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