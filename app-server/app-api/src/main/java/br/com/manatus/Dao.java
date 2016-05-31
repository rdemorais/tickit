package br.com.manatus;

import java.io.Serializable;

public interface Dao {
	public void create(Object o) throws AkulaRuntimeException;
	public Object merge(Object o) throws AkulaRuntimeException;
	public void remove(Object o) throws AkulaRuntimeException;
	public <T> T find(Class<T> c, Serializable pk) throws AkulaRuntimeException;
}