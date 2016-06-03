

    create table tb_cargo (
        co_cargo int8 not null,
        no_cargo varchar(255),
        primary key (co_cargo)
    );
    create table tb_categoria_demanda (
        co_categoria_demanda int8 not null,
        no_categoria varchar(255),
        primary key (co_categoria_demanda)
    );
    create table tb_cliente (
        ds_inscricao_estadual varchar(255),
        ds_razao_social varchar(255),
        ds_tipo_cliente varchar(255),
        co_pessoa int8 not null,
        primary key (co_pessoa)
    );
    create table tb_demanda (
        co_demanda int8 not null,
        ds_demanda varchar(255),
        co_categoria_demanda int8,
        primary key (co_demanda)
    );
    create table tb_funcionario (
        ds_area_atuacao varchar(255),
        ds_habilidade varchar(255),
        ds_salario float8,
        co_pessoa int8 not null,
        co_cargo int8,
        co_veiculo int8,
        primary key (co_pessoa)
    );
    create table tb_grupo_seg (
        co_grupo int8 not null,
        ind_administracao boolean,
        ds_identificador_unico varchar(255),
        ds_nome varchar(255),
        primary key (co_grupo)
    );
    create table tb_intervencao (
        co_intervencao int8 not null,
        dt_fim_intervencao timestamp,
        dt_intervencao timestamp,
        ds_obs TEXT,
        co_cliente_destino int8,
        co_cliente_origem int8,
        co_demanda int8,
        co_os int8,
        co_tecnico_responsavel int8,
        primary key (co_intervencao)
    );
    create table tb_os (
        co_os int8 not null,
        dt_delete timestamp,
        dt_insert timestamp,
        dt_update timestamp,
        dt_agendamento timestamp,
        dt_conclusao timestamp,
        dt_chamado timestamp,
        dt_limite_atendimento timestamp,
        ds_demanda TEXT,
        ds_status_os varchar(255),
        ds_solucao TEXT,
        co_usuario_delete int8,
        co_usuario_insert int8,
        co_usuario_update int8,
        co_categoria_demanda int8,
        co_cliente int8,
        co_tecnico_agendamento int8,
        co_tecnico_responsavel int8,
        co_tipo_os int8,
        primary key (co_os)
    );
    create table tb_pagina_seg (
        co_pagina int8 not null,
        ind_ativo boolean,
        ds_descricao varchar(255),
        ds_icone varchar(255),
        ds_identificador_unico varchar(255),
        link_barra boolean,
        ds_nome varchar(255),
        ordem int4,
        ind_pode_ser_pagina_padrao boolean,
        ds_url varchar(255),
        co_pagina_pai int8,
        primary key (co_pagina)
    );
    create table tb_permissao_grupo_usuario_seg (
        co_per_grupo_usuario int8 not null,
        co_grupo int8,
        co_permissao int8,
        co_usuario int8,
        primary key (co_per_grupo_usuario)
    );
    create table tb_permissao_seg (
        co_permissao int8 not null,
        ds_descricao varchar(255),
        ds_escopo varchar(255),
        ds_nome varchar(255),
        ds_nome_amigavel varchar(255),
        co_pagina int8,
        primary key (co_permissao)
    );
    create table tb_pessoa (
        co_pessoa int8 not null,
        ind_auto_registro boolean,
        ds_avatar TEXT,
        ds_comentario varchar(255),
        ds_cpf_cnpj varchar(255),
        dt_nascimento timestamp,
        ds_facebook varchar(255),
        ds_genero varchar(255),
        ds_nome varchar(255),
        ds_twitter varchar(255),
        ds_website varchar(255),
        co_usuario int8,
        primary key (co_pessoa)
    );
    create table tb_tipo_os (
        co_tipo_os int8 not null,
        ds_tipo_os varchar(255),
        primary key (co_tipo_os)
    );
    create table tb_usuario_grupo_seg (
        co_usuario_grupo int8 not null,
        co_grupo int8 not null,
        co_usuario int8 not null,
        primary key (co_usuario_grupo)
    );
    create table tb_usuario_seg (
        co_usuario int8 not null,
        ind_ativo boolean,
        ind_auto_registro boolean,
        ds_login varchar(255) not null,
        ds_senha varchar(255),
        ind_senha_alterada boolean,
        ds_tenant_id varchar(255),
        co_pagina int8,
        primary key (co_usuario)
    );
    create table tb_veiculo (
        co_veiculo int8 not null,
        ds_consumo varchar(255),
        no_marca varchar(255),
        ds_modelo varchar(255),
        primary key (co_veiculo)
    );
    alter table tb_intervencao 
        add constraint UK_rl89035mbtvgbilv9d2v09kxt  unique (co_os);
    alter table tb_permissao_seg 
        add constraint UK_2dbav7bxbxlfmmiml9nftg3l6  unique (ds_nome);
    alter table tb_usuario_seg 
        add constraint UK_8ljssx5akrjpqu6cfe00kw71u  unique (ds_login);
    alter table tb_cliente 
        add constraint FK_efh3jnvvfq7fik9rtbgsiuwld 
        foreign key (co_pessoa) 
        references tb_pessoa;
    alter table tb_demanda 
        add constraint FK_gmsntlh2c3c3w7c3apmh7a8hq 
        foreign key (co_categoria_demanda) 
        references tb_categoria_demanda;
    alter table tb_funcionario 
        add constraint FK_nmwflnpnhlul51h0icjtn9ttr 
        foreign key (co_cargo) 
        references tb_cargo;
    alter table tb_funcionario 
        add constraint FK_15kowmk0ygmd47tlir4umhclg 
        foreign key (co_veiculo) 
        references tb_veiculo;
    alter table tb_funcionario 
        add constraint FK_rmaij0ms9v7wfkbusivr1wj3r 
        foreign key (co_pessoa) 
        references tb_pessoa;
    alter table tb_intervencao 
        add constraint FK_lttyimyoxhu6ix998d5766ex6 
        foreign key (co_cliente_destino) 
        references tb_cliente;
    alter table tb_intervencao 
        add constraint FK_jwmd7gbres5j0ku4ukc4gtc7g 
        foreign key (co_cliente_origem) 
        references tb_cliente;
    alter table tb_intervencao 
        add constraint FK_munlrhup2dn2yig2wh1jq10n3 
        foreign key (co_demanda) 
        references tb_demanda;
    alter table tb_intervencao 
        add constraint FK_rl89035mbtvgbilv9d2v09kxt 
        foreign key (co_os) 
        references tb_os;
    alter table tb_intervencao 
        add constraint FK_b28kx9few7gcr0tranxfiwg88 
        foreign key (co_tecnico_responsavel) 
        references tb_funcionario;
    alter table tb_os 
        add constraint FK_44cp1gkfkgpu9di189kda8xdu 
        foreign key (co_usuario_delete) 
        references tb_usuario_seg;
    alter table tb_os 
        add constraint FK_i1p1dbt7ela3sj1lai8cnswgq 
        foreign key (co_usuario_insert) 
        references tb_usuario_seg;
    alter table tb_os 
        add constraint FK_pju9j1t73qxab28ws8o224h2 
        foreign key (co_usuario_update) 
        references tb_usuario_seg;
    alter table tb_os 
        add constraint FK_2nf84catspocxnrm9p8opeacs 
        foreign key (co_categoria_demanda) 
        references tb_categoria_demanda;
    alter table tb_os 
        add constraint FK_66iipdcqspewaertc80hd6qcd 
        foreign key (co_cliente) 
        references tb_cliente;
    alter table tb_os 
        add constraint FK_prnx5ron77yva7o2vs6rnfjou 
        foreign key (co_tecnico_agendamento) 
        references tb_funcionario;
    alter table tb_os 
        add constraint FK_aed73rl4u31l0kqxfitcxvskm 
        foreign key (co_tecnico_responsavel) 
        references tb_funcionario;
    alter table tb_os 
        add constraint FK_kknevm79ltkjsqw1pbsa6h8ok 
        foreign key (co_tipo_os) 
        references tb_tipo_os;
    alter table tb_pagina_seg 
        add constraint FK_rwuxt1q5al0cn7o3yvhkk9xpv 
        foreign key (co_pagina_pai) 
        references tb_pagina_seg;
    alter table tb_permissao_grupo_usuario_seg 
        add constraint FK_e81m6gxwge19907wabe2cx68s 
        foreign key (co_grupo) 
        references tb_grupo_seg;
    alter table tb_permissao_grupo_usuario_seg 
        add constraint FK_hw51lbj7gjic6o903edv7tkfe 
        foreign key (co_permissao) 
        references tb_permissao_seg;
    alter table tb_permissao_grupo_usuario_seg 
        add constraint FK_a453hfhp3y6fs7i29hv91ng9y 
        foreign key (co_usuario) 
        references tb_usuario_seg;
    alter table tb_permissao_seg 
        add constraint FK_d8v751b841dplislxkpnq8r5a 
        foreign key (co_pagina) 
        references tb_pagina_seg;
    alter table tb_pessoa 
        add constraint FK_3cl8l52k8fl9xfjt9ybhxl3pm 
        foreign key (co_usuario) 
        references tb_usuario_seg;
    alter table tb_usuario_grupo_seg 
        add constraint FK_cx1xuldof5hl31nwt0nhoyynt 
        foreign key (co_grupo) 
        references tb_grupo_seg;
    alter table tb_usuario_grupo_seg 
        add constraint FK_q9p003tw40ywqussv25i4mnmw 
        foreign key (co_usuario) 
        references tb_usuario_seg;
    alter table tb_usuario_seg 
        add constraint FK_le97dvcr91xprrdq0yyghchdw 
        foreign key (co_pagina) 
        references tb_pagina_seg;
    create sequence sentinela_grupo_seq;
    create sequence sentinela_pagina_seq;
    create sequence sentinela_per_grupo_usuario_seq;
    create sequence sentinela_permissao_seq;
    create sequence sentinela_usuario_grupo_seq;
    create sequence sentinela_usuario_seq;
    create sequence tickit_cargo_seq;
    create sequence tickit_categoria_demanda_seq;
    create sequence tickit_demanda_seq;
    create sequence tickit_intervencao_seq;
    create sequence tickit_os_seq;
    create sequence tickit_pessoa_seq;
    create sequence tickit_tipo_os_seq;
    create sequence tickit_veiculo_seq;