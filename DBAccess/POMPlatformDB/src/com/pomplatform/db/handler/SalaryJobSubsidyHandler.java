package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryJobSubsidy;
import com.pomplatform.db.dao.SalaryJobSubsidy;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryJobSubsidyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryJobSubsidyHandler.class);

	public static BaseSalaryJobSubsidy getSalaryJobSubsidyById( 
		java.lang.Integer salary_job_subsidy_id
	) throws Exception
	{
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setSalaryJobSubsidyId(salary_job_subsidy_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryJobSubsidyExists( com.pomplatform.db.bean.BaseSalaryJobSubsidy bean, String additional ) throws Exception {

		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryJobSubsidy( com.pomplatform.db.bean.BaseSalaryJobSubsidy bean, String additional ) throws Exception {

		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryJobSubsidy> querySalaryJobSubsidy( com.pomplatform.db.bean.BaseSalaryJobSubsidy bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryJobSubsidy> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryJobSubsidy> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryJobSubsidy addToSalaryJobSubsidy ( BaseSalaryJobSubsidy salaryjobsubsidy )  throws Exception {
		return addToSalaryJobSubsidy ( salaryjobsubsidy , false);
	}

	public static BaseSalaryJobSubsidy addToSalaryJobSubsidy ( BaseSalaryJobSubsidy salaryjobsubsidy, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setDataFromBase(salaryjobsubsidy);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryJobSubsidy addUpdateSalaryJobSubsidy ( BaseSalaryJobSubsidy salaryjobsubsidy ) throws Exception {
		return addUpdateSalaryJobSubsidy ( salaryjobsubsidy , false);
	}

	public static BaseSalaryJobSubsidy addUpdateSalaryJobSubsidy ( BaseSalaryJobSubsidy salaryjobsubsidy, boolean singleTransaction  ) throws Exception {
		if(salaryjobsubsidy.getSalaryJobSubsidyId() == null) return addToSalaryJobSubsidy(salaryjobsubsidy);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setDataFromBase(salaryjobsubsidy);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryjobsubsidy); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryJobSubsidy ( BaseSalaryJobSubsidy bean ) throws Exception {
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryJobSubsidy updateSalaryJobSubsidy ( BaseSalaryJobSubsidy salaryjobsubsidy ) throws Exception {
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setSalaryJobSubsidyId( salaryjobsubsidy.getSalaryJobSubsidyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryjobsubsidy);
			result = dao.update();
		}
		return result == 1 ? salaryjobsubsidy : null ;
	}

	public static BaseSalaryJobSubsidy updateSalaryJobSubsidyDirect( BaseSalaryJobSubsidy salaryjobsubsidy ) throws Exception {
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		int result = 0;
		dao.setDataFromBase(salaryjobsubsidy);
		result = dao.update();
		return result == 1 ? salaryjobsubsidy : null ;
	}

	public static int setDeleteConditions(BaseSalaryJobSubsidy bean, SalaryJobSubsidy dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryJobSubsidyId() != null) {
			dao.setConditionSalaryJobSubsidyId("=", bean.getSalaryJobSubsidyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
			if(bean.getMileageSubsidy() != null) {
				dao.setConditionMileageSubsidy("=", bean.getMileageSubsidy());
				count++;
			}
			if(bean.getAttentionSubsidy() != null) {
				dao.setConditionAttentionSubsidy("=", bean.getAttentionSubsidy());
				count++;
			}
			if(bean.getSalarySubsidy() != null) {
				dao.setConditionSalarySubsidy("=", bean.getSalarySubsidy());
				count++;
			}
			if(bean.getLeaveSubsidy() != null) {
				dao.setConditionLeaveSubsidy("=", bean.getLeaveSubsidy());
				count++;
			}
			if(bean.getPerformanceSubsidy() != null) {
				dao.setConditionPerformanceSubsidy("=", bean.getPerformanceSubsidy());
				count++;
			}
			if(bean.getWorkSiteSubsidy() != null) {
				dao.setConditionWorkSiteSubsidy("=", bean.getWorkSiteSubsidy());
				count++;
			}
			if(bean.getPositiveAccount() != null) {
				dao.setConditionPositiveAccount("=", bean.getPositiveAccount());
				count++;
			}
			if(bean.getTotalAmount() != null) {
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
				count++;
			}
			if(bean.getIsSended() != null) {
				dao.setConditionIsSended("=", bean.getIsSended());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryJobSubsidy bean, SalaryJobSubsidy dao){
		int count = 0;
		if(bean.getSalaryJobSubsidyId() != null) {
			dao.setConditionSalaryJobSubsidyId("=", bean.getSalaryJobSubsidyId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getMileageSubsidy() != null) {
			if(bean.getMileageSubsidy().indexOf("%") >= 0)
				dao.setConditionMileageSubsidy("like", bean.getMileageSubsidy());
			else
				dao.setConditionMileageSubsidy("=", bean.getMileageSubsidy());
			count++;
		}
		if(bean.getAttentionSubsidy() != null) {
			if(bean.getAttentionSubsidy().indexOf("%") >= 0)
				dao.setConditionAttentionSubsidy("like", bean.getAttentionSubsidy());
			else
				dao.setConditionAttentionSubsidy("=", bean.getAttentionSubsidy());
			count++;
		}
		if(bean.getSalarySubsidy() != null) {
			if(bean.getSalarySubsidy().indexOf("%") >= 0)
				dao.setConditionSalarySubsidy("like", bean.getSalarySubsidy());
			else
				dao.setConditionSalarySubsidy("=", bean.getSalarySubsidy());
			count++;
		}
		if(bean.getLeaveSubsidy() != null) {
			if(bean.getLeaveSubsidy().indexOf("%") >= 0)
				dao.setConditionLeaveSubsidy("like", bean.getLeaveSubsidy());
			else
				dao.setConditionLeaveSubsidy("=", bean.getLeaveSubsidy());
			count++;
		}
		if(bean.getPerformanceSubsidy() != null) {
			if(bean.getPerformanceSubsidy().indexOf("%") >= 0)
				dao.setConditionPerformanceSubsidy("like", bean.getPerformanceSubsidy());
			else
				dao.setConditionPerformanceSubsidy("=", bean.getPerformanceSubsidy());
			count++;
		}
		if(bean.getWorkSiteSubsidy() != null) {
			if(bean.getWorkSiteSubsidy().indexOf("%") >= 0)
				dao.setConditionWorkSiteSubsidy("like", bean.getWorkSiteSubsidy());
			else
				dao.setConditionWorkSiteSubsidy("=", bean.getWorkSiteSubsidy());
			count++;
		}
		if(bean.getPositiveAccount() != null) {
			if(bean.getPositiveAccount().indexOf("%") >= 0)
				dao.setConditionPositiveAccount("like", bean.getPositiveAccount());
			else
				dao.setConditionPositiveAccount("=", bean.getPositiveAccount());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			if(bean.getTotalAmount().indexOf("%") >= 0)
				dao.setConditionTotalAmount("like", bean.getTotalAmount());
			else
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getIsSended() != null) {
			dao.setConditionIsSended("=", bean.getIsSended());
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
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		bean.setDataFromJSON(json);
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryJobSubsidy> rlist = new BaseCollection<>();
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryJobSubsidy> result = dao.conditionalLoad(addtion);
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
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		bean.setDataFromJSON(json);
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		bean.setDataFromJSON(json);
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		bean.setDataFromJSON(json);
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryJobSubsidy bean = new BaseSalaryJobSubsidy();
		bean.setDataFromJSON(json);
		SalaryJobSubsidy dao = new SalaryJobSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


