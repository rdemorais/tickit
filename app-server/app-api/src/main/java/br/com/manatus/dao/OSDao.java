package br.com.manatus.dao;

import java.util.List;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.FiltroDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

public interface OSDao extends Dao{
	public PessoaDto loadPessoa(String email) throws AkulaRuntimeException;
	public OSDto loadOS(Long osId) throws AkulaRuntimeException;
	public List<OSDto> listOS(FiltroDto filtro, int firstResult, int maxResults) throws AkulaRuntimeException;
	public Long countOs() throws AkulaRuntimeException;
	public List<IntervencaoDto> listIntervencao(OSDto os) throws AkulaRuntimeException;
	public List<PessoaDto> listClientes() throws AkulaRuntimeException;
	public List<PessoaDto> listFuncionarios() throws AkulaRuntimeException;
	public List<TipoOSDto> listTipoOs() throws AkulaRuntimeException;
	public List<CategoriaDemandaDto> listCategoriaDemanda() throws AkulaRuntimeException;
	public List<DemandaDto> listDemanda(Long idCatDemanda) throws AkulaRuntimeException;
}