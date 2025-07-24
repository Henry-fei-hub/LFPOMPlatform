package pomplatform.mcapitalcmmssmssbor.handler;

import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.financialAccounting.bean.BaseMfinancialAccounting;
import pomplatform.mcapitalcmmssmssbor.bean.BaseScapitalssmor;

/**
 * 
 * @Title: CustomMcapitalReconciliationProcess.java 
 * @Package pomplatform.mcapitalcmmssmssbor.handler 
 * @Description: 银行资金对账
 * @author CL  
 * @date 2017年3月20日
 */
public class CustomMcapitalReconciliationProcess implements GenericProcessor ,  GenericDownloadProcessor{
	
	private final static String UPDATE_COMPLETE_TIME = "updateCompleteTime"; //进行凭证号与入账时间添加
	
	private final static int CAPITAL_TYPE_ONE = 1;//流入
	
	private final static int CAPITAL_TYPE_TWO = 2;//流出
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
			switch (opt_type) {
				case UPDATE_COMPLETE_TIME:
					return updateCompleteTime(params);
				default:
					break;
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}
	
	/**
	 * 
	 * @Title: updateCompleteTime 
	 * @Description: 修改流水 发生日期
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String updateCompleteTime(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMessage = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		BaseScapitalssmor oriBean = new BaseScapitalssmor();
		oriBean.setDataFromMap(params);
		Capital dao = new Capital();
		dao.setCapitalId(oriBean.getCapitalId());
		if(dao.load() && Objects.equals(dao.getCapitalType(), CAPITAL_TYPE_TWO)){
			dao.setHappenDate(oriBean.getHappenDate());
			dao.update();
		}
		
		ThreadConnection.commit();
		return bc.toJSON(status, errorMessage);
	}
	
	/**
	 * 
	 * @Title: updatePostingDate 
	 * @Description: 修改报销单的入账时间和凭证号
	 * @param @param updateBean
	 * @param @param oriBean
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	private void updatePostingDate(BaseMfinancialAccounting updateBean, BaseMfinancialAccounting oriBean) throws SQLException{
		int processType = updateBean.getProcessType();
		int bussinessId = updateBean.getBusinessId();
		switch (processType) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			ProjectNormalReimbursement prDao = new ProjectNormalReimbursement();
			prDao.setConditionProjectNormalReimbursementId("=", bussinessId);
			prDao.setVoucherNo(oriBean.getVoucherNo());
			prDao.setPostingDate(oriBean.getPostingDate());
			prDao.conditionalUpdate();
			break;
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			TravelReimbursement trDao = new TravelReimbursement();
			trDao.setConditionTravelReimbursementId("=", bussinessId);
			trDao.setVoucherNo(oriBean.getVoucherNo());
			trDao.setPostingDate(oriBean.getPostingDate());
			trDao.conditionalUpdate();
			break;
		//借款申请
		case StaticUtils.PROCESS_TYPE_6:
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionEmployeeMoneyManageId("=", bussinessId);
			emmDao.setVoucherNo(oriBean.getVoucherNo());
			emmDao.setPostingDate(oriBean.getPostingDate());
			emmDao.conditionalUpdate();
			break;
		//预付款申请	
		case StaticUtils.PROCESS_TYPE_7:
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setConditionPayMoneyManageId("=", bussinessId);
			pmmDao.setVoucherNo(oriBean.getVoucherNo());
			pmmDao.setPostingDate(oriBean.getPostingDate());
			pmmDao.conditionalUpdate();
			break;
		default:
			break;
		}
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}
}