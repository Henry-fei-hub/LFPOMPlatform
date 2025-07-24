package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.dao.ContractReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractReceivableHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractReceivableHandler.class);

	public static BaseContractReceivable getContractReceivableById( 
		java.lang.Integer contract_receivable_id
	) throws Exception
	{
		ContractReceivable dao = new ContractReceivable();
		dao.setContractReceivableId(contract_receivable_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractReceivableExists( com.pomplatform.db.bean.BaseContractReceivable bean, String additional ) throws Exception {

		ContractReceivable dao = new ContractReceivable();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractReceivable( com.pomplatform.db.bean.BaseContractReceivable bean, String additional ) throws Exception {

		ContractReceivable dao = new ContractReceivable();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractReceivable> queryContractReceivable( com.pomplatform.db.bean.BaseContractReceivable bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractReceivable dao = new ContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractReceivable> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractReceivable> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractReceivable addToContractReceivable ( BaseContractReceivable contractreceivable )  throws Exception {
		return addToContractReceivable ( contractreceivable , false);
	}

	public static BaseContractReceivable addToContractReceivable ( BaseContractReceivable contractreceivable, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractReceivable dao = new ContractReceivable();
		dao.setDataFromBase(contractreceivable);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractReceivable addUpdateContractReceivable ( BaseContractReceivable contractreceivable ) throws Exception {
		return addUpdateContractReceivable ( contractreceivable , false);
	}

	public static BaseContractReceivable addUpdateContractReceivable ( BaseContractReceivable contractreceivable, boolean singleTransaction  ) throws Exception {
		if(contractreceivable.getContractReceivableId() == null) return addToContractReceivable(contractreceivable);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractReceivable dao = new ContractReceivable();
		dao.setDataFromBase(contractreceivable);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractreceivable); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractReceivable ( BaseContractReceivable bean ) throws Exception {
		ContractReceivable dao = new ContractReceivable();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractReceivable updateContractReceivable ( BaseContractReceivable contractreceivable ) throws Exception {
		ContractReceivable dao = new ContractReceivable();
		dao.setContractReceivableId( contractreceivable.getContractReceivableId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractreceivable);
			result = dao.update();
		}
		return result == 1 ? contractreceivable : null ;
	}

	public static BaseContractReceivable updateContractReceivableDirect( BaseContractReceivable contractreceivable ) throws Exception {
		ContractReceivable dao = new ContractReceivable();
		int result = 0;
		dao.setDataFromBase(contractreceivable);
		result = dao.update();
		return result == 1 ? contractreceivable : null ;
	}

	public static int setDeleteConditions(BaseContractReceivable bean, ContractReceivable dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
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
			if(bean.getReceivableName() != null) {
				dao.setConditionReceivableName("=", bean.getReceivableName());
				count++;
			}
			if(bean.getIsConfirmationLetter() != null) {
				dao.setConditionIsConfirmationLetter("=", bean.getIsConfirmationLetter());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractReceivable bean, ContractReceivable dao){
		int count = 0;
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
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
		if(bean.getReceivableName() != null) {
			if(bean.getReceivableName().indexOf("%") >= 0)
				dao.setConditionReceivableName("like", bean.getReceivableName());
			else
				dao.setConditionReceivableName("=", bean.getReceivableName());
			count++;
		}
		if(bean.getReceivablePercentage() != null) {
			dao.setConditionReceivablePercentage("=", bean.getReceivablePercentage());
			count++;
		}
		if(bean.getReceivableSumMoney() != null) {
			dao.setConditionReceivableSumMoney("=", bean.getReceivableSumMoney());
			count++;
		}
		if(bean.getIsConfirmationLetter() != null) {
			dao.setConditionIsConfirmationLetter("=", bean.getIsConfirmationLetter());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractReceivable bean = new BaseContractReceivable();
		bean.setDataFromJSON(json);
		ContractReceivable dao = new ContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractReceivable> rlist = new BaseCollection<>();
		BaseContractReceivable bean = new BaseContractReceivable();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractReceivable dao = new ContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractReceivable> result = dao.conditionalLoad(addtion);
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
		BaseContractReceivable bean = new BaseContractReceivable();
		bean.setDataFromJSON(json);
		ContractReceivable dao = new ContractReceivable();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractReceivable bean = new BaseContractReceivable();
		bean.setDataFromJSON(json);
		ContractReceivable dao = new ContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractReceivable bean = new BaseContractReceivable();
		bean.setDataFromJSON(json);
		ContractReceivable dao = new ContractReceivable();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractReceivable bean = new BaseContractReceivable();
		bean.setDataFromJSON(json);
		ContractReceivable dao = new ContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


