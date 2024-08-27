package com.code4fun.app.dao;

import java.util.Set;

public interface Service<T, U> {

	U create(T t);

	U retrieveById(Long id);

	Set<U> retrieveAll();

	U update(Long id, T t);

	String delete(Long id);

}
