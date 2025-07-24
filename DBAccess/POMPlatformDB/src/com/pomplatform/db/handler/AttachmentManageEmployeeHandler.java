package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentManageEmployee;
import com.pomplatform.db.dao.AttachmentManageEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttachmentManageEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttachmentManageEmployeeHandler.class);

	public static BaseAttachmentManageEmployee getAttachmentManageEmployeeById( 
		java.lang.Integer attachment_manage_employee_id
	) throws Exception
	{
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setAttachmentManageEmployeeId(attachment_manage_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttachmentManageEmployeeExists( com.pomplatform.db.bean.BaseAttachmentManageEmployee bean, String additional ) throws Exception {

		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttachmentManageEmployee( com.pomplatform.db.bean.BaseAttachmentManageEmployee bean, String additional ) throws Exception {

		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttachmentManageEmployee> queryAttachmentManageEmployee( com.pomplatform.db.bean.BaseAttachmentManageEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttachmentManageEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttachmentManageEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttachmentManageEmployee addToAttachmentManageEmployee ( BaseAttachmentManageEmployee attachmentmanageemployee )  throws Exception {
		return addToAttachmentManageEmployee ( attachmentmanageemployee , false);
	}

	public static BaseAttachmentManageEmployee addToAttachmentManageEmployee ( BaseAttachmentManageEmployee attachmentmanageemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setDataFromBase(attachmentmanageemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttachmentManageEmployee addUpdateAttachmentManageEmployee ( BaseAttachmentManageEmployee attachmentmanageemployee ) throws Exception {
		return addUpdateAttachmentManageEmployee ( attachmentmanageemployee , false);
	}

	public static BaseAttachmentManageEmployee addUpdateAttachmentManageEmployee ( BaseAttachmentManageEmployee attachmentmanageemployee, boolean singleTransaction  ) throws Exception {
		if(attachmentmanageemployee.getAttachmentManageEmployeeId() == null) return addToAttachmentManageEmployee(attachmentmanageemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setDataFromBase(attachmentmanageemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attachmentmanageemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttachmentManageEmployee ( BaseAttachmentManageEmployee bean ) throws Exception {
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttachmentManageEmployee updateAttachmentManageEmployee ( BaseAttachmentManageEmployee attachmentmanageemployee ) throws Exception {
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setAttachmentManageEmployeeId( attachmentmanageemployee.getAttachmentManageEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attachmentmanageemployee);
			result = dao.update();
		}
		return result == 1 ? attachmentmanageemployee : null ;
	}

	public static BaseAttachmentManageEmployee updateAttachmentManageEmployeeDirect( BaseAttachmentManageEmployee attachmentmanageemployee ) throws Exception {
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		int result = 0;
		dao.setDataFromBase(attachmentmanageemployee);
		result = dao.update();
		return result == 1 ? attachmentmanageemployee : null ;
	}

	public static int setDeleteConditions(BaseAttachmentManageEmployee bean, AttachmentManageEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttachmentManageEmployeeId() != null) {
			dao.setConditionAttachmentManageEmployeeId("=", bean.getAttachmentManageEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAttachmentManageId() != null) {
				dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeType() != null) {
				dao.setConditionEmployeeType("=", bean.getEmployeeType());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttachmentManageEmployee bean, AttachmentManageEmployee dao){
		int count = 0;
		if(bean.getAttachmentManageEmployeeId() != null) {
			dao.setConditionAttachmentManageEmployeeId("=", bean.getAttachmentManageEmployeeId());
			count++;
		}
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeType() != null) {
			dao.setConditionEmployeeType("=", bean.getEmployeeType());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
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
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		bean.setDataFromJSON(json);
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttachmentManageEmployee> rlist = new BaseCollection<>();
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttachmentManageEmployee> result = dao.conditionalLoad(addtion);
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
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		bean.setDataFromJSON(json);
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		bean.setDataFromJSON(json);
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		bean.setDataFromJSON(json);
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttachmentManageEmployee bean = new BaseAttachmentManageEmployee();
		bean.setDataFromJSON(json);
		AttachmentManageEmployee dao = new AttachmentManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


