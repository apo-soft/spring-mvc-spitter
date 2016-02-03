/**
 * 
 */
package org.spring.dubbo.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.spring.dubbo.demo.intf.DemoService;
import org.spring.dubbo.demo.intf.Person;

import com.alibaba.dubbo.rpc.RpcContext;

/**
 * @author LiuJian
 *
 */
public class DemoServiceImpl implements DemoService {

	/**
	 * 问好实现方法 dubbo
	 * 
	 * @see org.spring.dubbo.demo.intf.DemoService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
				+ ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();

	}

	/**
	 * 呼叫用户实现方法
	 * 
	 * @see org.spring.dubbo.demo.intf.DemoService#callPerson(org.spring.dubbo.demo.
	 *      intf.Person)
	 */
	@Override
	public String callPerson(Person p) {
		if (p == null) {
			return "No person is called, response form provider: " + RpcContext.getContext().getLocalAddress();
		}
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + p.getName() + ","
				+ p.getAge() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + p.getName() + ", response form provider: " + RpcContext.getContext().getLocalAddress();
	}

}
