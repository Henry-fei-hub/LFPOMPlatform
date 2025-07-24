package pomplatform.ht.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.ht.bean.BaseOutQuotationWithO;
import pomplatform.ht.dao.OutQuotationWithO;
import com.pomplatform.db.dao.OutDesignConsideration;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class OutQuotationWithOHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(OutQuotationWithOHandler.class);

	public static BaseOutQuotationWithO getOutQuotationWithOById( java.lang.Integer out_quotation_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseOutQuotationWithO result;
			OutQuotationWithO dao = new OutQuotationWithO();
			dao.setOutQuotationId(out_quotation_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get OutQuotationWithO By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isOutQuotationWithOExists( pomplatform.ht.bean.BaseOutQuotationWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query OutQuotationWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countOutQuotationWithO( pomplatform.ht.bean.BaseOutQuotationWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query OutQuotationWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseOutQuotationWithO> queryOutQuotationWithO( BaseOutQuotationWithO bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseOutQuotationWithO> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseOutQuotationWithO> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query OutQuotationWithO List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOutQuotationWithO addToOutQuotationWithO ( BaseOutQuotationWithO outquotationwitho ) {
		return addToOutQuotationWithO ( outquotationwitho , false);
	}

	public static BaseOutQuotationWithO addToOutQuotationWithO ( BaseOutQuotationWithO outquotationwitho, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			OutQuotationWithO dao = new OutQuotationWithO();
			dao.setDataFromBase(outquotationwitho);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to OutQuotationWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOutQuotationWithO addUpdateOutQuotationWithO ( BaseOutQuotationWithO outquotationwitho ) {
		return addUpdateOutQuotationWithO ( outquotationwitho , false);
	}

	public static BaseOutQuotationWithO addUpdateOutQuotationWithO ( BaseOutQuotationWithO outquotationwitho, boolean singleTransaction  ) {
		if(outquotationwitho.getOutQuotationId() == null) return addToOutQuotationWithO(outquotationwitho);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			OutQuotationWithO dao = new OutQuotationWithO();
			dao.setDataFromBase(outquotationwitho);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(outquotationwitho); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to OutQuotationWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOutQuotationWithO deleteOutQuotationWithO ( BaseOutQuotationWithO bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete OutQuotationWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOutQuotationWithO updateOutQuotationWithO ( BaseOutQuotationWithO outquotationwitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			dao.setOutQuotationId( outquotationwitho.getOutQuotationId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(outquotationwitho);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update OutQuotationWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? outquotationwitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOutQuotationWithO updateOutQuotationWithODirect( BaseOutQuotationWithO outquotationwitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OutQuotationWithO dao = new OutQuotationWithO();
			int result = 0;
			dao.setDataFromBase(outquotationwitho);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update OutQuotationWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? outquotationwitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseOutQuotationWithO bean, OutQuotationWithO dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutQuotationId() != null) {
			dao.setOutQuotationId(bean.getOutQuotationId());
			dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getQuotationNumber() != null) {
				dao.setConditionQuotationNumber("=", bean.getQuotationNumber());
				count++;
			}
			if(bean.getQuotationName() != null) {
				dao.setConditionQuotationName("=", bean.getQuotationName());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getQuotationFiles() != null) {
				dao.setConditionQuotationFiles("=", bean.getQuotationFiles());
				count++;
			}
			if(bean.getQuotationStatus() != null) {
				dao.setConditionQuotationStatus("=", bean.getQuotationStatus());
				count++;
			}
			if(bean.getDisableType() != null) {
				dao.setConditionDisableType("=", bean.getDisableType());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutQuotationWithO bean, OutQuotationWithO dao){
		int count = 0;
		if(bean.getOutQuotationId() != null) {
			dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
			count++;
		}
		if(bean.getQuotationNumber() != null) {
			if(bean.getQuotationNumber().indexOf("%") >= 0)
				dao.setConditionQuotationNumber("like", bean.getQuotationNumber());
			else
				dao.setConditionQuotationNumber("=", bean.getQuotationNumber());
			count++;
		}
		if(bean.getQuotationName() != null) {
			if(bean.getQuotationName().indexOf("%") >= 0)
				dao.setConditionQuotationName("like", bean.getQuotationName());
			else
				dao.setConditionQuotationName("=", bean.getQuotationName());
			count++;
		}
		if(bean.getMoneySum() != null) {
			dao.setConditionMoneySum("=", bean.getMoneySum());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getQuotationFiles() != null) {
			if(bean.getQuotationFiles().indexOf("%") >= 0)
				dao.setConditionQuotationFiles("like", bean.getQuotationFiles());
			else
				dao.setConditionQuotationFiles("=", bean.getQuotationFiles());
			count++;
		}
		if(bean.getQuotationStatus() != null) {
			dao.setConditionQuotationStatus("=", bean.getQuotationStatus());
			count++;
		}
		if(bean.getDisableType() != null) {
			dao.setConditionDisableType("=", bean.getDisableType());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		bean.setDataFromJSON(json);
		OutQuotationWithO dao = new OutQuotationWithO();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutQuotationWithO> rlist = new BaseCollection<>();
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutQuotationWithO dao = new OutQuotationWithO();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutQuotationWithO> result = dao.conditionalLoadExt(addtion);
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
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		bean.setDataFromJSON(json);
		OutQuotationWithO dao = new OutQuotationWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		bean.setDataFromJSON(json);
		int num = 0;
		OutQuotationWithO dao = new OutQuotationWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		bean.setDataFromJSON(json);
		OutQuotationWithO dao = new OutQuotationWithO();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
		bean.setDataFromJSON(json);
		OutQuotationWithO dao = new OutQuotationWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


