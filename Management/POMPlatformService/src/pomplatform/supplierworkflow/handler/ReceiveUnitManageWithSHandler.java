package pomplatform.supplierworkflow.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.supplierworkflow.bean.BaseReceiveUnitManageWithS;
import pomplatform.supplierworkflow.dao.ReceiveUnitManageWithS;
import com.pomplatform.db.dao.Supplier;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ReceiveUnitManageWithSHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ReceiveUnitManageWithSHandler.class);

	public static BaseReceiveUnitManageWithS getReceiveUnitManageWithSById( java.lang.Integer receive_unit_manage_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseReceiveUnitManageWithS result;
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			dao.setReceiveUnitManageId(receive_unit_manage_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ReceiveUnitManageWithS By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isReceiveUnitManageWithSExists( pomplatform.supplierworkflow.bean.BaseReceiveUnitManageWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ReceiveUnitManageWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countReceiveUnitManageWithS( pomplatform.supplierworkflow.bean.BaseReceiveUnitManageWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ReceiveUnitManageWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseReceiveUnitManageWithS> queryReceiveUnitManageWithS( BaseReceiveUnitManageWithS bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseReceiveUnitManageWithS> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseReceiveUnitManageWithS> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ReceiveUnitManageWithS List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReceiveUnitManageWithS addToReceiveUnitManageWithS ( BaseReceiveUnitManageWithS receiveunitmanagewiths ) {
		return addToReceiveUnitManageWithS ( receiveunitmanagewiths , false);
	}

	public static BaseReceiveUnitManageWithS addToReceiveUnitManageWithS ( BaseReceiveUnitManageWithS receiveunitmanagewiths, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			dao.setDataFromBase(receiveunitmanagewiths);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ReceiveUnitManageWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReceiveUnitManageWithS addUpdateReceiveUnitManageWithS ( BaseReceiveUnitManageWithS receiveunitmanagewiths ) {
		return addUpdateReceiveUnitManageWithS ( receiveunitmanagewiths , false);
	}

	public static BaseReceiveUnitManageWithS addUpdateReceiveUnitManageWithS ( BaseReceiveUnitManageWithS receiveunitmanagewiths, boolean singleTransaction  ) {
		if(receiveunitmanagewiths.getReceiveUnitManageId() == null) return addToReceiveUnitManageWithS(receiveunitmanagewiths);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			dao.setDataFromBase(receiveunitmanagewiths);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(receiveunitmanagewiths); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ReceiveUnitManageWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReceiveUnitManageWithS deleteReceiveUnitManageWithS ( BaseReceiveUnitManageWithS bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ReceiveUnitManageWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReceiveUnitManageWithS updateReceiveUnitManageWithS ( BaseReceiveUnitManageWithS receiveunitmanagewiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			dao.setReceiveUnitManageId( receiveunitmanagewiths.getReceiveUnitManageId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(receiveunitmanagewiths);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ReceiveUnitManageWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? receiveunitmanagewiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseReceiveUnitManageWithS updateReceiveUnitManageWithSDirect( BaseReceiveUnitManageWithS receiveunitmanagewiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
			int result = 0;
			dao.setDataFromBase(receiveunitmanagewiths);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ReceiveUnitManageWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? receiveunitmanagewiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseReceiveUnitManageWithS bean, ReceiveUnitManageWithS dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReceiveUnitManageId() != null) {
			dao.setReceiveUnitManageId(bean.getReceiveUnitManageId());
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReceiveUnit() != null) {
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
			if(bean.getReceiveUnitAddress() != null) {
				dao.setConditionReceiveUnitAddress("=", bean.getReceiveUnitAddress());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getOrigin() != null) {
				dao.setConditionOrigin("=", bean.getOrigin());
				count++;
			}
			if(bean.getReceiveUnitType() != null) {
				dao.setConditionReceiveUnitType("=", bean.getReceiveUnitType());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getSalaryType() != null) {
				dao.setConditionSalaryType("=", bean.getSalaryType());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getBankAddress() != null) {
				dao.setConditionBankAddress("=", bean.getBankAddress());
				count++;
			}
			if(bean.getReceiveUnitPhone() != null) {
				dao.setConditionReceiveUnitPhone("=", bean.getReceiveUnitPhone());
				count++;
			}
			if(bean.getSwiftCode() != null) {
				dao.setConditionSwiftCode("=", bean.getSwiftCode());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getCountryCode() != null) {
				dao.setConditionCountryCode("=", bean.getCountryCode());
				count++;
			}
			if(bean.getPassport() != null) {
				dao.setConditionPassport("=", bean.getPassport());
				count++;
			}
			if(bean.getBankId() != null) {
				dao.setConditionBankId("=", bean.getBankId());
				count++;
			}
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getIsUse() != null) {
				dao.setConditionIsUse("=", bean.getIsUse());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReceiveUnitManageWithS bean, ReceiveUnitManageWithS dao){
		int count = 0;
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getReceiveUnit() != null) {
			if(bean.getReceiveUnit().indexOf("%") >= 0)
				dao.setConditionReceiveUnit("like", bean.getReceiveUnit());
			else
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		if(bean.getReceiveUnitAddress() != null) {
			if(bean.getReceiveUnitAddress().indexOf("%") >= 0)
				dao.setConditionReceiveUnitAddress("like", bean.getReceiveUnitAddress());
			else
				dao.setConditionReceiveUnitAddress("=", bean.getReceiveUnitAddress());
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
		if(bean.getOrigin() != null) {
			dao.setConditionOrigin("=", bean.getOrigin());
			count++;
		}
		if(bean.getReceiveUnitType() != null) {
			dao.setConditionReceiveUnitType("=", bean.getReceiveUnitType());
			count++;
		}
		if(bean.getCompanyId() != null) {
			if(bean.getCompanyId().indexOf("%") >= 0)
				dao.setConditionCompanyId("like", bean.getCompanyId());
			else
				dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getSalaryType() != null) {
			dao.setConditionSalaryType("=", bean.getSalaryType());
			count++;
		}
		if(bean.getProvince() != null) {
			dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getBankAddress() != null) {
			if(bean.getBankAddress().indexOf("%") >= 0)
				dao.setConditionBankAddress("like", bean.getBankAddress());
			else
				dao.setConditionBankAddress("=", bean.getBankAddress());
			count++;
		}
		if(bean.getReceiveUnitPhone() != null) {
			if(bean.getReceiveUnitPhone().indexOf("%") >= 0)
				dao.setConditionReceiveUnitPhone("like", bean.getReceiveUnitPhone());
			else
				dao.setConditionReceiveUnitPhone("=", bean.getReceiveUnitPhone());
			count++;
		}
		if(bean.getSwiftCode() != null) {
			if(bean.getSwiftCode().indexOf("%") >= 0)
				dao.setConditionSwiftCode("like", bean.getSwiftCode());
			else
				dao.setConditionSwiftCode("=", bean.getSwiftCode());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getCountryCode() != null) {
			if(bean.getCountryCode().indexOf("%") >= 0)
				dao.setConditionCountryCode("like", bean.getCountryCode());
			else
				dao.setConditionCountryCode("=", bean.getCountryCode());
			count++;
		}
		if(bean.getPassport() != null) {
			if(bean.getPassport().indexOf("%") >= 0)
				dao.setConditionPassport("like", bean.getPassport());
			else
				dao.setConditionPassport("=", bean.getPassport());
			count++;
		}
		if(bean.getBankId() != null) {
			dao.setConditionBankId("=", bean.getBankId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getIsUse() != null) {
			dao.setConditionIsUse("=", bean.getIsUse());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		bean.setDataFromJSON(json);
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReceiveUnitManageWithS> rlist = new BaseCollection<>();
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReceiveUnitManageWithS> result = dao.conditionalLoadExt(addtion);
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
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		bean.setDataFromJSON(json);
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		bean.setDataFromJSON(json);
		int num = 0;
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		bean.setDataFromJSON(json);
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();
		bean.setDataFromJSON(json);
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


