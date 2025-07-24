package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBorrowLimitManage;
import com.pomplatform.db.dao.BorrowLimitManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BorrowLimitManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BorrowLimitManageHandler.class);

	public static BaseBorrowLimitManage getBorrowLimitManageById( 
		java.lang.Integer borrow_limit_manage_id
	) throws Exception
	{
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setBorrowLimitManageId(borrow_limit_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBorrowLimitManageExists( com.pomplatform.db.bean.BaseBorrowLimitManage bean, String additional ) throws Exception {

		BorrowLimitManage dao = new BorrowLimitManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBorrowLimitManage( com.pomplatform.db.bean.BaseBorrowLimitManage bean, String additional ) throws Exception {

		BorrowLimitManage dao = new BorrowLimitManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBorrowLimitManage> queryBorrowLimitManage( com.pomplatform.db.bean.BaseBorrowLimitManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BorrowLimitManage dao = new BorrowLimitManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBorrowLimitManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBorrowLimitManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBorrowLimitManage addToBorrowLimitManage ( BaseBorrowLimitManage borrowlimitmanage )  throws Exception {
		return addToBorrowLimitManage ( borrowlimitmanage , false);
	}

	public static BaseBorrowLimitManage addToBorrowLimitManage ( BaseBorrowLimitManage borrowlimitmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setDataFromBase(borrowlimitmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBorrowLimitManage addUpdateBorrowLimitManage ( BaseBorrowLimitManage borrowlimitmanage ) throws Exception {
		return addUpdateBorrowLimitManage ( borrowlimitmanage , false);
	}

	public static BaseBorrowLimitManage addUpdateBorrowLimitManage ( BaseBorrowLimitManage borrowlimitmanage, boolean singleTransaction  ) throws Exception {
		if(borrowlimitmanage.getBorrowLimitManageId() == null) return addToBorrowLimitManage(borrowlimitmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setDataFromBase(borrowlimitmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(borrowlimitmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBorrowLimitManage ( BaseBorrowLimitManage bean ) throws Exception {
		BorrowLimitManage dao = new BorrowLimitManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBorrowLimitManage updateBorrowLimitManage ( BaseBorrowLimitManage borrowlimitmanage ) throws Exception {
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setBorrowLimitManageId( borrowlimitmanage.getBorrowLimitManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(borrowlimitmanage);
			result = dao.update();
		}
		return result == 1 ? borrowlimitmanage : null ;
	}

	public static BaseBorrowLimitManage updateBorrowLimitManageDirect( BaseBorrowLimitManage borrowlimitmanage ) throws Exception {
		BorrowLimitManage dao = new BorrowLimitManage();
		int result = 0;
		dao.setDataFromBase(borrowlimitmanage);
		result = dao.update();
		return result == 1 ? borrowlimitmanage : null ;
	}

	public static int setDeleteConditions(BaseBorrowLimitManage bean, BorrowLimitManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBorrowLimitManageId() != null) {
			dao.setConditionBorrowLimitManageId("=", bean.getBorrowLimitManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getUpdateEmployeeId() != null) {
				dao.setConditionUpdateEmployeeId("=", bean.getUpdateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBorrowLimitManage bean, BorrowLimitManage dao){
		int count = 0;
		if(bean.getBorrowLimitManageId() != null) {
			dao.setConditionBorrowLimitManageId("=", bean.getBorrowLimitManageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getBorrowLimitMoney() != null) {
			dao.setConditionBorrowLimitMoney("=", bean.getBorrowLimitMoney());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getUpdateEmployeeId() != null) {
			dao.setConditionUpdateEmployeeId("=", bean.getUpdateEmployeeId());
			count++;
		}
		if(bean.getUpdateDate() != null) {
			dao.setConditionUpdateDate(">=", bean.getUpdateDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		bean.setDataFromJSON(json);
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBorrowLimitManage> rlist = new BaseCollection<>();
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BorrowLimitManage dao = new BorrowLimitManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBorrowLimitManage> result = dao.conditionalLoad(addtion);
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
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		bean.setDataFromJSON(json);
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		bean.setDataFromJSON(json);
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		bean.setDataFromJSON(json);
		BorrowLimitManage dao = new BorrowLimitManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBorrowLimitManage bean = new BaseBorrowLimitManage();
		bean.setDataFromJSON(json);
		BorrowLimitManage dao = new BorrowLimitManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


