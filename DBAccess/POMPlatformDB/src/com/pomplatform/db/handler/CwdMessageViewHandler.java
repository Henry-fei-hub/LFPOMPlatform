package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdMessageView;
import com.pomplatform.db.dao.CwdMessageView;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdMessageViewHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdMessageViewHandler.class);

	public static BaseCwdMessageView getCwdMessageViewById( 
		java.lang.Integer message_view_id
	) throws Exception
	{
		CwdMessageView dao = new CwdMessageView();
		dao.setMessageViewId(message_view_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdMessageViewExists( com.pomplatform.db.bean.BaseCwdMessageView bean, String additional ) throws Exception {

		CwdMessageView dao = new CwdMessageView();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdMessageView( com.pomplatform.db.bean.BaseCwdMessageView bean, String additional ) throws Exception {

		CwdMessageView dao = new CwdMessageView();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdMessageView> queryCwdMessageView( com.pomplatform.db.bean.BaseCwdMessageView bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdMessageView dao = new CwdMessageView();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdMessageView> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdMessageView> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdMessageView addToCwdMessageView ( BaseCwdMessageView cwdmessageview )  throws Exception {
		return addToCwdMessageView ( cwdmessageview , false);
	}

	public static BaseCwdMessageView addToCwdMessageView ( BaseCwdMessageView cwdmessageview, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdMessageView dao = new CwdMessageView();
		dao.setDataFromBase(cwdmessageview);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdMessageView addUpdateCwdMessageView ( BaseCwdMessageView cwdmessageview ) throws Exception {
		return addUpdateCwdMessageView ( cwdmessageview , false);
	}

	public static BaseCwdMessageView addUpdateCwdMessageView ( BaseCwdMessageView cwdmessageview, boolean singleTransaction  ) throws Exception {
		if(cwdmessageview.getMessageViewId() == null) return addToCwdMessageView(cwdmessageview);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdMessageView dao = new CwdMessageView();
		dao.setDataFromBase(cwdmessageview);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdmessageview); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdMessageView ( BaseCwdMessageView bean ) throws Exception {
		CwdMessageView dao = new CwdMessageView();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdMessageView updateCwdMessageView ( BaseCwdMessageView cwdmessageview ) throws Exception {
		CwdMessageView dao = new CwdMessageView();
		dao.setMessageViewId( cwdmessageview.getMessageViewId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdmessageview);
			result = dao.update();
		}
		return result == 1 ? cwdmessageview : null ;
	}

	public static BaseCwdMessageView updateCwdMessageViewDirect( BaseCwdMessageView cwdmessageview ) throws Exception {
		CwdMessageView dao = new CwdMessageView();
		int result = 0;
		dao.setDataFromBase(cwdmessageview);
		result = dao.update();
		return result == 1 ? cwdmessageview : null ;
	}

	public static int setDeleteConditions(BaseCwdMessageView bean, CwdMessageView dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMessageViewId() != null) {
			dao.setConditionMessageViewId("=", bean.getMessageViewId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMessageId() != null) {
				dao.setConditionMessageId("=", bean.getMessageId());
				count++;
			}
			if(bean.getObserverId() != null) {
				dao.setConditionObserverId("=", bean.getObserverId());
				count++;
			}
			if(bean.getObserverType() != null) {
				dao.setConditionObserverType("=", bean.getObserverType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdMessageView bean, CwdMessageView dao){
		int count = 0;
		if(bean.getMessageViewId() != null) {
			dao.setConditionMessageViewId("=", bean.getMessageViewId());
			count++;
		}
		if(bean.getMessageId() != null) {
			dao.setConditionMessageId("=", bean.getMessageId());
			count++;
		}
		if(bean.getObserverId() != null) {
			dao.setConditionObserverId("=", bean.getObserverId());
			count++;
		}
		if(bean.getObserverType() != null) {
			dao.setConditionObserverType("=", bean.getObserverType());
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
		BaseCwdMessageView bean = new BaseCwdMessageView();
		bean.setDataFromJSON(json);
		CwdMessageView dao = new CwdMessageView();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdMessageView> rlist = new BaseCollection<>();
		BaseCwdMessageView bean = new BaseCwdMessageView();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdMessageView dao = new CwdMessageView();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdMessageView> result = dao.conditionalLoad(addtion);
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
		BaseCwdMessageView bean = new BaseCwdMessageView();
		bean.setDataFromJSON(json);
		CwdMessageView dao = new CwdMessageView();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdMessageView bean = new BaseCwdMessageView();
		bean.setDataFromJSON(json);
		CwdMessageView dao = new CwdMessageView();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdMessageView bean = new BaseCwdMessageView();
		bean.setDataFromJSON(json);
		CwdMessageView dao = new CwdMessageView();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdMessageView bean = new BaseCwdMessageView();
		bean.setDataFromJSON(json);
		CwdMessageView dao = new CwdMessageView();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


