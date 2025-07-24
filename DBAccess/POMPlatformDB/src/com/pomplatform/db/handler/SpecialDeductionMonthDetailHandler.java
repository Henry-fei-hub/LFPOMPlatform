package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail;
import java.util.List;
import com.pomplatform.db.dao.SpecialDeductionMonthDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class SpecialDeductionMonthDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionMonthDetailHandler.class);

	public static BaseSpecialDeductionMonthDetail getSpecialDeductionMonthDetailById( 
		java.lang.Integer special_deduction_month_detail_id
	) throws Exception
	{
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setSpecialDeductionMonthDetailId(special_deduction_month_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSpecialDeductionMonthDetailExists( com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail bean, String additional ) throws Exception {

		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSpecialDeductionMonthDetail( com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail bean, String additional ) throws Exception {

		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSpecialDeductionMonthDetail> querySpecialDeductionMonthDetail( com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSpecialDeductionMonthDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSpecialDeductionMonthDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSpecialDeductionMonthDetail addToSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail )  throws Exception {
		return addToSpecialDeductionMonthDetail ( specialdeductionmonthdetail , false);
	}

	public static BaseSpecialDeductionMonthDetail addToSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setDataFromBase(specialdeductionmonthdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSpecialDeductionMonthDetail addUpdateSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail ) throws Exception {
		return addUpdateSpecialDeductionMonthDetail ( specialdeductionmonthdetail , false);
	}

	public static BaseSpecialDeductionMonthDetail addUpdateSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail, boolean singleTransaction  ) throws Exception {
		if(specialdeductionmonthdetail.getSpecialDeductionMonthDetailId() == null) return addToSpecialDeductionMonthDetail(specialdeductionmonthdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setDataFromBase(specialdeductionmonthdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(specialdeductionmonthdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail bean ) throws Exception {
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSpecialDeductionMonthDetail updateSpecialDeductionMonthDetail ( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail ) throws Exception {
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setSpecialDeductionMonthDetailId( specialdeductionmonthdetail.getSpecialDeductionMonthDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(specialdeductionmonthdetail);
			result = dao.update();
		}
		return result == 1 ? specialdeductionmonthdetail : null ;
	}

	public static BaseSpecialDeductionMonthDetail updateSpecialDeductionMonthDetailDirect( BaseSpecialDeductionMonthDetail specialdeductionmonthdetail ) throws Exception {
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		int result = 0;
		dao.setDataFromBase(specialdeductionmonthdetail);
		result = dao.update();
		return result == 1 ? specialdeductionmonthdetail : null ;
	}

	public static int setDeleteConditions(BaseSpecialDeductionMonthDetail bean, SpecialDeductionMonthDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSpecialDeductionMonthDetailId() != null) {
			dao.setConditionSpecialDeductionMonthDetailId("=", bean.getSpecialDeductionMonthDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
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
			if(bean.getSpecialDeductionTypeIds() != null) {
				dao.setConditionSpecialDeductionTypeIds("=", bean.getSpecialDeductionTypeIds());
				count++;
			}
			if(bean.getSpecialDeductionDetailIds() != null) {
				dao.setConditionSpecialDeductionDetailIds("=", bean.getSpecialDeductionDetailIds());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSpecialDeductionMonthDetail bean, SpecialDeductionMonthDetail dao){
		int count = 0;
		if(bean.getSpecialDeductionMonthDetailId() != null) {
			dao.setConditionSpecialDeductionMonthDetailId("=", bean.getSpecialDeductionMonthDetailId());
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
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getYear() != null) {
			if(bean.getYear().indexOf("%") >= 0)
				dao.setConditionYear("like", bean.getYear());
			else
				dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			if(bean.getMonth().indexOf("%") >= 0)
				dao.setConditionMonth("like", bean.getMonth());
			else
				dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getSpecialDeductionTypeIds() != null) {
			if(bean.getSpecialDeductionTypeIds().indexOf("%") >= 0)
				dao.setConditionSpecialDeductionTypeIds("like", bean.getSpecialDeductionTypeIds());
			else
				dao.setConditionSpecialDeductionTypeIds("=", bean.getSpecialDeductionTypeIds());
			count++;
		}
		if(bean.getSpecialDeductionDetailIds() != null) {
			if(bean.getSpecialDeductionDetailIds().indexOf("%") >= 0)
				dao.setConditionSpecialDeductionDetailIds("like", bean.getSpecialDeductionDetailIds());
			else
				dao.setConditionSpecialDeductionDetailIds("=", bean.getSpecialDeductionDetailIds());
			count++;
		}
		if(bean.getSpecialDuduct1() != null) {
			dao.setConditionSpecialDuduct1("=", bean.getSpecialDuduct1());
			count++;
		}
		if(bean.getSpecialDuduct2() != null) {
			dao.setConditionSpecialDuduct2("=", bean.getSpecialDuduct2());
			count++;
		}
		if(bean.getSpecialDuduct3() != null) {
			dao.setConditionSpecialDuduct3("=", bean.getSpecialDuduct3());
			count++;
		}
		if(bean.getSpecialDuduct4() != null) {
			dao.setConditionSpecialDuduct4("=", bean.getSpecialDuduct4());
			count++;
		}
		if(bean.getSpecialDuduct5() != null) {
			dao.setConditionSpecialDuduct5("=", bean.getSpecialDuduct5());
			count++;
		}
		if(bean.getSpecialDuduct6() != null) {
			dao.setConditionSpecialDuduct6("=", bean.getSpecialDuduct6());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSpecialDeductionMonthDetail> rlist = new BaseCollection<>();
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSpecialDeductionMonthDetail> result = dao.conditionalLoad(addtion);
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
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSpecialDeductionMonthDetail bean = new BaseSpecialDeductionMonthDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionMonthDetail dao = new SpecialDeductionMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


