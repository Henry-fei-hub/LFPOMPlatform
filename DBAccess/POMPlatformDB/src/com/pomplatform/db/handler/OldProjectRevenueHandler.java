package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOldProjectRevenue;
import com.pomplatform.db.dao.OldProjectRevenue;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OldProjectRevenueHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OldProjectRevenueHandler.class);

	public static BaseOldProjectRevenue getOldProjectRevenueById( 
		java.lang.Integer old_project_revenue_id
	) throws Exception
	{
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setOldProjectRevenueId(old_project_revenue_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOldProjectRevenueExists( com.pomplatform.db.bean.BaseOldProjectRevenue bean, String additional ) throws Exception {

		OldProjectRevenue dao = new OldProjectRevenue();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOldProjectRevenue( com.pomplatform.db.bean.BaseOldProjectRevenue bean, String additional ) throws Exception {

		OldProjectRevenue dao = new OldProjectRevenue();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOldProjectRevenue> queryOldProjectRevenue( com.pomplatform.db.bean.BaseOldProjectRevenue bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OldProjectRevenue dao = new OldProjectRevenue();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOldProjectRevenue> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOldProjectRevenue> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOldProjectRevenue addToOldProjectRevenue ( BaseOldProjectRevenue oldprojectrevenue )  throws Exception {
		return addToOldProjectRevenue ( oldprojectrevenue , false);
	}

	public static BaseOldProjectRevenue addToOldProjectRevenue ( BaseOldProjectRevenue oldprojectrevenue, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setDataFromBase(oldprojectrevenue);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOldProjectRevenue addUpdateOldProjectRevenue ( BaseOldProjectRevenue oldprojectrevenue ) throws Exception {
		return addUpdateOldProjectRevenue ( oldprojectrevenue , false);
	}

	public static BaseOldProjectRevenue addUpdateOldProjectRevenue ( BaseOldProjectRevenue oldprojectrevenue, boolean singleTransaction  ) throws Exception {
		if(oldprojectrevenue.getOldProjectRevenueId() == null) return addToOldProjectRevenue(oldprojectrevenue);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setDataFromBase(oldprojectrevenue);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(oldprojectrevenue); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOldProjectRevenue ( BaseOldProjectRevenue bean ) throws Exception {
		OldProjectRevenue dao = new OldProjectRevenue();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOldProjectRevenue updateOldProjectRevenue ( BaseOldProjectRevenue oldprojectrevenue ) throws Exception {
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setOldProjectRevenueId( oldprojectrevenue.getOldProjectRevenueId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(oldprojectrevenue);
			result = dao.update();
		}
		return result == 1 ? oldprojectrevenue : null ;
	}

	public static BaseOldProjectRevenue updateOldProjectRevenueDirect( BaseOldProjectRevenue oldprojectrevenue ) throws Exception {
		OldProjectRevenue dao = new OldProjectRevenue();
		int result = 0;
		dao.setDataFromBase(oldprojectrevenue);
		result = dao.update();
		return result == 1 ? oldprojectrevenue : null ;
	}

	public static int setDeleteConditions(BaseOldProjectRevenue bean, OldProjectRevenue dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOldProjectRevenueId() != null) {
			dao.setConditionOldProjectRevenueId("=", bean.getOldProjectRevenueId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getPalteId() != null) {
				dao.setConditionPalteId("=", bean.getPalteId());
				count++;
			}
			if(bean.getIsFinish() != null) {
				dao.setConditionIsFinish("=", bean.getIsFinish());
				count++;
			}
			if(bean.getBuniessType() != null) {
				dao.setConditionBuniessType("=", bean.getBuniessType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOldProjectRevenue bean, OldProjectRevenue dao){
		int count = 0;
		if(bean.getOldProjectRevenueId() != null) {
			dao.setConditionOldProjectRevenueId("=", bean.getOldProjectRevenueId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getPalteId() != null) {
			dao.setConditionPalteId("=", bean.getPalteId());
			count++;
		}
		if(bean.getIsFinish() != null) {
			dao.setConditionIsFinish("=", bean.getIsFinish());
			count++;
		}
		if(bean.getBuniessType() != null) {
			dao.setConditionBuniessType("=", bean.getBuniessType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		bean.setDataFromJSON(json);
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOldProjectRevenue> rlist = new BaseCollection<>();
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OldProjectRevenue dao = new OldProjectRevenue();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOldProjectRevenue> result = dao.conditionalLoad(addtion);
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
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		bean.setDataFromJSON(json);
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		bean.setDataFromJSON(json);
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		bean.setDataFromJSON(json);
		OldProjectRevenue dao = new OldProjectRevenue();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOldProjectRevenue bean = new BaseOldProjectRevenue();
		bean.setDataFromJSON(json);
		OldProjectRevenue dao = new OldProjectRevenue();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


