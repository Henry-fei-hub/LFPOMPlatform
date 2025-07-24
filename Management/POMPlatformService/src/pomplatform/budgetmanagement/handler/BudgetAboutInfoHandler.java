package pomplatform.budgetmanagement.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.InputTaxRecord;
import com.pomplatform.db.dao.ProcessBillList;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetAboutInfoHandler implements GenericProcessor{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch (optType) {
		case "BudgetUpload"://上传
			return BudgetUpload(params);
		case "UpdateBudgetUpload"://修改并上传
			return UpdateBudgetUpload(params);
		case "BudgetApplyUpload"://预算立项上传附件
			return BudgetApplyUpload(params);
		case "SaveIntuxInfo"://保存进项税记录
			return SaveIntuxInfo(params);
		default:
			return null;
		}
	}


	/**
	 * 预算相关文件上传
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked"})
	public String BudgetUpload(Map<String, Object> params) throws Exception{
		/*//获取上传人ID
		int uploadEmployeeId=BaseHelpUtils.getIntValue(params,"uploadEmployeeId");*/
		//获取附件ID
		int fileId =BaseHelpUtils.getIntValue(params, "fileId");
		//获取预算管理ID
		int budgetManagementId=BaseHelpUtils.getIntValue(params, "budgetManagementId");
		/*//获取附件名称
		int attachmentName=BaseHelpUtils.getIntValue(params, "attachmentName");*/
		/*//获取附件备注
		int uploadRemark=BaseHelpUtils.getIntValue(params, "uploadRemark");
		//获取供应商
		int receiveUnitManageId=BaseHelpUtils.getIntValue(params,"receiveUnitManageId");
		 */
		//获取预算金额
		BigDecimal budgetContractAmount=BaseHelpUtils.getBigDecimalValue(params.get("budgetContractAmount"));
		//如果不上传附件
		if(fileId <= 0){
			if(budgetManagementId <= 0){
				throw new SQLException("保存异常：关联主预算订单不存在");
			}
			BudgetAttachment bdaDao=new BudgetAttachment();
			BaseBudgetAttachment  bdaBean=new BaseBudgetAttachment();
			bdaBean.setUploadTime(new Date());
			bdaBean.setBudgetContractAmountRest(budgetContractAmount);
			bdaBean.setDataFromMap(params);
			bdaDao.setDataFromBase(bdaBean);
			bdaDao.save();
			ThreadConnection.commit();
			BaseCollection<GenericBase> bc = new BaseCollection<>();
			return bc.toJSON(0,null);
		}else {
			//如果上传附件
			if(budgetManagementId <= 0){
				throw new SQLException("保存异常：关联主预算订单不存在");
			}
			ThreadConnection.beginTransaction();
			FileManage fileDao = new FileManage();
			fileDao.setFileId(fileId);
			if(fileDao.load()){
				fileDao.setCitationTimes(fileDao.getCitationTimes()+1);
				fileDao.update();
			}else{
				throw new SQLException("保存异常：加载文件失败");
			}
			BudgetAttachment bdaDao=new BudgetAttachment();
			BaseBudgetAttachment  bdaBean=new BaseBudgetAttachment();
			bdaBean.setUploadTime(new Date());
			bdaBean.setBudgetContractAmountRest(budgetContractAmount);
			bdaBean.setDataFromMap(params);
			bdaDao.setDataFromBase(bdaBean);
			bdaDao.save();
			ThreadConnection.commit();
			BaseCollection<GenericBase> bc = new BaseCollection<>();
			return bc.toJSON(0,null);
		}
	}


	/**
	 * 预算修改相关文件并上传
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked"})
	public String UpdateBudgetUpload(Map<String, Object> params) throws Exception{
		//获取预算附件主键
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		//获取file_mangage附件ID
		int fileId =BaseHelpUtils.getIntValue(params, "fileId");
		ThreadConnection.beginTransaction();
		if(budgetAttachmentId <= 0){
			throw new SQLException("更新异常：获取预算附件文件主键失败");
		}
		if(fileId <= 0){//如果不存在上传附件
			BudgetAttachment bdaDao=new BudgetAttachment();
			bdaDao.setBudgetAttachmentId(budgetAttachmentId);
			BaseCollection<GenericBase> bc = new BaseCollection<>();
			if(bdaDao.load()) {
				BaseBudgetAttachment  bdaBean=new BaseBudgetAttachment();
				bdaBean.setUploadTime(new Date());
				bdaBean.setDataFromMap(params);
				bdaDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
				bdaDao.setDataFromBase(bdaBean);
				bdaDao.setFileId(null);
				bdaDao.setAttachmentName(null);
				bdaDao.conditionalUpdate();
				ThreadConnection.commit();
				return bc.toJSON(0,null);
			}
			return bc.toJSON(-1,"更新失败,不存在此数据");
		}
		//如果存在上传附件
		FileManage fileDao = new FileManage();
		fileDao.setFileId(fileId);
		if(fileDao.load()){
			fileDao.setCitationTimes(fileDao.getCitationTimes()+1);
			fileDao.update();
		}else{
			throw new SQLException("保存异常：加载文件失败");
		}
		BudgetAttachment bdaDao=new BudgetAttachment();
		bdaDao.setBudgetAttachmentId(budgetAttachmentId);
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		if(bdaDao.load()) {
			BaseBudgetAttachment  bdaBean=new BaseBudgetAttachment();
			bdaBean.setUploadTime(new Date());
			bdaBean.setDataFromMap(params);
			bdaDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			bdaDao.setDataFromBase(bdaBean);
			bdaDao.conditionalUpdate();
			ThreadConnection.commit();
			return bc.toJSON(0,null);
		}
		return bc.toJSON(-1,"更新失败,不存在此数据");

	}

	/**
	 * 预算立项相关文件上传
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked"})
	public String BudgetApplyUpload(Map<String, Object> params) throws Exception{
		//获取file_mangage附件ID
		int fileId =BaseHelpUtils.getIntValue(params, "fileId");
		ThreadConnection.beginTransaction();
		FileManage fileDao = new FileManage();
		fileDao.setFileId(fileId);
		if(fileDao.load()){
			fileDao.setCitationTimes(fileDao.getCitationTimes()+1);
			fileDao.update();
		}else{
			throw new SQLException("保存异常：加载文件失败");
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}

	/**
	 * 保存进项税信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked"})
	public String SaveIntuxInfo(Map<String, Object> params) throws Exception{
		int status=-1;
		InputTaxRecord rdao=new InputTaxRecord();
		BaseInputTaxRecord rbean=new BaseInputTaxRecord();
		int  businessId=BaseHelpUtils.getIntValue(params.get("businessId"));
		int  operateEmployeeId=BaseHelpUtils.getIntValue(params.get("operateEmployeeId"));
		String  code=BaseHelpUtils.getString(params.get("code"));
		int processType=BaseHelpUtils.getIntValue(params.get("processType"));
		List<Map<String,Object>> list=(List<Map<String, Object>>) params.get("info");

		for (Map<String, Object> map : list) {
			int inputTaxRecordId=BaseHelpUtils.getIntValue(map.get("inputTaxRecordId"));
			rdao.setInputTaxRecordId(inputTaxRecordId);
			if(rdao.load()) {
				rdao.setInputTax(BaseHelpUtils.getBigDecimalValue(map.get("inputTax")));
				rdao.setOperateTime(new Date());
				rdao.setBusinessId(businessId);
				rdao.setProcessType(processType);
				rdao.setCode(code);
				rdao.setOperateEmployeeId(operateEmployeeId);
				rdao.setInvoiceEndNumber(BaseHelpUtils.getString(map.get("invoiceEndNumber")));
				rdao.update();
			}else {
				rbean.setBusinessId(businessId);
				rbean.setCode(code);
				rbean.setOperateEmployeeId(operateEmployeeId);
				rbean.setProcessType(processType);
				rbean.setDataFromMap(map);
				rbean.setOperateTime(new Date());
				rdao.setDataFromBase(rbean);
				rdao.save();
			}

		}
		status=1;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status,null);
	}
}
