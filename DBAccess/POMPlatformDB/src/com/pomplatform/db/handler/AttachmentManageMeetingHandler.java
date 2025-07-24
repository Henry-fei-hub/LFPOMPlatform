package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentManageMeeting;
import com.pomplatform.db.dao.AttachmentManageMeeting;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttachmentManageMeetingHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttachmentManageMeetingHandler.class);

	public static BaseAttachmentManageMeeting getAttachmentManageMeetingById( 
		java.lang.Integer attachment_manage_meeting_id
	) throws Exception
	{
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setAttachmentManageMeetingId(attachment_manage_meeting_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttachmentManageMeetingExists( com.pomplatform.db.bean.BaseAttachmentManageMeeting bean, String additional ) throws Exception {

		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttachmentManageMeeting( com.pomplatform.db.bean.BaseAttachmentManageMeeting bean, String additional ) throws Exception {

		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttachmentManageMeeting> queryAttachmentManageMeeting( com.pomplatform.db.bean.BaseAttachmentManageMeeting bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttachmentManageMeeting> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttachmentManageMeeting> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttachmentManageMeeting addToAttachmentManageMeeting ( BaseAttachmentManageMeeting attachmentmanagemeeting )  throws Exception {
		return addToAttachmentManageMeeting ( attachmentmanagemeeting , false);
	}

	public static BaseAttachmentManageMeeting addToAttachmentManageMeeting ( BaseAttachmentManageMeeting attachmentmanagemeeting, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setDataFromBase(attachmentmanagemeeting);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttachmentManageMeeting addUpdateAttachmentManageMeeting ( BaseAttachmentManageMeeting attachmentmanagemeeting ) throws Exception {
		return addUpdateAttachmentManageMeeting ( attachmentmanagemeeting , false);
	}

	public static BaseAttachmentManageMeeting addUpdateAttachmentManageMeeting ( BaseAttachmentManageMeeting attachmentmanagemeeting, boolean singleTransaction  ) throws Exception {
		if(attachmentmanagemeeting.getAttachmentManageMeetingId() == null) return addToAttachmentManageMeeting(attachmentmanagemeeting);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setDataFromBase(attachmentmanagemeeting);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attachmentmanagemeeting); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttachmentManageMeeting ( BaseAttachmentManageMeeting bean ) throws Exception {
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttachmentManageMeeting updateAttachmentManageMeeting ( BaseAttachmentManageMeeting attachmentmanagemeeting ) throws Exception {
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setAttachmentManageMeetingId( attachmentmanagemeeting.getAttachmentManageMeetingId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attachmentmanagemeeting);
			result = dao.update();
		}
		return result == 1 ? attachmentmanagemeeting : null ;
	}

	public static BaseAttachmentManageMeeting updateAttachmentManageMeetingDirect( BaseAttachmentManageMeeting attachmentmanagemeeting ) throws Exception {
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		int result = 0;
		dao.setDataFromBase(attachmentmanagemeeting);
		result = dao.update();
		return result == 1 ? attachmentmanagemeeting : null ;
	}

	public static int setDeleteConditions(BaseAttachmentManageMeeting bean, AttachmentManageMeeting dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttachmentManageMeetingId() != null) {
			dao.setConditionAttachmentManageMeetingId("=", bean.getAttachmentManageMeetingId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getMettingStatus() != null) {
				dao.setConditionMettingStatus("=", bean.getMettingStatus());
				count++;
			}
			if(bean.getOperatorStatus() != null) {
				dao.setConditionOperatorStatus("=", bean.getOperatorStatus());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getWorkNum() != null) {
				dao.setConditionWorkNum("=", bean.getWorkNum());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getAttachmentManageId() != null) {
				dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttachmentManageMeeting bean, AttachmentManageMeeting dao){
		int count = 0;
		if(bean.getAttachmentManageMeetingId() != null) {
			dao.setConditionAttachmentManageMeetingId("=", bean.getAttachmentManageMeetingId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getExpectReturnDate() != null) {
			dao.setConditionExpectReturnDate(">=", bean.getExpectReturnDate());
			count++;
		}
		if(bean.getNeedReturnAmount() != null) {
			dao.setConditionNeedReturnAmount("=", bean.getNeedReturnAmount());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getPublishDate() != null) {
			dao.setConditionPublishDate(">=", bean.getPublishDate());
			count++;
		}
		if(bean.getSubmitDate() != null) {
			dao.setConditionSubmitDate(">=", bean.getSubmitDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getMettingStatus() != null) {
			dao.setConditionMettingStatus("=", bean.getMettingStatus());
			count++;
		}
		if(bean.getOperatorStatus() != null) {
			dao.setConditionOperatorStatus("=", bean.getOperatorStatus());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getWorkNum() != null) {
			dao.setConditionWorkNum("=", bean.getWorkNum());
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
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(json);
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttachmentManageMeeting> rlist = new BaseCollection<>();
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttachmentManageMeeting> result = dao.conditionalLoad(addtion);
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
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(json);
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(json);
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(json);
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(json);
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


