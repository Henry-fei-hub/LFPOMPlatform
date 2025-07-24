package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractSerialNumber;
import com.pomplatform.db.dao.ContractSerialNumber;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractSerialNumberHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractSerialNumberHandler.class);

	public static BaseContractSerialNumber getContractSerialNumberById( 
		java.lang.Integer contract_serial_number_id
	) throws Exception
	{
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setContractSerialNumberId(contract_serial_number_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractSerialNumberExists( com.pomplatform.db.bean.BaseContractSerialNumber bean, String additional ) throws Exception {

		ContractSerialNumber dao = new ContractSerialNumber();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractSerialNumber( com.pomplatform.db.bean.BaseContractSerialNumber bean, String additional ) throws Exception {

		ContractSerialNumber dao = new ContractSerialNumber();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractSerialNumber> queryContractSerialNumber( com.pomplatform.db.bean.BaseContractSerialNumber bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractSerialNumber dao = new ContractSerialNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractSerialNumber> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractSerialNumber> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractSerialNumber addToContractSerialNumber ( BaseContractSerialNumber contractserialnumber )  throws Exception {
		return addToContractSerialNumber ( contractserialnumber , false);
	}

	public static BaseContractSerialNumber addToContractSerialNumber ( BaseContractSerialNumber contractserialnumber, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setDataFromBase(contractserialnumber);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractSerialNumber addUpdateContractSerialNumber ( BaseContractSerialNumber contractserialnumber ) throws Exception {
		return addUpdateContractSerialNumber ( contractserialnumber , false);
	}

	public static BaseContractSerialNumber addUpdateContractSerialNumber ( BaseContractSerialNumber contractserialnumber, boolean singleTransaction  ) throws Exception {
		if(contractserialnumber.getContractSerialNumberId() == null) return addToContractSerialNumber(contractserialnumber);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setDataFromBase(contractserialnumber);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractserialnumber); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractSerialNumber ( BaseContractSerialNumber bean ) throws Exception {
		ContractSerialNumber dao = new ContractSerialNumber();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractSerialNumber updateContractSerialNumber ( BaseContractSerialNumber contractserialnumber ) throws Exception {
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setContractSerialNumberId( contractserialnumber.getContractSerialNumberId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractserialnumber);
			result = dao.update();
		}
		return result == 1 ? contractserialnumber : null ;
	}

	public static BaseContractSerialNumber updateContractSerialNumberDirect( BaseContractSerialNumber contractserialnumber ) throws Exception {
		ContractSerialNumber dao = new ContractSerialNumber();
		int result = 0;
		dao.setDataFromBase(contractserialnumber);
		result = dao.update();
		return result == 1 ? contractserialnumber : null ;
	}

	public static int setDeleteConditions(BaseContractSerialNumber bean, ContractSerialNumber dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractSerialNumberId() != null) {
			dao.setConditionContractSerialNumberId("=", bean.getContractSerialNumberId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getSigningCompanyName() != null) {
				dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractSerialNumber bean, ContractSerialNumber dao){
		int count = 0;
		if(bean.getContractSerialNumberId() != null) {
			dao.setConditionContractSerialNumberId("=", bean.getContractSerialNumberId());
			count++;
		}
		if(bean.getProduceDate() != null) {
			dao.setConditionProduceDate(">=", bean.getProduceDate());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getSigningCompanyName() != null) {
			dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		bean.setDataFromJSON(json);
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractSerialNumber> rlist = new BaseCollection<>();
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractSerialNumber dao = new ContractSerialNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractSerialNumber> result = dao.conditionalLoad(addtion);
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
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		bean.setDataFromJSON(json);
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		bean.setDataFromJSON(json);
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		bean.setDataFromJSON(json);
		ContractSerialNumber dao = new ContractSerialNumber();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractSerialNumber bean = new BaseContractSerialNumber();
		bean.setDataFromJSON(json);
		ContractSerialNumber dao = new ContractSerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


