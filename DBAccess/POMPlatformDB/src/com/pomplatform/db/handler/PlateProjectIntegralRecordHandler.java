package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateProjectIntegralRecord;
import com.pomplatform.db.dao.PlateProjectIntegralRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateProjectIntegralRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateProjectIntegralRecordHandler.class);

	public static BasePlateProjectIntegralRecord getPlateProjectIntegralRecordById( 
		java.lang.Integer plate_project_integral_record_id
	) throws Exception
	{
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setPlateProjectIntegralRecordId(plate_project_integral_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateProjectIntegralRecordExists( com.pomplatform.db.bean.BasePlateProjectIntegralRecord bean, String additional ) throws Exception {

		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateProjectIntegralRecord( com.pomplatform.db.bean.BasePlateProjectIntegralRecord bean, String additional ) throws Exception {

		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateProjectIntegralRecord> queryPlateProjectIntegralRecord( com.pomplatform.db.bean.BasePlateProjectIntegralRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateProjectIntegralRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateProjectIntegralRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateProjectIntegralRecord addToPlateProjectIntegralRecord ( BasePlateProjectIntegralRecord plateprojectintegralrecord )  throws Exception {
		return addToPlateProjectIntegralRecord ( plateprojectintegralrecord , false);
	}

	public static BasePlateProjectIntegralRecord addToPlateProjectIntegralRecord ( BasePlateProjectIntegralRecord plateprojectintegralrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setDataFromBase(plateprojectintegralrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateProjectIntegralRecord addUpdatePlateProjectIntegralRecord ( BasePlateProjectIntegralRecord plateprojectintegralrecord ) throws Exception {
		return addUpdatePlateProjectIntegralRecord ( plateprojectintegralrecord , false);
	}

	public static BasePlateProjectIntegralRecord addUpdatePlateProjectIntegralRecord ( BasePlateProjectIntegralRecord plateprojectintegralrecord, boolean singleTransaction  ) throws Exception {
		if(plateprojectintegralrecord.getPlateProjectIntegralRecordId() == null) return addToPlateProjectIntegralRecord(plateprojectintegralrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setDataFromBase(plateprojectintegralrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateprojectintegralrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateProjectIntegralRecord ( BasePlateProjectIntegralRecord bean ) throws Exception {
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateProjectIntegralRecord updatePlateProjectIntegralRecord ( BasePlateProjectIntegralRecord plateprojectintegralrecord ) throws Exception {
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setPlateProjectIntegralRecordId( plateprojectintegralrecord.getPlateProjectIntegralRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateprojectintegralrecord);
			result = dao.update();
		}
		return result == 1 ? plateprojectintegralrecord : null ;
	}

	public static BasePlateProjectIntegralRecord updatePlateProjectIntegralRecordDirect( BasePlateProjectIntegralRecord plateprojectintegralrecord ) throws Exception {
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		int result = 0;
		dao.setDataFromBase(plateprojectintegralrecord);
		result = dao.update();
		return result == 1 ? plateprojectintegralrecord : null ;
	}

	public static int setDeleteConditions(BasePlateProjectIntegralRecord bean, PlateProjectIntegralRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateProjectIntegralRecordId() != null) {
			dao.setConditionPlateProjectIntegralRecordId("=", bean.getPlateProjectIntegralRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateProjectIntegralRecord bean, PlateProjectIntegralRecord dao){
		int count = 0;
		if(bean.getPlateProjectIntegralRecordId() != null) {
			dao.setConditionPlateProjectIntegralRecordId("=", bean.getPlateProjectIntegralRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getSendIntegral() != null) {
			dao.setConditionSendIntegral("=", bean.getSendIntegral());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getSendDate() != null) {
			dao.setConditionSendDate(">=", bean.getSendDate());
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
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		bean.setDataFromJSON(json);
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateProjectIntegralRecord> rlist = new BaseCollection<>();
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateProjectIntegralRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		bean.setDataFromJSON(json);
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		bean.setDataFromJSON(json);
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		bean.setDataFromJSON(json);
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateProjectIntegralRecord bean = new BasePlateProjectIntegralRecord();
		bean.setDataFromJSON(json);
		PlateProjectIntegralRecord dao = new PlateProjectIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


