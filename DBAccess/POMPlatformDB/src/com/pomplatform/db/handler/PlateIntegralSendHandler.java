package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.dao.PlateIntegralSend;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralSendHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralSendHandler.class);

	public static BasePlateIntegralSend getPlateIntegralSendById( 
		java.lang.Integer plate_integral_send_id
	) throws Exception
	{
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPlateIntegralSendId(plate_integral_send_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralSendExists( com.pomplatform.db.bean.BasePlateIntegralSend bean, String additional ) throws Exception {

		PlateIntegralSend dao = new PlateIntegralSend();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralSend( com.pomplatform.db.bean.BasePlateIntegralSend bean, String additional ) throws Exception {

		PlateIntegralSend dao = new PlateIntegralSend();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralSend> queryPlateIntegralSend( com.pomplatform.db.bean.BasePlateIntegralSend bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralSend dao = new PlateIntegralSend();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralSend> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralSend> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralSend addToPlateIntegralSend ( BasePlateIntegralSend plateintegralsend )  throws Exception {
		return addToPlateIntegralSend ( plateintegralsend , false);
	}

	public static BasePlateIntegralSend addToPlateIntegralSend ( BasePlateIntegralSend plateintegralsend, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setDataFromBase(plateintegralsend);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralSend addUpdatePlateIntegralSend ( BasePlateIntegralSend plateintegralsend ) throws Exception {
		return addUpdatePlateIntegralSend ( plateintegralsend , false);
	}

	public static BasePlateIntegralSend addUpdatePlateIntegralSend ( BasePlateIntegralSend plateintegralsend, boolean singleTransaction  ) throws Exception {
		if(plateintegralsend.getPlateIntegralSendId() == null) return addToPlateIntegralSend(plateintegralsend);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setDataFromBase(plateintegralsend);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegralsend); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralSend ( BasePlateIntegralSend bean ) throws Exception {
		PlateIntegralSend dao = new PlateIntegralSend();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralSend updatePlateIntegralSend ( BasePlateIntegralSend plateintegralsend ) throws Exception {
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPlateIntegralSendId( plateintegralsend.getPlateIntegralSendId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegralsend);
			result = dao.update();
		}
		return result == 1 ? plateintegralsend : null ;
	}

	public static BasePlateIntegralSend updatePlateIntegralSendDirect( BasePlateIntegralSend plateintegralsend ) throws Exception {
		PlateIntegralSend dao = new PlateIntegralSend();
		int result = 0;
		dao.setDataFromBase(plateintegralsend);
		result = dao.update();
		return result == 1 ? plateintegralsend : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralSend bean, PlateIntegralSend dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralSendId() != null) {
			dao.setConditionPlateIntegralSendId("=", bean.getPlateIntegralSendId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateIntegralSend bean, PlateIntegralSend dao){
		int count = 0;
		if(bean.getPlateIntegralSendId() != null) {
			dao.setConditionPlateIntegralSendId("=", bean.getPlateIntegralSendId());
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
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralSend> rlist = new BaseCollection<>();
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralSend dao = new PlateIntegralSend();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralSend> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


