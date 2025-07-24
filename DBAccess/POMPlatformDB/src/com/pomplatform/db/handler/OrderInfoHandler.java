package com.pomplatform.db.handler;

import com.pomplatform.db.bean.BaseOrderInfo;
import org.apache.log4j.Logger;

import java.util.List;
import com.pomplatform.db.dao.OrderInfo;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class OrderInfoHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OrderInfoHandler.class);

	public static BaseOrderInfo getOrderInfoById(
		Integer order_info_id
	) throws Exception
	{
		OrderInfo dao = new OrderInfo();
		dao.setOrderInfoId(order_info_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOrderInfoExists( BaseOrderInfo bean, String additional ) throws Exception {

		OrderInfo dao = new OrderInfo();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOrderInfo( BaseOrderInfo bean, String additional ) throws Exception {

		OrderInfo dao = new OrderInfo();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOrderInfo> queryOrderInfo( BaseOrderInfo bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OrderInfo dao = new OrderInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		List<BaseOrderInfo> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOrderInfo> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOrderInfo addToOrderInfo ( BaseOrderInfo orderinfo )  throws Exception {
		return addToOrderInfo ( orderinfo , false);
	}

	public static BaseOrderInfo addToOrderInfo ( BaseOrderInfo orderinfo, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OrderInfo dao = new OrderInfo();
		dao.setDataFromBase(orderinfo);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOrderInfo addUpdateOrderInfo ( BaseOrderInfo orderinfo ) throws Exception {
		return addUpdateOrderInfo ( orderinfo , false);
	}

	public static BaseOrderInfo addUpdateOrderInfo ( BaseOrderInfo orderinfo, boolean singleTransaction  ) throws Exception {
		if(orderinfo.getOrderInfoId() == null) return addToOrderInfo(orderinfo);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OrderInfo dao = new OrderInfo();
		dao.setDataFromBase(orderinfo);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(orderinfo); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOrderInfo ( BaseOrderInfo bean ) throws Exception {
		OrderInfo dao = new OrderInfo();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOrderInfo updateOrderInfo ( BaseOrderInfo orderinfo ) throws Exception {
		OrderInfo dao = new OrderInfo();
		dao.setOrderInfoId( orderinfo.getOrderInfoId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(orderinfo);
			result = dao.update();
		}
		return result == 1 ? orderinfo : null ;
	}

	public static BaseOrderInfo updateOrderInfoDirect( BaseOrderInfo orderinfo ) throws Exception {
		OrderInfo dao = new OrderInfo();
		int result = 0;
		dao.setDataFromBase(orderinfo);
		result = dao.update();
		return result == 1 ? orderinfo : null ;
	}

	public static int setDeleteConditions(BaseOrderInfo bean, OrderInfo dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOrderInfoId() != null) {
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
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getOutOuttationId() != null) {
				dao.setConditionOutOuttationId("=", bean.getOutOuttationId());
				count++;
			}
			if(bean.getFileName() != null) {
				dao.setConditionFlieName("=", bean.getFileName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOrderInfo bean, OrderInfo dao){
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
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getOutOuttationId() != null) {
			dao.setConditionOutOuttationId("=", bean.getOutOuttationId());
			count++;
		}
		if(bean.getFileName() != null) {
			if(bean.getFileName().indexOf("%") >= 0)
				dao.setConditionFlieName("like", bean.getFileName());
			else
				dao.setConditionFlieName("=", bean.getFileName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOrderInfo bean = new BaseOrderInfo();
		bean.setDataFromJSON(json);
		OrderInfo dao = new OrderInfo();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOrderInfo> rlist = new BaseCollection<>();
		BaseOrderInfo bean = new BaseOrderInfo();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OrderInfo dao = new OrderInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOrderInfo> result = dao.conditionalLoad(addtion);
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
		BaseOrderInfo bean = new BaseOrderInfo();
		bean.setDataFromJSON(json);
		OrderInfo dao = new OrderInfo();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOrderInfo bean = new BaseOrderInfo();
		bean.setDataFromJSON(json);
		OrderInfo dao = new OrderInfo();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOrderInfo bean = new BaseOrderInfo();
		bean.setDataFromJSON(json);
		OrderInfo dao = new OrderInfo();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOrderInfo bean = new BaseOrderInfo();
		bean.setDataFromJSON(json);
		OrderInfo dao = new OrderInfo();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


