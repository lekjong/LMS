package com.lkq.controller.backstage;



import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lkq.entity.User;


@Controller
@RequestMapping("/backstage/user/sub")
public class Backstage_User_Sub_Controller {
	
	
	/**
	 * /backstage/user/sub/manage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", "/admin/user/sub/list");
		mav.setViewName("/admin/page/user_sub/user_sub_manage");
		return mav;
	}
	
	
	
	/**
	 * /backstage/user/sub/my
	 * 我的借阅 记录
	 */
	@RequestMapping("/my")
	public ModelAndView my(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("table_url", "/admin/user/sub/list?userId="+user.getId());
		mav.setViewName("/admin/page/user_sub/my_sub_manage");
		return mav;
	}
	
	
	
	
}
