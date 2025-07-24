package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralSumRecord;
import com.pomplatform.db.dao.PlateIntegralSumRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralSumRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralSumRecordHandler.class);

	public static BasePlateIntegralSumRecord getPlateIntegralSumRecordById( 
		java.lang.Integer plate_integral_sum_record_id
	) throws Exception
	{
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setPlateIntegralSumRecordId(plate_integral_sum_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralSumRecordExists( com.pomplatform.db.bean.BasePlateIntegralSumRecord bean, String additional ) throws Exception {

		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralSumRecord( com.pomplatform.db.bean.BasePlateIntegralSumRecord bean, String additional ) throws Exception {

		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralSumRecord> queryPlateIntegralSumRecord( com.pomplatform.db.bean.BasePlateIntegralSumRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralSumRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralSumRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralSumRecord addToPlateIntegralSumRecord ( BasePlateIntegralSumRecord plateintegralsumrecord )  throws Exception {
		return addToPlateIntegralSumRecord ( plateintegralsumrecord , false);
	}

	public static BasePlateIntegralSumRecord addToPlateIntegralSumRecord ( BasePlateIntegralSumRecord plateintegralsumrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setDataFromBase(plateintegralsumrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralSumRecord addUpdatePlateIntegralSumRecord ( BasePlateIntegralSumRecord plateintegralsumrecord ) throws Exception {
		return addUpdatePlateIntegralSumRecord ( plateintegralsumrecord , false);
	}

	public static BasePlateIntegralSumRecord addUpdatePlateIntegralSumRecord ( BasePlateIntegralSumRecord plateintegralsumrecord, boolean singleTransaction  ) throws Exception {
		if(plateintegralsumrecord.getPlateIntegralSumRecordId() == null) return addToPlateIntegralSumRecord(plateintegralsumrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setDataFromBase(plateintegralsumrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegralsumrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralSumRecord ( BasePlateIntegralSumRecord bean ) throws Exception {
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralSumRecord updatePlateIntegralSumRecord ( BasePlateIntegralSumRecord plateintegralsumrecord ) throws Exception {
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setPlateIntegralSumRecordId( plateintegralsumrecord.getPlateIntegralSumRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegralsumrecord);
			result = dao.update();
		}
		return result == 1 ? plateintegralsumrecord : null ;
	}

	public static BasePlateIntegralSumRecord updatePlateIntegralSumRecordDirect( BasePlateIntegralSumRecord plateintegralsumrecord ) throws Exception {
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		int result = 0;
		dao.setDataFromBase(plateintegralsumrecord);
		result = dao.update();
		return result == 1 ? plateintegralsumrecord : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralSumRecord bean, PlateIntegralSumRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralSumRecordId() != null) {
			dao.setConditionPlateIntegralSumRecordId("=", bean.getPlateIntegralSumRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getTypeFlag() != null) {
				dao.setConditionTypeFlag("=", bean.getTypeFlag());
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

	public static int setConditions(BasePlateIntegralSumRecord bean, PlateIntegralSumRecord dao){
		int count = 0;
		if(bean.getPlateIntegralSumRecordId() != null) {
			dao.setConditionPlateIntegralSumRecordId("=", bean.getPlateIntegralSumRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getTypeFlag() != null) {
			dao.setConditionTypeFlag("=", bean.getTypeFlag());
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
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getProjectIntegralSum() != null) {
			dao.setConditionProjectIntegralSum("=", bean.getProjectIntegralSum());
			count++;
		}
		if(bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if(bean.getReserveIntegral() != null) {
			dao.setConditionReserveIntegral("=", bean.getReserveIntegral());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getCostIntegral() != null) {
			dao.setConditionCostIntegral("=", bean.getCostIntegral());
			count++;
		}
		if(bean.getSalaryIntegral() != null) {
			dao.setConditionSalaryIntegral("=", bean.getSalaryIntegral());
			count++;
		}
		if(bean.getSettlementIntegral() != null) {
			dao.setConditionSettlementIntegral("=", bean.getSettlementIntegral());
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
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		bean.setDataFromJSON(json);
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralSumRecord> rlist = new BaseCollection<>();
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralSumRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		bean.setDataFromJSON(json);
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		bean.setDataFromJSON(json);
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		bean.setDataFromJSON(json);
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
		bean.setDataFromJSON(json);
		PlateIntegralSumRecord dao = new PlateIntegralSumRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


