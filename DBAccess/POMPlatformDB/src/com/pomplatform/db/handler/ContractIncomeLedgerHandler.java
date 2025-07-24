package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractIncomeLedger;
import com.pomplatform.db.dao.ContractIncomeLedger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractIncomeLedgerHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractIncomeLedgerHandler.class);

	public static BaseContractIncomeLedger getContractIncomeLedgerById( 
		java.lang.Integer contract_income_ledger_id
	) throws Exception
	{
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setContractIncomeLedgerId(contract_income_ledger_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractIncomeLedgerExists( com.pomplatform.db.bean.BaseContractIncomeLedger bean, String additional ) throws Exception {

		ContractIncomeLedger dao = new ContractIncomeLedger();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractIncomeLedger( com.pomplatform.db.bean.BaseContractIncomeLedger bean, String additional ) throws Exception {

		ContractIncomeLedger dao = new ContractIncomeLedger();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractIncomeLedger> queryContractIncomeLedger( com.pomplatform.db.bean.BaseContractIncomeLedger bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractIncomeLedger dao = new ContractIncomeLedger();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractIncomeLedger> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractIncomeLedger> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractIncomeLedger addToContractIncomeLedger ( BaseContractIncomeLedger contractincomeledger )  throws Exception {
		return addToContractIncomeLedger ( contractincomeledger , false);
	}

	public static BaseContractIncomeLedger addToContractIncomeLedger ( BaseContractIncomeLedger contractincomeledger, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setDataFromBase(contractincomeledger);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractIncomeLedger addUpdateContractIncomeLedger ( BaseContractIncomeLedger contractincomeledger ) throws Exception {
		return addUpdateContractIncomeLedger ( contractincomeledger , false);
	}

	public static BaseContractIncomeLedger addUpdateContractIncomeLedger ( BaseContractIncomeLedger contractincomeledger, boolean singleTransaction  ) throws Exception {
		if(contractincomeledger.getContractIncomeLedgerId() == null) return addToContractIncomeLedger(contractincomeledger);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setDataFromBase(contractincomeledger);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractincomeledger); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractIncomeLedger ( BaseContractIncomeLedger bean ) throws Exception {
		ContractIncomeLedger dao = new ContractIncomeLedger();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractIncomeLedger updateContractIncomeLedger ( BaseContractIncomeLedger contractincomeledger ) throws Exception {
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setContractIncomeLedgerId( contractincomeledger.getContractIncomeLedgerId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractincomeledger);
			result = dao.update();
		}
		return result == 1 ? contractincomeledger : null ;
	}

	public static BaseContractIncomeLedger updateContractIncomeLedgerDirect( BaseContractIncomeLedger contractincomeledger ) throws Exception {
		ContractIncomeLedger dao = new ContractIncomeLedger();
		int result = 0;
		dao.setDataFromBase(contractincomeledger);
		result = dao.update();
		return result == 1 ? contractincomeledger : null ;
	}

	public static int setDeleteConditions(BaseContractIncomeLedger bean, ContractIncomeLedger dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractIncomeLedgerId() != null) {
			dao.setConditionContractIncomeLedgerId("=", bean.getContractIncomeLedgerId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getClientId() != null) {
				dao.setConditionClientId("=", bean.getClientId());
				count++;
			}
			if(bean.getProjectManager() != null) {
				dao.setConditionProjectManager("=", bean.getProjectManager());
				count++;
			}
			if(bean.getPlateManager() != null) {
				dao.setConditionPlateManager("=", bean.getPlateManager());
				count++;
			}
			if(bean.getInvoiceDate() != null) {
				dao.setConditionInvoiceDate("=", bean.getInvoiceDate());
				count++;
			}
			if(bean.getInvoiceNumber() != null) {
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
				count++;
			}
			if(bean.getInvoiceStage() != null) {
				dao.setConditionInvoiceStage("=", bean.getInvoiceStage());
				count++;
			}
			if(bean.getCurrentReceiveDate() != null) {
				dao.setConditionCurrentReceiveDate("=", bean.getCurrentReceiveDate());
				count++;
			}
			if(bean.getCurrentReceiveRemark() != null) {
				dao.setConditionCurrentReceiveRemark("=", bean.getCurrentReceiveRemark());
				count++;
			}
			if(bean.getProjectStatus() != null) {
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getContacts() != null) {
				dao.setConditionContacts("=", bean.getContacts());
				count++;
			}
			if(bean.getLedgerYear() != null) {
				dao.setConditionLedgerYear("=", bean.getLedgerYear());
				count++;
			}
			if(bean.getLedgerMonth() != null) {
				dao.setConditionLedgerMonth("=", bean.getLedgerMonth());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractIncomeLedger bean, ContractIncomeLedger dao){
		int count = 0;
		if(bean.getContractIncomeLedgerId() != null) {
			dao.setConditionContractIncomeLedgerId("=", bean.getContractIncomeLedgerId());
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
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
		}
		if(bean.getProjectManager() != null) {
			if(bean.getProjectManager().indexOf("%") >= 0)
				dao.setConditionProjectManager("like", bean.getProjectManager());
			else
				dao.setConditionProjectManager("=", bean.getProjectManager());
			count++;
		}
		if(bean.getPlateManager() != null) {
			if(bean.getPlateManager().indexOf("%") >= 0)
				dao.setConditionPlateManager("like", bean.getPlateManager());
			else
				dao.setConditionPlateManager("=", bean.getPlateManager());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getReceiveContractAmount() != null) {
			dao.setConditionReceiveContractAmount("=", bean.getReceiveContractAmount());
			count++;
		}
		if(bean.getUnreceivedContractAmount() != null) {
			dao.setConditionUnreceivedContractAmount("=", bean.getUnreceivedContractAmount());
			count++;
		}
		if(bean.getInvoiceDate() != null) {
			if(bean.getInvoiceDate().indexOf("%") >= 0)
				dao.setConditionInvoiceDate("like", bean.getInvoiceDate());
			else
				dao.setConditionInvoiceDate("=", bean.getInvoiceDate());
			count++;
		}
		if(bean.getInvoiceNumber() != null) {
			if(bean.getInvoiceNumber().indexOf("%") >= 0)
				dao.setConditionInvoiceNumber("like", bean.getInvoiceNumber());
			else
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
			count++;
		}
		if(bean.getInvoiceStage() != null) {
			if(bean.getInvoiceStage().indexOf("%") >= 0)
				dao.setConditionInvoiceStage("like", bean.getInvoiceStage());
			else
				dao.setConditionInvoiceStage("=", bean.getInvoiceStage());
			count++;
		}
		if(bean.getInvoiceAmount() != null) {
			dao.setConditionInvoiceAmount("=", bean.getInvoiceAmount());
			count++;
		}
		if(bean.getCurrentReceiveAmount() != null) {
			dao.setConditionCurrentReceiveAmount("=", bean.getCurrentReceiveAmount());
			count++;
		}
		if(bean.getCurrentReceiveDate() != null) {
			if(bean.getCurrentReceiveDate().indexOf("%") >= 0)
				dao.setConditionCurrentReceiveDate("like", bean.getCurrentReceiveDate());
			else
				dao.setConditionCurrentReceiveDate("=", bean.getCurrentReceiveDate());
			count++;
		}
		if(bean.getCurrentReceiveRemark() != null) {
			if(bean.getCurrentReceiveRemark().indexOf("%") >= 0)
				dao.setConditionCurrentReceiveRemark("like", bean.getCurrentReceiveRemark());
			else
				dao.setConditionCurrentReceiveRemark("=", bean.getCurrentReceiveRemark());
			count++;
		}
		if(bean.getProjectStatus() != null) {
			if(bean.getProjectStatus().indexOf("%") >= 0)
				dao.setConditionProjectStatus("like", bean.getProjectStatus());
			else
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getContacts() != null) {
			if(bean.getContacts().indexOf("%") >= 0)
				dao.setConditionContacts("like", bean.getContacts());
			else
				dao.setConditionContacts("=", bean.getContacts());
			count++;
		}
		if(bean.getLedgerYear() != null) {
			dao.setConditionLedgerYear("=", bean.getLedgerYear());
			count++;
		}
		if(bean.getLedgerMonth() != null) {
			dao.setConditionLedgerMonth("=", bean.getLedgerMonth());
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
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		bean.setDataFromJSON(json);
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractIncomeLedger> rlist = new BaseCollection<>();
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractIncomeLedger dao = new ContractIncomeLedger();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractIncomeLedger> result = dao.conditionalLoad(addtion);
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
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		bean.setDataFromJSON(json);
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		bean.setDataFromJSON(json);
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		bean.setDataFromJSON(json);
		ContractIncomeLedger dao = new ContractIncomeLedger();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractIncomeLedger bean = new BaseContractIncomeLedger();
		bean.setDataFromJSON(json);
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


