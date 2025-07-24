package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryInsteadDeduct;
import com.pomplatform.db.dao.SalaryInsteadDeduct;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryInsteadDeductHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryInsteadDeductHandler.class);

	public static BaseSalaryInsteadDeduct getSalaryInsteadDeductById( 
		java.lang.Integer salary_instead_deduct_id
	) throws Exception
	{
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setSalaryInsteadDeductId(salary_instead_deduct_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryInsteadDeductExists( com.pomplatform.db.bean.BaseSalaryInsteadDeduct bean, String additional ) throws Exception {

		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryInsteadDeduct( com.pomplatform.db.bean.BaseSalaryInsteadDeduct bean, String additional ) throws Exception {

		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryInsteadDeduct> querySalaryInsteadDeduct( com.pomplatform.db.bean.BaseSalaryInsteadDeduct bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryInsteadDeduct> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryInsteadDeduct> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryInsteadDeduct addToSalaryInsteadDeduct ( BaseSalaryInsteadDeduct salaryinsteaddeduct )  throws Exception {
		return addToSalaryInsteadDeduct ( salaryinsteaddeduct , false);
	}

	public static BaseSalaryInsteadDeduct addToSalaryInsteadDeduct ( BaseSalaryInsteadDeduct salaryinsteaddeduct, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setDataFromBase(salaryinsteaddeduct);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryInsteadDeduct addUpdateSalaryInsteadDeduct ( BaseSalaryInsteadDeduct salaryinsteaddeduct ) throws Exception {
		return addUpdateSalaryInsteadDeduct ( salaryinsteaddeduct , false);
	}

	public static BaseSalaryInsteadDeduct addUpdateSalaryInsteadDeduct ( BaseSalaryInsteadDeduct salaryinsteaddeduct, boolean singleTransaction  ) throws Exception {
		if(salaryinsteaddeduct.getSalaryInsteadDeductId() == null) return addToSalaryInsteadDeduct(salaryinsteaddeduct);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setDataFromBase(salaryinsteaddeduct);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryinsteaddeduct); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryInsteadDeduct ( BaseSalaryInsteadDeduct bean ) throws Exception {
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryInsteadDeduct updateSalaryInsteadDeduct ( BaseSalaryInsteadDeduct salaryinsteaddeduct ) throws Exception {
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setSalaryInsteadDeductId( salaryinsteaddeduct.getSalaryInsteadDeductId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryinsteaddeduct);
			result = dao.update();
		}
		return result == 1 ? salaryinsteaddeduct : null ;
	}

	public static BaseSalaryInsteadDeduct updateSalaryInsteadDeductDirect( BaseSalaryInsteadDeduct salaryinsteaddeduct ) throws Exception {
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		int result = 0;
		dao.setDataFromBase(salaryinsteaddeduct);
		result = dao.update();
		return result == 1 ? salaryinsteaddeduct : null ;
	}

	public static int setDeleteConditions(BaseSalaryInsteadDeduct bean, SalaryInsteadDeduct dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryInsteadDeductId() != null) {
			dao.setConditionSalaryInsteadDeductId("=", bean.getSalaryInsteadDeductId());
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
			if(bean.getInsteadDeduct() != null) {
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
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

	public static int setConditions(BaseSalaryInsteadDeduct bean, SalaryInsteadDeduct dao){
		int count = 0;
		if(bean.getSalaryInsteadDeductId() != null) {
			dao.setConditionSalaryInsteadDeductId("=", bean.getSalaryInsteadDeductId());
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
		if(bean.getInsteadDeduct() != null) {
			if(bean.getInsteadDeduct().indexOf("%") >= 0)
				dao.setConditionInsteadDeduct("like", bean.getInsteadDeduct());
			else
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
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
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		bean.setDataFromJSON(json);
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryInsteadDeduct> rlist = new BaseCollection<>();
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryInsteadDeduct> result = dao.conditionalLoad(addtion);
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
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		bean.setDataFromJSON(json);
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		bean.setDataFromJSON(json);
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		bean.setDataFromJSON(json);
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryInsteadDeduct bean = new BaseSalaryInsteadDeduct();
		bean.setDataFromJSON(json);
		SalaryInsteadDeduct dao = new SalaryInsteadDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


