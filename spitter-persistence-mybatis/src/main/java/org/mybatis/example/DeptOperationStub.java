/**
 * 
 */
package org.mybatis.example;

import org.apache.ibatis.session.SqlSession;

import domain.blog.Dept;

/**
 * Dept实体操作类
 * 
 * @author LiuJian
 *
 */
public class DeptOperationStub {
	// 数据库操作会话
	// private SqlSession session;
	private DeptMapper deptMapper;

	public Dept createDemoDept() {
		Dept dept = new Dept();
		dept.setDeptno((short) 9);
		dept.setDname("建设部");
		dept.setLoc("行政楼一楼");
		return dept;
	}

	/**
	 * Dept实体操作类构造函数
	 * 
	 * @param session
	 *            数据库操作会话
	 */
	public DeptOperationStub(SqlSession session) {
		// this.session = session;
		deptMapper = session.getMapper(DeptMapper.class);
	}

	/**
	 * 删除Dept实体操作
	 * 
	 * @param dept
	 *            传入的待删除的实体
	 * @return 删除记录数量
	 */
	public int insertDept(Dept dept) {
		return deptMapper.insert(dept);
		// return session.insert("org.mybatis.example.DeptMapper.insert", dept);
	}

	/**
	 * 删除Dept实体操作
	 * 
	 * @param dept
	 *            传入的待删除的实体
	 * @return 删除记录数量
	 */
	public int updateDept(Dept dept) {
		return deptMapper.updateByNo(dept);
		// return session.update("org.mybatis.example.DeptMapper.updateByNo",
		// dept);
	}

	/**
	 * 删除Dept实体操作
	 * 
	 * @param dept
	 *            传入的待删除的实体
	 * @return 删除记录数量
	 */
	public int deleteDept(Dept dept) {
		return deptMapper.deleteByNo(dept);
		// return session.delete("org.mybatis.example.DeptMapper.deleteByNo",
		// dept);
	}

	/**
	 * 删除Dept实体操作
	 * 
	 * @param dept
	 *            传入的待删除的实体
	 * @return 删除记录数量
	 */
	public Dept selectDept(Dept dept) {
		return deptMapper.selectByNo(dept);
		// return session.selectOne("org.mybatis.example.DeptMapper.selectByNo",
		// dept);
	}

}
