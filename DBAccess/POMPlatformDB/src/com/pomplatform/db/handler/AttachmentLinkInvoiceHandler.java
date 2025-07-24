package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentLinkInvoice;
import com.pomplatform.db.dao.AttachmentLinkInvoice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttachmentLinkInvoiceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttachmentLinkInvoiceHandler.class);

	public static BaseAttachmentLinkInvoice getAttachmentLinkInvoiceById( 
		java.lang.Integer attachment_link_invoice_id
	) throws Exception
	{
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setAttachmentLinkInvoiceId(attachment_link_invoice_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttachmentLinkInvoiceExists( com.pomplatform.db.bean.BaseAttachmentLinkInvoice bean, String additional ) throws Exception {

		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttachmentLinkInvoice( com.pomplatform.db.bean.BaseAttachmentLinkInvoice bean, String additional ) throws Exception {

		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttachmentLinkInvoice> queryAttachmentLinkInvoice( com.pomplatform.db.bean.BaseAttachmentLinkInvoice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttachmentLinkInvoice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttachmentLinkInvoice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttachmentLinkInvoice addToAttachmentLinkInvoice ( BaseAttachmentLinkInvoice attachmentlinkinvoice )  throws Exception {
		return addToAttachmentLinkInvoice ( attachmentlinkinvoice , false);
	}

	public static BaseAttachmentLinkInvoice addToAttachmentLinkInvoice ( BaseAttachmentLinkInvoice attachmentlinkinvoice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setDataFromBase(attachmentlinkinvoice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttachmentLinkInvoice addUpdateAttachmentLinkInvoice ( BaseAttachmentLinkInvoice attachmentlinkinvoice ) throws Exception {
		return addUpdateAttachmentLinkInvoice ( attachmentlinkinvoice , false);
	}

	public static BaseAttachmentLinkInvoice addUpdateAttachmentLinkInvoice ( BaseAttachmentLinkInvoice attachmentlinkinvoice, boolean singleTransaction  ) throws Exception {
		if(attachmentlinkinvoice.getAttachmentLinkInvoiceId() == null) return addToAttachmentLinkInvoice(attachmentlinkinvoice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setDataFromBase(attachmentlinkinvoice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attachmentlinkinvoice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttachmentLinkInvoice ( BaseAttachmentLinkInvoice bean ) throws Exception {
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttachmentLinkInvoice updateAttachmentLinkInvoice ( BaseAttachmentLinkInvoice attachmentlinkinvoice ) throws Exception {
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setAttachmentLinkInvoiceId( attachmentlinkinvoice.getAttachmentLinkInvoiceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attachmentlinkinvoice);
			result = dao.update();
		}
		return result == 1 ? attachmentlinkinvoice : null ;
	}

	public static BaseAttachmentLinkInvoice updateAttachmentLinkInvoiceDirect( BaseAttachmentLinkInvoice attachmentlinkinvoice ) throws Exception {
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		int result = 0;
		dao.setDataFromBase(attachmentlinkinvoice);
		result = dao.update();
		return result == 1 ? attachmentlinkinvoice : null ;
	}

	public static int setDeleteConditions(BaseAttachmentLinkInvoice bean, AttachmentLinkInvoice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttachmentLinkInvoiceId() != null) {
			dao.setConditionAttachmentLinkInvoiceId("=", bean.getAttachmentLinkInvoiceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAttachmentManageId() != null) {
				dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
				count++;
			}
			if(bean.getInvoiceId() != null) {
				dao.setConditionInvoiceId("=", bean.getInvoiceId());
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

	public static int setConditions(BaseAttachmentLinkInvoice bean, AttachmentLinkInvoice dao){
		int count = 0;
		if(bean.getAttachmentLinkInvoiceId() != null) {
			dao.setConditionAttachmentLinkInvoiceId("=", bean.getAttachmentLinkInvoiceId());
			count++;
		}
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getInvoiceId() != null) {
			dao.setConditionInvoiceId("=", bean.getInvoiceId());
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
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		bean.setDataFromJSON(json);
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttachmentLinkInvoice> rlist = new BaseCollection<>();
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttachmentLinkInvoice> result = dao.conditionalLoad(addtion);
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
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		bean.setDataFromJSON(json);
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		bean.setDataFromJSON(json);
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		bean.setDataFromJSON(json);
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttachmentLinkInvoice bean = new BaseAttachmentLinkInvoice();
		bean.setDataFromJSON(json);
		AttachmentLinkInvoice dao = new AttachmentLinkInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


