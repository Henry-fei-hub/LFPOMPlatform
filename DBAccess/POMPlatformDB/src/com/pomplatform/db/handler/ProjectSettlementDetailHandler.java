package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import java.util.List;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectSettlementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectSettlementDetailHandler.class);

	public static BaseProjectSettlementDetail getProjectSettlementDetailById( 
		java.lang.Integer settlement_detail_id
	) throws Exception
	{
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setSettlementDetailId(settlement_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectSettlementDetailExists( com.pomplatform.db.bean.BaseProjectSettlementDetail bean, String additional ) throws Exception {

		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectSettlementDetail( com.pomplatform.db.bean.BaseProjectSettlementDetail bean, String additional ) throws Exception {

		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectSettlementDetail> queryProjectSettlementDetail( com.pomplatform.db.bean.BaseProjectSettlementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectSettlementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectSettlementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectSettlementDetail addToProjectSettlementDetail ( BaseProjectSettlementDetail projectsettlementdetail )  throws Exception {
		return addToProjectSettlementDetail ( projectsettlementdetail , false);
	}

	public static BaseProjectSettlementDetail addToProjectSettlementDetail ( BaseProjectSettlementDetail projectsettlementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setDataFromBase(projectsettlementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectSettlementDetail addUpdateProjectSettlementDetail ( BaseProjectSettlementDetail projectsettlementdetail ) throws Exception {
		return addUpdateProjectSettlementDetail ( projectsettlementdetail , false);
	}

	public static BaseProjectSettlementDetail addUpdateProjectSettlementDetail ( BaseProjectSettlementDetail projectsettlementdetail, boolean singleTransaction  ) throws Exception {
		if(projectsettlementdetail.getSettlementDetailId() == null) return addToProjectSettlementDetail(projectsettlementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setDataFromBase(projectsettlementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectsettlementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectSettlementDetail ( BaseProjectSettlementDetail bean ) throws Exception {
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectSettlementDetail updateProjectSettlementDetail ( BaseProjectSettlementDetail projectsettlementdetail ) throws Exception {
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setSettlementDetailId( projectsettlementdetail.getSettlementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectsettlementdetail);
			result = dao.update();
		}
		return result == 1 ? projectsettlementdetail : null ;
	}

	public static BaseProjectSettlementDetail updateProjectSettlementDetailDirect( BaseProjectSettlementDetail projectsettlementdetail ) throws Exception {
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		int result = 0;
		dao.setDataFromBase(projectsettlementdetail);
		result = dao.update();
		return result == 1 ? projectsettlementdetail : null ;
	}

	public static int setDeleteConditions(BaseProjectSettlementDetail bean, ProjectSettlementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSettlementDetailId() != null) {
			dao.setConditionSettlementDetailId("=", bean.getSettlementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
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
			if(bean.getWorkContent() != null) {
				dao.setConditionWorkContent("=", bean.getWorkContent());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
			if(bean.getSettlementStatus() != null) {
				dao.setConditionSettlementStatus("=", bean.getSettlementStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectSettlementDetail bean, ProjectSettlementDetail dao){
		int count = 0;
		if(bean.getSettlementDetailId() != null) {
			dao.setConditionSettlementDetailId("=", bean.getSettlementDetailId());
			count++;
		}
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
		if(bean.getWorkContent() != null) {
			if(bean.getWorkContent().indexOf("%") >= 0)
				dao.setConditionWorkContent("like", bean.getWorkContent());
			else
				dao.setConditionWorkContent("=", bean.getWorkContent());
			count++;
		}
		if(bean.getSettlementDate() != null) {
			dao.setConditionSettlementDate(">=", bean.getSettlementDate());
			count++;
		}
		if(bean.getPlanAmount() != null) {
			dao.setConditionPlanAmount("=", bean.getPlanAmount());
			count++;
		}
		if(bean.getRealAmount() != null) {
			dao.setConditionRealAmount("=", bean.getRealAmount());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getFinishPercent() != null) {
			dao.setConditionFinishPercent("=", bean.getFinishPercent());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		if(bean.getAdjustedAmount() != null) {
			dao.setConditionAdjustedAmount("=", bean.getAdjustedAmount());
			count++;
		}
		if(bean.getSettlementStatus() != null) {
			dao.setConditionSettlementStatus("=", bean.getSettlementStatus());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getCost() != null) {
			dao.setConditionCost("=", bean.getCost());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectSettlementDetail> rlist = new BaseCollection<>();
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectSettlementDetail> result = dao.conditionalLoad(addtion);
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
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectSettlementDetail bean = new BaseProjectSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


