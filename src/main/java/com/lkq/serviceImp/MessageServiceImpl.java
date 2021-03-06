package com.lkq.serviceImp;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lkq.dao.RecallDao;
import com.lkq.dao.MessageDao;
import com.lkq.entity.Message;
import com.lkq.service.MessageService;



@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDao  messageDao;
	
	@Override
	public Integer add(Message msg) {
		// TODO Auto-generated method stub
		return messageDao.add(msg);
	}

	@Override
	public Integer update(Message msg) {
		// TODO Auto-generated method stub
		return messageDao.update(msg);
	}

	@Override
	public List<Message> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return messageDao.list(map);
	}
	
	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return messageDao.getTotal(map);
	}
	
	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return messageDao.delete(id);
	}

	@Override
	public Message findById(Integer id) {
		// TODO Auto-generated method stub
		return messageDao.findById(id);
	}

}
