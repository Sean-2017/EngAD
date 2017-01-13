package com.engad.ade.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.engad.ade.dao.IBaseMybatisDao;

@Repository
public class BaseMyBatisDao<T, PK extends Serializable> implements IBaseMybatisDao<T, PK> {
	@Resource(name = "readSqlSession")
	private SqlSessionTemplate readSqlSession;
	@Resource(name = "writeSqlSession")
	private SqlSessionTemplate writeSqlSession;

	public SqlSessionTemplate getReadSqlSession() {
		return readSqlSession;
	}

	public void setReadSqlSession(SqlSessionTemplate readSqlSession) {
		this.readSqlSession = readSqlSession;
	}

	public SqlSessionTemplate getWriteSqlSession() {
		return writeSqlSession;
	}

	public void setWriteSqlSession(SqlSessionTemplate writeSqlSession) {
		this.writeSqlSession = writeSqlSession;
	}

	@Override
	public int count(String statementName) {
		return readSqlSession.selectOne(statementName);
	}

	@Override
	public int count(String statementName, Object param) {
		return (Integer) get(statementName, param);
	}

	@Override
	public int delete(String statementName) {
		return writeSqlSession.delete(statementName);
	}

	@Override
	public int delete(String statementName, Object param) {
		return writeSqlSession.delete(statementName, param);
	}

	@Override
	public T get(String statementName) {
		return readSqlSession.selectOne(statementName);
	}

	@Override
	public T get(String statementName, Object param) {
		return readSqlSession.selectOne(statementName, param);
	}

	@Override
	public int insert(String statementName) {
		return writeSqlSession.insert(statementName);
	}

	@Override
	public int insert(String statementName, Object param) {
		return writeSqlSession.insert(statementName, param);
	}

	@Override
	public List<T> query(String statementName) {
		return readSqlSession.selectList(statementName);
	}

	@Override
	public List<T> query(String statementName, Object param) {
		return readSqlSession.selectList(statementName, param);
	}

	@Override
	public int update(String statementName) {
		return writeSqlSession.update(statementName);
	}

	@Override
	public int update(String statementName, Object param) {
		return writeSqlSession.update(statementName, param);
	}
}