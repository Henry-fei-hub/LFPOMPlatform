package pomplatform.common.business;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectAdvanceRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.AccountUtils;

/**
 * 根据项目ID检索该项目的补贴总积分和剩余积分
 * @author lxf
 */
public class OnProjectAdvanceRecordSave implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	ThreadConnection.beginTransaction();
    	//保存项目补贴记录表的数据
    	BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
    	bean.setDataFromJSON(creteria);
    	ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
    	bean.setAdvanceDate(new Date());
    	dao.setDataFromBase(bean);
    	dao.save();
    	int businessId = dao.getProjectAdvanceRecordId();
    	//将项目补贴的积分入到部门账户中
    	int plateId = BaseHelpUtils.getIntValue(bean.getPlateId());
    	Date recordDate = bean.getAdvanceDate();
    	recordDate = DateUtil.getFirstDay(recordDate);
    	BigDecimal advanceIntegral = bean.getAdvanceIntegral()==null?BigDecimal.ZERO:bean.getAdvanceIntegral();
    	String remark = bean.getRemark();
    	int operateEmployeeId = bean.getOperateEmployeeId();
    	//项目补贴入部门账户表
		AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_PROJECT_SUBSIDY, advanceIntegral, recordDate, remark, operateEmployeeId);
    	//账户系统：借订单
		AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PROJECT, dao.getProjectId(), AccountUtils.ACCOUNT_BUSSINESS_TYPE_23, businessId, businessId, advanceIntegral, true, recordDate, operateEmployeeId, remark);
		//账户系统：贷业务部门
		AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_23, businessId, businessId, advanceIntegral, false, recordDate, operateEmployeeId, remark);
		
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0, null);
    }

}
