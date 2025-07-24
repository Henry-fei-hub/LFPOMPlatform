package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractAttachment;
import com.pomplatform.db.dao.ContractAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractAttachmentHandler.class);

	public static BaseContractAttachment getContractAttachmentById( 
		java.lang.Integer contract_attachment_id
	) throws Exception
	{
		ContractAttachment dao = new ContractAttachment();
		dao.setContractAttachmentId(contract_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractAttachmentExists( com.pomplatform.db.bean.BaseContractAttachment bean, String additional ) throws Exception {

		ContractAttachment dao = new ContractAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractAttachment( com.pomplatform.db.bean.BaseContractAttachment bean, String additional ) throws Exception {

		ContractAttachment dao = new ContractAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractAttachment> queryContractAttachment( com.pomplatform.db.bean.BaseContractAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractAttachment dao = new ContractAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractAttachment addToContractAttachment ( BaseContractAttachment contractattachment )  throws Exception {
		return addToContractAttachment ( contractattachment , false);
	}

	public static BaseContractAttachment addToContractAttachment ( BaseContractAttachment contractattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractAttachment dao = new ContractAttachment();
		dao.setDataFromBase(contractattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractAttachment addUpdateContractAttachment ( BaseContractAttachment contractattachment ) throws Exception {
		return addUpdateContractAttachment ( contractattachment , false);
	}

	public static BaseContractAttachment addUpdateContractAttachment ( BaseContractAttachment contractattachment, boolean singleTransaction  ) throws Exception {
		if(contractattachment.getContractAttachmentId() == null) return addToContractAttachment(contractattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractAttachment dao = new ContractAttachment();
		dao.setDataFromBase(contractattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractAttachment ( BaseContractAttachment bean ) throws Exception {
		ContractAttachment dao = new ContractAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractAttachment updateContractAttachment ( BaseContractAttachment contractattachment ) throws Exception {
		ContractAttachment dao = new ContractAttachment();
		dao.setContractAttachmentId( contractattachment.getContractAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractattachment);
			result = dao.update();
		}
		return result == 1 ? contractattachment : null ;
	}

	public static BaseContractAttachment updateContractAttachmentDirect( BaseContractAttachment contractattachment ) throws Exception {
		ContractAttachment dao = new ContractAttachment();
		int result = 0;
		dao.setDataFromBase(contractattachment);
		result = dao.update();
		return result == 1 ? contractattachment : null ;
	}

	public static int setDeleteConditions(BaseContractAttachment bean, ContractAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractAttachmentId() != null) {
			dao.setConditionContractAttachmentId("=", bean.getContractAttachmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getAttachmentCode() != null) {
				dao.setConditionAttachmentCode("=", bean.getAttachmentCode());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getUploadEmployeeId() != null) {
				dao.setConditionUploadEmployeeId("=", bean.getUploadEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractAttachment bean, ContractAttachment dao){
		int count = 0;
		if(bean.getContractAttachmentId() != null) {
			dao.setConditionContractAttachmentId("=", bean.getContractAttachmentId());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getAttachmentCode() != null) {
			if(bean.getAttachmentCode().indexOf("%") >= 0)
				dao.setConditionAttachmentCode("like", bean.getAttachmentCode());
			else
				dao.setConditionAttachmentCode("=", bean.getAttachmentCode());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getUploadEmployeeId() != null) {
			dao.setConditionUploadEmployeeId("=", bean.getUploadEmployeeId());
			count++;
		}
		if(bean.getUploadTime() != null) {
			dao.setConditionUploadTime(">=", bean.getUploadTime());
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
		BaseContractAttachment bean = new BaseContractAttachment();
		bean.setDataFromJSON(json);
		ContractAttachment dao = new ContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractAttachment> rlist = new BaseCollection<>();
		BaseContractAttachment bean = new BaseContractAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractAttachment dao = new ContractAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractAttachment> result = dao.conditionalLoad(addtion);
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
		BaseContractAttachment bean = new BaseContractAttachment();
		bean.setDataFromJSON(json);
		ContractAttachment dao = new ContractAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractAttachment bean = new BaseContractAttachment();
		bean.setDataFromJSON(json);
		ContractAttachment dao = new ContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractAttachment bean = new BaseContractAttachment();
		bean.setDataFromJSON(json);
		ContractAttachment dao = new ContractAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractAttachment bean = new BaseContractAttachment();
		bean.setDataFromJSON(json);
		ContractAttachment dao = new ContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


