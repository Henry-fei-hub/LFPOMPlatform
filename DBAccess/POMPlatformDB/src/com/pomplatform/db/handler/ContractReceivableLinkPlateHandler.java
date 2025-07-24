package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractReceivableLinkPlate;
import com.pomplatform.db.dao.ContractReceivableLinkPlate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractReceivableLinkPlateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractReceivableLinkPlateHandler.class);

	public static BaseContractReceivableLinkPlate getContractReceivableLinkPlateById( 
		java.lang.Integer contract_receivable_link_plate_id
	) throws Exception
	{
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setContractReceivableLinkPlateId(contract_receivable_link_plate_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractReceivableLinkPlateExists( com.pomplatform.db.bean.BaseContractReceivableLinkPlate bean, String additional ) throws Exception {

		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractReceivableLinkPlate( com.pomplatform.db.bean.BaseContractReceivableLinkPlate bean, String additional ) throws Exception {

		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractReceivableLinkPlate> queryContractReceivableLinkPlate( com.pomplatform.db.bean.BaseContractReceivableLinkPlate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractReceivableLinkPlate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractReceivableLinkPlate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractReceivableLinkPlate addToContractReceivableLinkPlate ( BaseContractReceivableLinkPlate contractreceivablelinkplate )  throws Exception {
		return addToContractReceivableLinkPlate ( contractreceivablelinkplate , false);
	}

	public static BaseContractReceivableLinkPlate addToContractReceivableLinkPlate ( BaseContractReceivableLinkPlate contractreceivablelinkplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setDataFromBase(contractreceivablelinkplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractReceivableLinkPlate addUpdateContractReceivableLinkPlate ( BaseContractReceivableLinkPlate contractreceivablelinkplate ) throws Exception {
		return addUpdateContractReceivableLinkPlate ( contractreceivablelinkplate , false);
	}

	public static BaseContractReceivableLinkPlate addUpdateContractReceivableLinkPlate ( BaseContractReceivableLinkPlate contractreceivablelinkplate, boolean singleTransaction  ) throws Exception {
		if(contractreceivablelinkplate.getContractReceivableLinkPlateId() == null) return addToContractReceivableLinkPlate(contractreceivablelinkplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setDataFromBase(contractreceivablelinkplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractreceivablelinkplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractReceivableLinkPlate ( BaseContractReceivableLinkPlate bean ) throws Exception {
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractReceivableLinkPlate updateContractReceivableLinkPlate ( BaseContractReceivableLinkPlate contractreceivablelinkplate ) throws Exception {
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setContractReceivableLinkPlateId( contractreceivablelinkplate.getContractReceivableLinkPlateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractreceivablelinkplate);
			result = dao.update();
		}
		return result == 1 ? contractreceivablelinkplate : null ;
	}

	public static BaseContractReceivableLinkPlate updateContractReceivableLinkPlateDirect( BaseContractReceivableLinkPlate contractreceivablelinkplate ) throws Exception {
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		int result = 0;
		dao.setDataFromBase(contractreceivablelinkplate);
		result = dao.update();
		return result == 1 ? contractreceivablelinkplate : null ;
	}

	public static int setDeleteConditions(BaseContractReceivableLinkPlate bean, ContractReceivableLinkPlate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractReceivableLinkPlateId() != null) {
			dao.setConditionContractReceivableLinkPlateId("=", bean.getContractReceivableLinkPlateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractReceivableLinkPlate bean, ContractReceivableLinkPlate dao){
		int count = 0;
		if(bean.getContractReceivableLinkPlateId() != null) {
			dao.setConditionContractReceivableLinkPlateId("=", bean.getContractReceivableLinkPlateId());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getDistributionAmount() != null) {
			dao.setConditionDistributionAmount("=", bean.getDistributionAmount());
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
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		bean.setDataFromJSON(json);
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractReceivableLinkPlate> rlist = new BaseCollection<>();
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractReceivableLinkPlate> result = dao.conditionalLoad(addtion);
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
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		bean.setDataFromJSON(json);
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		bean.setDataFromJSON(json);
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		bean.setDataFromJSON(json);
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractReceivableLinkPlate bean = new BaseContractReceivableLinkPlate();
		bean.setDataFromJSON(json);
		ContractReceivableLinkPlate dao = new ContractReceivableLinkPlate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


