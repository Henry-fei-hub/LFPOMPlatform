package pomplatform.ProjectStages.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP;
import pomplatform.ProjectStages.dao.ProjectStageProcessRecordWithP;
import com.pomplatform.db.dao.ProjectStageProcessDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectStageProcessRecordWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectStageProcessRecordWithPHandler.class);

	public static BaseProjectStageProcessRecordWithP getProjectStageProcessRecordWithPById( java.lang.Integer project_stage_process_record_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectStageProcessRecordWithP result;
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			dao.setProjectStageProcessRecordId(project_stage_process_record_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectStageProcessRecordWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectStageProcessRecordWithPExists( pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectStageProcessRecordWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectStageProcessRecordWithP( pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectStageProcessRecordWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectStageProcessRecordWithP> queryProjectStageProcessRecordWithP( BaseProjectStageProcessRecordWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectStageProcessRecordWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectStageProcessRecordWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectStageProcessRecordWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectStageProcessRecordWithP addToProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp ) {
		return addToProjectStageProcessRecordWithP ( projectstageprocessrecordwithp , false);
	}

	public static BaseProjectStageProcessRecordWithP addToProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			dao.setDataFromBase(projectstageprocessrecordwithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectStageProcessRecordWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectStageProcessRecordWithP addUpdateProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp ) {
		return addUpdateProjectStageProcessRecordWithP ( projectstageprocessrecordwithp , false);
	}

	public static BaseProjectStageProcessRecordWithP addUpdateProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp, boolean singleTransaction  ) {
		if(projectstageprocessrecordwithp.getProjectStageProcessRecordId() == null) return addToProjectStageProcessRecordWithP(projectstageprocessrecordwithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			dao.setDataFromBase(projectstageprocessrecordwithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(projectstageprocessrecordwithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectStageProcessRecordWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectStageProcessRecordWithP deleteProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectStageProcessRecordWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectStageProcessRecordWithP updateProjectStageProcessRecordWithP ( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			dao.setProjectStageProcessRecordId( projectstageprocessrecordwithp.getProjectStageProcessRecordId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(projectstageprocessrecordwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectStageProcessRecordWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectstageprocessrecordwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectStageProcessRecordWithP updateProjectStageProcessRecordWithPDirect( BaseProjectStageProcessRecordWithP projectstageprocessrecordwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
			int result = 0;
			dao.setDataFromBase(projectstageprocessrecordwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectStageProcessRecordWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectstageprocessrecordwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectStageProcessRecordWithP bean, ProjectStageProcessRecordWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageProcessRecordId() != null) {
			dao.setProjectStageProcessRecordId(bean.getProjectStageProcessRecordId());
			dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectStageProcessRecordWithP bean, ProjectStageProcessRecordWithP dao){
		int count = 0;
		if(bean.getProjectStageProcessRecordId() != null) {
			dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectAmountSum() != null) {
			dao.setConditionProjectAmountSum("=", bean.getProjectAmountSum());
			count++;
		}
		if(bean.getApplyAmount() != null) {
			dao.setConditionApplyAmount("=", bean.getApplyAmount());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
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
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStageProcessRecordWithP> rlist = new BaseCollection<>();
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStageProcessRecordWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


