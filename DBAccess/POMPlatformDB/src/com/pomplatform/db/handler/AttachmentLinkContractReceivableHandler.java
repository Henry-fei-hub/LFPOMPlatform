package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentLinkContractReceivable;
import com.pomplatform.db.dao.AttachmentLinkContractReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttachmentLinkContractReceivableHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttachmentLinkContractReceivableHandler.class);

	public static BaseAttachmentLinkContractReceivable getAttachmentLinkContractReceivableById( 
		java.lang.Integer attachment_link_contract_receivable_id
	) throws Exception
	{
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setAttachmentLinkContractReceivableId(attachment_link_contract_receivable_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttachmentLinkContractReceivableExists( com.pomplatform.db.bean.BaseAttachmentLinkContractReceivable bean, String additional ) throws Exception {

		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttachmentLinkContractReceivable( com.pomplatform.db.bean.BaseAttachmentLinkContractReceivable bean, String additional ) throws Exception {

		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttachmentLinkContractReceivable> queryAttachmentLinkContractReceivable( com.pomplatform.db.bean.BaseAttachmentLinkContractReceivable bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttachmentLinkContractReceivable> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttachmentLinkContractReceivable> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttachmentLinkContractReceivable addToAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable )  throws Exception {
		return addToAttachmentLinkContractReceivable ( attachmentlinkcontractreceivable , false);
	}

	public static BaseAttachmentLinkContractReceivable addToAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setDataFromBase(attachmentlinkcontractreceivable);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttachmentLinkContractReceivable addUpdateAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable ) throws Exception {
		return addUpdateAttachmentLinkContractReceivable ( attachmentlinkcontractreceivable , false);
	}

	public static BaseAttachmentLinkContractReceivable addUpdateAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable, boolean singleTransaction  ) throws Exception {
		if(attachmentlinkcontractreceivable.getAttachmentLinkContractReceivableId() == null) return addToAttachmentLinkContractReceivable(attachmentlinkcontractreceivable);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setDataFromBase(attachmentlinkcontractreceivable);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attachmentlinkcontractreceivable); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable bean ) throws Exception {
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttachmentLinkContractReceivable updateAttachmentLinkContractReceivable ( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable ) throws Exception {
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setAttachmentLinkContractReceivableId( attachmentlinkcontractreceivable.getAttachmentLinkContractReceivableId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attachmentlinkcontractreceivable);
			result = dao.update();
		}
		return result == 1 ? attachmentlinkcontractreceivable : null ;
	}

	public static BaseAttachmentLinkContractReceivable updateAttachmentLinkContractReceivableDirect( BaseAttachmentLinkContractReceivable attachmentlinkcontractreceivable ) throws Exception {
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		int result = 0;
		dao.setDataFromBase(attachmentlinkcontractreceivable);
		result = dao.update();
		return result == 1 ? attachmentlinkcontractreceivable : null ;
	}

	public static int setDeleteConditions(BaseAttachmentLinkContractReceivable bean, AttachmentLinkContractReceivable dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttachmentLinkContractReceivableId() != null) {
			dao.setConditionAttachmentLinkContractReceivableId("=", bean.getAttachmentLinkContractReceivableId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAttachmentManageId() != null) {
				dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
				count++;
			}
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
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
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttachmentLinkContractReceivable bean, AttachmentLinkContractReceivable dao){
		int count = 0;
		if(bean.getAttachmentLinkContractReceivableId() != null) {
			dao.setConditionAttachmentLinkContractReceivableId("=", bean.getAttachmentLinkContractReceivableId());
			count++;
		}
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
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
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		bean.setDataFromJSON(json);
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttachmentLinkContractReceivable> rlist = new BaseCollection<>();
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttachmentLinkContractReceivable> result = dao.conditionalLoad(addtion);
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
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		bean.setDataFromJSON(json);
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		bean.setDataFromJSON(json);
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		bean.setDataFromJSON(json);
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttachmentLinkContractReceivable bean = new BaseAttachmentLinkContractReceivable();
		bean.setDataFromJSON(json);
		AttachmentLinkContractReceivable dao = new AttachmentLinkContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


