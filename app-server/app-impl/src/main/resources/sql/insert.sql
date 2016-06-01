insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Atendimento Avulso');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Atendimento Mensalista');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Bancada');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Coleta/Entrega');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Compras');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Cortesia');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Demanda Interna Manatus');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Desenvolvimento');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Manutenção Predial');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Manutenção de Estação');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Manutenção de Estação com Translado');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Montagem e Instalação de Estação');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Projetos Especiais');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Proposta Comercial');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Retorno');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Vendas');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Visita Comercial');
insert into tb_tipo_os(co_tipo_os, ds_tipo_os) values(nextval('tickit_tipo_os_seq'), 'Visita Técnica');

insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Gerente');
insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Entregador');
insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Técnico');
insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Prestador de Serviço');
insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Secretaria');
insert into tb_cargo(co_cargo, no_cargo) values(nextval('tickit_cargo_seq'), 'Engenheiro');

insert into tb_pagina_seg(
	co_pagina, ds_nome, ds_identificador_unico, ds_url, ds_descricao, ds_icone, link_barra, ind_ativo, ind_pode_ser_pagina_padrao, co_pagina_pai, ordem)	
	values (
		nextval('sentinela_pagina_seq'),
		'OS Dash',
		'OS_DASH',
		'#',
		null,
		'',
		false,
		true,
		true,
		null,
		0
	);
	
insert into tb_grupo_seg(co_grupo, ds_nome, ds_identificador_unico, ind_administracao)
	values(nextval('sentinela_grupo_seq'), 'Administradores', 'ADMINISTRADORES', true);
insert into tb_grupo_seg(co_grupo, ds_nome, ds_identificador_unico, ind_administracao)
	values(nextval('sentinela_grupo_seq'), 'Clientes', 'CLIENTES', true);
	
insert into tb_permissao_seg(co_permissao, ds_nome, ds_nome_amigavel, ds_descricao, ds_escopo, co_pagina)
	values(
		nextval('sentinela_permissao_seq'), 
		'ROLE_LEITURA_DASHBOARD_OS', 
		'Pode visualizar o dashboard de OSs',
		'',
		'PAGINA',
		(select co_pagina from tb_pagina_seg where ds_identificador_unico = 'OS_DASH'));

insert into tb_permissao_grupo_usuario_seg(co_per_grupo_usuario, co_grupo, co_permissao)
	values(nextval('sentinela_per_grupo_usuario_seq'), 
		(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'ADMINISTRADORES'),
		(select co_permissao from tb_permissao_seg where ds_nome = 'ROLE_LEITURA_DASHBOARD_OS')
	);

--Pessoas 

-- Adminstrador
insert into tb_usuario_seg(co_usuario, ind_ativo, ind_auto_registro, ds_login, ds_senha)
	values(nextval('sentinela_usuario_seq'),
		true,
		false,
		'${adm.email}',
		'${adm.senha}');

insert into tb_usuario_grupo_seg(co_usuario_grupo, co_grupo, co_usuario)
	values(nextval('sentinela_usuario_grupo_seq'),
	(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'ADMINISTRADORES'),
	(select co_usuario from tb_usuario_seg where ds_login = '${adm.email}'));
	
insert into tb_pessoa(co_pessoa, ind_auto_registro, ds_nome, ds_avatar, co_usuario)
	values(
		nextval('tickit_pessoa_seq'),
		false,
		'${adm.nome}',
		'${avatar.masc}',
		(select co_usuario from tb_usuario_seg where ds_login = '${adm.email}')
	);
	
insert into tb_funcionario(co_pessoa, co_cargo) 
	values(
		(select co_pessoa from tb_pessoa where ds_nome = '${adm.nome}'),
		(select co_cargo from tb_cargo where no_cargo = 'Gerente')
	);
	
--Funcionario 1
	
insert into tb_usuario_seg(co_usuario, ind_ativo, ind_auto_registro, ds_login, ds_senha)
	values(nextval('sentinela_usuario_seq'),
		true,
		false,
		'${fun1.email}',
		'${adm.senha}');

insert into tb_usuario_grupo_seg(co_usuario_grupo, co_grupo, co_usuario)
	values(nextval('sentinela_usuario_grupo_seq'),
	(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'ADMINISTRADORES'),
	(select co_usuario from tb_usuario_seg where ds_login = '${fun1.email}'));
	
insert into tb_pessoa(co_pessoa, ind_auto_registro, ds_nome, ds_avatar, co_usuario)
	values(
		nextval('tickit_pessoa_seq'),
		false,
		'${fun1.nome}',
		'${avatar.masc}',
		(select co_usuario from tb_usuario_seg where ds_login = '${fun1.email}')
	);
	
insert into tb_funcionario(co_pessoa, co_cargo) 
	values(
		(select co_pessoa from tb_pessoa where ds_nome = '${fun1.nome}'),
		(select co_cargo from tb_cargo where no_cargo = 'Engenheiro')
	);
	
--Funcionario 2
	
insert into tb_usuario_seg(co_usuario, ind_ativo, ind_auto_registro, ds_login, ds_senha)
	values(nextval('sentinela_usuario_seq'),
		true,
		false,
		'${fun2.email}',
		'${adm.senha}');

insert into tb_usuario_grupo_seg(co_usuario_grupo, co_grupo, co_usuario)
	values(nextval('sentinela_usuario_grupo_seq'),
	(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'ADMINISTRADORES'),
	(select co_usuario from tb_usuario_seg where ds_login = '${fun2.email}'));
	
insert into tb_pessoa(co_pessoa, ind_auto_registro, ds_nome, ds_avatar, co_usuario)
	values(
		nextval('tickit_pessoa_seq'),
		false,
		'${fun2.nome}',
		'${avatar.masc}',
		(select co_usuario from tb_usuario_seg where ds_login = '${fun2.email}')
	);
	
insert into tb_funcionario(co_pessoa, co_cargo) 
	values(
		(select co_pessoa from tb_pessoa where ds_nome = '${fun2.nome}'),
		(select co_cargo from tb_cargo where no_cargo = 'Engenheiro')
	);

--Cliente 1
	
insert into tb_usuario_seg(co_usuario, ind_ativo, ind_auto_registro, ds_login, ds_senha)
	values(nextval('sentinela_usuario_seq'),
		true,
		false,
		'${cli1.email}',
		'${adm.senha}');

insert into tb_usuario_grupo_seg(co_usuario_grupo, co_grupo, co_usuario)
	values(nextval('sentinela_usuario_grupo_seq'),
	(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'CLIENTES'),
	(select co_usuario from tb_usuario_seg where ds_login = '${cli1.email}'));
	
insert into tb_pessoa(co_pessoa, ind_auto_registro, ds_nome, ds_avatar, co_usuario)
	values(
		nextval('tickit_pessoa_seq'),
		false,
		'${cli1.nome}',
		'${avatar.masc}',
		(select co_usuario from tb_usuario_seg where ds_login = '${cli1.email}')
	);
	
insert into tb_cliente(co_pessoa, ds_tipo_cliente) 
	values(
		(select co_pessoa from tb_pessoa where ds_nome = '${cli1.nome}'),
		'PESSOA_JURIDICA'
	);