package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractClient;
import com.pomplatform.db.dao.ContractClient;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractClientHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractClientHandler.class);

	public static BaseContractClient getContractClientById( 
		java.lang.Integer contract_id, 
		java.lang.Integer client_id
	) throws Exception
	{
		ContractClient dao = new ContractClient();
		dao.setContractId(contract_id);
		dao.setClientId(client_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractClientExists( com.pomplatform.db.bean.BaseContractClient bean, String additional ) throws Exception {

		ContractClient dao = new ContractClient();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractClient( com.pomplatform.db.bean.BaseContractClient bean, String additional ) throws Exception {

		ContractClient dao = new ContractClient();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractClient> queryContractClient( com.pomplatform.db.bean.BaseContractClient bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractClient dao = new ContractClient();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractClient> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractClient> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractClient addToContractClient ( BaseContractClient contractclient )  throws Exception {
		return addToContractClient ( contractclient , false);
	}

	public static BaseContractClient addToContractClient ( BaseContractClient contractclient, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractClient dao = new ContractClient();
		dao.setDataFromBase(contractclient);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractClient addUpdateContractClient ( BaseContractClient contractclient ) throws Exception {
		return addUpdateContractClient ( contractclient , false);
	}

	public static BaseContractClient addUpdateContractClient ( BaseContractClient contractclient, boolean singleTransaction  ) throws Exception {
		if(contractclient.getContractId() == null) return addToContractClient(contractclient);
		if(contractclient.getClientId() == null) return addToContractClient(contractclient);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractClient dao = new ContractClient();
		dao.setDataFromBase(contractclient);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractclient); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractClient ( BaseContractClient bean ) throws Exception {
		ContractClient dao = new ContractClient();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractClient updateContractClient ( BaseContractClient contractclient ) throws Exception {
		ContractClient dao = new ContractClient();
		dao.setContractId( contractclient.getContractId() );
		dao.setClientId( contractclient.getClientId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractclient);
			result = dao.update();
		}
		return result == 1 ? contractclient : null ;
	}

	public static BaseContractClient updateContractClientDirect( BaseContractClient contractclient ) throws Exception {
		ContractClient dao = new ContractClient();
		int result = 0;
		dao.setDataFromBase(contractclient);
		result = dao.update();
		return result == 1 ? contractclient : null ;
	}

	public static int setDeleteConditions(BaseContractClient bean, ContractClient dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
			foundKey = true;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
		}
		return count;
	}

	public static int setConditions(BaseContractClient bean, ContractClient dao){
		int count = 0;
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
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
		BaseContractClient bean = new BaseContractClient();
		bean.setDataFromJSON(json);
		ContractClient dao = new ContractClient();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractClient> rlist = new BaseCollection<>();
		BaseContractClient bean = new BaseContractClient();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractClient dao = new ContractClient();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractClient> result = dao.conditionalLoad(addtion);
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
		BaseContractClient bean = new BaseContractClient();
		bean.setDataFromJSON(json);
		ContractClient dao = new ContractClient();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractClient bean = new BaseContractClient();
		bean.setDataFromJSON(json);
		ContractClient dao = new ContractClient();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractClient bean = new BaseContractClient();
		bean.setDataFromJSON(json);
		ContractClient dao = new ContractClient();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractClient bean = new BaseContractClient();
		bean.setDataFromJSON(json);
		ContractClient dao = new ContractClient();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


