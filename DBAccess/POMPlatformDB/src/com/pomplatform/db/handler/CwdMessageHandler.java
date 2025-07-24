package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdMessage;
import com.pomplatform.db.dao.CwdMessage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdMessageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdMessageHandler.class);

	public static BaseCwdMessage getCwdMessageById( 
		java.lang.Integer message_id
	) throws Exception
	{
		CwdMessage dao = new CwdMessage();
		dao.setMessageId(message_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdMessageExists( com.pomplatform.db.bean.BaseCwdMessage bean, String additional ) throws Exception {

		CwdMessage dao = new CwdMessage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdMessage( com.pomplatform.db.bean.BaseCwdMessage bean, String additional ) throws Exception {

		CwdMessage dao = new CwdMessage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdMessage> queryCwdMessage( com.pomplatform.db.bean.BaseCwdMessage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdMessage dao = new CwdMessage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdMessage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdMessage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdMessage addToCwdMessage ( BaseCwdMessage cwdmessage )  throws Exception {
		return addToCwdMessage ( cwdmessage , false);
	}

	public static BaseCwdMessage addToCwdMessage ( BaseCwdMessage cwdmessage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdMessage dao = new CwdMessage();
		dao.setDataFromBase(cwdmessage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdMessage addUpdateCwdMessage ( BaseCwdMessage cwdmessage ) throws Exception {
		return addUpdateCwdMessage ( cwdmessage , false);
	}

	public static BaseCwdMessage addUpdateCwdMessage ( BaseCwdMessage cwdmessage, boolean singleTransaction  ) throws Exception {
		if(cwdmessage.getMessageId() == null) return addToCwdMessage(cwdmessage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdMessage dao = new CwdMessage();
		dao.setDataFromBase(cwdmessage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdmessage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdMessage ( BaseCwdMessage bean ) throws Exception {
		CwdMessage dao = new CwdMessage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdMessage updateCwdMessage ( BaseCwdMessage cwdmessage ) throws Exception {
		CwdMessage dao = new CwdMessage();
		dao.setMessageId( cwdmessage.getMessageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdmessage);
			result = dao.update();
		}
		return result == 1 ? cwdmessage : null ;
	}

	public static BaseCwdMessage updateCwdMessageDirect( BaseCwdMessage cwdmessage ) throws Exception {
		CwdMessage dao = new CwdMessage();
		int result = 0;
		dao.setDataFromBase(cwdmessage);
		result = dao.update();
		return result == 1 ? cwdmessage : null ;
	}

	public static int setDeleteConditions(BaseCwdMessage bean, CwdMessage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMessageId() != null) {
			dao.setConditionMessageId("=", bean.getMessageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSenderId() != null) {
				dao.setConditionSenderId("=", bean.getSenderId());
				count++;
			}
			if(bean.getSenderType() != null) {
				dao.setConditionSenderType("=", bean.getSenderType());
				count++;
			}
			if(bean.getContent() != null) {
				dao.setConditionContent("=", bean.getContent());
				count++;
			}
			if(bean.getMessageType() != null) {
				dao.setConditionMessageType("=", bean.getMessageType());
				count++;
			}
			if(bean.getPrivacyType() != null) {
				dao.setConditionPrivacyType("=", bean.getPrivacyType());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getCwdTaskManageId() != null) {
				dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
				count++;
			}
			if(bean.getCwdTaskProcessId() != null) {
				dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdMessage bean, CwdMessage dao){
		int count = 0;
		if(bean.getMessageId() != null) {
			dao.setConditionMessageId("=", bean.getMessageId());
			count++;
		}
		if(bean.getSenderId() != null) {
			dao.setConditionSenderId("=", bean.getSenderId());
			count++;
		}
		if(bean.getSenderType() != null) {
			dao.setConditionSenderType("=", bean.getSenderType());
			count++;
		}
		if(bean.getContent() != null) {
			if(bean.getContent().indexOf("%") >= 0)
				dao.setConditionContent("like", bean.getContent());
			else
				dao.setConditionContent("=", bean.getContent());
			count++;
		}
		if(bean.getMessageType() != null) {
			dao.setConditionMessageType("=", bean.getMessageType());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getPrivacyType() != null) {
			dao.setConditionPrivacyType("=", bean.getPrivacyType());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdMessage bean = new BaseCwdMessage();
		bean.setDataFromJSON(json);
		CwdMessage dao = new CwdMessage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdMessage> rlist = new BaseCollection<>();
		BaseCwdMessage bean = new BaseCwdMessage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdMessage dao = new CwdMessage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdMessage> result = dao.conditionalLoad(addtion);
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
		BaseCwdMessage bean = new BaseCwdMessage();
		bean.setDataFromJSON(json);
		CwdMessage dao = new CwdMessage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdMessage bean = new BaseCwdMessage();
		bean.setDataFromJSON(json);
		CwdMessage dao = new CwdMessage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdMessage bean = new BaseCwdMessage();
		bean.setDataFromJSON(json);
		CwdMessage dao = new CwdMessage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdMessage bean = new BaseCwdMessage();
		bean.setDataFromJSON(json);
		CwdMessage dao = new CwdMessage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


