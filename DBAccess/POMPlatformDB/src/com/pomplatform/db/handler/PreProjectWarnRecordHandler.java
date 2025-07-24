package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePreProjectWarnRecord;
import com.pomplatform.db.dao.PreProjectWarnRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PreProjectWarnRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PreProjectWarnRecordHandler.class);

	public static BasePreProjectWarnRecord getPreProjectWarnRecordById( 
		java.lang.Integer pre_project_warn_record_id
	) throws Exception
	{
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setPreProjectWarnRecordId(pre_project_warn_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPreProjectWarnRecordExists( com.pomplatform.db.bean.BasePreProjectWarnRecord bean, String additional ) throws Exception {

		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPreProjectWarnRecord( com.pomplatform.db.bean.BasePreProjectWarnRecord bean, String additional ) throws Exception {

		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePreProjectWarnRecord> queryPreProjectWarnRecord( com.pomplatform.db.bean.BasePreProjectWarnRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePreProjectWarnRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePreProjectWarnRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePreProjectWarnRecord addToPreProjectWarnRecord ( BasePreProjectWarnRecord preprojectwarnrecord )  throws Exception {
		return addToPreProjectWarnRecord ( preprojectwarnrecord , false);
	}

	public static BasePreProjectWarnRecord addToPreProjectWarnRecord ( BasePreProjectWarnRecord preprojectwarnrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setDataFromBase(preprojectwarnrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePreProjectWarnRecord addUpdatePreProjectWarnRecord ( BasePreProjectWarnRecord preprojectwarnrecord ) throws Exception {
		return addUpdatePreProjectWarnRecord ( preprojectwarnrecord , false);
	}

	public static BasePreProjectWarnRecord addUpdatePreProjectWarnRecord ( BasePreProjectWarnRecord preprojectwarnrecord, boolean singleTransaction  ) throws Exception {
		if(preprojectwarnrecord.getPreProjectWarnRecordId() == null) return addToPreProjectWarnRecord(preprojectwarnrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setDataFromBase(preprojectwarnrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(preprojectwarnrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePreProjectWarnRecord ( BasePreProjectWarnRecord bean ) throws Exception {
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePreProjectWarnRecord updatePreProjectWarnRecord ( BasePreProjectWarnRecord preprojectwarnrecord ) throws Exception {
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setPreProjectWarnRecordId( preprojectwarnrecord.getPreProjectWarnRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(preprojectwarnrecord);
			result = dao.update();
		}
		return result == 1 ? preprojectwarnrecord : null ;
	}

	public static BasePreProjectWarnRecord updatePreProjectWarnRecordDirect( BasePreProjectWarnRecord preprojectwarnrecord ) throws Exception {
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		int result = 0;
		dao.setDataFromBase(preprojectwarnrecord);
		result = dao.update();
		return result == 1 ? preprojectwarnrecord : null ;
	}

	public static int setDeleteConditions(BasePreProjectWarnRecord bean, PreProjectWarnRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectWarnRecordId() != null) {
			dao.setConditionPreProjectWarnRecordId("=", bean.getPreProjectWarnRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
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
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getWarnDays() != null) {
				dao.setConditionWarnDays("=", bean.getWarnDays());
				count++;
			}
			if(bean.getWarnContent() != null) {
				dao.setConditionWarnContent("=", bean.getWarnContent());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProjectWarnRecord bean, PreProjectWarnRecord dao){
		int count = 0;
		if(bean.getPreProjectWarnRecordId() != null) {
			dao.setConditionPreProjectWarnRecordId("=", bean.getPreProjectWarnRecordId());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
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
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getWarnDays() != null) {
			dao.setConditionWarnDays("=", bean.getWarnDays());
			count++;
		}
		if(bean.getWarnContent() != null) {
			if(bean.getWarnContent().indexOf("%") >= 0)
				dao.setConditionWarnContent("like", bean.getWarnContent());
			else
				dao.setConditionWarnContent("=", bean.getWarnContent());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		bean.setDataFromJSON(json);
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProjectWarnRecord> rlist = new BaseCollection<>();
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProjectWarnRecord> result = dao.conditionalLoad(addtion);
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
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		bean.setDataFromJSON(json);
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		bean.setDataFromJSON(json);
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		bean.setDataFromJSON(json);
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProjectWarnRecord bean = new BasePreProjectWarnRecord();
		bean.setDataFromJSON(json);
		PreProjectWarnRecord dao = new PreProjectWarnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


