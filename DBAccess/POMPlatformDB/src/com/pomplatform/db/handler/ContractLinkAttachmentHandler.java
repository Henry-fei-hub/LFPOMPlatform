package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractLinkAttachment;
import com.pomplatform.db.dao.ContractLinkAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractLinkAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractLinkAttachmentHandler.class);

	public static BaseContractLinkAttachment getContractLinkAttachmentById( 
		java.lang.Integer contract_link_attachment_id
	) throws Exception
	{
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setContractLinkAttachmentId(contract_link_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractLinkAttachmentExists( com.pomplatform.db.bean.BaseContractLinkAttachment bean, String additional ) throws Exception {

		ContractLinkAttachment dao = new ContractLinkAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractLinkAttachment( com.pomplatform.db.bean.BaseContractLinkAttachment bean, String additional ) throws Exception {

		ContractLinkAttachment dao = new ContractLinkAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractLinkAttachment> queryContractLinkAttachment( com.pomplatform.db.bean.BaseContractLinkAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractLinkAttachment dao = new ContractLinkAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractLinkAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractLinkAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractLinkAttachment addToContractLinkAttachment ( BaseContractLinkAttachment contractlinkattachment )  throws Exception {
		return addToContractLinkAttachment ( contractlinkattachment , false);
	}

	public static BaseContractLinkAttachment addToContractLinkAttachment ( BaseContractLinkAttachment contractlinkattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setDataFromBase(contractlinkattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractLinkAttachment addUpdateContractLinkAttachment ( BaseContractLinkAttachment contractlinkattachment ) throws Exception {
		return addUpdateContractLinkAttachment ( contractlinkattachment , false);
	}

	public static BaseContractLinkAttachment addUpdateContractLinkAttachment ( BaseContractLinkAttachment contractlinkattachment, boolean singleTransaction  ) throws Exception {
		if(contractlinkattachment.getContractLinkAttachmentId() == null) return addToContractLinkAttachment(contractlinkattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setDataFromBase(contractlinkattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractlinkattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractLinkAttachment ( BaseContractLinkAttachment bean ) throws Exception {
		ContractLinkAttachment dao = new ContractLinkAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractLinkAttachment updateContractLinkAttachment ( BaseContractLinkAttachment contractlinkattachment ) throws Exception {
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setContractLinkAttachmentId( contractlinkattachment.getContractLinkAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractlinkattachment);
			result = dao.update();
		}
		return result == 1 ? contractlinkattachment : null ;
	}

	public static BaseContractLinkAttachment updateContractLinkAttachmentDirect( BaseContractLinkAttachment contractlinkattachment ) throws Exception {
		ContractLinkAttachment dao = new ContractLinkAttachment();
		int result = 0;
		dao.setDataFromBase(contractlinkattachment);
		result = dao.update();
		return result == 1 ? contractlinkattachment : null ;
	}

	public static int setDeleteConditions(BaseContractLinkAttachment bean, ContractLinkAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractLinkAttachmentId() != null) {
			dao.setConditionContractLinkAttachmentId("=", bean.getContractLinkAttachmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractAttachmentId() != null) {
				dao.setConditionContractAttachmentId("=", bean.getContractAttachmentId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
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

	public static int setConditions(BaseContractLinkAttachment bean, ContractLinkAttachment dao){
		int count = 0;
		if(bean.getContractLinkAttachmentId() != null) {
			dao.setConditionContractLinkAttachmentId("=", bean.getContractLinkAttachmentId());
			count++;
		}
		if(bean.getContractAttachmentId() != null) {
			dao.setConditionContractAttachmentId("=", bean.getContractAttachmentId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
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
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		bean.setDataFromJSON(json);
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractLinkAttachment> rlist = new BaseCollection<>();
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractLinkAttachment dao = new ContractLinkAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractLinkAttachment> result = dao.conditionalLoad(addtion);
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
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		bean.setDataFromJSON(json);
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		bean.setDataFromJSON(json);
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		bean.setDataFromJSON(json);
		ContractLinkAttachment dao = new ContractLinkAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractLinkAttachment bean = new BaseContractLinkAttachment();
		bean.setDataFromJSON(json);
		ContractLinkAttachment dao = new ContractLinkAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


