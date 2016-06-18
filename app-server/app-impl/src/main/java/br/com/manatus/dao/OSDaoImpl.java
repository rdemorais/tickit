package br.com.manatus.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.manatus.exc.AkulaDaoRuntimeException;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

public class OSDaoImpl extends DaoImpl implements OSDao{
	
	public PessoaDto loadPessoa(String email) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT new br.com.manatus.service.dto.PessoaDto(");
			hql.append("f.id, ");
			hql.append("f.nome, ");
			hql.append("user.login) ");
			hql.append("FROM Funcionario f ");
			hql.append("JOIN f.usuario user ");
			hql.append("WHERE user.login = :email ");
			
			Query q = em.createQuery(hql.toString());
			q.setParameter("email", email);
			
			return (PessoaDto) q.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new AkulaRuntimeException(e.getMessage(), e);
		}
	}
	
	public OSDto loadOS(Long osId) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("SELECT new br.com.manatus.service.dto.OSDto(");
			hql.append("os.id, ");
			hql.append("os.dataHoraChamado, ");
			hql.append("c.id, ");
			hql.append("c.nome, ");
			hql.append("os.dataLimiteAtendimento, ");
			hql.append("tec.nome, ");
			hql.append("os.descricaoDemanda, ");
			hql.append("os.sugestaoSolucao, ");
			hql.append("cd.categoriaDemanda.id, ");
			hql.append("cd.categoriaDemanda.categoriaDemanda, ");
			hql.append("tOs.tipoOs.tipoOs) ");
			
			hql.append("FROM OS os ");
			hql.append("JOIN os.cliente c ");
			hql.append("JOIN os.tecResponsavel tec ");
			hql.append("JOIN os.categoriaDemanda cd ");
			hql.append("JOIN os.tipoOs tOs ");
			hql.append("WHERE os.id = :osId ");
			
			Query q = em.createQuery(hql.toString());
			
			q.setParameter("osId", osId);
			
			return (OSDto) q.getSingleResult();
		} catch (NonUniqueResultException e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		} catch (NoResultException e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	public Long countOs() throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT COUNT(os.id) FROM OS os");
			
			Query q = em.createQuery(hql.toString());
			
			return (Long) q.getSingleResult();
		} catch (NonUniqueResultException e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		} catch (NoResultException e) {
			return 0L;
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OSDto> listOS(int firstResult, int maxResults) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("SELECT new br.com.manatus.service.dto.OSDto(");
			hql.append("os.id, ");
			hql.append("os.dataHoraChamado, ");
			hql.append("c.nome, ");
			hql.append("os.dataLimiteAtendimento, ");
			hql.append("tec.nome) ");
			hql.append("FROM OS os ");
			hql.append("JOIN os.cliente c ");
			hql.append("JOIN os.tecResponsavel tec ");
			
			Query q = em.createQuery(hql.toString());
			
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResults);
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IntervencaoDto> listIntervencao(OSDto os) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT new br.com.manatus.service.dto.IntervencaoDto(");
			hql.append("inter.id, ");
			hql.append("inter.dataHoraIntervencao, ");
			hql.append("inter.dataHoraFimIntervencao, ");
			hql.append("dem.demanda, ");
			hql.append("inter.observacao) ");
			hql.append("FROM Intervencao inter ");
			hql.append("JOIN inter.demanda dem ");
			hql.append("WHERE inter.os.id = :osId ");
			hql.append("ORDER BY inter.dataHoraIntervencao ASC ");
			
			Query q = em.createQuery(hql.toString());
			
			q.setParameter("osId", os.getId());
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaDto> listClientes() throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.PessoaDto(");
		hql.append("c.id, ");
		hql.append("c.nome, ");
		hql.append("user.login, ");
		hql.append("c.tipoCliente) ");
		hql.append("FROM Cliente c ");
		hql.append("JOIN c.usuario user ");
		
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
	public List<DemandaDto> listDemanda(Long idCatDemanda) throws AkulaRuntimeException {
		StringBuffer hql = new StringBuffer();
		
		hql.append("SELECT new br.com.manatus.service.dto.DemandaDto(");
		hql.append("d.id, ");
		hql.append("d.demanda) ");
		hql.append("FROM Demanda d ");
		hql.append("WHERE d.categoriaDemanda.id = :idCatDemanda ");
		
		Query q = em.createQuery(hql.toString());
		q.setParameter("idCatDemanda", idCatDemanda);
		return q.getResultList();
	}
}