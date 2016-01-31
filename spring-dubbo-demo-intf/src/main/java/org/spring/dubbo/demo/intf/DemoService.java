/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.spring.dubbo.demo.intf;

/**
 * 使用样例服务
 * 
 * @author LiuJian
 *
 */
public interface DemoService {
	/**
	 * 示例的sayHello
	 * 
	 * @param name
	 *            问候人姓名
	 * @return 服务端返回问候语
	 */
	String sayHello(String name);

	/**
	 * 呼叫人的姓名
	 * 
	 * @param p
	 *            被呼叫人
	 * @return 服务端返回呼叫信息
	 */
	String callPerson(Person p);

}