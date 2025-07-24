package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTargetRecord;
import com.pomplatform.db.dao.TargetRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TargetRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TargetRecordHandler.class);

	public static BaseTargetRecord getTargetRecordById( 
		java.lang.Integer target_record_id
	) throws Exception
	{
		TargetRecord dao = new TargetRecord();
		dao.setTargetRecordId(target_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTargetRecordExists( com.pomplatform.db.bean.BaseTargetRecord bean, String additional ) throws Exception {

		TargetRecord dao = new TargetRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTargetRecord( com.pomplatform.db.bean.BaseTargetRecord bean, String additional ) throws Exception {

		TargetRecord dao = new TargetRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTargetRecord> queryTargetRecord( com.pomplatform.db.bean.BaseTargetRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TargetRecord dao = new TargetRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTargetRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTargetRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTargetRecord addToTargetRecord ( BaseTargetRecord targetrecord )  throws Exception {
		return addToTargetRecord ( targetrecord , false);
	}

	public static BaseTargetRecord addToTargetRecord ( BaseTargetRecord targetrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TargetRecord dao = new TargetRecord();
		dao.setDataFromBase(targetrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTargetRecord addUpdateTargetRecord ( BaseTargetRecord targetrecord ) throws Exception {
		return addUpdateTargetRecord ( targetrecord , false);
	}

	public static BaseTargetRecord addUpdateTargetRecord ( BaseTargetRecord targetrecord, boolean singleTransaction  ) throws Exception {
		if(targetrecord.getTargetRecordId() == null) return addToTargetRecord(targetrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TargetRecord dao = new TargetRecord();
		dao.setDataFromBase(targetrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(targetrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTargetRecord ( BaseTargetRecord bean ) throws Exception {
		TargetRecord dao = new TargetRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTargetRecord updateTargetRecord ( BaseTargetRecord targetrecord ) throws Exception {
		TargetRecord dao = new TargetRecord();
		dao.setTargetRecordId( targetrecord.getTargetRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(targetrecord);
			result = dao.update();
		}
		return result == 1 ? targetrecord : null ;
	}

	public static BaseTargetRecord updateTargetRecordDirect( BaseTargetRecord targetrecord ) throws Exception {
		TargetRecord dao = new TargetRecord();
		int result = 0;
		dao.setDataFromBase(targetrecord);
		result = dao.update();
		return result == 1 ? targetrecord : null ;
	}

	public static int setDeleteConditions(BaseTargetRecord bean, TargetRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTargetRecordId() != null) {
			dao.setConditionTargetRecordId("=", bean.getTargetRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessLine() != null) {
				dao.setConditionBusinessLine("=", bean.getBusinessLine());
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
			if(bean.getTargetStr() != null) {
				dao.setConditionTargetStr("=", bean.getTargetStr());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTargetRecord bean, TargetRecord dao){
		int count = 0;
		if(bean.getTargetRecordId() != null) {
			dao.setConditionTargetRecordId("=", bean.getTargetRecordId());
			count++;
		}
		if(bean.getBusinessLine() != null) {
			dao.setConditionBusinessLine("=", bean.getBusinessLine());
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
		if(bean.getTarget() != null) {
			dao.setConditionTarget("=", bean.getTarget());
			count++;
		}
		if(bean.getTargetStr() != null) {
			if(bean.getTargetStr().indexOf("%") >= 0)
				dao.setConditionTargetStr("like", bean.getTargetStr());
			else
				dao.setConditionTargetStr("=", bean.getTargetStr());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOperateDate() != null) {
			dao.setConditionOperateDate(">=", bean.getOperateDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTargetRecord bean = new BaseTargetRecord();
		bean.setDataFromJSON(json);
		TargetRecord dao = new TargetRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTargetRecord> rlist = new BaseCollection<>();
		BaseTargetRecord bean = new BaseTargetRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TargetRecord dao = new TargetRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTargetRecord> result = dao.conditionalLoad(addtion);
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
		BaseTargetRecord bean = new BaseTargetRecord();
		bean.setDataFromJSON(json);
		TargetRecord dao = new TargetRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTargetRecord bean = new BaseTargetRecord();
		bean.setDataFromJSON(json);
		TargetRecord dao = new TargetRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTargetRecord bean = new BaseTargetRecord();
		bean.setDataFromJSON(json);
		TargetRecord dao = new TargetRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTargetRecord bean = new BaseTargetRecord();
		bean.setDataFromJSON(json);
		TargetRecord dao = new TargetRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


