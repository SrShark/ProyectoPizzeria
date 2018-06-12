package com.plan111.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T,ID extends Serializable> {
    T create() throws BussinessException;
    void saveOrUpdate(T entity) throws BussinessException;
    T get(ID id) throws BussinessException;
    void delete(ID id) throws BussinessException;
    List<T> findAll() throws BussinessException;
}
