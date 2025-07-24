package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.dao.AttachmentManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttachmentManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttachmentManageHandler.class);

	public static BaseAttachmentManage getAttachmentManageById(
			java.lang.Integer attachment_manage_id
	) throws Exception
	{
		AttachmentManage dao = new AttachmentManage();
		dao.setAttachmentManageId(attachment_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttachmentManageExists( com.pomplatform.db.bean.BaseAttachmentManage bean, String additional ) throws Exception {

		AttachmentManage dao = new AttachmentManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttachmentManage( com.pomplatform.db.bean.BaseAttachmentManage bean, String additional ) throws Exception {

		AttachmentManage dao = new AttachmentManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttachmentManage> queryAttachmentManage( com.pomplatform.db.bean.BaseAttachmentManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttachmentManage dao = new AttachmentManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttachmentManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttachmentManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttachmentManage addToAttachmentManage ( BaseAttachmentManage attachmentmanage )  throws Exception {
		return addToAttachmentManage ( attachmentmanage , false);
	}

	public static BaseAttachmentManage addToAttachmentManage ( BaseAttachmentManage attachmentmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttachmentManage dao = new AttachmentManage();
		dao.setDataFromBase(attachmentmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttachmentManage addUpdateAttachmentManage ( BaseAttachmentManage attachmentmanage ) throws Exception {
		return addUpdateAttachmentManage ( attachmentmanage , false);
	}

	public static BaseAttachmentManage addUpdateAttachmentManage ( BaseAttachmentManage attachmentmanage, boolean singleTransaction  ) throws Exception {
		if(attachmentmanage.getAttachmentManageId() == null) return addToAttachmentManage(attachmentmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttachmentManage dao = new AttachmentManage();
		dao.setDataFromBase(attachmentmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attachmentmanage);
			if(dao.isThisObjectModified()) {
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttachmentManage ( BaseAttachmentManage bean ) throws Exception {
		AttachmentManage dao = new AttachmentManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttachmentManage updateAttachmentManage ( BaseAttachmentManage attachmentmanage ) throws Exception {
		AttachmentManage dao = new AttachmentManage();
		dao.setAttachmentManageId( attachmentmanage.getAttachmentManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attachmentmanage);
			result = dao.update();
		}
		return result == 1 ? attachmentmanage : null ;
	}

	public static BaseAttachmentManage updateAttachmentManageDirect( BaseAttachmentManage attachmentmanage ) throws Exception {
		AttachmentManage dao = new AttachmentManage();
		int result = 0;
		dao.setDataFromBase(attachmentmanage);
		result = dao.update();
		return result == 1 ? attachmentmanage : null ;
	}

	public static int setDeleteConditions(BaseAttachmentManage bean, AttachmentManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
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
			if(bean.getAttachmentAddress() != null) {
				dao.setConditionAttachmentAddress("=", bean.getAttachmentAddress());
				count++;
			}
			if(bean.getPerfessionRemark() != null) {
				dao.setConditionPerfessionRemark("=", bean.getPerfessionRemark());
				count++;
			}
			if(bean.getPaymentSure() != null) {
				dao.setConditionPaymentSure("=", bean.getPaymentSure());
				count++;
			}
			if(bean.getPaymentGradeDescription() != null) {
				dao.setConditionPaymentGradeDescription("=", bean.getPaymentGradeDescription());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
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
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSuperProjectManageId() != null) {
				dao.setConditionSuperProjectManageId("=", bean.getSuperProjectManageId());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getHaveVoucher() != null) {
				dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
				count++;
			}
			if(bean.getFinanceRemark() != null) {
				dao.setConditionFinanceRemark("=", bean.getFinanceRemark());
				count++;
			}
			if(bean.getCanReceivedPayment() != null) {
				dao.setConditionCanReceivedPayment("=", bean.getCanReceivedPayment());
				count++;
			}
			if(bean.getConfirmationLetter() != null) {
				dao.setConditionConfirmationLetter("=", bean.getConfirmationLetter());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttachmentManage bean, AttachmentManage dao){
		int count = 0;
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
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
		if(bean.getAttachmentAddress() != null) {
			if(bean.getAttachmentAddress().indexOf("%") >= 0)
				dao.setConditionAttachmentAddress("like", bean.getAttachmentAddress());
			else
				dao.setConditionAttachmentAddress("=", bean.getAttachmentAddress());
			count++;
		}
		if(bean.getPerfessionRemark() != null) {
			if(bean.getPerfessionRemark().indexOf("%") >= 0)
				dao.setConditionPerfessionRemark("like", bean.getPerfessionRemark());
			else
				dao.setConditionPerfessionRemark("=", bean.getPerfessionRemark());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getReturnAmount() != null) {
			dao.setConditionReturnAmount("=", bean.getReturnAmount());
			count++;
		}
		if(bean.getPaymentSure() != null) {
			dao.setConditionPaymentSure("=", bean.getPaymentSure());
			count++;
		}
		if(bean.getPaymentGradeDescription() != null) {
			if(bean.getPaymentGradeDescription().indexOf("%") >= 0)
				dao.setConditionPaymentGradeDescription("like", bean.getPaymentGradeDescription());
			else
				dao.setConditionPaymentGradeDescription("=", bean.getPaymentGradeDescription());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getSuperProjectManageId() != null) {
			dao.setConditionSuperProjectManageId("=", bean.getSuperProjectManageId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getHaveVoucher() != null) {
			dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
			count++;
		}
		if(bean.getFinanceRemark() != null) {
			if(bean.getFinanceRemark().indexOf("%") >= 0)
				dao.setConditionFinanceRemark("like", bean.getFinanceRemark());
			else
				dao.setConditionFinanceRemark("=", bean.getFinanceRemark());
			count++;
		}
		if(bean.getCanReceivedPayment() != null) {
			dao.setConditionCanReceivedPayment("=", bean.getCanReceivedPayment());
			count++;
		}
		if(bean.getConfirmationLetter() != null) {
			dao.setConditionConfirmationLetter("=", bean.getConfirmationLetter());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromJSON(json);
		AttachmentManage dao = new AttachmentManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttachmentManage> rlist = new BaseCollection<>();
		BaseAttachmentManage bean = new BaseAttachmentManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttachmentManage dao = new AttachmentManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttachmentManage> result = dao.conditionalLoad(addtion);
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
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromJSON(json);
		AttachmentManage dao = new AttachmentManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromJSON(json);
		AttachmentManage dao = new AttachmentManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromJSON(json);
		AttachmentManage dao = new AttachmentManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromJSON(json);
		AttachmentManage dao = new AttachmentManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}
