/**
 * 
 */
package org.spring.dubbo.demo.client;

import java.util.HashMap;
import java.util.Map;

import org.spring.dubbo.demo.intf.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiuJian
 *
 */
@Controller
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

	@RequestMapping(value = "/hongbao", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String, Object> hongbao() {
		Map<String, Object> hongbaos = new HashMap<String, Object>();
		hongbaos.put("key" + String.valueOf(1), "新年大礼包");
		hongbaos.put("key" + String.valueOf(10), "新年百年包");
		hongbaos.put("key" + String.valueOf(100), "新年贺岁包");
		return hongbaos;
	}

}
