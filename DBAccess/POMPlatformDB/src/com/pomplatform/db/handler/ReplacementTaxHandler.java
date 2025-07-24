package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReplacementTax;
import com.pomplatform.db.dao.ReplacementTax;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReplacementTaxHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReplacementTaxHandler.class);

	public static BaseReplacementTax getReplacementTaxById( 
		java.lang.Integer replacement_tax_id
	) throws Exception
	{
		ReplacementTax dao = new ReplacementTax();
		dao.setReplacementTaxId(replacement_tax_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReplacementTaxExists( com.pomplatform.db.bean.BaseReplacementTax bean, String additional ) throws Exception {

		ReplacementTax dao = new ReplacementTax();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReplacementTax( com.pomplatform.db.bean.BaseReplacementTax bean, String additional ) throws Exception {

		ReplacementTax dao = new ReplacementTax();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReplacementTax> queryReplacementTax( com.pomplatform.db.bean.BaseReplacementTax bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReplacementTax dao = new ReplacementTax();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReplacementTax> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReplacementTax> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReplacementTax addToReplacementTax ( BaseReplacementTax replacementtax )  throws Exception {
		return addToReplacementTax ( replacementtax , false);
	}

	public static BaseReplacementTax addToReplacementTax ( BaseReplacementTax replacementtax, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReplacementTax dao = new ReplacementTax();
		dao.setDataFromBase(replacementtax);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReplacementTax addUpdateReplacementTax ( BaseReplacementTax replacementtax ) throws Exception {
		return addUpdateReplacementTax ( replacementtax , false);
	}

	public static BaseReplacementTax addUpdateReplacementTax ( BaseReplacementTax replacementtax, boolean singleTransaction  ) throws Exception {
		if(replacementtax.getReplacementTaxId() == null) return addToReplacementTax(replacementtax);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReplacementTax dao = new ReplacementTax();
		dao.setDataFromBase(replacementtax);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(replacementtax); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReplacementTax ( BaseReplacementTax bean ) throws Exception {
		ReplacementTax dao = new ReplacementTax();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReplacementTax updateReplacementTax ( BaseReplacementTax replacementtax ) throws Exception {
		ReplacementTax dao = new ReplacementTax();
		dao.setReplacementTaxId( replacementtax.getReplacementTaxId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(replacementtax);
			result = dao.update();
		}
		return result == 1 ? replacementtax : null ;
	}

	public static BaseReplacementTax updateReplacementTaxDirect( BaseReplacementTax replacementtax ) throws Exception {
		ReplacementTax dao = new ReplacementTax();
		int result = 0;
		dao.setDataFromBase(replacementtax);
		result = dao.update();
		return result == 1 ? replacementtax : null ;
	}

	public static int setDeleteConditions(BaseReplacementTax bean, ReplacementTax dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReplacementTaxId() != null) {
			dao.setConditionReplacementTaxId("=", bean.getReplacementTaxId());
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
			if(bean.getReplacementTax() != null) {
				dao.setConditionReplacementTax("=", bean.getReplacementTax());
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

	public static int setConditions(BaseReplacementTax bean, ReplacementTax dao){
		int count = 0;
		if(bean.getReplacementTaxId() != null) {
			dao.setConditionReplacementTaxId("=", bean.getReplacementTaxId());
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
		if(bean.getReplacementTax() != null) {
			if(bean.getReplacementTax().indexOf("%") >= 0)
				dao.setConditionReplacementTax("like", bean.getReplacementTax());
			else
				dao.setConditionReplacementTax("=", bean.getReplacementTax());
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
		BaseReplacementTax bean = new BaseReplacementTax();
		bean.setDataFromJSON(json);
		ReplacementTax dao = new ReplacementTax();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReplacementTax> rlist = new BaseCollection<>();
		BaseReplacementTax bean = new BaseReplacementTax();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReplacementTax dao = new ReplacementTax();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReplacementTax> result = dao.conditionalLoad(addtion);
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
		BaseReplacementTax bean = new BaseReplacementTax();
		bean.setDataFromJSON(json);
		ReplacementTax dao = new ReplacementTax();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReplacementTax bean = new BaseReplacementTax();
		bean.setDataFromJSON(json);
		ReplacementTax dao = new ReplacementTax();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReplacementTax bean = new BaseReplacementTax();
		bean.setDataFromJSON(json);
		ReplacementTax dao = new ReplacementTax();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReplacementTax bean = new BaseReplacementTax();
		bean.setDataFromJSON(json);
		ReplacementTax dao = new ReplacementTax();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


