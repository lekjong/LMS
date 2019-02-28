package com.lkq.controller.backstage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lkq.entity.Config;
import com.lkq.service.ConfigService;


@Controller
@RequestMapping("/backstage/config")
public class Backstage_Config_Controller {
	
	
	private ConfigService configService;
	
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/config/config_manage");
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Config config     = configService.findById(Integer.parseInt(id));
		mav.addObject("config", config);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/config/update?id=" + id);
		mav.setViewName("/admin/page/config/add_or_update");
		return mav;
	}
	
	
}
