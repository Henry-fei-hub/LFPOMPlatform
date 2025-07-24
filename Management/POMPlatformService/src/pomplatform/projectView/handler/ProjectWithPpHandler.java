package pomplatform.projectView.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectView.bean.BaseProjectWithPp;
import pomplatform.projectView.dao.ProjectWithPp;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectCost;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectWithPpHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectWithPpHandler.class);

	public static BaseProjectWithPp getProjectWithPpById( java.lang.Integer project_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectWithPp result;
			ProjectWithPp dao = new ProjectWithPp();
			dao.setProjectId(project_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectWithPp By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectWithPpExists( pomplatform.projectView.bean.BaseProjectWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectWithPp( pomplatform.projectView.bean.BaseProjectWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectWithPp> queryProjectWithPp( BaseProjectWithPp bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectWithPp> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectWithPp> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithPp List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithPp addToProjectWithPp ( BaseProjectWithPp projectwithpp ) {
		return addToProjectWithPp ( projectwithpp , false);
	}

	public static BaseProjectWithPp addToProjectWithPp ( BaseProjectWithPp projectwithpp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectWithPp dao = new ProjectWithPp();
			dao.setDataFromBase(projectwithpp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithPp addUpdateProjectWithPp ( BaseProjectWithPp projectwithpp ) {
		return addUpdateProjectWithPp ( projectwithpp , false);
	}

	public static BaseProjectWithPp addUpdateProjectWithPp ( BaseProjectWithPp projectwithpp, boolean singleTransaction  ) {
		if(projectwithpp.getProjectId() == null) return addToProjectWithPp(projectwithpp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectWithPp dao = new ProjectWithPp();
			dao.setDataFromBase(projectwithpp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(projectwithpp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithPp deleteProjectWithPp ( BaseProjectWithPp bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithPp updateProjectWithPp ( BaseProjectWithPp projectwithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			dao.setProjectId( projectwithpp.getProjectId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(projectwithpp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectwithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithPp updateProjectWithPpDirect( BaseProjectWithPp projectwithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithPp dao = new ProjectWithPp();
			int result = 0;
			dao.setDataFromBase(projectwithpp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectwithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectWithPp bean, ProjectWithPp dao){
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
			if(bean.getWorkHours() != null) {
				dao.setConditionWorkHours("=", bean.getWorkHours());
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
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProjectProgress() != null) {
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getProjectSize() != null) {
				dao.setConditionProjectSize("=", bean.getProjectSize());
				count++;
			}
			if(bean.getProjectIntegral() != null) {
				dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
				count++;
			}
			if(bean.getProjectDescription() != null) {
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
				count++;
			}
			if(bean.getBudget() != null) {
				dao.setConditionBudget("=", bean.getBudget());
				count++;
			}
			if(bean.getAuditReason() != null) {
				dao.setConditionAuditReason("=", bean.getAuditReason());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getPercentage() != null) {
				dao.setConditionPercentage("=", bean.getPercentage());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectWithPp bean, ProjectWithPp dao){
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
		
		if(bean.getWorkHours() != null) {
			if(bean.getWorkHours() >= 0)
				dao.setConditionWorkHours("like", bean.getWorkHours());
			else
				dao.setConditionWorkHours("=", bean.getWorkHours());
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
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getProjectProgress() != null) {
			if(bean.getProjectProgress().indexOf("%") >= 0)
				dao.setConditionProjectProgress("like", bean.getProjectProgress());
			else
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getProjectSize() != null) {
			if(0 < bean.getProjectSize().indexOf("%"))
				dao.setConditionProjectSize("like", bean.getProjectSize());
			else
				dao.setConditionProjectSize("=", bean.getProjectSize());
			count++;
		}
		if(bean.getProjectDescription() != null) {
			if(bean.getProjectDescription().contains("%"))
				dao.setConditionProjectDescription("like", bean.getProjectDescription());
			else
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
			count++;
		}
		
		if(bean.getAuditReason() != null) {
			if(bean.getAuditReason().contains("%"))
				dao.setConditionAuditReason("like", bean.getAuditReason());
			else
				dao.setConditionAuditReason("=", bean.getAuditReason());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		ProjectWithPp dao = new ProjectWithPp();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectWithPp> rlist = new BaseCollection<>();
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		ProjectWithPp dao = new ProjectWithPp();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectWithPp> result = dao.conditionalLoadExt(addtion);
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
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		ProjectWithPp dao = new ProjectWithPp();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectWithPp dao = new ProjectWithPp();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		ProjectWithPp dao = new ProjectWithPp();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectWithPp bean = new BaseProjectWithPp();
		bean.setDataFromJSON(json);
		ProjectWithPp dao = new ProjectWithPp();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

}


