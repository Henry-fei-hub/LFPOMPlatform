package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractChange;
import com.pomplatform.db.dao.ContractChange;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractChangeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractChangeHandler.class);

	public static BaseContractChange getContractChangeById( 
		java.lang.Integer contract_change_id
	) throws Exception
	{
		ContractChange dao = new ContractChange();
		dao.setContractChangeId(contract_change_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractChangeExists( com.pomplatform.db.bean.BaseContractChange bean, String additional ) throws Exception {

		ContractChange dao = new ContractChange();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractChange( com.pomplatform.db.bean.BaseContractChange bean, String additional ) throws Exception {

		ContractChange dao = new ContractChange();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractChange> queryContractChange( com.pomplatform.db.bean.BaseContractChange bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractChange dao = new ContractChange();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractChange> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractChange> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractChange addToContractChange ( BaseContractChange contractchange )  throws Exception {
		return addToContractChange ( contractchange , false);
	}

	public static BaseContractChange addToContractChange ( BaseContractChange contractchange, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractChange dao = new ContractChange();
		dao.setDataFromBase(contractchange);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractChange addUpdateContractChange ( BaseContractChange contractchange ) throws Exception {
		return addUpdateContractChange ( contractchange , false);
	}

	public static BaseContractChange addUpdateContractChange ( BaseContractChange contractchange, boolean singleTransaction  ) throws Exception {
		if(contractchange.getContractChangeId() == null) return addToContractChange(contractchange);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractChange dao = new ContractChange();
		dao.setDataFromBase(contractchange);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractchange); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractChange ( BaseContractChange bean ) throws Exception {
		ContractChange dao = new ContractChange();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractChange updateContractChange ( BaseContractChange contractchange ) throws Exception {
		ContractChange dao = new ContractChange();
		dao.setContractChangeId( contractchange.getContractChangeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractchange);
			result = dao.update();
		}
		return result == 1 ? contractchange : null ;
	}

	public static BaseContractChange updateContractChangeDirect( BaseContractChange contractchange ) throws Exception {
		ContractChange dao = new ContractChange();
		int result = 0;
		dao.setDataFromBase(contractchange);
		result = dao.update();
		return result == 1 ? contractchange : null ;
	}

	public static int setDeleteConditions(BaseContractChange bean, ContractChange dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractChangeId() != null) {
			dao.setConditionContractChangeId("=", bean.getContractChangeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractChangeView() != null) {
				dao.setConditionContractChangeView("=", bean.getContractChangeView());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractChange bean, ContractChange dao){
		int count = 0;
		if(bean.getContractChangeId() != null) {
			dao.setConditionContractChangeId("=", bean.getContractChangeId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getContractChangeAmount() != null) {
			dao.setConditionContractChangeAmount("=", bean.getContractChangeAmount());
			count++;
		}
		if(bean.getContractFinalAmount() != null) {
			dao.setConditionContractFinalAmount("=", bean.getContractFinalAmount());
			count++;
		}
		if(bean.getContractChangeView() != null) {
			if(bean.getContractChangeView().indexOf("%") >= 0)
				dao.setConditionContractChangeView("like", bean.getContractChangeView());
			else
				dao.setConditionContractChangeView("=", bean.getContractChangeView());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
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
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractChange bean = new BaseContractChange();
		bean.setDataFromJSON(json);
		ContractChange dao = new ContractChange();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractChange> rlist = new BaseCollection<>();
		BaseContractChange bean = new BaseContractChange();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractChange dao = new ContractChange();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractChange> result = dao.conditionalLoad(addtion);
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
		BaseContractChange bean = new BaseContractChange();
		bean.setDataFromJSON(json);
		ContractChange dao = new ContractChange();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractChange bean = new BaseContractChange();
		bean.setDataFromJSON(json);
		ContractChange dao = new ContractChange();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractChange bean = new BaseContractChange();
		bean.setDataFromJSON(json);
		ContractChange dao = new ContractChange();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractChange bean = new BaseContractChange();
		bean.setDataFromJSON(json);
		ContractChange dao = new ContractChange();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


