package com.lkq.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.lkq.entity.Tree;
import com.lkq.entity.User;
import com.lkq.service.PublicService;
import com.lkq.service.TreeService;
import com.lkq.service.UserService;
import com.lkq.util.MyUtil;



@Service("publicService")
public class PublicServiceImp implements PublicService {
	
	@Resource
	private TreeService treeService;
	@Resource
	private UserService userService;
 
	
	public void addLeftMenu(ModelAndView mav) {
		
		mav.addObject("leftPage", "/admin/common/left_menu.jsp");
		
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		currentUser = userService.findById(currentUser.getId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		String menuIds = currentUser.getMenuIds();
		/**
		 * 

17,171000,171005,171009,171011,171010

		 */
		if(menuIds==null){
			menuIds = "";
		}
		
		List<Integer> ids =MyUtil.Str_ids_To_ListInteger_ids(menuIds);  
		map.put("father", -1);
		map.put("ids", ids);
		
		if(ids.size()>0){
		}else{
			mav.addObject("treeList", null);
		}
		try {
			List<Tree> treeList = getTreesByParentId(map);//   List<Integer> ids
			mav.addObject("treeList", treeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * �ò˵�
	 */
	public List<Tree> getTreesByParentId(Map<String,Object> map) throws Exception {
		//String parentId,String ids  = map
		List<Tree> list = treeService.getTreesByFatherOrIds(map);
		//����
		
		
		for(Tree tree : list){
			//��� �Ǹ�ѡ��  �����������ж�   
			//tree.setChecked(true);
			if("open".equals(tree.getState())){
				continue;
			}else{
				map.put("father", tree.getId()+"");//����id����ids������
				tree.setChildren(getTreesByParentId(map));
			}
		}
		return list;
	}
	
	
 
	
	
}
