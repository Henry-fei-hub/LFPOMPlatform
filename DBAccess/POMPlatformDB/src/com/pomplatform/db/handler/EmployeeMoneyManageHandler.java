package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.dao.EmployeeMoneyManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeMoneyManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeMoneyManageHandler.class);

	public static BaseEmployeeMoneyManage getEmployeeMoneyManageById( 
		java.lang.Integer employee_money_manage_id
	) throws Exception
	{
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setEmployeeMoneyManageId(employee_money_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeMoneyManageExists( com.pomplatform.db.bean.BaseEmployeeMoneyManage bean, String additional ) throws Exception {

		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeMoneyManage( com.pomplatform.db.bean.BaseEmployeeMoneyManage bean, String additional ) throws Exception {

		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeMoneyManage> queryEmployeeMoneyManage( com.pomplatform.db.bean.BaseEmployeeMoneyManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeMoneyManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeMoneyManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeMoneyManage addToEmployeeMoneyManage ( BaseEmployeeMoneyManage employeemoneymanage )  throws Exception {
		return addToEmployeeMoneyManage ( employeemoneymanage , false);
	}

	public static BaseEmployeeMoneyManage addToEmployeeMoneyManage ( BaseEmployeeMoneyManage employeemoneymanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setDataFromBase(employeemoneymanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeMoneyManage addUpdateEmployeeMoneyManage ( BaseEmployeeMoneyManage employeemoneymanage ) throws Exception {
		return addUpdateEmployeeMoneyManage ( employeemoneymanage , false);
	}

	public static BaseEmployeeMoneyManage addUpdateEmployeeMoneyManage ( BaseEmployeeMoneyManage employeemoneymanage, boolean singleTransaction  ) throws Exception {
		if(employeemoneymanage.getEmployeeMoneyManageId() == null) return addToEmployeeMoneyManage(employeemoneymanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setDataFromBase(employeemoneymanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeemoneymanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeMoneyManage ( BaseEmployeeMoneyManage bean ) throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeMoneyManage updateEmployeeMoneyManage ( BaseEmployeeMoneyManage employeemoneymanage ) throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setEmployeeMoneyManageId( employeemoneymanage.getEmployeeMoneyManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeemoneymanage);
			result = dao.update();
		}
		return result == 1 ? employeemoneymanage : null ;
	}

	public static BaseEmployeeMoneyManage updateEmployeeMoneyManageDirect( BaseEmployeeMoneyManage employeemoneymanage ) throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		int result = 0;
		dao.setDataFromBase(employeemoneymanage);
		result = dao.update();
		return result == 1 ? employeemoneymanage : null ;
	}

	public static int setDeleteConditions(BaseEmployeeMoneyManage bean, EmployeeMoneyManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeMoneyManageId() != null) {
			dao.setConditionEmployeeMoneyManageId("=", bean.getEmployeeMoneyManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getTitleName() != null) {
				dao.setConditionTitleName("=", bean.getTitleName());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getFalg() != null) {
				dao.setConditionFalg("=", bean.getFalg());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
				count++;
			}
			if(bean.getBePacked() != null) {
				dao.setConditionBePacked("=", bean.getBePacked());
				count++;
			}
			if(bean.getVoucherNo() != null) {
				dao.setConditionVoucherNo("=", bean.getVoucherNo());
				count++;
			}
			if(bean.getEquivalentNumber() != null) {
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
				count++;
			}
			if(bean.getCurrency() != null) {
				dao.setConditionCurrency("=", bean.getCurrency());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getPaymentSequenceId() != null) {
				dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
				count++;
			}
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getBudgetAttachmentId() != null) {
				dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeMoneyManage bean, EmployeeMoneyManage dao){
		int count = 0;
		if(bean.getEmployeeMoneyManageId() != null) {
			dao.setConditionEmployeeMoneyManageId("=", bean.getEmployeeMoneyManageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getBorrowMoney() != null) {
			dao.setConditionBorrowMoney("=", bean.getBorrowMoney());
			count++;
		}
		if(bean.getReturnMoney() != null) {
			dao.setConditionReturnMoney("=", bean.getReturnMoney());
			count++;
		}
		if(bean.getBorrowDate() != null) {
			dao.setConditionBorrowDate(">=", bean.getBorrowDate());
			count++;
		}
		if(bean.getAnticipatedDate() != null) {
			dao.setConditionAnticipatedDate(">=", bean.getAnticipatedDate());
			count++;
		}
		if(bean.getReturnDate() != null) {
			dao.setConditionReturnDate(">=", bean.getReturnDate());
			count++;
		}
		if(bean.getTitleName() != null) {
			if(bean.getTitleName().indexOf("%") >= 0)
				dao.setConditionTitleName("like", bean.getTitleName());
			else
				dao.setConditionTitleName("=", bean.getTitleName());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getFalg() != null) {
			dao.setConditionFalg("=", bean.getFalg());
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
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
			count++;
		}
		if(bean.getBePacked() != null) {
			dao.setConditionBePacked("=", bean.getBePacked());
			count++;
		}
		if(bean.getVoucherNo() != null) {
			if(bean.getVoucherNo().indexOf("%") >= 0)
				dao.setConditionVoucherNo("like", bean.getVoucherNo());
			else
				dao.setConditionVoucherNo("=", bean.getVoucherNo());
			count++;
		}
		if(bean.getPostingDate() != null) {
			dao.setConditionPostingDate(">=", bean.getPostingDate());
			count++;
		}
		if(bean.getEquivalentNumber() != null) {
			if(bean.getEquivalentNumber().indexOf("%") >= 0)
				dao.setConditionEquivalentNumber("like", bean.getEquivalentNumber());
			else
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
			count++;
		}
		if(bean.getCurrency() != null) {
			dao.setConditionCurrency("=", bean.getCurrency());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getPaymentSequenceId() != null) {
			dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBudgetAttachmentId() != null) {
			dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		bean.setDataFromJSON(json);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeMoneyManage> rlist = new BaseCollection<>();
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeMoneyManage> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		bean.setDataFromJSON(json);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		bean.setDataFromJSON(json);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		bean.setDataFromJSON(json);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
		bean.setDataFromJSON(json);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


