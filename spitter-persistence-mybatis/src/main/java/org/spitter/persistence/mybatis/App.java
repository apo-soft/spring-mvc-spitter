package org.spitter.persistence.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.DeptOperationStub;

import domain.blog.Dept;

/**
 * Hello world!
 *
 */
public class App {

	public void executeDemos(String[] args) {
		SqlSessionFactory factory = null;
		try {
			Properties props = loadProperties("org/mybatis/configs/config.properties");
			String resource = "org/mybatis/configs/Configuration.xml";
			Reader reader = loadConfigReader(resource);
			factory = createSqlSessionFactory(reader, props);
			// 以下为session执行过程
			executionDeptOperations(factory);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
			}
		}
	}

	/**
	 * 针对dept执行增删改查操作
	 * 
	 * @param factory
	 */
	private void executionDeptOperations(SqlSessionFactory factory) {
		boolean autoCommit = true;
		// 启动session,确定是否自动提交
		SqlSession session = factory.openSession(autoCommit);
		try {
			DeptOperationStub stub = new DeptOperationStub(session);
			Dept dept = stub.createDemoDept();
			stub.insertDept(dept);
			dept.setDname("行政部");
			stub.updateDept(dept);
			Dept respDept = stub.selectDept(dept);
			System.out.println(respDept);
			stub.deleteDept(dept);
			if (!autoCommit) {
				session.commit();
			}
		} catch (Exception e) {
			if (!autoCommit) {
				session.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public SqlSessionFactory createSqlSessionFactory(Reader reader, Properties props) {
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, props);
		return factory;
	}

	/**
	 * 加载属性
	 * 
	 * @param propPath
	 * @throws IOException
	 */
	private Properties loadProperties(String propPath) throws IOException {
		InputStream input = ClassLoader.getSystemResourceAsStream(propPath);
		Properties props = new Properties();
		props.load(input);

		return props;
	}

	/**
	 * 记载配置信息
	 * 
	 * @param configPath
	 * @throws IOException
	 */
	private Reader loadConfigReader(String configPath) throws IOException {
		Reader reader = Resources.getResourceAsReader(configPath);
		return reader;
	}
}
