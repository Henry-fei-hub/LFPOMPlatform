package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectIntegralSumRecord;
import com.pomplatform.db.dao.ProjectIntegralSumRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectIntegralSumRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectIntegralSumRecordHandler.class);

	public static BaseProjectIntegralSumRecord getProjectIntegralSumRecordById( 
		java.lang.Integer project_integral_sum_record_id
	) throws Exception
	{
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setProjectIntegralSumRecordId(project_integral_sum_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectIntegralSumRecordExists( com.pomplatform.db.bean.BaseProjectIntegralSumRecord bean, String additional ) throws Exception {

		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectIntegralSumRecord( com.pomplatform.db.bean.BaseProjectIntegralSumRecord bean, String additional ) throws Exception {

		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectIntegralSumRecord> queryProjectIntegralSumRecord( com.pomplatform.db.bean.BaseProjectIntegralSumRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectIntegralSumRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectIntegralSumRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectIntegralSumRecord addToProjectIntegralSumRecord ( BaseProjectIntegralSumRecord projectintegralsumrecord )  throws Exception {
		return addToProjectIntegralSumRecord ( projectintegralsumrecord , false);
	}

	public static BaseProjectIntegralSumRecord addToProjectIntegralSumRecord ( BaseProjectIntegralSumRecord projectintegralsumrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setDataFromBase(projectintegralsumrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectIntegralSumRecord addUpdateProjectIntegralSumRecord ( BaseProjectIntegralSumRecord projectintegralsumrecord ) throws Exception {
		return addUpdateProjectIntegralSumRecord ( projectintegralsumrecord , false);
	}

	public static BaseProjectIntegralSumRecord addUpdateProjectIntegralSumRecord ( BaseProjectIntegralSumRecord projectintegralsumrecord, boolean singleTransaction  ) throws Exception {
		if(projectintegralsumrecord.getProjectIntegralSumRecordId() == null) return addToProjectIntegralSumRecord(projectintegralsumrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setDataFromBase(projectintegralsumrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectintegralsumrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectIntegralSumRecord ( BaseProjectIntegralSumRecord bean ) throws Exception {
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectIntegralSumRecord updateProjectIntegralSumRecord ( BaseProjectIntegralSumRecord projectintegralsumrecord ) throws Exception {
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setProjectIntegralSumRecordId( projectintegralsumrecord.getProjectIntegralSumRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectintegralsumrecord);
			result = dao.update();
		}
		return result == 1 ? projectintegralsumrecord : null ;
	}

	public static BaseProjectIntegralSumRecord updateProjectIntegralSumRecordDirect( BaseProjectIntegralSumRecord projectintegralsumrecord ) throws Exception {
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		int result = 0;
		dao.setDataFromBase(projectintegralsumrecord);
		result = dao.update();
		return result == 1 ? projectintegralsumrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectIntegralSumRecord bean, ProjectIntegralSumRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectIntegralSumRecordId() != null) {
			dao.setConditionProjectIntegralSumRecordId("=", bean.getProjectIntegralSumRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectIntegralSumRecord bean, ProjectIntegralSumRecord dao){
		int count = 0;
		if(bean.getProjectIntegralSumRecordId() != null) {
			dao.setConditionProjectIntegralSumRecordId("=", bean.getProjectIntegralSumRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getProjectIntegralSum() != null) {
			dao.setConditionProjectIntegralSum("=", bean.getProjectIntegralSum());
			count++;
		}
		if(bean.getReserveIntegral() != null) {
			dao.setConditionReserveIntegral("=", bean.getReserveIntegral());
			count++;
		}
		if(bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if(bean.getUndistributedProjectIntegral() != null) {
			dao.setConditionUndistributedProjectIntegral("=", bean.getUndistributedProjectIntegral());
			count++;
		}
		if(bean.getDistributedProjectIntegral() != null) {
			dao.setConditionDistributedProjectIntegral("=", bean.getDistributedProjectIntegral());
			count++;
		}
		if(bean.getUnsureIntegral() != null) {
			dao.setConditionUnsureIntegral("=", bean.getUnsureIntegral());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getSettlementIntegral() != null) {
			dao.setConditionSettlementIntegral("=", bean.getSettlementIntegral());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
			count++;
		}
		if(bean.getSettledProjectCost() != null) {
			dao.setConditionSettledProjectCost("=", bean.getSettledProjectCost());
			count++;
		}
		if(bean.getUnsettledProjectCost() != null) {
			dao.setConditionUnsettledProjectCost("=", bean.getUnsettledProjectCost());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
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
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectIntegralSumRecord> rlist = new BaseCollection<>();
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectIntegralSumRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectIntegralSumRecord bean = new BaseProjectIntegralSumRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralSumRecord dao = new ProjectIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


