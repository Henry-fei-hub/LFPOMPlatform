package pomplatform.orderplacement.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.orderplacement.bean.BaseOrderInfoWithO;
import pomplatform.orderplacement.dao.OrderInfoWithO;
import com.pomplatform.db.dao.OrderInfoChild;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class OrderInfoWithOHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(OrderInfoWithOHandler.class);

	public static BaseOrderInfoWithO getOrderInfoWithOById( java.lang.Integer order_info_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseOrderInfoWithO result;
			OrderInfoWithO dao = new OrderInfoWithO();
			dao.setOrderInfoId(order_info_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get OrderInfoWithO By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isOrderInfoWithOExists( pomplatform.orderplacement.bean.BaseOrderInfoWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query OrderInfoWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countOrderInfoWithO( pomplatform.orderplacement.bean.BaseOrderInfoWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query OrderInfoWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseOrderInfoWithO> queryOrderInfoWithO( BaseOrderInfoWithO bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseOrderInfoWithO> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseOrderInfoWithO> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query OrderInfoWithO List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOrderInfoWithO addToOrderInfoWithO ( BaseOrderInfoWithO orderinfowitho ) {
		return addToOrderInfoWithO ( orderinfowitho , false);
	}

	public static BaseOrderInfoWithO addToOrderInfoWithO ( BaseOrderInfoWithO orderinfowitho, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			OrderInfoWithO dao = new OrderInfoWithO();
			dao.setDataFromBase(orderinfowitho);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to OrderInfoWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOrderInfoWithO addUpdateOrderInfoWithO ( BaseOrderInfoWithO orderinfowitho ) {
		return addUpdateOrderInfoWithO ( orderinfowitho , false);
	}

	public static BaseOrderInfoWithO addUpdateOrderInfoWithO ( BaseOrderInfoWithO orderinfowitho, boolean singleTransaction  ) {
		if(orderinfowitho.getOrderInfoId() == null) return addToOrderInfoWithO(orderinfowitho);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			OrderInfoWithO dao = new OrderInfoWithO();
			dao.setDataFromBase(orderinfowitho);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(orderinfowitho); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to OrderInfoWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOrderInfoWithO deleteOrderInfoWithO ( BaseOrderInfoWithO bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete OrderInfoWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOrderInfoWithO updateOrderInfoWithO ( BaseOrderInfoWithO orderinfowitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			dao.setOrderInfoId( orderinfowitho.getOrderInfoId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(orderinfowitho);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update OrderInfoWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? orderinfowitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseOrderInfoWithO updateOrderInfoWithODirect( BaseOrderInfoWithO orderinfowitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			OrderInfoWithO dao = new OrderInfoWithO();
			int result = 0;
			dao.setDataFromBase(orderinfowitho);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update OrderInfoWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? orderinfowitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseOrderInfoWithO bean, OrderInfoWithO dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOrderInfoId() != null) {
			dao.setOrderInfoId(bean.getOrderInfoId());
			dao.setConditionOrderInfoId("=", bean.getOrderInfoId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractType() != null) {
				dao.setConditionContractType("=", bean.getContractType());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getProjectAddress() != null) {
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
				count++;
			}
			if(bean.getContractFollower() != null) {
				dao.setConditionContractFollower("=", bean.getContractFollower());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSigningCompanyName() != null) {
				dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getFlowStatus() != null) {
				dao.setConditionFlowStatus("=", bean.getFlowStatus());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProfessionalCooperation() != null) {
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
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
			if(bean.getDetailAddress() != null) {
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
				count++;
			}
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getServiceSuggestBook() != null) {
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getContractStatus() != null) {
				dao.setConditionContractStatus("=", bean.getContractStatus());
				count++;
			}
			if(bean.getClientContractId() != null) {
				dao.setConditionClientContractId("=", bean.getClientContractId());
				count++;
			}
			if(bean.getIsFinish() != null) {
				dao.setConditionIsFinish("=", bean.getIsFinish());
				count++;
			}
			if(bean.getIsSystemAdd() != null) {
				dao.setConditionIsSystemAdd("=", bean.getIsSystemAdd());
				count++;
			}
			if(bean.getHasOutQuotations() != null) {
				dao.setConditionHasOutQuotations("=", bean.getHasOutQuotations());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
			if(bean.getTotalProjectTime() != null) {
				dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
				count++;
			}
			if(bean.getHasSplitPrice() != null) {
				dao.setConditionHasSplitPrice("=", bean.getHasSplitPrice());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOrderInfoWithO bean, OrderInfoWithO dao){
		int count = 0;
		if(bean.getOrderInfoId() != null) {
			dao.setConditionOrderInfoId("=", bean.getOrderInfoId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
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
		if(bean.getStatus() != null) {
			if(bean.getStatus().indexOf("%") >= 0)
				dao.setConditionStatus("like", bean.getStatus());
			else
				dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getContractType() != null) {
			if(bean.getContractType().indexOf("%") >= 0)
				dao.setConditionContractType("like", bean.getContractType());
			else
				dao.setConditionContractType("=", bean.getContractType());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			if(bean.getProjectLevel().indexOf("%") >= 0)
				dao.setConditionProjectLevel("like", bean.getProjectLevel());
			else
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getContractPrice() != null) {
			dao.setConditionContractPrice("=", bean.getContractPrice());
			count++;
		}
		if(bean.getProjectAddress() != null) {
			if(bean.getProjectAddress().indexOf("%") >= 0)
				dao.setConditionProjectAddress("like", bean.getProjectAddress());
			else
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
			count++;
		}
		if(bean.getContractFollower() != null) {
			dao.setConditionContractFollower("=", bean.getContractFollower());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getSigningCompanyName() != null) {
			dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getFlowStatus() != null) {
			dao.setConditionFlowStatus("=", bean.getFlowStatus());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			if(bean.getSerialNumber().indexOf("%") >= 0)
				dao.setConditionSerialNumber("like", bean.getSerialNumber());
			else
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getProjectType() != null) {
			if(bean.getProjectType().indexOf("%") >= 0)
				dao.setConditionProjectType("like", bean.getProjectType());
			else
				dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getCoveredArea() != null) {
			dao.setConditionCoveredArea("=", bean.getCoveredArea());
			count++;
		}
		if(bean.getProfessionalCooperation() != null) {
			if(bean.getProfessionalCooperation().indexOf("%") >= 0)
				dao.setConditionProfessionalCooperation("like", bean.getProfessionalCooperation());
			else
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
			count++;
		}
		if(bean.getProvince() != null) {
			if(bean.getProvince().indexOf("%") >= 0)
				dao.setConditionProvince("like", bean.getProvince());
			else
				dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getDetailAddress() != null) {
			if(bean.getDetailAddress().indexOf("%") >= 0)
				dao.setConditionDetailAddress("like", bean.getDetailAddress());
			else
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
			count++;
		}
		if(bean.getCustomerAddress() != null) {
			if(bean.getCustomerAddress().indexOf("%") >= 0)
				dao.setConditionCustomerAddress("like", bean.getCustomerAddress());
			else
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
			count++;
		}
		if(bean.getServiceSuggestBook() != null) {
			if(bean.getServiceSuggestBook().indexOf("%") >= 0)
				dao.setConditionServiceSuggestBook("like", bean.getServiceSuggestBook());
			else
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getContractStatus() != null) {
			dao.setConditionContractStatus("=", bean.getContractStatus());
			count++;
		}
		if(bean.getClientContractId() != null) {
			if(bean.getClientContractId().indexOf("%") >= 0)
				dao.setConditionClientContractId("like", bean.getClientContractId());
			else
				dao.setConditionClientContractId("=", bean.getClientContractId());
			count++;
		}
		if(bean.getIsFinish() != null) {
			dao.setConditionIsFinish("=", bean.getIsFinish());
			count++;
		}
		if(bean.getIsSystemAdd() != null) {
			dao.setConditionIsSystemAdd("=", bean.getIsSystemAdd());
			count++;
		}
		if(bean.getHasOutQuotations() != null) {
			dao.setConditionHasOutQuotations("=", bean.getHasOutQuotations());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
			count++;
		}
		if(bean.getTotalProjectTime() != null) {
			dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
			count++;
		}
		if(bean.getDesignAreas() != null) {
			dao.setConditionDesignAreas("=", bean.getDesignAreas());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getHasSplitPrice() != null) {
			dao.setConditionHasSplitPrice("=", bean.getHasSplitPrice());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		bean.setDataFromJSON(json);
		OrderInfoWithO dao = new OrderInfoWithO();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOrderInfoWithO> rlist = new BaseCollection<>();
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OrderInfoWithO dao = new OrderInfoWithO();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOrderInfoWithO> result = dao.conditionalLoadExt(addtion);
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
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		bean.setDataFromJSON(json);
		OrderInfoWithO dao = new OrderInfoWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		bean.setDataFromJSON(json);
		int num = 0;
		OrderInfoWithO dao = new OrderInfoWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		bean.setDataFromJSON(json);
		OrderInfoWithO dao = new OrderInfoWithO();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOrderInfoWithO bean = new BaseOrderInfoWithO();
		bean.setDataFromJSON(json);
		OrderInfoWithO dao = new OrderInfoWithO();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


