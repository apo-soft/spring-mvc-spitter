/**
 * 
 */
package com.habuma.spitter.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

/**
 * 样例Dao应用
 * 
 * @author Jann Liu
 *
 */
public class DemoSpitterDao implements SpitterDao {
	private final static Calendar calendar = Calendar.getInstance();

	private final static Map<Long, Spitter> container;

	private final static List<Spittle> spittlesList;

	private final static Spitter createSpitter(final long id, final String username, final String password,
			final String fullName, final String email, final boolean updateByEmail) {
		Spitter spitter = new Spitter();
		spitter.setId(id);
		spitter.setUsername(username);
		spitter.setPassword(password);
		spitter.setFullName(fullName);
		spitter.setEmail(email);
		spitter.setUpdateByEmail(updateByEmail);
		return spitter;
	}

	private final static Spittle createSpittle(final long id, final String spittleText, final Date postedTime) {
		Spittle spittle = new Spittle();
		spittle.setId(id);
		spittle.setText(spittleText);
		spittle.setWhen(postedTime);
		spittle.setSpitter(container.get(id));

		return spittle;
	}

	static {
		container = new HashMap<Long, Spitter>();
		container.put(1L, createSpitter(1L, "habuma", "password", "Craig Walls", "craig@habuma.com", false));
		container.put(2L, createSpitter(2L, "artnames", "password", "Art Names", "artnames@habuma.com", false));

		spittlesList = new ArrayList<Spittle>(3);
		calendar.set(2010, 6, 9);
		spittlesList
				.add(createSpittle(1L, "Have you read Spring in Action 3? I hear it is awesome!", calendar.getTime()));
		calendar.set(2010, 6, 11);
		spittlesList.add(createSpittle(2L, "Trying out Spring''s new expression language.", calendar.getTime()));
		calendar.set(2010, 6, 19);
		spittlesList.add(createSpittle(1L, "Who''s going to SpringOne/2GX this year?", calendar.getTime()));
	}

	@Override
	public Spitter getSpitterById(long id) {
		return container.get(id);
	}

	@Override
	public void addSpitter(Spitter spitter) {
		if (container.containsKey(spitter.getId())) {
			// NOOP
		} else {
			container.put(spitter.getId(), spitter);
		}
	}

	@Override
	public void saveSpitter(Spitter spitter) {
		container.put(spitter.getId(), spitter);
	}

	@Override
	public List<Spittle> getRecentSpittle() {
		List<Spittle> spittles = new ArrayList<Spittle>();
		spittles.addAll(spittlesList);
		return spittles;
	}
	/////////////////////////////////////////////////////////////
	// 实现的方法分割线
	/////////////////////////////////////////////////////////////

	@Override
	public void saveSpittle(Spittle spittle) {
		// NOOP

	}

	@Override
	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
		// NOOP
		return null;
	}

	@Override
	public Spitter getSpitterByUsername(String username) {
		// NOOP
		return null;
	}

	@Override
	public void deleteSpittle(long id) {
		// NOOP

	}

	@Override
	public Spittle getSpittleById(long id) {
		// NOOP
		return null;
	}

	@Override
	public List<Spitter> findAllSpitters() {
		// NOOP
		return null;
	}

}
