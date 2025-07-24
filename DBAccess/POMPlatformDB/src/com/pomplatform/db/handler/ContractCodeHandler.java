package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractCode;
import com.pomplatform.db.dao.ContractCode;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractCodeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractCodeHandler.class);

	public static BaseContractCode getContractCodeById( 
		java.lang.Integer contract_code_id
	) throws Exception
	{
		ContractCode dao = new ContractCode();
		dao.setContractCodeId(contract_code_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractCodeExists( com.pomplatform.db.bean.BaseContractCode bean, String additional ) throws Exception {

		ContractCode dao = new ContractCode();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractCode( com.pomplatform.db.bean.BaseContractCode bean, String additional ) throws Exception {

		ContractCode dao = new ContractCode();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractCode> queryContractCode( com.pomplatform.db.bean.BaseContractCode bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractCode dao = new ContractCode();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractCode> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractCode> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractCode addToContractCode ( BaseContractCode contractcode )  throws Exception {
		return addToContractCode ( contractcode , false);
	}

	public static BaseContractCode addToContractCode ( BaseContractCode contractcode, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractCode dao = new ContractCode();
		dao.setDataFromBase(contractcode);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractCode addUpdateContractCode ( BaseContractCode contractcode ) throws Exception {
		return addUpdateContractCode ( contractcode , false);
	}

	public static BaseContractCode addUpdateContractCode ( BaseContractCode contractcode, boolean singleTransaction  ) throws Exception {
		if(contractcode.getContractCodeId() == null) return addToContractCode(contractcode);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractCode dao = new ContractCode();
		dao.setDataFromBase(contractcode);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractcode); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractCode ( BaseContractCode bean ) throws Exception {
		ContractCode dao = new ContractCode();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractCode updateContractCode ( BaseContractCode contractcode ) throws Exception {
		ContractCode dao = new ContractCode();
		dao.setContractCodeId( contractcode.getContractCodeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractcode);
			result = dao.update();
		}
		return result == 1 ? contractcode : null ;
	}

	public static BaseContractCode updateContractCodeDirect( BaseContractCode contractcode ) throws Exception {
		ContractCode dao = new ContractCode();
		int result = 0;
		dao.setDataFromBase(contractcode);
		result = dao.update();
		return result == 1 ? contractcode : null ;
	}

	public static int setDeleteConditions(BaseContractCode bean, ContractCode dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractCodeId() != null) {
			dao.setConditionContractCodeId("=", bean.getContractCodeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSignCompany() != null) {
				dao.setConditionSignCompany("=", bean.getSignCompany());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractCode bean, ContractCode dao){
		int count = 0;
		if(bean.getContractCodeId() != null) {
			dao.setConditionContractCodeId("=", bean.getContractCodeId());
			count++;
		}
		if(bean.getSignCompany() != null) {
			dao.setConditionSignCompany("=", bean.getSignCompany());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromJSON(json);
		ContractCode dao = new ContractCode();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractCode> rlist = new BaseCollection<>();
		BaseContractCode bean = new BaseContractCode();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractCode dao = new ContractCode();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractCode> result = dao.conditionalLoad(addtion);
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
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromJSON(json);
		ContractCode dao = new ContractCode();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromJSON(json);
		ContractCode dao = new ContractCode();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromJSON(json);
		ContractCode dao = new ContractCode();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromJSON(json);
		ContractCode dao = new ContractCode();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


