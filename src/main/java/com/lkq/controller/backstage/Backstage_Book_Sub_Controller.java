package com.lkq.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/book/sub")
public class Backstage_Book_Sub_Controller {
	
	/**
	 * /backstage/book/sub/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/book_sub/book_sub_manage");
		return mav;
	}
	
	
}
