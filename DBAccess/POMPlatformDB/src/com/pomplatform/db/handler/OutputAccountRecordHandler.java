package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseOutputAccountRecord;
import java.util.List;
import com.pomplatform.db.dao.OutputAccountRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class OutputAccountRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutputAccountRecordHandler.class);

	public static BaseOutputAccountRecord getOutputAccountRecordById( 
		java.lang.Integer output_account_record_id
	) throws Exception
	{
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setOutputAccountRecordId(output_account_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutputAccountRecordExists( com.pomplatform.db.bean.BaseOutputAccountRecord bean, String additional ) throws Exception {

		OutputAccountRecord dao = new OutputAccountRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutputAccountRecord( com.pomplatform.db.bean.BaseOutputAccountRecord bean, String additional ) throws Exception {

		OutputAccountRecord dao = new OutputAccountRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutputAccountRecord> queryOutputAccountRecord( com.pomplatform.db.bean.BaseOutputAccountRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutputAccountRecord dao = new OutputAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutputAccountRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutputAccountRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutputAccountRecord addToOutputAccountRecord ( BaseOutputAccountRecord outputaccountrecord )  throws Exception {
		return addToOutputAccountRecord ( outputaccountrecord , false);
	}

	public static BaseOutputAccountRecord addToOutputAccountRecord ( BaseOutputAccountRecord outputaccountrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setDataFromBase(outputaccountrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutputAccountRecord addUpdateOutputAccountRecord ( BaseOutputAccountRecord outputaccountrecord ) throws Exception {
		return addUpdateOutputAccountRecord ( outputaccountrecord , false);
	}

	public static BaseOutputAccountRecord addUpdateOutputAccountRecord ( BaseOutputAccountRecord outputaccountrecord, boolean singleTransaction  ) throws Exception {
		if(outputaccountrecord.getOutputAccountRecordId() == null) return addToOutputAccountRecord(outputaccountrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setDataFromBase(outputaccountrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outputaccountrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutputAccountRecord ( BaseOutputAccountRecord bean ) throws Exception {
		OutputAccountRecord dao = new OutputAccountRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutputAccountRecord updateOutputAccountRecord ( BaseOutputAccountRecord outputaccountrecord ) throws Exception {
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setOutputAccountRecordId( outputaccountrecord.getOutputAccountRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outputaccountrecord);
			result = dao.update();
		}
		return result == 1 ? outputaccountrecord : null ;
	}

	public static BaseOutputAccountRecord updateOutputAccountRecordDirect( BaseOutputAccountRecord outputaccountrecord ) throws Exception {
		OutputAccountRecord dao = new OutputAccountRecord();
		int result = 0;
		dao.setDataFromBase(outputaccountrecord);
		result = dao.update();
		return result == 1 ? outputaccountrecord : null ;
	}

	public static int setDeleteConditions(BaseOutputAccountRecord bean, OutputAccountRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutputAccountRecordId() != null) {
			dao.setConditionOutputAccountRecordId("=", bean.getOutputAccountRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
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
			if(bean.getIsYearFinalAccount() != null) {
				dao.setConditionIsYearFinalAccount("=", bean.getIsYearFinalAccount());
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

	public static int setConditions(BaseOutputAccountRecord bean, OutputAccountRecord dao){
		int count = 0;
		if(bean.getOutputAccountRecordId() != null) {
			dao.setConditionOutputAccountRecordId("=", bean.getOutputAccountRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepAccountIntegral() != null) {
			dao.setConditionDepAccountIntegral("=", bean.getDepAccountIntegral());
			count++;
		}
		if(bean.getEmpAccountIntegral() != null) {
			dao.setConditionEmpAccountIntegral("=", bean.getEmpAccountIntegral());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getAccountDate() != null) {
			dao.setConditionAccountDate(">=", bean.getAccountDate());
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
		if(bean.getIsYearFinalAccount() != null) {
			dao.setConditionIsYearFinalAccount("=", bean.getIsYearFinalAccount());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		bean.setDataFromJSON(json);
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutputAccountRecord> rlist = new BaseCollection<>();
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutputAccountRecord dao = new OutputAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutputAccountRecord> result = dao.conditionalLoad(addtion);
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
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		bean.setDataFromJSON(json);
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		bean.setDataFromJSON(json);
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		bean.setDataFromJSON(json);
		OutputAccountRecord dao = new OutputAccountRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
		bean.setDataFromJSON(json);
		OutputAccountRecord dao = new OutputAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


