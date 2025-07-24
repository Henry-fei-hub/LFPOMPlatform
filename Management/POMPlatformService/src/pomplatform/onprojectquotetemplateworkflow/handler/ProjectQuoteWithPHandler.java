package pomplatform.onprojectquotetemplateworkflow.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.onprojectquotetemplateworkflow.bean.BaseProjectQuoteWithP;
import pomplatform.onprojectquotetemplateworkflow.dao.ProjectQuoteWithP;
import com.pomplatform.db.dao.ProjectQuoteDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProjectQuoteWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProjectQuoteWithPHandler.class);

	public static BaseProjectQuoteWithP getProjectQuoteWithPById( java.lang.Integer project_quote_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProjectQuoteWithP result;
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			dao.setProjectQuoteId(project_quote_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProjectQuoteWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProjectQuoteWithPExists( pomplatform.onprojectquotetemplateworkflow.bean.BaseProjectQuoteWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectQuoteWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProjectQuoteWithP( pomplatform.onprojectquotetemplateworkflow.bean.BaseProjectQuoteWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProjectQuoteWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProjectQuoteWithP> queryProjectQuoteWithP( BaseProjectQuoteWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProjectQuoteWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProjectQuoteWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProjectQuoteWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectQuoteWithP addToProjectQuoteWithP ( BaseProjectQuoteWithP projectquotewithp ) {
		return addToProjectQuoteWithP ( projectquotewithp , false);
	}

	public static BaseProjectQuoteWithP addToProjectQuoteWithP ( BaseProjectQuoteWithP projectquotewithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			dao.setDataFromBase(projectquotewithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectQuoteWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectQuoteWithP addUpdateProjectQuoteWithP ( BaseProjectQuoteWithP projectquotewithp ) {
		return addUpdateProjectQuoteWithP ( projectquotewithp , false);
	}

	public static BaseProjectQuoteWithP addUpdateProjectQuoteWithP ( BaseProjectQuoteWithP projectquotewithp, boolean singleTransaction  ) {
		if(projectquotewithp.getProjectQuoteId() == null) return addToProjectQuoteWithP(projectquotewithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			dao.setDataFromBase(projectquotewithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(projectquotewithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProjectQuoteWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectQuoteWithP deleteProjectQuoteWithP ( BaseProjectQuoteWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProjectQuoteWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectQuoteWithP updateProjectQuoteWithP ( BaseProjectQuoteWithP projectquotewithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			dao.setProjectQuoteId( projectquotewithp.getProjectQuoteId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(projectquotewithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProjectQuoteWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectquotewithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProjectQuoteWithP updateProjectQuoteWithPDirect( BaseProjectQuoteWithP projectquotewithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProjectQuoteWithP dao = new ProjectQuoteWithP();
			int result = 0;
			dao.setDataFromBase(projectquotewithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProjectQuoteWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? projectquotewithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProjectQuoteWithP bean, ProjectQuoteWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteId() != null) {
			dao.setProjectQuoteId(bean.getProjectQuoteId());
			dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getTitleName() != null) {
				dao.setConditionTitleName("=", bean.getTitleName());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getVersionNumber() != null) {
				dao.setConditionVersionNumber("=", bean.getVersionNumber());
				count++;
			}
			if(bean.getQuoteStatus() != null) {
				dao.setConditionQuoteStatus("=", bean.getQuoteStatus());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getProjectQuoteTemplatesParentId() != null) {
				dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectQuoteWithP bean, ProjectQuoteWithP dao){
		int count = 0;
		if(bean.getProjectQuoteId() != null) {
			dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getTitleName() != null) {
			if(bean.getTitleName().indexOf("%") >= 0)
				dao.setConditionTitleName("like", bean.getTitleName());
			else
				dao.setConditionTitleName("=", bean.getTitleName());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getVersionNumber() != null) {
			dao.setConditionVersionNumber("=", bean.getVersionNumber());
			count++;
		}
		if(bean.getQuoteStatus() != null) {
			dao.setConditionQuoteStatus("=", bean.getQuoteStatus());
			count++;
		}
		if(bean.getBasicAmount() != null) {
			dao.setConditionBasicAmount("=", bean.getBasicAmount());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getUpAmount() != null) {
			dao.setConditionUpAmount("=", bean.getUpAmount());
			count++;
		}
		if(bean.getUpPercent() != null) {
			dao.setConditionUpPercent("=", bean.getUpPercent());
			count++;
		}
		if(bean.getPreferentialAmount() != null) {
			dao.setConditionPreferentialAmount("=", bean.getPreferentialAmount());
			count++;
		}
		if(bean.getPerferentialPercent() != null) {
			dao.setConditionPerferentialPercent("=", bean.getPerferentialPercent());
			count++;
		}
		if(bean.getSpecialDiscountAmount() != null) {
			dao.setConditionSpecialDiscountAmount("=", bean.getSpecialDiscountAmount());
			count++;
		}
		if(bean.getSpecialDiscountPercent() != null) {
			dao.setConditionSpecialDiscountPercent("=", bean.getSpecialDiscountPercent());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getOtherTaxAmount() != null) {
			dao.setConditionOtherTaxAmount("=", bean.getOtherTaxAmount());
			count++;
		}
		if(bean.getFinalPercent() != null) {
			dao.setConditionFinalPercent("=", bean.getFinalPercent());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getTaxFinalAmount() != null) {
			dao.setConditionTaxFinalAmount("=", bean.getTaxFinalAmount());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProjectQuoteTemplatesParentId() != null) {
			dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		bean.setDataFromJSON(json);
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectQuoteWithP> rlist = new BaseCollection<>();
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectQuoteWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		bean.setDataFromJSON(json);
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		bean.setDataFromJSON(json);
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectQuoteWithP bean = new BaseProjectQuoteWithP();
		bean.setDataFromJSON(json);
		ProjectQuoteWithP dao = new ProjectQuoteWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


