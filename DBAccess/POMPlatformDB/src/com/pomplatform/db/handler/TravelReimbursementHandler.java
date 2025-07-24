package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import java.util.List;
import com.pomplatform.db.dao.TravelReimbursement;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class TravelReimbursementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementHandler.class);

	public static BaseTravelReimbursement getTravelReimbursementById( 
		java.lang.Integer travel_reimbursement_id
	) throws Exception
	{
		TravelReimbursement dao = new TravelReimbursement();
		dao.setTravelReimbursementId(travel_reimbursement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTravelReimbursementExists( com.pomplatform.db.bean.BaseTravelReimbursement bean, String additional ) throws Exception {

		TravelReimbursement dao = new TravelReimbursement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTravelReimbursement( com.pomplatform.db.bean.BaseTravelReimbursement bean, String additional ) throws Exception {

		TravelReimbursement dao = new TravelReimbursement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTravelReimbursement> queryTravelReimbursement( com.pomplatform.db.bean.BaseTravelReimbursement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTravelReimbursement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTravelReimbursement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTravelReimbursement addToTravelReimbursement ( BaseTravelReimbursement travelreimbursement )  throws Exception {
		return addToTravelReimbursement ( travelreimbursement , false);
	}

	public static BaseTravelReimbursement addToTravelReimbursement ( BaseTravelReimbursement travelreimbursement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TravelReimbursement dao = new TravelReimbursement();
		dao.setDataFromBase(travelreimbursement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTravelReimbursement addUpdateTravelReimbursement ( BaseTravelReimbursement travelreimbursement ) throws Exception {
		return addUpdateTravelReimbursement ( travelreimbursement , false);
	}

	public static BaseTravelReimbursement addUpdateTravelReimbursement ( BaseTravelReimbursement travelreimbursement, boolean singleTransaction  ) throws Exception {
		if(travelreimbursement.getTravelReimbursementId() == null) return addToTravelReimbursement(travelreimbursement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TravelReimbursement dao = new TravelReimbursement();
		dao.setDataFromBase(travelreimbursement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(travelreimbursement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTravelReimbursement ( BaseTravelReimbursement bean ) throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTravelReimbursement updateTravelReimbursement ( BaseTravelReimbursement travelreimbursement ) throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		dao.setTravelReimbursementId( travelreimbursement.getTravelReimbursementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(travelreimbursement);
			result = dao.update();
		}
		return result == 1 ? travelreimbursement : null ;
	}

	public static BaseTravelReimbursement updateTravelReimbursementDirect( BaseTravelReimbursement travelreimbursement ) throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		int result = 0;
		dao.setDataFromBase(travelreimbursement);
		result = dao.update();
		return result == 1 ? travelreimbursement : null ;
	}

	public static int setDeleteConditions(BaseTravelReimbursement bean, TravelReimbursement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
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
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getApplicant() != null) {
				dao.setConditionApplicant("=", bean.getApplicant());
				count++;
			}
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getStrikeABalance() != null) {
				dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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
		}
		return count;
	}

	public static int setConditions(BaseTravelReimbursement bean, TravelReimbursement dao){
		int count = 0;
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
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
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getApplicant() != null) {
			dao.setConditionApplicant("=", bean.getApplicant());
			count++;
		}
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getReimbursementTime() != null) {
			dao.setConditionReimbursementTime(">=", bean.getReimbursementTime());
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
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getStrikeABalance() != null) {
			dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		bean.setDataFromJSON(json);
		TravelReimbursement dao = new TravelReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTravelReimbursement> rlist = new BaseCollection<>();
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TravelReimbursement dao = new TravelReimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTravelReimbursement> result = dao.conditionalLoad(addtion);
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
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		bean.setDataFromJSON(json);
		TravelReimbursement dao = new TravelReimbursement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		bean.setDataFromJSON(json);
		TravelReimbursement dao = new TravelReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		bean.setDataFromJSON(json);
		TravelReimbursement dao = new TravelReimbursement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTravelReimbursement bean = new BaseTravelReimbursement();
		bean.setDataFromJSON(json);
		TravelReimbursement dao = new TravelReimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


