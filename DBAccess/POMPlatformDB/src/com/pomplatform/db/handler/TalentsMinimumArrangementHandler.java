package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTalentsMinimumArrangement;
import com.pomplatform.db.dao.TalentsMinimumArrangement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TalentsMinimumArrangementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TalentsMinimumArrangementHandler.class);

	public static BaseTalentsMinimumArrangement getTalentsMinimumArrangementById( 
		java.lang.Integer talents_minimum_arrangement_id
	) throws Exception
	{
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setTalentsMinimumArrangementId(talents_minimum_arrangement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTalentsMinimumArrangementExists( com.pomplatform.db.bean.BaseTalentsMinimumArrangement bean, String additional ) throws Exception {

		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTalentsMinimumArrangement( com.pomplatform.db.bean.BaseTalentsMinimumArrangement bean, String additional ) throws Exception {

		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTalentsMinimumArrangement> queryTalentsMinimumArrangement( com.pomplatform.db.bean.BaseTalentsMinimumArrangement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTalentsMinimumArrangement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTalentsMinimumArrangement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTalentsMinimumArrangement addToTalentsMinimumArrangement ( BaseTalentsMinimumArrangement talentsminimumarrangement )  throws Exception {
		return addToTalentsMinimumArrangement ( talentsminimumarrangement , false);
	}

	public static BaseTalentsMinimumArrangement addToTalentsMinimumArrangement ( BaseTalentsMinimumArrangement talentsminimumarrangement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setDataFromBase(talentsminimumarrangement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTalentsMinimumArrangement addUpdateTalentsMinimumArrangement ( BaseTalentsMinimumArrangement talentsminimumarrangement ) throws Exception {
		return addUpdateTalentsMinimumArrangement ( talentsminimumarrangement , false);
	}

	public static BaseTalentsMinimumArrangement addUpdateTalentsMinimumArrangement ( BaseTalentsMinimumArrangement talentsminimumarrangement, boolean singleTransaction  ) throws Exception {
		if(talentsminimumarrangement.getTalentsMinimumArrangementId() == null) return addToTalentsMinimumArrangement(talentsminimumarrangement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setDataFromBase(talentsminimumarrangement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(talentsminimumarrangement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTalentsMinimumArrangement ( BaseTalentsMinimumArrangement bean ) throws Exception {
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTalentsMinimumArrangement updateTalentsMinimumArrangement ( BaseTalentsMinimumArrangement talentsminimumarrangement ) throws Exception {
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setTalentsMinimumArrangementId( talentsminimumarrangement.getTalentsMinimumArrangementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(talentsminimumarrangement);
			result = dao.update();
		}
		return result == 1 ? talentsminimumarrangement : null ;
	}

	public static BaseTalentsMinimumArrangement updateTalentsMinimumArrangementDirect( BaseTalentsMinimumArrangement talentsminimumarrangement ) throws Exception {
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		int result = 0;
		dao.setDataFromBase(talentsminimumarrangement);
		result = dao.update();
		return result == 1 ? talentsminimumarrangement : null ;
	}

	public static int setDeleteConditions(BaseTalentsMinimumArrangement bean, TalentsMinimumArrangement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTalentsMinimumArrangementId() != null) {
			dao.setConditionTalentsMinimumArrangementId("=", bean.getTalentsMinimumArrangementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
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
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
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

	public static int setConditions(BaseTalentsMinimumArrangement bean, TalentsMinimumArrangement dao){
		int count = 0;
		if(bean.getTalentsMinimumArrangementId() != null) {
			dao.setConditionTalentsMinimumArrangementId("=", bean.getTalentsMinimumArrangementId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
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
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTalentsMinimumArrangement> rlist = new BaseCollection<>();
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTalentsMinimumArrangement> result = dao.conditionalLoad(addtion);
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
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTalentsMinimumArrangement bean = new BaseTalentsMinimumArrangement();
		bean.setDataFromJSON(json);
		TalentsMinimumArrangement dao = new TalentsMinimumArrangement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


