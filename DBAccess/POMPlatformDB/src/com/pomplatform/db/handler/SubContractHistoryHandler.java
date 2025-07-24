package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubContractHistory;
import com.pomplatform.db.dao.SubContractHistory;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SubContractHistoryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubContractHistoryHandler.class);

	public static BaseSubContractHistory getSubContractHistoryById( 
		java.lang.Integer sub_contract_history_id
	) throws Exception
	{
		SubContractHistory dao = new SubContractHistory();
		dao.setSubContractHistoryId(sub_contract_history_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubContractHistoryExists( com.pomplatform.db.bean.BaseSubContractHistory bean, String additional ) throws Exception {

		SubContractHistory dao = new SubContractHistory();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubContractHistory( com.pomplatform.db.bean.BaseSubContractHistory bean, String additional ) throws Exception {

		SubContractHistory dao = new SubContractHistory();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubContractHistory> querySubContractHistory( com.pomplatform.db.bean.BaseSubContractHistory bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubContractHistory dao = new SubContractHistory();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubContractHistory> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubContractHistory> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubContractHistory addToSubContractHistory ( BaseSubContractHistory subcontracthistory )  throws Exception {
		return addToSubContractHistory ( subcontracthistory , false);
	}

	public static BaseSubContractHistory addToSubContractHistory ( BaseSubContractHistory subcontracthistory, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubContractHistory dao = new SubContractHistory();
		dao.setDataFromBase(subcontracthistory);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubContractHistory addUpdateSubContractHistory ( BaseSubContractHistory subcontracthistory ) throws Exception {
		return addUpdateSubContractHistory ( subcontracthistory , false);
	}

	public static BaseSubContractHistory addUpdateSubContractHistory ( BaseSubContractHistory subcontracthistory, boolean singleTransaction  ) throws Exception {
		if(subcontracthistory.getSubContractHistoryId() == null) return addToSubContractHistory(subcontracthistory);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubContractHistory dao = new SubContractHistory();
		dao.setDataFromBase(subcontracthistory);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subcontracthistory); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubContractHistory ( BaseSubContractHistory bean ) throws Exception {
		SubContractHistory dao = new SubContractHistory();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubContractHistory updateSubContractHistory ( BaseSubContractHistory subcontracthistory ) throws Exception {
		SubContractHistory dao = new SubContractHistory();
		dao.setSubContractHistoryId( subcontracthistory.getSubContractHistoryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subcontracthistory);
			result = dao.update();
		}
		return result == 1 ? subcontracthistory : null ;
	}

	public static BaseSubContractHistory updateSubContractHistoryDirect( BaseSubContractHistory subcontracthistory ) throws Exception {
		SubContractHistory dao = new SubContractHistory();
		int result = 0;
		dao.setDataFromBase(subcontracthistory);
		result = dao.update();
		return result == 1 ? subcontracthistory : null ;
	}

	public static int setDeleteConditions(BaseSubContractHistory bean, SubContractHistory dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubContractHistoryId() != null) {
			dao.setConditionSubContractHistoryId("=", bean.getSubContractHistoryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
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
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubContractHistory bean, SubContractHistory dao){
		int count = 0;
		if(bean.getSubContractHistoryId() != null) {
			dao.setConditionSubContractHistoryId("=", bean.getSubContractHistoryId());
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
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubContractHistory bean = new BaseSubContractHistory();
		bean.setDataFromJSON(json);
		SubContractHistory dao = new SubContractHistory();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubContractHistory> rlist = new BaseCollection<>();
		BaseSubContractHistory bean = new BaseSubContractHistory();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubContractHistory dao = new SubContractHistory();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubContractHistory> result = dao.conditionalLoad(addtion);
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
		BaseSubContractHistory bean = new BaseSubContractHistory();
		bean.setDataFromJSON(json);
		SubContractHistory dao = new SubContractHistory();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubContractHistory bean = new BaseSubContractHistory();
		bean.setDataFromJSON(json);
		SubContractHistory dao = new SubContractHistory();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubContractHistory bean = new BaseSubContractHistory();
		bean.setDataFromJSON(json);
		SubContractHistory dao = new SubContractHistory();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubContractHistory bean = new BaseSubContractHistory();
		bean.setDataFromJSON(json);
		SubContractHistory dao = new SubContractHistory();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


