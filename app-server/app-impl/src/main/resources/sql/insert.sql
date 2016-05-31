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

insert into tb_usuario_seg(co_usuario, ind_ativo, ind_auto_registro, ds_login, ds_senha)
	values(nextval('sentinela_usuario_seq'),
		true,
		false,
		'${email}',
		'${senha}');

insert into tb_usuario_grupo_seg(co_usuario_grupo, co_grupo, co_usuario)
	values(nextval('sentinela_usuario_grupo_seq'),
	(select co_grupo from tb_grupo_seg where ds_identificador_unico = 'ADMINISTRADORES'),
	(select co_usuario from tb_usuario_seg where ds_login = '${email}'));