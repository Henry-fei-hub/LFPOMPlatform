package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSpecialDeductionType;
import com.pomplatform.db.dao.SpecialDeductionType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SpecialDeductionTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionTypeHandler.class);

	public static BaseSpecialDeductionType getSpecialDeductionTypeById( 
		java.lang.Integer special_deduction_type_id
	) throws Exception
	{
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setSpecialDeductionTypeId(special_deduction_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSpecialDeductionTypeExists( com.pomplatform.db.bean.BaseSpecialDeductionType bean, String additional ) throws Exception {

		SpecialDeductionType dao = new SpecialDeductionType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSpecialDeductionType( com.pomplatform.db.bean.BaseSpecialDeductionType bean, String additional ) throws Exception {

		SpecialDeductionType dao = new SpecialDeductionType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSpecialDeductionType> querySpecialDeductionType( com.pomplatform.db.bean.BaseSpecialDeductionType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SpecialDeductionType dao = new SpecialDeductionType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSpecialDeductionType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSpecialDeductionType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSpecialDeductionType addToSpecialDeductionType ( BaseSpecialDeductionType specialdeductiontype )  throws Exception {
		return addToSpecialDeductionType ( specialdeductiontype , false);
	}

	public static BaseSpecialDeductionType addToSpecialDeductionType ( BaseSpecialDeductionType specialdeductiontype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setDataFromBase(specialdeductiontype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSpecialDeductionType addUpdateSpecialDeductionType ( BaseSpecialDeductionType specialdeductiontype ) throws Exception {
		return addUpdateSpecialDeductionType ( specialdeductiontype , false);
	}

	public static BaseSpecialDeductionType addUpdateSpecialDeductionType ( BaseSpecialDeductionType specialdeductiontype, boolean singleTransaction  ) throws Exception {
		if(specialdeductiontype.getSpecialDeductionTypeId() == null) return addToSpecialDeductionType(specialdeductiontype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setDataFromBase(specialdeductiontype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(specialdeductiontype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSpecialDeductionType ( BaseSpecialDeductionType bean ) throws Exception {
		SpecialDeductionType dao = new SpecialDeductionType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSpecialDeductionType updateSpecialDeductionType ( BaseSpecialDeductionType specialdeductiontype ) throws Exception {
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setSpecialDeductionTypeId( specialdeductiontype.getSpecialDeductionTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(specialdeductiontype);
			result = dao.update();
		}
		return result == 1 ? specialdeductiontype : null ;
	}

	public static BaseSpecialDeductionType updateSpecialDeductionTypeDirect( BaseSpecialDeductionType specialdeductiontype ) throws Exception {
		SpecialDeductionType dao = new SpecialDeductionType();
		int result = 0;
		dao.setDataFromBase(specialdeductiontype);
		result = dao.update();
		return result == 1 ? specialdeductiontype : null ;
	}

	public static int setDeleteConditions(BaseSpecialDeductionType bean, SpecialDeductionType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSpecialDeductionTypeId() != null) {
			dao.setConditionSpecialDeductionTypeId("=", bean.getSpecialDeductionTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSpecialDeductionTypeName() != null) {
				dao.setConditionSpecialDeductionTypeName("=", bean.getSpecialDeductionTypeName());
				count++;
			}
			if(bean.getScopeApplication() != null) {
				dao.setConditionScopeApplication("=", bean.getScopeApplication());
				count++;
			}
			if(bean.getRangeApplication() != null) {
				dao.setConditionRangeApplication("=", bean.getRangeApplication());
				count++;
			}
			if(bean.getAmountDescription() != null) {
				dao.setConditionAmountDescription("=", bean.getAmountDescription());
				count++;
			}
			if(bean.getDateDescription() != null) {
				dao.setConditionDateDescription("=", bean.getDateDescription());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSpecialDeductionType bean, SpecialDeductionType dao){
		int count = 0;
		if(bean.getSpecialDeductionTypeId() != null) {
			dao.setConditionSpecialDeductionTypeId("=", bean.getSpecialDeductionTypeId());
			count++;
		}
		if(bean.getSpecialDeductionTypeName() != null) {
			if(bean.getSpecialDeductionTypeName().indexOf("%") >= 0)
				dao.setConditionSpecialDeductionTypeName("like", bean.getSpecialDeductionTypeName());
			else
				dao.setConditionSpecialDeductionTypeName("=", bean.getSpecialDeductionTypeName());
			count++;
		}
		if(bean.getScopeApplication() != null) {
			if(bean.getScopeApplication().indexOf("%") >= 0)
				dao.setConditionScopeApplication("like", bean.getScopeApplication());
			else
				dao.setConditionScopeApplication("=", bean.getScopeApplication());
			count++;
		}
		if(bean.getRangeApplication() != null) {
			if(bean.getRangeApplication().indexOf("%") >= 0)
				dao.setConditionRangeApplication("like", bean.getRangeApplication());
			else
				dao.setConditionRangeApplication("=", bean.getRangeApplication());
			count++;
		}
		if(bean.getAmountDescription() != null) {
			if(bean.getAmountDescription().indexOf("%") >= 0)
				dao.setConditionAmountDescription("like", bean.getAmountDescription());
			else
				dao.setConditionAmountDescription("=", bean.getAmountDescription());
			count++;
		}
		if(bean.getDateDescription() != null) {
			if(bean.getDateDescription().indexOf("%") >= 0)
				dao.setConditionDateDescription("like", bean.getDateDescription());
			else
				dao.setConditionDateDescription("=", bean.getDateDescription());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
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
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		bean.setDataFromJSON(json);
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSpecialDeductionType> rlist = new BaseCollection<>();
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SpecialDeductionType dao = new SpecialDeductionType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSpecialDeductionType> result = dao.conditionalLoad(addtion);
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
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		bean.setDataFromJSON(json);
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		bean.setDataFromJSON(json);
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		bean.setDataFromJSON(json);
		SpecialDeductionType dao = new SpecialDeductionType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSpecialDeductionType bean = new BaseSpecialDeductionType();
		bean.setDataFromJSON(json);
		SpecialDeductionType dao = new SpecialDeductionType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


