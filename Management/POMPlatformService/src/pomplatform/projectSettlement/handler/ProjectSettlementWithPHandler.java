package pomplatform.projectSettlement.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.projectSettlement.bean.BaseProjectSettlementWithP;
import pomplatform.projectSettlement.dao.ProjectSettlementWithP;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectSettlementWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectSettlementWithPHandler.class);

	public static BaseProjectSettlementWithP getProjectSettlementWithPById( java.lang.Integer settlement_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectSettlementWithP result;
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			dao.setSettlementId(settlement_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectSettlementWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectSettlementWithPExists( pomplatform.projectSettlement.bean.BaseProjectSettlementWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectSettlementWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectSettlementWithP( pomplatform.projectSettlement.bean.BaseProjectSettlementWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectSettlementWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectSettlementWithP> queryProjectSettlementWithP( BaseProjectSettlementWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectSettlementWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectSettlementWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectSettlementWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectSettlementWithP addToProjectSettlementWithP ( BaseProjectSettlementWithP projectsettlementwithp ) {
		return addToProjectSettlementWithP ( projectsettlementwithp , false);
	}

	public static BaseProjectSettlementWithP addToProjectSettlementWithP ( BaseProjectSettlementWithP projectsettlementwithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			dao.setDataFromBase(projectsettlementwithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectSettlementWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectSettlementWithP addUpdateProjectSettlementWithP ( BaseProjectSettlementWithP projectsettlementwithp ) {
		return addUpdateProjectSettlementWithP ( projectsettlementwithp , false);
	}

	public static BaseProjectSettlementWithP addUpdateProjectSettlementWithP ( BaseProjectSettlementWithP projectsettlementwithp, boolean singleTransaction  ) {
		if(projectsettlementwithp.getSettlementId() == null) return addToProjectSettlementWithP(projectsettlementwithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			dao.setDataFromBase(projectsettlementwithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(projectsettlementwithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectSettlementWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectSettlementWithP deleteProjectSettlementWithP ( BaseProjectSettlementWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectSettlementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectSettlementWithP updateProjectSettlementWithP ( BaseProjectSettlementWithP projectsettlementwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			dao.setSettlementId( projectsettlementwithp.getSettlementId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(projectsettlementwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectSettlementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectsettlementwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectSettlementWithP updateProjectSettlementWithPDirect( BaseProjectSettlementWithP projectsettlementwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectSettlementWithP dao = new ProjectSettlementWithP();
			int result = 0;
			dao.setDataFromBase(projectsettlementwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectSettlementWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectsettlementwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectSettlementWithP bean, ProjectSettlementWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSettlementId() != null) {
			dao.setSettlementId(bean.getSettlementId());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectSettlementWithP bean, ProjectSettlementWithP dao){
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		bean.setDataFromJSON(json);
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectSettlementWithP> rlist = new BaseCollection<>();
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectSettlementWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		bean.setDataFromJSON(json);
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		bean.setDataFromJSON(json);
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
		bean.setDataFromJSON(json);
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


