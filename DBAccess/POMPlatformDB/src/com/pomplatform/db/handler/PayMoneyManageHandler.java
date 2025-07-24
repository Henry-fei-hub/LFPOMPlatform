package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePayMoneyManage;
import java.util.List;
import com.pomplatform.db.dao.PayMoneyManage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PayMoneyManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PayMoneyManageHandler.class);

	public static BasePayMoneyManage getPayMoneyManageById( 
		java.lang.Integer pay_money_manage_id
	) throws Exception
	{
		PayMoneyManage dao = new PayMoneyManage();
		dao.setPayMoneyManageId(pay_money_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPayMoneyManageExists( com.pomplatform.db.bean.BasePayMoneyManage bean, String additional ) throws Exception {

		PayMoneyManage dao = new PayMoneyManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPayMoneyManage( com.pomplatform.db.bean.BasePayMoneyManage bean, String additional ) throws Exception {

		PayMoneyManage dao = new PayMoneyManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePayMoneyManage> queryPayMoneyManage( com.pomplatform.db.bean.BasePayMoneyManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PayMoneyManage dao = new PayMoneyManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePayMoneyManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePayMoneyManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePayMoneyManage addToPayMoneyManage ( BasePayMoneyManage paymoneymanage )  throws Exception {
		return addToPayMoneyManage ( paymoneymanage , false);
	}

	public static BasePayMoneyManage addToPayMoneyManage ( BasePayMoneyManage paymoneymanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PayMoneyManage dao = new PayMoneyManage();
		dao.setDataFromBase(paymoneymanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePayMoneyManage addUpdatePayMoneyManage ( BasePayMoneyManage paymoneymanage ) throws Exception {
		return addUpdatePayMoneyManage ( paymoneymanage , false);
	}

	public static BasePayMoneyManage addUpdatePayMoneyManage ( BasePayMoneyManage paymoneymanage, boolean singleTransaction  ) throws Exception {
		if(paymoneymanage.getPayMoneyManageId() == null) return addToPayMoneyManage(paymoneymanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PayMoneyManage dao = new PayMoneyManage();
		dao.setDataFromBase(paymoneymanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(paymoneymanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePayMoneyManage ( BasePayMoneyManage bean ) throws Exception {
		PayMoneyManage dao = new PayMoneyManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePayMoneyManage updatePayMoneyManage ( BasePayMoneyManage paymoneymanage ) throws Exception {
		PayMoneyManage dao = new PayMoneyManage();
		dao.setPayMoneyManageId( paymoneymanage.getPayMoneyManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(paymoneymanage);
			result = dao.update();
		}
		return result == 1 ? paymoneymanage : null ;
	}

	public static BasePayMoneyManage updatePayMoneyManageDirect( BasePayMoneyManage paymoneymanage ) throws Exception {
		PayMoneyManage dao = new PayMoneyManage();
		int result = 0;
		dao.setDataFromBase(paymoneymanage);
		result = dao.update();
		return result == 1 ? paymoneymanage : null ;
	}

	public static int setDeleteConditions(BasePayMoneyManage bean, PayMoneyManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPayMoneyManageId() != null) {
			dao.setConditionPayMoneyManageId("=", bean.getPayMoneyManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReceiveUnit() != null) {
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
			if(bean.getTitleName() != null) {
				dao.setConditionTitleName("=", bean.getTitleName());
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
			if(bean.getAttachmentFile() != null) {
				dao.setConditionAttachmentFile("=", bean.getAttachmentFile());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
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
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getUseOfFund() != null) {
				dao.setConditionUseOfFund("=", bean.getUseOfFund());
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

	public static int setConditions(BasePayMoneyManage bean, PayMoneyManage dao){
		int count = 0;
		if(bean.getPayMoneyManageId() != null) {
			dao.setConditionPayMoneyManageId("=", bean.getPayMoneyManageId());
			count++;
		}
		if(bean.getReceiveUnit() != null) {
			if(bean.getReceiveUnit().indexOf("%") >= 0)
				dao.setConditionReceiveUnit("like", bean.getReceiveUnit());
			else
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		if(bean.getTitleName() != null) {
			if(bean.getTitleName().indexOf("%") >= 0)
				dao.setConditionTitleName("like", bean.getTitleName());
			else
				dao.setConditionTitleName("=", bean.getTitleName());
			count++;
		}
		if(bean.getPayAmount() != null) {
			dao.setConditionPayAmount("=", bean.getPayAmount());
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
		if(bean.getAttachmentFile() != null) {
			if(bean.getAttachmentFile().indexOf("%") >= 0)
				dao.setConditionAttachmentFile("like", bean.getAttachmentFile());
			else
				dao.setConditionAttachmentFile("=", bean.getAttachmentFile());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
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
		if(bean.getUseOfFund() != null) {
			dao.setConditionUseOfFund("=", bean.getUseOfFund());
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
		BasePayMoneyManage bean = new BasePayMoneyManage();
		bean.setDataFromJSON(json);
		PayMoneyManage dao = new PayMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePayMoneyManage> rlist = new BaseCollection<>();
		BasePayMoneyManage bean = new BasePayMoneyManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PayMoneyManage dao = new PayMoneyManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePayMoneyManage> result = dao.conditionalLoad(addtion);
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
		BasePayMoneyManage bean = new BasePayMoneyManage();
		bean.setDataFromJSON(json);
		PayMoneyManage dao = new PayMoneyManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePayMoneyManage bean = new BasePayMoneyManage();
		bean.setDataFromJSON(json);
		PayMoneyManage dao = new PayMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePayMoneyManage bean = new BasePayMoneyManage();
		bean.setDataFromJSON(json);
		PayMoneyManage dao = new PayMoneyManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePayMoneyManage bean = new BasePayMoneyManage();
		bean.setDataFromJSON(json);
		PayMoneyManage dao = new PayMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


