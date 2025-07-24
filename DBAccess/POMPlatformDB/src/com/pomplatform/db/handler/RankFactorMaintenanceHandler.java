package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseRankFactorMaintenance;
import java.util.List;
import com.pomplatform.db.dao.RankFactorMaintenance;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class RankFactorMaintenanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RankFactorMaintenanceHandler.class);

	public static BaseRankFactorMaintenance getRankFactorMaintenanceById( 
		java.lang.Integer rank_factor_maintenance_id
	) throws Exception
	{
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setRankFactorMaintenanceId(rank_factor_maintenance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRankFactorMaintenanceExists( com.pomplatform.db.bean.BaseRankFactorMaintenance bean, String additional ) throws Exception {

		RankFactorMaintenance dao = new RankFactorMaintenance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRankFactorMaintenance( com.pomplatform.db.bean.BaseRankFactorMaintenance bean, String additional ) throws Exception {

		RankFactorMaintenance dao = new RankFactorMaintenance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRankFactorMaintenance> queryRankFactorMaintenance( com.pomplatform.db.bean.BaseRankFactorMaintenance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RankFactorMaintenance dao = new RankFactorMaintenance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRankFactorMaintenance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRankFactorMaintenance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRankFactorMaintenance addToRankFactorMaintenance ( BaseRankFactorMaintenance rankfactormaintenance )  throws Exception {
		return addToRankFactorMaintenance ( rankfactormaintenance , false);
	}

	public static BaseRankFactorMaintenance addToRankFactorMaintenance ( BaseRankFactorMaintenance rankfactormaintenance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setDataFromBase(rankfactormaintenance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRankFactorMaintenance addUpdateRankFactorMaintenance ( BaseRankFactorMaintenance rankfactormaintenance ) throws Exception {
		return addUpdateRankFactorMaintenance ( rankfactormaintenance , false);
	}

	public static BaseRankFactorMaintenance addUpdateRankFactorMaintenance ( BaseRankFactorMaintenance rankfactormaintenance, boolean singleTransaction  ) throws Exception {
		if(rankfactormaintenance.getRankFactorMaintenanceId() == null) return addToRankFactorMaintenance(rankfactormaintenance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setDataFromBase(rankfactormaintenance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(rankfactormaintenance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRankFactorMaintenance ( BaseRankFactorMaintenance bean ) throws Exception {
		RankFactorMaintenance dao = new RankFactorMaintenance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRankFactorMaintenance updateRankFactorMaintenance ( BaseRankFactorMaintenance rankfactormaintenance ) throws Exception {
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setRankFactorMaintenanceId( rankfactormaintenance.getRankFactorMaintenanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(rankfactormaintenance);
			result = dao.update();
		}
		return result == 1 ? rankfactormaintenance : null ;
	}

	public static BaseRankFactorMaintenance updateRankFactorMaintenanceDirect( BaseRankFactorMaintenance rankfactormaintenance ) throws Exception {
		RankFactorMaintenance dao = new RankFactorMaintenance();
		int result = 0;
		dao.setDataFromBase(rankfactormaintenance);
		result = dao.update();
		return result == 1 ? rankfactormaintenance : null ;
	}

	public static int setDeleteConditions(BaseRankFactorMaintenance bean, RankFactorMaintenance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRankFactorMaintenanceId() != null) {
			dao.setConditionRankFactorMaintenanceId("=", bean.getRankFactorMaintenanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getRankId() != null) {
				dao.setConditionRankId("=", bean.getRankId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRankFactorMaintenance bean, RankFactorMaintenance dao){
		int count = 0;
		if(bean.getRankFactorMaintenanceId() != null) {
			dao.setConditionRankFactorMaintenanceId("=", bean.getRankFactorMaintenanceId());
			count++;
		}
		if(bean.getRankId() != null) {
			dao.setConditionRankId("=", bean.getRankId());
			count++;
		}
		if(bean.getCoefficient() != null) {
			dao.setConditionCoefficient("=", bean.getCoefficient());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		bean.setDataFromJSON(json);
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRankFactorMaintenance> rlist = new BaseCollection<>();
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RankFactorMaintenance dao = new RankFactorMaintenance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRankFactorMaintenance> result = dao.conditionalLoad(addtion);
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
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		bean.setDataFromJSON(json);
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		bean.setDataFromJSON(json);
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		bean.setDataFromJSON(json);
		RankFactorMaintenance dao = new RankFactorMaintenance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRankFactorMaintenance bean = new BaseRankFactorMaintenance();
		bean.setDataFromJSON(json);
		RankFactorMaintenance dao = new RankFactorMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


