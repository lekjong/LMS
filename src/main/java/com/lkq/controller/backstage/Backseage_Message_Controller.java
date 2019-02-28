package com.lkq.controller.backstage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lkq.entity.Book;
import com.lkq.entity.Message;
import com.lkq.service.BookService;
import com.lkq.service.MessageService;


@Controller
@RequestMapping("/backstage/message")
public class Backseage_Message_Controller {
	
	private MessageService messageService;
	
	/**
	 * /backstage/message/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/message_manage");
		return mav;
	}
	
	
	/**
	 * /backstage/message/my
	 */
	@RequestMapping("/my")
	public ModelAndView my() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/my_message_manage");
		return mav;
	}
	
	
	
	/**
	 * /backstage/message/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "���");
		mav.addObject("save_url", "/admin/message/add");
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
	
	
	/**
	 * /backstage/message/edit?id=22
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			,HttpServletResponse response
			,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Message message = messageService.findById(Integer.parseInt(id));
		mav.addObject("message", message);
		mav.addObject("btn_text", "�޸�");
		mav.addObject("save_url", "/admin/message/update?id="+id);
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
}
