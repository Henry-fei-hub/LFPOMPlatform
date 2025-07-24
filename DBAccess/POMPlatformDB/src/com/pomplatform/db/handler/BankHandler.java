package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBank;
import com.pomplatform.db.dao.Bank;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BankHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BankHandler.class);

	public static BaseBank getBankById( 
		java.lang.Integer bank_id
	) throws Exception
	{
		Bank dao = new Bank();
		dao.setBankId(bank_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBankExists( com.pomplatform.db.bean.BaseBank bean, String additional ) throws Exception {

		Bank dao = new Bank();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBank( com.pomplatform.db.bean.BaseBank bean, String additional ) throws Exception {

		Bank dao = new Bank();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBank> queryBank( com.pomplatform.db.bean.BaseBank bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Bank dao = new Bank();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBank> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBank> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBank addToBank ( BaseBank bank )  throws Exception {
		return addToBank ( bank , false);
	}

	public static BaseBank addToBank ( BaseBank bank, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Bank dao = new Bank();
		dao.setDataFromBase(bank);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBank addUpdateBank ( BaseBank bank ) throws Exception {
		return addUpdateBank ( bank , false);
	}

	public static BaseBank addUpdateBank ( BaseBank bank, boolean singleTransaction  ) throws Exception {
		if(bank.getBankId() == null) return addToBank(bank);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Bank dao = new Bank();
		dao.setDataFromBase(bank);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(bank); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBank ( BaseBank bean ) throws Exception {
		Bank dao = new Bank();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBank updateBank ( BaseBank bank ) throws Exception {
		Bank dao = new Bank();
		dao.setBankId( bank.getBankId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(bank);
			result = dao.update();
		}
		return result == 1 ? bank : null ;
	}

	public static BaseBank updateBankDirect( BaseBank bank ) throws Exception {
		Bank dao = new Bank();
		int result = 0;
		dao.setDataFromBase(bank);
		result = dao.update();
		return result == 1 ? bank : null ;
	}

	public static int setDeleteConditions(BaseBank bean, Bank dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBankId() != null) {
			dao.setConditionBankId("=", bean.getBankId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
			if(bean.getOrderNum() != null) {
				dao.setConditionOrderNum("=", bean.getOrderNum());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBank bean, Bank dao){
		int count = 0;
		if(bean.getBankId() != null) {
			dao.setConditionBankId("=", bean.getBankId());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		if(bean.getOrderNum() != null) {
			dao.setConditionOrderNum("=", bean.getOrderNum());
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
		BaseBank bean = new BaseBank();
		bean.setDataFromJSON(json);
		Bank dao = new Bank();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBank> rlist = new BaseCollection<>();
		BaseBank bean = new BaseBank();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Bank dao = new Bank();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBank> result = dao.conditionalLoad(addtion);
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
		BaseBank bean = new BaseBank();
		bean.setDataFromJSON(json);
		Bank dao = new Bank();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBank bean = new BaseBank();
		bean.setDataFromJSON(json);
		Bank dao = new Bank();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBank bean = new BaseBank();
		bean.setDataFromJSON(json);
		Bank dao = new Bank();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBank bean = new BaseBank();
		bean.setDataFromJSON(json);
		Bank dao = new Bank();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


