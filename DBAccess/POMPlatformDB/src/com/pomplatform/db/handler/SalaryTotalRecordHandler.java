package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryTotalRecord;
import com.pomplatform.db.dao.SalaryTotalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryTotalRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryTotalRecordHandler.class);

	public static BaseSalaryTotalRecord getSalaryTotalRecordById( 
		java.lang.Integer salary_total_record_id
	) throws Exception
	{
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setSalaryTotalRecordId(salary_total_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryTotalRecordExists( com.pomplatform.db.bean.BaseSalaryTotalRecord bean, String additional ) throws Exception {

		SalaryTotalRecord dao = new SalaryTotalRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryTotalRecord( com.pomplatform.db.bean.BaseSalaryTotalRecord bean, String additional ) throws Exception {

		SalaryTotalRecord dao = new SalaryTotalRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryTotalRecord> querySalaryTotalRecord( com.pomplatform.db.bean.BaseSalaryTotalRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryTotalRecord dao = new SalaryTotalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryTotalRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryTotalRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryTotalRecord addToSalaryTotalRecord ( BaseSalaryTotalRecord salarytotalrecord )  throws Exception {
		return addToSalaryTotalRecord ( salarytotalrecord , false);
	}

	public static BaseSalaryTotalRecord addToSalaryTotalRecord ( BaseSalaryTotalRecord salarytotalrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setDataFromBase(salarytotalrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryTotalRecord addUpdateSalaryTotalRecord ( BaseSalaryTotalRecord salarytotalrecord ) throws Exception {
		return addUpdateSalaryTotalRecord ( salarytotalrecord , false);
	}

	public static BaseSalaryTotalRecord addUpdateSalaryTotalRecord ( BaseSalaryTotalRecord salarytotalrecord, boolean singleTransaction  ) throws Exception {
		if(salarytotalrecord.getSalaryTotalRecordId() == null) return addToSalaryTotalRecord(salarytotalrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setDataFromBase(salarytotalrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salarytotalrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryTotalRecord ( BaseSalaryTotalRecord bean ) throws Exception {
		SalaryTotalRecord dao = new SalaryTotalRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryTotalRecord updateSalaryTotalRecord ( BaseSalaryTotalRecord salarytotalrecord ) throws Exception {
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setSalaryTotalRecordId( salarytotalrecord.getSalaryTotalRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salarytotalrecord);
			result = dao.update();
		}
		return result == 1 ? salarytotalrecord : null ;
	}

	public static BaseSalaryTotalRecord updateSalaryTotalRecordDirect( BaseSalaryTotalRecord salarytotalrecord ) throws Exception {
		SalaryTotalRecord dao = new SalaryTotalRecord();
		int result = 0;
		dao.setDataFromBase(salarytotalrecord);
		result = dao.update();
		return result == 1 ? salarytotalrecord : null ;
	}

	public static int setDeleteConditions(BaseSalaryTotalRecord bean, SalaryTotalRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryTotalRecordId() != null) {
			dao.setConditionSalaryTotalRecordId("=", bean.getSalaryTotalRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
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
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getNum() != null) {
				dao.setConditionNum("=", bean.getNum());
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

	public static int setConditions(BaseSalaryTotalRecord bean, SalaryTotalRecord dao){
		int count = 0;
		if(bean.getSalaryTotalRecordId() != null) {
			dao.setConditionSalaryTotalRecordId("=", bean.getSalaryTotalRecordId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
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
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getShouldSalary() != null) {
			dao.setConditionShouldSalary("=", bean.getShouldSalary());
			count++;
		}
		if(bean.getLeaveAdvance() != null) {
			dao.setConditionLeaveAdvance("=", bean.getLeaveAdvance());
			count++;
		}
		if(bean.getShouldBonus() != null) {
			dao.setConditionShouldBonus("=", bean.getShouldBonus());
			count++;
		}
		if(bean.getShouldTotal() != null) {
			dao.setConditionShouldTotal("=", bean.getShouldTotal());
			count++;
		}
		if(bean.getShouldTax() != null) {
			dao.setConditionShouldTax("=", bean.getShouldTax());
			count++;
		}
		if(bean.getTotalInsurance() != null) {
			dao.setConditionTotalInsurance("=", bean.getTotalInsurance());
			count++;
		}
		if(bean.getPersonalPension() != null) {
			dao.setConditionPersonalPension("=", bean.getPersonalPension());
			count++;
		}
		if(bean.getPersonalMedicalInsurance() != null) {
			dao.setConditionPersonalMedicalInsurance("=", bean.getPersonalMedicalInsurance());
			count++;
		}
		if(bean.getPersonalUnemploymentInsurance() != null) {
			dao.setConditionPersonalUnemploymentInsurance("=", bean.getPersonalUnemploymentInsurance());
			count++;
		}
		if(bean.getPersonalLargeMedicalInsurance() != null) {
			dao.setConditionPersonalLargeMedicalInsurance("=", bean.getPersonalLargeMedicalInsurance());
			count++;
		}
		if(bean.getPersonalHeating() != null) {
			dao.setConditionPersonalHeating("=", bean.getPersonalHeating());
			count++;
		}
		if(bean.getTotalFund() != null) {
			dao.setConditionTotalFund("=", bean.getTotalFund());
			count++;
		}
		if(bean.getInsteadDeduct() != null) {
			dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
			count++;
		}
		if(bean.getInsteadDeductIll() != null) {
			dao.setConditionInsteadDeductIll("=", bean.getInsteadDeductIll());
			count++;
		}
		if(bean.getFactSalary() != null) {
			dao.setConditionFactSalary("=", bean.getFactSalary());
			count++;
		}
		if(bean.getNum() != null) {
			dao.setConditionNum("=", bean.getNum());
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
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		bean.setDataFromJSON(json);
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryTotalRecord> rlist = new BaseCollection<>();
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryTotalRecord dao = new SalaryTotalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryTotalRecord> result = dao.conditionalLoad(addtion);
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
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		bean.setDataFromJSON(json);
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		bean.setDataFromJSON(json);
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		bean.setDataFromJSON(json);
		SalaryTotalRecord dao = new SalaryTotalRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryTotalRecord bean = new BaseSalaryTotalRecord();
		bean.setDataFromJSON(json);
		SalaryTotalRecord dao = new SalaryTotalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


