package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReimbursementPackage;
import com.pomplatform.db.dao.ReimbursementPackage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReimbursementPackageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementPackageHandler.class);

	public static BaseReimbursementPackage getReimbursementPackageById( 
		java.lang.Integer reimbursement_package_id
	) throws Exception
	{
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setReimbursementPackageId(reimbursement_package_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementPackageExists( com.pomplatform.db.bean.BaseReimbursementPackage bean, String additional ) throws Exception {

		ReimbursementPackage dao = new ReimbursementPackage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursementPackage( com.pomplatform.db.bean.BaseReimbursementPackage bean, String additional ) throws Exception {

		ReimbursementPackage dao = new ReimbursementPackage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursementPackage> queryReimbursementPackage( com.pomplatform.db.bean.BaseReimbursementPackage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReimbursementPackage dao = new ReimbursementPackage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursementPackage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursementPackage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursementPackage addToReimbursementPackage ( BaseReimbursementPackage reimbursementpackage )  throws Exception {
		return addToReimbursementPackage ( reimbursementpackage , false);
	}

	public static BaseReimbursementPackage addToReimbursementPackage ( BaseReimbursementPackage reimbursementpackage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setDataFromBase(reimbursementpackage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursementPackage addUpdateReimbursementPackage ( BaseReimbursementPackage reimbursementpackage ) throws Exception {
		return addUpdateReimbursementPackage ( reimbursementpackage , false);
	}

	public static BaseReimbursementPackage addUpdateReimbursementPackage ( BaseReimbursementPackage reimbursementpackage, boolean singleTransaction  ) throws Exception {
		if(reimbursementpackage.getReimbursementPackageId() == null) return addToReimbursementPackage(reimbursementpackage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setDataFromBase(reimbursementpackage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursementpackage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursementPackage ( BaseReimbursementPackage bean ) throws Exception {
		ReimbursementPackage dao = new ReimbursementPackage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursementPackage updateReimbursementPackage ( BaseReimbursementPackage reimbursementpackage ) throws Exception {
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setReimbursementPackageId( reimbursementpackage.getReimbursementPackageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursementpackage);
			result = dao.update();
		}
		return result == 1 ? reimbursementpackage : null ;
	}

	public static BaseReimbursementPackage updateReimbursementPackageDirect( BaseReimbursementPackage reimbursementpackage ) throws Exception {
		ReimbursementPackage dao = new ReimbursementPackage();
		int result = 0;
		dao.setDataFromBase(reimbursementpackage);
		result = dao.update();
		return result == 1 ? reimbursementpackage : null ;
	}

	public static int setDeleteConditions(BaseReimbursementPackage bean, ReimbursementPackage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getRoleId() != null) {
				dao.setConditionRoleId("=", bean.getRoleId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getPackageSize() != null) {
				dao.setConditionPackageSize("=", bean.getPackageSize());
				count++;
			}
			if(bean.getIsOnlinePay() != null) {
				dao.setConditionIsOnlinePay("=", bean.getIsOnlinePay());
				count++;
			}
			if(bean.getPayStatus() != null) {
				dao.setConditionPayStatus("=", bean.getPayStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursementPackage bean, ReimbursementPackage dao){
		int count = 0;
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getPaymentAmount() != null) {
			dao.setConditionPaymentAmount("=", bean.getPaymentAmount());
			count++;
		}
		if(bean.getStrikeABalanceAmount() != null) {
			dao.setConditionStrikeABalanceAmount("=", bean.getStrikeABalanceAmount());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRoleId() != null) {
			dao.setConditionRoleId("=", bean.getRoleId());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
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
		if(bean.getPackageSize() != null) {
			dao.setConditionPackageSize("=", bean.getPackageSize());
			count++;
		}
		if(bean.getIsOnlinePay() != null) {
			dao.setConditionIsOnlinePay("=", bean.getIsOnlinePay());
			count++;
		}
		if(bean.getPayStatus() != null) {
			dao.setConditionPayStatus("=", bean.getPayStatus());
			count++;
		}
		if(bean.getMakeBillTime() != null) {
			dao.setConditionMakeBillTime(">=", bean.getMakeBillTime());
			count++;
		}
		if(bean.getPayTime() != null) {
			dao.setConditionPayTime(">=", bean.getPayTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		bean.setDataFromJSON(json);
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementPackage> rlist = new BaseCollection<>();
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementPackage dao = new ReimbursementPackage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementPackage> result = dao.conditionalLoad(addtion);
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
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		bean.setDataFromJSON(json);
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		bean.setDataFromJSON(json);
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		bean.setDataFromJSON(json);
		ReimbursementPackage dao = new ReimbursementPackage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementPackage bean = new BaseReimbursementPackage();
		bean.setDataFromJSON(json);
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


