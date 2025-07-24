package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import java.util.List;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectNormalReimbursementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectNormalReimbursementHandler.class);

	public static BaseProjectNormalReimbursement getProjectNormalReimbursementById( 
		java.lang.Integer project_normal_reimbursement_id
	) throws Exception
	{
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setProjectNormalReimbursementId(project_normal_reimbursement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectNormalReimbursementExists( com.pomplatform.db.bean.BaseProjectNormalReimbursement bean, String additional ) throws Exception {

		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectNormalReimbursement( com.pomplatform.db.bean.BaseProjectNormalReimbursement bean, String additional ) throws Exception {

		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectNormalReimbursement> queryProjectNormalReimbursement( com.pomplatform.db.bean.BaseProjectNormalReimbursement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectNormalReimbursement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectNormalReimbursement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectNormalReimbursement addToProjectNormalReimbursement ( BaseProjectNormalReimbursement projectnormalreimbursement )  throws Exception {
		return addToProjectNormalReimbursement ( projectnormalreimbursement , false);
	}

	public static BaseProjectNormalReimbursement addToProjectNormalReimbursement ( BaseProjectNormalReimbursement projectnormalreimbursement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setDataFromBase(projectnormalreimbursement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectNormalReimbursement addUpdateProjectNormalReimbursement ( BaseProjectNormalReimbursement projectnormalreimbursement ) throws Exception {
		return addUpdateProjectNormalReimbursement ( projectnormalreimbursement , false);
	}

	public static BaseProjectNormalReimbursement addUpdateProjectNormalReimbursement ( BaseProjectNormalReimbursement projectnormalreimbursement, boolean singleTransaction  ) throws Exception {
		if(projectnormalreimbursement.getProjectNormalReimbursementId() == null) return addToProjectNormalReimbursement(projectnormalreimbursement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setDataFromBase(projectnormalreimbursement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectnormalreimbursement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectNormalReimbursement ( BaseProjectNormalReimbursement bean ) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectNormalReimbursement updateProjectNormalReimbursement ( BaseProjectNormalReimbursement projectnormalreimbursement ) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setProjectNormalReimbursementId( projectnormalreimbursement.getProjectNormalReimbursementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectnormalreimbursement);
			result = dao.update();
		}
		return result == 1 ? projectnormalreimbursement : null ;
	}

	public static BaseProjectNormalReimbursement updateProjectNormalReimbursementDirect( BaseProjectNormalReimbursement projectnormalreimbursement ) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		int result = 0;
		dao.setDataFromBase(projectnormalreimbursement);
		result = dao.update();
		return result == 1 ? projectnormalreimbursement : null ;
	}

	public static int setDeleteConditions(BaseProjectNormalReimbursement bean, ProjectNormalReimbursement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
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
			if(bean.getReimbursementName() != null) {
				dao.setConditionReimbursementName("=", bean.getReimbursementName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getStrikeABalance() != null) {
				dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
			if(bean.getAttachmentNumber() != null) {
				dao.setConditionAttachmentNumber("=", bean.getAttachmentNumber());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getIsProject() != null) {
				dao.setConditionIsProject("=", bean.getIsProject());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getReceiveUnitManageId() != null) {
				dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
				count++;
			}
			if(bean.getCurrency() != null) {
				dao.setConditionCurrency("=", bean.getCurrency());
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
			if(bean.getFeeType() != null) {
				dao.setConditionFeeType("=", bean.getFeeType());
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
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getRelatedToContract() != null) {
				dao.setConditionRelatedToContract("=", bean.getRelatedToContract());
				count++;
			}
			if(bean.getReceiveUnitId() != null) {
				dao.setConditionReceiveUnitId("=", bean.getReceiveUnitId());
				count++;
			}
			if(bean.getPurchaserDepartment() != null) {
				dao.setConditionPurchaserDepartment("=", bean.getPurchaserDepartment());
				count++;
			}
			if(bean.getPurchaser() != null) {
				dao.setConditionPurchaser("=", bean.getPurchaser());
				count++;
			}
			if(bean.getPurchasingCategory() != null) {
				dao.setConditionPurchasingCategory("=", bean.getPurchasingCategory());
				count++;
			}
			if(bean.getReimbursementType() != null) {
				dao.setConditionReimbursementType("=", bean.getReimbursementType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectNormalReimbursement bean, ProjectNormalReimbursement dao){
		int count = 0;
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
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
		if(bean.getReimbursementName() != null) {
			if(bean.getReimbursementName().indexOf("%") >= 0)
				dao.setConditionReimbursementName("like", bean.getReimbursementName());
			else
				dao.setConditionReimbursementName("=", bean.getReimbursementName());
			count++;
		}
		if(bean.getReimbursementTime() != null) {
			dao.setConditionReimbursementTime(">=", bean.getReimbursementTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getApplyTime() != null) {
			dao.setConditionApplyTime(">=", bean.getApplyTime());
			count++;
		}
		if(bean.getCompleteTime() != null) {
			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getStrikeABalance() != null) {
			dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		if(bean.getAttachmentNumber() != null) {
			dao.setConditionAttachmentNumber("=", bean.getAttachmentNumber());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getIsProject() != null) {
			dao.setConditionIsProject("=", bean.getIsProject());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getCurrency() != null) {
			dao.setConditionCurrency("=", bean.getCurrency());
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
		if(bean.getFeeType() != null) {
			dao.setConditionFeeType("=", bean.getFeeType());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
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
		if(bean.getWhiteStrip() != null) {
			dao.setConditionWhiteStrip("=", bean.getWhiteStrip());
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
		if(bean.getRelatedToContract() != null) {
			dao.setConditionRelatedToContract("=", bean.getRelatedToContract());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getReceiveUnitId() != null) {
			dao.setConditionReceiveUnitId("=", bean.getReceiveUnitId());
			count++;
		}
		if(bean.getPurchaserDepartment() != null) {
			dao.setConditionPurchaserDepartment("=", bean.getPurchaserDepartment());
			count++;
		}
		if(bean.getPurchaser() != null) {
			dao.setConditionPurchaser("=", bean.getPurchaser());
			count++;
		}
		if(bean.getPurchasingCategory() != null) {
			if(bean.getPurchasingCategory().indexOf("%") >= 0)
				dao.setConditionPurchasingCategory("like", bean.getPurchasingCategory());
			else
				dao.setConditionPurchasingCategory("=", bean.getPurchasingCategory());
			count++;
		}
		if(bean.getReimbursementType() != null) {
			dao.setConditionReimbursementType("=", bean.getReimbursementType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectNormalReimbursement> rlist = new BaseCollection<>();
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectNormalReimbursement> result = dao.conditionalLoad(addtion);
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
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectNormalReimbursement bean = new BaseProjectNormalReimbursement();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


