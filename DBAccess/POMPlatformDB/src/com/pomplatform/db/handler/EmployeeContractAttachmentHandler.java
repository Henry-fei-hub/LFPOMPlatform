package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeContractAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeContractAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeContractAttachmentHandler.class);

	public static BaseEmployeeContractAttachment getEmployeeContractAttachmentById( 
		java.lang.Integer employee_contract_attachment_id
	) throws Exception
	{
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setEmployeeContractAttachmentId(employee_contract_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeContractAttachmentExists( com.pomplatform.db.bean.BaseEmployeeContractAttachment bean, String additional ) throws Exception {

		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeContractAttachment( com.pomplatform.db.bean.BaseEmployeeContractAttachment bean, String additional ) throws Exception {

		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeContractAttachment> queryEmployeeContractAttachment( com.pomplatform.db.bean.BaseEmployeeContractAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeContractAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeContractAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeContractAttachment addToEmployeeContractAttachment ( BaseEmployeeContractAttachment employeecontractattachment )  throws Exception {
		return addToEmployeeContractAttachment ( employeecontractattachment , false);
	}

	public static BaseEmployeeContractAttachment addToEmployeeContractAttachment ( BaseEmployeeContractAttachment employeecontractattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setDataFromBase(employeecontractattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeContractAttachment addUpdateEmployeeContractAttachment ( BaseEmployeeContractAttachment employeecontractattachment ) throws Exception {
		return addUpdateEmployeeContractAttachment ( employeecontractattachment , false);
	}

	public static BaseEmployeeContractAttachment addUpdateEmployeeContractAttachment ( BaseEmployeeContractAttachment employeecontractattachment, boolean singleTransaction  ) throws Exception {
		if(employeecontractattachment.getEmployeeContractAttachmentId() == null) return addToEmployeeContractAttachment(employeecontractattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setDataFromBase(employeecontractattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecontractattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeContractAttachment ( BaseEmployeeContractAttachment bean ) throws Exception {
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeContractAttachment updateEmployeeContractAttachment ( BaseEmployeeContractAttachment employeecontractattachment ) throws Exception {
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setEmployeeContractAttachmentId( employeecontractattachment.getEmployeeContractAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecontractattachment);
			result = dao.update();
		}
		return result == 1 ? employeecontractattachment : null ;
	}

	public static BaseEmployeeContractAttachment updateEmployeeContractAttachmentDirect( BaseEmployeeContractAttachment employeecontractattachment ) throws Exception {
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		int result = 0;
		dao.setDataFromBase(employeecontractattachment);
		result = dao.update();
		return result == 1 ? employeecontractattachment : null ;
	}

	public static int setDeleteConditions(BaseEmployeeContractAttachment bean, EmployeeContractAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeContractAttachmentId() != null) {
			dao.setConditionEmployeeContractAttachmentId("=", bean.getEmployeeContractAttachmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getAttachmentUrl() != null) {
				dao.setConditionAttachmentUrl("=", bean.getAttachmentUrl());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getContractType() != null) {
				dao.setConditionContractType("=", bean.getContractType());
				count++;
			}
			if(bean.getSignType() != null) {
				dao.setConditionSignType("=", bean.getSignType());
				count++;
			}
			if(bean.getWillEnd() != null) {
				dao.setConditionWillEnd("=", bean.getWillEnd());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeStatus() != null) {
				dao.setConditionEmployeeStatus("=", bean.getEmployeeStatus());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeContractAttachment bean, EmployeeContractAttachment dao){
		int count = 0;
		if(bean.getEmployeeContractAttachmentId() != null) {
			dao.setConditionEmployeeContractAttachmentId("=", bean.getEmployeeContractAttachmentId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getAttachmentUrl() != null) {
			if(bean.getAttachmentUrl().indexOf("%") >= 0)
				dao.setConditionAttachmentUrl("like", bean.getAttachmentUrl());
			else
				dao.setConditionAttachmentUrl("=", bean.getAttachmentUrl());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getContractType() != null) {
			dao.setConditionContractType("=", bean.getContractType());
			count++;
		}
		if(bean.getSignType() != null) {
			dao.setConditionSignType("=", bean.getSignType());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getWillEnd() != null) {
			dao.setConditionWillEnd("=", bean.getWillEnd());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getOnboardDate() != null) {
			dao.setConditionOnboardDate(">=", bean.getOnboardDate());
			count++;
		}
		if(bean.getEmployeeStatus() != null) {
			dao.setConditionEmployeeStatus("=", bean.getEmployeeStatus());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromJSON(json);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeContractAttachment> rlist = new BaseCollection<>();
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeContractAttachment> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromJSON(json);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromJSON(json);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromJSON(json);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromJSON(json);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


