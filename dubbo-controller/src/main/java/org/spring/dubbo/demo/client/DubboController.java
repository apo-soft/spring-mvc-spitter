/**
 * 
 */
package org.spring.dubbo.demo.client;

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
		System.out.println("create dubbo controller");
	}

	@Autowired
	private DemoClient demoClient;

	@RequestMapping("/dubbo")
	@ResponseBody
	public String showDubboText(String name) {
		System.out.println("in dubbo");
		return demoClient.sayHello(name);
	}
}
