package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMainProjectStage;
import java.util.List;
import com.pomplatform.db.dao.MainProjectStage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MainProjectStageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectStageHandler.class);

	public static BaseMainProjectStage getMainProjectStageById( 
		java.lang.Integer main_project_stage_id
	) throws Exception
	{
		MainProjectStage dao = new MainProjectStage();
		dao.setMainProjectStageId(main_project_stage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectStageExists( com.pomplatform.db.bean.BaseMainProjectStage bean, String additional ) throws Exception {

		MainProjectStage dao = new MainProjectStage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectStage( com.pomplatform.db.bean.BaseMainProjectStage bean, String additional ) throws Exception {

		MainProjectStage dao = new MainProjectStage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectStage> queryMainProjectStage( com.pomplatform.db.bean.BaseMainProjectStage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectStage dao = new MainProjectStage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectStage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectStage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectStage addToMainProjectStage ( BaseMainProjectStage mainprojectstage )  throws Exception {
		return addToMainProjectStage ( mainprojectstage , false);
	}

	public static BaseMainProjectStage addToMainProjectStage ( BaseMainProjectStage mainprojectstage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectStage dao = new MainProjectStage();
		dao.setDataFromBase(mainprojectstage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectStage addUpdateMainProjectStage ( BaseMainProjectStage mainprojectstage ) throws Exception {
		return addUpdateMainProjectStage ( mainprojectstage , false);
	}

	public static BaseMainProjectStage addUpdateMainProjectStage ( BaseMainProjectStage mainprojectstage, boolean singleTransaction  ) throws Exception {
		if(mainprojectstage.getMainProjectStageId() == null) return addToMainProjectStage(mainprojectstage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectStage dao = new MainProjectStage();
		dao.setDataFromBase(mainprojectstage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectstage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectStage ( BaseMainProjectStage bean ) throws Exception {
		MainProjectStage dao = new MainProjectStage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectStage updateMainProjectStage ( BaseMainProjectStage mainprojectstage ) throws Exception {
		MainProjectStage dao = new MainProjectStage();
		dao.setMainProjectStageId( mainprojectstage.getMainProjectStageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectstage);
			result = dao.update();
		}
		return result == 1 ? mainprojectstage : null ;
	}

	public static BaseMainProjectStage updateMainProjectStageDirect( BaseMainProjectStage mainprojectstage ) throws Exception {
		MainProjectStage dao = new MainProjectStage();
		int result = 0;
		dao.setDataFromBase(mainprojectstage);
		result = dao.update();
		return result == 1 ? mainprojectstage : null ;
	}

	public static int setDeleteConditions(BaseMainProjectStage bean, MainProjectStage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectStageId() != null) {
			dao.setConditionMainProjectStageId("=", bean.getMainProjectStageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainStageId() != null) {
				dao.setConditionMainStageId("=", bean.getMainStageId());
				count++;
			}
			if(bean.getMainStageCode() != null) {
				dao.setConditionMainStageCode("=", bean.getMainStageCode());
				count++;
			}
			if(bean.getMainStageName() != null) {
				dao.setConditionMainStageName("=", bean.getMainStageName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectStage bean, MainProjectStage dao){
		int count = 0;
		if(bean.getMainProjectStageId() != null) {
			dao.setConditionMainProjectStageId("=", bean.getMainProjectStageId());
			count++;
		}
		if(bean.getMainStageId() != null) {
			dao.setConditionMainStageId("=", bean.getMainStageId());
			count++;
		}
		if(bean.getMainStageCode() != null) {
			if(bean.getMainStageCode().indexOf("%") >= 0)
				dao.setConditionMainStageCode("like", bean.getMainStageCode());
			else
				dao.setConditionMainStageCode("=", bean.getMainStageCode());
			count++;
		}
		if(bean.getMainStageName() != null) {
			if(bean.getMainStageName().indexOf("%") >= 0)
				dao.setConditionMainStageName("like", bean.getMainStageName());
			else
				dao.setConditionMainStageName("=", bean.getMainStageName());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectStage bean = new BaseMainProjectStage();
		bean.setDataFromJSON(json);
		MainProjectStage dao = new MainProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectStage> rlist = new BaseCollection<>();
		BaseMainProjectStage bean = new BaseMainProjectStage();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectStage dao = new MainProjectStage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectStage> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectStage bean = new BaseMainProjectStage();
		bean.setDataFromJSON(json);
		MainProjectStage dao = new MainProjectStage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectStage bean = new BaseMainProjectStage();
		bean.setDataFromJSON(json);
		MainProjectStage dao = new MainProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectStage bean = new BaseMainProjectStage();
		bean.setDataFromJSON(json);
		MainProjectStage dao = new MainProjectStage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectStage bean = new BaseMainProjectStage();
		bean.setDataFromJSON(json);
		MainProjectStage dao = new MainProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


