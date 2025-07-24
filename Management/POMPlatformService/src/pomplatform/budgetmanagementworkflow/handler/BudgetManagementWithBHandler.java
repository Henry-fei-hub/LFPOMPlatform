package pomplatform.budgetmanagementworkflow.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB;
import pomplatform.budgetmanagementworkflow.dao.BudgetManagementWithB;
import com.pomplatform.db.dao.BudgetManagementDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class BudgetManagementWithBHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(BudgetManagementWithBHandler.class);

	public static BaseBudgetManagementWithB getBudgetManagementWithBById( java.lang.Integer budget_management_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseBudgetManagementWithB result;
			BudgetManagementWithB dao = new BudgetManagementWithB();
			dao.setBudgetManagementId(budget_management_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get BudgetManagementWithB By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isBudgetManagementWithBExists( pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query BudgetManagementWithB List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countBudgetManagementWithB( pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query BudgetManagementWithB List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseBudgetManagementWithB> queryBudgetManagementWithB( BaseBudgetManagementWithB bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseBudgetManagementWithB> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseBudgetManagementWithB> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query BudgetManagementWithB List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBudgetManagementWithB addToBudgetManagementWithB ( BaseBudgetManagementWithB budgetmanagementwithb ) {
		return addToBudgetManagementWithB ( budgetmanagementwithb , false);
	}

	public static BaseBudgetManagementWithB addToBudgetManagementWithB ( BaseBudgetManagementWithB budgetmanagementwithb, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			dao.setDataFromBase(budgetmanagementwithb);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to BudgetManagementWithB time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBudgetManagementWithB addUpdateBudgetManagementWithB ( BaseBudgetManagementWithB budgetmanagementwithb ) {
		return addUpdateBudgetManagementWithB ( budgetmanagementwithb , false);
	}

	public static BaseBudgetManagementWithB addUpdateBudgetManagementWithB ( BaseBudgetManagementWithB budgetmanagementwithb, boolean singleTransaction  ) {
		if(budgetmanagementwithb.getBudgetManagementId() == null) return addToBudgetManagementWithB(budgetmanagementwithb);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			dao.setDataFromBase(budgetmanagementwithb);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(budgetmanagementwithb); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to BudgetManagementWithB time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBudgetManagementWithB deleteBudgetManagementWithB ( BaseBudgetManagementWithB bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete BudgetManagementWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBudgetManagementWithB updateBudgetManagementWithB ( BaseBudgetManagementWithB budgetmanagementwithb ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			dao.setBudgetManagementId( budgetmanagementwithb.getBudgetManagementId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(budgetmanagementwithb);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update BudgetManagementWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? budgetmanagementwithb : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBudgetManagementWithB updateBudgetManagementWithBDirect( BaseBudgetManagementWithB budgetmanagementwithb ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BudgetManagementWithB dao = new BudgetManagementWithB();
			int result = 0;
			dao.setDataFromBase(budgetmanagementwithb);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update BudgetManagementWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? budgetmanagementwithb : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseBudgetManagementWithB bean, BudgetManagementWithB dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetManagementId() != null) {
			dao.setBudgetManagementId(bean.getBudgetManagementId());
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBdCode() != null) {
				dao.setConditionBdCode("=", bean.getBdCode());
				count++;
			}
			if(bean.getBdType() != null) {
				dao.setConditionBdType("=", bean.getBdType());
				count++;
			}
			if(bean.getBdApplyEmployeeId() != null) {
				dao.setConditionBdApplyEmployeeId("=", bean.getBdApplyEmployeeId());
				count++;
			}
			if(bean.getBdStatus() != null) {
				dao.setConditionBdStatus("=", bean.getBdStatus());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getBdRemark() != null) {
				dao.setConditionBdRemark("=", bean.getBdRemark());
				count++;
			}
			if(bean.getInputTaxInvoiceId() != null) {
				dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetManagementWithB bean, BudgetManagementWithB dao){
		int count = 0;
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBdCode() != null) {
			if(bean.getBdCode().indexOf("%") >= 0)
				dao.setConditionBdCode("like", bean.getBdCode());
			else
				dao.setConditionBdCode("=", bean.getBdCode());
			count++;
		}
		if(bean.getBdType() != null) {
			dao.setConditionBdType("=", bean.getBdType());
			count++;
		}
		if(bean.getBdTotalAmount() != null) {
			dao.setConditionBdTotalAmount("=", bean.getBdTotalAmount());
			count++;
		}
		if(bean.getBdUseAmount() != null) {
			dao.setConditionBdUseAmount("=", bean.getBdUseAmount());
			count++;
		}
		if(bean.getBdRestAmount() != null) {
			dao.setConditionBdRestAmount("=", bean.getBdRestAmount());
			count++;
		}
		if(bean.getBdApplyEmployeeId() != null) {
			dao.setConditionBdApplyEmployeeId("=", bean.getBdApplyEmployeeId());
			count++;
		}
		if(bean.getBdApplyTime() != null) {
			dao.setConditionBdApplyTime(">=", bean.getBdApplyTime());
			count++;
		}
		if(bean.getBdEstimatecloseTime() != null) {
			dao.setConditionBdEstimatecloseTime(">=", bean.getBdEstimatecloseTime());
			count++;
		}
		if(bean.getBdStatus() != null) {
			dao.setConditionBdStatus("=", bean.getBdStatus());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getBdRemark() != null) {
			if(bean.getBdRemark().indexOf("%") >= 0)
				dao.setConditionBdRemark("like", bean.getBdRemark());
			else
				dao.setConditionBdRemark("=", bean.getBdRemark());
			count++;
		}
		if(bean.getInputTaxInvoiceId() != null) {
			dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		bean.setDataFromJSON(json);
		BudgetManagementWithB dao = new BudgetManagementWithB();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetManagementWithB> rlist = new BaseCollection<>();
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetManagementWithB dao = new BudgetManagementWithB();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetManagementWithB> result = dao.conditionalLoadExt(addtion);
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
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		bean.setDataFromJSON(json);
		BudgetManagementWithB dao = new BudgetManagementWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		bean.setDataFromJSON(json);
		int num = 0;
		BudgetManagementWithB dao = new BudgetManagementWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		bean.setDataFromJSON(json);
		BudgetManagementWithB dao = new BudgetManagementWithB();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
		bean.setDataFromJSON(json);
		BudgetManagementWithB dao = new BudgetManagementWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


