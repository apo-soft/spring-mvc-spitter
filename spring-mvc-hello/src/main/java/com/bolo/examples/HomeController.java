/**
 * 
 */
package com.bolo.examples;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.habuma.spitter.service.SpitterService;

/**
 * @author LiuJian
 *
 */
@Controller
public class HomeController {

	private SpitterService spitterService;
	// <start id="spittlesPerPage"/>
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}

	/**
	 * 
	 * @return
	 */
	private SpitterService getSpitterService() {
		return spitterService;
	}

	@Inject
	public HomeController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}

	@RequestMapping("/home")
	public String showHomePage(Map<String, Object> model) {
		model.put("spittles", getSpitterService().getRecentSpittles(spittlesPerPage));
		return "home";
	}

}
