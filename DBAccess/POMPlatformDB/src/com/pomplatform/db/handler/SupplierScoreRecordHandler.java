package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierScoreRecord;
import com.pomplatform.db.dao.SupplierScoreRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierScoreRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierScoreRecordHandler.class);

	public static BaseSupplierScoreRecord getSupplierScoreRecordById( 
		java.lang.Integer scord_id
	) throws Exception
	{
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setScordId(scord_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierScoreRecordExists( com.pomplatform.db.bean.BaseSupplierScoreRecord bean, String additional ) throws Exception {

		SupplierScoreRecord dao = new SupplierScoreRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierScoreRecord( com.pomplatform.db.bean.BaseSupplierScoreRecord bean, String additional ) throws Exception {

		SupplierScoreRecord dao = new SupplierScoreRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierScoreRecord> querySupplierScoreRecord( com.pomplatform.db.bean.BaseSupplierScoreRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierScoreRecord dao = new SupplierScoreRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierScoreRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierScoreRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierScoreRecord addToSupplierScoreRecord ( BaseSupplierScoreRecord supplierscorerecord )  throws Exception {
		return addToSupplierScoreRecord ( supplierscorerecord , false);
	}

	public static BaseSupplierScoreRecord addToSupplierScoreRecord ( BaseSupplierScoreRecord supplierscorerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setDataFromBase(supplierscorerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierScoreRecord addUpdateSupplierScoreRecord ( BaseSupplierScoreRecord supplierscorerecord ) throws Exception {
		return addUpdateSupplierScoreRecord ( supplierscorerecord , false);
	}

	public static BaseSupplierScoreRecord addUpdateSupplierScoreRecord ( BaseSupplierScoreRecord supplierscorerecord, boolean singleTransaction  ) throws Exception {
		if(supplierscorerecord.getScordId() == null) return addToSupplierScoreRecord(supplierscorerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setDataFromBase(supplierscorerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplierscorerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierScoreRecord ( BaseSupplierScoreRecord bean ) throws Exception {
		SupplierScoreRecord dao = new SupplierScoreRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierScoreRecord updateSupplierScoreRecord ( BaseSupplierScoreRecord supplierscorerecord ) throws Exception {
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setScordId( supplierscorerecord.getScordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplierscorerecord);
			result = dao.update();
		}
		return result == 1 ? supplierscorerecord : null ;
	}

	public static BaseSupplierScoreRecord updateSupplierScoreRecordDirect( BaseSupplierScoreRecord supplierscorerecord ) throws Exception {
		SupplierScoreRecord dao = new SupplierScoreRecord();
		int result = 0;
		dao.setDataFromBase(supplierscorerecord);
		result = dao.update();
		return result == 1 ? supplierscorerecord : null ;
	}

	public static int setDeleteConditions(BaseSupplierScoreRecord bean, SupplierScoreRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getScordId() != null) {
			dao.setConditionScordId("=", bean.getScordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierScoreRecord bean, SupplierScoreRecord dao){
		int count = 0;
		if(bean.getScordId() != null) {
			dao.setConditionScordId("=", bean.getScordId());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getScord() != null) {
			dao.setConditionScord("=", bean.getScord());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		bean.setDataFromJSON(json);
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierScoreRecord> rlist = new BaseCollection<>();
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierScoreRecord dao = new SupplierScoreRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierScoreRecord> result = dao.conditionalLoad(addtion);
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
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		bean.setDataFromJSON(json);
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		bean.setDataFromJSON(json);
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		bean.setDataFromJSON(json);
		SupplierScoreRecord dao = new SupplierScoreRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierScoreRecord bean = new BaseSupplierScoreRecord();
		bean.setDataFromJSON(json);
		SupplierScoreRecord dao = new SupplierScoreRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


