package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;
import com.pomplatform.db.dao.CapitalDistributionLinkSubContract;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalDistributionLinkSubContractHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionLinkSubContractHandler.class);

	public static BaseCapitalDistributionLinkSubContract getCapitalDistributionLinkSubContractById( 
		java.lang.Integer capital_distribution_link_sub_contract_id
	) throws Exception
	{
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setCapitalDistributionLinkSubContractId(capital_distribution_link_sub_contract_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalDistributionLinkSubContractExists( com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract bean, String additional ) throws Exception {

		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalDistributionLinkSubContract( com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract bean, String additional ) throws Exception {

		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalDistributionLinkSubContract> queryCapitalDistributionLinkSubContract( com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalDistributionLinkSubContract> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalDistributionLinkSubContract> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalDistributionLinkSubContract addToCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract )  throws Exception {
		return addToCapitalDistributionLinkSubContract ( capitaldistributionlinksubcontract , false);
	}

	public static BaseCapitalDistributionLinkSubContract addToCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setDataFromBase(capitaldistributionlinksubcontract);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalDistributionLinkSubContract addUpdateCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract ) throws Exception {
		return addUpdateCapitalDistributionLinkSubContract ( capitaldistributionlinksubcontract , false);
	}

	public static BaseCapitalDistributionLinkSubContract addUpdateCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract, boolean singleTransaction  ) throws Exception {
		if(capitaldistributionlinksubcontract.getCapitalDistributionLinkSubContractId() == null) return addToCapitalDistributionLinkSubContract(capitaldistributionlinksubcontract);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setDataFromBase(capitaldistributionlinksubcontract);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitaldistributionlinksubcontract); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract bean ) throws Exception {
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalDistributionLinkSubContract updateCapitalDistributionLinkSubContract ( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract ) throws Exception {
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setCapitalDistributionLinkSubContractId( capitaldistributionlinksubcontract.getCapitalDistributionLinkSubContractId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitaldistributionlinksubcontract);
			result = dao.update();
		}
		return result == 1 ? capitaldistributionlinksubcontract : null ;
	}

	public static BaseCapitalDistributionLinkSubContract updateCapitalDistributionLinkSubContractDirect( BaseCapitalDistributionLinkSubContract capitaldistributionlinksubcontract ) throws Exception {
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		int result = 0;
		dao.setDataFromBase(capitaldistributionlinksubcontract);
		result = dao.update();
		return result == 1 ? capitaldistributionlinksubcontract : null ;
	}

	public static int setDeleteConditions(BaseCapitalDistributionLinkSubContract bean, CapitalDistributionLinkSubContract dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalDistributionLinkSubContractId() != null) {
			dao.setConditionCapitalDistributionLinkSubContractId("=", bean.getCapitalDistributionLinkSubContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCapitalDistributionId() != null) {
				dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
				count++;
			}
			if(bean.getSubContractId() != null) {
				dao.setConditionSubContractId("=", bean.getSubContractId());
				count++;
			}
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalDistributionLinkSubContract bean, CapitalDistributionLinkSubContract dao){
		int count = 0;
		if(bean.getCapitalDistributionLinkSubContractId() != null) {
			dao.setConditionCapitalDistributionLinkSubContractId("=", bean.getCapitalDistributionLinkSubContractId());
			count++;
		}
		if(bean.getCapitalDistributionId() != null) {
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
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
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
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
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalDistributionLinkSubContract> rlist = new BaseCollection<>();
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalDistributionLinkSubContract> result = dao.conditionalLoad(addtion);
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
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalDistributionLinkSubContract bean = new BaseCapitalDistributionLinkSubContract();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkSubContract dao = new CapitalDistributionLinkSubContract();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


