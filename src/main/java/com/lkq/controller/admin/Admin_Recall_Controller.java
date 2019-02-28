package com.lkq.controller.admin;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkq.entity.Book;
import com.lkq.entity.Recall;
import com.lkq.entity.PageBean;
import com.lkq.entity.Result;
import com.lkq.entity.User;
import com.lkq.entity.UserSub;
import com.lkq.service.RecallService;
import com.lkq.service.UserSubService;
import com.lkq.util.ResponseUtil;
import com.lkq.util.StringUtil;

@Controller
@RequestMapping("/admin/recall")
public class Admin_Recall_Controller {
	
	@Resource
	private UserSubService userSubService;
	@Resource
	private RecallService recallService;
	 
	
	/**
	 *   /admin/recall/add
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(value = "userSubId", required = false) String userSubId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		UserSub userSub = userSubService.findById(Integer.parseInt(userSubId));
		
		Recall recall = recallService.findBySubId(Integer.parseInt(userSubId));
		
		Result result = new Result();
		Gson gson = new Gson();
		
		if(recall!=null){
			result.setSuccess(false);
			result.setMsg("已在催还列表");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		recall = new Recall();
		recall.setCreateDateTime(new Date());
		recall.setBookId(userSub.getBookId());
		recall.setUserSubId(userSub.getId());
		recall.setJieyuerenId(userSub.getUserId());
		
		int resultTotal = recallService.add(recall);
		
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("已添加到催还列表");
		} else {
			result.setSuccess(false);
			result.setMsg("借阅失败");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	
	/**
	 * /admin/recall/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "userId", required = false) String userId, 
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("jieyuerenId", userId);
		
		List<Recall> list = recallService.list(map);
		Integer total = recallService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
	
	
	
	
	
	
}
