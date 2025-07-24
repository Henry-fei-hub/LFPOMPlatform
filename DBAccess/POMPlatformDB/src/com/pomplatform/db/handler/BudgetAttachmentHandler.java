package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.dao.BudgetAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BudgetAttachmentHandler.class);

	public static BaseBudgetAttachment getBudgetAttachmentById( 
		java.lang.Integer budget_attachment_id
	) throws Exception
	{
		BudgetAttachment dao = new BudgetAttachment();
		dao.setBudgetAttachmentId(budget_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBudgetAttachmentExists( com.pomplatform.db.bean.BaseBudgetAttachment bean, String additional ) throws Exception {

		BudgetAttachment dao = new BudgetAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBudgetAttachment( com.pomplatform.db.bean.BaseBudgetAttachment bean, String additional ) throws Exception {

		BudgetAttachment dao = new BudgetAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBudgetAttachment> queryBudgetAttachment( com.pomplatform.db.bean.BaseBudgetAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BudgetAttachment dao = new BudgetAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBudgetAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBudgetAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBudgetAttachment addToBudgetAttachment ( BaseBudgetAttachment budgetattachment )  throws Exception {
		return addToBudgetAttachment ( budgetattachment , false);
	}

	public static BaseBudgetAttachment addToBudgetAttachment ( BaseBudgetAttachment budgetattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BudgetAttachment dao = new BudgetAttachment();
		dao.setDataFromBase(budgetattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBudgetAttachment addUpdateBudgetAttachment ( BaseBudgetAttachment budgetattachment ) throws Exception {
		return addUpdateBudgetAttachment ( budgetattachment , false);
	}

	public static BaseBudgetAttachment addUpdateBudgetAttachment ( BaseBudgetAttachment budgetattachment, boolean singleTransaction  ) throws Exception {
		if(budgetattachment.getBudgetAttachmentId() == null) return addToBudgetAttachment(budgetattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BudgetAttachment dao = new BudgetAttachment();
		dao.setDataFromBase(budgetattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(budgetattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBudgetAttachment ( BaseBudgetAttachment bean ) throws Exception {
		BudgetAttachment dao = new BudgetAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBudgetAttachment updateBudgetAttachment ( BaseBudgetAttachment budgetattachment ) throws Exception {
		BudgetAttachment dao = new BudgetAttachment();
		dao.setBudgetAttachmentId( budgetattachment.getBudgetAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(budgetattachment);
			result = dao.update();
		}
		return result == 1 ? budgetattachment : null ;
	}

	public static BaseBudgetAttachment updateBudgetAttachmentDirect( BaseBudgetAttachment budgetattachment ) throws Exception {
		BudgetAttachment dao = new BudgetAttachment();
		int result = 0;
		dao.setDataFromBase(budgetattachment);
		result = dao.update();
		return result == 1 ? budgetattachment : null ;
	}

	public static int setDeleteConditions(BaseBudgetAttachment bean, BudgetAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetAttachmentId() != null) {
			dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getUploadEmployeeId() != null) {
				dao.setConditionUploadEmployeeId("=", bean.getUploadEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getUploadRemark() != null) {
				dao.setConditionUploadRemark("=", bean.getUploadRemark());
				count++;
			}
			if(bean.getReceiveUnitManageId() != null) {
				dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getInputTaxInvoiceId() != null) {
				dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
				count++;
			}
			if(bean.getBddType() != null) {
				dao.setConditionBddType("=", bean.getBddType());
				count++;
			}
			if(bean.getIsApproval() != null) {
				dao.setConditionIsApproval("=", bean.getIsApproval());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetAttachment bean, BudgetAttachment dao){
		int count = 0;
		if(bean.getBudgetAttachmentId() != null) {
			dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getUploadEmployeeId() != null) {
			dao.setConditionUploadEmployeeId("=", bean.getUploadEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getUploadTime() != null) {
			dao.setConditionUploadTime(">=", bean.getUploadTime());
			count++;
		}
		if(bean.getUploadRemark() != null) {
			if(bean.getUploadRemark().indexOf("%") >= 0)
				dao.setConditionUploadRemark("like", bean.getUploadRemark());
			else
				dao.setConditionUploadRemark("=", bean.getUploadRemark());
			count++;
		}
		if(bean.getBudgetContractAmount() != null) {
			dao.setConditionBudgetContractAmount("=", bean.getBudgetContractAmount());
			count++;
		}
		if(bean.getBudgetContractAmountUse() != null) {
			dao.setConditionBudgetContractAmountUse("=", bean.getBudgetContractAmountUse());
			count++;
		}
		if(bean.getBudgetContractAmountRest() != null) {
			dao.setConditionBudgetContractAmountRest("=", bean.getBudgetContractAmountRest());
			count++;
		}
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getInputTaxInvoiceId() != null) {
			dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
			count++;
		}
		if(bean.getBddType() != null) {
			if(bean.getBddType().indexOf("%") >= 0)
				dao.setConditionBddType("like", bean.getBddType());
			else
				dao.setConditionBddType("=", bean.getBddType());
			count++;
		}
		if(bean.getIsApproval() != null) {
			dao.setConditionIsApproval("=", bean.getIsApproval());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		bean.setDataFromJSON(json);
		BudgetAttachment dao = new BudgetAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetAttachment> rlist = new BaseCollection<>();
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetAttachment dao = new BudgetAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetAttachment> result = dao.conditionalLoad(addtion);
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
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		bean.setDataFromJSON(json);
		BudgetAttachment dao = new BudgetAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		bean.setDataFromJSON(json);
		BudgetAttachment dao = new BudgetAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		bean.setDataFromJSON(json);
		BudgetAttachment dao = new BudgetAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetAttachment bean = new BaseBudgetAttachment();
		bean.setDataFromJSON(json);
		BudgetAttachment dao = new BudgetAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


