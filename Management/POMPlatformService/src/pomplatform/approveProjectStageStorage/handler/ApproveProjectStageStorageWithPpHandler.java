package pomplatform.approveProjectStageStorage.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp;
import pomplatform.approveProjectStageStorage.dao.ApproveProjectStageStorageWithPp;
import com.pomplatform.db.dao.ProjectStageStorage;
import com.pomplatform.db.dao.ProjectStage;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ApproveProjectStageStorageWithPpHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ApproveProjectStageStorageWithPpHandler.class);

	public static BaseApproveProjectStageStorageWithPp getApproveProjectStageStorageWithPpById( java.lang.Integer approve_project_stage_storage_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseApproveProjectStageStorageWithPp result;
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			dao.setApproveProjectStageStorageId(approve_project_stage_storage_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ApproveProjectStageStorageWithPp By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isApproveProjectStageStorageWithPpExists( pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ApproveProjectStageStorageWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countApproveProjectStageStorageWithPp( pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ApproveProjectStageStorageWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseApproveProjectStageStorageWithPp> queryApproveProjectStageStorageWithPp( BaseApproveProjectStageStorageWithPp bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseApproveProjectStageStorageWithPp> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseApproveProjectStageStorageWithPp> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ApproveProjectStageStorageWithPp List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseApproveProjectStageStorageWithPp addToApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp ) {
		return addToApproveProjectStageStorageWithPp ( approveprojectstagestoragewithpp , false);
	}

	public static BaseApproveProjectStageStorageWithPp addToApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			dao.setDataFromBase(approveprojectstagestoragewithpp);
			int result = dao.save(false);
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ApproveProjectStageStorageWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseApproveProjectStageStorageWithPp addUpdateApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp ) {
		return addUpdateApproveProjectStageStorageWithPp ( approveprojectstagestoragewithpp , false);
	}

	public static BaseApproveProjectStageStorageWithPp addUpdateApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp, boolean singleTransaction  ) {
		if(approveprojectstagestoragewithpp.getApproveProjectStageStorageId() == null) return addToApproveProjectStageStorageWithPp(approveprojectstagestoragewithpp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			dao.setDataFromBase(approveprojectstagestoragewithpp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(approveprojectstagestoragewithpp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save(false);
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ApproveProjectStageStorageWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseApproveProjectStageStorageWithPp deleteApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ApproveProjectStageStorageWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseApproveProjectStageStorageWithPp updateApproveProjectStageStorageWithPp ( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			dao.setApproveProjectStageStorageId( approveprojectstagestoragewithpp.getApproveProjectStageStorageId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(approveprojectstagestoragewithpp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ApproveProjectStageStorageWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? approveprojectstagestoragewithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseApproveProjectStageStorageWithPp updateApproveProjectStageStorageWithPpDirect( BaseApproveProjectStageStorageWithPp approveprojectstagestoragewithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
			int result = 0;
			dao.setDataFromBase(approveprojectstagestoragewithpp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ApproveProjectStageStorageWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? approveprojectstagestoragewithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseApproveProjectStageStorageWithPp bean, ApproveProjectStageStorageWithPp dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getApproveProjectStageStorageId() != null) {
			dao.setApproveProjectStageStorageId(bean.getApproveProjectStageStorageId());
			dao.setConditionApproveProjectStageStorageId("=", bean.getApproveProjectStageStorageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
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
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getPlateManagerId() != null) {
				dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
				count++;
			}
			if(bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseApproveProjectStageStorageWithPp bean, ApproveProjectStageStorageWithPp dao){
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
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getPlateManagerId() != null) {
			dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
			count++;
		}
		if(bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if(bean.getApproveProjectStageStorageId() != null) {
			dao.setConditionApproveProjectStageStorageId("=", bean.getApproveProjectStageStorageId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseApproveProjectStageStorageWithPp> rlist = new BaseCollection<>();
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseApproveProjectStageStorageWithPp> result = dao.conditionalLoadExt(addtion);
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
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		bean.setDataFromJSON(json);
		int num = 0;
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save(false);
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


