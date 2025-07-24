package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOtherDeduction;
import com.pomplatform.db.dao.OtherDeduction;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OtherDeductionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OtherDeductionHandler.class);

	public static BaseOtherDeduction getOtherDeductionById( 
		java.lang.Integer other_deduction_id
	) throws Exception
	{
		OtherDeduction dao = new OtherDeduction();
		dao.setOtherDeductionId(other_deduction_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOtherDeductionExists( com.pomplatform.db.bean.BaseOtherDeduction bean, String additional ) throws Exception {

		OtherDeduction dao = new OtherDeduction();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOtherDeduction( com.pomplatform.db.bean.BaseOtherDeduction bean, String additional ) throws Exception {

		OtherDeduction dao = new OtherDeduction();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOtherDeduction> queryOtherDeduction( com.pomplatform.db.bean.BaseOtherDeduction bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OtherDeduction dao = new OtherDeduction();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOtherDeduction> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOtherDeduction> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOtherDeduction addToOtherDeduction ( BaseOtherDeduction otherdeduction )  throws Exception {
		return addToOtherDeduction ( otherdeduction , false);
	}

	public static BaseOtherDeduction addToOtherDeduction ( BaseOtherDeduction otherdeduction, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OtherDeduction dao = new OtherDeduction();
		dao.setDataFromBase(otherdeduction);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOtherDeduction addUpdateOtherDeduction ( BaseOtherDeduction otherdeduction ) throws Exception {
		return addUpdateOtherDeduction ( otherdeduction , false);
	}

	public static BaseOtherDeduction addUpdateOtherDeduction ( BaseOtherDeduction otherdeduction, boolean singleTransaction  ) throws Exception {
		if(otherdeduction.getOtherDeductionId() == null) return addToOtherDeduction(otherdeduction);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OtherDeduction dao = new OtherDeduction();
		dao.setDataFromBase(otherdeduction);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(otherdeduction); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOtherDeduction ( BaseOtherDeduction bean ) throws Exception {
		OtherDeduction dao = new OtherDeduction();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOtherDeduction updateOtherDeduction ( BaseOtherDeduction otherdeduction ) throws Exception {
		OtherDeduction dao = new OtherDeduction();
		dao.setOtherDeductionId( otherdeduction.getOtherDeductionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(otherdeduction);
			result = dao.update();
		}
		return result == 1 ? otherdeduction : null ;
	}

	public static BaseOtherDeduction updateOtherDeductionDirect( BaseOtherDeduction otherdeduction ) throws Exception {
		OtherDeduction dao = new OtherDeduction();
		int result = 0;
		dao.setDataFromBase(otherdeduction);
		result = dao.update();
		return result == 1 ? otherdeduction : null ;
	}

	public static int setDeleteConditions(BaseOtherDeduction bean, OtherDeduction dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOtherDeductionId() != null) {
			dao.setConditionOtherDeductionId("=", bean.getOtherDeductionId());
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
			if(bean.getOtherDeduction() != null) {
				dao.setConditionOtherDeduction("=", bean.getOtherDeduction());
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

	public static int setConditions(BaseOtherDeduction bean, OtherDeduction dao){
		int count = 0;
		if(bean.getOtherDeductionId() != null) {
			dao.setConditionOtherDeductionId("=", bean.getOtherDeductionId());
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
		if(bean.getOtherDeduction() != null) {
			if(bean.getOtherDeduction().indexOf("%") >= 0)
				dao.setConditionOtherDeduction("like", bean.getOtherDeduction());
			else
				dao.setConditionOtherDeduction("=", bean.getOtherDeduction());
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
		BaseOtherDeduction bean = new BaseOtherDeduction();
		bean.setDataFromJSON(json);
		OtherDeduction dao = new OtherDeduction();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOtherDeduction> rlist = new BaseCollection<>();
		BaseOtherDeduction bean = new BaseOtherDeduction();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OtherDeduction dao = new OtherDeduction();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOtherDeduction> result = dao.conditionalLoad(addtion);
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
		BaseOtherDeduction bean = new BaseOtherDeduction();
		bean.setDataFromJSON(json);
		OtherDeduction dao = new OtherDeduction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOtherDeduction bean = new BaseOtherDeduction();
		bean.setDataFromJSON(json);
		OtherDeduction dao = new OtherDeduction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOtherDeduction bean = new BaseOtherDeduction();
		bean.setDataFromJSON(json);
		OtherDeduction dao = new OtherDeduction();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOtherDeduction bean = new BaseOtherDeduction();
		bean.setDataFromJSON(json);
		OtherDeduction dao = new OtherDeduction();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


