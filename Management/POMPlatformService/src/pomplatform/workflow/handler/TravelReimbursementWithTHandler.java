package pomplatform.workflow.handler;


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
import pomplatform.workflow.bean.BaseTravelReimbursementWithT;
import pomplatform.workflow.dao.TravelReimbursementWithT;

public class TravelReimbursementWithTHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(TravelReimbursementWithTHandler.class);

	public static BaseTravelReimbursementWithT getTravelReimbursementWithTById( java.lang.Integer travel_reimbursement_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseTravelReimbursementWithT result;
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			dao.setTravelReimbursementId(travel_reimbursement_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get TravelReimbursementWithT By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isTravelReimbursementWithTExists( pomplatform.workflow.bean.BaseTravelReimbursementWithT bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query TravelReimbursementWithT List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countTravelReimbursementWithT( pomplatform.workflow.bean.BaseTravelReimbursementWithT bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query TravelReimbursementWithT List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseTravelReimbursementWithT> queryTravelReimbursementWithT( BaseTravelReimbursementWithT bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseTravelReimbursementWithT> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseTravelReimbursementWithT> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query TravelReimbursementWithT List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTravelReimbursementWithT addToTravelReimbursementWithT ( BaseTravelReimbursementWithT travelreimbursementwitht ) {
		return addToTravelReimbursementWithT ( travelreimbursementwitht , false);
	}

	public static BaseTravelReimbursementWithT addToTravelReimbursementWithT ( BaseTravelReimbursementWithT travelreimbursementwitht, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			dao.setDataFromBase(travelreimbursementwitht);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to TravelReimbursementWithT time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTravelReimbursementWithT addUpdateTravelReimbursementWithT ( BaseTravelReimbursementWithT travelreimbursementwitht ) {
		return addUpdateTravelReimbursementWithT ( travelreimbursementwitht , false);
	}

	public static BaseTravelReimbursementWithT addUpdateTravelReimbursementWithT ( BaseTravelReimbursementWithT travelreimbursementwitht, boolean singleTransaction  ) {
		if(travelreimbursementwitht.getTravelReimbursementId() == null) return addToTravelReimbursementWithT(travelreimbursementwitht);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			dao.setDataFromBase(travelreimbursementwitht);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(travelreimbursementwitht); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to TravelReimbursementWithT time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTravelReimbursementWithT deleteTravelReimbursementWithT ( BaseTravelReimbursementWithT bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete TravelReimbursementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTravelReimbursementWithT updateTravelReimbursementWithT ( BaseTravelReimbursementWithT travelreimbursementwitht ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			dao.setTravelReimbursementId( travelreimbursementwitht.getTravelReimbursementId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(travelreimbursementwitht);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update TravelReimbursementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? travelreimbursementwitht : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTravelReimbursementWithT updateTravelReimbursementWithTDirect( BaseTravelReimbursementWithT travelreimbursementwitht ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			int result = 0;
			dao.setDataFromBase(travelreimbursementwitht);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update TravelReimbursementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? travelreimbursementwitht : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseTravelReimbursementWithT bean, TravelReimbursementWithT dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTravelReimbursementId() != null) {
			dao.setTravelReimbursementId(bean.getTravelReimbursementId());
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
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
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getApplicant() != null) {
				dao.setConditionApplicant("=", bean.getApplicant());
				count++;
			}
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getStrikeABalance() != null) {
				dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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

	public static int setConditions(BaseTravelReimbursementWithT bean, TravelReimbursementWithT dao){
		int count = 0;
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
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
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getApplicant() != null) {
			dao.setConditionApplicant("=", bean.getApplicant());
			count++;
		}
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getReimbursementTime() != null) {
			dao.setConditionReimbursementTime(">=", bean.getReimbursementTime());
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
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getStrikeABalance() != null) {
			dao.setConditionStrikeABalance("=", bean.getStrikeABalance());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		bean.setDataFromJSON(json);
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTravelReimbursementWithT> rlist = new BaseCollection<>();
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTravelReimbursementWithT> result = dao.conditionalLoadExt(addtion);
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
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		bean.setDataFromJSON(json);
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		bean.setDataFromJSON(json);
		int num = 0;
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		bean.setDataFromJSON(json);
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();
		bean.setDataFromJSON(json);
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


