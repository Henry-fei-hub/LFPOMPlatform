package pomplatform.minvocieapplydedaocor.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoiceApply;
import com.pomplatform.db.bean.BaseInvoiceApplyReceivable;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.InvoiceApply;
import com.pomplatform.db.dao.InvoiceApplyReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.minvocieapplydedaocor.bean.BaseMinvocieapplydedaocor;
import pomplatform.minvocieapplydedaocor.bean.ConditionMinvocieapplydedaocor;
import pomplatform.minvocieapplydedaocor.query.QueryMinvocieapplydedaocor;

public class CustomMinvocieapplydedaocorHandler implements GenericProcessor,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomMinvocieapplydedaocorHandler.class);
	
	private static final String GET_APPLY_INIT_DATA = "getApplyInitData";//申请发票时  获取初始数据
	
	private static final String ADD_APPLY_INVOCIE = "addApplyInvocie";//添加申请数据
	
	private static final String UPDATE_APPLY_INVOICE = "updateApplyInvoice"; //修改申请发票数据
	
	private static final String REJECT_INVOICE_APPLY = "rejectInvoiceApply"; //驳回发票申请
	
	private static final String UPDATE_CONTRACT_ATTACHMENT_REAMRK = "updateContractAttachmentReamrk";//修改合同确认函备注
	
	private static final String DELETE_CONTACTS = "deleteContacts"; //删除联系人
	
	private static final String UPDATE_CONTACTS = "updateContacts";//修改联系人
	
	//invoice_apply_status申请状态  1:已申请 2：已处理 3：已驳回
	private static final int INVOICE_APPLY_STATUS_ONE = 1;
	private static final int INVOICE_APPLY_STATUS_TWO = 2;
	private static final int INVOICE_APPLY_STATUS_THREE = 3;
	
	
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
				case GET_APPLY_INIT_DATA:
					return getApplyInitData(result);
				case ADD_APPLY_INVOCIE:
					return addApplyInvocie(result);
				case UPDATE_APPLY_INVOICE:
					return updateApplyInvoice(result);
				case REJECT_INVOICE_APPLY:
					return rejectInvoiceApply(result);
				case UPDATE_CONTRACT_ATTACHMENT_REAMRK:
					return updateContractAttachmentReamrk(result);	
				case DELETE_CONTACTS:
					return deleteContacts(result);
				case UPDATE_CONTACTS:
					return updateContacts(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: updateContacts 
	 * @Description: 修改联系人数据
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String updateContacts(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		InvoiceApply dao = new InvoiceApply();
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromMap(params);
		int invoiceApplyId =  bean.getInvoiceApplyId();
		dao.setInvoiceApplyId(invoiceApplyId);
		if(invoiceApplyId > 0 && dao.load()){
			dao.setDataFromBase(bean);
			dao.update();
		} else {
			status = -1;
			errorMsg = "联系人数据错误 invoiceApplyId = " + invoiceApplyId;
		}
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: deleteContacts 
	 * @Description: 删除联系人
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String deleteContacts(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		InvoiceApply dao = new InvoiceApply();
		int invoiceApplyId =  BaseHelpUtils.getIntValue(params, "invoiceApplyId");
		dao.setInvoiceApplyId(invoiceApplyId);
		if(invoiceApplyId > 0 && dao.load()){
			dao.setDeleteFlag(StaticUtils.HAS_DELETE);
			dao.update();
		} else {
			status = -1;
			errorMsg = "联系人数据错误 invoiceApplyId = " + invoiceApplyId;
		}
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: updateContractAttachmentReamrk 
	 * @Description: 修改合同确认函相关备注
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String updateContractAttachmentReamrk(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int contractId =  BaseHelpUtils.getIntValue(params, "contractId");
		String attachmentRemark =  BaseHelpUtils.getStringValue(params, "attachmentRemark");
		Contract dao = new Contract();
		dao.setContractId(contractId);
		if(contractId > 0 && dao.load()){
			dao.setAttachmentRemark(attachmentRemark);
			dao.update();
		} else {
			status = -1;
			errorMsg = "合同数据错误 contractId = " + contractId;
		}
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: rejectInvoiceApply 
	 * @Description: 驳回发票申请
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String rejectInvoiceApply(Map<String, Object> result) throws Exception {
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		Date currentDate = new Date();
		InvoiceApply dao = new InvoiceApply();
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromMap(result);
		
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load() && Objects.equals(dao.getInvoiceApplyStatus(), INVOICE_APPLY_STATUS_ONE) && !BaseHelpUtils.isNullOrEmpty(bean.getOperatorRemark())){
			dao.setOperatorRemark(bean.getOperatorRemark());
			dao.setOperatorId(bean.getOperatorId());
			dao.setUpdateTime(currentDate);
			dao.setOperatorTime(currentDate);
			dao.setInvoiceApplyStatus(INVOICE_APPLY_STATUS_THREE);
			dao.update();//修改主表数据
		}else{
			status = -1;
			errorMsg = "数据错误  申请信息不存在 或者 无驳回理由 id = " + dao.getInvoiceApplyId();
		}
		
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: updateApplyInvoice 
	 * @Description: 修改申请表数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String updateApplyInvoice(Map<String, Object> result) throws Exception {
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		Date currentDate = new Date();
		InvoiceApply dao = new InvoiceApply();
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromMap(result);
		bean.setUpdateTime(currentDate);
		
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()){
			dao.setDataFromBase(bean);
			dao.update();//修改主表数据
			//修改阶段关联数据
			//删除跟此关联申请的数据后再做关联
			InvoiceApplyReceivable iaDao = new InvoiceApplyReceivable();
			iaDao.setConditionInvoiceApplyId("=", dao.getInvoiceApplyId());
			iaDao.conditionalDelete();
			//插入阶段关联数据
			if(null != result.get("list")){
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> mapList = (List<Map<String, Object>>) result.get("list");
				List<BaseInvoiceApplyReceivable> tmpList = new ArrayList<>();
				for (Map<String, Object> map : mapList) {
					BaseInvoiceApplyReceivable tmpBean = new BaseInvoiceApplyReceivable();
					tmpBean.setDataFromMap(map);
					if(null != tmpBean.getReceivableApplyMoney()){
						tmpBean.setContractId(bean.getContractId());
						tmpBean.setInvoiceApplyId(dao.getInvoiceApplyId());
						tmpBean.setCreateTime(currentDate);
						tmpList.add(tmpBean);
					}
				}
				if(tmpList.size() > 0){
					iaDao.save(tmpList);
				}
			}
		}else{
			status = -1;
			errorMsg = "没找到申请数据";
		}
		
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	
	/**
	 * 
	 * @Title: addApplyInvocie 
	 * @Description: 申请发票入库
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String addApplyInvocie(Map<String, Object> result) throws Exception {
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		Date currentDate = new Date();
		InvoiceApply dao = new InvoiceApply();
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromMap(result);
		bean.setApplyTime(currentDate);
		bean.setInvoiceApplyStatus(INVOICE_APPLY_STATUS_ONE);
		bean.setCreateTime(currentDate);
		if(null != bean.getContractId() && null != bean.getApplicantId()){
			dao.setDataFromBase(bean);
			int __num = dao.save();//插入主表数据
			//插入阶段关联数据
			if(null != result.get("list") && __num > 0){
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> mapList = (List<Map<String, Object>>) result.get("list");
				List<BaseInvoiceApplyReceivable> tmpList = new ArrayList<>();
				for (Map<String, Object> map : mapList) {
					BaseInvoiceApplyReceivable tmpBean = new BaseInvoiceApplyReceivable();
					tmpBean.setDataFromMap(map);
					if(null != tmpBean.getReceivableApplyMoney()){
						tmpBean.setContractId(bean.getContractId());
						tmpBean.setInvoiceApplyId(dao.getInvoiceApplyId());
						tmpBean.setCreateTime(currentDate);
						tmpList.add(tmpBean);
					}
				}
				if(tmpList.size() > 0){
					InvoiceApplyReceivable iaDao = new InvoiceApplyReceivable();
					iaDao.save(tmpList);
				}
			}
			return dao.generateBase().toOneLineJSON(status, errorMsg);
		}else{
			status = -1;
			errorMsg = "错误  合同ID（不为空） = " + bean.getContractId() + "  申请人ID不为空 = " + bean.getApplicantId();
		}
		
		BaseCollection<BaseInvoiceApplyReceivable> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
		
	}
	
	/**
	 * 
	 * @Title: getApplyInitData 
	 * @Description: 申请发票时  获取初始数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getApplyInitData(Map<String, Object> result) throws Exception {
		int status = 1;
		String errorMsg = null;
		String employeeName = null;
		String departmentName = null;
		Integer employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		Employee eDao = new Employee();
		eDao.setEmployeeId(employeeId);
		if(eDao.load()){
			//员工名称
			employeeName = eDao.getEmployeeName();
			//员工部门名称
			Integer departmentId = eDao.getDepartmentId();
			Department dDao = new Department();
			dDao.setDepartmentId(departmentId);
			if(dDao.load()){
				departmentName = dDao.getDepartmentName();
			}
		}
		BaseMinvocieapplydedaocor bean = new BaseMinvocieapplydedaocor();
		bean.setApplicantName(employeeName);
		bean.setDepartmentName(departmentName);
		List<BaseMinvocieapplydedaocor> list= new ArrayList<>();
		list.add(bean);
		BaseCollection<BaseMinvocieapplydedaocor> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(status, errorMsg);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMinvocieapplydedaocor> result;
		ConditionMinvocieapplydedaocor c = new ConditionMinvocieapplydedaocor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMinvocieapplydedaocor dao = new QueryMinvocieapplydedaocor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMinvocieapplydedaocor.ALL_CAPTIONS);
			for(BaseMinvocieapplydedaocor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


