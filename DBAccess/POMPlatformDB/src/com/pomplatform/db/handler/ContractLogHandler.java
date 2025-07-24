package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractLog;
import com.pomplatform.db.dao.ContractLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractLogHandler.class);

	public static BaseContractLog getContractLogById( 
		java.lang.Integer contract_log_id
	) throws Exception
	{
		ContractLog dao = new ContractLog();
		dao.setContractLogId(contract_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractLogExists( com.pomplatform.db.bean.BaseContractLog bean, String additional ) throws Exception {

		ContractLog dao = new ContractLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractLog( com.pomplatform.db.bean.BaseContractLog bean, String additional ) throws Exception {

		ContractLog dao = new ContractLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractLog> queryContractLog( com.pomplatform.db.bean.BaseContractLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractLog dao = new ContractLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractLog addToContractLog ( BaseContractLog contractlog )  throws Exception {
		return addToContractLog ( contractlog , false);
	}

	public static BaseContractLog addToContractLog ( BaseContractLog contractlog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractLog dao = new ContractLog();
		dao.setDataFromBase(contractlog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractLog addUpdateContractLog ( BaseContractLog contractlog ) throws Exception {
		return addUpdateContractLog ( contractlog , false);
	}

	public static BaseContractLog addUpdateContractLog ( BaseContractLog contractlog, boolean singleTransaction  ) throws Exception {
		if(contractlog.getContractLogId() == null) return addToContractLog(contractlog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractLog dao = new ContractLog();
		dao.setDataFromBase(contractlog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractlog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractLog ( BaseContractLog bean ) throws Exception {
		ContractLog dao = new ContractLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractLog updateContractLog ( BaseContractLog contractlog ) throws Exception {
		ContractLog dao = new ContractLog();
		dao.setContractLogId( contractlog.getContractLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractlog);
			result = dao.update();
		}
		return result == 1 ? contractlog : null ;
	}

	public static BaseContractLog updateContractLogDirect( BaseContractLog contractlog ) throws Exception {
		ContractLog dao = new ContractLog();
		int result = 0;
		dao.setDataFromBase(contractlog);
		result = dao.update();
		return result == 1 ? contractlog : null ;
	}

	public static int setDeleteConditions(BaseContractLog bean, ContractLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractLogId() != null) {
			dao.setConditionContractLogId("=", bean.getContractLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getOriginalStatus() != null) {
				dao.setConditionOriginalStatus("=", bean.getOriginalStatus());
				count++;
			}
			if(bean.getNewStatus() != null) {
				dao.setConditionNewStatus("=", bean.getNewStatus());
				count++;
			}
			if(bean.getContent() != null) {
				dao.setConditionContent("=", bean.getContent());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractLog bean, ContractLog dao){
		int count = 0;
		if(bean.getContractLogId() != null) {
			dao.setConditionContractLogId("=", bean.getContractLogId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getOriginalStatus() != null) {
			dao.setConditionOriginalStatus("=", bean.getOriginalStatus());
			count++;
		}
		if(bean.getNewStatus() != null) {
			dao.setConditionNewStatus("=", bean.getNewStatus());
			count++;
		}
		if(bean.getContent() != null) {
			if(bean.getContent().indexOf("%") >= 0)
				dao.setConditionContent("like", bean.getContent());
			else
				dao.setConditionContent("=", bean.getContent());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractLog bean = new BaseContractLog();
		bean.setDataFromJSON(json);
		ContractLog dao = new ContractLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractLog> rlist = new BaseCollection<>();
		BaseContractLog bean = new BaseContractLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractLog dao = new ContractLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractLog> result = dao.conditionalLoad(addtion);
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
		BaseContractLog bean = new BaseContractLog();
		bean.setDataFromJSON(json);
		ContractLog dao = new ContractLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractLog bean = new BaseContractLog();
		bean.setDataFromJSON(json);
		ContractLog dao = new ContractLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractLog bean = new BaseContractLog();
		bean.setDataFromJSON(json);
		ContractLog dao = new ContractLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractLog bean = new BaseContractLog();
		bean.setDataFromJSON(json);
		ContractLog dao = new ContractLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


