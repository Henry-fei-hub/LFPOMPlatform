package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralAchieve;
import com.pomplatform.db.dao.PlateIntegralAchieve;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralAchieveHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralAchieveHandler.class);

	public static BasePlateIntegralAchieve getPlateIntegralAchieveById( 
		java.lang.Integer plate_integral_achieve_id
	) throws Exception
	{
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setPlateIntegralAchieveId(plate_integral_achieve_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralAchieveExists( com.pomplatform.db.bean.BasePlateIntegralAchieve bean, String additional ) throws Exception {

		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralAchieve( com.pomplatform.db.bean.BasePlateIntegralAchieve bean, String additional ) throws Exception {

		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralAchieve> queryPlateIntegralAchieve( com.pomplatform.db.bean.BasePlateIntegralAchieve bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralAchieve> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralAchieve> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralAchieve addToPlateIntegralAchieve ( BasePlateIntegralAchieve plateintegralachieve )  throws Exception {
		return addToPlateIntegralAchieve ( plateintegralachieve , false);
	}

	public static BasePlateIntegralAchieve addToPlateIntegralAchieve ( BasePlateIntegralAchieve plateintegralachieve, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setDataFromBase(plateintegralachieve);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralAchieve addUpdatePlateIntegralAchieve ( BasePlateIntegralAchieve plateintegralachieve ) throws Exception {
		return addUpdatePlateIntegralAchieve ( plateintegralachieve , false);
	}

	public static BasePlateIntegralAchieve addUpdatePlateIntegralAchieve ( BasePlateIntegralAchieve plateintegralachieve, boolean singleTransaction  ) throws Exception {
		if(plateintegralachieve.getPlateIntegralAchieveId() == null) return addToPlateIntegralAchieve(plateintegralachieve);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setDataFromBase(plateintegralachieve);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegralachieve); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralAchieve ( BasePlateIntegralAchieve bean ) throws Exception {
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralAchieve updatePlateIntegralAchieve ( BasePlateIntegralAchieve plateintegralachieve ) throws Exception {
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setPlateIntegralAchieveId( plateintegralachieve.getPlateIntegralAchieveId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegralachieve);
			result = dao.update();
		}
		return result == 1 ? plateintegralachieve : null ;
	}

	public static BasePlateIntegralAchieve updatePlateIntegralAchieveDirect( BasePlateIntegralAchieve plateintegralachieve ) throws Exception {
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		int result = 0;
		dao.setDataFromBase(plateintegralachieve);
		result = dao.update();
		return result == 1 ? plateintegralachieve : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralAchieve bean, PlateIntegralAchieve dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralAchieveId() != null) {
			dao.setConditionPlateIntegralAchieveId("=", bean.getPlateIntegralAchieveId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFromPlateId() != null) {
				dao.setConditionFromPlateId("=", bean.getFromPlateId());
				count++;
			}
			if(bean.getToPlateId() != null) {
				dao.setConditionToPlateId("=", bean.getToPlateId());
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

	public static int setConditions(BasePlateIntegralAchieve bean, PlateIntegralAchieve dao){
		int count = 0;
		if(bean.getPlateIntegralAchieveId() != null) {
			dao.setConditionPlateIntegralAchieveId("=", bean.getPlateIntegralAchieveId());
			count++;
		}
		if(bean.getFromPlateId() != null) {
			dao.setConditionFromPlateId("=", bean.getFromPlateId());
			count++;
		}
		if(bean.getToPlateId() != null) {
			dao.setConditionToPlateId("=", bean.getToPlateId());
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
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		bean.setDataFromJSON(json);
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralAchieve> rlist = new BaseCollection<>();
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralAchieve> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		bean.setDataFromJSON(json);
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		bean.setDataFromJSON(json);
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		bean.setDataFromJSON(json);
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
		bean.setDataFromJSON(json);
		PlateIntegralAchieve dao = new PlateIntegralAchieve();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


