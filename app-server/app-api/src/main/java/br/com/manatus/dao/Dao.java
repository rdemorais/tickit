package br.com.manatus.dao;

import java.io.Serializable;

import br.com.manatus.exc.AkulaRuntimeException;

public interface Dao {
	public void create(Object o) throws AkulaRuntimeException;
	public Object merge(Object o) throws AkulaRuntimeException;
	public void remove(Object o) throws AkulaRuntimeException;
	public <T> T find(Class<T> c, Serializable pk) throws AkulaRuntimeException;
}