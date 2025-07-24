package delicacy.workflow.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.workflow.bean.BaseProject;
import delicacy.workflow.dao.Project;

public class ProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectHandler.class);

	public static BaseProject getProjectById( 
		java.lang.Integer project_id
	) throws Exception
	{
		Project dao = new Project();
		dao.setProjectId(project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectExists( delicacy.workflow.bean.BaseProject bean, String additional ) throws Exception {

		Project dao = new Project();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProject( delicacy.workflow.bean.BaseProject bean, String additional ) throws Exception {

		Project dao = new Project();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProject> queryProject( delicacy.workflow.bean.BaseProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Project dao = new Project();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProject addToProject ( BaseProject project )  throws Exception {
		return addToProject ( project , false);
	}

	public static BaseProject addToProject ( BaseProject project, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Project dao = new Project();
		dao.setDataFromBase(project);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProject addUpdateProject ( BaseProject project ) throws Exception {
		return addUpdateProject ( project , false);
	}

	public static BaseProject addUpdateProject ( BaseProject project, boolean singleTransaction  ) throws Exception {
		if(project.getProjectId() == null) return addToProject(project);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Project dao = new Project();
		dao.setDataFromBase(project);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(project); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProject ( BaseProject bean ) throws Exception {
		Project dao = new Project();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProject updateProject ( BaseProject project ) throws Exception {
		Project dao = new Project();
		dao.setProjectId( project.getProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(project);
			result = dao.update();
		}
		return result == 1 ? project : null ;
	}

	public static BaseProject updateProjectDirect( BaseProject project ) throws Exception {
		Project dao = new Project();
		int result = 0;
		dao.setDataFromBase(project);
		result = dao.update();
		return result == 1 ? project : null ;
	}

	public static int setDeleteConditions(BaseProject bean, Project dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDesignType() != null) {
				dao.setConditionDesignType("=", bean.getDesignType());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getDesignPhase() != null) {
				dao.setConditionDesignPhase("=", bean.getDesignPhase());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getWorkHours() != null) {
				dao.setConditionWorkHours("=", bean.getWorkHours());
				count++;
			}
			if(bean.getProjectProgress() != null) {
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
				count++;
			}
			if(bean.getProjectSize() != null) {
				dao.setConditionProjectSize("=", bean.getProjectSize());
				count++;
			}
			if(bean.getProjectDescription() != null) {
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
				count++;
			}
			if(bean.getAuditReason() != null) {
				dao.setConditionAuditReason("=", bean.getAuditReason());
				count++;
			}
			if(bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
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
			if(bean.getProjectGradeType() != null) {
				dao.setConditionProjectGradeType("=", bean.getProjectGradeType());
				count++;
			}
			if(bean.getPlateManagerId() != null) {
				dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProject bean, Project dao){
		int count = 0;
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDesignType() != null) {
			dao.setConditionDesignType("=", bean.getDesignType());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getDesignPhase() != null) {
			dao.setConditionDesignPhase("=", bean.getDesignPhase());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getWorkHours() != null) {
			dao.setConditionWorkHours("=", bean.getWorkHours());
			count++;
		}
		if(bean.getPlanStartDate() != null) {
			dao.setConditionPlanStartDate(">=", bean.getPlanStartDate());
			count++;
		}
		if(bean.getPlanEndDate() != null) {
			dao.setConditionPlanEndDate(">=", bean.getPlanEndDate());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getCommonArea() != null) {
			dao.setConditionCommonArea("=", bean.getCommonArea());
			count++;
		}
		if(bean.getLogisticsArea() != null) {
			dao.setConditionLogisticsArea("=", bean.getLogisticsArea());
			count++;
		}
		if(bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		if(bean.getOldProjectDiscount() != null) {
			dao.setConditionOldProjectDiscount("=", bean.getOldProjectDiscount());
			count++;
		}
		if(bean.getBudget() != null) {
			dao.setConditionBudget("=", bean.getBudget());
			count++;
		}
		if(bean.getTotalIntegral() != null) {
			dao.setConditionTotalIntegral("=", bean.getTotalIntegral());
			count++;
		}
		if(bean.getReserveIntegral() != null) {
			dao.setConditionReserveIntegral("=", bean.getReserveIntegral());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if(bean.getProjectProgress() != null) {
			if(bean.getProjectProgress().indexOf("%") >= 0)
				dao.setConditionProjectProgress("like", bean.getProjectProgress());
			else
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
			count++;
		}
		if(bean.getProjectSize() != null) {
			if(bean.getProjectSize().indexOf("%") >= 0)
				dao.setConditionProjectSize("like", bean.getProjectSize());
			else
				dao.setConditionProjectSize("=", bean.getProjectSize());
			count++;
		}
		if(bean.getProjectDescription() != null) {
			if(bean.getProjectDescription().indexOf("%") >= 0)
				dao.setConditionProjectDescription("like", bean.getProjectDescription());
			else
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
			count++;
		}
		if(bean.getAuditReason() != null) {
			if(bean.getAuditReason().indexOf("%") >= 0)
				dao.setConditionAuditReason("like", bean.getAuditReason());
			else
				dao.setConditionAuditReason("=", bean.getAuditReason());
			count++;
		}
		if(bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if(bean.getBimArea() != null) {
			dao.setConditionBimArea("=", bean.getBimArea());
			count++;
		}
		if(bean.getCadArea() != null) {
			dao.setConditionCadArea("=", bean.getCadArea());
			count++;
		}
		if(bean.getHumanAmount() != null) {
			dao.setConditionHumanAmount("=", bean.getHumanAmount());
			count++;
		}
		if(bean.getAppendTotalIntegral() != null) {
			dao.setConditionAppendTotalIntegral("=", bean.getAppendTotalIntegral());
			count++;
		}
		if(bean.getAppendIntegral() != null) {
			dao.setConditionAppendIntegral("=", bean.getAppendIntegral());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProjectFinishPercent() != null) {
			dao.setConditionProjectFinishPercent("=", bean.getProjectFinishPercent());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getTotalFinishPercent() != null) {
			dao.setConditionTotalFinishPercent("=", bean.getTotalFinishPercent());
			count++;
		}
		if(bean.getProjectGradeType() != null) {
			dao.setConditionProjectGradeType("=", bean.getProjectGradeType());
			count++;
		}
		if(bean.getPlateManagerId() != null) {
			dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
			count++;
		}
		if(bean.getLastPercent() != null) {
			dao.setConditionLastPercent("=", bean.getLastPercent());
			count++;
		}
		if(bean.getComplaintPercentage() != null) {
			dao.setConditionComplaintPercentage("=", bean.getComplaintPercentage());
			count++;
		}
		if(bean.getComplaintIntegral() != null) {
			dao.setConditionComplaintIntegral("=", bean.getComplaintIntegral());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProject bean = new BaseProject();
		bean.setDataFromJSON(json);
		Project dao = new Project();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProject> rlist = new BaseCollection<>();
		BaseProject bean = new BaseProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Project dao = new Project();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProject> result = dao.conditionalLoad(addtion);
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
		BaseProject bean = new BaseProject();
		bean.setDataFromJSON(json);
		Project dao = new Project();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProject bean = new BaseProject();
		bean.setDataFromJSON(json);
		Project dao = new Project();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProject bean = new BaseProject();
		bean.setDataFromJSON(json);
		Project dao = new Project();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProject bean = new BaseProject();
		bean.setDataFromJSON(json);
		Project dao = new Project();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}
	
	
	

}


