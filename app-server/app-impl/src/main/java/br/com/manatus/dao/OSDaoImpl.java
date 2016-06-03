package br.com.manatus.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

public class OSDaoImpl extends DaoImpl implements OSDao{
	
	@SuppressWarnings("unchecked")
	public List<PessoaDto> listClientes() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.PessoaDto(");
		hql.append("c.id, ");
		hql.append("c.nome) ");
		hql.append("FROM Cliente c ");
		
		Query q = em.createQuery(hql.toString());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaDto> listFuncionarios() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.PessoaDto(");
		hql.append("f.id, ");
		hql.append("f.nome) ");
		hql.append("FROM Funcionario f ");
		
		Query q = em.createQuery(hql.toString());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoOSDto> listTipoOs() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.TipoOSDto(");
		hql.append("tOs.id, ");
		hql.append("tOs.tipoOs) ");
		hql.append("FROM TipoOS tOs ");
		
		Query q = em.createQuery(hql.toString());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoriaDemandaDto> listCategoriaDemanda() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.CategoriaDemandaDto(");
		hql.append("cd.id, ");
		hql.append("cd.categoriaDemanda) ");
		hql.append("FROM CategoriaDemanda cd ");
		
		Query q = em.createQuery(hql.toString());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DemandaDto> listDemanda() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.DemandaDto(");
		hql.append("d.id, ");
		hql.append("d.demanda) ");
		hql.append("FROM Demanda d ");
		
		Query q = em.createQuery(hql.toString());
		return q.getResultList();
	}
}