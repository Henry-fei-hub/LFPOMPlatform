package pomplatform.purchase.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BasePaymentTemplateDetail;
import com.pomplatform.db.bean.BasePurchasePayment;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.PaymentTemplateDetail;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;

public class PurchaseActionProcessor implements GenericProcessor {

	// 操作类型
	private static final String OPT_TYPE = "optType";
	
	

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		// 设置为最终报价
		case "getPaymentData":
			return getPaymentData(params);
		case "getPurchaseContractCode":
			return getPurchaseContractCode(params);
		default:
			break;
		}
		return null;
	}

	/**
	 * 获取采购合同编号
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String getPurchaseContractCode(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseContract> bc = new BaseCollection<>();
		int mainProjectId = BaseHelpUtils.getIntValue(params, "mainProjectId");
		
		MainProject dao = new MainProject();
		dao.setMainProjectId(mainProjectId);
		if(mainProjectId > 0 && dao.load()) {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String yearStr = sdf.format(currentDate);
			String purchaseCode = "";
			String purchaseCodeOne = "(%1$s)深万城采字%2$s-%3$s号";
			String purchaseCodeTwo = "(%1$s)深万城采字第%2$s号";
			// 完善项目模块后需要优化
			boolean isPurchaseContract = true;
			// 查找流水号
			PersonnelBusines pbDao = new PersonnelBusines();
			pbDao.setConditionProcessType("=", StaticUtils.PURCHASE_ACTION_PROCESS_TYPE);
			pbDao.setConditionProjectId("=", mainProjectId);
			int countS = pbDao.countRows() + 1;
			String orderNum = String.format("%03d", countS);
			if(isPurchaseContract) {
				purchaseCode = String.format(purchaseCodeOne, yearStr, dao.getProjectCode(), orderNum);
			}else {
				purchaseCode = String.format(purchaseCodeTwo, yearStr, orderNum);
			}
			List<BaseContract> list = new ArrayList<>();
			BaseContract bean = new BaseContract();
			bean.setContractCode(purchaseCode);
			list.add(bean);
			bc.setCollections(list);
		}else {
			status = -1;
			errorMsg = "参数错误";
		}
		
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 根据付款模板生成真实付款数据
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String getPaymentData(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = null;
		BaseCollection<BasePurchasePayment> bc = new BaseCollection<>();
		int paymentTemplateId = BaseHelpUtils.getIntValue(params, "paymentTemplateId");
		BigDecimal taxAmount = GenericBase.__getDecimal(params.get("taxAmount"));
		Date contractDate = GenericBase.__getDate(params.get("contractDate"));
		if (paymentTemplateId > 0 && null != taxAmount && null != contractDate) {
			PaymentTemplateDetail dao = new PaymentTemplateDetail();
			dao.setConditionPaymentTemplateId("=", paymentTemplateId);
			List<BasePaymentTemplateDetail> list = dao.conditionalLoad(" ORDER BY order_num ASC");
			List<BasePurchasePayment> payList = new ArrayList<>();
			if (list.size() > 0) {
				for (BasePaymentTemplateDetail basePaymentTemplateDetail : list) {
					BasePurchasePayment payBean = new BasePurchasePayment();
					payBean.setPaymentDate(
							DateUtil.getNextDayOfDay(contractDate, basePaymentTemplateDetail.getDelayDay()));
					payBean.setPaymentAmount(taxAmount.multiply(basePaymentTemplateDetail.getPaymentRatio())
							.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
					payBean.setRemark(basePaymentTemplateDetail.getRemark());
					payBean.setPaymentCondition(basePaymentTemplateDetail.getPaymentCondition());
					payBean.setPaymentName(basePaymentTemplateDetail.getPaymentName());
					payBean.setPaymentRatio(basePaymentTemplateDetail.getPaymentRatio());
					payList.add(payBean);
				}
			}
			bc.setCollections(payList);
		} else {
			status = -1;
			errorMsg = "参数错误,应用失败";
		}
		return bc.toJSON(status, errorMsg);
	}

}
