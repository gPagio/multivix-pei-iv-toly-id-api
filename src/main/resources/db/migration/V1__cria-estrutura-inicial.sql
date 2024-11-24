CREATE TABLE amostras (
	id bigserial,
	ectoparasitos boolean NULL,
	fezes boolean NULL,
	"local" boolean NULL,
	outros varchar(255) NULL,
	pelo boolean NULL,
	sangue boolean NULL,
	swab boolean NULL,
	CONSTRAINT pk_amostras PRIMARY KEY (id)
);

CREATE TABLE biometrias (
	id bigserial,
	comprimento_da_cabeca float8 NULL,
	comprimento_da_cauda float8 NULL,
	comprimento_da_orelha float8 NULL,
	comprimento_do_clitoris float8 NULL,
	comprimento_do_penis float8 NULL,
	comprimento_escudo_cefalico float8 NULL,
	comprimento_escudo_escapular float8 NULL,
	comprimento_escudo_pelvico float8 NULL,
	comprimento_mao_sem_unha float8 NULL,
	comprimento_pe_sem_unha float8 NULL,
	comprimento_total float8 NULL,
	comprimento_unha_da_mao float8 NULL,
	comprimento_unha_do_pe float8 NULL,
	largura_base_penis float8 NULL,
	largura_da_cabeca float8 NULL,
	largura_da_cauda float8 NULL,
	largura_escudo_cefalico float8 NULL,
	largura_inter_lacrimal float8 NULL,
	largura_inter_orbital float8 NULL,
	largura_na_segunda_cinta float8 NULL,
	numero_de_cintas int4 NULL,
	padrao_escudo_cefalico varchar(255) NULL,
	semicircunferencia_escudo_escapular float8 NULL,
	semicircunferencia_escudo_pelvico float8 NULL,
	CONSTRAINT pk_biometrias PRIMARY KEY (id)
);

CREATE TABLE dados_gerais (
	id bigserial,
	contato_do_responsavel varchar(255) NULL,
	data_captura timestamp(6) NULL,
	equipe_responsavel varchar(255) NULL,
	instituicao varchar(255) NULL,
	local_de_captura varchar(255) NULL,
	observacoes varchar(255) NULL,
	peso_do_tatu float8 NULL,
	CONSTRAINT pk_dados_gerais PRIMARY KEY (id)
);

CREATE TABLE fichas_anestesicas (
	id bigserial,
	aplicacao time(6) NULL,
	inducao time(6) NULL,
	retorno time(6) NULL,
	tipo_anestesico_ou_dose varchar(255) NULL,
	via_de_administracao varchar(255) NULL,
	CONSTRAINT pk_fichas_anestesicas PRIMARY KEY (id)
);

CREATE TABLE tatus (
	id bigserial,
	identificacao_animal varchar(255) NULL,
	numero_microchip int4 NULL,
	sexo char(1),
	CONSTRAINT pk_tatus PRIMARY KEY (id)
);

CREATE TABLE usuarios (
	id bigserial,
	ativo boolean NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	senha varchar(255) NULL,
	telefone varchar(255) NULL,
	CONSTRAINT pk_usuarios PRIMARY KEY (id)
);

CREATE TABLE capturas (
	id bigserial,
	amostra_id bigint NULL,
	biometria_id bigint NULL,
	dados_gerais_id bigint NULL,
	ficha_anestesica_id bigint NULL,
	tatu_id bigint NULL,
	usuario_id bigint NULL,
	CONSTRAINT pk_capturas PRIMARY KEY (id),
	CONSTRAINT uk_biometria_id UNIQUE (biometria_id),
	CONSTRAINT uk_dados_gerais_id UNIQUE (dados_gerais_id),
	CONSTRAINT uk_ficha_anestesica_id UNIQUE (ficha_anestesica_id),
	CONSTRAINT uk_amostra_id UNIQUE (amostra_id),
	CONSTRAINT fk_capturas_usuarios FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
	CONSTRAINT fk_capturas_dados_gerais FOREIGN KEY (dados_gerais_id) REFERENCES dados_gerais(id),
	CONSTRAINT fk_capturas_ficha_anestesica_id FOREIGN KEY (ficha_anestesica_id) REFERENCES fichas_anestesicas(id),
	CONSTRAINT fk_capturas_biometria_id FOREIGN KEY (biometria_id) REFERENCES biometrias(id),
	CONSTRAINT fk_capturas_amostra_id FOREIGN KEY (amostra_id) REFERENCES amostras(id),
	CONSTRAINT fk_capturas_tatu_id FOREIGN KEY (tatu_id) REFERENCES tatus(id)
);

CREATE TABLE parametros_fisiologicos (
	id bigserial,
	frequencia_cardiaca float8 NULL,
	frequencia_respiratoria float8 NULL,
	oximetria float8 NULL,
	temperatura float8 NULL,
	ficha_anestesica_id bigint NULL,
	CONSTRAINT pk_parametros_fisiologicos PRIMARY KEY (id),
	CONSTRAINT fk_parametros_fisiologicos_fichas_anestesicas FOREIGN KEY (ficha_anestesica_id) REFERENCES fichas_anestesicas(id)
);

INSERT INTO usuarios (id, ativo, email             , nome     , senha                                                         )
	 		  VALUES (1 , true , 'usuario@toly.com', 'Usuario', '$2a$12$7.ZKqbEjFT3vGRc/47xd5.etGVMMbtGp4KLSy6Uo1Qb6KJmCHoJIa');