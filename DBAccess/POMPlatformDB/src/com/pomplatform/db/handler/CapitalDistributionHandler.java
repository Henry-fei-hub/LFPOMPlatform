package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalDistribution;
import com.pomplatform.db.dao.CapitalDistribution;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalDistributionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionHandler.class);

	public static BaseCapitalDistribution getCapitalDistributionById( 
		java.lang.Integer capital_distribution_id
	) throws Exception
	{
		CapitalDistribution dao = new CapitalDistribution();
		dao.setCapitalDistributionId(capital_distribution_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalDistributionExists( com.pomplatform.db.bean.BaseCapitalDistribution bean, String additional ) throws Exception {

		CapitalDistribution dao = new CapitalDistribution();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalDistribution( com.pomplatform.db.bean.BaseCapitalDistribution bean, String additional ) throws Exception {

		CapitalDistribution dao = new CapitalDistribution();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalDistribution> queryCapitalDistribution( com.pomplatform.db.bean.BaseCapitalDistribution bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalDistribution dao = new CapitalDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalDistribution> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalDistribution> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalDistribution addToCapitalDistribution ( BaseCapitalDistribution capitaldistribution )  throws Exception {
		return addToCapitalDistribution ( capitaldistribution , false);
	}

	public static BaseCapitalDistribution addToCapitalDistribution ( BaseCapitalDistribution capitaldistribution, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalDistribution dao = new CapitalDistribution();
		dao.setDataFromBase(capitaldistribution);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalDistribution addUpdateCapitalDistribution ( BaseCapitalDistribution capitaldistribution ) throws Exception {
		return addUpdateCapitalDistribution ( capitaldistribution , false);
	}

	public static BaseCapitalDistribution addUpdateCapitalDistribution ( BaseCapitalDistribution capitaldistribution, boolean singleTransaction  ) throws Exception {
		if(capitaldistribution.getCapitalDistributionId() == null) return addToCapitalDistribution(capitaldistribution);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalDistribution dao = new CapitalDistribution();
		dao.setDataFromBase(capitaldistribution);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitaldistribution); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalDistribution ( BaseCapitalDistribution bean ) throws Exception {
		CapitalDistribution dao = new CapitalDistribution();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalDistribution updateCapitalDistribution ( BaseCapitalDistribution capitaldistribution ) throws Exception {
		CapitalDistribution dao = new CapitalDistribution();
		dao.setCapitalDistributionId( capitaldistribution.getCapitalDistributionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitaldistribution);
			result = dao.update();
		}
		return result == 1 ? capitaldistribution : null ;
	}

	public static BaseCapitalDistribution updateCapitalDistributionDirect( BaseCapitalDistribution capitaldistribution ) throws Exception {
		CapitalDistribution dao = new CapitalDistribution();
		int result = 0;
		dao.setDataFromBase(capitaldistribution);
		result = dao.update();
		return result == 1 ? capitaldistribution : null ;
	}

	public static int setDeleteConditions(BaseCapitalDistribution bean, CapitalDistribution dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalDistributionId() != null) {
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getLocked() != null) {
				dao.setConditionLocked("=", bean.getLocked());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalDistribution bean, CapitalDistribution dao){
		int count = 0;
		if(bean.getCapitalDistributionId() != null) {
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
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
		if(bean.getLocked() != null) {
			dao.setConditionLocked("=", bean.getLocked());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		bean.setDataFromJSON(json);
		CapitalDistribution dao = new CapitalDistribution();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalDistribution> rlist = new BaseCollection<>();
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalDistribution dao = new CapitalDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalDistribution> result = dao.conditionalLoad(addtion);
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
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		bean.setDataFromJSON(json);
		CapitalDistribution dao = new CapitalDistribution();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		bean.setDataFromJSON(json);
		CapitalDistribution dao = new CapitalDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		bean.setDataFromJSON(json);
		CapitalDistribution dao = new CapitalDistribution();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalDistribution bean = new BaseCapitalDistribution();
		bean.setDataFromJSON(json);
		CapitalDistribution dao = new CapitalDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


