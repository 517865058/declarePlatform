package com.qjz.declarePlatfrom.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjz.declarePlatfrom.domain.Review2;
import com.qjz.declarePlatfrom.service.Review2Service;
import com.qjz.declarePlatfrom.util.JsonResult;

@Controller
@RequestMapping("/review2")
public class Review2Controller {
	
	@Resource
	private Review2Service review2Service;
	
	@RequestMapping("/listReview2")
	@ResponseBody
	public Map<String, Object> listReview2(
			//page第几页，rows每页多少行
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows) {
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> map = review2Service.listReview2(currentPage, pageSize);
		return map;
	}
	
	@RequestMapping("/addReview2")
	@ResponseBody
	public JsonResult addReview2(Integer item_id, String review2_user) {
		review2Service.addReview2(item_id, review2_user);
		return new JsonResult();
	}
	
	@RequestMapping("/updateReview2")
	@ResponseBody
	public JsonResult updateReview2(Review2 review2) {
		review2Service.updateReview2(review2);
		return new JsonResult();
	}

}
