package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseContractMessage;
import java.util.List;
import com.pomplatform.db.dao.ContractMessage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ContractMessageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractMessageHandler.class);

	public static BaseContractMessage getContractMessageById( 
		java.lang.Integer contract_message_id
	) throws Exception
	{
		ContractMessage dao = new ContractMessage();
		dao.setContractMessageId(contract_message_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractMessageExists( com.pomplatform.db.bean.BaseContractMessage bean, String additional ) throws Exception {

		ContractMessage dao = new ContractMessage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractMessage( com.pomplatform.db.bean.BaseContractMessage bean, String additional ) throws Exception {

		ContractMessage dao = new ContractMessage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractMessage> queryContractMessage( com.pomplatform.db.bean.BaseContractMessage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractMessage dao = new ContractMessage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractMessage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractMessage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractMessage addToContractMessage ( BaseContractMessage contractmessage )  throws Exception {
		return addToContractMessage ( contractmessage , false);
	}

	public static BaseContractMessage addToContractMessage ( BaseContractMessage contractmessage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractMessage dao = new ContractMessage();
		dao.setDataFromBase(contractmessage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractMessage addUpdateContractMessage ( BaseContractMessage contractmessage ) throws Exception {
		return addUpdateContractMessage ( contractmessage , false);
	}

	public static BaseContractMessage addUpdateContractMessage ( BaseContractMessage contractmessage, boolean singleTransaction  ) throws Exception {
		if(contractmessage.getContractMessageId() == null) return addToContractMessage(contractmessage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractMessage dao = new ContractMessage();
		dao.setDataFromBase(contractmessage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractmessage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractMessage ( BaseContractMessage bean ) throws Exception {
		ContractMessage dao = new ContractMessage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractMessage updateContractMessage ( BaseContractMessage contractmessage ) throws Exception {
		ContractMessage dao = new ContractMessage();
		dao.setContractMessageId( contractmessage.getContractMessageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractmessage);
			result = dao.update();
		}
		return result == 1 ? contractmessage : null ;
	}

	public static BaseContractMessage updateContractMessageDirect( BaseContractMessage contractmessage ) throws Exception {
		ContractMessage dao = new ContractMessage();
		int result = 0;
		dao.setDataFromBase(contractmessage);
		result = dao.update();
		return result == 1 ? contractmessage : null ;
	}

	public static int setDeleteConditions(BaseContractMessage bean, ContractMessage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractMessageId() != null) {
			dao.setConditionContractMessageId("=", bean.getContractMessageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getMsgCount() != null) {
				dao.setConditionMsgCount("=", bean.getMsgCount());
				count++;
			}
			if(bean.getMsgStatus() != null) {
				dao.setConditionMsgStatus("=", bean.getMsgStatus());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractMessage bean, ContractMessage dao){
		int count = 0;
		if(bean.getContractMessageId() != null) {
			dao.setConditionContractMessageId("=", bean.getContractMessageId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getMsgCount() != null) {
			dao.setConditionMsgCount("=", bean.getMsgCount());
			count++;
		}
		if(bean.getMsgStatus() != null) {
			dao.setConditionMsgStatus("=", bean.getMsgStatus());
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
		BaseContractMessage bean = new BaseContractMessage();
		bean.setDataFromJSON(json);
		ContractMessage dao = new ContractMessage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractMessage> rlist = new BaseCollection<>();
		BaseContractMessage bean = new BaseContractMessage();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractMessage dao = new ContractMessage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractMessage> result = dao.conditionalLoad(addtion);
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
		BaseContractMessage bean = new BaseContractMessage();
		bean.setDataFromJSON(json);
		ContractMessage dao = new ContractMessage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractMessage bean = new BaseContractMessage();
		bean.setDataFromJSON(json);
		ContractMessage dao = new ContractMessage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractMessage bean = new BaseContractMessage();
		bean.setDataFromJSON(json);
		ContractMessage dao = new ContractMessage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractMessage bean = new BaseContractMessage();
		bean.setDataFromJSON(json);
		ContractMessage dao = new ContractMessage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


