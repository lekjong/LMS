package com.lkq.serviceImp;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.lkq.dao.TreeDao;
import com.lkq.entity.Tree;
import com.lkq.service.TreeService;

import javax.annotation.Resource;



@Service("treeService")
public class TreeServiceImp implements TreeService {

	@Resource
	private TreeDao  treeDao;



	public Tree findById(Integer id) {
		return treeDao.findById(id);
	}
	
	

	public List<Tree> getTreesByFatherOrIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return treeDao.getTreesByFatherOrIds(map);
	}
 
	


	 
}
