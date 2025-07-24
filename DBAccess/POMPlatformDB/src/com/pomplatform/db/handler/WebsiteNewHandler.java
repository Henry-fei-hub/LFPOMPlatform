package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseWebsiteNew;
import com.pomplatform.db.dao.WebsiteNew;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class WebsiteNewHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(WebsiteNewHandler.class);

	public static BaseWebsiteNew getWebsiteNewById( 
		java.lang.Integer website_new_id
	) throws Exception
	{
		WebsiteNew dao = new WebsiteNew();
		dao.setWebsiteNewId(website_new_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isWebsiteNewExists( com.pomplatform.db.bean.BaseWebsiteNew bean, String additional ) throws Exception {

		WebsiteNew dao = new WebsiteNew();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countWebsiteNew( com.pomplatform.db.bean.BaseWebsiteNew bean, String additional ) throws Exception {

		WebsiteNew dao = new WebsiteNew();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseWebsiteNew> queryWebsiteNew( com.pomplatform.db.bean.BaseWebsiteNew bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		WebsiteNew dao = new WebsiteNew();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseWebsiteNew> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseWebsiteNew> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseWebsiteNew addToWebsiteNew ( BaseWebsiteNew websitenew )  throws Exception {
		return addToWebsiteNew ( websitenew , false);
	}

	public static BaseWebsiteNew addToWebsiteNew ( BaseWebsiteNew websitenew, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		WebsiteNew dao = new WebsiteNew();
		dao.setDataFromBase(websitenew);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseWebsiteNew addUpdateWebsiteNew ( BaseWebsiteNew websitenew ) throws Exception {
		return addUpdateWebsiteNew ( websitenew , false);
	}

	public static BaseWebsiteNew addUpdateWebsiteNew ( BaseWebsiteNew websitenew, boolean singleTransaction  ) throws Exception {
		if(websitenew.getWebsiteNewId() == null) return addToWebsiteNew(websitenew);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		WebsiteNew dao = new WebsiteNew();
		dao.setDataFromBase(websitenew);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(websitenew); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteWebsiteNew ( BaseWebsiteNew bean ) throws Exception {
		WebsiteNew dao = new WebsiteNew();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseWebsiteNew updateWebsiteNew ( BaseWebsiteNew websitenew ) throws Exception {
		WebsiteNew dao = new WebsiteNew();
		dao.setWebsiteNewId( websitenew.getWebsiteNewId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(websitenew);
			result = dao.update();
		}
		return result == 1 ? websitenew : null ;
	}

	public static BaseWebsiteNew updateWebsiteNewDirect( BaseWebsiteNew websitenew ) throws Exception {
		WebsiteNew dao = new WebsiteNew();
		int result = 0;
		dao.setDataFromBase(websitenew);
		result = dao.update();
		return result == 1 ? websitenew : null ;
	}

	public static int setDeleteConditions(BaseWebsiteNew bean, WebsiteNew dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getWebsiteNewId() != null) {
			dao.setConditionWebsiteNewId("=", bean.getWebsiteNewId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
			if(bean.getContent() != null) {
				dao.setConditionContent("=", bean.getContent());
				count++;
			}
			if(bean.getNewType() != null) {
				dao.setConditionNewType("=", bean.getNewType());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getOrderNum() != null) {
				dao.setConditionOrderNum("=", bean.getOrderNum());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseWebsiteNew bean, WebsiteNew dao){
		int count = 0;
		if(bean.getWebsiteNewId() != null) {
			dao.setConditionWebsiteNewId("=", bean.getWebsiteNewId());
			count++;
		}
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
			count++;
		}
		if(bean.getContent() != null) {
			if(bean.getContent().indexOf("%") >= 0)
				dao.setConditionContent("like", bean.getContent());
			else
				dao.setConditionContent("=", bean.getContent());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getNewType() != null) {
			dao.setConditionNewType("=", bean.getNewType());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getOrderNum() != null) {
			dao.setConditionOrderNum("=", bean.getOrderNum());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseWebsiteNew> rlist = new BaseCollection<>();
		BaseWebsiteNew bean = new BaseWebsiteNew();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		WebsiteNew dao = new WebsiteNew();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseWebsiteNew> result = dao.conditionalLoad(addtion);
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
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


