package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStageModel;
import com.pomplatform.db.dao.StageModel;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StageModelHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StageModelHandler.class);

	public static BaseStageModel getStageModelById( 
		java.lang.Integer stage_model_id
	) throws Exception
	{
		StageModel dao = new StageModel();
		dao.setStageModelId(stage_model_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStageModelExists( com.pomplatform.db.bean.BaseStageModel bean, String additional ) throws Exception {

		StageModel dao = new StageModel();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStageModel( com.pomplatform.db.bean.BaseStageModel bean, String additional ) throws Exception {

		StageModel dao = new StageModel();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStageModel> queryStageModel( com.pomplatform.db.bean.BaseStageModel bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StageModel dao = new StageModel();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStageModel> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStageModel> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStageModel addToStageModel ( BaseStageModel stagemodel )  throws Exception {
		return addToStageModel ( stagemodel , false);
	}

	public static BaseStageModel addToStageModel ( BaseStageModel stagemodel, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StageModel dao = new StageModel();
		dao.setDataFromBase(stagemodel);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStageModel addUpdateStageModel ( BaseStageModel stagemodel ) throws Exception {
		return addUpdateStageModel ( stagemodel , false);
	}

	public static BaseStageModel addUpdateStageModel ( BaseStageModel stagemodel, boolean singleTransaction  ) throws Exception {
		if(stagemodel.getStageModelId() == null) return addToStageModel(stagemodel);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StageModel dao = new StageModel();
		dao.setDataFromBase(stagemodel);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(stagemodel); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStageModel ( BaseStageModel bean ) throws Exception {
		StageModel dao = new StageModel();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStageModel updateStageModel ( BaseStageModel stagemodel ) throws Exception {
		StageModel dao = new StageModel();
		dao.setStageModelId( stagemodel.getStageModelId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(stagemodel);
			result = dao.update();
		}
		return result == 1 ? stagemodel : null ;
	}

	public static BaseStageModel updateStageModelDirect( BaseStageModel stagemodel ) throws Exception {
		StageModel dao = new StageModel();
		int result = 0;
		dao.setDataFromBase(stagemodel);
		result = dao.update();
		return result == 1 ? stagemodel : null ;
	}

	public static int setDeleteConditions(BaseStageModel bean, StageModel dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStageModelId() != null) {
			dao.setConditionStageModelId("=", bean.getStageModelId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getStageModelName() != null) {
				dao.setConditionStageModelName("=", bean.getStageModelName());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getLeafNode() != null) {
				dao.setConditionLeafNode("=", bean.getLeafNode());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getNeedManagerAudit() != null) {
				dao.setConditionNeedManagerAudit("=", bean.getNeedManagerAudit());
				count++;
			}
			if(bean.getNeedDesignDirectorAudit() != null) {
				dao.setConditionNeedDesignDirectorAudit("=", bean.getNeedDesignDirectorAudit());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStageModel bean, StageModel dao){
		int count = 0;
		if(bean.getStageModelId() != null) {
			dao.setConditionStageModelId("=", bean.getStageModelId());
			count++;
		}
		if(bean.getStageModelName() != null) {
			if(bean.getStageModelName().indexOf("%") >= 0)
				dao.setConditionStageModelName("like", bean.getStageModelName());
			else
				dao.setConditionStageModelName("=", bean.getStageModelName());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getLeafNode() != null) {
			dao.setConditionLeafNode("=", bean.getLeafNode());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getNeedManagerAudit() != null) {
			dao.setConditionNeedManagerAudit("=", bean.getNeedManagerAudit());
			count++;
		}
		if(bean.getNeedDesignDirectorAudit() != null) {
			dao.setConditionNeedDesignDirectorAudit("=", bean.getNeedDesignDirectorAudit());
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
		BaseStageModel bean = new BaseStageModel();
		bean.setDataFromJSON(json);
		StageModel dao = new StageModel();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStageModel> rlist = new BaseCollection<>();
		BaseStageModel bean = new BaseStageModel();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StageModel dao = new StageModel();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStageModel> result = dao.conditionalLoad(addtion);
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
		BaseStageModel bean = new BaseStageModel();
		bean.setDataFromJSON(json);
		StageModel dao = new StageModel();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStageModel bean = new BaseStageModel();
		bean.setDataFromJSON(json);
		StageModel dao = new StageModel();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStageModel bean = new BaseStageModel();
		bean.setDataFromJSON(json);
		StageModel dao = new StageModel();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStageModel bean = new BaseStageModel();
		bean.setDataFromJSON(json);
		StageModel dao = new StageModel();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


