package pomplatform.scapitaldistributionor.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionWithCc;
import pomplatform.scapitaldistributionor.dao.CapitalDistributionWithCc;
import com.pomplatform.db.dao.CapitalDistributionLinkDepartment;
import com.pomplatform.db.dao.CapitalDistributionLinkSubContract;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class CapitalDistributionWithCcHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(CapitalDistributionWithCcHandler.class);

	public static BaseCapitalDistributionWithCc getCapitalDistributionWithCcById( java.lang.Integer capital_distribution_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseCapitalDistributionWithCc result;
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			dao.setCapitalDistributionId(capital_distribution_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get CapitalDistributionWithCc By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isCapitalDistributionWithCcExists( pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionWithCc bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CapitalDistributionWithCc List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countCapitalDistributionWithCc( pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionWithCc bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CapitalDistributionWithCc List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseCapitalDistributionWithCc> queryCapitalDistributionWithCc( BaseCapitalDistributionWithCc bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseCapitalDistributionWithCc> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseCapitalDistributionWithCc> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query CapitalDistributionWithCc List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCapitalDistributionWithCc addToCapitalDistributionWithCc ( BaseCapitalDistributionWithCc capitaldistributionwithcc ) {
		return addToCapitalDistributionWithCc ( capitaldistributionwithcc , false);
	}

	public static BaseCapitalDistributionWithCc addToCapitalDistributionWithCc ( BaseCapitalDistributionWithCc capitaldistributionwithcc, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			dao.setDataFromBase(capitaldistributionwithcc);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CapitalDistributionWithCc time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCapitalDistributionWithCc addUpdateCapitalDistributionWithCc ( BaseCapitalDistributionWithCc capitaldistributionwithcc ) {
		return addUpdateCapitalDistributionWithCc ( capitaldistributionwithcc , false);
	}

	public static BaseCapitalDistributionWithCc addUpdateCapitalDistributionWithCc ( BaseCapitalDistributionWithCc capitaldistributionwithcc, boolean singleTransaction  ) {
		if(capitaldistributionwithcc.getCapitalDistributionId() == null) return addToCapitalDistributionWithCc(capitaldistributionwithcc);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			dao.setDataFromBase(capitaldistributionwithcc);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(capitaldistributionwithcc); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CapitalDistributionWithCc time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCapitalDistributionWithCc deleteCapitalDistributionWithCc ( BaseCapitalDistributionWithCc bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete CapitalDistributionWithCc time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCapitalDistributionWithCc updateCapitalDistributionWithCc ( BaseCapitalDistributionWithCc capitaldistributionwithcc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			dao.setCapitalDistributionId( capitaldistributionwithcc.getCapitalDistributionId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(capitaldistributionwithcc);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update CapitalDistributionWithCc time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? capitaldistributionwithcc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCapitalDistributionWithCc updateCapitalDistributionWithCcDirect( BaseCapitalDistributionWithCc capitaldistributionwithcc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
			int result = 0;
			dao.setDataFromBase(capitaldistributionwithcc);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update CapitalDistributionWithCc time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? capitaldistributionwithcc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseCapitalDistributionWithCc bean, CapitalDistributionWithCc dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalDistributionId() != null) {
			dao.setCapitalDistributionId(bean.getCapitalDistributionId());
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
			count++;
			foundKey = true;
		}
//		if(!foundKey) {
//			if(bean.getCode() != null) {
//				dao.setConditionCode("=", bean.getCode());
//				count++;
//			}
//			if(bean.getProcessInstanceId() != null) {
//				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
//				count++;
//			}
//			if(bean.getApplyEmployeeId() != null) {
//				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
//				count++;
//			}
//			if(bean.getEmployeeId() != null) {
//				dao.setConditionEmployeeId("=", bean.getEmployeeId());
//				count++;
//			}
//			if(bean.getDepartmentId() != null) {
//				dao.setConditionDepartmentId("=", bean.getDepartmentId());
//				count++;
//			}
//			if(bean.getTitle() != null) {
//				dao.setConditionTitle("=", bean.getTitle());
//				count++;
//			}
//			if(bean.getCompanyId() != null) {
//				dao.setConditionCompanyId("=", bean.getCompanyId());
//				count++;
//			}
//			if(bean.getContractId() != null) {
//				dao.setConditionContractId("=", bean.getContractId());
//				count++;
//			}
//			if(bean.getCapitalId() != null) {
//				dao.setConditionCapitalId("=", bean.getCapitalId());
//				count++;
//			}
//			if(bean.getRemark() != null) {
//				dao.setConditionRemark("=", bean.getRemark());
//				count++;
//			}
//			if(bean.getIsCompleted() != null) {
//				dao.setConditionIsCompleted("=", bean.getIsCompleted());
//				count++;
//			}
//			if(bean.getMainProfessional() != null) {
//				dao.setConditionMainProfessional("=", bean.getMainProfessional());
//				count++;
//			}
//		}
		return count;
	}

	public static int setConditions(BaseCapitalDistributionWithCc bean, CapitalDistributionWithCc dao){
		int count = 0;
//		if(bean.getCapitalDistributionId() != null) {
//			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
//			count++;
//		}
//		if(bean.getCode() != null) {
//			if(bean.getCode().indexOf("%") >= 0)
//				dao.setConditionCode("like", bean.getCode());
//			else
//				dao.setConditionCode("=", bean.getCode());
//			count++;
//		}
//		if(bean.getProcessInstanceId() != null) {
//			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
//			count++;
//		}
//		if(bean.getApplyEmployeeId() != null) {
//			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
//			count++;
//		}
//		if(bean.getEmployeeId() != null) {
//			dao.setConditionEmployeeId("=", bean.getEmployeeId());
//			count++;
//		}
//		if(bean.getDepartmentId() != null) {
//			dao.setConditionDepartmentId("=", bean.getDepartmentId());
//			count++;
//		}
//		if(bean.getTitle() != null) {
//			if(bean.getTitle().indexOf("%") >= 0)
//				dao.setConditionTitle("like", bean.getTitle());
//			else
//				dao.setConditionTitle("=", bean.getTitle());
//			count++;
//		}
//		if(bean.getCompanyId() != null) {
//			dao.setConditionCompanyId("=", bean.getCompanyId());
//			count++;
//		}
//		if(bean.getContractId() != null) {
//			dao.setConditionContractId("=", bean.getContractId());
//			count++;
//		}
//		if(bean.getCapitalId() != null) {
//			dao.setConditionCapitalId("=", bean.getCapitalId());
//			count++;
//		}
//		if(bean.getApplyTime() != null) {
//			dao.setConditionApplyTime(">=", bean.getApplyTime());
//			count++;
//		}
//		if(bean.getCompleteTime() != null) {
//			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
//			count++;
//		}
//		if(bean.getRemark() != null) {
//			if(bean.getRemark().indexOf("%") >= 0)
//				dao.setConditionRemark("like", bean.getRemark());
//			else
//				dao.setConditionRemark("=", bean.getRemark());
//			count++;
//		}
//		if(bean.getIsCompleted() != null) {
//			dao.setConditionIsCompleted("=", bean.getIsCompleted());
//			count++;
//		}
//		if(bean.getMainProfessional() != null) {
//			dao.setConditionMainProfessional("=", bean.getMainProfessional());
//			count++;
//		}
//		if(bean.getContractChangeAmount() != null) {
//			dao.setConditionContractChangeAmount("=", bean.getContractChangeAmount());
//			count++;
//		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		bean.setDataFromJSON(json);
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalDistributionWithCc> rlist = new BaseCollection<>();
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalDistributionWithCc> result = dao.conditionalLoadExt(addtion);
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
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		bean.setDataFromJSON(json);
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		bean.setDataFromJSON(json);
		int num = 0;
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		bean.setDataFromJSON(json);
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();
		bean.setDataFromJSON(json);
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


