/**
 * 
 */
package org.spring.dubbo.demo.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	AtomicLong longSeq = new AtomicLong(0);
	private static final Logger logger = LoggerFactory.getLogger(DubboController.class);

	public DubboController() {
	}

	@Autowired
	private DemoClient demoClient;

	@RequestMapping(value = "/hello", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String showDubboText(String name) {
		long seq = longSeq.incrementAndGet();
		logger.info("seq:" + seq + " " + name);
		String resp = demoClient.sayHello(name);
		logger.info("seq:" + seq + " " + resp);
		return resp;
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
