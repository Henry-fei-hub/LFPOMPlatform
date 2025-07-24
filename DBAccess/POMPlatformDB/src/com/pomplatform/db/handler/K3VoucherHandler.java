package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseK3Voucher;
import com.pomplatform.db.dao.K3Voucher;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class K3VoucherHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(K3VoucherHandler.class);

	public static BaseK3Voucher getK3VoucherById( 
		java.lang.Integer k3_voucher_id
	) throws Exception
	{
		K3Voucher dao = new K3Voucher();
		dao.setK3VoucherId(k3_voucher_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isK3VoucherExists( com.pomplatform.db.bean.BaseK3Voucher bean, String additional ) throws Exception {

		K3Voucher dao = new K3Voucher();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countK3Voucher( com.pomplatform.db.bean.BaseK3Voucher bean, String additional ) throws Exception {

		K3Voucher dao = new K3Voucher();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseK3Voucher> queryK3Voucher( com.pomplatform.db.bean.BaseK3Voucher bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		K3Voucher dao = new K3Voucher();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseK3Voucher> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseK3Voucher> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseK3Voucher addToK3Voucher ( BaseK3Voucher k3voucher )  throws Exception {
		return addToK3Voucher ( k3voucher , false);
	}

	public static BaseK3Voucher addToK3Voucher ( BaseK3Voucher k3voucher, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		K3Voucher dao = new K3Voucher();
		dao.setDataFromBase(k3voucher);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseK3Voucher addUpdateK3Voucher ( BaseK3Voucher k3voucher ) throws Exception {
		return addUpdateK3Voucher ( k3voucher , false);
	}

	public static BaseK3Voucher addUpdateK3Voucher ( BaseK3Voucher k3voucher, boolean singleTransaction  ) throws Exception {
		if(k3voucher.getK3VoucherId() == null) return addToK3Voucher(k3voucher);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		K3Voucher dao = new K3Voucher();
		dao.setDataFromBase(k3voucher);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(k3voucher); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteK3Voucher ( BaseK3Voucher bean ) throws Exception {
		K3Voucher dao = new K3Voucher();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseK3Voucher updateK3Voucher ( BaseK3Voucher k3voucher ) throws Exception {
		K3Voucher dao = new K3Voucher();
		dao.setK3VoucherId( k3voucher.getK3VoucherId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(k3voucher);
			result = dao.update();
		}
		return result == 1 ? k3voucher : null ;
	}

	public static BaseK3Voucher updateK3VoucherDirect( BaseK3Voucher k3voucher ) throws Exception {
		K3Voucher dao = new K3Voucher();
		int result = 0;
		dao.setDataFromBase(k3voucher);
		result = dao.update();
		return result == 1 ? k3voucher : null ;
	}

	public static int setDeleteConditions(BaseK3Voucher bean, K3Voucher dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getK3VoucherId() != null) {
			dao.setConditionK3VoucherId("=", bean.getK3VoucherId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getSequenceNumber() != null) {
				dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
				count++;
			}
			if(bean.getInternalSequenceNumber() != null) {
				dao.setConditionInternalSequenceNumber("=", bean.getInternalSequenceNumber());
				count++;
			}
			if(bean.getCodeType() != null) {
				dao.setConditionCodeType("=", bean.getCodeType());
				count++;
			}
			if(bean.getCodeId() != null) {
				dao.setConditionCodeId("=", bean.getCodeId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getSecondaryCodeType() != null) {
				dao.setConditionSecondaryCodeType("=", bean.getSecondaryCodeType());
				count++;
			}
			if(bean.getSecondaryCodeId() != null) {
				dao.setConditionSecondaryCodeId("=", bean.getSecondaryCodeId());
				count++;
			}
			if(bean.getSecondaryCode() != null) {
				dao.setConditionSecondaryCode("=", bean.getSecondaryCode());
				count++;
			}
			if(bean.getSecondaryName() != null) {
				dao.setConditionSecondaryName("=", bean.getSecondaryName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSimplifyRemark() != null) {
				dao.setConditionSimplifyRemark("=", bean.getSimplifyRemark());
				count++;
			}
			if(bean.getReimbursementPackageCode() != null) {
				dao.setConditionReimbursementPackageCode("=", bean.getReimbursementPackageCode());
				count++;
			}
			if(bean.getSelfBankAccount() != null) {
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
				count++;
			}
			if(bean.getOtherBankAccount() != null) {
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
				count++;
			}
			if(bean.getNeedToChange() != null) {
				dao.setConditionNeedToChange("=", bean.getNeedToChange());
				count++;
			}
			if(bean.getLocked() != null) {
				dao.setConditionLocked("=", bean.getLocked());
				count++;
			}
			if(bean.getVoucherType() != null) {
				dao.setConditionVoucherType("=", bean.getVoucherType());
				count++;
			}
			if(bean.getLinkId() != null) {
				dao.setConditionLinkId("=", bean.getLinkId());
				count++;
			}
			if(bean.getAdditionalLinkId() != null) {
				dao.setConditionAdditionalLinkId("=", bean.getAdditionalLinkId());
				count++;
			}
			if(bean.getVoucherYear() != null) {
				dao.setConditionVoucherYear("=", bean.getVoucherYear());
				count++;
			}
			if(bean.getVoucherMonth() != null) {
				dao.setConditionVoucherMonth("=", bean.getVoucherMonth());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getReimbursementPackageId() != null) {
				dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseK3Voucher bean, K3Voucher dao){
		int count = 0;
		if(bean.getK3VoucherId() != null) {
			dao.setConditionK3VoucherId("=", bean.getK3VoucherId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getSequenceNumber() != null) {
			dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
			count++;
		}
		if(bean.getInternalSequenceNumber() != null) {
			dao.setConditionInternalSequenceNumber("=", bean.getInternalSequenceNumber());
			count++;
		}
		if(bean.getCodeType() != null) {
			dao.setConditionCodeType("=", bean.getCodeType());
			count++;
		}
		if(bean.getCodeId() != null) {
			dao.setConditionCodeId("=", bean.getCodeId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getSecondaryCodeType() != null) {
			dao.setConditionSecondaryCodeType("=", bean.getSecondaryCodeType());
			count++;
		}
		if(bean.getSecondaryCodeId() != null) {
			dao.setConditionSecondaryCodeId("=", bean.getSecondaryCodeId());
			count++;
		}
		if(bean.getSecondaryCode() != null) {
			if(bean.getSecondaryCode().indexOf("%") >= 0)
				dao.setConditionSecondaryCode("like", bean.getSecondaryCode());
			else
				dao.setConditionSecondaryCode("=", bean.getSecondaryCode());
			count++;
		}
		if(bean.getSecondaryName() != null) {
			if(bean.getSecondaryName().indexOf("%") >= 0)
				dao.setConditionSecondaryName("like", bean.getSecondaryName());
			else
				dao.setConditionSecondaryName("=", bean.getSecondaryName());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getSimplifyRemark() != null) {
			if(bean.getSimplifyRemark().indexOf("%") >= 0)
				dao.setConditionSimplifyRemark("like", bean.getSimplifyRemark());
			else
				dao.setConditionSimplifyRemark("=", bean.getSimplifyRemark());
			count++;
		}
		if(bean.getDebitSide() != null) {
			dao.setConditionDebitSide("=", bean.getDebitSide());
			count++;
		}
		if(bean.getCreditSide() != null) {
			dao.setConditionCreditSide("=", bean.getCreditSide());
			count++;
		}
		if(bean.getReimbursementPackageCode() != null) {
			if(bean.getReimbursementPackageCode().indexOf("%") >= 0)
				dao.setConditionReimbursementPackageCode("like", bean.getReimbursementPackageCode());
			else
				dao.setConditionReimbursementPackageCode("=", bean.getReimbursementPackageCode());
			count++;
		}
		if(bean.getAmountOfReimbursement() != null) {
			dao.setConditionAmountOfReimbursement("=", bean.getAmountOfReimbursement());
			count++;
		}
		if(bean.getInputTax() != null) {
			dao.setConditionInputTax("=", bean.getInputTax());
			count++;
		}
		if(bean.getSelfBankAccount() != null) {
			if(bean.getSelfBankAccount().indexOf("%") >= 0)
				dao.setConditionSelfBankAccount("like", bean.getSelfBankAccount());
			else
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
			count++;
		}
		if(bean.getOtherBankAccount() != null) {
			if(bean.getOtherBankAccount().indexOf("%") >= 0)
				dao.setConditionOtherBankAccount("like", bean.getOtherBankAccount());
			else
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
			count++;
		}
		if(bean.getNeedToChange() != null) {
			dao.setConditionNeedToChange("=", bean.getNeedToChange());
			count++;
		}
		if(bean.getVestingDate() != null) {
			dao.setConditionVestingDate(">=", bean.getVestingDate());
			count++;
		}
		if(bean.getLocked() != null) {
			dao.setConditionLocked("=", bean.getLocked());
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
		if(bean.getLockedTime() != null) {
			dao.setConditionLockedTime(">=", bean.getLockedTime());
			count++;
		}
		if(bean.getVoucherType() != null) {
			dao.setConditionVoucherType("=", bean.getVoucherType());
			count++;
		}
		if(bean.getLinkId() != null) {
			dao.setConditionLinkId("=", bean.getLinkId());
			count++;
		}
		if(bean.getAdditionalLinkId() != null) {
			dao.setConditionAdditionalLinkId("=", bean.getAdditionalLinkId());
			count++;
		}
		if(bean.getInputTaxRebate() != null) {
			dao.setConditionInputTaxRebate("=", bean.getInputTaxRebate());
			count++;
		}
		if(bean.getVoucherYear() != null) {
			dao.setConditionVoucherYear("=", bean.getVoucherYear());
			count++;
		}
		if(bean.getVoucherMonth() != null) {
			dao.setConditionVoucherMonth("=", bean.getVoucherMonth());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseK3Voucher bean = new BaseK3Voucher();
		bean.setDataFromJSON(json);
		K3Voucher dao = new K3Voucher();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseK3Voucher> rlist = new BaseCollection<>();
		BaseK3Voucher bean = new BaseK3Voucher();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		K3Voucher dao = new K3Voucher();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseK3Voucher> result = dao.conditionalLoad(addtion);
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
		BaseK3Voucher bean = new BaseK3Voucher();
		bean.setDataFromJSON(json);
		K3Voucher dao = new K3Voucher();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseK3Voucher bean = new BaseK3Voucher();
		bean.setDataFromJSON(json);
		K3Voucher dao = new K3Voucher();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseK3Voucher bean = new BaseK3Voucher();
		bean.setDataFromJSON(json);
		K3Voucher dao = new K3Voucher();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseK3Voucher bean = new BaseK3Voucher();
		bean.setDataFromJSON(json);
		K3Voucher dao = new K3Voucher();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


