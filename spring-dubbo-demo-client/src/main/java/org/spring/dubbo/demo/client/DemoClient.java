/**
 * 
 */
package org.spring.dubbo.demo.client;

import org.spring.dubbo.demo.intf.DemoService;
import org.spring.dubbo.demo.intf.Person;

/**
 * 远程服务封装对象
 * 
 * @author LiuJian
 *
 */
public class DemoClient {

	private DemoService demoService;

	/**
	 * 设置远程dubbo对象
	 * 
	 * @param demoService
	 *            远程对象代理
	 * 
	 */
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}

	/**
	 * 远程调用dubboService转发
	 * 
	 * @param p
	 *            Person
	 * @return service reply
	 */
	public String sayHello(String name) {
		return demoService.sayHello(name);
	}

	/**
	 * 远程调用dubboService转发
	 * 
	 * @param p
	 *            Person
	 * @return service reply
	 */
	public String callp(Person p) {
		return demoService.callPerson(p);
	}
}
