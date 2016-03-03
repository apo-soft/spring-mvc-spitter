package com.habuma.spitter.service;

import java.util.List;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

/**
 * 服务层实现
 * 
 * @author LiuJian
 *
 */
public interface SpitterService {
	/**
	 * 读取最新的消息
	 * 
	 * @param count
	 *            读取的数量
	 * @return 最近吐槽内容列表
	 */
	List<Spittle> getRecentSpittles(int count);

	/**
	 * 保存吐槽内容
	 * 
	 * @param spittle
	 *            待保存对象
	 */
	void saveSpittle(Spittle spittle);

	/**
	 * 保存吐槽人信息
	 * 
	 * @param spitter
	 *            吐槽人信息
	 */
	void saveSpitter(Spitter spitter);

	Spitter getSpitter(long id);

	void startFollowing(Spitter follower, Spitter followee);

	List<Spittle> getSpittlesForSpitter(Spitter spitter);

	List<Spittle> getSpittlesForSpitter(String username);

	Spitter getSpitter(String username);

	Spittle getSpittleById(long id);

	void deleteSpittle(long id);

	List<Spitter> getAllSpitters();
}
