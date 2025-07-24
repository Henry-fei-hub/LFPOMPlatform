package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectSettlement;
import java.util.List;
import com.pomplatform.db.dao.ProjectSettlement;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectSettlementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectSettlementHandler.class);

	public static BaseProjectSettlement getProjectSettlementById( 
		java.lang.Integer settlement_id
	) throws Exception
	{
		ProjectSettlement dao = new ProjectSettlement();
		dao.setSettlementId(settlement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectSettlementExists( com.pomplatform.db.bean.BaseProjectSettlement bean, String additional ) throws Exception {

		ProjectSettlement dao = new ProjectSettlement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectSettlement( com.pomplatform.db.bean.BaseProjectSettlement bean, String additional ) throws Exception {

		ProjectSettlement dao = new ProjectSettlement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectSettlement> queryProjectSettlement( com.pomplatform.db.bean.BaseProjectSettlement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectSettlement dao = new ProjectSettlement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectSettlement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectSettlement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectSettlement addToProjectSettlement ( BaseProjectSettlement projectsettlement )  throws Exception {
		return addToProjectSettlement ( projectsettlement , false);
	}

	public static BaseProjectSettlement addToProjectSettlement ( BaseProjectSettlement projectsettlement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectSettlement dao = new ProjectSettlement();
		dao.setDataFromBase(projectsettlement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectSettlement addUpdateProjectSettlement ( BaseProjectSettlement projectsettlement ) throws Exception {
		return addUpdateProjectSettlement ( projectsettlement , false);
	}

	public static BaseProjectSettlement addUpdateProjectSettlement ( BaseProjectSettlement projectsettlement, boolean singleTransaction  ) throws Exception {
		if(projectsettlement.getSettlementId() == null) return addToProjectSettlement(projectsettlement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectSettlement dao = new ProjectSettlement();
		dao.setDataFromBase(projectsettlement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectsettlement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectSettlement ( BaseProjectSettlement bean ) throws Exception {
		ProjectSettlement dao = new ProjectSettlement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectSettlement updateProjectSettlement ( BaseProjectSettlement projectsettlement ) throws Exception {
		ProjectSettlement dao = new ProjectSettlement();
		dao.setSettlementId( projectsettlement.getSettlementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectsettlement);
			result = dao.update();
		}
		return result == 1 ? projectsettlement : null ;
	}

	public static BaseProjectSettlement updateProjectSettlementDirect( BaseProjectSettlement projectsettlement ) throws Exception {
		ProjectSettlement dao = new ProjectSettlement();
		int result = 0;
		dao.setDataFromBase(projectsettlement);
		result = dao.update();
		return result == 1 ? projectsettlement : null ;
	}

	public static int setDeleteConditions(BaseProjectSettlement bean, ProjectSettlement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSettlementId() != null) {
			dao.setConditionSettlementId("=", bean.getSettlementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
				count++;
			}
			if(bean.getSettlementStatus() != null) {
				dao.setConditionSettlementStatus("=", bean.getSettlementStatus());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getTotalCount() != null) {
				dao.setConditionTotalCount("=", bean.getTotalCount());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectSettlement bean, ProjectSettlement dao){
		int count = 0;
		if(bean.getSettlementId() != null) {
			dao.setConditionSettlementId("=", bean.getSettlementId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getSettlementDate() != null) {
			dao.setConditionSettlementDate(">=", bean.getSettlementDate());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getTotalCost() != null) {
			dao.setConditionTotalCost("=", bean.getTotalCost());
			count++;
		}
		if(bean.getProjectAmount() != null) {
			dao.setConditionProjectAmount("=", bean.getProjectAmount());
			count++;
		}
		if(bean.getLeftAmount() != null) {
			dao.setConditionLeftAmount("=", bean.getLeftAmount());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getStageId() != null) {
			dao.setConditionStageId("=", bean.getStageId());
			count++;
		}
		if(bean.getSettlementStatus() != null) {
			dao.setConditionSettlementStatus("=", bean.getSettlementStatus());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		if(bean.getReserveAmount() != null) {
			dao.setConditionReserveAmount("=", bean.getReserveAmount());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getTotalCount() != null) {
			dao.setConditionTotalCount("=", bean.getTotalCount());
			count++;
		}
		if(bean.getSureAmount() != null) {
			dao.setConditionSureAmount("=", bean.getSureAmount());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectSettlement bean = new BaseProjectSettlement();
		bean.setDataFromJSON(json);
		ProjectSettlement dao = new ProjectSettlement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectSettlement> rlist = new BaseCollection<>();
		BaseProjectSettlement bean = new BaseProjectSettlement();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectSettlement dao = new ProjectSettlement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectSettlement> result = dao.conditionalLoad(addtion);
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
		BaseProjectSettlement bean = new BaseProjectSettlement();
		bean.setDataFromJSON(json);
		ProjectSettlement dao = new ProjectSettlement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectSettlement bean = new BaseProjectSettlement();
		bean.setDataFromJSON(json);
		ProjectSettlement dao = new ProjectSettlement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectSettlement bean = new BaseProjectSettlement();
		bean.setDataFromJSON(json);
		ProjectSettlement dao = new ProjectSettlement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectSettlement bean = new BaseProjectSettlement();
		bean.setDataFromJSON(json);
		ProjectSettlement dao = new ProjectSettlement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


