package pomplatform.client.workflow.specialDeduction.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS;
import pomplatform.client.workflow.specialDeduction.dao.SpecialDeductionRecordWithS;
import com.pomplatform.db.dao.SpecialDeductionDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class SpecialDeductionRecordWithSHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(SpecialDeductionRecordWithSHandler.class);

	public static BaseSpecialDeductionRecordWithS getSpecialDeductionRecordWithSById( java.lang.Integer special_deduction_record_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseSpecialDeductionRecordWithS result;
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			dao.setSpecialDeductionRecordId(special_deduction_record_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get SpecialDeductionRecordWithS By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isSpecialDeductionRecordWithSExists( pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SpecialDeductionRecordWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countSpecialDeductionRecordWithS( pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SpecialDeductionRecordWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseSpecialDeductionRecordWithS> querySpecialDeductionRecordWithS( BaseSpecialDeductionRecordWithS bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseSpecialDeductionRecordWithS> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseSpecialDeductionRecordWithS> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query SpecialDeductionRecordWithS List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSpecialDeductionRecordWithS addToSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths ) {
		return addToSpecialDeductionRecordWithS ( specialdeductionrecordwiths , false);
	}

	public static BaseSpecialDeductionRecordWithS addToSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			dao.setDataFromBase(specialdeductionrecordwiths);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SpecialDeductionRecordWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSpecialDeductionRecordWithS addUpdateSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths ) {
		return addUpdateSpecialDeductionRecordWithS ( specialdeductionrecordwiths , false);
	}

	public static BaseSpecialDeductionRecordWithS addUpdateSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths, boolean singleTransaction  ) {
		if(specialdeductionrecordwiths.getSpecialDeductionRecordId() == null) return addToSpecialDeductionRecordWithS(specialdeductionrecordwiths);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			dao.setDataFromBase(specialdeductionrecordwiths);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(specialdeductionrecordwiths); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SpecialDeductionRecordWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSpecialDeductionRecordWithS deleteSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete SpecialDeductionRecordWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSpecialDeductionRecordWithS updateSpecialDeductionRecordWithS ( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			dao.setSpecialDeductionRecordId( specialdeductionrecordwiths.getSpecialDeductionRecordId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(specialdeductionrecordwiths);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update SpecialDeductionRecordWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? specialdeductionrecordwiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSpecialDeductionRecordWithS updateSpecialDeductionRecordWithSDirect( BaseSpecialDeductionRecordWithS specialdeductionrecordwiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
			int result = 0;
			dao.setDataFromBase(specialdeductionrecordwiths);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update SpecialDeductionRecordWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? specialdeductionrecordwiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseSpecialDeductionRecordWithS bean, SpecialDeductionRecordWithS dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSpecialDeductionRecordId() != null) {
			dao.setSpecialDeductionRecordId(bean.getSpecialDeductionRecordId());
			dao.setConditionSpecialDeductionRecordId("=", bean.getSpecialDeductionRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeId() != null) {
				dao.setConditionEmployeId("=", bean.getEmployeId());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getDeparmentId() != null) {
				dao.setConditionDeparmentId("=", bean.getDeparmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSpecialDeductionRecordWithS bean, SpecialDeductionRecordWithS dao){
		int count = 0;
		if(bean.getSpecialDeductionRecordId() != null) {
			dao.setConditionSpecialDeductionRecordId("=", bean.getSpecialDeductionRecordId());
			count++;
		}
		if(bean.getEmployeId() != null) {
			dao.setConditionEmployeId("=", bean.getEmployeId());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
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
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getDeparmentId() != null) {
			dao.setConditionDeparmentId("=", bean.getDeparmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
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
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		bean.setDataFromJSON(json);
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSpecialDeductionRecordWithS> rlist = new BaseCollection<>();
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSpecialDeductionRecordWithS> result = dao.conditionalLoadExt(addtion);
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
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		bean.setDataFromJSON(json);
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		bean.setDataFromJSON(json);
		int num = 0;
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		bean.setDataFromJSON(json);
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();
		bean.setDataFromJSON(json);
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


