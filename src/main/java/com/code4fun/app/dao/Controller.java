package com.code4fun.app.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface Controller<T> {

	ResponseEntity<?> create(@RequestBody T t);

	ResponseEntity<?> retrieveById(@PathVariable Long id);

	ResponseEntity<?> retrieveAll();

	ResponseEntity<?> update(@PathVariable Long id, @RequestBody T t);

	ResponseEntity<?> delete(@PathVariable Long id);

}
