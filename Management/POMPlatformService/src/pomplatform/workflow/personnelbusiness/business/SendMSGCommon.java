
package pomplatform.workflow.personnelbusiness.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BaseHolidayManage;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeCheckinoutDetail;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.HolidayManage;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.email.ChineseToEnglish;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.CommonTimer;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcessAttention;
import delicacy.system.bean.BaseSystemProcessType;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessType;
import delicacy.system.executor.NewCreateWorkFlow;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.system.executor.WorkFlowActivityProcessor;
import delicacy.system.executor.WorkFlowPooledTaskProcessor;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.bean.BaseKeyValue;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employee.bean.BaseEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.employee.bean.BasePositiveEmployeeInfo;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.leavetype.bean.BaseSearchLeaveTypes;
import pomplatform.leavetype.bean.ConditionSearchLeaveTypes;
import pomplatform.leavetype.query.QuerySearchLeaveTypes;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;
import pomplatform.payment.query.QueryOnLoadEmployeePayment;
import pomplatform.personnelbusiness.bean.BaseDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.bean.ConditionDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.query.QueryDecryptPersonnelBusiness;
import pomplatform.project.bean.BaseProjectOfProjectManager;
import pomplatform.project.bean.ConditionProjectOfProjectManager;
import pomplatform.project.query.QueryProjectOfProjectManager;
import pomplatform.shift.bean.BaseGetShiftInfoByEmployeeId;
import pomplatform.shift.bean.ConditionGetShiftInfoByEmployeeId;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.shift.query.QueryGetShiftInfoByEmployeeId;
import pomplatform.workflow.bean.BaseGetProcessByTypeAndDepartment;
import pomplatform.workflow.bean.ConditionGetProcessByTypeAndDepartment;
import pomplatform.workflow.personnelbusiness.bean.BaseCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.bean.BaseGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.BaseQueryLeaveApplyDays;
import pomplatform.workflow.personnelbusiness.bean.ConditionCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.ConditionQueryLeaveApplyDays;
import pomplatform.workflow.personnelbusiness.dao.EmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.query.QueryCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.query.QueryGetProcessComment;
import pomplatform.workflow.personnelbusiness.query.QueryQueryLeaveApplyDays;
import pomplatform.workflow.query.QueryGetProcessByTypeAndDepartment;

public class SendMSGCommon implements GenericProcessor{
    
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	return null;
    }
    
    /**
     * 流程驳回，推送消息至发起人
     * @param params
     * @return
     * @throws Exception 
     */
    public void sendWXMsgToUser(Map<String, Object> params) throws Exception {
    	String code = BaseHelpUtils.getString(params.get("code"));
    	int processType = BaseHelpUtils.getIntValue(params.get("processType"));
    	int applyEmpId = BaseHelpUtils.getIntValue(params.get("applyEmpId"));
    	if(processType>0 &&applyEmpId>0 ) {
			StringBuffer content =new StringBuffer();
    		//您的****【报销单号：】已被驳回
			SystemProcessType spt =new SystemProcessType();
			spt.setConditionProcessTypeId("=", processType);
			spt.setConditionParentProcessTypeId("=", 1);//报销流程
			BaseSystemProcessType executeQueryOneRow = spt.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)&&!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow.getProcessTypeName())) {
				if(processType==2||processType==3||processType==4||processType==5||processType==8||processType==9||processType==10) {
					content.append("你的");
					content.append(executeQueryOneRow.getProcessTypeName());
					content.append("(报销单号：");
					content.append(code);
					content.append(")已被驳回");
					ERPWeixinUtils.sendWXMsgToUser(applyEmpId, content.toString());
				}else if(processType==6||processType==7) {
					content.append("你的");
					content.append(executeQueryOneRow.getProcessTypeName());
					content.append("(单号：");
					content.append(code);
					content.append(")已被驳回");
					ERPWeixinUtils.sendWXMsgToUser(applyEmpId, content.toString());
				}else {
					content.append("你的");
					content.append(executeQueryOneRow.getProcessTypeName());
					content.append("已被驳回");
					ERPWeixinUtils.sendWXMsgToUser(applyEmpId, content.toString());
				}
			}
    	}
	}
    
   
	public static void main(String[] args) {}
}











