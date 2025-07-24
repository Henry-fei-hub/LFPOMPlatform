package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.dao.Capital;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalHandler.class);

	public static BaseCapital getCapitalById( 
		java.lang.Integer capital_id
	) throws Exception
	{
		Capital dao = new Capital();
		dao.setCapitalId(capital_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalExists( com.pomplatform.db.bean.BaseCapital bean, String additional ) throws Exception {

		Capital dao = new Capital();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapital( com.pomplatform.db.bean.BaseCapital bean, String additional ) throws Exception {

		Capital dao = new Capital();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapital> queryCapital( com.pomplatform.db.bean.BaseCapital bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Capital dao = new Capital();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapital> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapital> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapital addToCapital ( BaseCapital capital )  throws Exception {
		return addToCapital ( capital , false);
	}

	public static BaseCapital addToCapital ( BaseCapital capital, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Capital dao = new Capital();
		dao.setDataFromBase(capital);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapital addUpdateCapital ( BaseCapital capital ) throws Exception {
		return addUpdateCapital ( capital , false);
	}

	public static BaseCapital addUpdateCapital ( BaseCapital capital, boolean singleTransaction  ) throws Exception {
		if(capital.getCapitalId() == null) return addToCapital(capital);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Capital dao = new Capital();
		dao.setDataFromBase(capital);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capital); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapital ( BaseCapital bean ) throws Exception {
		Capital dao = new Capital();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapital updateCapital ( BaseCapital capital ) throws Exception {
		Capital dao = new Capital();
		dao.setCapitalId( capital.getCapitalId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capital);
			result = dao.update();
		}
		return result == 1 ? capital : null ;
	}

	public static BaseCapital updateCapitalDirect( BaseCapital capital ) throws Exception {
		Capital dao = new Capital();
		int result = 0;
		dao.setDataFromBase(capital);
		result = dao.update();
		return result == 1 ? capital : null ;
	}

	public static int setDeleteConditions(BaseCapital bean, Capital dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getMoneyAttribute() != null) {
				dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
				count++;
			}
			if(bean.getSelfName() != null) {
				dao.setConditionSelfName("=", bean.getSelfName());
				count++;
			}
			if(bean.getSelfBankName() != null) {
				dao.setConditionSelfBankName("=", bean.getSelfBankName());
				count++;
			}
			if(bean.getSelfBankAccount() != null) {
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
				count++;
			}
			if(bean.getOtherName() != null) {
				dao.setConditionOtherName("=", bean.getOtherName());
				count++;
			}
			if(bean.getOtherBankName() != null) {
				dao.setConditionOtherBankName("=", bean.getOtherBankName());
				count++;
			}
			if(bean.getOtherBankAccount() != null) {
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getHasInvoices() != null) {
				dao.setConditionHasInvoices("=", bean.getHasInvoices());
				count++;
			}
			if(bean.getHasContractReceivable() != null) {
				dao.setConditionHasContractReceivable("=", bean.getHasContractReceivable());
				count++;
			}
			if(bean.getHasDistributionCollection() != null) {
				dao.setConditionHasDistributionCollection("=", bean.getHasDistributionCollection());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getCapitalType() != null) {
				dao.setConditionCapitalType("=", bean.getCapitalType());
				count++;
			}
			if(bean.getReimbursementPackageSummaryId() != null) {
				dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
			if(bean.getCapitalDistributionId() != null) {
				dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
				count++;
			}
			if(bean.getHaveVoucher() != null) {
				dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getRecordReceiveCapital() != null) {
				dao.setConditionRecordReceiveCapital("=", bean.getRecordReceiveCapital());
				count++;
			}
			if(bean.getIsPayback() != null) {
				dao.setConditionIsPayback("=", bean.getIsPayback());
				count++;
			}
			if(bean.getIsHavingInvoice() != null) {
				dao.setConditionIsHavingInvoice("=", bean.getIsHavingInvoice());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getReceiveUnitId() != null) {
				dao.setConditionReceiveUnitId("=", bean.getReceiveUnitId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapital bean, Capital dao){
		int count = 0;
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
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
		if(bean.getMoneyAttribute() != null) {
			dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
			count++;
		}
		if(bean.getSelfName() != null) {
			dao.setConditionSelfName("=", bean.getSelfName());
			count++;
		}
		if(bean.getSelfBankName() != null) {
			if(bean.getSelfBankName().indexOf("%") >= 0)
				dao.setConditionSelfBankName("like", bean.getSelfBankName());
			else
				dao.setConditionSelfBankName("=", bean.getSelfBankName());
			count++;
		}
		if(bean.getSelfBankAccount() != null) {
			if(bean.getSelfBankAccount().indexOf("%") >= 0)
				dao.setConditionSelfBankAccount("like", bean.getSelfBankAccount());
			else
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
			count++;
		}
		if(bean.getOtherName() != null) {
			if(bean.getOtherName().indexOf("%") >= 0)
				dao.setConditionOtherName("like", bean.getOtherName());
			else
				dao.setConditionOtherName("=", bean.getOtherName());
			count++;
		}
		if(bean.getOtherBankName() != null) {
			if(bean.getOtherBankName().indexOf("%") >= 0)
				dao.setConditionOtherBankName("like", bean.getOtherBankName());
			else
				dao.setConditionOtherBankName("=", bean.getOtherBankName());
			count++;
		}
		if(bean.getOtherBankAccount() != null) {
			if(bean.getOtherBankAccount().indexOf("%") >= 0)
				dao.setConditionOtherBankAccount("like", bean.getOtherBankAccount());
			else
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
			count++;
		}
		if(bean.getBorrowMoney() != null) {
			dao.setConditionBorrowMoney("=", bean.getBorrowMoney());
			count++;
		}
		if(bean.getLoanMoney() != null) {
			dao.setConditionLoanMoney("=", bean.getLoanMoney());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getHappenDate() != null) {
			dao.setConditionHappenDate(">=", bean.getHappenDate());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getHasInvoices() != null) {
			dao.setConditionHasInvoices("=", bean.getHasInvoices());
			count++;
		}
		if(bean.getHasContractReceivable() != null) {
			dao.setConditionHasContractReceivable("=", bean.getHasContractReceivable());
			count++;
		}
		if(bean.getHasDistributionCollection() != null) {
			dao.setConditionHasDistributionCollection("=", bean.getHasDistributionCollection());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCapitalType() != null) {
			dao.setConditionCapitalType("=", bean.getCapitalType());
			count++;
		}
		if(bean.getReimbursementPackageSummaryId() != null) {
			dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		if(bean.getCapitalDistributionId() != null) {
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
			count++;
		}
		if(bean.getHaveVoucher() != null) {
			dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getRecordReceiveCapital() != null) {
			dao.setConditionRecordReceiveCapital("=", bean.getRecordReceiveCapital());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getOriginalCurrency() != null) {
			dao.setConditionOriginalCurrency("=", bean.getOriginalCurrency());
			count++;
		}
		if(bean.getIsPayback() != null) {
			dao.setConditionIsPayback("=", bean.getIsPayback());
			count++;
		}
		if(bean.getIsHavingInvoice() != null) {
			dao.setConditionIsHavingInvoice("=", bean.getIsHavingInvoice());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getIssueDate() != null) {
			dao.setConditionIssueDate(">=", bean.getIssueDate());
			count++;
		}
		if(bean.getExpireDate() != null) {
			dao.setConditionExpireDate(">=", bean.getExpireDate());
			count++;
		}
		if(bean.getReceiveUnitId() != null) {
			dao.setConditionReceiveUnitId("=", bean.getReceiveUnitId());
			count++;
		}
		if(bean.getActualAmount() != null) {
			dao.setConditionActualAmount("=", bean.getActualAmount());
			count++;
		}
		if(bean.getActualReceiveDate() != null) {
			dao.setConditionActualReceiveDate(">=", bean.getActualReceiveDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapital> rlist = new BaseCollection<>();
		BaseCapital bean = new BaseCapital();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Capital dao = new Capital();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapital> result = dao.conditionalLoad(addtion);
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
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


