package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseContractMessageDetail;
import java.util.List;
import com.pomplatform.db.dao.ContractMessageDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ContractMessageDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractMessageDetailHandler.class);

	public static BaseContractMessageDetail getContractMessageDetailById( 
		java.lang.Integer contract_message_detail_id
	) throws Exception
	{
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setContractMessageDetailId(contract_message_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractMessageDetailExists( com.pomplatform.db.bean.BaseContractMessageDetail bean, String additional ) throws Exception {

		ContractMessageDetail dao = new ContractMessageDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractMessageDetail( com.pomplatform.db.bean.BaseContractMessageDetail bean, String additional ) throws Exception {

		ContractMessageDetail dao = new ContractMessageDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractMessageDetail> queryContractMessageDetail( com.pomplatform.db.bean.BaseContractMessageDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractMessageDetail dao = new ContractMessageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractMessageDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractMessageDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractMessageDetail addToContractMessageDetail ( BaseContractMessageDetail contractmessagedetail )  throws Exception {
		return addToContractMessageDetail ( contractmessagedetail , false);
	}

	public static BaseContractMessageDetail addToContractMessageDetail ( BaseContractMessageDetail contractmessagedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setDataFromBase(contractmessagedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractMessageDetail addUpdateContractMessageDetail ( BaseContractMessageDetail contractmessagedetail ) throws Exception {
		return addUpdateContractMessageDetail ( contractmessagedetail , false);
	}

	public static BaseContractMessageDetail addUpdateContractMessageDetail ( BaseContractMessageDetail contractmessagedetail, boolean singleTransaction  ) throws Exception {
		if(contractmessagedetail.getContractMessageDetailId() == null) return addToContractMessageDetail(contractmessagedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setDataFromBase(contractmessagedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractmessagedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractMessageDetail ( BaseContractMessageDetail bean ) throws Exception {
		ContractMessageDetail dao = new ContractMessageDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractMessageDetail updateContractMessageDetail ( BaseContractMessageDetail contractmessagedetail ) throws Exception {
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setContractMessageDetailId( contractmessagedetail.getContractMessageDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractmessagedetail);
			result = dao.update();
		}
		return result == 1 ? contractmessagedetail : null ;
	}

	public static BaseContractMessageDetail updateContractMessageDetailDirect( BaseContractMessageDetail contractmessagedetail ) throws Exception {
		ContractMessageDetail dao = new ContractMessageDetail();
		int result = 0;
		dao.setDataFromBase(contractmessagedetail);
		result = dao.update();
		return result == 1 ? contractmessagedetail : null ;
	}

	public static int setDeleteConditions(BaseContractMessageDetail bean, ContractMessageDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractMessageDetailId() != null) {
			dao.setConditionContractMessageDetailId("=", bean.getContractMessageDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractMessageId() != null) {
				dao.setConditionContractMessageId("=", bean.getContractMessageId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
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

	public static int setConditions(BaseContractMessageDetail bean, ContractMessageDetail dao){
		int count = 0;
		if(bean.getContractMessageDetailId() != null) {
			dao.setConditionContractMessageDetailId("=", bean.getContractMessageDetailId());
			count++;
		}
		if(bean.getContractMessageId() != null) {
			dao.setConditionContractMessageId("=", bean.getContractMessageId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
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
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		bean.setDataFromJSON(json);
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractMessageDetail> rlist = new BaseCollection<>();
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractMessageDetail dao = new ContractMessageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractMessageDetail> result = dao.conditionalLoad(addtion);
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
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		bean.setDataFromJSON(json);
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		bean.setDataFromJSON(json);
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		bean.setDataFromJSON(json);
		ContractMessageDetail dao = new ContractMessageDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractMessageDetail bean = new BaseContractMessageDetail();
		bean.setDataFromJSON(json);
		ContractMessageDetail dao = new ContractMessageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


