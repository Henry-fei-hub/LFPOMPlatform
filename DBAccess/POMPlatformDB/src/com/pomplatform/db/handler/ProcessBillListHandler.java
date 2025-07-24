package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.dao.ProcessBillList;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProcessBillListHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProcessBillListHandler.class);

	public static BaseProcessBillList getProcessBillListById( 
		java.lang.Integer process_bill_list_id
	) throws Exception
	{
		ProcessBillList dao = new ProcessBillList();
		dao.setProcessBillListId(process_bill_list_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProcessBillListExists( com.pomplatform.db.bean.BaseProcessBillList bean, String additional ) throws Exception {

		ProcessBillList dao = new ProcessBillList();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProcessBillList( com.pomplatform.db.bean.BaseProcessBillList bean, String additional ) throws Exception {

		ProcessBillList dao = new ProcessBillList();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProcessBillList> queryProcessBillList( com.pomplatform.db.bean.BaseProcessBillList bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProcessBillList dao = new ProcessBillList();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProcessBillList> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProcessBillList> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProcessBillList addToProcessBillList ( BaseProcessBillList processbilllist )  throws Exception {
		return addToProcessBillList ( processbilllist , false);
	}

	public static BaseProcessBillList addToProcessBillList ( BaseProcessBillList processbilllist, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProcessBillList dao = new ProcessBillList();
		dao.setDataFromBase(processbilllist);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProcessBillList addUpdateProcessBillList ( BaseProcessBillList processbilllist ) throws Exception {
		return addUpdateProcessBillList ( processbilllist , false);
	}

	public static BaseProcessBillList addUpdateProcessBillList ( BaseProcessBillList processbilllist, boolean singleTransaction  ) throws Exception {
		if(processbilllist.getProcessBillListId() == null) return addToProcessBillList(processbilllist);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProcessBillList dao = new ProcessBillList();
		dao.setDataFromBase(processbilllist);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(processbilllist); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProcessBillList ( BaseProcessBillList bean ) throws Exception {
		ProcessBillList dao = new ProcessBillList();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProcessBillList updateProcessBillList ( BaseProcessBillList processbilllist ) throws Exception {
		ProcessBillList dao = new ProcessBillList();
		dao.setProcessBillListId( processbilllist.getProcessBillListId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(processbilllist);
			result = dao.update();
		}
		return result == 1 ? processbilllist : null ;
	}

	public static BaseProcessBillList updateProcessBillListDirect( BaseProcessBillList processbilllist ) throws Exception {
		ProcessBillList dao = new ProcessBillList();
		int result = 0;
		dao.setDataFromBase(processbilllist);
		result = dao.update();
		return result == 1 ? processbilllist : null ;
	}

	public static int setDeleteConditions(BaseProcessBillList bean, ProcessBillList dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProcessBillListId() != null) {
			dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
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
			if(bean.getPayFor() != null) {
				dao.setConditionPayFor("=", bean.getPayFor());
				count++;
			}
			if(bean.getEmployeeOrCompanyId() != null) {
				dao.setConditionEmployeeOrCompanyId("=", bean.getEmployeeOrCompanyId());
				count++;
			}
			if(bean.getMoneyAttribute() != null) {
				dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
				count++;
			}
			if(bean.getPayeeName() != null) {
				dao.setConditionPayeeName("=", bean.getPayeeName());
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
			if(bean.getIsComplete() != null) {
				dao.setConditionIsComplete("=", bean.getIsComplete());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getEquivalentNumber() != null) {
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getPayType() != null) {
				dao.setConditionPayType("=", bean.getPayType());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getFundraisingProjectTypeId() != null) {
				dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
				count++;
			}
			if(bean.getEmployeeFundIssuanceId() != null) {
				dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProcessBillList bean, ProcessBillList dao){
		int count = 0;
		if(bean.getProcessBillListId() != null) {
			dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
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
		if(bean.getPayFor() != null) {
			dao.setConditionPayFor("=", bean.getPayFor());
			count++;
		}
		if(bean.getEmployeeOrCompanyId() != null) {
			dao.setConditionEmployeeOrCompanyId("=", bean.getEmployeeOrCompanyId());
			count++;
		}
		if(bean.getMoneyAttribute() != null) {
			dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
			count++;
		}
		if(bean.getPayeeName() != null) {
			if(bean.getPayeeName().indexOf("%") >= 0)
				dao.setConditionPayeeName("like", bean.getPayeeName());
			else
				dao.setConditionPayeeName("=", bean.getPayeeName());
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
		if(bean.getPayMoney() != null) {
			dao.setConditionPayMoney("=", bean.getPayMoney());
			count++;
		}
		if(bean.getBalanceAmount() != null) {
			dao.setConditionBalanceAmount("=", bean.getBalanceAmount());
			count++;
		}
		if(bean.getIsComplete() != null) {
			dao.setConditionIsComplete("=", bean.getIsComplete());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getEquivalentNumber() != null) {
			if(bean.getEquivalentNumber().indexOf("%") >= 0)
				dao.setConditionEquivalentNumber("like", bean.getEquivalentNumber());
			else
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getPayType() != null) {
			dao.setConditionPayType("=", bean.getPayType());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getFundraisingProjectTypeId() != null) {
			dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
			count++;
		}
		if(bean.getEmployeeFundIssuanceId() != null) {
			dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProcessBillList bean = new BaseProcessBillList();
		bean.setDataFromJSON(json);
		ProcessBillList dao = new ProcessBillList();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProcessBillList> rlist = new BaseCollection<>();
		BaseProcessBillList bean = new BaseProcessBillList();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProcessBillList dao = new ProcessBillList();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProcessBillList> result = dao.conditionalLoad(addtion);
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
		BaseProcessBillList bean = new BaseProcessBillList();
		bean.setDataFromJSON(json);
		ProcessBillList dao = new ProcessBillList();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProcessBillList bean = new BaseProcessBillList();
		bean.setDataFromJSON(json);
		ProcessBillList dao = new ProcessBillList();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProcessBillList bean = new BaseProcessBillList();
		bean.setDataFromJSON(json);
		ProcessBillList dao = new ProcessBillList();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProcessBillList bean = new BaseProcessBillList();
		bean.setDataFromJSON(json);
		ProcessBillList dao = new ProcessBillList();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


