package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTeamBuilding;
import com.pomplatform.db.dao.TeamBuilding;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TeamBuildingHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TeamBuildingHandler.class);

	public static BaseTeamBuilding getTeamBuildingById( 
		java.lang.Integer team_building_id
	) throws Exception
	{
		TeamBuilding dao = new TeamBuilding();
		dao.setTeamBuildingId(team_building_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTeamBuildingExists( com.pomplatform.db.bean.BaseTeamBuilding bean, String additional ) throws Exception {

		TeamBuilding dao = new TeamBuilding();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTeamBuilding( com.pomplatform.db.bean.BaseTeamBuilding bean, String additional ) throws Exception {

		TeamBuilding dao = new TeamBuilding();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTeamBuilding> queryTeamBuilding( com.pomplatform.db.bean.BaseTeamBuilding bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TeamBuilding dao = new TeamBuilding();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTeamBuilding> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTeamBuilding> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTeamBuilding addToTeamBuilding ( BaseTeamBuilding teambuilding )  throws Exception {
		return addToTeamBuilding ( teambuilding , false);
	}

	public static BaseTeamBuilding addToTeamBuilding ( BaseTeamBuilding teambuilding, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TeamBuilding dao = new TeamBuilding();
		dao.setDataFromBase(teambuilding);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTeamBuilding addUpdateTeamBuilding ( BaseTeamBuilding teambuilding ) throws Exception {
		return addUpdateTeamBuilding ( teambuilding , false);
	}

	public static BaseTeamBuilding addUpdateTeamBuilding ( BaseTeamBuilding teambuilding, boolean singleTransaction  ) throws Exception {
		if(teambuilding.getTeamBuildingId() == null) return addToTeamBuilding(teambuilding);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TeamBuilding dao = new TeamBuilding();
		dao.setDataFromBase(teambuilding);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(teambuilding); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTeamBuilding ( BaseTeamBuilding bean ) throws Exception {
		TeamBuilding dao = new TeamBuilding();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTeamBuilding updateTeamBuilding ( BaseTeamBuilding teambuilding ) throws Exception {
		TeamBuilding dao = new TeamBuilding();
		dao.setTeamBuildingId( teambuilding.getTeamBuildingId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(teambuilding);
			result = dao.update();
		}
		return result == 1 ? teambuilding : null ;
	}

	public static BaseTeamBuilding updateTeamBuildingDirect( BaseTeamBuilding teambuilding ) throws Exception {
		TeamBuilding dao = new TeamBuilding();
		int result = 0;
		dao.setDataFromBase(teambuilding);
		result = dao.update();
		return result == 1 ? teambuilding : null ;
	}

	public static int setDeleteConditions(BaseTeamBuilding bean, TeamBuilding dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTeamBuildingId() != null) {
			dao.setConditionTeamBuildingId("=", bean.getTeamBuildingId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOrderId() != null) {
				dao.setConditionOrderId("=", bean.getOrderId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getRate() != null) {
				dao.setConditionRate("=", bean.getRate());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTeamBuilding bean, TeamBuilding dao){
		int count = 0;
		if(bean.getTeamBuildingId() != null) {
			dao.setConditionTeamBuildingId("=", bean.getTeamBuildingId());
			count++;
		}
		if(bean.getOrderId() != null) {
			if(bean.getOrderId().indexOf("%") >= 0)
				dao.setConditionOrderId("like", bean.getOrderId());
			else
				dao.setConditionOrderId("=", bean.getOrderId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getRate() != null) {
			dao.setConditionRate("=", bean.getRate());
			count++;
		}
		if(bean.getSettlement() != null) {
			dao.setConditionSettlement("=", bean.getSettlement());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTeamBuilding bean = new BaseTeamBuilding();
		bean.setDataFromJSON(json);
		TeamBuilding dao = new TeamBuilding();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTeamBuilding> rlist = new BaseCollection<>();
		BaseTeamBuilding bean = new BaseTeamBuilding();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TeamBuilding dao = new TeamBuilding();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTeamBuilding> result = dao.conditionalLoad(addtion);
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
		BaseTeamBuilding bean = new BaseTeamBuilding();
		bean.setDataFromJSON(json);
		TeamBuilding dao = new TeamBuilding();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTeamBuilding bean = new BaseTeamBuilding();
		bean.setDataFromJSON(json);
		TeamBuilding dao = new TeamBuilding();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTeamBuilding bean = new BaseTeamBuilding();
		bean.setDataFromJSON(json);
		TeamBuilding dao = new TeamBuilding();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTeamBuilding bean = new BaseTeamBuilding();
		bean.setDataFromJSON(json);
		TeamBuilding dao = new TeamBuilding();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


