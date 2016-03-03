package org.mybatis.example;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import domain.blog.Dept;
import domain.blog.DeptExample;

public interface DeptMapper {
	int countByExample(DeptExample example);

	int deleteByExample(DeptExample example);

	int insert(Dept record);

	int insertSelective(Dept record);

	List<Dept> selectByExample(DeptExample example);

	int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

	int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

	int updateByNo(Dept dept);

	int deleteByNo(Dept dept);

	Dept selectByNo(Dept dept);

}