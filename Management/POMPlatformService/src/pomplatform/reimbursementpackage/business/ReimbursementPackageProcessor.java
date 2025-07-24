package pomplatform.reimbursementpackage.business;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCmbcPayDetail;
import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseReimbursementPackage;
import com.pomplatform.db.bean.BaseReimbursementPackageDetail;
import com.pomplatform.db.bean.BaseReimbursementPackageSummary;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.bean.CustomBaseReimbursementPackageSummary;
import com.pomplatform.db.dao.Area;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.BudgetManagement;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CmbcPayDetail;
import com.pomplatform.db.dao.CmbcPayment;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.InputTaxRecord;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.NormalReimbursementLinkProject;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.PaymentSequence;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.ReimbursementPackage;
import com.pomplatform.db.dao.ReimbursementPackageDetail;
import com.pomplatform.db.dao.ReimbursementPackageSummary;
import com.pomplatform.db.dao.SystemDictionary;
import com.pomplatform.db.dao.TravelReimbursement;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementLinkDepartment;
import com.pomplatform.db.dao.TravelReimbursementLinkProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.bean.BaseSystemProcessPooledTask;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.plateCostRecord.bean.BaseStrikeABalance;
import pomplatform.plateCostRecord.bean.ConditionStrikeABalance;
import pomplatform.plateCostRecord.query.QueryStrikeABalance;
import pomplatform.reimbursement.bean.BaseGetReimbursementCost;
import pomplatform.reimbursement.bean.ConditionGetReimbursementCost;
import pomplatform.reimbursement.query.QueryGetReimbursementCost;
import pomplatform.reimbursementpackage.bean.BaseNewReimbursementPackage;
import pomplatform.reimbursementpackage.bean.CustomBaseNewReimbursementPackage;

/**
 * 
 * @Title: ReimbursementPackageProcessor.java 
 * @Package pomplatform.reimbursementpackage.business 
 * @Description: 打包功能处理模块控制类(含打印数据获取)
 * @author CL  
 * @date 2017年2月22日
 */
public class ReimbursementPackageProcessor implements GenericProcessor ,  GenericDownloadProcessor{
	
	private final static String ADD_PACKAGE = "addPackage"; //财务经理进行报销单打包
	
	private final static String UPDATE_BALANCE_AMOUNT = "updateBalanceAmount";//修改冲账金额
	
	private final static String GET_PACKAGE_DETAIL_BY_ID = "getPackageDetailById";//根据打包ID获取打包主数据
	
	private final static String DELETE_PACKAGE = "deletePackage";//删除打包数据
	
	private final static String SUBMIT_PACKAGE = "submitPackage";//财务出纳审核审批通过打包数据
	
	private final static String GET_PACKAGE_DETAIL_BY_PACKAGEID = "getPackageDetailByPackageId";//根据打包的主键获取打包的详情信息
	
	private final static String GET_PACKAGE_SUMMARY_BY_PACKAGEID = "getPackageSummaryByPackageId";//根据打包的主键获取打包的汇总信息
	
	private final static String GET_BILL_LIST_BY_REIMBURSEMENT = "getBillListByReimbursement";//根据报销单获取账单流水
	
	private final static String GET_REIMBURSEMENTS_BY_PACAKGE_ID = "getReimbursementsByPacakgeId";// 根据打包数据查询出所有报销单的数据(包含所有审批人与财务会计的数据)
	
	private final static String GET_SUBJECT_BY_PACKAGE_ID = "getSubjectByPackageId";//根据打包的主键获取出所有科目的汇总数据(汇总依据需要追溯到第二级的科目)
	
	private final static String GET_REIMBURSEMENT_BY_SCAN_CODE = "getReimbursementByScanCode";//根据扫描的条形码号获取真正的报销编号后
	
	private final static String GET_PACKAGEID_BY_SUMMARYID = "getPackageidBySummaryid";//根据汇总详情的ID查询出打包的Id
	
	private final static String COMPLETED_UPDATE_SUMMARY = "completedUpdateSummary";//修改完成的打包汇总的
	
	private final static String SPLIT_ADD_PACKAGE = "splitAddPackage";//分开打包
	
	private final static String VIEW_MAKE_BILL = "viewMakeBill";//查看制单情况
	
	private final static String CMBC_PAY = "cmbcPay";//银企直连支付
	
	private final static String DEAL_WITH_DRAW = "dealWithDraw";//处理退单
	
	private final static String REPLAY_PAY_WITHDRAW = "replayPayWithdraw";//对退单的重新发起单进行支付
	
	private final static String UPDATE_PAYDATA_REPAY_DEFEAT_DRAW = "updatePaydataRepayDefeatDraw";//修改失败的支付单后直接重新支付
	
	private final static String GET_PAYMENT_PROVINCE_AND_CITY = "getPaymentProvinceAndCity";//获取支付信息的收款方的省和城市的数据
	
	private final static String UPDATE_NUSAGE_OR_BUSNAR = "updateNusageOrBusnar";//根据详情主键修改摘要和备注
	
	private final static String UPDATE_SUMMARY_PAYMENT_INFO = "updateSummaryPaymentInfo";//打包汇总单(在制单与通过审核前)修改付款方数据
	
	public final static BigDecimal MAX_MONEY = new BigDecimal("190000");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
			switch (opt_type) {
				case ADD_PACKAGE:
					return addPackage(params);
				case UPDATE_BALANCE_AMOUNT:
					return updateBalanceAmount(params);
				case GET_PACKAGE_DETAIL_BY_PACKAGEID:
					return getPackageDetailByPackageId(params);
				case GET_PACKAGE_SUMMARY_BY_PACKAGEID:
					return getPackageSummaryByPackageId(params);
				case SUBMIT_PACKAGE:
					return submitPackage(params);
				case DELETE_PACKAGE:
					return deletePackage(params);
				case GET_BILL_LIST_BY_REIMBURSEMENT:
					return getBillListByReimbursement(params);
				case GET_PACKAGE_DETAIL_BY_ID:
					return getPackageDetailById(params);
				case GET_REIMBURSEMENTS_BY_PACAKGE_ID:	
					return getReimbursementsByPacakgeId(params);
				case GET_SUBJECT_BY_PACKAGE_ID:
					return getSubjectByPackageId(params);
				case GET_REIMBURSEMENT_BY_SCAN_CODE:
					return getReimbursementByScanCode(params);
				case GET_PACKAGEID_BY_SUMMARYID:
					return getPackageidBySummaryid(params);
				case COMPLETED_UPDATE_SUMMARY:
					return completedUpdateSummary(params);
				case SPLIT_ADD_PACKAGE:
					return splitAddPackage(params);
				case VIEW_MAKE_BILL:	
					return viewMakeBill(params);
				case CMBC_PAY:
					return cmbcPay(params);
				case DEAL_WITH_DRAW:
					return dealWithDraw(params);
				case REPLAY_PAY_WITHDRAW:
					return replayPayWithdraw(params);
				case UPDATE_PAYDATA_REPAY_DEFEAT_DRAW:
					return updatePaydataRepayDefeatDraw(params);
				case GET_PAYMENT_PROVINCE_AND_CITY:
					return getPaymentProvinceAndCity(params);
				case UPDATE_NUSAGE_OR_BUSNAR:
					return updateNusageOrBusnar(params);
				case UPDATE_SUMMARY_PAYMENT_INFO:
					return updateSummaryPaymentInfo(params);
				default:
					break;
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}
	
	/**
	 * 打包汇总单(在制单与通过审核前)修改付款方数据
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String updateSummaryPaymentInfo(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = "";

		ThreadConnection.beginTransaction();
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//操作人ID
		List<BaseReimbursementPackageSummary> summaryList = GenericBase.__getList(
				params.get("records"), BaseReimbursementPackageSummary.newInstance());
		
		if(packageId > 0 && null != summaryList && summaryList.size() > 0){
			Date currentDate = new Date();
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setReimbursementPackageId(packageId);
			if(rpDao.load() && !rpDao.getIsCompleted()){
				if(rpDao.getPayStatus() == 1){
					//获取打包详情数据
					ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
					rpdDao.setConditionReimbursementPackageId("=", packageId);
					List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
					ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
					//先处理需要修改的数据
					for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
						rpsDao.clear();
						rpsDao.setConditionReimbursementPackageSummaryId("=", baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
						rpsDao.setOtherName(baseReimbursementPackageSummary.getOtherName());
						rpsDao.setOtherBankName(baseReimbursementPackageSummary.getOtherBankName());
						rpsDao.setOtherBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
						rpsDao.setUpdateTime(currentDate);
						rpsDao.conditionalUpdate();
					}
					//修改账单流水的的数据  回填   冲账金额、付款方、付款账号、付款银行地址
					ProcessBillList pblDao = new ProcessBillList();
					
					for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
						int proceessBillListId = baseReimbursementPackageDetail.getProcessBillListId();
						String __bankAccount = baseReimbursementPackageDetail.getSelfBankAccount();
						Integer otherName = null;//付款方
						String otherBankName = null;//付款账号银行名称
						String otherBankAccount = null;//付款账号
						//获取付款方信息
						for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
							if(baseReimbursementPackageSummary.getSelfBankAccount().equals(__bankAccount)){
								otherName = baseReimbursementPackageSummary.getOtherName();
								otherBankName = baseReimbursementPackageSummary.getOtherBankName();
								otherBankAccount = baseReimbursementPackageSummary.getOtherBankAccount();
								break;
							}
						}
						pblDao.clear();
						pblDao.setProcessBillListId(proceessBillListId);
						if(pblDao.load()){
							pblDao.setOtherName(otherName);
							pblDao.setOtherBankName(otherBankName);
							pblDao.setOtherBankAccount(otherBankAccount);
							pblDao.setBalanceAmount(baseReimbursementPackageDetail.getStrikeABalanceAmount());
							pblDao.setPayMoney(baseReimbursementPackageDetail.getPaymentAmount());
							pblDao.update();
						}
					}
				}else{
					status = -1;
					errorMsg = "该单已制单或已提交支付不可修改付款方数据";
				}
				
			}else{
				status = -1;
				errorMsg = "此打包单不存在或该打包单已经完成 packageId= " + packageId;
			}
			
		}else{
			status = -1;
			errorMsg = "参数错误";
		}
		ThreadConnection.commit();
	
		
		
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 根据付款详情表主键修改摘要和备注
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String updateNusageOrBusnar(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		
		int cmbcPayDetailId = BaseHelpUtils.getIntValue(params, "cmbcPayDetailId");
		CmbcPayDetail cpdDao = new CmbcPayDetail();
		cpdDao.setCmbcPayDetailId(cmbcPayDetailId);
		if(cpdDao.load()){
			CmbcPayment dao = new CmbcPayment();
			dao.setCmbcPaymentId(cpdDao.getCmbcPaymentId());
			if(dao.load() && (dao.getPayStatus() == 1 || dao.getPayStatus() == 0)){
				BaseCmbcPayDetail cpdBean = new BaseCmbcPayDetail();
				cpdBean.setDataFromMap(params);
				
				cpdDao.setNusage(cpdBean.getNusage());
				cpdDao.setBusnar(cpdBean.getBusnar());
				cpdDao.setCrtbnk(cpdBean.getCrtbnk());
				cpdDao.update();
				
			}else{
				status = -1;
				errorMsg = "数据错误(没有查到主数据或主数据不符合要求) cmbcPayDetailId = " + cmbcPayDetailId;
			}
		}else{
			status = -1;
			errorMsg = "数据错误 cmbcPayDetailId = " + cmbcPayDetailId;
		}
		
		return bc.toJSON(status, errorMsg);
	}
	
	private String getPaymentProvinceAndCity(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = "";
		
		int cmbcPaymentId = BaseHelpUtils.getIntValue(params, "cmbcPaymentId");
		BaseCollection<BaseReceiveUnitManage> bc = new BaseCollection<>();

		CmbcPayment cpDao = new CmbcPayment();
		cpDao.setCmbcPaymentId(cmbcPaymentId);
		if(cpDao.load()){
			CmbcPayDetail cpdDao = new CmbcPayDetail();
			cpdDao.setConditionCmbcPaymentId("=", cmbcPaymentId);
			if(null != cpdDao.executeQueryOneRow()){
				
				Area aDao = new Area();
				aDao.addCondition(BaseArea.CS_AREA_NAME, "in", new Object[]{cpdDao.getCrtpvc(), cpdDao.getCrtcty()});
				List<BaseArea> areaList = aDao.conditionalLoad();
				BaseReceiveUnitManage bean = new BaseReceiveUnitManage();

				for (BaseArea baseArea : areaList) {
					if(baseArea.getAreaName().equals(cpdDao.getCrtpvc())){
						bean.setProvince(baseArea.getAreaId());
					}else if(baseArea.getAreaName().equals(cpdDao.getCrtcty())){
						bean.setCity(baseArea.getAreaId());
					}
				}
				
				List<BaseReceiveUnitManage> list = new ArrayList<>();
				
				list.add(bean);
				bc.setCollections(list);
				
			}else{
				status = -1;
				errorMsg = "数据错误没有找到子数据 cmbcPaymentId =" + cmbcPaymentId;
			}
		}else{
			status = -1;
			errorMsg = "数据错误 cmbcPaymentId =" + cmbcPaymentId;
		}
		
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 直接失败的单直接重新支付
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String updatePaydataRepayDefeatDraw(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		
		int cmbcPaymentId = BaseHelpUtils.getIntValue(params, "cmbcPaymentId");
		int crtpvc = BaseHelpUtils.getIntValue(params, "crtpvc");
		int crtcty = BaseHelpUtils.getIntValue(params, "crtcty");
		
		if(crtpvc > 0 && crtcty > 0 && cmbcPaymentId > 0){
			CmbcPayment cpDao = new CmbcPayment();
			cpDao.setCmbcPaymentId(cmbcPaymentId);
			if(cpDao.load()){
				if(cpDao.getType() == 1){
					if(cpDao.getPayStatus() == 1){
						Area aDao = new Area();
						aDao.addCondition(BaseArea.CS_AREA_ID, "in", crtpvc, crtcty);
						List<BaseArea> areaList = aDao.conditionalLoad();
						
						if(areaList.size() == 2){
							String crtpvcStr = "";
							String crtctyStr = "";
							for (BaseArea baseArea : areaList) {
								if(Objects.equals(baseArea.getAreaId(), crtpvc)){
									crtpvcStr = baseArea.getAreaName();
								}else if(Objects.equals(baseArea.getAreaId(), crtcty)){
									crtctyStr = baseArea.getAreaName();
								}
							}
							//更新收款单位的数据
							ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
							rpsDao.setConditionCmbcPaymentId("=", cmbcPaymentId);
							if(null != rpsDao.executeQueryOneRow() && rpsDao.getPayFor() == 2
									&& rpsDao.getEmployeeOrCompanyId() > 0){
								ReceiveUnitManage rumDao = new ReceiveUnitManage();
								rumDao.setReceiveUnitManageId(rpsDao.getEmployeeOrCompanyId());
								if(rumDao.load()){
									rumDao.setProvince(crtpvc);
									rumDao.setCity(crtcty);
									rumDao.update();
								}
							}
							
							//更新支付详细单的数据 且提交支付
							CmbcPayDetail cpdDao = new CmbcPayDetail();
							cpdDao.setConditionCmbcPaymentId("=", cmbcPaymentId);
							if(null != cpdDao.executeQueryOneRow()){
								cpdDao.setCrtpvc(crtpvcStr);
								cpdDao.setCrtcty(crtctyStr);
								cpdDao.update();
								ReimbursementPackageCmbPayUtil.repayDefeatDraw(cmbcPaymentId);
							}else{
								status = -1;
								errorMsg = "没有查到支付单的详情数据 cmbcPaymentId = " + cmbcPaymentId;
							}
						}else{
							status = -1;
							errorMsg = "省或城市没有找到数据 crtpvc= " + crtpvc + " -- crtcty=" + crtcty;
						}
						
						
					}else{
						status = -1;
						errorMsg = "该单不为失败的单子";
					}
				}else{
					status = -1;
					errorMsg = "只能对重新发起类型[支付]失败的单";
				}
			}else{
				status = -1;
				errorMsg = "参数错误";
			}
		}else{
			status = -1;
			errorMsg = "参数错误";
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 对退单的重新发起单进行支付
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String replayPayWithdraw(Map<String, Object> params) throws Exception{
		int cmbcPayDetailId = BaseHelpUtils.getIntValue(params, "cmbcPayDetailId");
		return ReimbursementPackageCmbPayUtil.cmbcWithdrawPay(cmbcPayDetailId);
	}

	/**
	 * 对退单的支付单重新发起制单
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String dealWithDraw(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = null;
		int cmbcPayDetailId = BaseHelpUtils.getIntValue(params, "cmbcPayDetailId");
		if(cmbcPayDetailId > 0){
			CmbcPayDetail cpdDao = new CmbcPayDetail();
			cpdDao.setCmbcPayDetailId(cmbcPayDetailId);
			if(cpdDao.load()){
				if(cpdDao.getStatus() == 5){//判断是否为退单状态
					cpdDao.setStatus(6);//设置为退单已处理状态
					cpdDao.update();
					//重新制作新的支付单
					BaseCmbcPayDetail cpdBean = cpdDao.generateBase();
					cpdBean.setWithdrawOriginId(cpdBean.getCmbcPayDetailId());
					cpdBean.setWithdrawFlag(ReimbursementPackageCmbPayUtil.WITHDRAW_FLAG_2);
					cpdBean.setTotalAmount(cpdBean.getTrsamt());
					cpdBean.setTotalNum(1);
					cpdBean.setStatus(1);//设置为数据录入状态
					cpdDao.clear();
					cpdDao.setDataFromBase(cpdBean);
					cpdDao.save();
					cpdDao.setYurref(cpdBean.getYurref() + "-" + cpdDao.getCmbcPayDetailId());
					cpdDao.update();
				}else{
					status = -1;
					errorMsg = String.format("cmbcPayDetailId[%1$s]改单不处于退单状态", cmbcPayDetailId);
				}
			}else{
				status = -1;
				errorMsg = String.format("cmbcPayDetailId[%1$s]参数错误", cmbcPayDetailId);
			}
		}else{
			status = -1;
			errorMsg = String.format("cmbcPayDetailId[%1$s]参数错误", cmbcPayDetailId);
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	private String cmbcPay(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		ReimbursementPackage rpDao = new ReimbursementPackage();
		rpDao.setReimbursementPackageId(packageId);
		if(rpDao.load()){
			if(rpDao.getPayStatus() == ReimbursementPackageCmbPayUtil.PAY_STATUS_1){
				status = -1;
				errorMsg = "请先制单";
			}else if(rpDao.getPayStatus() == ReimbursementPackageCmbPayUtil.PAY_STATUS_2){
				return ReimbursementPackageCmbPayUtil.cmbcPay(packageId);
			}
		}
		return bc.toJSON(status, errorMsg);
	}
	
	private String viewMakeBill(Map<String, Object> params) throws Exception{
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		ReimbursementPackage rpDao = new ReimbursementPackage();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = "";
		rpDao.setReimbursementPackageId(packageId);
		if(rpDao.load()){
			if(Objects.equals(rpDao.getPayStatus(), ReimbursementPackageCmbPayUtil.PAY_STATUS_1)){
				return ReimbursementPackageCmbPayUtil.makeBill(packageId);
			}
		}
		return bc.toJSON(status, errorMsg);
	}
	
	
	/**
	 * 
	 * @Title: splitAddPackage 
	 * @Description: 报销单分别打包
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String splitAddPackage(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		int operatorId = BaseHelpUtils.getIntValue(params, "operatorId");//操作人ID
//		int roleId = BaseHelpUtils.getIntValue(params, "role");//可操作角色Id
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//可操作人员Id
		String remark = BaseHelpUtils.getStringValue(params, "remark");
		List<BaseNewReimbursementPackage> __list = GenericBase.__getList(
				params.get("records"), BaseNewReimbursementPackage.newInstance());
		if(null != __list && __list.size() > 0){
			for (BaseNewReimbursementPackage baseNewReimbursementPackage : __list) {
				List<BaseNewReimbursementPackage> list = new ArrayList<>();
				list.add(baseNewReimbursementPackage);
				if(null != list && !list.isEmpty()){
					BigDecimal packagePayAmount = BigDecimal.ZERO;
					BigDecimal packageBlanceAmount = BigDecimal.ZERO;
					Date currentDate = new Date();
					Integer companyId = list.get(0).getCompanyId();
					ReimbursementPackage rpDao = new ReimbursementPackage();
					rpDao.setPackageSize(1);
					rpDao.setCreateTime(currentDate);
					rpDao.setCompanyId(companyId);
					rpDao.setOperatorId(operatorId);
					// roleId --> 37 : 财务出纳 ,  49 ：财务出纳（武汉）, 50:财务出纳(北京), 51：财务出纳(大连), 52:财务出纳(上海) 
					int roleId = 37;
//					switch (companyId) {
//					case 0://杰恩
//					case 1://博普森
//					case 2://姜峰
//					case 3://杰加
//					case 8://杰拓
//					case 9://姜峰室内设计(香港)有限公司
//						roleId = 37;
//						break;
//					case 4://武汉
//						roleId = 49;
//						break;
//					case 6://北京
//					case 12://北京
//						roleId = 50;
//						break;
//					case 7://大连
//					case 10://大连
//						roleId = 51;
//						break;
//					case 5://上海
//					case 13:
//						roleId = 52;
//						break;
//					}
					rpDao.setRoleId(roleId);
					rpDao.setRemark(remark);
					rpDao.setEmployeeId(employeeId);
					rpDao.save();
					int packageId = rpDao.getReimbursementPackageId();
					//查询出所选报销单的操作流水
					List<BaseReimbursementPackageDetail> detailList = new ArrayList<>();
					ProcessBillList pbDao = new ProcessBillList();
					for(BaseNewReimbursementPackage obj : list){
						pbDao.clear();
						pbDao.setConditionBusinessId("=", obj.getBusinessId());
						pbDao.setConditionProcessType("=", obj.getProcessType());
						List<BaseProcessBillList> pbList = pbDao.conditionalLoad();
						if(pbList.size() <= 0){
							ThreadConnection.rollback();
							throw  new SQLException("在打包的报销单中含有没有添加账单流水的报销单,不允许打包");
						}
						for (BaseProcessBillList baseProcessBillList : pbList) {
							BaseReimbursementPackageDetail tmpBean = new BaseReimbursementPackageDetail();
							tmpBean.setDataFromJSON(baseProcessBillList.toJSON());
							tmpBean.setCreateTime(currentDate);
							tmpBean.setProcessTypeId(obj.getProcessType());
							tmpBean.setDrafter(obj.getEmployeeId());
							tmpBean.setProcessId(obj.getProcessId());
							tmpBean.setProcessInstanceId(obj.getProcessInstanceId());
							tmpBean.setProcessBillListId(baseProcessBillList.getProcessBillListId());
							tmpBean.setStrikeABalanceAmount(baseProcessBillList.getBalanceAmount());
							tmpBean.setPaymentAmount(baseProcessBillList.getPayMoney());
							tmpBean.setReimbursementPackageId(packageId);
							tmpBean.setCode(obj.getCode());
							detailList.add(tmpBean);
						}
						//将4张表的报销单进行成功打包标志改变
						try {
							doPackage(obj.getProcessType(), obj.getBusinessId());
						} catch (SQLException e) {
							ThreadConnection.rollback();
							throw new SQLException("请勿重复打包");
						}
						
						
					}
					//银行账号汇总List
					List<String> bankAccountList = new ArrayList<>();
					//选取出银行账号进行数据汇总的根据
					for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
						String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
						if(!bankAccountList.contains(tempAccount)){
							bankAccountList.add(tempAccount);
						}
					}
					//数据汇总
					List<BaseReimbursementPackageSummary> packageSummaryList = new ArrayList<>();
					for (String string : bankAccountList) {
						String bankName = null;
						String reciveName = null;
						Integer payfor = null;
						Integer employeeOrCompanyId = null;
						BigDecimal __payAmount = BigDecimal.ZERO;//付款金额
						BigDecimal __blanceAmount = BigDecimal.ZERO;//冲账金额
						BaseReimbursementPackageSummary tmpPackageSummaryBean = new BaseReimbursementPackageSummary();
						//进行数据相加操作
						for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
							String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
							if(string.equals(tempAccount)){
								if(null != baseReimbursementPackageDetail.getPaymentAmount()){
									packagePayAmount = packagePayAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
									__payAmount = __payAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
								}
								if(null != baseReimbursementPackageDetail.getStrikeABalanceAmount()){
									packageBlanceAmount = packageBlanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
									__blanceAmount = __blanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
								}
								if(null == bankName && null ==reciveName && null == payfor){
									bankName = baseReimbursementPackageDetail.getSelfBankName();
									reciveName = baseReimbursementPackageDetail.getPayeeName();
									payfor = baseReimbursementPackageDetail.getPayFor();
									employeeOrCompanyId = baseReimbursementPackageDetail.getEmployeeOrCompanyId();
								}
								if(null == tmpPackageSummaryBean.getPayType() && null != baseReimbursementPackageDetail.getPayType()){
									tmpPackageSummaryBean.setPayType(baseReimbursementPackageDetail.getPayType());
								}
								if(null == tmpPackageSummaryBean.getCompanyId() && null != baseReimbursementPackageDetail.getCompanyId()){
									tmpPackageSummaryBean.setCompanyId(baseReimbursementPackageDetail.getCompanyId());
								}
								if(null == tmpPackageSummaryBean.getYear() && null != baseReimbursementPackageDetail.getYear()){
									tmpPackageSummaryBean.setYear(baseReimbursementPackageDetail.getYear());
								}
								if(null == tmpPackageSummaryBean.getMonth() && null != baseReimbursementPackageDetail.getMonth()){
									tmpPackageSummaryBean.setMonth(baseReimbursementPackageDetail.getMonth());
								}
								if(null == tmpPackageSummaryBean.getPersonnelBusinessId() && null != baseReimbursementPackageDetail.getPersonnelBusinessId()){
									tmpPackageSummaryBean.setPersonnelBusinessId(baseReimbursementPackageDetail.getPersonnelBusinessId());
								}
								if(null == tmpPackageSummaryBean.getEmployeeFundIssuanceId() && null != baseReimbursementPackageDetail.getEmployeeFundIssuanceId()) {
									tmpPackageSummaryBean.setEmployeeFundIssuanceId(baseReimbursementPackageDetail.getEmployeeFundIssuanceId());
								}
							}
						}
						tmpPackageSummaryBean.setAmount(__payAmount.add(__blanceAmount));
						tmpPackageSummaryBean.setPayeeName(reciveName);
						tmpPackageSummaryBean.setPayFor(payfor);
						tmpPackageSummaryBean.setEmployeeOrCompanyId(employeeOrCompanyId);
						tmpPackageSummaryBean.setCreateTime(currentDate);
						tmpPackageSummaryBean.setSelfBankAccount(string);
						tmpPackageSummaryBean.setSelfBankName(bankName);
						tmpPackageSummaryBean.setPaymentAmount(__payAmount);
						tmpPackageSummaryBean.setStrikeABalanceAmount(__blanceAmount);
						tmpPackageSummaryBean.setReimbursementPackageId(packageId);
						packageSummaryList.add(tmpPackageSummaryBean);
					}
					//由于公司签订协议  对于代发的每一笔金额不能大于10万 所以对于代发的需要进行分拆
					List<BaseReimbursementPackageSummary> finalSummaryList = new ArrayList<>();
					for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : packageSummaryList) {
						Integer payFor = baseReimbursementPackageSummary.getPayFor();
						BigDecimal payAmount = baseReimbursementPackageSummary.getPaymentAmount();
						BigDecimal strikeABalanceAmount = baseReimbursementPackageSummary.getStrikeABalanceAmount();
						if(null != payFor && payFor == 1 && null != payAmount && payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) > 0){
							boolean flag = true;
							int index = 0;
							while(flag){
								BaseReimbursementPackageSummary tmpSummaryBean = new BaseReimbursementPackageSummary();
								baseReimbursementPackageSummary.cloneCopy(tmpSummaryBean);
								tmpSummaryBean.setPaymentAmount(ReimbursementPackageProcessor.MAX_MONEY);
								if(null == strikeABalanceAmount || strikeABalanceAmount.compareTo(BigDecimal.ZERO) == 0){
									tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
								}else{
									if(index == 0){
										tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount().add(strikeABalanceAmount));
									}else{
										tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
										tmpSummaryBean.setStrikeABalanceAmount(BigDecimal.ZERO);
									}
								}
								finalSummaryList.add(tmpSummaryBean);
								payAmount = payAmount.subtract(ReimbursementPackageProcessor.MAX_MONEY);
								if(payAmount.compareTo(BigDecimal.ZERO) > 0){
									if(payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) <= 0){
										flag = false;
										BaseReimbursementPackageSummary finalSummaryBean = new BaseReimbursementPackageSummary();
										baseReimbursementPackageSummary.cloneCopy(finalSummaryBean);
										finalSummaryBean.setPaymentAmount(payAmount);
										finalSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
										finalSummaryBean.setStrikeABalanceAmount(BigDecimal.ZERO);
										finalSummaryList.add(finalSummaryBean);
									}
								}else{
									flag = false;
								}
								index ++;
							}
						}else{
							finalSummaryList.add(baseReimbursementPackageSummary);
						}
					}
					rpDao.setAmount(packagePayAmount.add(packageBlanceAmount));
					rpDao.setPaymentAmount(packagePayAmount);
					rpDao.setStrikeABalanceAmount(packageBlanceAmount);
					rpDao.setCode(getBarCode(packageId));
					rpDao.update();
					//插入详情数据
					ReimbursementPackageDetail rpDdao = new ReimbursementPackageDetail();
					rpDdao.save(detailList);
					//插入详情汇总数据
					ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
					rpsDao.save(finalSummaryList);
				} else {
					throw  new SQLException("参数错误  打包失败");
				}
			}
		}
		
		
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: completedUpdateSummary 
	 * @Description: 完成后修改打包汇总详情
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String completedUpdateSummary(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//操作人ID
		List<BaseReimbursementPackageSummary> summaryList = GenericBase.__getList(
				params.get("records"), BaseReimbursementPackageSummary.newInstance());
		
		if(employeeId > 0 && packageId > 0 && null != summaryList && summaryList.size() > 0){
			Date currentDate = new Date();
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setReimbursementPackageId(packageId);
			if(rpDao.load()){
				Capital cDao = new Capital();//完成后将汇总付款的流向资金表
				ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
				//先处理需要修改的数据
				for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
					rpsDao.clear();
					rpsDao.setConditionReimbursementPackageSummaryId("=", baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
					rpsDao.setOtherName(baseReimbursementPackageSummary.getOtherName());
					rpsDao.setOtherBankName(baseReimbursementPackageSummary.getOtherBankName());
					rpsDao.setOtherBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
					rpsDao.setIsCompleted(true);
					rpsDao.setUpdateTime(currentDate);
					rpsDao.conditionalUpdate();
					if(!BaseHelpUtils.isNullOrEmpty(baseReimbursementPackageSummary.getOtherBankAccount())){
						BaseCapital bean = new BaseCapital();
						bean.setHappenDate(null == baseReimbursementPackageSummary.getUpdateTime() ? currentDate : baseReimbursementPackageSummary.getUpdateTime() );
						bean.setCreateDate(currentDate);
						bean.setLoanMoney(baseReimbursementPackageSummary.getPaymentAmount());
						bean.setOtherName(baseReimbursementPackageSummary.getPayeeName());
						bean.setSelfBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
						bean.setSelfName(baseReimbursementPackageSummary.getOtherName());
						bean.setSelfBankName(baseReimbursementPackageSummary.getOtherBankName());
						bean.setOtherBankAccount(baseReimbursementPackageSummary.getSelfBankAccount());
						bean.setOtherBankName(baseReimbursementPackageSummary.getSelfBankName());
						bean.setReimbursementPackageSummaryId(baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
						bean.setOperator(employeeId);
						bean.setCapitalType(2);//表示资金为流出
						
						cDao.clear();
						cDao.setConditionReimbursementPackageSummaryId("=", baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
						if(null == cDao.executeQueryOneRow()){
							cDao.clear();
							cDao.setDataFromBase(bean);
							cDao.save();
						} else {
							cDao.setSelfName(baseReimbursementPackageSummary.getOtherName());
							cDao.setSelfBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
							cDao.setSelfBankName(baseReimbursementPackageSummary.getOtherBankName());
							cDao.update();
						}
					}
				}
				//获取打包详情数据
				ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
				rpdDao.setConditionReimbursementPackageId("=", packageId);
				List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
				
				//修改账单流水的的数据  回填   冲账金额、付款方、付款账号、付款银行地址
				ProcessBillList pblDao = new ProcessBillList();
				
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
					int proceessBillListId = baseReimbursementPackageDetail.getProcessBillListId();
					String __bankAccount = baseReimbursementPackageDetail.getSelfBankAccount();
					Integer otherName = null;//付款方
					String otherBankName = null;//付款账号银行名称
					String otherBankAccount = null;//付款账号
					//获取付款方信息
					for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
						if(baseReimbursementPackageSummary.getSelfBankAccount().equals(__bankAccount)){
							otherName = baseReimbursementPackageSummary.getOtherName();
							otherBankName = baseReimbursementPackageSummary.getOtherBankName();
							otherBankAccount = baseReimbursementPackageSummary.getOtherBankAccount();
							break;
						}
					}
					pblDao.clear();
					pblDao.setProcessBillListId(proceessBillListId);
					if(pblDao.load()){
//						pblDao.setIsComplete(true);//改成通过流程  账单流水通过
						pblDao.setOtherName(otherName);
						pblDao.setOtherBankName(otherBankName);
						pblDao.setOtherBankAccount(otherBankAccount);
						pblDao.setBalanceAmount(baseReimbursementPackageDetail.getStrikeABalanceAmount());
						pblDao.update();
					}
				}
				
			}else{
				status = -1;
				errorMsg = "此打包单不存在 packageId= " + packageId;
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
	 * @Title: getPackageidBySummaryid 
	 * @Description: 根据汇总详情的ID查询出打包的Id
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPackageidBySummaryid(Map<String, Object> params) throws Exception{
		int pacakgeId = -1;
		int summaryId = BaseHelpUtils.getIntValue(params, "summaryId");
		ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
		rpsDao.setReimbursementPackageSummaryId(summaryId);
		if(rpsDao.load()){
			pacakgeId = rpsDao.getReimbursementPackageId();
		}
		return pacakgeId + "";
	}
	
	/**
	 * 
	 * @Title: getReimbursementByScanCode 
	 * @Description: 根据扫描枪的扫入的编码获取出真实的报销编号且查询出该报销编号对应的报销单
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getReimbursementByScanCode(Map<String, Object> params) throws Exception{
		BaseCollection<BaseNewReimbursementPackage> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		String code = BaseHelpUtils.getStringValue(params, "code");
		if(!BaseHelpUtils.isNullOrEmpty(code)){
//			//获取出真实的报销单单号
//			String codePrefix = scanCode.substring(0, 6);
//			if(codePrefix.substring(0, 1).equals("8")){
//				codePrefix = codePrefix.substring(1);
//			}
//			String codeSuffix = scanCode.substring(7, 12);
//			String code = codePrefix + "-" + codeSuffix;
			
			//根据code  去4张表检索出具体报销信息且确定该报销的类型
			int processType = 0;//报销类型
			BaseNewReimbursementPackage dataBean = new BaseNewReimbursementPackage();//最终数据
			
			//借款
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionCode("=", code);
			//预付款
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setConditionCode("=", code);
			//日常
			ProjectNormalReimbursement pnrDao = new ProjectNormalReimbursement();
			pnrDao.setConditionCode("=", code);
			//差旅
			TravelReimbursement trbDao = new TravelReimbursement();
			trbDao.setConditionCode("=", code);
			
			if(null != emmDao.executeQueryOneRow()){//借款检测
				if(emmDao.getBePacked()){
					throw new SQLException("该报销单已经被打包 code = " + code);
				} else {
					processType = StaticUtils.PROCESS_TYPE_6;
					dataBean.setCode(emmDao.getCode());
					dataBean.setBusinessId(emmDao.getEmployeeMoneyManageId());
					dataBean.setCompanyId(emmDao.getCompanyId());
					dataBean.setDepartmentId(emmDao.getDepartmentId());
					dataBean.setEmployeeId(emmDao.getEmployeeId());
					dataBean.setAmount(emmDao.getBorrowMoney());
				}
				
			} else if (null != pmmDao.executeQueryOneRow()){//预付款检测 
				if(pmmDao.getBePacked()){
					throw new SQLException("该报销单已经被打包 code = " + code);
				} else {
					processType = StaticUtils.PROCESS_TYPE_7;
					dataBean.setCode(pmmDao.getCode());
					dataBean.setBusinessId(pmmDao.getPayMoneyManageId());
					dataBean.setCompanyId(pmmDao.getCompanyId());
					dataBean.setDepartmentId(pmmDao.getDepartmentId());
					dataBean.setEmployeeId(pmmDao.getEmployeeId());
					dataBean.setAmount(pmmDao.getPayAmount());
				}
				
			} else if (null != pnrDao.executeQueryOneRow()){
				if(pnrDao.getBePacked()){
					throw new SQLException("该报销单已经被打包 code = " + code);
				} else {
					int businessId = pnrDao.getProjectNormalReimbursementId();
					//检测属于哪种报销
					SystemProcessInstance spiDao = new SystemProcessInstance();
					spiDao.setConditionBusinessId("=", businessId);
					spiDao.addCondition("process_type", "in", StaticUtils.PROCESS_TYPE_2, StaticUtils.PROCESS_TYPE_3, StaticUtils.PROCESS_TYPE_8, StaticUtils.PROCESS_TYPE_10);
					if(null != spiDao.executeQueryOneRow() && spiDao.getProcessStatus() == SystemProcessConstants.PROCESS_STATUS_WORKING){
						processType = spiDao.getProcessType();
						dataBean.setCode(pnrDao.getCode());
						dataBean.setDepartmentId(pnrDao.getDepartmentId());
						dataBean.setCompanyId(pnrDao.getCompanyId());
						dataBean.setEmployeeId(pnrDao.getEmployeeId());
						dataBean.setAmount(pnrDao.getAmount());
						dataBean.setBusinessId(spiDao.getBusinessId());
						dataBean.setProcessId(spiDao.getProcessId());
						dataBean.setProcessInstanceId(spiDao.getProcessInstanceId());
						dataBean.setActivityType(spiDao.getProcessStatus());
					} else {
						throw new SQLException("该报销单被删除或者已经完成  spiId = " + spiDao.getProcessInstanceId());
					}
				}
				
			} else if (null != trbDao.executeQueryOneRow()){
				if(trbDao.getBePacked()){
					throw new SQLException("该报销单已经被打包 code = " + code);
				} else {
					int businessId = trbDao.getTravelReimbursementId();
					//检测属于哪种报销
					SystemProcessInstance spiDao = new SystemProcessInstance();
					spiDao.setConditionBusinessId("=", businessId);
					spiDao.addCondition("process_type", "in", StaticUtils.PROCESS_TYPE_4, StaticUtils.PROCESS_TYPE_5, StaticUtils.PROCESS_TYPE_9);
					if(null != spiDao.executeQueryOneRow() && spiDao.getProcessStatus() == SystemProcessConstants.PROCESS_STATUS_WORKING){
						processType = spiDao.getProcessType();
						dataBean.setCode(trbDao.getCode());
						dataBean.setDepartmentId(trbDao.getDepartmentId());
						dataBean.setCompanyId(trbDao.getCompanyId());
						dataBean.setEmployeeId(trbDao.getApplicant());
						dataBean.setAmount(trbDao.getAmount());
						dataBean.setBusinessId(spiDao.getBusinessId());
						dataBean.setProcessId(spiDao.getProcessId());
						dataBean.setProcessInstanceId(spiDao.getProcessInstanceId());
						dataBean.setActivityType(spiDao.getProcessStatus());
					} else {
						throw new SQLException("该报销单被删除或者已经完成  spiId = " + spiDao.getProcessInstanceId());
					}
				}
			} else {
				throw new SQLException("根据扫描单号没有检测到报销单 code = " + code);
			}
			dataBean.setProcessType(processType);
			if(processType == StaticUtils.PROCESS_TYPE_6 || processType == StaticUtils.PROCESS_TYPE_7){//借款和预付款流程数据查询
				SystemProcessInstance spiDao = new SystemProcessInstance();
				spiDao.setConditionBusinessId("=", dataBean.getBusinessId());
				spiDao.setConditionProcessType("=", processType);
				if(null != spiDao.executeQueryOneRow() && spiDao.getProcessStatus() == SystemProcessConstants.PROCESS_STATUS_WORKING){
					dataBean.setBusinessId(spiDao.getBusinessId());
					dataBean.setActivityId(spiDao.getProcessInstanceActivityId());
					dataBean.setProcessId(spiDao.getProcessId());
					dataBean.setProcessInstanceId(spiDao.getProcessInstanceId());
					dataBean.setActivityType(spiDao.getProcessStatus());
				} else {
					throw new SQLException("该报销单被删除或者已经完成  spiId = " + spiDao.getProcessInstanceId());
				}
			}
			//检测财务经理是否通过审批
			SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
			spiaDao.setConditionBusinessId("=", dataBean.getBusinessId());
			spiaDao.setConditionProcessType("=", dataBean.getProcessType());
			spiaDao.setConditionBackViewName("like", "%财务经理%");
			spiaDao.setConditionStatus("=", 2);
			spiaDao.addCondition("activity_type", "in", 2, 3);
			if(null == spiaDao.executeQueryOneRow()){
				throw new SQLException("财务经理还没有通过审核！不能添加 ");
			}
			
			List<BaseNewReimbursementPackage> list = new ArrayList<>();
			list.add(dataBean);
			bc.setCollections(list);
			
		}else{
			status = -1;
			errorMsg = "该单号参数错误  code ==" + code;
		}
		
		return bc.toJSON(status, errorMsg);
	}
	
	/**打印操作    数据统计操作   -------------------------------------------------------------------------------------begin */
	
	/**
	 * 
	 * @Title: getSubjectByPackageId 
	 * @Description: 根据打包主键获取所有的报销单下的科目信息且进行合并
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getSubjectByPackageId(Map<String, Object> params) throws Exception{
		BaseCollection<BaseProjectNormalReimbursementDetail> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setReimbursementPackageId(packageId);
		if(dao.load()){
			//查询打包详情表关联数据
			ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
			rpdDao.setConditionReimbursementPackageId("=", packageId);
			List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
			if(rpdList.size() > 0){
				List<String> ptIdAndBuId = new ArrayList<>();
				//去除重复的报销  
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
					String tmpKey = baseReimbursementPackageDetail.getProcessTypeId() + "-" + baseReimbursementPackageDetail.getBusinessId();
					if(!ptIdAndBuId.contains(tmpKey)){
						ptIdAndBuId.add(tmpKey);
					}
				}
				//统计数据放入
				List<BaseProjectNormalReimbursementDetail> dataList = new ArrayList<>();
				//获取所有报销中的科目数据
				getSubjectByReimbursement(ptIdAndBuId, dataList);
				bc.setCollections(dataList);
			}else{
				status = -1;
				errorMsg = "没有找到该打包下的详情数据  detailListSize = " + rpdList.size();
			}
		}else{
			status = -1;
			errorMsg = "没有查询该打包的报销单  packageId = " + packageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getSubjectByReimbursement 
	 * @Description: 根据报销单获取科目信息 且进行合并
	 * @param @param ids
	 * @param @param dataList
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	private void getSubjectByReimbursement(List<String> ids, List<BaseProjectNormalReimbursementDetail> dataList) throws Exception{
		//将所有的日常报销单的主键取出  去重
		List<Integer> idsList = new ArrayList<>();
		//去除所有差旅的主键取出  去重
		List<Integer> tlIdsList = new ArrayList<>();
		for (String str : ids) {
			String [] strArra = str.split("-"); 
			int processType = BaseHelpUtils.getIntValue(strArra[0]);
			int businessId = BaseHelpUtils.getIntValue(strArra[1]);
			switch (processType) {
			//日常报销
			case StaticUtils.PROCESS_TYPE_2:
			case StaticUtils.PROCESS_TYPE_3:
			case StaticUtils.PROCESS_TYPE_8:
			case StaticUtils.PROCESS_TYPE_10:
				Integer tmpId = businessId;
				if(!idsList.contains(tmpId)){
					idsList.add(tmpId);
				}
				break;
				//差旅报销
			case StaticUtils.PROCESS_TYPE_4:
			case StaticUtils.PROCESS_TYPE_5:
			case StaticUtils.PROCESS_TYPE_9:
				Integer __tmpId = businessId;
				if(!tlIdsList.contains(__tmpId)){
					tlIdsList.add(__tmpId);
				}
				break;
			}
		}
		//去除所有差旅的科目数据
		if(tlIdsList.size() > 0){
			Object [] paramsArra = new Object[tlIdsList.size()];
			for (int i = 0; i < tlIdsList.size(); i++) {
				paramsArra[i] = tlIdsList.get(i);
			}
			//查询有关所有差旅的费用进项统计
			BaseProjectNormalReimbursementDetail tmpBean = new BaseProjectNormalReimbursementDetail();
			TravelReimbursementDetail trdDao = new TravelReimbursementDetail();
			trdDao.addCondition("travel_reimbursement_id", "in", paramsArra);
			List<BaseTravelReimbursementDetail> trdList = trdDao.conditionalLoad();
			BigDecimal payAmount = BigDecimal.ZERO;
			for (BaseTravelReimbursementDetail baseTravelReimbursementDetail : trdList) {
				if(null != baseTravelReimbursementDetail.getSum()){
					payAmount = payAmount.add(baseTravelReimbursementDetail.getSum());
				}
			}
			tmpBean.setMainItemId(13);
			tmpBean.setAmount(payAmount);
			tmpBean.setSubItemId(0);
			dataList.add(tmpBean);
		}
		
		//取出所有科目的数据
		if(idsList.size() > 0){
			Object [] paramsArra = new Object[idsList.size()];
			for (int i = 0; i < idsList.size(); i++) {
				paramsArra[i] = idsList.get(i);
			}
			ProjectNormalReimbursementDetail prDao = new ProjectNormalReimbursementDetail();
			prDao.addCondition("project_normal_reimbursement_id", "in", paramsArra);
			List<BaseProjectNormalReimbursementDetail> list = prDao.conditionalLoad();
			//将科目数据进行统计
			//取出一二级科目进行统计合并
			if(list.size() > 0){
				List<String> idsStrList = new ArrayList<>();
				for (BaseProjectNormalReimbursementDetail baseProjectNormalReimbursementDetail : list) {
					int mainId = baseProjectNormalReimbursementDetail.getMainItemId();
					int subId = baseProjectNormalReimbursementDetail.getSubItemId();
					String tmpIdStr = mainId + "-" + subId;
					if(!idsStrList.contains(tmpIdStr)){
						idsStrList.add(tmpIdStr);
					}
				}
				//合并统计数据
				for (String string : idsStrList) {
					String [] tmpArra = string.split("-");
					int mainId = BaseHelpUtils.getIntValue(tmpArra[0]);
					int subId = BaseHelpUtils.getIntValue(tmpArra[1]);
					BaseProjectNormalReimbursementDetail tmpBean = new BaseProjectNormalReimbursementDetail();
					BigDecimal payAmount = BigDecimal.ZERO;
					String remarks = "";
					for (BaseProjectNormalReimbursementDetail baseProjectNormalReimbursementDetail : list) {
						int __mainId = baseProjectNormalReimbursementDetail.getMainItemId();
						int __subId = baseProjectNormalReimbursementDetail.getSubItemId();
						if(__mainId == mainId && __subId == subId){
							if(null != baseProjectNormalReimbursementDetail.getAmount()){
								payAmount = payAmount.add(baseProjectNormalReimbursementDetail.getAmount());
							}
							if(!BaseHelpUtils.isNullOrEmpty(baseProjectNormalReimbursementDetail.getRemark())){
								remarks += "----" + baseProjectNormalReimbursementDetail.getRemark();
							}
						}
					}
					tmpBean.setAmount(payAmount);
					tmpBean.setRemark(remarks);
					tmpBean.setMainItemId(mainId);
					tmpBean.setSubItemId(subId);
					dataList.add(tmpBean);
				}
			}
		}	
	}
	
	/**
	 * 
	 * @Title: getReimbursementsByPacakgeId 
	 * @Description: 根据打包的主键获取所有报销单的数据
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getReimbursementsByPacakgeId(Map<String, Object> params) throws Exception{
		BaseCollection<CustomBaseNewReimbursementPackage> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setReimbursementPackageId(packageId);
		if(dao.load()){
			//查询打包详情表关联数据
			ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
			rpdDao.setConditionReimbursementPackageId("=", packageId);
			List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
			if(rpdList.size() > 0){
				List<String> ptIdAndBuId = new ArrayList<>();
				//去除重复的报销  
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
					String tmpKey = baseReimbursementPackageDetail.getProcessTypeId() + "-" + baseReimbursementPackageDetail.getBusinessId();
					if(!ptIdAndBuId.contains(tmpKey)){
						ptIdAndBuId.add(tmpKey);
					}
				}
				//统计数据放入
				List<CustomBaseNewReimbursementPackage> dataList = new ArrayList<>();
				for (String string : ptIdAndBuId) {
					String [] strArra = string.split("-"); 
					int processType = BaseHelpUtils.getIntValue(strArra[0]);
					int businessId = BaseHelpUtils.getIntValue(strArra[1]);
					//获取所有报销包括审批人与财务会计的数据
					getReimbursementListFormFourTable(processType, businessId, dataList);
				}
				bc.setCollections(dataList);
			}else{
				status = -1;
				errorMsg = "没有找到该打包下的详情数据  detailListSize = " + rpdList.size();
			}
		}else{
			status = -1;
			errorMsg = "没有查询该打包的报销单  packageId = " + packageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getApproveName 
	 * @Description:  获取每一笔报销单的所有审批人与财务会计名称
	 * @param @param processType
	 * @param @param businessId
	 * @param @param bean
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	private void getApproveName(int processType, int businessId, CustomBaseNewReimbursementPackage bean) throws Exception{
		String approveName = "";
		String financeName = "";
		int findex = 0;
		int aindex = 0;
		SystemProcessInstanceActivity dao = new SystemProcessInstanceActivity();
		dao.setConditionBusinessId("=", businessId);
		dao.setConditionProcessType("=", processType);
		dao.addCondition("activity_type", "in", 2, 3);
		List<BaseSystemProcessInstanceActivity> list = dao.conditionalLoad("  order by next_activity_id");
		Employee emDao = new Employee();
		for (BaseSystemProcessInstanceActivity baseSystemProcessInstanceActivity : list) {
			if(null != baseSystemProcessInstanceActivity.getEmployeeId()){
				emDao.setEmployeeId(baseSystemProcessInstanceActivity.getEmployeeId());
				if(emDao.load()){
					if(null != baseSystemProcessInstanceActivity.getBackViewName() && baseSystemProcessInstanceActivity.getBackViewName().contains("财务")){
						if(baseSystemProcessInstanceActivity.getBackViewName().contains("财务会计")){
							if(findex != 0){
								financeName += ",";
							}
							financeName += emDao.getEmployeeName();
							findex ++;
						}
					}else{
						if(aindex != 0){
							approveName += ",";
						}
						approveName += emDao.getEmployeeName();
						aindex ++;
					}
				}
			}
		}
		bean.setApproveName(approveName);
		bean.setFinanceName(financeName);
	}
	
	/**
	 * 
	 * @Title: getInputTaxByReimbursement 
	 * @Description: 获取报销单的所有进项税
	 * @param @param processType
	 * @param @param businessId
	 * @param @return
	 * @param @throws Exception   
	 * @return BigDecimal   
	 * @throws
	 */
	private BigDecimal getInputTaxByReimbursement(int processType, int businessId) throws Exception{
		BigDecimal allInputTax = BigDecimal.ZERO;
		switch (processType) {
		//非前期项目跟项目有关
		case StaticUtils.PROCESS_TYPE_2://日常
			NormalReimbursementLinkProject nrlpDao = new NormalReimbursementLinkProject();
			nrlpDao.setConditionProjectNormalReimbursementId("=", businessId);
			List<BaseNormalReimbursementLinkProject> nrlpList = nrlpDao.conditionalLoad();
			for (BaseNormalReimbursementLinkProject baseNormalReimbursementLinkProject : nrlpList) {
				if(null != baseNormalReimbursementLinkProject.getInputTax()){
					allInputTax = allInputTax.add(baseNormalReimbursementLinkProject.getInputTax());
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_4://差旅
			TravelReimbursementLinkProject trlpDao = new TravelReimbursementLinkProject();
			trlpDao.setConditionTravelReimbursementId("=", businessId);
			List<BaseTravelReimbursementLinkProject> trlpList = trlpDao.conditionalLoad();
			for (BaseTravelReimbursementLinkProject baseTravelReimbursementLinkProject : trlpList) {
				if(null != baseTravelReimbursementLinkProject.getInputTax()){
					allInputTax = allInputTax.add(baseTravelReimbursementLinkProject.getInputTax());
				}
			}
			break;
		//普通跟部门有关
		case StaticUtils.PROCESS_TYPE_3://日常
		case StaticUtils.PROCESS_TYPE_10://公司日常
			NormalReimbursementLinkDepartment nrldDao = new NormalReimbursementLinkDepartment();
			nrldDao.setConditionProjectNormalReimbursementId("=", businessId);
			List<BaseNormalReimbursementLinkDepartment> nrldList = nrldDao.conditionalLoad();
			for (BaseNormalReimbursementLinkDepartment baseNormalReimbursementLinkDepartment : nrldList) {
				if(null != baseNormalReimbursementLinkDepartment.getInputTax()){
					allInputTax = allInputTax.add(baseNormalReimbursementLinkDepartment.getInputTax());
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_5://差旅
			TravelReimbursementLinkDepartment trldDao = new TravelReimbursementLinkDepartment();
			trldDao.setConditionTravelReimbursementId("=", businessId);
			List<BaseTravelReimbursementLinkDepartment> trldList = trldDao.conditionalLoad();
			for (BaseTravelReimbursementLinkDepartment baseTravelReimbursementLinkDepartment : trldList) {
				if(null != baseTravelReimbursementLinkDepartment.getInputTax()){
					allInputTax = allInputTax.add(baseTravelReimbursementLinkDepartment.getInputTax());
				}
			}
			break;
		//前期项目 与前期日常	
//		case StaticUtils.PROCESS_TYPE_8://前期项目日常	
//		case StaticUtils.PROCESS_TYPE_9://前期项目差旅
//			break;
//		//借款申请
//		case StaticUtils.PROCESS_TYPE_6:
//			break;
//		//预付款申请	
//		case StaticUtils.PROCESS_TYPE_7:
//			break;
		default:
			break;
		}
		return allInputTax;
	}
	
	/**
	 * 
	 * @Title: getReimbursementListFormFourTable 
	 * @Description: 从四张表获取出所有报销单的数据
	 * @param @param processType
	 * @param @param businessId
	 * @param @param dataList
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	private void getReimbursementListFormFourTable(int processType, int businessId, List<CustomBaseNewReimbursementPackage> dataList) throws Exception{
		switch (processType) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			ProjectNormalReimbursement prDao = new ProjectNormalReimbursement();
			prDao.setConditionProjectNormalReimbursementId("=", businessId);
			List<BaseProjectNormalReimbursement> prList = prDao.conditionalLoad();
			for (BaseProjectNormalReimbursement baseProjectNormalReimbursement : prList) {
				CustomBaseNewReimbursementPackage bean = new CustomBaseNewReimbursementPackage();
				bean.setAmount(baseProjectNormalReimbursement.getAmount());
				bean.setEmployeeId(baseProjectNormalReimbursement.getApplyEmployeeId());
				bean.setCode(baseProjectNormalReimbursement.getCode());
				bean.setCompanyId(baseProjectNormalReimbursement.getCompanyId());
				bean.setProcessType(processType);
				bean.setBusinessId(baseProjectNormalReimbursement.getProjectNormalReimbursementId());
				bean.setProcessComment(baseProjectNormalReimbursement.getRemark());
				bean.setInputTax(getInputTaxByReimbursement(processType, businessId));
				//设置审批人与复核人
				getApproveName(processType, businessId, bean);
				dataList.add(bean);
			}
			break;
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			TravelReimbursement trDao = new TravelReimbursement();
			trDao.setConditionTravelReimbursementId("=", businessId);
			List<BaseTravelReimbursement> trList = trDao.conditionalLoad();
			for (BaseTravelReimbursement baseTravelReimbursement : trList) {
				CustomBaseNewReimbursementPackage bean = new CustomBaseNewReimbursementPackage();
				bean.setAmount(baseTravelReimbursement.getAmount());
				bean.setEmployeeId(baseTravelReimbursement.getApplicant());
				bean.setCode(baseTravelReimbursement.getCode());
				bean.setCompanyId(baseTravelReimbursement.getCompanyId());
				bean.setProcessType(processType);
				bean.setBusinessId(baseTravelReimbursement.getTravelReimbursementId());
				bean.setProcessComment(baseTravelReimbursement.getRemark());
				bean.setInputTax(getInputTaxByReimbursement(processType, businessId));
				//设置审批人与复核人
				getApproveName(processType, businessId, bean);
				dataList.add(bean);
			}
			break;
		//借款申请
		case StaticUtils.PROCESS_TYPE_6:
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionEmployeeMoneyManageId("=", businessId);
			List<BaseEmployeeMoneyManage> emmList =emmDao.conditionalLoad();
			for (BaseEmployeeMoneyManage baseEmployeeMoneyManage : emmList) {
				CustomBaseNewReimbursementPackage bean = new CustomBaseNewReimbursementPackage();
				bean.setAmount(baseEmployeeMoneyManage.getBorrowMoney());
				bean.setEmployeeId(baseEmployeeMoneyManage.getEmployeeId());
				bean.setCode(baseEmployeeMoneyManage.getCode());
				bean.setCompanyId(baseEmployeeMoneyManage.getCompanyId());
				bean.setProcessType(processType);
				bean.setBusinessId(baseEmployeeMoneyManage.getEmployeeMoneyManageId());
				bean.setProcessComment(baseEmployeeMoneyManage.getReason());
				bean.setInputTax(getInputTaxByReimbursement(processType, businessId));
				//设置审批人与复核人
				getApproveName(processType, businessId, bean);
				dataList.add(bean);
			}
			break;
		//预付款申请	
		case StaticUtils.PROCESS_TYPE_7:
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setConditionPayMoneyManageId("=", businessId);
			List<BasePayMoneyManage> pmmList = pmmDao.conditionalLoad();
			for (BasePayMoneyManage basePayMoneyManage : pmmList) {
				CustomBaseNewReimbursementPackage bean = new CustomBaseNewReimbursementPackage();
				bean.setAmount(basePayMoneyManage.getPayAmount());
				bean.setEmployeeId(basePayMoneyManage.getEmployeeId());
				bean.setCode(basePayMoneyManage.getCode());
				bean.setCompanyId(basePayMoneyManage.getCompanyId());
				bean.setProcessType(processType);
				bean.setBusinessId(basePayMoneyManage.getPayMoneyManageId());
				bean.setProcessComment(basePayMoneyManage.getReason());
				bean.setInputTax(getInputTaxByReimbursement(processType, businessId));
				//设置审批人与复核人
				getApproveName(processType, businessId, bean);
				dataList.add(bean);
			}
			break;
		default:
			break;
		}
	}
	
	/**打印操作    数据统计操作  -------------------------------------------------------------------------------------end */
	
	
	/**
	 * 
	 * @Title: getPackageDetailById 
	 * @Description: 根据打包ID获取打包主数据
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPackageDetailById(Map<String, Object> params) throws Exception{
		BaseCollection<BaseReimbursementPackage> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		ReimbursementPackage dao = new ReimbursementPackage();
		dao.setReimbursementPackageId(packageId);
		if(dao.load()){
			List<BaseReimbursementPackage> list =  new ArrayList<>();
			BaseReimbursementPackage bean = new BaseReimbursementPackage();
			dao.setDataToBase(bean);
			list.add(bean);
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = "没有查询该打包的报销单  packageId = " + packageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getBillListByReimbursement 
	 * @Description: 根据报销单获取账单流水
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getBillListByReimbursement(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		BaseNewReimbursementPackage bean = new BaseNewReimbursementPackage();
		bean.setDataFromMap(params);
		ProcessBillList dao = new ProcessBillList();
		dao.setConditionProcessType("=", bean.getProcessType());
		dao.setConditionBusinessId("=", bean.getBusinessId());
		List<BaseProcessBillList> list =  dao.conditionalLoad();
		BaseCollection<BaseProcessBillList> bc = new BaseCollection<>();
		bc.setCollections(list);
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: deletePackage 
	 * @Description: 删除打包数据
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String deletePackage(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		if(packageId > 0){
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setReimbursementPackageId(packageId);
			if(rpDao.load()){
				if(!rpDao.getIsCompleted()){
					if(rpDao.getPayStatus() == 1){
						//将4张报销表的报销单解除打包锁定
						ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
						rpdDao.setConditionReimbursementPackageId("=", packageId);
						List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
						for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
							relievePackage(baseReimbursementPackageDetail.getProcessTypeId(), baseReimbursementPackageDetail.getBusinessId());
						}
						//删除两张子表的数据
						rpdDao.conditionalDelete();
						ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
						rpsDao.setConditionReimbursementPackageId("=", packageId);
						rpsDao.conditionalDelete();
						//删除主表数据
						rpDao.delete();
					}else{
						status = -1;
						errorMsg = "该打包信息已经制单或提交支付不可删除";
					}
					
				}else{
					status = -1;
					errorMsg = "该打包信息已经通过审批不能删除";
				}
			}else{
				status = -1;
				errorMsg = "参数错误  packageId = " + packageId;
			}
		}else{
			status = -1;
			errorMsg = "参数错误  packageId = " + packageId;
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: submitPackage 
	 * @Description: 财务出纳填写付款信息后 审批通过报销单
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String submitPackage(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//操作人ID
		List<BaseReimbursementPackageSummary> summaryList = GenericBase.__getList(
				params.get("records"), BaseReimbursementPackageSummary.newInstance());
		
		if(employeeId > 0 && packageId > 0 && null != summaryList && summaryList.size() > 0){
			Date currentDate = new Date();
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setReimbursementPackageId(packageId);
			if(rpDao.load() && !rpDao.getIsCompleted()){
				Capital cDao = new Capital();//完成后将汇总付款的流向资金表
				List<BaseCapital> cList = new ArrayList<>();
				ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
				//先处理需要修改的数据
				for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
					rpsDao.clear();
					rpsDao.setConditionReimbursementPackageSummaryId("=", baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
					rpsDao.setOtherName(baseReimbursementPackageSummary.getOtherName());
					rpsDao.setOtherBankName(baseReimbursementPackageSummary.getOtherBankName());
					rpsDao.setOtherBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
					rpsDao.setIsCompleted(true);
					rpsDao.setUpdateTime(currentDate);
					rpsDao.conditionalUpdate();
					if(!BaseHelpUtils.isNullOrEmpty(baseReimbursementPackageSummary.getOtherBankAccount())){
						BaseCapital bean = new BaseCapital();
						bean.setHappenDate(null == baseReimbursementPackageSummary.getUpdateTime() ? currentDate : baseReimbursementPackageSummary.getUpdateTime() );
						bean.setCreateDate(currentDate);
						bean.setLoanMoney(baseReimbursementPackageSummary.getPaymentAmount());
						bean.setOtherName(baseReimbursementPackageSummary.getPayeeName());
						bean.setSelfBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
						bean.setSelfName(baseReimbursementPackageSummary.getOtherName());
						bean.setSelfBankName(baseReimbursementPackageSummary.getOtherBankName());
						bean.setOtherBankAccount(baseReimbursementPackageSummary.getSelfBankAccount());
						bean.setOtherBankName(baseReimbursementPackageSummary.getSelfBankName());
						bean.setReimbursementPackageSummaryId(baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
						bean.setOperator(employeeId);
						bean.setCapitalType(2);//表示资金为流出
						cList.add(bean);
					}
				}
				//将数据插入到资金表
				if(cList.size()> 0){
					cDao.save(cList);
				}
				//获取打包详情数据
				ReimbursementPackageDetail rpdDao = new ReimbursementPackageDetail();
				rpdDao.setConditionReimbursementPackageId("=", packageId);
				List<BaseReimbursementPackageDetail> rpdList = rpdDao.conditionalLoad();
				
				//修改账单流水的的数据  回填   冲账金额、付款方、付款账号、付款银行地址
				ProcessBillList pblDao = new ProcessBillList();
				Set<String> bpIds = new HashSet<>();//将业务ID+业务ID拼接去重
				
				//将流程改为完成
				SystemProcessInstance spiDao = new SystemProcessInstance();
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : rpdList) {
					int proceessBillListId = baseReimbursementPackageDetail.getProcessBillListId();
					String __bankAccount = baseReimbursementPackageDetail.getSelfBankAccount();
					Integer otherName = null;//付款方
					String otherBankName = null;//付款账号银行名称
					String otherBankAccount = null;//付款账号
					//获取付款方信息
					for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
						if(baseReimbursementPackageSummary.getSelfBankAccount().equals(__bankAccount)){
							otherName = baseReimbursementPackageSummary.getOtherName();
							otherBankName = baseReimbursementPackageSummary.getOtherBankName();
							otherBankAccount = baseReimbursementPackageSummary.getOtherBankAccount();
							break;
						}
					}
					pblDao.clear();
					pblDao.setProcessBillListId(proceessBillListId);
					if(pblDao.load()){
						pblDao.setIsComplete(true);//改成通过流程  账单流水通过
						pblDao.setOtherName(otherName);
						pblDao.setOtherBankName(otherBankName);
						pblDao.setOtherBankAccount(otherBankAccount);
						pblDao.setBalanceAmount(baseReimbursementPackageDetail.getStrikeABalanceAmount());
						pblDao.update();
					}
					Integer businessId = baseReimbursementPackageDetail.getBusinessId();
					Integer processType = baseReimbursementPackageDetail.getProcessTypeId();
					
					spiDao.clear();
					spiDao.setCompleteTime(currentDate);
					spiDao.setProcessStatus(3);
					spiDao.setConditionProcessInstanceId("=", baseReimbursementPackageDetail.getProcessInstanceId());
					spiDao.conditionalUpdate();
					bpIds.add(businessId + "," + processType + "," + baseReimbursementPackageDetail.getDrafter() + "," + baseReimbursementPackageDetail.getCode());
				}
				
				String operatorName = SelectValueCache.getSelectValue("employees", String.valueOf(employeeId));
				StringBuilder sb = new StringBuilder();
				sb.append("【报销单消息提示】")
					.append("\r\n  申请人：%1$s")
					.append("\r\n  报销单号：%2$s")
					.append("\r\n  报销类型：%3$s")
					.append("\r\n  提示时间：")
					.append(DateUtil.formatDateTimeString(currentDate))
					.append("\r\n  消息：财务部(")
					.append(operatorName)
					.append(")已处理该报销单,请核对是否收到款")
					.append("\r\n 如有问题请联系财务部(")
					.append(operatorName)
					.append(")。");
				String sbStr = sb.toString();
				
				Employee employee = new Employee();
				employee.unsetSelectFlags();
				employee.setSelectEmployeeName(true);
				employee.setSelectCompanyWeixin(true);
				
				//修改流程实例数据  将需要进行审批的改成通过
				SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
				SystemProcessPooledTask spptDao = new SystemProcessPooledTask();
				for (String string : bpIds) {
					String arra[] = string.split(",");
					int businessId = BaseHelpUtils.getIntValue(arra[0]);
					int processType = BaseHelpUtils.getIntValue(arra[1]);
					int drafter = BaseHelpUtils.getIntValue(arra[2]);
					String code = arra[3];
					
					spiaDao.clear();
//					spiaDao.setConditionEmployeeId("=", employeeId);
					spiaDao.setConditionBusinessId("=", businessId);
					spiaDao.setConditionProcessType("=", processType);
					spiaDao.setConditionStatus("=", 1);
					if(null != spiaDao.executeQueryOneRow()) {
						if(null == spiaDao.getEmployeeId()) {
							spptDao.clear();
							spptDao.setConditionInstanceActivityId("=", spiaDao.getProcessInstanceActivityId());
							spptDao.setConditionEmployeeId("=", employeeId);
							if(spptDao.countRows() > 0) {
								spptDao.clear();
								spptDao.setConditionInstanceActivityId("=", spiaDao.getProcessInstanceActivityId());
								spptDao.setStatus(2);
								spptDao.setOperateTime(currentDate);
								spptDao.conditionalUpdate();
								
								spiaDao.setEmployeeId(employeeId);
								spiaDao.setOperateTime(currentDate);
								spiaDao.setStatus(2);
								spiaDao.update();
							}
						} else {
							if(Objects.equals(spiaDao.getEmployeeId(), employeeId)) {
								spiaDao.setOperateTime(currentDate);
								spiaDao.setStatus(2);
								spiaDao.update();
							}
						}
					}
					//将业务数据改为完成
					completePackge(processType, businessId);
					//冲账数据记录
					strikeABalance(processType, businessId);
					//成本挂钩
					costRecord(processType, businessId);
					
					employee.setEmployeeId(drafter);
					if(employee.load() && !BaseHelpUtils.isNullOrEmpty(employee.getCompanyWeixin())){
						String processName = SelectValueCache.getSelectValue("system_process_types", String.valueOf(processType));
						//发送企业微信消息提示申请人该报销单已经处理完毕
						ERPWeixinUtils.sendTextMsgToUser(employee.getCompanyWeixin(), String.format(sbStr, employee.getEmployeeName(), code, processName));
					}
					
				}
				//将打包主数据改为完成
				rpDao.setIsCompleted(true);
				rpDao.setUpdateTime(currentDate);
				rpDao.update();
				
			}else{
				status = -1;
				errorMsg = "此打包单不存在或该打包单已经完成 packageId= " + packageId;
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
	 * @Title: updateBalanceAmount 
	 * @Description: 财务经理修改冲账金额数据
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String updateBalanceAmount(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		List<BaseReimbursementPackageDetail> detailList = GenericBase.__getList(
				params.get("records"), BaseReimbursementPackageDetail.newInstance());
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		if(null != detailList && detailList.size() > 0 && packageId > 0){
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setReimbursementPackageId(packageId);
			if(rpDao.load()){
				//银行账号汇总List
				List<String> bankAccountList = new ArrayList<>();
				//选取出银行账号进行数据汇总的根据  且更新冲账金额数据
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
					dao.setReimbursementPackageDetailId(baseReimbursementPackageDetail.getReimbursementPackageDetailId());
					if(dao.load()){
						//获取原有的冲账金额进行比较来确定付款金额(付款金额=实付金额)
						BigDecimal oriBalanceAmount = dao.getStrikeABalanceAmount();
						if(null != oriBalanceAmount || null != baseReimbursementPackageDetail.getStrikeABalanceAmount()){
							BigDecimal toBalanceAmount = baseReimbursementPackageDetail.getStrikeABalanceAmount();
							if(null == oriBalanceAmount){
								oriBalanceAmount = BigDecimal.ZERO;
							}
							if(null == toBalanceAmount){
								toBalanceAmount = BigDecimal.ZERO;
							}
							BigDecimal subMoney = oriBalanceAmount.subtract(toBalanceAmount);
							if(subMoney.compareTo(BigDecimal.ZERO) != 0){
								dao.setPaymentAmount(dao.getPaymentAmount().add(subMoney));
								dao.setStrikeABalanceAmount(baseReimbursementPackageDetail.getStrikeABalanceAmount());
								dao.update();
							}
						}
					}
					String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
					if(!bankAccountList.contains(tempAccount)){
						bankAccountList.add(tempAccount);
					}
				}
				ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
				//重新查找详情数据做统计
				dao.clear();
				dao.setConditionReimbursementPackageId("=", packageId);
				detailList = dao.conditionalLoad();
				
				BigDecimal allBlanceAmount = BigDecimal.ZERO;
				BigDecimal allPayAmount = BigDecimal.ZERO;
				//数据汇总
				for (String string : bankAccountList) {
					BigDecimal __blanceAmount = BigDecimal.ZERO;//冲账金额
					BigDecimal __payAmount = BigDecimal.ZERO;//付款金额(实付金额)
					//进行数据相加操作
					for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
						String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
						if(string.equals(tempAccount)){
							if(null != baseReimbursementPackageDetail.getPaymentAmount()){
								__payAmount = __payAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
							}
							if(null != baseReimbursementPackageDetail.getStrikeABalanceAmount()){
								__blanceAmount = __blanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
							}
						}
					}
					allBlanceAmount = allBlanceAmount.add(__blanceAmount);
					allPayAmount = allPayAmount.add(__payAmount);
					rpsDao.setConditionSelfBankAccount("=", string);
					rpsDao.setConditionReimbursementPackageId("=", packageId);
					rpsDao.setStrikeABalanceAmount(__blanceAmount);
					rpsDao.setPaymentAmount(__payAmount);
					rpsDao.conditionalUpdate();
				}
				//修改打包主表数据
				rpDao.setStrikeABalanceAmount(allBlanceAmount);
				rpDao.setPaymentAmount(allPayAmount);
				rpDao.setAmount(allPayAmount.add(allBlanceAmount));
				rpDao.update();
			}else{
				status = -1;
				errorMsg = "打包数据不存在  packageId = " + packageId;
			}
		}else{
			status = -1;
			errorMsg = "参数错误  packageId = " + packageId + " --- list.size() = " + detailList.size();
		}
		BaseCollection<BaseReimbursementPackageDetail> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getPackageDetailByPackageId 
	 * @Description: 根据打包的主键获取打包的详情信息
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPackageDetailByPackageId(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseReimbursementPackageDetail> bc = new BaseCollection<>();
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		if(packageId > 0){
			ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
			dao.setConditionReimbursementPackageId("=", packageId);
			List<BaseReimbursementPackageDetail> list = dao.conditionalLoad(" order by process_type_id, reimbursement_package_detail_id");
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = "参数错误 ：packageId = " + packageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getPackageSummaryByPackageId 
	 * @Description: 根据打包的主键获取汇总打包信息
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getPackageSummaryByPackageId(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseReimbursementPackageSummary> bc = new BaseCollection<>();
		int packageId = BaseHelpUtils.getIntValue(params, "packageId");
		if(packageId > 0){
			ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
			dao.setConditionReimbursementPackageId("=", packageId);
			List<BaseReimbursementPackageSummary> list = dao.conditionalLoad(" order by " + BaseReimbursementPackageSummary.CS_PAY_FOR 
					+ "," + BaseReimbursementPackageSummary.CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID);
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = "参数错误 ：packageId = " + packageId;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: addPackage 
	 * @Description: 财务经理进行报销单打包
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String addPackage(Map<String, Object> params) throws Exception{
		ThreadConnection.beginTransaction();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = null;
		
		List<BaseNewReimbursementPackage> list = GenericBase.__getList(
				params.get("records"), BaseNewReimbursementPackage.newInstance());
		int operatorId = BaseHelpUtils.getIntValue(params, "operatorId");//操作人ID
		int roleId = BaseHelpUtils.getIntValue(params, "role");//可操作角色Id
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//可操作人员Id
		String remark = BaseHelpUtils.getStringValue(params, "remark");
		if(null != list && !list.isEmpty()){
			BigDecimal packagePayAmount = BigDecimal.ZERO;
			BigDecimal packageBlanceAmount = BigDecimal.ZERO;
			Date currentDate = new Date();
			Integer companyId = list.get(0).getCompanyId();
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setCreateTime(currentDate);
			rpDao.setCompanyId(companyId);
			rpDao.setOperatorId(operatorId);
			rpDao.setRoleId(roleId);
			rpDao.setRemark(remark);
			rpDao.setEmployeeId(employeeId);
			rpDao.setPackageSize(list.size());
			rpDao.save();
			int packageId = rpDao.getReimbursementPackageId();
			//查询出所选报销单的操作流水
			List<BaseReimbursementPackageDetail> detailList = new ArrayList<>();
			ProcessBillList pbDao = new ProcessBillList();
			for(BaseNewReimbursementPackage obj : list){
				pbDao.clear();
				pbDao.setConditionBusinessId("=", obj.getBusinessId());
				pbDao.setConditionProcessType("=", obj.getProcessType());
				List<BaseProcessBillList> pbList = pbDao.conditionalLoad();
				if(pbList.size() <= 0){
					ThreadConnection.rollback();
					status = -1;
					errorMsg = "没有账单流水  不允许打包";
					return bc.toJSON(status, errorMsg);
				}
				for (BaseProcessBillList baseProcessBillList : pbList) {
					BaseReimbursementPackageDetail tmpBean = new BaseReimbursementPackageDetail();
					tmpBean.setDataFromJSON(baseProcessBillList.toJSON());
					tmpBean.setCreateTime(currentDate);
					tmpBean.setProcessTypeId(obj.getProcessType());
					tmpBean.setDrafter(obj.getEmployeeId());
					tmpBean.setProcessId(obj.getProcessId());
					tmpBean.setProcessInstanceId(obj.getProcessInstanceId());
					tmpBean.setProcessBillListId(baseProcessBillList.getProcessBillListId());
					tmpBean.setStrikeABalanceAmount(baseProcessBillList.getBalanceAmount());
					tmpBean.setPaymentAmount(baseProcessBillList.getPayMoney());
					tmpBean.setReimbursementPackageId(packageId);
					tmpBean.setCode(obj.getCode());
					detailList.add(tmpBean);
				}
				//将4张表的报销单进行成功打包标志改变
				try {
					doPackage(obj.getProcessType(), obj.getBusinessId());
				} catch (SQLException e) {
					ThreadConnection.rollback();
					throw new SQLException("请勿重复打包");
				}
				
				
			}
			//银行账号汇总List
			List<String> bankAccountList = new ArrayList<>();
			//选取出银行账号进行数据汇总的根据
			for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
				String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
				if(!bankAccountList.contains(tempAccount)){
					bankAccountList.add(tempAccount);
				}
			}
			//数据汇总
			List<BaseReimbursementPackageSummary> packageSummaryList = new ArrayList<>();
			for (String string : bankAccountList) {
				String bankName = null;
				String reciveName = null;
				Integer payfor = null;
				Integer employeeOrCompanyId = null;
				BigDecimal __payAmount = BigDecimal.ZERO;//付款金额
				BigDecimal __blanceAmount = BigDecimal.ZERO;//冲账金额
				BaseReimbursementPackageSummary tmpPackageSummaryBean = new BaseReimbursementPackageSummary();
				//进行数据相加操作
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
					String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
					if(string.equals(tempAccount)){
						if(null != baseReimbursementPackageDetail.getPaymentAmount()){
							packagePayAmount = packagePayAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
							__payAmount = __payAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
						}
						if(null != baseReimbursementPackageDetail.getStrikeABalanceAmount()){
							packageBlanceAmount = packageBlanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
							__blanceAmount = __blanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
						}
						if(null == bankName && null ==reciveName && null == payfor){
							bankName = baseReimbursementPackageDetail.getSelfBankName();
							reciveName = baseReimbursementPackageDetail.getPayeeName();
							payfor = baseReimbursementPackageDetail.getPayFor();
							employeeOrCompanyId = baseReimbursementPackageDetail.getEmployeeOrCompanyId();
						}
						if(null == tmpPackageSummaryBean.getPayType() && null != baseReimbursementPackageDetail.getPayType()){
							tmpPackageSummaryBean.setPayType(baseReimbursementPackageDetail.getPayType());
						}
						if(null == tmpPackageSummaryBean.getCompanyId() && null != baseReimbursementPackageDetail.getCompanyId()){
							tmpPackageSummaryBean.setCompanyId(baseReimbursementPackageDetail.getCompanyId());
						}
						if(null == tmpPackageSummaryBean.getYear() && null != baseReimbursementPackageDetail.getYear()){
							tmpPackageSummaryBean.setYear(baseReimbursementPackageDetail.getYear());
						}
						if(null == tmpPackageSummaryBean.getMonth() && null != baseReimbursementPackageDetail.getMonth()){
							tmpPackageSummaryBean.setMonth(baseReimbursementPackageDetail.getMonth());
						}
						if(null == tmpPackageSummaryBean.getPersonnelBusinessId() && null != baseReimbursementPackageDetail.getPersonnelBusinessId()){
							tmpPackageSummaryBean.setPersonnelBusinessId(baseReimbursementPackageDetail.getPersonnelBusinessId());
						}
						if(null == tmpPackageSummaryBean.getEmployeeFundIssuanceId() && null != baseReimbursementPackageDetail.getEmployeeFundIssuanceId()) {
							tmpPackageSummaryBean.setEmployeeFundIssuanceId(baseReimbursementPackageDetail.getEmployeeFundIssuanceId());
						}
					}
				}
				
				tmpPackageSummaryBean.setAmount(__payAmount.add(__blanceAmount));
				tmpPackageSummaryBean.setPayeeName(reciveName);
				tmpPackageSummaryBean.setPayFor(payfor);
				tmpPackageSummaryBean.setEmployeeOrCompanyId(employeeOrCompanyId);
				tmpPackageSummaryBean.setCreateTime(currentDate);
				tmpPackageSummaryBean.setSelfBankAccount(string);
				tmpPackageSummaryBean.setSelfBankName(bankName);
				tmpPackageSummaryBean.setPaymentAmount(__payAmount);
				tmpPackageSummaryBean.setStrikeABalanceAmount(__blanceAmount);
				tmpPackageSummaryBean.setReimbursementPackageId(packageId);
				packageSummaryList.add(tmpPackageSummaryBean);
			}
			//由于公司签订协议  对于代发的每一笔金额不能大于10万 所以对于代发的需要进行分拆
			List<BaseReimbursementPackageSummary> finalSummaryList = new ArrayList<>();
			for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : packageSummaryList) {
				Integer payFor = baseReimbursementPackageSummary.getPayFor();
				BigDecimal payAmount = baseReimbursementPackageSummary.getPaymentAmount();
				BigDecimal strikeABalanceAmount = baseReimbursementPackageSummary.getStrikeABalanceAmount();
				if(null != payFor && payFor == 1 && null != payAmount && payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) > 0){
					boolean flag = true;
					int index = 0;
					while(flag){
						BaseReimbursementPackageSummary tmpSummaryBean = new BaseReimbursementPackageSummary();
						baseReimbursementPackageSummary.cloneCopy(tmpSummaryBean);
						tmpSummaryBean.setPaymentAmount(ReimbursementPackageProcessor.MAX_MONEY);
						if(null == strikeABalanceAmount || strikeABalanceAmount.compareTo(BigDecimal.ZERO) == 0){
							tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
						}else{
							if(index == 0){
								tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount().add(strikeABalanceAmount));
							}else{
								tmpSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
								tmpSummaryBean.setStrikeABalanceAmount(BigDecimal.ZERO);
							}
						}
						finalSummaryList.add(tmpSummaryBean);
						payAmount = payAmount.subtract(ReimbursementPackageProcessor.MAX_MONEY);
						if(payAmount.compareTo(BigDecimal.ZERO) > 0){
							if(payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) <= 0){
								flag = false;
								BaseReimbursementPackageSummary finalSummaryBean = new BaseReimbursementPackageSummary();
								baseReimbursementPackageSummary.cloneCopy(finalSummaryBean);
								finalSummaryBean.setPaymentAmount(payAmount);
								finalSummaryBean.setAmount(tmpSummaryBean.getPaymentAmount());
								finalSummaryBean.setStrikeABalanceAmount(BigDecimal.ZERO);
								finalSummaryList.add(finalSummaryBean);
							}
						}else{
							flag = false;
						}
						index ++;
					}
				}else{
					finalSummaryList.add(baseReimbursementPackageSummary);
				}
			}
			
			
			rpDao.setAmount(packagePayAmount.add(packageBlanceAmount));
			rpDao.setPaymentAmount(packagePayAmount);
			rpDao.setStrikeABalanceAmount(packageBlanceAmount);
			rpDao.setCode(getBarCode(packageId));
			rpDao.update();
			//插入详情数据
			ReimbursementPackageDetail rpDdao = new ReimbursementPackageDetail();
			rpDdao.save(detailList);
			//插入详情汇总数据
			ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
			rpsDao.save(finalSummaryList);
		} else {
			status = -1;
			errorMsg = "";
		}
		
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: strikeABalance 
	 * @Description: 冲账数据记录
	 * @param @param processType
	 * @param @param businessId
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public void strikeABalance(int processType, int businessId) throws Exception{
		ConditionStrikeABalance condition = new ConditionStrikeABalance();
		condition.setBusinessId(businessId);
		condition.setProcessType(processType);
		QueryStrikeABalance query = new QueryStrikeABalance();
		BaseCollection<BaseStrikeABalance> bc = query.executeQuery(null, condition);
		List<BaseStrikeABalance> list = bc.getCollections();
		if(null != list && !list.isEmpty()){
			List<BaseEmployeeMoneyManage> saveList = new ArrayList<>();
			for(BaseStrikeABalance obj : list){
				BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();
				bean.setDataFromJSON(obj.toJSON());
				bean.setIsCompleted(true);
				bean.setFalg(StaticUtils.RETURN_MONEY);
				bean.setReturnDate(obj.getReturnDate());
				bean.setDeleteFlag(StaticUtils.NO_DELETE);
				saveList.add(bean);
			}
			EmployeeMoneyManage dao = new EmployeeMoneyManage();
			dao.save(saveList);
		}
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * @Title: doPackage 
	 * @Description: 给4张报销表进行打包(改标志位打包)
	 * @param @param processType
	 * @param @param businessId   
	 * @return void   
	 * @throws
	 */
	private void doPackage(int processType, int businessId) throws SQLException{
		switch (processType) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			ProjectNormalReimbursement prDao = new ProjectNormalReimbursement();
			prDao.setConditionProjectNormalReimbursementId("=", businessId);
			prDao.setConditionBePacked("=", true);
			if(prDao.countRows() <= 0){
				prDao.clear();
				prDao.setConditionProjectNormalReimbursementId("=", businessId);
				prDao.setBePacked(true);
				prDao.conditionalUpdate();
			}else{
				throw new SQLException();
			}
			break;
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			TravelReimbursement trDao = new TravelReimbursement();
			trDao.setConditionTravelReimbursementId("=", businessId);
			trDao.setConditionBePacked("=", true);
			if(trDao.countRows() <= 0){
				trDao.clear();
				trDao.setConditionTravelReimbursementId("=", businessId);
				trDao.setBePacked(true);
				trDao.conditionalUpdate();
			}else{
				throw new SQLException();
			}
			break;
		//借款申请
		case StaticUtils.PROCESS_TYPE_6:
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionEmployeeMoneyManageId("=", businessId);
			emmDao.setConditionBePacked("=", true);
			if(emmDao.countRows() <= 0){
				emmDao.clear();
				emmDao.setConditionEmployeeMoneyManageId("=", businessId);
				emmDao.setBePacked(true);
				emmDao.conditionalUpdate();
			}else{
				throw new SQLException();
			}
			break;
		//预付款申请	
		case StaticUtils.PROCESS_TYPE_7:
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setConditionPayMoneyManageId("=", businessId);
			pmmDao.setConditionBePacked("=", true);
			if(pmmDao.countRows() <= 0){
				pmmDao.clear();
				pmmDao.setConditionPayMoneyManageId("=", businessId);
				pmmDao.setBePacked(true);
				pmmDao.conditionalUpdate();
			}else{
				throw new SQLException();
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * @Title: relievePackage 
	 * @Description: 解除4张报销表的打包标志
	 * @param @param processType
	 * @param @param businessId   
	 * @return void   
	 * @throws
	 */
	private void relievePackage(int processType, int businessId) throws SQLException{
		switch (processType) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			ProjectNormalReimbursement prDao = new ProjectNormalReimbursement();
			prDao.setConditionProjectNormalReimbursementId("=", businessId);
			prDao.setBePacked(false);
			prDao.conditionalUpdate();
			break;
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			TravelReimbursement trDao = new TravelReimbursement();
			trDao.setConditionTravelReimbursementId("=", businessId);
			trDao.setBePacked(false);
			trDao.conditionalUpdate();
			break;
		//借款申请
		case StaticUtils.PROCESS_TYPE_6:
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionEmployeeMoneyManageId("=", businessId);
			emmDao.setBePacked(false);
			emmDao.conditionalUpdate();
			break;
		//预付款申请	
		case StaticUtils.PROCESS_TYPE_7:
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setConditionPayMoneyManageId("=", businessId);
			pmmDao.setBePacked(false);
			pmmDao.conditionalUpdate();
			break;
		default:
			break;
		}
	}
	
	
    public static String getBarCode(int packageId){
    	String barCode = null;
    	String code = String.format("%012d", packageId);
//    	a、从代码位置序号2开始，所有偶数位的数字代码求和。 
//    	b、将步骤a的和乘以3。 
//    	c、从代码位置序号3开始，所有奇数位的数字代码求和。 
//    	d、将步骤b与步骤c的结果相加。 
//    	e、用大于或等于步骤d所得结果且为10最小整数倍的数减去步骤d所得结果，其差即为所求校验码的值。 
    	
    	//计算校验码  计算出 奇数位和偶数位 的总和      		   13	12  11  10  9   8	7	6	5	4	3	2	1
    	//	X未知 校验码							2	0	1	6	1	2	0	0	0	3	6	8	X
    	int evenNumbers = 0;
    	int sigleNumbers = 0;
    	char [] codeArra = code.toCharArray();
    	for (int i = 0; i < codeArra.length; i++) {
			if(isBarCodeEvenNumbers(i)){
				evenNumbers += Integer.parseInt(codeArra[i] + "");
			}else{
				sigleNumbers += Integer.parseInt(codeArra[i] + "");
			}
		}
    	evenNumbers = evenNumbers * 3;//偶数位乘3   
    	
    	int allVal = evenNumbers + sigleNumbers;//奇数位总值加偶数位总值
    	//计算大于或等于步骤d所得结果且为10最小整数倍的数
    	int remainderNumber = allVal%10;
    	int	tenNumber = allVal + (10 - remainderNumber);
    	int checkNumber = tenNumber - allVal;
    	if(remainderNumber == 0){
    		barCode = code + "0";
    	}else{
    		barCode = code + checkNumber;
    	}
    	return barCode;
    }
    
    /**
     * 
     * @Title: isBarCodeEvenNumbers  
     * @Description: 获取自定义编码的奇偶数  return true is evenNumber; return false is not evenNumber;
     * @param @param val
     * @param @return
     * @return boolean 
     * @throws
     */
    public static boolean isBarCodeEvenNumbers(int val){
    	if(val%2 == 0){
    		return false;
    	}else{
    		return true;
    	}
    }

    @SuppressWarnings("resource")
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//操作poi执行导出
    	JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
    	int packageId = BaseHelpUtils.getIntValue(params, "packageId");
    	ReimbursementPackage rpDao = new ReimbursementPackage();
    	rpDao.setReimbursementPackageId(packageId);
    	if(rpDao.load()){
    		ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
    		
    		rpsDao.setConditionReimbursementPackageId("=", rpDao.getReimbursementPackageId());
    		List<BaseReimbursementPackageSummary> list = rpsDao.conditionalLoad();
    		if(list.size() > 0){
    			String headName = CustomBaseReimbursementPackageSummary.ALL_CAPTIONS;
    	    	String headNameArra [] = headName.split(",");
    	    	String fileName = rpDao.getCode() + ".xls";
    			fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
    			response.reset();
    			response.setHeader("Content-Disposition", "attachment;filename="
    					+ fileName);// 指定下载的文件名
    			response.setContentType("application/vnd.ms-excel");
    			response.setHeader("Pragma", "no-cache");
    			response.setHeader("Cache-Control", "no-cache");
    			response.setDateHeader("Expires", 0);
    			OutputStream output = response.getOutputStream();
    			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
    			// 定义单元格报头
//    			String worksheetTitle = "";

    			HSSFWorkbook wb = new HSSFWorkbook();

    			// 创建单元格样式
    			HSSFCellStyle cellStyleTitle = wb.createCellStyle();
    			// 指定单元格居中对齐
    			cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    			// 指定单元格垂直居中对齐
    			cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    			// 指定当单元格内容显示不下时自动换行
    			cellStyleTitle.setWrapText(true);
    			// ------------------------------------------------------------------
    			HSSFCellStyle cellStyle = wb.createCellStyle();
    			// 指定单元格居中对齐
    			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    			// 指定单元格垂直居中对齐
    			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    			// 指定当单元格内容显示不下时自动换行
    			cellStyle.setWrapText(true);
    			// ------------------------------------------------------------------
    			// 设置单元格字体
    			HSSFFont font = wb.createFont();
    			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    			font.setFontName("宋体");
    			font.setFontHeight((short) 200);
    			cellStyleTitle.setFont(font);
    			
    			HSSFSheet sheet = wb.createSheet();
//    			ExportExcelUtil exportExcel = new ExportExcelUtil(wb, sheet);
    			// 创建报表头部
//    			exportExcel.createNormalHead(worksheetTitle, headNameArra.length);
    			//设置表头
    			HSSFRow row1 = sheet.createRow(0);
    			for (int i = 0; i < headNameArra.length; i++) {
    				HSSFCell tmpCell = row1.createCell(i);
    				tmpCell.setCellStyle(cellStyleTitle);
    				tmpCell.setCellValue(new HSSFRichTextString(headNameArra[i]));
				}
    			HSSFRow row = sheet.createRow(1);
    			HSSFCell cell = row.createCell(1);
    			BaseReimbursementPackageSummary baseSummary = new BaseReimbursementPackageSummary();
    			for (int i = 0; i < list.size(); i++) {
    				baseSummary = list.get(i);
    				row = sheet.createRow(i + 1);

    				cell = row.createCell(0);
    				cell.setCellStyle(cellStyle);
    				cell.setCellValue(new HSSFRichTextString(baseSummary.getPayeeName()));

    				cell = row.createCell(1);
    				cell.setCellStyle(cellStyle);
    				cell.setCellValue(new HSSFRichTextString(baseSummary.getSelfBankAccount()));

    				cell = row.createCell(2);
    				cell.setCellStyle(cellStyle);
    				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(baseSummary.getPaymentAmount(), 2) + ""));

    				cell = row.createCell(3);
    				cell.setCellStyle(cellStyle);
    				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(baseSummary.getStrikeABalanceAmount(), 2) + ""));

    				cell = row.createCell(4);
    				cell.setCellStyle(cellStyle);
    				cell.setCellValue(new HSSFRichTextString(baseSummary.getSelfBankName()));

    			}
    			try {
    				bufferedOutPut.flush();
    				wb.write(bufferedOutPut);
    				bufferedOutPut.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    				System.out.println("Output   is   closed ");
    			} finally {
    				list.clear();
    			}
    		}
    	
    	}
		
		
//    	JSON parser = new JSON(new StringReader(creteria));
//		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
//    	int packageId = BaseHelpUtils.getIntValue(params, "packageId");
//    	ReimbursementPackage rpDao = new ReimbursementPackage();
//    	rpDao.setReimbursementPackageId(packageId);
//    	if(rpDao.load()){
//    		ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
//    		
//    		rpsDao.setConditionReimbursementPackageId("=", rpDao.getReimbursementPackageId());
//    		List<BaseReimbursementPackageSummary> list = rpsDao.conditionalLoad();
//    		if(list.size() > GenericBase.MAX_EXPORT_LINES){
//    			throw new SQLException(String.format("Too many data to export : %1$d", list.size()));
//    		} else {
//    			try(PrintStream ps = new PrintStream(downFile, "GBK")){
//    				ps.println(CustomBaseReimbursementPackageSummary.ALL_CAPTIONS);
//    				for(BaseReimbursementPackageSummary b : list){
//    					CustomBaseReimbursementPackageSummary tmpBean = new CustomBaseReimbursementPackageSummary();
//    					tmpBean.setDataFromJSON(b.toJSON());
//    					ps.println(tmpBean.toCSVString());
//    				}
//    			}
//    		}
//    	}else{
//    		throw new SQLException("该编号没有找到汇总单  packageId = " + packageId);
//    	}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	private void completePackge(int processType, int businessId) throws SQLException{
		switch (processType) {
		//日常报销
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			ProjectNormalReimbursement prDao = new ProjectNormalReimbursement();
			prDao.setProjectNormalReimbursementId(businessId);
			if(prDao.load()) {
				BaseProjectNormalReimbursement normalbean=prDao.generateBase();
				//获取预算管理id
				int budgetManagementId=BaseHelpUtils.getIntValue(normalbean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(normalbean.getBudgetAttachmentId());
				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(normalbean.getPaymentSequenceId());
				if(budgetManagementId>0&&budgetAttachmentId>0&&paymentSequenceId>0){
					ProcessBillList  biDao=new ProcessBillList();
					biDao.clear();
					biDao.setConditionBusinessId("=", normalbean.getProjectNormalReimbursementId());
					biDao.setConditionProcessType("=", processType);
					List<BaseProcessBillList> bilist=biDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(bilist)&&bilist.size()>0) {
						//获取流水报销金额
						BigDecimal payMoney=BigDecimal.ZERO;
						//获取流水冲账金额
						BigDecimal balanceAmount=BigDecimal.ZERO;
						//获取收款方Id
						int employeeOrcompanyId=0;
						int payfor=0;
						//获取收款方名称
						String payName="";
						for (BaseProcessBillList biBean : bilist) {
							payMoney=BaseHelpUtils.getBigDecimalValue(biBean.getPayMoney()).add(payMoney);
							balanceAmount=BaseHelpUtils.getBigDecimalValue(biBean.getBalanceAmount()).add(balanceAmount);
							payfor=BaseHelpUtils.getIntValue(biBean.getPayFor());
							payName=BaseHelpUtils.getString(biBean.getPayeeName());
							employeeOrcompanyId=BaseHelpUtils.getIntValue(biBean.getEmployeeOrCompanyId());
						}

						BudgetManagement bddao=new BudgetManagement();
						bddao.setBudgetManagementId(budgetManagementId);
						if(bddao.load()) {
							BaseBudgetManagement bdbean=bddao.generateBase();
							//获取预算已用金额
							BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
							//获取预算剩余金额
							BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
							//获取报销金额
							//BigDecimal amount=BaseHelpUtils.getBigDecimalValue(normalbean.getAmount()); 
							bdUseAmout=bdUseAmout.add(payMoney);
							BdRestAmount=BdRestAmount.subtract(payMoney);
							bddao.setBdUseAmount(bdUseAmout);
							bddao.setBdRestAmount(BdRestAmount);
							bddao.update();
						}
						
						BudgetAttachment bdadao=new BudgetAttachment();
						bdadao.setBudgetAttachmentId(budgetAttachmentId);
						if(bdadao.load()) {
							BaseBudgetAttachment bdabean=bdadao.generateBase();
							//获取附件合同已用金额
							BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountUse());
							//获取附件合同剩余金额
							BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountRest());
							budgetContractAmountUse=budgetContractAmountUse.add(payMoney);
							budgetContractAmountRest=budgetContractAmountRest.subtract(payMoney);
							bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
							bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
							bdadao.update();
						}
						
						//获取报销编号
						String code=BaseHelpUtils.getString(normalbean.getCode());
						PaymentSequence payseqdao=new PaymentSequence();
						payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
						payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
						payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
						payseqdao.setReimbursementCode(code);
						payseqdao.setReimbursementAmount(payMoney);//设置序列报销金额为流水付款金额
						payseqdao.setPayAmount(payMoney);//设置付款序列付款金额为流水付款金额
						payseqdao.setReverseAmount(balanceAmount);//设置付款序列冲账金额为流水冲账金额
						payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
						payseqdao.setPayDate(new Date());
						payseqdao.setPayFor(payfor);
						payseqdao.setPayName(payName);
						payseqdao.conditionalUpdate();
					}
				}
				int bunessId=BaseHelpUtils.getIntValue(normalbean.getProjectNormalReimbursementId());
				InputTaxRecord rdao=new InputTaxRecord();
				rdao.setConditionBusinessId("=", bunessId);
				List<BaseInputTaxRecord> rlist=rdao.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0) {
                	rdao.setOverTime(new Date());
                	rdao.conditionalUpdate();
                }
				prDao.setIsCompleted(true);
				prDao.update();
			}
			break;
		//差旅报销
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			TravelReimbursement trDao = new TravelReimbursement();
			trDao.setTravelReimbursementId(businessId);
			if(trDao.load()) {
				BaseTravelReimbursement Travelbean=trDao.generateBase();
				//获取预算管理id
				int budgetManagementId=BaseHelpUtils.getIntValue(Travelbean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(Travelbean.getBudgetAttachmentId());
				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(Travelbean.getPaymentSequenceId());
				if(budgetManagementId>0&&budgetAttachmentId>0&&paymentSequenceId>0){
					ProcessBillList  biDao=new ProcessBillList();
					biDao.clear();
					biDao.setConditionBusinessId("=", Travelbean.getTravelReimbursementId());
					biDao.setConditionProcessType("=", processType);
					List<BaseProcessBillList> bilist=biDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(bilist)&&bilist.size()>0) {
						//获取流水报销金额
						BigDecimal payMoney=BigDecimal.ZERO;
						//获取流水冲账金额
						BigDecimal balanceAmount=BigDecimal.ZERO;
						//获取收款方Id
						int employeeOrcompanyId=0;
						int payfor=0;
						//获取收款方名称
						String payName="";
						for (BaseProcessBillList biBean : bilist) {
							payMoney=BaseHelpUtils.getBigDecimalValue(biBean.getPayMoney()).add(payMoney);
							balanceAmount=BaseHelpUtils.getBigDecimalValue(biBean.getBalanceAmount()).add(balanceAmount);
							payfor=BaseHelpUtils.getIntValue(biBean.getPayFor());
							payName=BaseHelpUtils.getString(biBean.getPayeeName());
							employeeOrcompanyId=BaseHelpUtils.getIntValue(biBean.getEmployeeOrCompanyId());
						}

						BudgetManagement bddao=new BudgetManagement();
						bddao.setBudgetManagementId(budgetManagementId);
						if(bddao.load()) {
							BaseBudgetManagement bdbean=bddao.generateBase();
							//获取预算已用金额
							BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
							//获取预算剩余金额
							BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
							bdUseAmout=bdUseAmout.add(payMoney);
							BdRestAmount=BdRestAmount.subtract(payMoney);
							bddao.setBdUseAmount(bdUseAmout);
							bddao.setBdRestAmount(BdRestAmount);
							bddao.update();
						}

						BudgetAttachment bdadao=new BudgetAttachment();
						bdadao.setBudgetAttachmentId(budgetAttachmentId);
						if(bdadao.load()) {
							BaseBudgetAttachment bdabean=bdadao.generateBase();
							//获取附件合同已用金额
							BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountUse());
							//获取附件合同剩余金额
							BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountRest());
							budgetContractAmountUse=budgetContractAmountUse.add(payMoney);
							budgetContractAmountRest=budgetContractAmountRest.subtract(payMoney);
							bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
							bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
							bdadao.update();
						}

						//获取报销编号
						String code=BaseHelpUtils.getString(Travelbean.getCode());
						PaymentSequence payseqdao=new PaymentSequence();
						payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
						payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
						payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
						payseqdao.setReimbursementCode(code);
						payseqdao.setReimbursementAmount(payMoney);//设置序列报销金额为流水付款金额
						payseqdao.setPayAmount(payMoney);//设置付款序列付款金额为流水付款金额
						payseqdao.setReverseAmount(balanceAmount);//设置付款序列冲账金额为流水冲账金额
						payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
						payseqdao.setPayDate(new Date());
						payseqdao.setPayFor(payfor);
						payseqdao.setPayName(payName);
						payseqdao.conditionalUpdate();
					}
				}
				
				int bunessId=BaseHelpUtils.getIntValue(Travelbean.getTravelReimbursementId());
				InputTaxRecord rdao=new InputTaxRecord();
				rdao.setConditionBusinessId("=", bunessId);
				List<BaseInputTaxRecord> rlist=rdao.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0) {
                	rdao.setOverTime(new Date());
                	rdao.conditionalUpdate();
                }
				
				trDao.setIsCompleted(true);
				trDao.update();
			}
			break;
		//借款申请
		case StaticUtils.PROCESS_TYPE_6:
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setEmployeeMoneyManageId(businessId);
			if(emmDao.load()) {
				BaseEmployeeMoneyManage Employeebean=emmDao.generateBase();
				//获取预算管理id
				int budgetManagementId=BaseHelpUtils.getIntValue(Employeebean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(Employeebean.getBudgetAttachmentId());
				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(Employeebean.getPaymentSequenceId());
				if(budgetManagementId>0&&budgetAttachmentId>0&&paymentSequenceId>0){
					ProcessBillList  biDao=new ProcessBillList();
					biDao.clear();
					biDao.setConditionBusinessId("=",  Employeebean.getEmployeeMoneyManageId());
					biDao.setConditionProcessType("=", processType);
					List<BaseProcessBillList> bilist=biDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(bilist)&&bilist.size()>0) {
						//获取流水报销金额
						BigDecimal payMoney=BigDecimal.ZERO;
						//获取流水冲账金额
						BigDecimal balanceAmount=BigDecimal.ZERO;
						//获取收款方Id
						int employeeOrcompanyId=0;
						int payfor=0;
						//获取收款方名称
						String payName="";
						for (BaseProcessBillList biBean : bilist) {
							payMoney=BaseHelpUtils.getBigDecimalValue(biBean.getPayMoney()).add(payMoney);
							balanceAmount=BaseHelpUtils.getBigDecimalValue(biBean.getBalanceAmount()).add(balanceAmount);
							payfor=BaseHelpUtils.getIntValue(biBean.getPayFor());
							payName=BaseHelpUtils.getString(biBean.getPayeeName());
							employeeOrcompanyId=BaseHelpUtils.getIntValue(biBean.getEmployeeOrCompanyId());
						}

						BudgetManagement bddao=new BudgetManagement();
						bddao.setBudgetManagementId(budgetManagementId);
						if(bddao.load()) {
							BaseBudgetManagement bdbean=bddao.generateBase();
							//获取预付金额
							BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(Employeebean.getBorrowMoney()); 
							//获取已用金额
							BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
							//获取剩余金额
							BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
							bdUseAmout=bdUseAmout.add(payAmount);
							BdRestAmount=BdRestAmount.subtract(payAmount);
							bddao.setBdUseAmount(bdUseAmout);
							bddao.setBdRestAmount(BdRestAmount);
							bddao.update();
						}

						BudgetAttachment bdadao=new BudgetAttachment();
						bdadao.setBudgetAttachmentId(budgetAttachmentId);
						if(bdadao.load()) {
							BaseBudgetAttachment bdabean=bdadao.generateBase();
							//获取附件合同已用金额
							BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountUse());
							//获取附件合同剩余金额
							BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountRest());
							//获取借款金额
							BigDecimal amount=BaseHelpUtils.getBigDecimalValue(Employeebean.getBorrowMoney()); 
							budgetContractAmountUse=budgetContractAmountUse.add(amount);
							budgetContractAmountRest=budgetContractAmountRest.subtract(amount);
							bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
							bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
							bdadao.update();
						}

						//获取报销编号
						String code=BaseHelpUtils.getString(Employeebean.getCode());
						PaymentSequence payseqdao=new PaymentSequence();
						payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
						payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
						payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
						payseqdao.setReimbursementCode(code);
						payseqdao.setPayDate(new Date());
						payseqdao.setPayAmount(Employeebean.getBorrowMoney());
						payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
						payseqdao.setPayFor(payfor);
						payseqdao.setPayName(payName);
						payseqdao.conditionalUpdate();
					}
				}
				emmDao.setIsCompleted(true);
				emmDao.update();
			}
			break;
		//预付款申请	
		case StaticUtils.PROCESS_TYPE_7:
			PayMoneyManage pmmDao = new PayMoneyManage();
			pmmDao.setPayMoneyManageId(businessId);
			if(pmmDao.load()) {
				BasePayMoneyManage payMoneybean=pmmDao.generateBase();
				//获取预算管理id
				int budgetManagementId=BaseHelpUtils.getIntValue(payMoneybean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(payMoneybean.getBudgetAttachmentId());
				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(payMoneybean.getPaymentSequenceId());
				if(budgetManagementId>0&&budgetAttachmentId>0&&budgetAttachmentId>0){
					ProcessBillList  biDao=new ProcessBillList();
					biDao.clear();
					biDao.setConditionBusinessId("=", payMoneybean.getPayMoneyManageId());
					biDao.setConditionProcessType("=", processType);
					List<BaseProcessBillList> bilist=biDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(bilist)&&bilist.size()>0) {
						//获取流水报销金额
						BigDecimal payMoney=BigDecimal.ZERO;
						//获取流水冲账金额
						BigDecimal balanceAmount=BigDecimal.ZERO;
						//获取收款方Id
						int employeeOrcompanyId=0;
						int payfor=0;
						//获取收款方名称
						String payName="";
						for (BaseProcessBillList biBean : bilist) {
							payMoney=BaseHelpUtils.getBigDecimalValue(biBean.getPayMoney()).add(payMoney);
							balanceAmount=BaseHelpUtils.getBigDecimalValue(biBean.getBalanceAmount()).add(balanceAmount);
							payfor=BaseHelpUtils.getIntValue(biBean.getPayFor());
							payName=BaseHelpUtils.getString(biBean.getPayeeName());
							employeeOrcompanyId=BaseHelpUtils.getIntValue(biBean.getEmployeeOrCompanyId());
						}

						BudgetManagement bddao=new BudgetManagement();
						bddao.setBudgetManagementId(budgetManagementId);
						if(bddao.load()) {
							BaseBudgetManagement bdbean=bddao.generateBase();
							//获取预付金额
							BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(payMoneybean.getPayAmount()); 
							//获取已用金额
							BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
							//获取剩余金额
							BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
							bdUseAmout=bdUseAmout.add(payAmount);
							BdRestAmount=BdRestAmount.subtract(payAmount);
							bddao.setBdUseAmount(bdUseAmout);
							bddao.setBdRestAmount(BdRestAmount);
							bddao.update();
						}

						BudgetAttachment bdadao=new BudgetAttachment();
						bdadao.setBudgetAttachmentId(budgetAttachmentId);
						if(bdadao.load()) {
							BaseBudgetAttachment bdabean=bdadao.generateBase();
							//获取附件合同已用金额
							BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountUse());
							//获取附件合同剩余金额
							BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountRest());
							//获取预付金额
							BigDecimal amount=BaseHelpUtils.getBigDecimalValue(payMoneybean.getPayAmount()); 
							budgetContractAmountUse=budgetContractAmountUse.add(amount);
							budgetContractAmountRest=budgetContractAmountRest.subtract(amount);
							bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
							bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
							bdadao.update();
						}

						//获取报销编号
						String code=BaseHelpUtils.getString(payMoneybean.getCode());
						PaymentSequence payseqdao=new PaymentSequence();
						payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
						payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
						payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
						payseqdao.setReimbursementCode(code);
						payseqdao.setPayDate(new Date());
						payseqdao.setPayAmount(payMoneybean.getPayAmount());
						payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
						payseqdao.setPayFor(payfor);
						payseqdao.setPayName(payName);
						payseqdao.conditionalUpdate();
						payseqdao.clear();
					}
				}
				pmmDao.setIsCompleted(true);
				pmmDao.update();
			}	
			break;
		default:
			break;
		}
	}
	
	/**
	 * 成本挂钩
	 * @param processType
	 * @param businessId
	 * @throws SQLException
	 */
	private void costRecord(int processType, int businessId) throws Exception{
		Calendar c = Calendar.getInstance();
		SystemDictionary dicDao = new SystemDictionary();
		dicDao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_CURRENCY);
		dicDao.setConditionDicIsEnable("=", true);
		dicDao.unsetSelectFlags();
		dicDao.setSelectDicTypeValueId(true);
		List<BaseSystemDictionary> dicList = dicDao.conditionalLoad();
		Map<Integer, BigDecimal> map = new HashMap<>();
		for(BaseSystemDictionary dicBean : dicList) {
			if(Objects.equals(dicBean.getDicTypeValueId(), StaticUtils.CURRENCY_0)) {
				map.put(StaticUtils.CURRENCY_0, BigDecimal.ONE);
			}else {
				BigDecimal rate = ExchangeRateUtils.getTodayExchangeRate(dicBean.getDicTypeValueId());
				if(null != rate) {
					map.put(dicBean.getDicTypeValueId(), rate);
				}
			}
		}
		ConditionGetReimbursementCost condition = new ConditionGetReimbursementCost();
		condition.setProcessType(processType);
		condition.setBusinessId(businessId);
		QueryGetReimbursementCost query = new QueryGetReimbursementCost();
		BaseCollection<BaseGetReimbursementCost> bc = query.executeQuery(null, condition);
		List<BaseGetReimbursementCost> list = bc.getCollections();
		if(null != list && !list.isEmpty()){
			switch (processType) {
			//项目成本
			case StaticUtils.PROCESS_TYPE_2:
			case StaticUtils.PROCESS_TYPE_4:
				ProjectCost projectCostDao = new ProjectCost();
				projectCostDao.setConditionProcessType("=", processType);
				projectCostDao.setConditionBusinessId("=", businessId);
				if(projectCostDao.countRows()<=0){
					List<BaseProjectCost> saveList1 = new ArrayList<>();
					for(BaseGetReimbursementCost obj : list){
						BigDecimal rate = getExchangeRate(processType, businessId, map, obj);
						BaseProjectCost bean = new BaseProjectCost();
						bean.setDataFromJSON(obj.toJSON());
						bean.setProjectId(obj.getLinkedId());
						bean.setAmount(obj.getCost().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN));
						bean.setCostDate(c.getTime());
						bean.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
						saveList1.add(bean);
					}
					projectCostDao.clear();
					projectCostDao.save(saveList1);
				}
				break;
			//部门成本
			//部门成本的话，还要更新到部门积分汇总表plate_account_records中
			case StaticUtils.PROCESS_TYPE_3:
			case StaticUtils.PROCESS_TYPE_5:
			case StaticUtils.PROCESS_TYPE_8:
			case StaticUtils.PROCESS_TYPE_9:
			case StaticUtils.PROCESS_TYPE_10:
				PlateCostRecord pcrDao = new PlateCostRecord();
				pcrDao.setConditionBusinessId("=", businessId);
				pcrDao.setConditionProcessType("=", processType);
				if(pcrDao.countRows() <= 0){
					//找流程的发起者
					Integer operator = -1;
					String remark = null;
					if(processType == StaticUtils.PROCESS_TYPE_5){
						TravelReimbursement dao = new TravelReimbursement();
						dao.setConditionTravelReimbursementId("=", businessId);
						if(dao.countRows() > 0){
							BaseTravelReimbursement bean = dao.executeQueryOneRow();
							operator = bean.getApplicant(); 
							remark = bean.getTitle();
						}
					}else if(processType == StaticUtils.PROCESS_TYPE_3 || processType == StaticUtils.PROCESS_TYPE_10){
						ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
						dao.setConditionProjectNormalReimbursementId("=", businessId);
						if(dao.countRows() > 0){
							BaseProjectNormalReimbursement bean = dao.conditionalLoad().get(0); 
							operator = bean.getApplyEmployeeId();
							remark = bean.getReimbursementName();
						}
					}
					for(BaseGetReimbursementCost obj : list){
						BigDecimal rate = getExchangeRate(processType, businessId, map, obj);
						//插入部门成本数据
						BasePlateCostRecord bean = new BasePlateCostRecord();
						bean.setDataFromJSON(obj.toJSON());
						bean.setPlateId(obj.getLinkedId());
						bean.setCostIntegral(obj.getCost().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN));
						bean.setCostDate(c.getTime());
						bean.setYear(c.get(Calendar.YEAR));
						bean.setMonth(c.get(Calendar.MONTH)+1);
						PlateCostRecord plateCostRecordDao = new PlateCostRecord();
						plateCostRecordDao.setDataFromBase(bean);
						plateCostRecordDao.save();
						//插入数据到部门积分汇总表
						PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
						plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
						plateAccountRecordDao.setBusinessId(plateCostRecordDao.getPlateCostRecordId());
						plateAccountRecordDao.setPlateId(plateCostRecordDao.getPlateId());
						plateAccountRecordDao.setIntegral(plateCostRecordDao.getCostIntegral());
						plateAccountRecordDao.setRecordDate(plateCostRecordDao.getCostDate());
						plateAccountRecordDao.setOperateEmployeeId(operator);
						plateAccountRecordDao.setOperateTime(c.getTime());
						plateAccountRecordDao.setRemark(remark);
						plateAccountRecordDao.save();
					}
				}
				break;
			default:
				break;
			}
		}else{
			//借款或预付款
			if(processType == StaticUtils.PROCESS_TYPE_6){
				//借款申请
				EmployeeMoneyManage employeeMoneyDao = new EmployeeMoneyManage();
				employeeMoneyDao.setEmployeeMoneyManageId(businessId);
				if(employeeMoneyDao.load()){
					if(null != employeeMoneyDao.getCurrency()){
						if(null != map.get(employeeMoneyDao.getCurrency())){
							employeeMoneyDao.setExchangeRate(map.get(employeeMoneyDao.getCurrency()));
							employeeMoneyDao.update();
						}else{
							throw new Exception("本月的汇率没有设置，无法换算成本");
						}
					}else{
						throw new Exception("借款的货币种类为空");
					}
				}else{
					throw new Exception("找不到借款数据");
				}
			}else if(processType == StaticUtils.PROCESS_TYPE_7){
				//预付款
				PayMoneyManage payMoneyDao = new PayMoneyManage();
				payMoneyDao.setPayMoneyManageId(businessId);
				if(payMoneyDao.load()){
					if(null != payMoneyDao.getCurrency()){
						if(null != map.get(payMoneyDao.getCurrency())){
							payMoneyDao.setExchangeRate(map.get(payMoneyDao.getCurrency()));
							payMoneyDao.update();
						}else{
							throw new Exception("本月的汇率没有设置，无法换算成本");
						}
					}else{
						throw new Exception("预付款的货币种类为空");
					}
				}else{
					throw new Exception("找不到预付款数据");
				}
			}
		}
	}
	
	private BigDecimal getExchangeRate(int processType, int businessId, Map<Integer, BigDecimal> map, BaseGetReimbursementCost obj) throws Exception{
		if(null == obj.getCurrency()){
			throw new Exception("货币类型为空，无法进行成本换算");
		}
		BigDecimal rate = BigDecimal.ONE;
		if(obj.getCurrency().intValue() != StaticUtils.CURRENCY_0){
			if(!map.containsKey(obj.getCurrency())){
				throw new Exception("本月的汇率没有设置，无法换算成本");
			}
			rate = map.get(obj.getCurrency());
		}
		if(processType == StaticUtils.PROCESS_TYPE_2 || processType == StaticUtils.PROCESS_TYPE_3 || processType == StaticUtils.PROCESS_TYPE_10){
			ProjectNormalReimbursement normalDao = new ProjectNormalReimbursement();
			normalDao.setProjectNormalReimbursementId(businessId);
			if(normalDao.load()){
				normalDao.setExchangeRate(rate);
				normalDao.update();
			}else{
				throw new Exception("找不到报销数据");
			}
		}else if(processType == StaticUtils.PROCESS_TYPE_4 || processType == StaticUtils.PROCESS_TYPE_5){
			TravelReimbursement travelDao = new TravelReimbursement();
			travelDao.setTravelReimbursementId(businessId);
			if(travelDao.load()){
				travelDao.setExchangeRate(rate);
				travelDao.update();
			}else{
				throw new Exception("找不到报销数据");
			}
		}
		return rate;
	}
	
	//手动操作  将完成的报销且没有进行的报销单进行打包
//	public static void main(String[] args) throws Exception {
//		ThreadConnection.beginTransaction();
//		BaseCollection<BaseMfinancialAccounting> result;
//		ConditionMfinancialAccounting c = new ConditionMfinancialAccounting();
//		c.setBePacked(false);
//		c.setProcessStatus(3);
//		QueryMfinancialAccounting dao = new QueryMfinancialAccounting();
//		dao.setCurrentPage(0);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		List<BaseMfinancialAccounting> list = result.getCollections();
//		System.out.println("初始 SIZE =====" + list.size());
//		//获取出所有有凭证号的、完成的、没有被打包的报销单   按照    凭证号  加  入账时间作为唯一主键  进行筛选整理分批的数据进行打包
//		//获取所含有凭证号的报销单
//		List<BaseMfinancialAccounting> dataList = new ArrayList<>();
//		for (BaseMfinancialAccounting baseMfinancialAccounting : list) {
//			if(!BaseHelpUtils.isNullOrEmpty(baseMfinancialAccounting.getVoucherNo())){
//				dataList.add(baseMfinancialAccounting);
//			}
//		}
//		System.out.println("整理 SIZE =====" + dataList.size());
//		
//		Set<String> set = new TreeSet<>();
//		for (BaseMfinancialAccounting bean : dataList) {
//			String vcode = bean.getVoucherNo();
//			Date date = bean.getPostingDate();
//			Long __times = date.getTime();
//			set.add(vcode + "--" + __times);
//		}
//		int allSize = 0;
//		Set<String> setStr = new HashSet<String>();
//		//将需要打包在一起的报销单放在一起
//		for (String string : set) {
//			Map<String, Object> map = new HashMap<>();
//			map.put("operatorId", 0);
//			map.put("role", 37);
//			System.out.print(string + "=");
//			String [] arr = string.split("--");
//			String vcode = arr[0];
//			Long timess = Long.parseLong(arr[1]);
//			List<BaseNewReimbursementPackage> packageList = new ArrayList<>();
//			String bankAccount = null;
//			String bankName = null;
//			String __companyId = null;
//			
//			for (BaseMfinancialAccounting bean : dataList) {
//				Integer companyId = null;
//				String __vcode = bean.getVoucherNo();
//				Date date = bean.getPostingDate();
//				Long __times = date.getTime();
//				String checkStr = __vcode + "--" + __times;
//				BaseNewReimbursementPackage __bean = new BaseNewReimbursementPackage();
//				__bean.setBusinessId(bean.getBusinessId());
//				__bean.setProcessType(bean.getProcessType());
//				__bean.setProcessId(bean.getProcessId());
//				__bean.setProcessInstanceId(bean.getProcessInstanceId());
//				__bean.setCode(bean.getCode());
//				__bean.setEmployeeId(bean.getEmployeeId());
//				if(checkStr.equals(string) ){
//					//根据归属公司   将打包分给指定人员
//					if(null == companyId){
//						companyId = bean.getCompanyId();
//						switch (companyId) {
//						case 0:
//							bankAccount = "814482506410001";
//							bankName = "招商银行深圳泰然金谷支行";
//							break;
//						case 1:
//							bankAccount = "755919551510601";
//							bankName = "招商银行深圳泰然金谷支行";
//							break;	
//						case 2:
//							bankAccount = "755919982610606";
//							bankName = "招商银行深圳泰然金谷支行";
//							break;	
//						case 4:
//							bankAccount = "127908532410204";
//							bankName = "招商银行股份有限公司武汉中北路支行";
//							break;	
//						case 5:
//							bankAccount = "2900000010120100151702";
//							bankName = "浙商银行上海分行";
//							break;	
//						case 6:
//							bankAccount = "110909809410803";
//							bankName = "招商银行北京华贸中心支行";
//							break;	
//						case 7:
//							bankAccount = "411904487710818";
//							bankName = "招商银行大连和平广场支行";
//							break;
//						case 8:
//							bankAccount = "848-427720-838-CR";
//							bankName = "汇丰银行香港分行-港元往来户-HK";
//							break;
//						case 10:
//							bankAccount = "411906271610809";
//							bankName = "招商银行大连沙河口支行";
//							break;
//						case 12:
//							bankAccount = "110926702810701";
//							bankName = "招商银行北京华贸中心支行";
//							break;
//						case 13:
//							bankAccount = "121924520210501";
//							bankName = "招商银行上海田林支行";
//							break;
//						default:
//							throw new Exception("操作范围  companyId = " + companyId) ;
//						}
//					}
//					__bean.setCompanyId(companyId);
//					packageList.add(__bean);
//					setStr.add(companyId + "");
//					__companyId = companyId.toString();
//				}
//			}
//			switch (vcode) {
//			case "JA 记 - 131":
//			case "JA 记 - 173":
//			case "JA 记 - 178":
//			case "JA 记 - 177":
//				bankAccount = "9550880201045400120";
//				bankName = "广发银行深圳高新支行";
//				break;
//			default:
//				break;
//			}
//			map.put("bankAccount", bankAccount);
//			map.put("bankName", bankName);
//			Date date = new Date(timess);
//			System.out.print(" companyId =  " + __companyId + "");
//			System.out.println(" ============= " + packageList.size());
//			System.out.println(map.toString());
//			allSize += packageList.size();
////			ReimbursementPackageProcessor p = new ReimbursementPackageProcessor();
////			p.manualPacking(packageList, map, date);
//		}
//		System.out.println(set.size());
//		System.out.println(" aaSize = " + allSize);
//		System.out.println(" ======");
//		System.out.println(setStr.toString());
//		ThreadConnection.commit();
//	}
	
	/**
	 * 
	 * @Title: manualPacking 
	 * @Description: 手动操作  将完成的报销且没有进行的报销单进行打包
	 * @param @param list
	 * @param @param params
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	private void manualPacking(List<BaseNewReimbursementPackage> list, Map<String, Object> params, Date completeDate) throws Exception{
		
		String errorMsg = null;
		int operatorId = BaseHelpUtils.getIntValue(params, "operatorId");//操作人ID
		int roleId = BaseHelpUtils.getIntValue(params, "role");//可操作角色Id
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");//可操作人员Id
		String remark = BaseHelpUtils.getStringValue(params, "remark");
		String G_bankAccount = BaseHelpUtils.getStringValue(params, "bankAccount");
		String G_bankName = BaseHelpUtils.getStringValue(params, "bankName");
		if(null != list && !list.isEmpty()){
			BigDecimal packagePayAmount = BigDecimal.ZERO;
			BigDecimal packageBlanceAmount = BigDecimal.ZERO;
			String str = "2017-01-01 12:00:00";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date currentDate = format.parse(str);
			Integer companyId = list.get(0).getCompanyId();
			ReimbursementPackage rpDao = new ReimbursementPackage();
			rpDao.setCreateTime(currentDate);
			rpDao.setCompanyId(companyId);
			rpDao.setOperatorId(operatorId);
			rpDao.setRoleId(roleId);
			rpDao.setRemark(remark);
			rpDao.setEmployeeId(employeeId);
			rpDao.setIsCompleted(true);
			rpDao.save();
			int packageId = rpDao.getReimbursementPackageId();
			//查询出所选报销单的操作流水
			List<BaseReimbursementPackageDetail> detailList = new ArrayList<>();
			ProcessBillList pbDao = new ProcessBillList();
			for(BaseNewReimbursementPackage obj : list){
				pbDao.clear();
				pbDao.setConditionBusinessId("=", obj.getBusinessId());
				pbDao.setConditionProcessType("=", obj.getProcessType());
				List<BaseProcessBillList> pbList = pbDao.conditionalLoad();
				if(pbList.size() <= 0){
					ThreadConnection.rollback();
					errorMsg = "没有账单流水  不允许打包";
					throw new Exception(errorMsg);
				}
				for (BaseProcessBillList baseProcessBillList : pbList) {
					BaseReimbursementPackageDetail tmpBean = new BaseReimbursementPackageDetail();
					tmpBean.setDataFromJSON(baseProcessBillList.toJSON());
					tmpBean.setCreateTime(currentDate);
					tmpBean.setProcessTypeId(obj.getProcessType());
					tmpBean.setDrafter(obj.getEmployeeId());
					tmpBean.setProcessId(obj.getProcessId());
					tmpBean.setProcessInstanceId(obj.getProcessInstanceId());
					tmpBean.setProcessBillListId(baseProcessBillList.getProcessBillListId());
					tmpBean.setStrikeABalanceAmount(baseProcessBillList.getBalanceAmount());
					tmpBean.setPaymentAmount(baseProcessBillList.getPayMoney());
					tmpBean.setReimbursementPackageId(packageId);
					tmpBean.setCode(obj.getCode());
					detailList.add(tmpBean);
				}
				//将4张表的报销单进行成功打包标志改变
				doPackage(obj.getProcessType(), obj.getBusinessId());
				
			}
			//银行账号汇总List
			List<String> bankAccountList = new ArrayList<>();
			//选取出银行账号进行数据汇总的根据
			for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
				String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
				if(!bankAccountList.contains(tempAccount)){
					bankAccountList.add(tempAccount);
				}
			}
			//数据汇总
			List<BaseReimbursementPackageSummary> packageSummaryList = new ArrayList<>();
			for (String string : bankAccountList) {
				String bankName = null;
				String reciveName = null;
				Integer payfor = null;
				Integer employeeOrCompanyId = null;
				BigDecimal __payAmount = BigDecimal.ZERO;//付款金额
				BigDecimal __blanceAmount = BigDecimal.ZERO;//冲账金额
				BaseReimbursementPackageSummary tmpPackageSummaryBean = new BaseReimbursementPackageSummary();
				//进行数据相加操作
				for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
					String tempAccount = baseReimbursementPackageDetail.getSelfBankAccount();
					if(string.equals(tempAccount)){
						if(null != baseReimbursementPackageDetail.getPaymentAmount()){
							packagePayAmount = packagePayAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
							__payAmount = __payAmount.add(baseReimbursementPackageDetail.getPaymentAmount());
						}
						if(null != baseReimbursementPackageDetail.getStrikeABalanceAmount()){
							packageBlanceAmount = packageBlanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
							__blanceAmount = __blanceAmount.add(baseReimbursementPackageDetail.getStrikeABalanceAmount());
						}
						if(null == bankName && null ==reciveName && null == payfor){
							bankName = baseReimbursementPackageDetail.getSelfBankName();
							reciveName = baseReimbursementPackageDetail.getPayeeName();
							payfor = baseReimbursementPackageDetail.getPayFor();
							employeeOrCompanyId = baseReimbursementPackageDetail.getEmployeeOrCompanyId();
						}
						if(null == tmpPackageSummaryBean.getPayType() && null != baseReimbursementPackageDetail.getPayType()){
							tmpPackageSummaryBean.setPayType(baseReimbursementPackageDetail.getPayType());
						}
						if(null == tmpPackageSummaryBean.getCompanyId() && null != baseReimbursementPackageDetail.getCompanyId()){
							tmpPackageSummaryBean.setCompanyId(baseReimbursementPackageDetail.getCompanyId());
						}
						if(null == tmpPackageSummaryBean.getYear() && null != baseReimbursementPackageDetail.getYear()){
							tmpPackageSummaryBean.setYear(baseReimbursementPackageDetail.getYear());
						}
						if(null == tmpPackageSummaryBean.getMonth() && null != baseReimbursementPackageDetail.getMonth()){
							tmpPackageSummaryBean.setMonth(baseReimbursementPackageDetail.getMonth());
						}
					}
				}
				tmpPackageSummaryBean.setAmount(__payAmount.add(__blanceAmount));
				tmpPackageSummaryBean.setPayeeName(reciveName);
				tmpPackageSummaryBean.setPayFor(payfor);
				tmpPackageSummaryBean.setEmployeeOrCompanyId(employeeOrCompanyId);
				tmpPackageSummaryBean.setCreateTime(currentDate);
				tmpPackageSummaryBean.setSelfBankAccount(string);
				tmpPackageSummaryBean.setSelfBankName(bankName);
				tmpPackageSummaryBean.setPaymentAmount(__payAmount);
				tmpPackageSummaryBean.setStrikeABalanceAmount(__blanceAmount);
				tmpPackageSummaryBean.setReimbursementPackageId(packageId);
				tmpPackageSummaryBean.setIsCompleted(true);
				tmpPackageSummaryBean.setUpdateTime(completeDate);
				tmpPackageSummaryBean.setOtherBankAccount(G_bankAccount);
				tmpPackageSummaryBean.setOtherName(companyId);
				tmpPackageSummaryBean.setOtherBankName(G_bankName);
				packageSummaryList.add(tmpPackageSummaryBean);
			}
			rpDao.setAmount(packagePayAmount.add(packageBlanceAmount));
			rpDao.setPaymentAmount(packagePayAmount);
			rpDao.setStrikeABalanceAmount(packageBlanceAmount);
			rpDao.setCode(getBarCode(packageId));
			rpDao.setUpdateTime(completeDate);
			rpDao.update();
			//插入详情数据
			ReimbursementPackageDetail rpDdao = new ReimbursementPackageDetail();
			rpDdao.save(detailList);
			//插入详情汇总数据
			ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
//			rpsDao.save(packageSummaryList);
			Capital cDao = new Capital();//完成后将汇总付款的流向资金表
			List<BaseCapital> cList = new ArrayList<>();
			for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : packageSummaryList) {
				rpsDao.clear();
				rpsDao.setDataFromBase(baseReimbursementPackageSummary);
				rpsDao.save();
				if(!BaseHelpUtils.isNullOrEmpty(baseReimbursementPackageSummary.getOtherBankAccount())){
					BaseCapital bean = new BaseCapital();
					bean.setHappenDate(baseReimbursementPackageSummary.getUpdateTime());
					bean.setCreateDate(currentDate);
					bean.setLoanMoney(baseReimbursementPackageSummary.getPaymentAmount());
					bean.setOtherName(baseReimbursementPackageSummary.getPayeeName());
					bean.setSelfBankAccount(baseReimbursementPackageSummary.getOtherBankAccount());
					bean.setSelfName(baseReimbursementPackageSummary.getOtherName());
					bean.setSelfBankName(baseReimbursementPackageSummary.getOtherBankName());
					bean.setOtherBankAccount(baseReimbursementPackageSummary.getSelfBankAccount());
					bean.setOtherBankName(baseReimbursementPackageSummary.getSelfBankName());
					bean.setReimbursementPackageSummaryId(rpsDao.getReimbursementPackageSummaryId());
					bean.setOperator(employeeId);
					bean.setCapitalType(2);//表示资金为流出
					cList.add(bean);
				}
			}
			//将数据插入到资金表
			if(cList.size()> 0){
				cDao.save(cList);
			}
			ProcessBillList pblDao = new ProcessBillList();
			for (BaseReimbursementPackageDetail baseReimbursementPackageDetail : detailList) {
				int proceessBillListId = baseReimbursementPackageDetail.getProcessBillListId();
				String __bankAccount = baseReimbursementPackageDetail.getSelfBankAccount();
				Integer otherName = null;//付款方
				String otherBankName = null;//付款账号银行名称
				String otherBankAccount = null;//付款账号
				//获取付款方信息
				for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : packageSummaryList) {
					if(baseReimbursementPackageSummary.getSelfBankAccount().equals(__bankAccount)){
						otherName = baseReimbursementPackageSummary.getOtherName();
						otherBankName = baseReimbursementPackageSummary.getOtherBankName();
						otherBankAccount = baseReimbursementPackageSummary.getOtherBankAccount();
						break;
					}
				}
				pblDao.clear();
				pblDao.setProcessBillListId(proceessBillListId);
				if(pblDao.load()){
					pblDao.setIsComplete(true);//改成通过流程  账单流水通过
					pblDao.setOtherName(otherName);
					pblDao.setOtherBankName(otherBankName);
					pblDao.setOtherBankAccount(otherBankAccount);
					pblDao.update();
				}
			}
		} 
		
	}
}
