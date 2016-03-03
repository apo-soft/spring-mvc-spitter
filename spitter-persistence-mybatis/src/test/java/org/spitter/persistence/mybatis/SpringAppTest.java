/**
 * 
 */
package org.spitter.persistence.mybatis;

import org.mybatis.example.DeptMapper;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import domain.blog.Dept;

/**
 * 测试Spring,mybatis集成的用例
 * 
 * @author LiuJian
 *
 */
public class SpringAppTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] contextPaths = { "classpath:spring-prop-config.xml", "classpath:spring-mybatis-config.xml" };
		FileSystemXmlApplicationContext context = null;

		try {
			context = new FileSystemXmlApplicationContext(contextPaths);
			DeptMapper mapper = context.getBean(DeptMapper.class);
			// System.out.println(mapper != null);
			Dept dept = new Dept();
			dept.setDeptno((short) 10);
			Dept respDept = mapper.selectByNo(dept);
			System.out.println(respDept);
		} finally {
			if (context != null) {
				context.close();
			}
		}

	}
}
