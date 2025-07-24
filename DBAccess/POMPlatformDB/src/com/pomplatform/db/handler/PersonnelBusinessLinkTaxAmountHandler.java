package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonnelBusinessLinkTaxAmount;
import com.pomplatform.db.dao.PersonnelBusinessLinkTaxAmount;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PersonnelBusinessLinkTaxAmountHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinessLinkTaxAmountHandler.class);

	public static BasePersonnelBusinessLinkTaxAmount getPersonnelBusinessLinkTaxAmountById( 
		java.lang.Integer personnel_business_link_tax_amount_id
	) throws Exception
	{
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setPersonnelBusinessLinkTaxAmountId(personnel_business_link_tax_amount_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPersonnelBusinessLinkTaxAmountExists( com.pomplatform.db.bean.BasePersonnelBusinessLinkTaxAmount bean, String additional ) throws Exception {

		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPersonnelBusinessLinkTaxAmount( com.pomplatform.db.bean.BasePersonnelBusinessLinkTaxAmount bean, String additional ) throws Exception {

		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePersonnelBusinessLinkTaxAmount> queryPersonnelBusinessLinkTaxAmount( com.pomplatform.db.bean.BasePersonnelBusinessLinkTaxAmount bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePersonnelBusinessLinkTaxAmount> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePersonnelBusinessLinkTaxAmount> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePersonnelBusinessLinkTaxAmount addToPersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount )  throws Exception {
		return addToPersonnelBusinessLinkTaxAmount ( personnelbusinesslinktaxamount , false);
	}

	public static BasePersonnelBusinessLinkTaxAmount addToPersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setDataFromBase(personnelbusinesslinktaxamount);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePersonnelBusinessLinkTaxAmount addUpdatePersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount ) throws Exception {
		return addUpdatePersonnelBusinessLinkTaxAmount ( personnelbusinesslinktaxamount , false);
	}

	public static BasePersonnelBusinessLinkTaxAmount addUpdatePersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount, boolean singleTransaction  ) throws Exception {
		if(personnelbusinesslinktaxamount.getPersonnelBusinessLinkTaxAmountId() == null) return addToPersonnelBusinessLinkTaxAmount(personnelbusinesslinktaxamount);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setDataFromBase(personnelbusinesslinktaxamount);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(personnelbusinesslinktaxamount); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount bean ) throws Exception {
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePersonnelBusinessLinkTaxAmount updatePersonnelBusinessLinkTaxAmount ( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount ) throws Exception {
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setPersonnelBusinessLinkTaxAmountId( personnelbusinesslinktaxamount.getPersonnelBusinessLinkTaxAmountId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(personnelbusinesslinktaxamount);
			result = dao.update();
		}
		return result == 1 ? personnelbusinesslinktaxamount : null ;
	}

	public static BasePersonnelBusinessLinkTaxAmount updatePersonnelBusinessLinkTaxAmountDirect( BasePersonnelBusinessLinkTaxAmount personnelbusinesslinktaxamount ) throws Exception {
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		int result = 0;
		dao.setDataFromBase(personnelbusinesslinktaxamount);
		result = dao.update();
		return result == 1 ? personnelbusinesslinktaxamount : null ;
	}

	public static int setDeleteConditions(BasePersonnelBusinessLinkTaxAmount bean, PersonnelBusinessLinkTaxAmount dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonnelBusinessLinkTaxAmountId() != null) {
			dao.setConditionPersonnelBusinessLinkTaxAmountId("=", bean.getPersonnelBusinessLinkTaxAmountId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePersonnelBusinessLinkTaxAmount bean, PersonnelBusinessLinkTaxAmount dao){
		int count = 0;
		if(bean.getPersonnelBusinessLinkTaxAmountId() != null) {
			dao.setConditionPersonnelBusinessLinkTaxAmountId("=", bean.getPersonnelBusinessLinkTaxAmountId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonnelBusinessLinkTaxAmount> rlist = new BaseCollection<>();
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonnelBusinessLinkTaxAmount> result = dao.conditionalLoad(addtion);
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
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonnelBusinessLinkTaxAmount bean = new BasePersonnelBusinessLinkTaxAmount();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkTaxAmount dao = new PersonnelBusinessLinkTaxAmount();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


