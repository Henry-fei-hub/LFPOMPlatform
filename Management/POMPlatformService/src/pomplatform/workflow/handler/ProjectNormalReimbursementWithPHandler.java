package pomplatform.workflow.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.workflow.bean.BaseProjectNormalReimbursementWithP;
import pomplatform.workflow.dao.ProjectNormalReimbursementWithP;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectNormalReimbursementWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectNormalReimbursementWithPHandler.class);

	public static BaseProjectNormalReimbursementWithP getProjectNormalReimbursementWithPById( java.lang.Integer project_normal_reimbursement_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectNormalReimbursementWithP result;
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			dao.setProjectNormalReimbursementId(project_normal_reimbursement_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectNormalReimbursementWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectNormalReimbursementWithPExists( pomplatform.workflow.bean.BaseProjectNormalReimbursementWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectNormalReimbursementWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectNormalReimbursementWithP( pomplatform.workflow.bean.BaseProjectNormalReimbursementWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectNormalReimbursementWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectNormalReimbursementWithP> queryProjectNormalReimbursementWithP( BaseProjectNormalReimbursementWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectNormalReimbursementWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectNormalReimbursementWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectNormalReimbursementWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectNormalReimbursementWithP addToProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp ) {
		return addToProjectNormalReimbursementWithP ( projectnormalreimbursementwithp , false);
	}

	public static BaseProjectNormalReimbursementWithP addToProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			dao.setDataFromBase(projectnormalreimbursementwithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectNormalReimbursementWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectNormalReimbursementWithP addUpdateProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp ) {
		return addUpdateProjectNormalReimbursementWithP ( projectnormalreimbursementwithp , false);
	}

	public static BaseProjectNormalReimbursementWithP addUpdateProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp, boolean singleTransaction  ) {
		if(projectnormalreimbursementwithp.getProjectNormalReimbursementId() == null) return addToProjectNormalReimbursementWithP(projectnormalreimbursementwithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			dao.setDataFromBase(projectnormalreimbursementwithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(projectnormalreimbursementwithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectNormalReimbursementWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectNormalReimbursementWithP deleteProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectNormalReimbursementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectNormalReimbursementWithP updateProjectNormalReimbursementWithP ( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			dao.setProjectNormalReimbursementId( projectnormalreimbursementwithp.getProjectNormalReimbursementId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(projectnormalreimbursementwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectNormalReimbursementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectnormalreimbursementwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectNormalReimbursementWithP updateProjectNormalReimbursementWithPDirect( BaseProjectNormalReimbursementWithP projectnormalreimbursementwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
			int result = 0;
			dao.setDataFromBase(projectnormalreimbursementwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectNormalReimbursementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectnormalreimbursementwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectNormalReimbursementWithP bean, ProjectNormalReimbursementWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setProjectNormalReimbursementId(bean.getProjectNormalReimbursementId());
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
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
			if(bean.getReimbursementName() != null) {
				dao.setConditionReimbursementName("=", bean.getReimbursementName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getStrikeABalance() != null) {
				dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
			if(bean.getAttachmentNumber() != null) {
				dao.setConditionAttachmentNumber("=", bean.getAttachmentNumber());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getIsProject() != null) {
				dao.setConditionIsProject("=", bean.getIsProject());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectNormalReimbursementWithP bean, ProjectNormalReimbursementWithP dao){
		int count = 0;
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
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
		if(bean.getReimbursementName() != null) {
			if(bean.getReimbursementName().indexOf("%") >= 0)
				dao.setConditionReimbursementName("like", bean.getReimbursementName());
			else
				dao.setConditionReimbursementName("=", bean.getReimbursementName());
			count++;
		}
		if(bean.getReimbursementTime() != null) {
			dao.setConditionReimbursementTime(">=", bean.getReimbursementTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getApplyTime() != null) {
			dao.setConditionApplyTime(">=", bean.getApplyTime());
			count++;
		}
		if(bean.getCompleteTime() != null) {
			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getStrikeABalance() != null) {
			dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		if(bean.getAttachmentNumber() != null) {
			dao.setConditionAttachmentNumber("=", bean.getAttachmentNumber());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getIsProject() != null) {
			dao.setConditionIsProject("=", bean.getIsProject());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectNormalReimbursementWithP> rlist = new BaseCollection<>();
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectNormalReimbursementWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectNormalReimbursementWithP bean = new BaseProjectNormalReimbursementWithP();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementWithP dao = new ProjectNormalReimbursementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


