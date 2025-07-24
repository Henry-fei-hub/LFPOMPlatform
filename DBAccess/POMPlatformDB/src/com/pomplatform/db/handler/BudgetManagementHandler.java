package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.dao.BudgetManagement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetManagementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BudgetManagementHandler.class);

	public static BaseBudgetManagement getBudgetManagementById( 
		java.lang.Integer budget_management_id
	) throws Exception
	{
		BudgetManagement dao = new BudgetManagement();
		dao.setBudgetManagementId(budget_management_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBudgetManagementExists( com.pomplatform.db.bean.BaseBudgetManagement bean, String additional ) throws Exception {

		BudgetManagement dao = new BudgetManagement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBudgetManagement( com.pomplatform.db.bean.BaseBudgetManagement bean, String additional ) throws Exception {

		BudgetManagement dao = new BudgetManagement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBudgetManagement> queryBudgetManagement( com.pomplatform.db.bean.BaseBudgetManagement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BudgetManagement dao = new BudgetManagement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBudgetManagement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBudgetManagement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBudgetManagement addToBudgetManagement ( BaseBudgetManagement budgetmanagement )  throws Exception {
		return addToBudgetManagement ( budgetmanagement , false);
	}

	public static BaseBudgetManagement addToBudgetManagement ( BaseBudgetManagement budgetmanagement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BudgetManagement dao = new BudgetManagement();
		dao.setDataFromBase(budgetmanagement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBudgetManagement addUpdateBudgetManagement ( BaseBudgetManagement budgetmanagement ) throws Exception {
		return addUpdateBudgetManagement ( budgetmanagement , false);
	}

	public static BaseBudgetManagement addUpdateBudgetManagement ( BaseBudgetManagement budgetmanagement, boolean singleTransaction  ) throws Exception {
		if(budgetmanagement.getBudgetManagementId() == null) return addToBudgetManagement(budgetmanagement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BudgetManagement dao = new BudgetManagement();
		dao.setDataFromBase(budgetmanagement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(budgetmanagement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBudgetManagement ( BaseBudgetManagement bean ) throws Exception {
		BudgetManagement dao = new BudgetManagement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBudgetManagement updateBudgetManagement ( BaseBudgetManagement budgetmanagement ) throws Exception {
		BudgetManagement dao = new BudgetManagement();
		dao.setBudgetManagementId( budgetmanagement.getBudgetManagementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(budgetmanagement);
			result = dao.update();
		}
		return result == 1 ? budgetmanagement : null ;
	}

	public static BaseBudgetManagement updateBudgetManagementDirect( BaseBudgetManagement budgetmanagement ) throws Exception {
		BudgetManagement dao = new BudgetManagement();
		int result = 0;
		dao.setDataFromBase(budgetmanagement);
		result = dao.update();
		return result == 1 ? budgetmanagement : null ;
	}

	public static int setDeleteConditions(BaseBudgetManagement bean, BudgetManagement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBdCode() != null) {
				dao.setConditionBdCode("=", bean.getBdCode());
				count++;
			}
			if(bean.getBdType() != null) {
				dao.setConditionBdType("=", bean.getBdType());
				count++;
			}
			if(bean.getBdApplyEmployeeId() != null) {
				dao.setConditionBdApplyEmployeeId("=", bean.getBdApplyEmployeeId());
				count++;
			}
			if(bean.getBdStatus() != null) {
				dao.setConditionBdStatus("=", bean.getBdStatus());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getBdRemark() != null) {
				dao.setConditionBdRemark("=", bean.getBdRemark());
				count++;
			}
			if(bean.getInputTaxInvoiceId() != null) {
				dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCostBearing() != null) {
				dao.setConditionCostBearing("=", bean.getCostBearing());
				count++;
			}
			if(bean.getOutSourceType() != null) {
				dao.setConditionOutSourceType("=", bean.getOutSourceType());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getBdAttachmentName() != null) {
				dao.setConditionBdAttachmentName("=", bean.getBdAttachmentName());
				count++;
			}
			if(bean.getBdUploadRemark() != null) {
				dao.setConditionBdUploadRemark("=", bean.getBdUploadRemark());
				count++;
			}
			if(bean.getBdSupplierPerson() != null) {
				dao.setConditionBdSupplierPerson("=", bean.getBdSupplierPerson());
				count++;
			}
			if(bean.getBdSupplierCompany() != null) {
				dao.setConditionBdSupplierCompany("=", bean.getBdSupplierCompany());
				count++;
			}
			if(bean.getIsProcess() != null) {
				dao.setConditionIsProcess("=", bean.getIsProcess());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetManagement bean, BudgetManagement dao){
		int count = 0;
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBdCode() != null) {
			if(bean.getBdCode().indexOf("%") >= 0)
				dao.setConditionBdCode("like", bean.getBdCode());
			else
				dao.setConditionBdCode("=", bean.getBdCode());
			count++;
		}
		if(bean.getBdType() != null) {
			dao.setConditionBdType("=", bean.getBdType());
			count++;
		}
		if(bean.getBdTotalAmount() != null) {
			dao.setConditionBdTotalAmount("=", bean.getBdTotalAmount());
			count++;
		}
		if(bean.getBdUseAmount() != null) {
			dao.setConditionBdUseAmount("=", bean.getBdUseAmount());
			count++;
		}
		if(bean.getBdRestAmount() != null) {
			dao.setConditionBdRestAmount("=", bean.getBdRestAmount());
			count++;
		}
		if(bean.getBdApplyEmployeeId() != null) {
			dao.setConditionBdApplyEmployeeId("=", bean.getBdApplyEmployeeId());
			count++;
		}
		if(bean.getBdApplyTime() != null) {
			dao.setConditionBdApplyTime(">=", bean.getBdApplyTime());
			count++;
		}
		if(bean.getBdEstimatecloseTime() != null) {
			dao.setConditionBdEstimatecloseTime(">=", bean.getBdEstimatecloseTime());
			count++;
		}
		if(bean.getBdStatus() != null) {
			dao.setConditionBdStatus("=", bean.getBdStatus());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getBdRemark() != null) {
			if(bean.getBdRemark().indexOf("%") >= 0)
				dao.setConditionBdRemark("like", bean.getBdRemark());
			else
				dao.setConditionBdRemark("=", bean.getBdRemark());
			count++;
		}
		if(bean.getInputTaxInvoiceId() != null) {
			dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCostBearing() != null) {
			if(bean.getCostBearing().indexOf("%") >= 0)
				dao.setConditionCostBearing("like", bean.getCostBearing());
			else
				dao.setConditionCostBearing("=", bean.getCostBearing());
			count++;
		}
		if(bean.getOutSourceType() != null) {
			dao.setConditionOutSourceType("=", bean.getOutSourceType());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getBdAttachmentName() != null) {
			if(bean.getBdAttachmentName().indexOf("%") >= 0)
				dao.setConditionBdAttachmentName("like", bean.getBdAttachmentName());
			else
				dao.setConditionBdAttachmentName("=", bean.getBdAttachmentName());
			count++;
		}
		if(bean.getBdUploadRemark() != null) {
			if(bean.getBdUploadRemark().indexOf("%") >= 0)
				dao.setConditionBdUploadRemark("like", bean.getBdUploadRemark());
			else
				dao.setConditionBdUploadRemark("=", bean.getBdUploadRemark());
			count++;
		}
		if(bean.getBdSupplierPerson() != null) {
			if(bean.getBdSupplierPerson().indexOf("%") >= 0)
				dao.setConditionBdSupplierPerson("like", bean.getBdSupplierPerson());
			else
				dao.setConditionBdSupplierPerson("=", bean.getBdSupplierPerson());
			count++;
		}
		if(bean.getBdSupplierCompany() != null) {
			if(bean.getBdSupplierCompany().indexOf("%") >= 0)
				dao.setConditionBdSupplierCompany("like", bean.getBdSupplierCompany());
			else
				dao.setConditionBdSupplierCompany("=", bean.getBdSupplierCompany());
			count++;
		}
		if(bean.getIsProcess() != null) {
			dao.setConditionIsProcess("=", bean.getIsProcess());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetManagement bean = new BaseBudgetManagement();
		bean.setDataFromJSON(json);
		BudgetManagement dao = new BudgetManagement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetManagement> rlist = new BaseCollection<>();
		BaseBudgetManagement bean = new BaseBudgetManagement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetManagement dao = new BudgetManagement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetManagement> result = dao.conditionalLoad(addtion);
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
		BaseBudgetManagement bean = new BaseBudgetManagement();
		bean.setDataFromJSON(json);
		BudgetManagement dao = new BudgetManagement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetManagement bean = new BaseBudgetManagement();
		bean.setDataFromJSON(json);
		BudgetManagement dao = new BudgetManagement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetManagement bean = new BaseBudgetManagement();
		bean.setDataFromJSON(json);
		BudgetManagement dao = new BudgetManagement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetManagement bean = new BaseBudgetManagement();
		bean.setDataFromJSON(json);
		BudgetManagement dao = new BudgetManagement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


