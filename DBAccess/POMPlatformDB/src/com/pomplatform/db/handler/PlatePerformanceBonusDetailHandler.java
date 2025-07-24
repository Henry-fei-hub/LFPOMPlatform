package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlatePerformanceBonusDetail;
import com.pomplatform.db.dao.PlatePerformanceBonusDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlatePerformanceBonusDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlatePerformanceBonusDetailHandler.class);

	public static BasePlatePerformanceBonusDetail getPlatePerformanceBonusDetailById( 
		java.lang.Integer plate_performance_bonus_detail_id
	) throws Exception
	{
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setPlatePerformanceBonusDetailId(plate_performance_bonus_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlatePerformanceBonusDetailExists( com.pomplatform.db.bean.BasePlatePerformanceBonusDetail bean, String additional ) throws Exception {

		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlatePerformanceBonusDetail( com.pomplatform.db.bean.BasePlatePerformanceBonusDetail bean, String additional ) throws Exception {

		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlatePerformanceBonusDetail> queryPlatePerformanceBonusDetail( com.pomplatform.db.bean.BasePlatePerformanceBonusDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlatePerformanceBonusDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlatePerformanceBonusDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlatePerformanceBonusDetail addToPlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail plateperformancebonusdetail )  throws Exception {
		return addToPlatePerformanceBonusDetail ( plateperformancebonusdetail , false);
	}

	public static BasePlatePerformanceBonusDetail addToPlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail plateperformancebonusdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setDataFromBase(plateperformancebonusdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlatePerformanceBonusDetail addUpdatePlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail plateperformancebonusdetail ) throws Exception {
		return addUpdatePlatePerformanceBonusDetail ( plateperformancebonusdetail , false);
	}

	public static BasePlatePerformanceBonusDetail addUpdatePlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail plateperformancebonusdetail, boolean singleTransaction  ) throws Exception {
		if(plateperformancebonusdetail.getPlatePerformanceBonusDetailId() == null) return addToPlatePerformanceBonusDetail(plateperformancebonusdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setDataFromBase(plateperformancebonusdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateperformancebonusdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail bean ) throws Exception {
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlatePerformanceBonusDetail updatePlatePerformanceBonusDetail ( BasePlatePerformanceBonusDetail plateperformancebonusdetail ) throws Exception {
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setPlatePerformanceBonusDetailId( plateperformancebonusdetail.getPlatePerformanceBonusDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateperformancebonusdetail);
			result = dao.update();
		}
		return result == 1 ? plateperformancebonusdetail : null ;
	}

	public static BasePlatePerformanceBonusDetail updatePlatePerformanceBonusDetailDirect( BasePlatePerformanceBonusDetail plateperformancebonusdetail ) throws Exception {
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		int result = 0;
		dao.setDataFromBase(plateperformancebonusdetail);
		result = dao.update();
		return result == 1 ? plateperformancebonusdetail : null ;
	}

	public static int setDeleteConditions(BasePlatePerformanceBonusDetail bean, PlatePerformanceBonusDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlatePerformanceBonusDetailId() != null) {
			dao.setConditionPlatePerformanceBonusDetailId("=", bean.getPlatePerformanceBonusDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlatePerformanceBonusId() != null) {
				dao.setConditionPlatePerformanceBonusId("=", bean.getPlatePerformanceBonusId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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

	public static int setConditions(BasePlatePerformanceBonusDetail bean, PlatePerformanceBonusDetail dao){
		int count = 0;
		if(bean.getPlatePerformanceBonusDetailId() != null) {
			dao.setConditionPlatePerformanceBonusDetailId("=", bean.getPlatePerformanceBonusDetailId());
			count++;
		}
		if(bean.getPlatePerformanceBonusId() != null) {
			dao.setConditionPlatePerformanceBonusId("=", bean.getPlatePerformanceBonusId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getSendIntegral() != null) {
			dao.setConditionSendIntegral("=", bean.getSendIntegral());
			count++;
		}
		if(bean.getSendedIntegral() != null) {
			dao.setConditionSendedIntegral("=", bean.getSendedIntegral());
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
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		bean.setDataFromJSON(json);
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlatePerformanceBonusDetail> rlist = new BaseCollection<>();
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlatePerformanceBonusDetail> result = dao.conditionalLoad(addtion);
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
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		bean.setDataFromJSON(json);
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		bean.setDataFromJSON(json);
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		bean.setDataFromJSON(json);
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlatePerformanceBonusDetail bean = new BasePlatePerformanceBonusDetail();
		bean.setDataFromJSON(json);
		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


