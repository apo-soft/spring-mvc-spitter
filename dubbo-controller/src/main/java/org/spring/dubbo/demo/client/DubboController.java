/**
 * 
 */
package org.spring.dubbo.demo.client;

import org.spring.dubbo.demo.intf.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiuJian
 *
 */
@Controller
@RequestMapping("/")
public class DubboController {

	public DubboController() {
	}

	@Autowired
	private DemoClient demoClient;

	@RequestMapping("/hello")
	@ResponseBody
	public String showDubboText(String name) {
		return demoClient.sayHello(name);
	}

	@RequestMapping("/person")
	@ResponseBody
	public String showDubboText(Person p) {
		return demoClient.callp(p);
	}
}
