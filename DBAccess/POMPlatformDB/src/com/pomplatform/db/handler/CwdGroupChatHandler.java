package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdGroupChat;
import com.pomplatform.db.dao.CwdGroupChat;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdGroupChatHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdGroupChatHandler.class);

	public static BaseCwdGroupChat getCwdGroupChatById( 
		java.lang.Integer group_chat_id
	) throws Exception
	{
		CwdGroupChat dao = new CwdGroupChat();
		dao.setGroupChatId(group_chat_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdGroupChatExists( com.pomplatform.db.bean.BaseCwdGroupChat bean, String additional ) throws Exception {

		CwdGroupChat dao = new CwdGroupChat();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdGroupChat( com.pomplatform.db.bean.BaseCwdGroupChat bean, String additional ) throws Exception {

		CwdGroupChat dao = new CwdGroupChat();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdGroupChat> queryCwdGroupChat( com.pomplatform.db.bean.BaseCwdGroupChat bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdGroupChat dao = new CwdGroupChat();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdGroupChat> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdGroupChat> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdGroupChat addToCwdGroupChat ( BaseCwdGroupChat cwdgroupchat )  throws Exception {
		return addToCwdGroupChat ( cwdgroupchat , false);
	}

	public static BaseCwdGroupChat addToCwdGroupChat ( BaseCwdGroupChat cwdgroupchat, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdGroupChat dao = new CwdGroupChat();
		dao.setDataFromBase(cwdgroupchat);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdGroupChat addUpdateCwdGroupChat ( BaseCwdGroupChat cwdgroupchat ) throws Exception {
		return addUpdateCwdGroupChat ( cwdgroupchat , false);
	}

	public static BaseCwdGroupChat addUpdateCwdGroupChat ( BaseCwdGroupChat cwdgroupchat, boolean singleTransaction  ) throws Exception {
		if(cwdgroupchat.getGroupChatId() == null) return addToCwdGroupChat(cwdgroupchat);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdGroupChat dao = new CwdGroupChat();
		dao.setDataFromBase(cwdgroupchat);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdgroupchat); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdGroupChat ( BaseCwdGroupChat bean ) throws Exception {
		CwdGroupChat dao = new CwdGroupChat();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdGroupChat updateCwdGroupChat ( BaseCwdGroupChat cwdgroupchat ) throws Exception {
		CwdGroupChat dao = new CwdGroupChat();
		dao.setGroupChatId( cwdgroupchat.getGroupChatId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdgroupchat);
			result = dao.update();
		}
		return result == 1 ? cwdgroupchat : null ;
	}

	public static BaseCwdGroupChat updateCwdGroupChatDirect( BaseCwdGroupChat cwdgroupchat ) throws Exception {
		CwdGroupChat dao = new CwdGroupChat();
		int result = 0;
		dao.setDataFromBase(cwdgroupchat);
		result = dao.update();
		return result == 1 ? cwdgroupchat : null ;
	}

	public static int setDeleteConditions(BaseCwdGroupChat bean, CwdGroupChat dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getGroupChatId() != null) {
			dao.setConditionGroupChatId("=", bean.getGroupChatId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getChatName() != null) {
				dao.setConditionChatName("=", bean.getChatName());
				count++;
			}
			if(bean.getGroupType() != null) {
				dao.setConditionGroupType("=", bean.getGroupType());
				count++;
			}
			if(bean.getWeixinOwner() != null) {
				dao.setConditionWeixinOwner("=", bean.getWeixinOwner());
				count++;
			}
			if(bean.getWeixinChatId() != null) {
				dao.setConditionWeixinChatId("=", bean.getWeixinChatId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getCreateApplicationType() != null) {
				dao.setConditionCreateApplicationType("=", bean.getCreateApplicationType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdGroupChat bean, CwdGroupChat dao){
		int count = 0;
		if(bean.getGroupChatId() != null) {
			dao.setConditionGroupChatId("=", bean.getGroupChatId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getChatName() != null) {
			if(bean.getChatName().indexOf("%") >= 0)
				dao.setConditionChatName("like", bean.getChatName());
			else
				dao.setConditionChatName("=", bean.getChatName());
			count++;
		}
		if(bean.getGroupType() != null) {
			dao.setConditionGroupType("=", bean.getGroupType());
			count++;
		}
		if(bean.getWeixinOwner() != null) {
			if(bean.getWeixinOwner().indexOf("%") >= 0)
				dao.setConditionWeixinOwner("like", bean.getWeixinOwner());
			else
				dao.setConditionWeixinOwner("=", bean.getWeixinOwner());
			count++;
		}
		if(bean.getWeixinChatId() != null) {
			if(bean.getWeixinChatId().indexOf("%") >= 0)
				dao.setConditionWeixinChatId("like", bean.getWeixinChatId());
			else
				dao.setConditionWeixinChatId("=", bean.getWeixinChatId());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCreateApplicationType() != null) {
			dao.setConditionCreateApplicationType("=", bean.getCreateApplicationType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		bean.setDataFromJSON(json);
		CwdGroupChat dao = new CwdGroupChat();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdGroupChat> rlist = new BaseCollection<>();
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdGroupChat dao = new CwdGroupChat();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdGroupChat> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		bean.setDataFromJSON(json);
		CwdGroupChat dao = new CwdGroupChat();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		bean.setDataFromJSON(json);
		CwdGroupChat dao = new CwdGroupChat();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		bean.setDataFromJSON(json);
		CwdGroupChat dao = new CwdGroupChat();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdGroupChat bean = new BaseCwdGroupChat();
		bean.setDataFromJSON(json);
		CwdGroupChat dao = new CwdGroupChat();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


