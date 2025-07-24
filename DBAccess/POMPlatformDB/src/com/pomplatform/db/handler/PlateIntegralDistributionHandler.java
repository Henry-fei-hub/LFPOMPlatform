package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralDistribution;
import com.pomplatform.db.dao.PlateIntegralDistribution;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralDistributionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralDistributionHandler.class);

	public static BasePlateIntegralDistribution getPlateIntegralDistributionById( 
		java.lang.Integer plate_integral_distribution_id
	) throws Exception
	{
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setPlateIntegralDistributionId(plate_integral_distribution_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralDistributionExists( com.pomplatform.db.bean.BasePlateIntegralDistribution bean, String additional ) throws Exception {

		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralDistribution( com.pomplatform.db.bean.BasePlateIntegralDistribution bean, String additional ) throws Exception {

		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralDistribution> queryPlateIntegralDistribution( com.pomplatform.db.bean.BasePlateIntegralDistribution bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralDistribution> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralDistribution> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralDistribution addToPlateIntegralDistribution ( BasePlateIntegralDistribution plateintegraldistribution )  throws Exception {
		return addToPlateIntegralDistribution ( plateintegraldistribution , false);
	}

	public static BasePlateIntegralDistribution addToPlateIntegralDistribution ( BasePlateIntegralDistribution plateintegraldistribution, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setDataFromBase(plateintegraldistribution);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralDistribution addUpdatePlateIntegralDistribution ( BasePlateIntegralDistribution plateintegraldistribution ) throws Exception {
		return addUpdatePlateIntegralDistribution ( plateintegraldistribution , false);
	}

	public static BasePlateIntegralDistribution addUpdatePlateIntegralDistribution ( BasePlateIntegralDistribution plateintegraldistribution, boolean singleTransaction  ) throws Exception {
		if(plateintegraldistribution.getPlateIntegralDistributionId() == null) return addToPlateIntegralDistribution(plateintegraldistribution);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setDataFromBase(plateintegraldistribution);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegraldistribution); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralDistribution ( BasePlateIntegralDistribution bean ) throws Exception {
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralDistribution updatePlateIntegralDistribution ( BasePlateIntegralDistribution plateintegraldistribution ) throws Exception {
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setPlateIntegralDistributionId( plateintegraldistribution.getPlateIntegralDistributionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegraldistribution);
			result = dao.update();
		}
		return result == 1 ? plateintegraldistribution : null ;
	}

	public static BasePlateIntegralDistribution updatePlateIntegralDistributionDirect( BasePlateIntegralDistribution plateintegraldistribution ) throws Exception {
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		int result = 0;
		dao.setDataFromBase(plateintegraldistribution);
		result = dao.update();
		return result == 1 ? plateintegraldistribution : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralDistribution bean, PlateIntegralDistribution dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralDistributionId() != null) {
			dao.setConditionPlateIntegralDistributionId("=", bean.getPlateIntegralDistributionId());
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

	public static int setConditions(BasePlateIntegralDistribution bean, PlateIntegralDistribution dao){
		int count = 0;
		if(bean.getPlateIntegralDistributionId() != null) {
			dao.setConditionPlateIntegralDistributionId("=", bean.getPlateIntegralDistributionId());
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
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		bean.setDataFromJSON(json);
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralDistribution> rlist = new BaseCollection<>();
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralDistribution> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		bean.setDataFromJSON(json);
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		bean.setDataFromJSON(json);
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		bean.setDataFromJSON(json);
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralDistribution bean = new BasePlateIntegralDistribution();
		bean.setDataFromJSON(json);
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


