package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePlateDeployRecord;
import java.util.List;
import com.pomplatform.db.dao.PlateDeployRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PlateDeployRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateDeployRecordHandler.class);

	public static BasePlateDeployRecord getPlateDeployRecordById( 
		java.lang.Integer plate_deploy_record_id
	) throws Exception
	{
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setPlateDeployRecordId(plate_deploy_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateDeployRecordExists( com.pomplatform.db.bean.BasePlateDeployRecord bean, String additional ) throws Exception {

		PlateDeployRecord dao = new PlateDeployRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateDeployRecord( com.pomplatform.db.bean.BasePlateDeployRecord bean, String additional ) throws Exception {

		PlateDeployRecord dao = new PlateDeployRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateDeployRecord> queryPlateDeployRecord( com.pomplatform.db.bean.BasePlateDeployRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateDeployRecord dao = new PlateDeployRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateDeployRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateDeployRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateDeployRecord addToPlateDeployRecord ( BasePlateDeployRecord platedeployrecord )  throws Exception {
		return addToPlateDeployRecord ( platedeployrecord , false);
	}

	public static BasePlateDeployRecord addToPlateDeployRecord ( BasePlateDeployRecord platedeployrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setDataFromBase(platedeployrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateDeployRecord addUpdatePlateDeployRecord ( BasePlateDeployRecord platedeployrecord ) throws Exception {
		return addUpdatePlateDeployRecord ( platedeployrecord , false);
	}

	public static BasePlateDeployRecord addUpdatePlateDeployRecord ( BasePlateDeployRecord platedeployrecord, boolean singleTransaction  ) throws Exception {
		if(platedeployrecord.getPlateDeployRecordId() == null) return addToPlateDeployRecord(platedeployrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setDataFromBase(platedeployrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platedeployrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateDeployRecord ( BasePlateDeployRecord bean ) throws Exception {
		PlateDeployRecord dao = new PlateDeployRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateDeployRecord updatePlateDeployRecord ( BasePlateDeployRecord platedeployrecord ) throws Exception {
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setPlateDeployRecordId( platedeployrecord.getPlateDeployRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platedeployrecord);
			result = dao.update();
		}
		return result == 1 ? platedeployrecord : null ;
	}

	public static BasePlateDeployRecord updatePlateDeployRecordDirect( BasePlateDeployRecord platedeployrecord ) throws Exception {
		PlateDeployRecord dao = new PlateDeployRecord();
		int result = 0;
		dao.setDataFromBase(platedeployrecord);
		result = dao.update();
		return result == 1 ? platedeployrecord : null ;
	}

	public static int setDeleteConditions(BasePlateDeployRecord bean, PlateDeployRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateDeployRecordId() != null) {
			dao.setConditionPlateDeployRecordId("=", bean.getPlateDeployRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
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

	public static int setConditions(BasePlateDeployRecord bean, PlateDeployRecord dao){
		int count = 0;
		if(bean.getPlateDeployRecordId() != null) {
			dao.setConditionPlateDeployRecordId("=", bean.getPlateDeployRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getAdvanceIntegral() != null) {
			dao.setConditionAdvanceIntegral("=", bean.getAdvanceIntegral());
			count++;
		}
		if(bean.getAdvanceDate() != null) {
			dao.setConditionAdvanceDate(">=", bean.getAdvanceDate());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		bean.setDataFromJSON(json);
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateDeployRecord> rlist = new BaseCollection<>();
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateDeployRecord dao = new PlateDeployRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateDeployRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		bean.setDataFromJSON(json);
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		bean.setDataFromJSON(json);
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		bean.setDataFromJSON(json);
		PlateDeployRecord dao = new PlateDeployRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateDeployRecord bean = new BasePlateDeployRecord();
		bean.setDataFromJSON(json);
		PlateDeployRecord dao = new PlateDeployRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


