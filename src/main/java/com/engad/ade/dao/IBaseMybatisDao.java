package com.engad.ade.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseMybatisDao<T, PK extends Serializable> {
	/**
	 * 查询整表总记录数.
	 * 
	 * @param statementName
	 *            声明
	 * @return 记录数
	 */
	public int count(String statementName);

	/**
	 * 查询符合条件的记录数
	 * 
	 * @param statementName
	 *            声明
	 * @param param
	 *            条件参数
	 * @return 记录数
	 */
	public int count(String statementName, Object param);

	/**
	 * 删除记录.
	 * 
	 * @param statementName
	 *            声明
	 * @return 删除的对象个数
	 */
	public int delete(String statementName);

	/**
	 * 删除符合条件的记录
	 * 
	 * @param statementName
	 *            声明
	 * @param param
	 *            条件参数
	 * @return 受影响的记录数
	 */
	public int delete(String statementName, Object param);

	/**
	 * 获取一条记录
	 * 
	 * @param statementName
	 *            声明
	 * @return 对象
	 */
	public T get(String statementName);

	/**
	 * 获取符合条件的一条记录
	 * 
	 * @param statementName
	 *            声明
	 * @param param
	 *            条件参数
	 * @return 对象
	 */
	public T get(String statementName, Object param);

	/**
	 * 新增记录
	 * 
	 * @param statementName
	 *            声明
	 * @return 受影响的记录数
	 */
	public int insert(String statementName);

	/**
	 * 新增记录
	 * 
	 * @param statementName
	 *            声明
	 * @param list
	 *            对象集合
	 * @return 受影响的记录数
	 */
	public int insert(String statementName, Object param);

	/**
	 * 查询记录
	 * 
	 * @param statementName
	 *            声明
	 * @return 实体对象集合
	 */
	public List<T> query(String statementName);

	/**
	 * 查询符合条件的记录
	 * 
	 * @param statementName
	 *            声明
	 * @param param
	 *            条件参数
	 * @return 实体对象集合
	 */
	public List<T> query(String statementName, Object param);

	/**
	 * 修改记录
	 * 
	 * @param statementName
	 *            声明
	 * @return 受影响的记录数
	 */
	public int update(String statementName);

	/**
	 * 修改符合条件的记录
	 * 
	 * @param statementName
	 *            声明
	 * @param param
	 *            条件参数
	 * @return 受影响的记录数
	 */
	public int update(String statementName, Object param);
}