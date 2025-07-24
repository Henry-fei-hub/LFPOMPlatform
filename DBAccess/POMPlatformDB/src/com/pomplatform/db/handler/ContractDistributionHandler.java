package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.dao.ContractDistribution;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractDistributionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractDistributionHandler.class);

	public static BaseContractDistribution getContractDistributionById( 
		java.lang.Integer contract_distribution_id
	) throws Exception
	{
		ContractDistribution dao = new ContractDistribution();
		dao.setContractDistributionId(contract_distribution_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractDistributionExists( com.pomplatform.db.bean.BaseContractDistribution bean, String additional ) throws Exception {

		ContractDistribution dao = new ContractDistribution();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractDistribution( com.pomplatform.db.bean.BaseContractDistribution bean, String additional ) throws Exception {

		ContractDistribution dao = new ContractDistribution();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractDistribution> queryContractDistribution( com.pomplatform.db.bean.BaseContractDistribution bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractDistribution dao = new ContractDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractDistribution> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractDistribution> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractDistribution addToContractDistribution ( BaseContractDistribution contractdistribution )  throws Exception {
		return addToContractDistribution ( contractdistribution , false);
	}

	public static BaseContractDistribution addToContractDistribution ( BaseContractDistribution contractdistribution, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractDistribution dao = new ContractDistribution();
		dao.setDataFromBase(contractdistribution);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractDistribution addUpdateContractDistribution ( BaseContractDistribution contractdistribution ) throws Exception {
		return addUpdateContractDistribution ( contractdistribution , false);
	}

	public static BaseContractDistribution addUpdateContractDistribution ( BaseContractDistribution contractdistribution, boolean singleTransaction  ) throws Exception {
		if(contractdistribution.getContractDistributionId() == null) return addToContractDistribution(contractdistribution);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractDistribution dao = new ContractDistribution();
		dao.setDataFromBase(contractdistribution);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractdistribution); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractDistribution ( BaseContractDistribution bean ) throws Exception {
		ContractDistribution dao = new ContractDistribution();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractDistribution updateContractDistribution ( BaseContractDistribution contractdistribution ) throws Exception {
		ContractDistribution dao = new ContractDistribution();
		dao.setContractDistributionId( contractdistribution.getContractDistributionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractdistribution);
			result = dao.update();
		}
		return result == 1 ? contractdistribution : null ;
	}

	public static BaseContractDistribution updateContractDistributionDirect( BaseContractDistribution contractdistribution ) throws Exception {
		ContractDistribution dao = new ContractDistribution();
		int result = 0;
		dao.setDataFromBase(contractdistribution);
		result = dao.update();
		return result == 1 ? contractdistribution : null ;
	}

	public static int setDeleteConditions(BaseContractDistribution bean, ContractDistribution dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractDistributionId() != null) {
			dao.setConditionContractDistributionId("=", bean.getContractDistributionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getOrderId() != null) {
				dao.setConditionOrderId("=", bean.getOrderId());
				count++;
			}
			if(bean.getOperationManagerId() != null) {
				dao.setConditionOperationManagerId("=", bean.getOperationManagerId());
				count++;
			}
			if(bean.getOrderStatus() != null) {
				dao.setConditionOrderStatus("=", bean.getOrderStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractDistribution bean, ContractDistribution dao){
		int count = 0;
		if(bean.getContractDistributionId() != null) {
			dao.setConditionContractDistributionId("=", bean.getContractDistributionId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getActualMoney() != null) {
			dao.setConditionActualMoney("=", bean.getActualMoney());
			count++;
		}
		if(bean.getOrderId() != null) {
			if(bean.getOrderId().indexOf("%") >= 0)
				dao.setConditionOrderId("like", bean.getOrderId());
			else
				dao.setConditionOrderId("=", bean.getOrderId());
			count++;
		}
		if(bean.getOperationManagerId() != null) {
			dao.setConditionOperationManagerId("=", bean.getOperationManagerId());
			count++;
		}
		if(bean.getRateOfProgress() != null) {
			dao.setConditionRateOfProgress("=", bean.getRateOfProgress());
			count++;
		}
		if(bean.getOrderStatus() != null) {
			dao.setConditionOrderStatus("=", bean.getOrderStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractDistribution bean = new BaseContractDistribution();
		bean.setDataFromJSON(json);
		ContractDistribution dao = new ContractDistribution();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractDistribution> rlist = new BaseCollection<>();
		BaseContractDistribution bean = new BaseContractDistribution();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractDistribution dao = new ContractDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractDistribution> result = dao.conditionalLoad(addtion);
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
		BaseContractDistribution bean = new BaseContractDistribution();
		bean.setDataFromJSON(json);
		ContractDistribution dao = new ContractDistribution();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractDistribution bean = new BaseContractDistribution();
		bean.setDataFromJSON(json);
		ContractDistribution dao = new ContractDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractDistribution bean = new BaseContractDistribution();
		bean.setDataFromJSON(json);
		ContractDistribution dao = new ContractDistribution();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractDistribution bean = new BaseContractDistribution();
		bean.setDataFromJSON(json);
		ContractDistribution dao = new ContractDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


