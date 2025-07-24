package delicacy.workflow.handler;


import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.workflow.bean.BaseReimbursementWithR;
import delicacy.workflow.dao.ReimbursementWithR;

public class ReimbursementWithRHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ReimbursementWithRHandler.class);

	public static BaseReimbursementWithR getReimbursementWithRById( java.lang.Integer reimbursement_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseReimbursementWithR result;
			ReimbursementWithR dao = new ReimbursementWithR();
			dao.setReimbursementId(reimbursement_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ReimbursementWithR By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isReimbursementWithRExists( delicacy.workflow.bean.BaseReimbursementWithR bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ReimbursementWithR List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countReimbursementWithR( delicacy.workflow.bean.BaseReimbursementWithR bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ReimbursementWithR List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseReimbursementWithR> queryReimbursementWithR( BaseReimbursementWithR bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseReimbursementWithR> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseReimbursementWithR> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ReimbursementWithR List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReimbursementWithR addToReimbursementWithR ( BaseReimbursementWithR reimbursementwithr ) {
		return addToReimbursementWithR ( reimbursementwithr , false);
	}

	public static BaseReimbursementWithR addToReimbursementWithR ( BaseReimbursementWithR reimbursementwithr, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ReimbursementWithR dao = new ReimbursementWithR();
			dao.setDataFromBase(reimbursementwithr);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ReimbursementWithR time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReimbursementWithR addUpdateReimbursementWithR ( BaseReimbursementWithR reimbursementwithr ) {
		return addUpdateReimbursementWithR ( reimbursementwithr , false);
	}

	public static BaseReimbursementWithR addUpdateReimbursementWithR ( BaseReimbursementWithR reimbursementwithr, boolean singleTransaction  ) {
		if(reimbursementwithr.getReimbursementId() == null) return addToReimbursementWithR(reimbursementwithr);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ReimbursementWithR dao = new ReimbursementWithR();
			dao.setDataFromBase(reimbursementwithr);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(reimbursementwithr); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ReimbursementWithR time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReimbursementWithR deleteReimbursementWithR ( BaseReimbursementWithR bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ReimbursementWithR time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReimbursementWithR updateReimbursementWithR ( BaseReimbursementWithR reimbursementwithr ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			dao.setReimbursementId( reimbursementwithr.getReimbursementId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(reimbursementwithr);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ReimbursementWithR time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? reimbursementwithr : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReimbursementWithR updateReimbursementWithRDirect( BaseReimbursementWithR reimbursementwithr ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReimbursementWithR dao = new ReimbursementWithR();
			int result = 0;
			dao.setDataFromBase(reimbursementwithr);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ReimbursementWithR time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? reimbursementwithr : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseReimbursementWithR bean, ReimbursementWithR dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementId() != null) {
			dao.setReimbursementId(bean.getReimbursementId());
			dao.setConditionReimbursementId("=", bean.getReimbursementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getReimbursementType() != null) {
				dao.setConditionReimbursementType("=", bean.getReimbursementType());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getSubject() != null) {
				dao.setConditionSubject("=", bean.getSubject());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursementWithR bean, ReimbursementWithR dao){
		int count = 0;
		if(bean.getReimbursementId() != null) {
			dao.setConditionReimbursementId("=", bean.getReimbursementId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getApplicationDate() != null) {
			dao.setConditionApplicationDate(">=", bean.getApplicationDate());
			count++;
		}
		if(bean.getReimbursementType() != null) {
			dao.setConditionReimbursementType("=", bean.getReimbursementType());
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
		if(bean.getCompleteDate() != null) {
			dao.setConditionCompleteDate(">=", bean.getCompleteDate());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getSubject() != null) {
			if(bean.getSubject().indexOf("%") >= 0)
				dao.setConditionSubject("like", bean.getSubject());
			else
				dao.setConditionSubject("=", bean.getSubject());
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
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		bean.setDataFromJSON(json);
		ReimbursementWithR dao = new ReimbursementWithR();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementWithR> rlist = new BaseCollection<>();
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementWithR dao = new ReimbursementWithR();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementWithR> result = dao.conditionalLoadExt(addtion);
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
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		bean.setDataFromJSON(json);
		ReimbursementWithR dao = new ReimbursementWithR();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		bean.setDataFromJSON(json);
		int num = 0;
		ReimbursementWithR dao = new ReimbursementWithR();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		bean.setDataFromJSON(json);
		ReimbursementWithR dao = new ReimbursementWithR();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementWithR bean = new BaseReimbursementWithR();
		bean.setDataFromJSON(json);
		ReimbursementWithR dao = new ReimbursementWithR();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

}


