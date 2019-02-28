package com.lkq.controller.backstage;



import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.gson.Gson;
import com.lkq.entity.Result;
import com.lkq.entity.User;
import com.lkq.service.PublicService;
import com.lkq.service.UserService;
import com.lkq.util.CryptographyUtil;
import com.lkq.util.ResponseUtil;
import com.lkq.util.StringUtil;



@Controller
@RequestMapping("/backstage/user")
public class Backstage_User_Controller {
	
	
	@Resource
	private UserService  userService;
	@Resource
	private PublicService  publicService;
	

	/**
	 * 
	 * @param t  是null 代表，是全部
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "用户管理");
		mav.addObject("title", "用户管理");
		mav.setViewName("/admin/page/user/user_manage");
		return mav;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			,HttpServletResponse response
			,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		User user = userService.findById(Integer.parseInt(id));
		
		mav.addObject("user", user);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/user/update?id="+id);
		
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}
	
	@RequestMapping("/setPersm")
	public ModelAndView setPersm(@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.setViewName("admin/page/user/set_persm");
		return mav;
	}
	
	@RequestMapping("/setPassword")
	public ModelAndView setPassword(@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("save_url", "/admin/user/update?id="+id);
		mav.setViewName("admin/page/user/set_password");
		return mav;
	}
	
	
	
}


