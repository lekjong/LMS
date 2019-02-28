package com.lkq.controller.backstage;



import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lkq.entity.User;
import com.lkq.service.RecallService;



@Controller
@RequestMapping("/backstage/recall")
public class Backstage_Recall_Controller {
	
	@Resource
	private RecallService recallService;
	
	
	/**
	 * /backstage/recall/manage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", "/admin/recall/list");
		mav.setViewName("/admin/page/recall/recall_manage");
		return mav;
	}

	
	/**
	 * /backstage/recall/my
	 * 我的催还记录
	 */
	@RequestMapping("/my")
	public ModelAndView my(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("table_url", "/admin/recall/list?userId="+user.getId());
		mav.setViewName("/admin/page/recall/my_recall_manage");
		return mav;
	}
	
	
	
	
}
