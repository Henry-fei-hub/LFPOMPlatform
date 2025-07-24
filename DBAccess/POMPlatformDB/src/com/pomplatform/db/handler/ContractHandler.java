package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseContract;
import java.util.List;
import com.pomplatform.db.dao.Contract;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ContractHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractHandler.class);

	public static BaseContract getContractById( 
		java.lang.Integer contract_id
	) throws Exception
	{
		Contract dao = new Contract();
		dao.setContractId(contract_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractExists( com.pomplatform.db.bean.BaseContract bean, String additional ) throws Exception {

		Contract dao = new Contract();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContract( com.pomplatform.db.bean.BaseContract bean, String additional ) throws Exception {

		Contract dao = new Contract();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContract> queryContract( com.pomplatform.db.bean.BaseContract bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Contract dao = new Contract();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContract> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContract> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContract addToContract ( BaseContract contract )  throws Exception {
		return addToContract ( contract , false);
	}

	public static BaseContract addToContract ( BaseContract contract, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Contract dao = new Contract();
		dao.setDataFromBase(contract);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContract addUpdateContract ( BaseContract contract ) throws Exception {
		return addUpdateContract ( contract , false);
	}

	public static BaseContract addUpdateContract ( BaseContract contract, boolean singleTransaction  ) throws Exception {
		if(contract.getContractId() == null) return addToContract(contract);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Contract dao = new Contract();
		dao.setDataFromBase(contract);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contract); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContract ( BaseContract bean ) throws Exception {
		Contract dao = new Contract();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContract updateContract ( BaseContract contract ) throws Exception {
		Contract dao = new Contract();
		dao.setContractId( contract.getContractId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contract);
			result = dao.update();
		}
		return result == 1 ? contract : null ;
	}

	public static BaseContract updateContractDirect( BaseContract contract ) throws Exception {
		Contract dao = new Contract();
		int result = 0;
		dao.setDataFromBase(contract);
		result = dao.update();
		return result == 1 ? contract : null ;
	}

	public static int setDeleteConditions(BaseContract bean, Contract dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractType() != null) {
				dao.setConditionContractType("=", bean.getContractType());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getTotalProjectTime() != null) {
				dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
				count++;
			}
			if(bean.getProjectAddress() != null) {
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
				count++;
			}
			if(bean.getContractFollower() != null) {
				dao.setConditionContractFollower("=", bean.getContractFollower());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSigningCompanyName() != null) {
				dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getFlowStatus() != null) {
				dao.setConditionFlowStatus("=", bean.getFlowStatus());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProfessionalCooperation() != null) {
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getDetailAddress() != null) {
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
				count++;
			}
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getServiceSuggestBook() != null) {
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getContractStatus() != null) {
				dao.setConditionContractStatus("=", bean.getContractStatus());
				count++;
			}
			if(bean.getClientContractId() != null) {
				dao.setConditionClientContractId("=", bean.getClientContractId());
				count++;
			}
			if(bean.getIsFinish() != null) {
				dao.setConditionIsFinish("=", bean.getIsFinish());
				count++;
			}
			if(bean.getIsSystemAdd() != null) {
				dao.setConditionIsSystemAdd("=", bean.getIsSystemAdd());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getAttachmentRemark() != null) {
				dao.setConditionAttachmentRemark("=", bean.getAttachmentRemark());
				count++;
			}
			if(bean.getFinancialContractCode() != null) {
				dao.setConditionFinancialContractCode("=", bean.getFinancialContractCode());
				count++;
			}
			if(bean.getContractArea() != null) {
				dao.setConditionContractArea("=", bean.getContractArea());
				count++;
			}
			if(bean.getCustomerId() != null) {
				dao.setConditionCustomerId("=", bean.getCustomerId());
				count++;
			}
			if(bean.getContractInfoAudited() != null) {
				dao.setConditionContractInfoAudited("=", bean.getContractInfoAudited());
				count++;
			}
			if(bean.getContractSigningStatus() != null) {
				dao.setConditionContractSigningStatus("=", bean.getContractSigningStatus());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getRelevantEmployees() != null) {
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
				count++;
			}
			if(bean.getRelevantEmployeesName() != null) {
				dao.setConditionRelevantEmployeesName("=", bean.getRelevantEmployeesName());
				count++;
			}
			if(bean.getServiceSuggestBookId() != null) {
				dao.setConditionServiceSuggestBookId("=", bean.getServiceSuggestBookId());
				count++;
			}
			if(bean.getContractYear() != null) {
				dao.setConditionContractYear("=", bean.getContractYear());
				count++;
			}
			if(bean.getCopyIncomeLedger() != null) {
				dao.setConditionCopyIncomeLedger("=", bean.getCopyIncomeLedger());
				count++;
			}
			if(bean.getIncomeLedgerNumber() != null) {
				dao.setConditionIncomeLedgerNumber("=", bean.getIncomeLedgerNumber());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContract bean, Contract dao){
		int count = 0;
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getContractType() != null) {
			dao.setConditionContractType("=", bean.getContractType());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getTotalProjectTime() != null) {
			dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getDesignAreas() != null) {
			dao.setConditionDesignAreas("=", bean.getDesignAreas());
			count++;
		}
		if(bean.getContractPrice() != null) {
			dao.setConditionContractPrice("=", bean.getContractPrice());
			count++;
		}
		if(bean.getProjectAddress() != null) {
			if(bean.getProjectAddress().indexOf("%") >= 0)
				dao.setConditionProjectAddress("like", bean.getProjectAddress());
			else
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
			count++;
		}
		if(bean.getContractFollower() != null) {
			dao.setConditionContractFollower("=", bean.getContractFollower());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getSigningCompanyName() != null) {
			dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getFlowStatus() != null) {
			dao.setConditionFlowStatus("=", bean.getFlowStatus());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			if(bean.getSerialNumber().indexOf("%") >= 0)
				dao.setConditionSerialNumber("like", bean.getSerialNumber());
			else
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getProjectType() != null) {
			if(bean.getProjectType().indexOf("%") >= 0)
				dao.setConditionProjectType("like", bean.getProjectType());
			else
				dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getCoveredArea() != null) {
			dao.setConditionCoveredArea("=", bean.getCoveredArea());
			count++;
		}
		if(bean.getProfessionalCooperation() != null) {
			if(bean.getProfessionalCooperation().indexOf("%") >= 0)
				dao.setConditionProfessionalCooperation("like", bean.getProfessionalCooperation());
			else
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
			count++;
		}
		if(bean.getProvince() != null) {
			if(bean.getProvince().indexOf("%") >= 0)
				dao.setConditionProvince("like", bean.getProvince());
			else
				dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getDetailAddress() != null) {
			if(bean.getDetailAddress().indexOf("%") >= 0)
				dao.setConditionDetailAddress("like", bean.getDetailAddress());
			else
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
			count++;
		}
		if(bean.getCustomerAddress() != null) {
			if(bean.getCustomerAddress().indexOf("%") >= 0)
				dao.setConditionCustomerAddress("like", bean.getCustomerAddress());
			else
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
			count++;
		}
		if(bean.getServiceSuggestBook() != null) {
			if(bean.getServiceSuggestBook().indexOf("%") >= 0)
				dao.setConditionServiceSuggestBook("like", bean.getServiceSuggestBook());
			else
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getContractStatus() != null) {
			dao.setConditionContractStatus("=", bean.getContractStatus());
			count++;
		}
		if(bean.getClientContractId() != null) {
			if(bean.getClientContractId().indexOf("%") >= 0)
				dao.setConditionClientContractId("like", bean.getClientContractId());
			else
				dao.setConditionClientContractId("=", bean.getClientContractId());
			count++;
		}
		if(bean.getIsFinish() != null) {
			dao.setConditionIsFinish("=", bean.getIsFinish());
			count++;
		}
		if(bean.getIsSystemAdd() != null) {
			dao.setConditionIsSystemAdd("=", bean.getIsSystemAdd());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getAttachmentRemark() != null) {
			if(bean.getAttachmentRemark().indexOf("%") >= 0)
				dao.setConditionAttachmentRemark("like", bean.getAttachmentRemark());
			else
				dao.setConditionAttachmentRemark("=", bean.getAttachmentRemark());
			count++;
		}
		if(bean.getFinancialContractCode() != null) {
			if(bean.getFinancialContractCode().indexOf("%") >= 0)
				dao.setConditionFinancialContractCode("like", bean.getFinancialContractCode());
			else
				dao.setConditionFinancialContractCode("=", bean.getFinancialContractCode());
			count++;
		}
		if(bean.getContractArea() != null) {
			dao.setConditionContractArea("=", bean.getContractArea());
			count++;
		}
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
		}
		if(bean.getContractInfoAudited() != null) {
			dao.setConditionContractInfoAudited("=", bean.getContractInfoAudited());
			count++;
		}
		if(bean.getContractSigningStatus() != null) {
			dao.setConditionContractSigningStatus("=", bean.getContractSigningStatus());
			count++;
		}
		if(bean.getSendingDate() != null) {
			dao.setConditionSendingDate(">=", bean.getSendingDate());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getRelevantEmployees() != null) {
			if(bean.getRelevantEmployees().indexOf("%") >= 0)
				dao.setConditionRelevantEmployees("like", bean.getRelevantEmployees());
			else
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
			count++;
		}
		if(bean.getRelevantEmployeesName() != null) {
			if(bean.getRelevantEmployeesName().indexOf("%") >= 0)
				dao.setConditionRelevantEmployeesName("like", bean.getRelevantEmployeesName());
			else
				dao.setConditionRelevantEmployeesName("=", bean.getRelevantEmployeesName());
			count++;
		}
		if(bean.getServiceSuggestBookId() != null) {
			dao.setConditionServiceSuggestBookId("=", bean.getServiceSuggestBookId());
			count++;
		}
		if(bean.getContractYear() != null) {
			dao.setConditionContractYear("=", bean.getContractYear());
			count++;
		}
		if(bean.getCopyIncomeLedger() != null) {
			dao.setConditionCopyIncomeLedger("=", bean.getCopyIncomeLedger());
			count++;
		}
		if(bean.getIncomeLedgerNumber() != null) {
			dao.setConditionIncomeLedgerNumber("=", bean.getIncomeLedgerNumber());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContract> rlist = new BaseCollection<>();
		BaseContract bean = new BaseContract();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Contract dao = new Contract();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContract> result = dao.conditionalLoad(addtion);
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
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


