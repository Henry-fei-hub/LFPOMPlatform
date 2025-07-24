package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdMessageReceive;
import com.pomplatform.db.dao.CwdMessageReceive;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdMessageReceiveHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdMessageReceiveHandler.class);

	public static BaseCwdMessageReceive getCwdMessageReceiveById( 
		java.lang.Integer message_receive_id
	) throws Exception
	{
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setMessageReceiveId(message_receive_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdMessageReceiveExists( com.pomplatform.db.bean.BaseCwdMessageReceive bean, String additional ) throws Exception {

		CwdMessageReceive dao = new CwdMessageReceive();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdMessageReceive( com.pomplatform.db.bean.BaseCwdMessageReceive bean, String additional ) throws Exception {

		CwdMessageReceive dao = new CwdMessageReceive();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdMessageReceive> queryCwdMessageReceive( com.pomplatform.db.bean.BaseCwdMessageReceive bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdMessageReceive dao = new CwdMessageReceive();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdMessageReceive> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdMessageReceive> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdMessageReceive addToCwdMessageReceive ( BaseCwdMessageReceive cwdmessagereceive )  throws Exception {
		return addToCwdMessageReceive ( cwdmessagereceive , false);
	}

	public static BaseCwdMessageReceive addToCwdMessageReceive ( BaseCwdMessageReceive cwdmessagereceive, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setDataFromBase(cwdmessagereceive);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdMessageReceive addUpdateCwdMessageReceive ( BaseCwdMessageReceive cwdmessagereceive ) throws Exception {
		return addUpdateCwdMessageReceive ( cwdmessagereceive , false);
	}

	public static BaseCwdMessageReceive addUpdateCwdMessageReceive ( BaseCwdMessageReceive cwdmessagereceive, boolean singleTransaction  ) throws Exception {
		if(cwdmessagereceive.getMessageReceiveId() == null) return addToCwdMessageReceive(cwdmessagereceive);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setDataFromBase(cwdmessagereceive);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdmessagereceive); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdMessageReceive ( BaseCwdMessageReceive bean ) throws Exception {
		CwdMessageReceive dao = new CwdMessageReceive();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdMessageReceive updateCwdMessageReceive ( BaseCwdMessageReceive cwdmessagereceive ) throws Exception {
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setMessageReceiveId( cwdmessagereceive.getMessageReceiveId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdmessagereceive);
			result = dao.update();
		}
		return result == 1 ? cwdmessagereceive : null ;
	}

	public static BaseCwdMessageReceive updateCwdMessageReceiveDirect( BaseCwdMessageReceive cwdmessagereceive ) throws Exception {
		CwdMessageReceive dao = new CwdMessageReceive();
		int result = 0;
		dao.setDataFromBase(cwdmessagereceive);
		result = dao.update();
		return result == 1 ? cwdmessagereceive : null ;
	}

	public static int setDeleteConditions(BaseCwdMessageReceive bean, CwdMessageReceive dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMessageReceiveId() != null) {
			dao.setConditionMessageReceiveId("=", bean.getMessageReceiveId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMessageId() != null) {
				dao.setConditionMessageId("=", bean.getMessageId());
				count++;
			}
			if(bean.getReceiverId() != null) {
				dao.setConditionReceiverId("=", bean.getReceiverId());
				count++;
			}
			if(bean.getReceiverType() != null) {
				dao.setConditionReceiverType("=", bean.getReceiverType());
				count++;
			}
			if(bean.getReadStatus() != null) {
				dao.setConditionReadStatus("=", bean.getReadStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdMessageReceive bean, CwdMessageReceive dao){
		int count = 0;
		if(bean.getMessageReceiveId() != null) {
			dao.setConditionMessageReceiveId("=", bean.getMessageReceiveId());
			count++;
		}
		if(bean.getMessageId() != null) {
			dao.setConditionMessageId("=", bean.getMessageId());
			count++;
		}
		if(bean.getReceiverId() != null) {
			dao.setConditionReceiverId("=", bean.getReceiverId());
			count++;
		}
		if(bean.getReceiverType() != null) {
			dao.setConditionReceiverType("=", bean.getReceiverType());
			count++;
		}
		if(bean.getReadStatus() != null) {
			dao.setConditionReadStatus("=", bean.getReadStatus());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		bean.setDataFromJSON(json);
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdMessageReceive> rlist = new BaseCollection<>();
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdMessageReceive dao = new CwdMessageReceive();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdMessageReceive> result = dao.conditionalLoad(addtion);
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
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		bean.setDataFromJSON(json);
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		bean.setDataFromJSON(json);
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		bean.setDataFromJSON(json);
		CwdMessageReceive dao = new CwdMessageReceive();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdMessageReceive bean = new BaseCwdMessageReceive();
		bean.setDataFromJSON(json);
		CwdMessageReceive dao = new CwdMessageReceive();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


