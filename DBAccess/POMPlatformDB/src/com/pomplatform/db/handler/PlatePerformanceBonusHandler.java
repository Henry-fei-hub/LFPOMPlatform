package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlatePerformanceBonus;
import com.pomplatform.db.dao.PlatePerformanceBonus;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlatePerformanceBonusHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlatePerformanceBonusHandler.class);

	public static BasePlatePerformanceBonus getPlatePerformanceBonusById( 
		java.lang.Integer plate_performance_bonus_id
	) throws Exception
	{
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setPlatePerformanceBonusId(plate_performance_bonus_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlatePerformanceBonusExists( com.pomplatform.db.bean.BasePlatePerformanceBonus bean, String additional ) throws Exception {

		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlatePerformanceBonus( com.pomplatform.db.bean.BasePlatePerformanceBonus bean, String additional ) throws Exception {

		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlatePerformanceBonus> queryPlatePerformanceBonus( com.pomplatform.db.bean.BasePlatePerformanceBonus bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlatePerformanceBonus> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlatePerformanceBonus> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlatePerformanceBonus addToPlatePerformanceBonus ( BasePlatePerformanceBonus plateperformancebonus )  throws Exception {
		return addToPlatePerformanceBonus ( plateperformancebonus , false);
	}

	public static BasePlatePerformanceBonus addToPlatePerformanceBonus ( BasePlatePerformanceBonus plateperformancebonus, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setDataFromBase(plateperformancebonus);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlatePerformanceBonus addUpdatePlatePerformanceBonus ( BasePlatePerformanceBonus plateperformancebonus ) throws Exception {
		return addUpdatePlatePerformanceBonus ( plateperformancebonus , false);
	}

	public static BasePlatePerformanceBonus addUpdatePlatePerformanceBonus ( BasePlatePerformanceBonus plateperformancebonus, boolean singleTransaction  ) throws Exception {
		if(plateperformancebonus.getPlatePerformanceBonusId() == null) return addToPlatePerformanceBonus(plateperformancebonus);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setDataFromBase(plateperformancebonus);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateperformancebonus); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlatePerformanceBonus ( BasePlatePerformanceBonus bean ) throws Exception {
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlatePerformanceBonus updatePlatePerformanceBonus ( BasePlatePerformanceBonus plateperformancebonus ) throws Exception {
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setPlatePerformanceBonusId( plateperformancebonus.getPlatePerformanceBonusId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateperformancebonus);
			result = dao.update();
		}
		return result == 1 ? plateperformancebonus : null ;
	}

	public static BasePlatePerformanceBonus updatePlatePerformanceBonusDirect( BasePlatePerformanceBonus plateperformancebonus ) throws Exception {
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		int result = 0;
		dao.setDataFromBase(plateperformancebonus);
		result = dao.update();
		return result == 1 ? plateperformancebonus : null ;
	}

	public static int setDeleteConditions(BasePlatePerformanceBonus bean, PlatePerformanceBonus dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlatePerformanceBonusId() != null) {
			dao.setConditionPlatePerformanceBonusId("=", bean.getPlatePerformanceBonusId());
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

	public static int setConditions(BasePlatePerformanceBonus bean, PlatePerformanceBonus dao){
		int count = 0;
		if(bean.getPlatePerformanceBonusId() != null) {
			dao.setConditionPlatePerformanceBonusId("=", bean.getPlatePerformanceBonusId());
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
		if(bean.getSendDate() != null) {
			dao.setConditionSendDate(">=", bean.getSendDate());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		bean.setDataFromJSON(json);
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlatePerformanceBonus> rlist = new BaseCollection<>();
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlatePerformanceBonus> result = dao.conditionalLoad(addtion);
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
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		bean.setDataFromJSON(json);
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		bean.setDataFromJSON(json);
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		bean.setDataFromJSON(json);
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlatePerformanceBonus bean = new BasePlatePerformanceBonus();
		bean.setDataFromJSON(json);
		PlatePerformanceBonus dao = new PlatePerformanceBonus();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


