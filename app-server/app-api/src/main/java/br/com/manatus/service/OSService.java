package br.com.manatus.service;

import java.util.List;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

public interface OSService {
	public List<OSDto> listOS() throws AkulaRuntimeException;
	public PessoaDto getUsuarioLogado() throws AkulaRuntimeException;
	public OSDto loadOS(Long id) throws AkulaRuntimeException;
	public OSDto manterOS(OSDto dto) throws AkulaRuntimeException;
	public void manterIntervencao(IntervencaoDto dto) throws AkulaRuntimeException;
	public List<PessoaDto> listClientes() throws AkulaRuntimeException;
	public List<PessoaDto> listFuncionarios() throws AkulaRuntimeException;
	public List<TipoOSDto> listTipoOs() throws AkulaRuntimeException;
	public List<CategoriaDemandaDto> listCategoriaDemanda() throws AkulaRuntimeException;
	public List<DemandaDto> listDemanda() throws AkulaRuntimeException;
}