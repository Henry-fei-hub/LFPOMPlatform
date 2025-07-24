package pomplatform.costallocation.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.costallocation.bean.BaseResetCostWithC;
import pomplatform.costallocation.dao.ResetCostWithC;
import com.pomplatform.db.dao.CostAllocation;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ResetCostWithCHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ResetCostWithCHandler.class);

	public static BaseResetCostWithC getResetCostWithCById( java.lang.Integer reset_cost_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseResetCostWithC result;
			ResetCostWithC dao = new ResetCostWithC();
			dao.setResetCostId(reset_cost_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ResetCostWithC By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isResetCostWithCExists( pomplatform.costallocation.bean.BaseResetCostWithC bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ResetCostWithC List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countResetCostWithC( pomplatform.costallocation.bean.BaseResetCostWithC bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ResetCostWithC List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseResetCostWithC> queryResetCostWithC( BaseResetCostWithC bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseResetCostWithC> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseResetCostWithC> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ResetCostWithC List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseResetCostWithC addToResetCostWithC ( BaseResetCostWithC resetcostwithc ) {
		return addToResetCostWithC ( resetcostwithc , false);
	}

	public static BaseResetCostWithC addToResetCostWithC ( BaseResetCostWithC resetcostwithc, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ResetCostWithC dao = new ResetCostWithC();
			dao.setDataFromBase(resetcostwithc);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ResetCostWithC time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseResetCostWithC addUpdateResetCostWithC ( BaseResetCostWithC resetcostwithc ) {
		return addUpdateResetCostWithC ( resetcostwithc , false);
	}

	public static BaseResetCostWithC addUpdateResetCostWithC ( BaseResetCostWithC resetcostwithc, boolean singleTransaction  ) {
		if(resetcostwithc.getResetCostId() == null) return addToResetCostWithC(resetcostwithc);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ResetCostWithC dao = new ResetCostWithC();
			dao.setDataFromBase(resetcostwithc);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(resetcostwithc); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ResetCostWithC time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseResetCostWithC deleteResetCostWithC ( BaseResetCostWithC bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ResetCostWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseResetCostWithC updateResetCostWithC ( BaseResetCostWithC resetcostwithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			dao.setResetCostId( resetcostwithc.getResetCostId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(resetcostwithc);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ResetCostWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? resetcostwithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseResetCostWithC updateResetCostWithCDirect( BaseResetCostWithC resetcostwithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ResetCostWithC dao = new ResetCostWithC();
			int result = 0;
			dao.setDataFromBase(resetcostwithc);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ResetCostWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? resetcostwithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseResetCostWithC bean, ResetCostWithC dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResetCostId() != null) {
			dao.setResetCostId(bean.getResetCostId());
			dao.setConditionResetCostId("=", bean.getResetCostId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getId() != null) {
				dao.setConditionId("=", bean.getId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getLinkId() != null) {
				dao.setConditionLinkId("=", bean.getLinkId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseResetCostWithC bean, ResetCostWithC dao){
		int count = 0;
		if(bean.getResetCostId() != null) {
			dao.setConditionResetCostId("=", bean.getResetCostId());
			count++;
		}
		if(bean.getId() != null) {
			dao.setConditionId("=", bean.getId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getCost() != null) {
			dao.setConditionCost("=", bean.getCost());
			count++;
		}
		if(bean.getLinkId() != null) {
			dao.setConditionLinkId("=", bean.getLinkId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseResetCostWithC bean = new BaseResetCostWithC();
		bean.setDataFromJSON(json);
		ResetCostWithC dao = new ResetCostWithC();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseResetCostWithC> rlist = new BaseCollection<>();
		BaseResetCostWithC bean = new BaseResetCostWithC();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ResetCostWithC dao = new ResetCostWithC();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseResetCostWithC> result = dao.conditionalLoadExt(addtion);
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
		BaseResetCostWithC bean = new BaseResetCostWithC();
		bean.setDataFromJSON(json);
		ResetCostWithC dao = new ResetCostWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseResetCostWithC bean = new BaseResetCostWithC();
		bean.setDataFromJSON(json);
		int num = 0;
		ResetCostWithC dao = new ResetCostWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseResetCostWithC bean = new BaseResetCostWithC();
		bean.setDataFromJSON(json);
		ResetCostWithC dao = new ResetCostWithC();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseResetCostWithC bean = new BaseResetCostWithC();
		bean.setDataFromJSON(json);
		ResetCostWithC dao = new ResetCostWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


