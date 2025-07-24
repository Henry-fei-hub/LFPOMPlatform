package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectPriceChangedRecord;
import com.pomplatform.db.dao.ProjectPriceChangedRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectPriceChangedRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectPriceChangedRecordHandler.class);

	public static BaseProjectPriceChangedRecord getProjectPriceChangedRecordById( 
		java.lang.Integer project_price_changed_record_id
	) throws Exception
	{
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setProjectPriceChangedRecordId(project_price_changed_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectPriceChangedRecordExists( com.pomplatform.db.bean.BaseProjectPriceChangedRecord bean, String additional ) throws Exception {

		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectPriceChangedRecord( com.pomplatform.db.bean.BaseProjectPriceChangedRecord bean, String additional ) throws Exception {

		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectPriceChangedRecord> queryProjectPriceChangedRecord( com.pomplatform.db.bean.BaseProjectPriceChangedRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectPriceChangedRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectPriceChangedRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectPriceChangedRecord addToProjectPriceChangedRecord ( BaseProjectPriceChangedRecord projectpricechangedrecord )  throws Exception {
		return addToProjectPriceChangedRecord ( projectpricechangedrecord , false);
	}

	public static BaseProjectPriceChangedRecord addToProjectPriceChangedRecord ( BaseProjectPriceChangedRecord projectpricechangedrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setDataFromBase(projectpricechangedrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectPriceChangedRecord addUpdateProjectPriceChangedRecord ( BaseProjectPriceChangedRecord projectpricechangedrecord ) throws Exception {
		return addUpdateProjectPriceChangedRecord ( projectpricechangedrecord , false);
	}

	public static BaseProjectPriceChangedRecord addUpdateProjectPriceChangedRecord ( BaseProjectPriceChangedRecord projectpricechangedrecord, boolean singleTransaction  ) throws Exception {
		if(projectpricechangedrecord.getProjectPriceChangedRecordId() == null) return addToProjectPriceChangedRecord(projectpricechangedrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setDataFromBase(projectpricechangedrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectpricechangedrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectPriceChangedRecord ( BaseProjectPriceChangedRecord bean ) throws Exception {
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectPriceChangedRecord updateProjectPriceChangedRecord ( BaseProjectPriceChangedRecord projectpricechangedrecord ) throws Exception {
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setProjectPriceChangedRecordId( projectpricechangedrecord.getProjectPriceChangedRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectpricechangedrecord);
			result = dao.update();
		}
		return result == 1 ? projectpricechangedrecord : null ;
	}

	public static BaseProjectPriceChangedRecord updateProjectPriceChangedRecordDirect( BaseProjectPriceChangedRecord projectpricechangedrecord ) throws Exception {
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		int result = 0;
		dao.setDataFromBase(projectpricechangedrecord);
		result = dao.update();
		return result == 1 ? projectpricechangedrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectPriceChangedRecord bean, ProjectPriceChangedRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectPriceChangedRecordId() != null) {
			dao.setConditionProjectPriceChangedRecordId("=", bean.getProjectPriceChangedRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
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
			if(bean.getSubsidiesType() != null) {
				dao.setConditionSubsidiesType("=", bean.getSubsidiesType());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectPriceChangedRecord bean, ProjectPriceChangedRecord dao){
		int count = 0;
		if(bean.getProjectPriceChangedRecordId() != null) {
			dao.setConditionProjectPriceChangedRecordId("=", bean.getProjectPriceChangedRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getYear() != null) {
			if(bean.getYear().indexOf("%") >= 0)
				dao.setConditionYear("like", bean.getYear());
			else
				dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			if(bean.getMonth().indexOf("%") >= 0)
				dao.setConditionMonth("like", bean.getMonth());
			else
				dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getRecordTime() != null) {
			dao.setConditionRecordTime(">=", bean.getRecordTime());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
			count++;
		}
		if(bean.getSubsidiesType() != null) {
			dao.setConditionSubsidiesType("=", bean.getSubsidiesType());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		bean.setDataFromJSON(json);
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectPriceChangedRecord> rlist = new BaseCollection<>();
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectPriceChangedRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		bean.setDataFromJSON(json);
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		bean.setDataFromJSON(json);
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		bean.setDataFromJSON(json);
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectPriceChangedRecord bean = new BaseProjectPriceChangedRecord();
		bean.setDataFromJSON(json);
		ProjectPriceChangedRecord dao = new ProjectPriceChangedRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


