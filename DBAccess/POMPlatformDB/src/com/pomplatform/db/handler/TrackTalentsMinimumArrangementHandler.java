package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTrackTalentsMinimumArrangement;
import com.pomplatform.db.dao.TrackTalentsMinimumArrangement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TrackTalentsMinimumArrangementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TrackTalentsMinimumArrangementHandler.class);

	public static BaseTrackTalentsMinimumArrangement getTrackTalentsMinimumArrangementById( 
		java.lang.Integer track_talents_minimum_arrangement_id
	) throws Exception
	{
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setTrackTalentsMinimumArrangementId(track_talents_minimum_arrangement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTrackTalentsMinimumArrangementExists( com.pomplatform.db.bean.BaseTrackTalentsMinimumArrangement bean, String additional ) throws Exception {

		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTrackTalentsMinimumArrangement( com.pomplatform.db.bean.BaseTrackTalentsMinimumArrangement bean, String additional ) throws Exception {

		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTrackTalentsMinimumArrangement> queryTrackTalentsMinimumArrangement( com.pomplatform.db.bean.BaseTrackTalentsMinimumArrangement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTrackTalentsMinimumArrangement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTrackTalentsMinimumArrangement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTrackTalentsMinimumArrangement addToTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement )  throws Exception {
		return addToTrackTalentsMinimumArrangement ( tracktalentsminimumarrangement , false);
	}

	public static BaseTrackTalentsMinimumArrangement addToTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setDataFromBase(tracktalentsminimumarrangement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTrackTalentsMinimumArrangement addUpdateTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement ) throws Exception {
		return addUpdateTrackTalentsMinimumArrangement ( tracktalentsminimumarrangement , false);
	}

	public static BaseTrackTalentsMinimumArrangement addUpdateTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement, boolean singleTransaction  ) throws Exception {
		if(tracktalentsminimumarrangement.getTrackTalentsMinimumArrangementId() == null) return addToTrackTalentsMinimumArrangement(tracktalentsminimumarrangement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setDataFromBase(tracktalentsminimumarrangement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(tracktalentsminimumarrangement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement bean ) throws Exception {
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTrackTalentsMinimumArrangement updateTrackTalentsMinimumArrangement ( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement ) throws Exception {
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setTrackTalentsMinimumArrangementId( tracktalentsminimumarrangement.getTrackTalentsMinimumArrangementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(tracktalentsminimumarrangement);
			result = dao.update();
		}
		return result == 1 ? tracktalentsminimumarrangement : null ;
	}

	public static BaseTrackTalentsMinimumArrangement updateTrackTalentsMinimumArrangementDirect( BaseTrackTalentsMinimumArrangement tracktalentsminimumarrangement ) throws Exception {
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		int result = 0;
		dao.setDataFromBase(tracktalentsminimumarrangement);
		result = dao.update();
		return result == 1 ? tracktalentsminimumarrangement : null ;
	}

	public static int setDeleteConditions(BaseTrackTalentsMinimumArrangement bean, TrackTalentsMinimumArrangement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTrackTalentsMinimumArrangementId() != null) {
			dao.setConditionTrackTalentsMinimumArrangementId("=", bean.getTrackTalentsMinimumArrangementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getHighDesigner() != null) {
				dao.setConditionHighDesigner("=", bean.getHighDesigner());
				count++;
			}
			if(bean.getMiddleDesigner() != null) {
				dao.setConditionMiddleDesigner("=", bean.getMiddleDesigner());
				count++;
			}
			if(bean.getInitialDesigner() != null) {
				dao.setConditionInitialDesigner("=", bean.getInitialDesigner());
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

	public static int setConditions(BaseTrackTalentsMinimumArrangement bean, TrackTalentsMinimumArrangement dao){
		int count = 0;
		if(bean.getTrackTalentsMinimumArrangementId() != null) {
			dao.setConditionTrackTalentsMinimumArrangementId("=", bean.getTrackTalentsMinimumArrangementId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getMaxAmount() != null) {
			dao.setConditionMaxAmount("=", bean.getMaxAmount());
			count++;
		}
		if(bean.getMinAmount() != null) {
			dao.setConditionMinAmount("=", bean.getMinAmount());
			count++;
		}
		if(bean.getHighDesigner() != null) {
			dao.setConditionHighDesigner("=", bean.getHighDesigner());
			count++;
		}
		if(bean.getMiddleDesigner() != null) {
			dao.setConditionMiddleDesigner("=", bean.getMiddleDesigner());
			count++;
		}
		if(bean.getInitialDesigner() != null) {
			dao.setConditionInitialDesigner("=", bean.getInitialDesigner());
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
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTrackTalentsMinimumArrangement> rlist = new BaseCollection<>();
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTrackTalentsMinimumArrangement> result = dao.conditionalLoad(addtion);
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
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTrackTalentsMinimumArrangement bean = new BaseTrackTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TrackTalentsMinimumArrangement dao = new TrackTalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


