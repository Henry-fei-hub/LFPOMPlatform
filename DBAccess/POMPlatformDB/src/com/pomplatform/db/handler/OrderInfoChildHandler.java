package com.pomplatform.db.handler;

import com.pomplatform.db.bean.BaseOrderInfoChild;
import org.apache.log4j.Logger;

import java.util.List;
import com.pomplatform.db.dao.OrderInfoChild;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class OrderInfoChildHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OrderInfoChildHandler.class);

	public static BaseOrderInfoChild getOrderInfoChildById(
		Integer order_info_child_id
	) throws Exception
	{
		OrderInfoChild dao = new OrderInfoChild();
		dao.setOrderInfoChildId(order_info_child_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOrderInfoChildExists( BaseOrderInfoChild bean, String additional ) throws Exception {

		OrderInfoChild dao = new OrderInfoChild();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOrderInfoChild( BaseOrderInfoChild bean, String additional ) throws Exception {

		OrderInfoChild dao = new OrderInfoChild();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOrderInfoChild> queryOrderInfoChild( BaseOrderInfoChild bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OrderInfoChild dao = new OrderInfoChild();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		List<BaseOrderInfoChild> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOrderInfoChild> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOrderInfoChild addToOrderInfoChild ( BaseOrderInfoChild orderinfochild )  throws Exception {
		return addToOrderInfoChild ( orderinfochild , false);
	}

	public static BaseOrderInfoChild addToOrderInfoChild ( BaseOrderInfoChild orderinfochild, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OrderInfoChild dao = new OrderInfoChild();
		dao.setDataFromBase(orderinfochild);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOrderInfoChild addUpdateOrderInfoChild ( BaseOrderInfoChild orderinfochild ) throws Exception {
		return addUpdateOrderInfoChild ( orderinfochild , false);
	}

	public static BaseOrderInfoChild addUpdateOrderInfoChild ( BaseOrderInfoChild orderinfochild, boolean singleTransaction  ) throws Exception {
		if(orderinfochild.getOrderInfoChildId() == null) return addToOrderInfoChild(orderinfochild);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OrderInfoChild dao = new OrderInfoChild();
		dao.setDataFromBase(orderinfochild);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(orderinfochild); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOrderInfoChild ( BaseOrderInfoChild bean ) throws Exception {
		OrderInfoChild dao = new OrderInfoChild();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOrderInfoChild updateOrderInfoChild ( BaseOrderInfoChild orderinfochild ) throws Exception {
		OrderInfoChild dao = new OrderInfoChild();
		dao.setOrderInfoChildId( orderinfochild.getOrderInfoChildId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(orderinfochild);
			result = dao.update();
		}
		return result == 1 ? orderinfochild : null ;
	}

	public static BaseOrderInfoChild updateOrderInfoChildDirect( BaseOrderInfoChild orderinfochild ) throws Exception {
		OrderInfoChild dao = new OrderInfoChild();
		int result = 0;
		dao.setDataFromBase(orderinfochild);
		result = dao.update();
		return result == 1 ? orderinfochild : null ;
	}

	public static int setDeleteConditions(BaseOrderInfoChild bean, OrderInfoChild dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOrderInfoChildId() != null) {
			dao.setConditionOrderInfoChildId("=", bean.getOrderInfoChildId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSubContractId() != null) {
				dao.setConditionSubContractId("=", bean.getSubContractId());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSubContractCode() != null) {
				dao.setConditionSubContractCode("=", bean.getSubContractCode());
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
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSubContractName() != null) {
				dao.setConditionSubContractName("=", bean.getSubContractName());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getOrderInfoId() != null) {
				dao.setConditionOrderInfoId("=", bean.getOrderInfoId());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getIsHistory() != null) {
				dao.setConditionIsHistory("=", bean.getIsHistory());
				count++;
			}
			if(bean.getBusinessStateRecordId() != null) {
				dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
				count++;
			}
			if(bean.getReserveSheetId() != null) {
				dao.setConditionReserveSheetId("=", bean.getReserveSheetId());
				count++;
			}
			if(bean.getBusinessLine() != null) {
				dao.setConditionBusinessLine("=", bean.getBusinessLine());
				count++;
			}
			if(bean.getIsAuto() != null) {
				dao.setConditionIsAuto("=", bean.getIsAuto());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOrderInfoChild bean, OrderInfoChild dao){
		int count = 0;
		if(bean.getOrderInfoChildId() != null) {
			dao.setConditionOrderInfoChildId("=", bean.getOrderInfoChildId());
			count++;
		}
		if(bean.getSubContractId() != null) {
			dao.setConditionSubContractId("=", bean.getSubContractId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSubContractCode() != null) {
			if(bean.getSubContractCode().indexOf("%") >= 0)
				dao.setConditionSubContractCode("like", bean.getSubContractCode());
			else
				dao.setConditionSubContractCode("=", bean.getSubContractCode());
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
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCommonArea() != null) {
			dao.setConditionCommonArea("=", bean.getCommonArea());
			count++;
		}
		if(bean.getLogisticsArea() != null) {
			dao.setConditionLogisticsArea("=", bean.getLogisticsArea());
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
		if(bean.getSubContractName() != null) {
			if(bean.getSubContractName().indexOf("%") >= 0)
				dao.setConditionSubContractName("like", bean.getSubContractName());
			else
				dao.setConditionSubContractName("=", bean.getSubContractName());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getSheetTotalIntegral() != null) {
			dao.setConditionSheetTotalIntegral("=", bean.getSheetTotalIntegral());
			count++;
		}
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getComplaintPercentage() != null) {
			dao.setConditionComplaintPercentage("=", bean.getComplaintPercentage());
			count++;
		}
		if(bean.getComplaintIntegral() != null) {
			dao.setConditionComplaintIntegral("=", bean.getComplaintIntegral());
			count++;
		}
		if(bean.getSheetIntegral() != null) {
			dao.setConditionSheetIntegral("=", bean.getSheetIntegral());
			count++;
		}
		if(bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		if(bean.getOrderInfoId() != null) {
			dao.setConditionOrderInfoId("=", bean.getOrderInfoId());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getIsHistory() != null) {
			dao.setConditionIsHistory("=", bean.getIsHistory());
			count++;
		}
		if(bean.getBusinessStateRecordId() != null) {
			dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
			count++;
		}
		if(bean.getReserveSheetId() != null) {
			dao.setConditionReserveSheetId("=", bean.getReserveSheetId());
			count++;
		}
		if(bean.getBusinessLine() != null) {
			if(bean.getBusinessLine().indexOf("%") >= 0)
				dao.setConditionBusinessLine("like", bean.getBusinessLine());
			else
				dao.setConditionBusinessLine("=", bean.getBusinessLine());
			count++;
		}
		if(bean.getIsAuto() != null) {
			dao.setConditionIsAuto("=", bean.getIsAuto());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getAgreeDate() != null) {
			dao.setConditionAgreeDate(">=", bean.getAgreeDate());
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
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		bean.setDataFromJSON(json);
		OrderInfoChild dao = new OrderInfoChild();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOrderInfoChild> rlist = new BaseCollection<>();
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OrderInfoChild dao = new OrderInfoChild();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOrderInfoChild> result = dao.conditionalLoad(addtion);
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
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		bean.setDataFromJSON(json);
		OrderInfoChild dao = new OrderInfoChild();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		bean.setDataFromJSON(json);
		OrderInfoChild dao = new OrderInfoChild();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		bean.setDataFromJSON(json);
		OrderInfoChild dao = new OrderInfoChild();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOrderInfoChild bean = new BaseOrderInfoChild();
		bean.setDataFromJSON(json);
		OrderInfoChild dao = new OrderInfoChild();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


