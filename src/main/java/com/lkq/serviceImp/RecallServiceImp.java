package com.lkq.serviceImp;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lkq.dao.BookDao;
import com.lkq.dao.RecallDao;
import com.lkq.entity.Recall;
import com.lkq.service.RecallService;


@Service("recallService")
public class RecallServiceImp implements RecallService {
	

	@Resource
	private RecallDao  recallDao;
	
	@Override
	public Integer add(Recall recall) {
		// TODO Auto-generated method stub
		return recallDao.add(recall);
	}

	@Override
	public Integer update(Recall recall) {
		// TODO Auto-generated method stub
		return recallDao.update(recall);
	}

	@Override
	public List<Recall> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return recallDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return recallDao.getTotal(map);
	}

	@Override
	public Recall findById(Integer id) {
		// TODO Auto-generated method stub
		return recallDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return recallDao.delete(id);
	}
	
	@Override
	public Recall findBySubId(Integer subId) {
		// TODO Auto-generated method stub
		return recallDao.findBySubId(subId);
	}
	
	@Override
	public Integer deleteBySubId(Integer subId) {
		// TODO Auto-generated method stub
		return recallDao.deleteBySubId(subId);
	}
	
	
	
}
