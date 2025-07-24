package pomplatform.attachment.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAttachmentLinkContractReceivable;
import com.pomplatform.db.bean.BaseAttachmentLinkInvoice;
import com.pomplatform.db.bean.BaseAttachmentLinkInvoiceApply;
import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseAttachmentManageEmployee;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.AttachmentLinkContractReceivable;
import com.pomplatform.db.dao.AttachmentLinkInvoice;
import com.pomplatform.db.dao.AttachmentLinkInvoiceApply;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.AttachmentManageEmployee;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.dao.EmployeeRole;
import pomplatform.attachment.bean.BaseOnAttachmentLinkContractReceivables;
import pomplatform.attachment.bean.BaseOnAttachmentLinkInvoiceApplys;
import pomplatform.attachment.bean.BaseOnAttachmentLinkInvoices;
import pomplatform.common.utils.StaticUtils;
import pomplatform.sinvoiceitior.bean.CustomBaseIddStrVal;

public class CustomAttachmentWorkProcess implements GenericProcessor{
	
	private final static String BIND_ATTACHMENT = "bindAttachment"; 
	
	private final static String GET_DEPT_EMPLOYEE = "getDeptEmployee";//获取部门下的人员
	
	private final static String GET_UP_REMARK = "getUpRemark";//获取上一次申请的确认函的备注
	
	private final static String UPDATE_BIND_DATA = "updateBindData";//更新绑定数据
	
	private final static String UPDATE_ATTACHMENT_EMP = "updateAttachmentEmp";//修改确认函的人员信息
	
	private final static String GET_ATTACHMENT_EMP = "getAttachmentEmp";//获取确认函的人员信息
	
	private final static String PASS_AFTER_BIND_ATTACHMENT = "passAfterBindAttachment";
	
	private final static String MOVE_ATTACHMENT = "moveAttachment";//移动确认函

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
			case GET_DEPT_EMPLOYEE:
				return getDeptEmployee(result);
			case GET_UP_REMARK:
				return getUpRemark(result);
			case GET_ATTACHMENT_EMP:
				return getAttachmentEmp(result);
			case UPDATE_ATTACHMENT_EMP:
				return updateAttachmentEmp(result);
			case PASS_AFTER_BIND_ATTACHMENT:
				return passAfterBindAttachment(result);
			case MOVE_ATTACHMENT:
				return moveAttachment(result);
			}
		}
		return null;
	}
	
	private String moveAttachment(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String contractIds = BaseHelpUtils.getStringValue(params, "contractIds");
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
		if(contractId > 0 && !BaseHelpUtils.isNullOrEmpty(contractIds)){
			String [] contractIdArra = contractIds.split(",");
			
			Object [] ids = new Object[contractIdArra.length];
			for (int i = 0; i < contractIdArra.length; i++) {
				ids[i] = Integer.parseInt(contractIdArra[i]);
			}
			
			AttachmentManage dao = new AttachmentManage();
			dao.addCondition(BaseAttachmentManage.CS_ATTACHMENT_MANAGE_ID, "in", ids);
			dao.setContractId(contractId);
			dao.conditionalUpdate();
		}else{
			status = -1;
			errorMsg = "数据错误 contractId = " + contractId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 修改确认函的人员信息
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String updateAttachmentEmp(Map<String, Object> params) throws SQLException{
		int status = 1;
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		String errorMsg = null;
		BaseAttachmentManage amBean = new BaseAttachmentManage();
		amBean.setDataFromMap(params);
		AttachmentManage amDao = new AttachmentManage();
		amDao.setPrimaryKeyFromBase(amBean);
		if(amDao.load()){
			amDao.setProjectManageId(amBean.getProjectManageId());
			amDao.setSuperProjectManageId(amBean.getSuperProjectManageId());
			amDao.setDepartmentId(amBean.getDepartmentId());
			amDao.update();
			Date currentDate = new Date();
			List<BaseAttachmentManageEmployee> ameList = GenericBase.__getList(params.get("list"), BaseAttachmentManageEmployee.newInstance());
			AttachmentManageEmployee ameDao = new AttachmentManageEmployee();
			ameDao.setConditionAttachmentManageId("=", amBean.getAttachmentManageId());
			ameDao.conditionalDelete();
			if(ameList.size() > 0){
				ameDao.clear();
				for (BaseAttachmentManageEmployee baseAttachmentManageEmployee : ameList) {
					baseAttachmentManageEmployee.setAttachmentManageId(amBean.getAttachmentManageId());
					baseAttachmentManageEmployee.setEmployeeType(1);
					if(null == baseAttachmentManageEmployee.getOperator()){
						baseAttachmentManageEmployee.setOperator(employeeId);
					}
					if(null == baseAttachmentManageEmployee.getCreateTime()){
						baseAttachmentManageEmployee.setCreateTime(currentDate);
					}
				}
				ameDao.save(ameList);
			}
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 获取确认函的人员信息
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String getAttachmentEmp(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		int attachmentManageId = BaseHelpUtils.getIntValue(params, "attachmentManageId");
		BaseCollection<BaseAttachmentManageEmployee> bc = new BaseCollection<>();
		if(attachmentManageId > 0){
			AttachmentManage dao = new AttachmentManage();
			dao.setAttachmentManageId(attachmentManageId);
			if(dao.load()){
				AttachmentManageEmployee ameDao = new AttachmentManageEmployee();
				ameDao.setConditionAttachmentManageId("=", attachmentManageId);
				List<BaseAttachmentManageEmployee> ameList = ameDao.conditionalLoad();
				bc.setCollections(ameList);
			}else{
				errorMsg = "确认函数据错误 attachmentManageId = " + attachmentManageId;
			}
		}else{
			errorMsg = "确认函数据错误 attachmentManageId = " + attachmentManageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 获取最近一次的专业备注作为新建确认函流程的专业备注
	 * @return
	 * @throws SQLException
	 */
	public String getUpRemark(Map<String, Object> params) throws SQLException{
		int status = 1;
		BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
		PersonnelBusines dao = new PersonnelBusines();
		dao.setConditionProcessType("=", 27);
		dao.setConditionProjectId("=", BaseHelpUtils.getIntValue(params, "contractId"));
		if(null != dao.executeQueryOneRow(" order by " + BasePersonnelBusines.CS_CREATE_TIME + " desc")){
			List<BasePersonnelBusines> list = new ArrayList<>();
			list.add(dao.generateBase());
			bc.setCollections(list);
		}else{
			status = -1;
		}
		return bc.toJSON(status, null);
	}
	
	public String getDeptEmployee(Map<String, Object> params) throws SQLException{
		int status = 1;
		BaseCollection<CustomBaseIddStrVal> bc = new BaseCollection<>();
		int type = BaseHelpUtils.getIntValue(params, "type");
		List<BaseEmployee> list = new ArrayList<>();
		Employee emDao = new Employee();
		emDao.unsetSelectFlags();
		emDao.setSelectEmployeeId(true);
		emDao.setSelectEmployeeNo(true);
		emDao.setSelectEmployeeName(true);
		if(type == 1){
			list = emDao.conditionalLoad(" employee_id in (select project_manage_id from projects)");
		} else {
			//获取业务部门信息
			String plateIds = BaseHelpUtils.getStringValue(params, "plateIds");
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
				list = emDao.conditionalLoad(" employee_id in (select project_manage_id from projects where plate_id in("+plateIds+"))");
			}
		}
		if(list.size() > 0){
			List<CustomBaseIddStrVal> dataList = new ArrayList<>();
			CustomBaseIddStrVal tmpBean = null;
			for (BaseEmployee baseEmployee : list) {
				tmpBean = new CustomBaseIddStrVal();
				tmpBean.setIdd(baseEmployee.getEmployeeId().toString());
				tmpBean.setVal(baseEmployee.getEmployeeName());
				dataList.add(tmpBean);
			}
			bc.setCollections(dataList);
		}else{
			status = -1;
		}
		return bc.toJSON(status, null);
	}
	
	/**
	 * 流程结束后修改确认函数据
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String passAfterBindAttachment(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseAttachmentManage bean = new BaseAttachmentManage();
		bean.setDataFromMap(params);
		Integer attachmentManageId = bean.getAttachmentManageId();
		if(null != attachmentManageId){
			AttachmentManage dao = new AttachmentManage();
			dao.setPrimaryKeyFromBase(bean);
			if(dao.load()){
				dao.setDataFromBase(bean);
				dao.update();
				
				AttachmentLinkContractReceivable alrDao = new AttachmentLinkContractReceivable();
				AttachmentLinkInvoiceApply aliaDao = new AttachmentLinkInvoiceApply();
				AttachmentLinkInvoice aliDao = new AttachmentLinkInvoice();
				//获取流程中的业务主键
				Integer personnelBusinessId = dao.getPersonnelBusinessId();
				if(null == personnelBusinessId){//当主表没有时  从子表进行寻找
					alrDao.setConditionAttachmentManageId("=", attachmentManageId);
					if(null != alrDao.executeQueryOneRow()){
						personnelBusinessId = alrDao.getPersonnelBusinessId();
					}
				}
				
				//修改子表
				List<BaseOnAttachmentLinkInvoices> aliList = GenericBase.__getList(params.get("detailAttachmentLinkInvoices"), BaseOnAttachmentLinkInvoices.newInstance());
				List<BaseOnAttachmentLinkContractReceivables> alrList = GenericBase.__getList(params.get("detailAttachmentLinkContractReceivables"), BaseOnAttachmentLinkContractReceivables.newInstance());
				List<BaseOnAttachmentLinkInvoiceApplys> aliaList = GenericBase.__getList(params.get("detailAttachmentLinkInvoiceApplys"), BaseOnAttachmentLinkInvoiceApplys.newInstance());
				
				//清除中间表数据
				alrDao.clear();
				aliaDao.clear();
				aliDao.clear();
				alrDao.setConditionAttachmentManageId("=", attachmentManageId);
				aliaDao.setConditionAttachmentManageId("=", attachmentManageId);
				aliDao.setConditionAttachmentManageId("=", attachmentManageId);
				alrDao.conditionalDelete();
				aliaDao.conditionalDelete();
				aliDao.conditionalDelete();
				//插入中间表数据
				if(dao.getPaymentSure()){
					int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
					Date currentDate = new Date();
					if(aliaList.size() > 0){
						List<BaseAttachmentLinkInvoiceApply> addList = new ArrayList<>();
						for (BaseOnAttachmentLinkInvoiceApplys ownBean : aliaList) {
							if(ownBean.getFlagType() == 2){
								BaseAttachmentLinkInvoiceApply tmpBean = new BaseAttachmentLinkInvoiceApply();
								tmpBean.setInvoiceApplyId(ownBean.getInvoiceApplyId());
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								tmpBean.setOperateEmployeeId(employeeId);
								tmpBean.setOperateTime(currentDate);
								tmpBean.setAttachmentManageId(attachmentManageId);
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								addList.add(tmpBean);
							}
						}
						if(addList.size() > 0){
							aliaDao.save(addList);
						}
					}
					//插入与合同阶段有关的数据
					if(alrList.size() > 0){
						List<BaseAttachmentLinkContractReceivable> addList = new ArrayList<>();
						for (BaseOnAttachmentLinkContractReceivables ownBean : alrList) {
							if(ownBean.getFlagType() == 2){
								BaseAttachmentLinkContractReceivable tmpBean = new BaseAttachmentLinkContractReceivable();
								tmpBean.setContractReceivableId(ownBean.getContractReceivableId());
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								tmpBean.setOperateEmployeeId(employeeId);
								tmpBean.setOperateTime(currentDate);
								tmpBean.setAttachmentManageId(attachmentManageId);
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								addList.add(tmpBean);
							}
						}
						if(addList.size() > 0){
							alrDao.save(addList);
						}
					}
					//插入与发票有关的数据
					if(aliList.size() > 0){
						List<BaseAttachmentLinkInvoice> addList = new ArrayList<>();
						for (BaseOnAttachmentLinkInvoices ownBean : aliList) {
							if(ownBean.getFlagType() == 2){
								BaseAttachmentLinkInvoice tmpBean = new BaseAttachmentLinkInvoice();
								tmpBean.setInvoiceId(ownBean.getInvoiceId());
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								tmpBean.setOperateEmployeeId(employeeId);
								tmpBean.setOperateTime(currentDate);
								tmpBean.setAttachmentManageId(attachmentManageId);
								tmpBean.setPersonnelBusinessId(personnelBusinessId);
								addList.add(tmpBean);
							}
						}
						if(addList.size() > 0){
							aliDao.save(addList);
						}
					}
				}
			}else{
				status = -1;
				errorMsg = String.format("数据错误 params = [%1$s]", bean.toJSONString());
			}
		}else{
			status = -1;
			errorMsg = String.format("数据错误 params = [%1$s]", bean.toJSONString());
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: bindAttachment 
	 * @Description: 子表与确认函的绑定
	 * @param @param params
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	public static void bindAttachment(Map<String, Object> params, boolean isUpdate) throws SQLException{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromMap(params);
		List<BaseOnAttachmentLinkInvoices> aliList = GenericBase.__getList(params.get("detailAttachmentLinkInvoices"), BaseOnAttachmentLinkInvoices.newInstance());
		List<BaseOnAttachmentLinkContractReceivables> alrList = GenericBase.__getList(params.get("detailAttachmentLinkContractReceivables"), BaseOnAttachmentLinkContractReceivables.newInstance());
		List<BaseOnAttachmentLinkInvoiceApplys> aliaList = GenericBase.__getList(params.get("detailAttachmentLinkInvoiceApplys"), BaseOnAttachmentLinkInvoiceApplys.newInstance());
		AttachmentLinkContractReceivable alrDao = new AttachmentLinkContractReceivable();
		AttachmentLinkInvoiceApply aliaDao = new AttachmentLinkInvoiceApply();
		AttachmentLinkInvoice aliDao = new AttachmentLinkInvoice();
		int personnelBusinessId = bean.getPersonnelBusinessId();
		int employeeId = bean.getEmployeeId();
		Date currentDate = new Date();
		if(isUpdate){//先进行删除
			alrDao.setConditionPersonnelBusinessId("=", personnelBusinessId);
			aliaDao.setConditionPersonnelBusinessId("=", personnelBusinessId);
			aliDao.setConditionPersonnelBusinessId("=", personnelBusinessId);
			alrDao.conditionalDelete();
			aliaDao.conditionalDelete();
			aliDao.conditionalDelete();
		}
		//插入与申请人有关的关联数据
		if(bean.getIsRemoteCity()){
			if(aliaList.size() > 0){
				List<BaseAttachmentLinkInvoiceApply> addList = new ArrayList<>();
				for (BaseOnAttachmentLinkInvoiceApplys ownBean : aliaList) {
					if(ownBean.getFlagType() == 2){
						BaseAttachmentLinkInvoiceApply tmpBean = new BaseAttachmentLinkInvoiceApply();
						tmpBean.setInvoiceApplyId(ownBean.getInvoiceApplyId());
						tmpBean.setPersonnelBusinessId(personnelBusinessId);
						tmpBean.setOperateEmployeeId(employeeId);
						tmpBean.setOperateTime(currentDate);
						addList.add(tmpBean);
					}
				}
				if(addList.size() > 0){
					aliaDao.save(addList);
				}
			}
			//插入与合同阶段有关的数据
			if(alrList.size() > 0){
				List<BaseAttachmentLinkContractReceivable> addList = new ArrayList<>();
				for (BaseOnAttachmentLinkContractReceivables ownBean : alrList) {
					if(ownBean.getFlagType() == 2){
						BaseAttachmentLinkContractReceivable tmpBean = new BaseAttachmentLinkContractReceivable();
						tmpBean.setContractReceivableId(ownBean.getContractReceivableId());
						tmpBean.setPersonnelBusinessId(personnelBusinessId);
						tmpBean.setOperateEmployeeId(employeeId);
						tmpBean.setOperateTime(currentDate);
						addList.add(tmpBean);
					}
				}
				if(addList.size() > 0){
					alrDao.save(addList);
				}
			}
			//插入与发票有关的数据
			if(aliList.size() > 0){
				List<BaseAttachmentLinkInvoice> addList = new ArrayList<>();
				for (BaseOnAttachmentLinkInvoices ownBean : aliList) {
					if(ownBean.getFlagType() == 2){
						BaseAttachmentLinkInvoice tmpBean = new BaseAttachmentLinkInvoice();
						tmpBean.setInvoiceId(ownBean.getInvoiceId());
						tmpBean.setPersonnelBusinessId(personnelBusinessId);
						tmpBean.setOperateEmployeeId(employeeId);
						tmpBean.setOperateTime(currentDate);
						addList.add(tmpBean);
					}
				}
				if(addList.size() > 0){
					aliDao.save(addList);
				}
			}
		}
	}
	
	public static void passAttachmentApply(BasePersonnelBusines bean) throws SQLException {
		AttachmentManage dao = new AttachmentManage();
		// 检测是否有重复通过确认函
		dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
		if(dao.countRows() > 0) {
			return ;
		}
		dao.clear();
		EmployeeRole erDao = new EmployeeRole();
		AttachmentManageEmployee ameDao = new AttachmentManageEmployee();
		Date currentDate = new Date();
		Map<String, String> returnMap = getAttachmentCode(bean.getProjectId());
		dao.setAttachmentAddress(bean.getAttachment());
		dao.setAttachmentName(bean.getReason());
		dao.setAttachmentCode(returnMap.get("code"));
		dao.setPerfessionRemark(bean.getAddress());
		dao.setPaymentGradeDescription(bean.getAddress());
		dao.setPaymentSure(bean.getIsRemoteCity());
		dao.setSerialNumber(Integer.parseInt(returnMap.get("serialNumber")));
		dao.setAmount(bean.getFee());
		dao.setOperateEmployeeId(bean.getEmployeeId());
		dao.setOperateTime(currentDate);
		dao.setRecordDate(currentDate);
		dao.setContractId(bean.getProjectId());
		dao.setRemark(bean.getRemark());
		dao.setProjectManageId(bean.getEmployeeId());
		dao.setPersonnelBusinessId(bean.getPersonnelBusinessId());
		dao.setDepartmentId(bean.getDepartmentId());
		dao.save();
		Integer manageId = dao.getAttachmentManageId();
		if(null != bean.getEmployeeId() && null != bean.getDepartmentId()){
			erDao.setConditionDepartmentId("=", bean.getDepartmentId());
			erDao.setConditionRoleId("=", StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER);
			if(null != erDao.executeQueryOneRow()){
				dao.setSuperProjectManageId(erDao.getEmployeeId());
				dao.update();
				ameDao.setConditionEmployeeId("=", erDao.getEmployeeId());
				ameDao.setConditionEmployeeType("=", 1);
				ameDao.setConditionAttachmentManageId("=", manageId);
				if(ameDao.countRows() <= 0){//不存在则插入
					ameDao.clear();
					ameDao.setAttachmentManageId(manageId);
					ameDao.setEmployeeId(erDao.getEmployeeId());
					ameDao.setOperator(bean.getEmployeeId());
					ameDao.setEmployeeType(1);
					ameDao.save();
				}
			}
		}
		
		//当有收款时 更新所有子表的数据 
		if(bean.getIsRemoteCity()){
			AttachmentLinkContractReceivable alrDao = new AttachmentLinkContractReceivable();
			AttachmentLinkInvoiceApply aliaDao = new AttachmentLinkInvoiceApply();
			AttachmentLinkInvoice aliDao = new AttachmentLinkInvoice();
			alrDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			alrDao.setAttachmentManageId(manageId);
			alrDao.conditionalUpdate();
			
			aliaDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			aliaDao.setAttachmentManageId(manageId);
			aliaDao.conditionalUpdate();
			
			aliDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			aliDao.setAttachmentManageId(manageId);
			aliDao.conditionalUpdate();
			
//			List<BaseAttachmentLinkInvoice> aliList = aliDao.conditionalLoad();
			//当确认函上传时间  大于其中绑定发票的开票日期时  将开票日期作为确认的记录日期
//			if(aliList.size() > 0 && null != bean.getCreateTime()){
//				Object [] arrIds = new Object[aliList.size()];
//				Invoice iDao = new Invoice();
//				
//				for (int i = 0; i < aliList.size(); i++) {
//					arrIds[i] = aliList.get(i).getInvoiceId();
//				}
//				iDao.setConditionInvoiceDate("<", bean.getCreateTime());
//				iDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", arrIds);
//				BaseInvoice iBean= iDao.executeQueryOneRow(" order by " + BaseInvoice.CS_INVOICE_DATE + " asc");
//				if(null != iBean && null != iBean.getInvoiceDate()){
//					dao.setRecordDate(iBean.getInvoiceDate());
//					dao.update();
//				}
//			}
		}
	}
	
	public static void passAttachmentApply(Map<String, Object> params) throws SQLException{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromMap(params);
		passAttachmentApply(bean);
	}
	
	/**
	 * 
	 * @Title: getAttachmentCode 
	 * @Description: 获取确认函编号
	 * @param @param contractId
	 * @param @return
	 * @param @throws SQLException   
	 * @return Map<String,String>   
	 * @throws
	 */
	public static Map<String, String> getAttachmentCode(int contractId) throws SQLException{
		String code = null;
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		cDao.load();
		String contractCode = null == cDao.getContractCode() ? "" : cDao.getContractCode();
		AttachmentManage dao = new AttachmentManage();
		dao.setConditionContractId("=", contractId);
		BaseAttachmentManage base = dao.executeQueryOneRow(" order by " + BaseAttachmentManage.CS_SERIAL_NUMBER + " desc");
		int size = null == base ? 0 : base.getSerialNumber();
		size ++;
		code = contractCode + "-" + String.format("%02d", size);
		Map<String, String> returnMap = new HashMap<>();
		returnMap.put("code", code);
		returnMap.put("serialNumber", size + "");
		return returnMap;
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
		PersonnelBusines personnelBusines = new PersonnelBusines();
		personnelBusines.setPersonnelBusinessId(43773);
		personnelBusines.load();
		BasePersonnelBusines basePersonnelBusines = personnelBusines.generateBase();

//		BasePersonnelBusines basePersonnelBusines1 = personnelBusines.executeQueryOneRow();
		passAttachmentApply(basePersonnelBusines);
		System.out.println("执行成功");
	}
//		AttachmentManage dao = new AttachmentManage();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		dao.setConditionRecordDate(">=", sdf.parse("2017-06-06"));
//		dao.addCondition(BaseAttachmentManage.CS_OPERATE_EMPLOYEE_ID, "in", 1101, 97);
//		List<BaseAttachmentManage> list = dao.conditionalLoad();
//		System.out.println(list.size());
//		AttachmentLinkInvoice aliDao = new AttachmentLinkInvoice();
//		for (BaseAttachmentManage baseAttachmentManage : list) {
//
//			int contractId = baseAttachmentManage.getContractId();
//			int attId = baseAttachmentManage.getAttachmentManageId();
//			aliDao.setConditionAttachmentManageId("=", attId);
//			List<BaseAttachmentLinkInvoice> aliList = aliDao.conditionalLoad();
//			//当确认函上传时间  大于其中绑定发票的开票日期时  将开票日期作为确认的记录日期
//			if(aliList.size() > 0 ){
//				Object [] arrIds = new Object[aliList.size()];
//				Invoice iDao = new Invoice();
//
//				for (int i = 0; i < aliList.size(); i++) {
//					arrIds[i] = aliList.get(i).getInvoiceId();
//				}
//				iDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", arrIds);
//				BaseInvoice iBean= iDao.executeQueryOneRow(" order by " + BaseInvoice.CS_INVOICE_DATE + " asc");
//				if(null != iBean && null != iBean.getInvoiceDate()){
//					dao.clear();
//					System.out.println(sdf.format(iBean.getInvoiceDate()));
//					dao.setAttachmentManageId(attId);
//					dao.load();
//					dao.setRecordDate(iBean.getInvoiceDate());
//					dao.update();
//				}
//			}
//		}
//	}
}
