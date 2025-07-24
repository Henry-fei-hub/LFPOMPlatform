package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseSubContract;
import java.util.List;
import com.pomplatform.db.dao.SubContract;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class SubContractHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubContractHandler.class);

	public static BaseSubContract getSubContractById( 
		java.lang.Integer sub_contract_id
	) throws Exception
	{
		SubContract dao = new SubContract();
		dao.setSubContractId(sub_contract_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubContractExists( com.pomplatform.db.bean.BaseSubContract bean, String additional ) throws Exception {

		SubContract dao = new SubContract();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubContract( com.pomplatform.db.bean.BaseSubContract bean, String additional ) throws Exception {

		SubContract dao = new SubContract();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubContract> querySubContract( com.pomplatform.db.bean.BaseSubContract bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubContract dao = new SubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubContract> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubContract> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubContract addToSubContract ( BaseSubContract subcontract )  throws Exception {
		return addToSubContract ( subcontract , false);
	}

	public static BaseSubContract addToSubContract ( BaseSubContract subcontract, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubContract dao = new SubContract();
		dao.setDataFromBase(subcontract);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubContract addUpdateSubContract ( BaseSubContract subcontract ) throws Exception {
		return addUpdateSubContract ( subcontract , false);
	}

	public static BaseSubContract addUpdateSubContract ( BaseSubContract subcontract, boolean singleTransaction  ) throws Exception {
		if(subcontract.getSubContractId() == null) return addToSubContract(subcontract);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubContract dao = new SubContract();
		dao.setDataFromBase(subcontract);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subcontract); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubContract ( BaseSubContract bean ) throws Exception {
		SubContract dao = new SubContract();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubContract updateSubContract ( BaseSubContract subcontract ) throws Exception {
		SubContract dao = new SubContract();
		dao.setSubContractId( subcontract.getSubContractId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subcontract);
			result = dao.update();
		}
		return result == 1 ? subcontract : null ;
	}

	public static BaseSubContract updateSubContractDirect( BaseSubContract subcontract ) throws Exception {
		SubContract dao = new SubContract();
		int result = 0;
		dao.setDataFromBase(subcontract);
		result = dao.update();
		return result == 1 ? subcontract : null ;
	}

	public static int setDeleteConditions(BaseSubContract bean, SubContract dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubContractId() != null) {
			dao.setConditionSubContractId("=", bean.getSubContractId());
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
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getBusinessStateRecordId() != null) {
				dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
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
			if(bean.getIsAuto() != null) {
				dao.setConditionIsAuto("=", bean.getIsAuto());
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
		}
		return count;
	}

	public static int setConditions(BaseSubContract bean, SubContract dao){
		int count = 0;
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
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getSheetTotalIntegral() != null) {
			dao.setConditionSheetTotalIntegral("=", bean.getSheetTotalIntegral());
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
		if(bean.getComplaintPercentage() != null) {
			dao.setConditionComplaintPercentage("=", bean.getComplaintPercentage());
			count++;
		}
		if(bean.getAgreeDate() != null) {
			dao.setConditionAgreeDate(">=", bean.getAgreeDate());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getBusinessStateRecordId() != null) {
			dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getIsAuto() != null) {
			dao.setConditionIsAuto("=", bean.getIsAuto());
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
		if(bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubContract bean = new BaseSubContract();
		bean.setDataFromJSON(json);
		SubContract dao = new SubContract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubContract> rlist = new BaseCollection<>();
		BaseSubContract bean = new BaseSubContract();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubContract dao = new SubContract();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubContract> result = dao.conditionalLoad(addtion);
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
		BaseSubContract bean = new BaseSubContract();
		bean.setDataFromJSON(json);
		SubContract dao = new SubContract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubContract bean = new BaseSubContract();
		bean.setDataFromJSON(json);
		SubContract dao = new SubContract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubContract bean = new BaseSubContract();
		bean.setDataFromJSON(json);
		SubContract dao = new SubContract();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubContract bean = new BaseSubContract();
		bean.setDataFromJSON(json);
		SubContract dao = new SubContract();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


