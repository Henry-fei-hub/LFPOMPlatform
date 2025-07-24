package pomplatform.stage.handler;

import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stage.bean.BaseProjectWithP;
import pomplatform.stage.dao.ProjectWithP;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectWithPHandler.class);

	public static BaseProjectWithP getProjectWithPById(java.lang.Integer project_id) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectWithP result;
			ProjectWithP dao = new ProjectWithP();
			dao.setProjectId(project_id);
			if (dao.load(true)) {
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectWithPExists(pomplatform.stage.bean.BaseProjectWithP bean, String additional) {

		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectWithP(pomplatform.stage.bean.BaseProjectWithP bean, String additional) {

		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectWithP> queryProjectWithP(BaseProjectWithP bean, int pageNo, int pageLines, String additionalCondition) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithP addToProjectWithP(BaseProjectWithP projectwithp) {
		return addToProjectWithP(projectwithp, false);
	}

	public static BaseProjectWithP addToProjectWithP(BaseProjectWithP projectwithp, boolean singleTransaction) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if (singleTransaction) {
				ThreadConnection.beginTransaction();
			}
			ProjectWithP dao = new ProjectWithP();
			dao.setDataFromBase(projectwithp);
			int result = dao.save();
			if (singleTransaction) {
				ThreadConnection.commit();
			}
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? dao.generateBaseExt() : null;
		} catch (Exception ex) {
			if (singleTransaction) {
				ThreadConnection.rollback();
			}
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithP addUpdateProjectWithP(BaseProjectWithP projectwithp) {
		return addUpdateProjectWithP(projectwithp, false);
	}

	public static BaseProjectWithP addUpdateProjectWithP(BaseProjectWithP projectwithp, boolean singleTransaction) {
		if (projectwithp.getProjectId() == null) {
			return addToProjectWithP(projectwithp);
		}
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if (singleTransaction) {
				ThreadConnection.beginTransaction();
			}
			ProjectWithP dao = new ProjectWithP();
			dao.setDataFromBase(projectwithp);
			int result = 0;
			if (dao.load()) {
				dao.setDataFromBase(projectwithp);
				if (dao.isThisObjectModified()) {
					result = dao.update();
				} else {
					result = 1;
				}
			} else {
				result = dao.save();
			}
			if (singleTransaction) {
				ThreadConnection.commit();
			}
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? dao.generateBaseExt() : null;
		} catch (Exception ex) {
			if (singleTransaction) {
				ThreadConnection.rollback();
			}
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithP deleteProjectWithP(BaseProjectWithP bean) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithP updateProjectWithP(BaseProjectWithP projectwithp) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			dao.setProjectId(projectwithp.getProjectId());
			int result = 0;
			if (dao.load()) {
				dao.setDataFromBase(projectwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectwithp : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectWithP updateProjectWithPDirect(BaseProjectWithP projectwithp) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectWithP dao = new ProjectWithP();
			int result = 0;
			dao.setDataFromBase(projectwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectwithp : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectWithP bean, ProjectWithP dao) {
		int count = 0;
		boolean foundKey = false;
		if (bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
			foundKey = true;
		}
		if (!foundKey) {
			if (bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if (bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if (bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if (bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if (bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if (bean.getDesignType() != null) {
				dao.setConditionDesignType("=", bean.getDesignType());
				count++;
			}
			if (bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if (bean.getDesignPhase() != null) {
				dao.setConditionDesignPhase("=", bean.getDesignPhase());
				count++;
			}
			if (bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if (bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if (bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if (bean.getWorkHours() != null) {
				dao.setConditionWorkHours("=", bean.getWorkHours());
				count++;
			}
			if (bean.getPercentage() != null) {
				dao.setConditionPercentage("=", bean.getPercentage());
				count++;
			}
			if (bean.getOldProjectDiscount() != null) {
				dao.setConditionOldProjectDiscount("=", bean.getOldProjectDiscount());
				count++;
			}
			if (bean.getProjectProgress() != null) {
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
				count++;
			}
			if (bean.getProjectSize() != null) {
				dao.setConditionProjectSize("=", bean.getProjectSize());
				count++;
			}
			if (bean.getProjectDescription() != null) {
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
				count++;
			}
			if (bean.getAuditReason() != null) {
				dao.setConditionAuditReason("=", bean.getAuditReason());
				count++;
			}
			if (bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectWithP bean, ProjectWithP dao) {
		int count = 0;
		if (bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if (bean.getContractCode() != null) {
			if (bean.getContractCode().indexOf("%") >= 0) {
				dao.setConditionContractCode("like", bean.getContractCode());
			} else {
				dao.setConditionContractCode("=", bean.getContractCode());
			}
			count++;
		}
		if (bean.getProjectCode() != null) {
			if (bean.getProjectCode().indexOf("%") >= 0) {
				dao.setConditionProjectCode("like", bean.getProjectCode());
			} else {
				dao.setConditionProjectCode("=", bean.getProjectCode());
			}
			count++;
		}
		if (bean.getProjectName() != null) {
			if (bean.getProjectName().indexOf("%") >= 0) {
				dao.setConditionProjectName("like", bean.getProjectName());
			} else {
				dao.setConditionProjectName("=", bean.getProjectName());
			}
			count++;
		}
		if (bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if (bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if (bean.getDesignType() != null) {
			dao.setConditionDesignType("=", bean.getDesignType());
			count++;
		}
		if (bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if (bean.getDesignPhase() != null) {
			dao.setConditionDesignPhase("=", bean.getDesignPhase());
			count++;
		}
		if (bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if (bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if (bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if (bean.getWorkHours() != null) {
			dao.setConditionWorkHours("=", bean.getWorkHours());
			count++;
		}
		if (bean.getPlanStartDate() != null) {
			dao.setConditionPlanStartDate(">=", bean.getPlanStartDate());
			count++;
		}
		if (bean.getPlanEndDate() != null) {
			dao.setConditionPlanEndDate(">=", bean.getPlanEndDate());
			count++;
		}
		if (bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if (bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if (bean.getCommonArea() != null) {
			dao.setConditionCommonArea("=", bean.getCommonArea());
			count++;
		}
		if (bean.getLogisticsArea() != null) {
			dao.setConditionLogisticsArea("=", bean.getLogisticsArea());
			count++;
		}
		if (bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		if (bean.getOldProjectDiscount() != null) {
			dao.setConditionOldProjectDiscount("=", bean.getOldProjectDiscount());
			count++;
		}
		if (bean.getBudget() != null) {
			dao.setConditionBudget("=", bean.getBudget());
			count++;
		}
		if (bean.getTotalIntegral() != null) {
			dao.setConditionTotalIntegral("=", bean.getTotalIntegral());
			count++;
		}
		if (bean.getReserveIntegral() != null) {
			dao.setConditionReserveIntegral("=", bean.getReserveIntegral());
			count++;
		}
		if (bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if (bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if (bean.getProjectProgress() != null) {
			if (bean.getProjectProgress().indexOf("%") >= 0) {
				dao.setConditionProjectProgress("like", bean.getProjectProgress());
			} else {
				dao.setConditionProjectProgress("=", bean.getProjectProgress());
			}
			count++;
		}
		if (bean.getProjectSize() != null) {
			if (bean.getProjectSize().indexOf("%") >= 0) {
				dao.setConditionProjectSize("like", bean.getProjectSize());
			} else {
				dao.setConditionProjectSize("=", bean.getProjectSize());
			}
			count++;
		}
		if (bean.getProjectDescription() != null) {
			if (bean.getProjectDescription().indexOf("%") >= 0) {
				dao.setConditionProjectDescription("like", bean.getProjectDescription());
			} else {
				dao.setConditionProjectDescription("=", bean.getProjectDescription());
			}
			count++;
		}
		if (bean.getAuditReason() != null) {
			if (bean.getAuditReason().indexOf("%") >= 0) {
				dao.setConditionAuditReason("like", bean.getAuditReason());
			} else {
				dao.setConditionAuditReason("=", bean.getAuditReason());
			}
			count++;
		}
		if (bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if (bean.getBimArea() != null) {
			dao.setConditionBimArea("=", bean.getBimArea());
			count++;
		}
		if (bean.getCadArea() != null) {
			dao.setConditionCadArea("=", bean.getCadArea());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception {
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		ProjectWithP dao = new ProjectWithP();
		dao.setPrimaryKeyFromBase(bean);
		if (dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1, null);
		}
		return bean.toOneLineJSON(0, "Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception {
		BaseCollection<BaseProjectWithP> rlist = new BaseCollection<>();
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		ProjectWithP dao = new ProjectWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectWithP> result = dao.conditionalLoadExt(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception {
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		ProjectWithP dao = new ProjectWithP();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectWithP dao = new ProjectWithP();
		dao.setDataFromBase(bean);
		if (dao.isPrimaryKeyNull()) {
			num = dao.save();
		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception {
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		ProjectWithP dao = new ProjectWithP();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception {
		BaseProjectWithP bean = new BaseProjectWithP();
		bean.setDataFromJSON(json);
		ProjectWithP dao = new ProjectWithP();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

}
