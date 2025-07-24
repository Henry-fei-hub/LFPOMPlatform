package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail;
import com.pomplatform.db.dao.EmployeeFundIssuanceDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeFundIssuanceDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeFundIssuanceDetailHandler.class);

	public static BaseEmployeeFundIssuanceDetail getEmployeeFundIssuanceDetailById( 
		java.lang.Integer employee_fund_issuance_detail_id
	) throws Exception
	{
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setEmployeeFundIssuanceDetailId(employee_fund_issuance_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeFundIssuanceDetailExists( com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail bean, String additional ) throws Exception {

		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeFundIssuanceDetail( com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail bean, String additional ) throws Exception {

		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeFundIssuanceDetail> queryEmployeeFundIssuanceDetail( com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeFundIssuanceDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeFundIssuanceDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeFundIssuanceDetail addToEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail employeefundissuancedetail )  throws Exception {
		return addToEmployeeFundIssuanceDetail ( employeefundissuancedetail , false);
	}

	public static BaseEmployeeFundIssuanceDetail addToEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail employeefundissuancedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setDataFromBase(employeefundissuancedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeFundIssuanceDetail addUpdateEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail employeefundissuancedetail ) throws Exception {
		return addUpdateEmployeeFundIssuanceDetail ( employeefundissuancedetail , false);
	}

	public static BaseEmployeeFundIssuanceDetail addUpdateEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail employeefundissuancedetail, boolean singleTransaction  ) throws Exception {
		if(employeefundissuancedetail.getEmployeeFundIssuanceDetailId() == null) return addToEmployeeFundIssuanceDetail(employeefundissuancedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setDataFromBase(employeefundissuancedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeefundissuancedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail bean ) throws Exception {
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeFundIssuanceDetail updateEmployeeFundIssuanceDetail ( BaseEmployeeFundIssuanceDetail employeefundissuancedetail ) throws Exception {
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setEmployeeFundIssuanceDetailId( employeefundissuancedetail.getEmployeeFundIssuanceDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeefundissuancedetail);
			result = dao.update();
		}
		return result == 1 ? employeefundissuancedetail : null ;
	}

	public static BaseEmployeeFundIssuanceDetail updateEmployeeFundIssuanceDetailDirect( BaseEmployeeFundIssuanceDetail employeefundissuancedetail ) throws Exception {
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		int result = 0;
		dao.setDataFromBase(employeefundissuancedetail);
		result = dao.update();
		return result == 1 ? employeefundissuancedetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeeFundIssuanceDetail bean, EmployeeFundIssuanceDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeFundIssuanceDetailId() != null) {
			dao.setConditionEmployeeFundIssuanceDetailId("=", bean.getEmployeeFundIssuanceDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFundraisingTypeId() != null) {
				dao.setConditionFundraisingTypeId("=", bean.getFundraisingTypeId());
				count++;
			}
			if(bean.getFundType() != null) {
				dao.setConditionFundType("=", bean.getFundType());
				count++;
			}
			if(bean.getEmployeeFundIssuanceId() != null) {
				dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
			if(bean.getPersonelBusinessId() != null) {
				dao.setConditionPersonelBusinessId("=", bean.getPersonelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeFundIssuanceDetail bean, EmployeeFundIssuanceDetail dao){
		int count = 0;
		if(bean.getEmployeeFundIssuanceDetailId() != null) {
			dao.setConditionEmployeeFundIssuanceDetailId("=", bean.getEmployeeFundIssuanceDetailId());
			count++;
		}
		if(bean.getFundraisingTypeId() != null) {
			dao.setConditionFundraisingTypeId("=", bean.getFundraisingTypeId());
			count++;
		}
		if(bean.getFundType() != null) {
			dao.setConditionFundType("=", bean.getFundType());
			count++;
		}
		if(bean.getEmployeeFundIssuanceId() != null) {
			dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getIssueMoney() != null) {
			dao.setConditionIssueMoney("=", bean.getIssueMoney());
			count++;
		}
		if(bean.getRatio() != null) {
			dao.setConditionRatio("=", bean.getRatio());
			count++;
		}
		if(bean.getAmountOfCredit() != null) {
			dao.setConditionAmountOfCredit("=", bean.getAmountOfCredit());
			count++;
		}
		if(bean.getTotalMoney() != null) {
			dao.setConditionTotalMoney("=", bean.getTotalMoney());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		if(bean.getPersonelBusinessId() != null) {
			dao.setConditionPersonelBusinessId("=", bean.getPersonelBusinessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		bean.setDataFromJSON(json);
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeFundIssuanceDetail> rlist = new BaseCollection<>();
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeFundIssuanceDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		bean.setDataFromJSON(json);
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		bean.setDataFromJSON(json);
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		bean.setDataFromJSON(json);
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
		bean.setDataFromJSON(json);
		EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


