
    create table tb_grupo_seg (
        co_grupo int8 not null,
        ind_administracao boolean,
        ds_identificador_unico varchar(255),
        ds_nome varchar(255),
        primary key (co_grupo)
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
    alter table tb_permissao_seg 
        add constraint UK_2dbav7bxbxlfmmiml9nftg3l6  unique (ds_nome);
    alter table tb_usuario_seg 
        add constraint UK_8ljssx5akrjpqu6cfe00kw71u  unique (ds_login);
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