/**
 * 
 */
package org.spring.dubbo.demo.intf;

import java.io.Serializable;

/**
 * Dubbo 序列化传输测试类
 * @author LiuJian
 *
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 491692290625049991L;

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
