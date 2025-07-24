package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalSubContract;
import com.pomplatform.db.dao.CapitalSubContract;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalSubContractHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalSubContractHandler.class);

	public static BaseCapitalSubContract getCapitalSubContractById( 
		java.lang.Integer capital_sub_contract_id
	) throws Exception
	{
		CapitalSubContract dao = new CapitalSubContract();
		dao.setCapitalSubContractId(capital_sub_contract_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalSubContractExists( com.pomplatform.db.bean.BaseCapitalSubContract bean, String additional ) throws Exception {

		CapitalSubContract dao = new CapitalSubContract();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalSubContract( com.pomplatform.db.bean.BaseCapitalSubContract bean, String additional ) throws Exception {

		CapitalSubContract dao = new CapitalSubContract();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalSubContract> queryCapitalSubContract( com.pomplatform.db.bean.BaseCapitalSubContract bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalSubContract dao = new CapitalSubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalSubContract> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalSubContract> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalSubContract addToCapitalSubContract ( BaseCapitalSubContract capitalsubcontract )  throws Exception {
		return addToCapitalSubContract ( capitalsubcontract , false);
	}

	public static BaseCapitalSubContract addToCapitalSubContract ( BaseCapitalSubContract capitalsubcontract, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalSubContract dao = new CapitalSubContract();
		dao.setDataFromBase(capitalsubcontract);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalSubContract addUpdateCapitalSubContract ( BaseCapitalSubContract capitalsubcontract ) throws Exception {
		return addUpdateCapitalSubContract ( capitalsubcontract , false);
	}

	public static BaseCapitalSubContract addUpdateCapitalSubContract ( BaseCapitalSubContract capitalsubcontract, boolean singleTransaction  ) throws Exception {
		if(capitalsubcontract.getCapitalSubContractId() == null) return addToCapitalSubContract(capitalsubcontract);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalSubContract dao = new CapitalSubContract();
		dao.setDataFromBase(capitalsubcontract);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitalsubcontract); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalSubContract ( BaseCapitalSubContract bean ) throws Exception {
		CapitalSubContract dao = new CapitalSubContract();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalSubContract updateCapitalSubContract ( BaseCapitalSubContract capitalsubcontract ) throws Exception {
		CapitalSubContract dao = new CapitalSubContract();
		dao.setCapitalSubContractId( capitalsubcontract.getCapitalSubContractId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitalsubcontract);
			result = dao.update();
		}
		return result == 1 ? capitalsubcontract : null ;
	}

	public static BaseCapitalSubContract updateCapitalSubContractDirect( BaseCapitalSubContract capitalsubcontract ) throws Exception {
		CapitalSubContract dao = new CapitalSubContract();
		int result = 0;
		dao.setDataFromBase(capitalsubcontract);
		result = dao.update();
		return result == 1 ? capitalsubcontract : null ;
	}

	public static int setDeleteConditions(BaseCapitalSubContract bean, CapitalSubContract dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalSubContractId() != null) {
			dao.setConditionCapitalSubContractId("=", bean.getCapitalSubContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
			if(bean.getSubContractId() != null) {
				dao.setConditionSubContractId("=", bean.getSubContractId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalSubContract bean, CapitalSubContract dao){
		int count = 0;
		if(bean.getCapitalSubContractId() != null) {
			dao.setConditionCapitalSubContractId("=", bean.getCapitalSubContractId());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getSubContractId() != null) {
			dao.setConditionSubContractId("=", bean.getSubContractId());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreatTime() != null) {
			dao.setConditionCreatTime(">=", bean.getCreatTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		bean.setDataFromJSON(json);
		CapitalSubContract dao = new CapitalSubContract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalSubContract> rlist = new BaseCollection<>();
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalSubContract dao = new CapitalSubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalSubContract> result = dao.conditionalLoad(addtion);
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
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		bean.setDataFromJSON(json);
		CapitalSubContract dao = new CapitalSubContract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		bean.setDataFromJSON(json);
		CapitalSubContract dao = new CapitalSubContract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		bean.setDataFromJSON(json);
		CapitalSubContract dao = new CapitalSubContract();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalSubContract bean = new BaseCapitalSubContract();
		bean.setDataFromJSON(json);
		CapitalSubContract dao = new CapitalSubContract();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


