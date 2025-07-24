package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractsRecords;
import com.pomplatform.db.dao.ContractsRecords;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractsRecordsHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractsRecordsHandler.class);

	public static BaseContractsRecords getContractsRecordsById( 
		java.lang.Integer contracts_records_id
	) throws Exception
	{
		ContractsRecords dao = new ContractsRecords();
		dao.setContractsRecordsId(contracts_records_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractsRecordsExists( com.pomplatform.db.bean.BaseContractsRecords bean, String additional ) throws Exception {

		ContractsRecords dao = new ContractsRecords();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractsRecords( com.pomplatform.db.bean.BaseContractsRecords bean, String additional ) throws Exception {

		ContractsRecords dao = new ContractsRecords();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractsRecords> queryContractsRecords( com.pomplatform.db.bean.BaseContractsRecords bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractsRecords dao = new ContractsRecords();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractsRecords> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractsRecords> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractsRecords addToContractsRecords ( BaseContractsRecords contractsrecords )  throws Exception {
		return addToContractsRecords ( contractsrecords , false);
	}

	public static BaseContractsRecords addToContractsRecords ( BaseContractsRecords contractsrecords, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractsRecords dao = new ContractsRecords();
		dao.setDataFromBase(contractsrecords);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractsRecords addUpdateContractsRecords ( BaseContractsRecords contractsrecords ) throws Exception {
		return addUpdateContractsRecords ( contractsrecords , false);
	}

	public static BaseContractsRecords addUpdateContractsRecords ( BaseContractsRecords contractsrecords, boolean singleTransaction  ) throws Exception {
		if(contractsrecords.getContractsRecordsId() == null) return addToContractsRecords(contractsrecords);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractsRecords dao = new ContractsRecords();
		dao.setDataFromBase(contractsrecords);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractsrecords); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractsRecords ( BaseContractsRecords bean ) throws Exception {
		ContractsRecords dao = new ContractsRecords();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractsRecords updateContractsRecords ( BaseContractsRecords contractsrecords ) throws Exception {
		ContractsRecords dao = new ContractsRecords();
		dao.setContractsRecordsId( contractsrecords.getContractsRecordsId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractsrecords);
			result = dao.update();
		}
		return result == 1 ? contractsrecords : null ;
	}

	public static BaseContractsRecords updateContractsRecordsDirect( BaseContractsRecords contractsrecords ) throws Exception {
		ContractsRecords dao = new ContractsRecords();
		int result = 0;
		dao.setDataFromBase(contractsrecords);
		result = dao.update();
		return result == 1 ? contractsrecords : null ;
	}

	public static int setDeleteConditions(BaseContractsRecords bean, ContractsRecords dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractsRecordsId() != null) {
			dao.setConditionContractsRecordsId("=", bean.getContractsRecordsId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getContractStatus() != null) {
				dao.setConditionContractStatus("=", bean.getContractStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getRegisterEmployee() != null) {
				dao.setConditionRegisterEmployee("=", bean.getRegisterEmployee());
				count++;
			}
			if(bean.getRelevantEmployees() != null) {
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
				count++;
			}
			if(bean.getRelevantEmployeesName() != null) {
				dao.setConditionRelevantEmployeesName("=", bean.getRelevantEmployeesName());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getTrackType() != null) {
				dao.setConditionTrackType("=", bean.getTrackType());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractsRecords bean, ContractsRecords dao){
		int count = 0;
		if(bean.getContractsRecordsId() != null) {
			dao.setConditionContractsRecordsId("=", bean.getContractsRecordsId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getContractStatus() != null) {
			dao.setConditionContractStatus("=", bean.getContractStatus());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getTrackDate() != null) {
			dao.setConditionTrackDate(">=", bean.getTrackDate());
			count++;
		}
		if(bean.getRegisterEmployee() != null) {
			dao.setConditionRegisterEmployee("=", bean.getRegisterEmployee());
			count++;
		}
		if(bean.getRegisterDate() != null) {
			dao.setConditionRegisterDate(">=", bean.getRegisterDate());
			count++;
		}
		if(bean.getRelevantEmployees() != null) {
			if(bean.getRelevantEmployees().indexOf("%") >= 0)
				dao.setConditionRelevantEmployees("like", bean.getRelevantEmployees());
			else
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
			count++;
		}
		if(bean.getRelevantEmployeesName() != null) {
			if(bean.getRelevantEmployeesName().indexOf("%") >= 0)
				dao.setConditionRelevantEmployeesName("like", bean.getRelevantEmployeesName());
			else
				dao.setConditionRelevantEmployeesName("=", bean.getRelevantEmployeesName());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getSendingDate() != null) {
			dao.setConditionSendingDate(">=", bean.getSendingDate());
			count++;
		}
		if(bean.getTrackType() != null) {
			dao.setConditionTrackType("=", bean.getTrackType());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractsRecords bean = new BaseContractsRecords();
		bean.setDataFromJSON(json);
		ContractsRecords dao = new ContractsRecords();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractsRecords> rlist = new BaseCollection<>();
		BaseContractsRecords bean = new BaseContractsRecords();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractsRecords dao = new ContractsRecords();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractsRecords> result = dao.conditionalLoad(addtion);
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
		BaseContractsRecords bean = new BaseContractsRecords();
		bean.setDataFromJSON(json);
		ContractsRecords dao = new ContractsRecords();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractsRecords bean = new BaseContractsRecords();
		bean.setDataFromJSON(json);
		ContractsRecords dao = new ContractsRecords();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractsRecords bean = new BaseContractsRecords();
		bean.setDataFromJSON(json);
		ContractsRecords dao = new ContractsRecords();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractsRecords bean = new BaseContractsRecords();
		bean.setDataFromJSON(json);
		ContractsRecords dao = new ContractsRecords();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


