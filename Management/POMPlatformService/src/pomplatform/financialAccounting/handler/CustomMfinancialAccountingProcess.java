package pomplatform.financialAccounting.handler;

import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.NormalReimbursementLinkMainProject;
import com.pomplatform.db.dao.NormalReimbursementLinkProject;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursement;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementLinkDepartment;
import com.pomplatform.db.dao.TravelReimbursementLinkMainProject;
import com.pomplatform.db.dao.TravelReimbursementLinkProject;

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

/**
 * 
 * @Title: CustomMfinancialAccountingProcess.java 
 * @Package pomplatform.financialAccounting.handler 
 * @Description: 入账指定模块
 * @author CL  
 * @date 2017年3月2日
 */
public class CustomMfinancialAccountingProcess implements GenericProcessor ,  GenericDownloadProcessor{
	
	private final static String FINANCIAL_ACCOUNTING_DATE = "financialAccountingDate"; //进行凭证号与入账时间添加
	
	private final static String GET_BUSINESS_DETAIL_BY_PROCESS_DATA = "getBusinessDetailByProcessData"; //根据流程数据获取科目与出差详细信息数据
	
	private final static String GET_BUSINESS_DATA_BY_PROCESS_DATA = "getBusinessDataByProcessData";//根据流程数据获取分拆业务详情数据
	
	private final static String UPDATE_PROCESS_BILL_LIST = "updateProcessBillList";//修改账单流水数据
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
			switch (opt_type) {
				case FINANCIAL_ACCOUNTING_DATE:
					return financialAccountingDate(params);
				case GET_BUSINESS_DETAIL_BY_PROCESS_DATA:
					return getBusinessDetailByProcessData(params);
				case GET_BUSINESS_DATA_BY_PROCESS_DATA:
					return getBusinessDataByProcessData(params);
				case UPDATE_PROCESS_BILL_LIST:
					return updateProcessBillList(params);
				default:
					break;
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}
	
	/**
	 * 
	 * @Title: updateProcessBillList 
	 * @Description: 修改账单流水的的付款方信息
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings({ "unchecked" })
	private String updateProcessBillList(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		List<BaseProcessBillList> summaryList = GenericBase.__getList(
				params.get("records"), BaseProcessBillList.newInstance());
		int processType = BaseHelpUtils.getIntValue(params, "processType");
		if(null != summaryList && summaryList.size() > 0){
			ProcessBillList dao = new ProcessBillList();
			for (BaseProcessBillList baseProcessBillList : summaryList) {
				dao.setConditionProcessBillListId("=", baseProcessBillList.getProcessBillListId());
				dao.setOtherName(baseProcessBillList.getOtherName());
				dao.setOtherBankAccount(baseProcessBillList.getOtherBankAccount());
				dao.setOtherBankName(baseProcessBillList.getOtherBankName());
				dao.setPayMoney(baseProcessBillList.getPayMoney());
				if(!Objects.equals(StaticUtils.PROCESS_TYPE_6, processType) && !Objects.equals(StaticUtils.PROCESS_TYPE_7, processType)){
					dao.setBalanceAmount(baseProcessBillList.getBalanceAmount());
				}
				dao.conditionalUpdate();
			}
		}else{
			status = -1;
			errorMsg = "参数错误";
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getBusinessDataByProcessData 
	 * @Description: 根据流程数据获取分拆业务详情数据
	 * @param @param params
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String getBusinessDataByProcessData(Map<String, Object> params) throws SQLException {
		BaseCollection<GenericBase> mainBc = new BaseCollection<>();
		BaseMfinancialAccounting oriBean = new BaseMfinancialAccounting();
		oriBean.setDataFromMap(params);
		int status = 1;
		switch (oriBean.getProcessType()) {
		
		//日常跟订单有关
		case StaticUtils.PROCESS_TYPE_2:
			BaseCollection<BaseNormalReimbursementLinkProject> mrmBc = new BaseCollection<>();
			NormalReimbursementLinkProject mrmDao = new NormalReimbursementLinkProject();
			mrmDao.setConditionProjectNormalReimbursementId("=", oriBean.getBusinessId());
			mrmBc.setCollections(mrmDao.conditionalLoad());
			return mrmBc.toJSON(status, null);
		//差旅跟订单有关	
		case StaticUtils.PROCESS_TYPE_4:
			BaseCollection<BaseTravelReimbursementLinkProject> trlBc = new BaseCollection<>();
			TravelReimbursementLinkProject trlDao = new TravelReimbursementLinkProject();
			trlDao.setConditionTravelReimbursementId("=", oriBean.getBusinessId());
			trlBc.setCollections(trlDao.conditionalLoad());
			return trlBc.toJSON();
		//日常跟前期项目有关
		case StaticUtils.PROCESS_TYPE_8:
			BaseCollection<BaseNormalReimbursementLinkMainProject> rmlBc = new BaseCollection<>();
			NormalReimbursementLinkMainProject rmlDao = new NormalReimbursementLinkMainProject();
			rmlDao.setConditionProjectNormalReimbursementId("=", oriBean.getBusinessId());
			rmlBc.setCollections(rmlDao.conditionalLoad());
			return rmlBc.toJSON(status, null);
		//差旅跟前期项目有关
		case StaticUtils.PROCESS_TYPE_9:
			BaseCollection<BaseTravelReimbursementLinkMainProject> tmlBc = new BaseCollection<>();
			TravelReimbursementLinkMainProject tmlDao = new TravelReimbursementLinkMainProject();
			tmlDao.setConditionTravelReimbursementId("=", oriBean.getBusinessId());
			tmlBc.setCollections(tmlDao.conditionalLoad());
			return tmlBc.toJSON(status, null);
		//日常跟部门有关
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_10:
			BaseCollection<BaseNormalReimbursementLinkDepartment> nrdBc = new BaseCollection<>();
			NormalReimbursementLinkDepartment nrdDao = new NormalReimbursementLinkDepartment();
			nrdDao.setConditionProjectNormalReimbursementId("=", oriBean.getBusinessId());
			nrdBc.setCollections(nrdDao.conditionalLoad());
			return nrdBc.toJSON(status, null);
		//差旅跟部门有关
		case StaticUtils.PROCESS_TYPE_5:
			BaseCollection<BaseTravelReimbursementLinkDepartment> trdBc = new BaseCollection<>();
			TravelReimbursementLinkDepartment trdDao = new TravelReimbursementLinkDepartment();
			trdDao.setConditionTravelReimbursementId("=", oriBean.getBusinessId());
			trdBc.setCollections(trdDao.conditionalLoad());
			return trdBc.toJSON(status, null);
		default:
			break;
		}
		return mainBc.toJSON(-1, "没有找到相关的拆分数据");
	}
	
	/**
	 * 
	 * @Title: getBusinessDetailByProcessData 
	 * @Description: 根据流程数据获取科目与出差详细信息数据
	 * @param @param params
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String getBusinessDetailByProcessData(Map<String, Object> params) throws SQLException{
		BaseCollection<GenericBase> mainBc = new BaseCollection<>();
		BaseMfinancialAccounting oriBean = new BaseMfinancialAccounting();
		oriBean.setDataFromMap(params);
		switch (oriBean.getProcessType()) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			BaseCollection<BaseProjectNormalReimbursementDetail> bc = new BaseCollection<>();
			ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
			dao.setConditionProjectNormalReimbursementId("=", oriBean.getBusinessId());
			bc.setCollections(dao.conditionalLoad());
			return bc.toJSON(1, null);
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:	
			BaseCollection<BaseTravelReimbursementDetail> tbc = new BaseCollection<>();
			TravelReimbursementDetail tDao =  new TravelReimbursementDetail();
			tDao.setConditionTravelReimbursementId("=", oriBean.getBusinessId());
			tbc.setCollections(tDao.conditionalLoad());
			return tbc.toJSON(1, null);
		default:
			break;
		}
		return mainBc.toJSON(-1, "没有找到相关的科目或者出差数据");
	}
	
	
	/**
	 * 
	 * @Title: financialAccountingDate 
	 * @Description: 修改报销单的入账时间和凭证号
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String financialAccountingDate(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMessage = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		List<BaseMfinancialAccounting> list = GenericBase.__getList(params.get("records"), BaseMfinancialAccounting.newInstance());
		BaseMfinancialAccounting oriBean = new BaseMfinancialAccounting();
		oriBean.setDataFromMap(params);
		
		if(null != list && list.size() > 0 && null != oriBean.getVoucherNo() && null != oriBean.getPostingDate()){
			for (BaseMfinancialAccounting baseMfinancialAccounting : list) {
				updatePostingDate(baseMfinancialAccounting, oriBean);
			}
		}else{
			status = -1;
			errorMessage = "参数错误 params = " + params.toString();
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