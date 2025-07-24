package pomplatform.workflow.query;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.InputTaxInvoiceLinkFinance;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InputTaxInvoiceLinkFinanceProcess implements GenericProcessor {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		int status = -1;
		BaseCollection<BaseInputTaxInvoiceLinkFinance> collection = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String invoiceCode = BaseHelpUtils.getStringValue(result, "invoiceCode");
		String invoiceNumber = BaseHelpUtils.getStringValue(result, "invoiceNumber");
		if (!BaseHelpUtils.isNullOrEmpty(invoiceCode) && !BaseHelpUtils.isNullOrEmpty(invoiceNumber)) {
			InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
			dao.setConditionInvoiceCode("=", invoiceCode);
			dao.setConditionInvoiceNumber("=", invoiceNumber);
			BaseInputTaxInvoiceLinkFinance bean = dao.executeQueryOneRow();
			if (BaseHelpUtils.isNullOrEmpty(bean)) {
				//保存发票的信息
				BaseInputTaxInvoiceLinkFinance bean1 = new BaseInputTaxInvoiceLinkFinance();
				bean1.setDataFromMap(result);
//				bean1.setAddType(BaseHelpUtils.getIntValue(result,"addType"));
//				bean1.setInvoiceCode(BaseHelpUtils.getStringValue(result, "invoiceCode"));
//				bean1.setInvoiceType(BaseHelpUtils.getIntValue(result, "invoiceType"));
//				bean1.setInvoiceNumber(BaseHelpUtils.getStringValue(result, "invoiceNumber"));
//				bean1.setInvoiceDate(BaseHelpUtils.getDateValue(result.get("invoiceDate")));
//				bean1.setInvoiceAmount(BaseHelpUtils.getBigDecimalValue(result.get("invoiceAmount")));
//				bean1.setRandomCode(BaseHelpUtils.getStringValue(result, "randomCode"));
//				bean1.setProcessType(BaseHelpUtils.getIntValue(result, "processType"));
//				bean1.setBusinessId(BaseHelpUtils.getIntValue(result, "businessId"));
//				bean1.setCode(BaseHelpUtils.getStringValue(result, "code"));
//				bean1.setOperator(BaseHelpUtils.getIntValue(result, "operator"));
//				bean1.setCompanyId(BaseHelpUtils.getIntValue(result, "companyId"));
				dao.setDataFromBase(bean1);
				dao.save();
				BaseInputTaxInvoiceLinkFinance aBaseInputTaxInvoiceLinkFinance = dao.generateBase();
				status = 1;
				List<BaseInputTaxInvoiceLinkFinance> baseInputTaxInvoiceLinkFinances = new ArrayList<>();
				baseInputTaxInvoiceLinkFinances.add(aBaseInputTaxInvoiceLinkFinance);
				collection.setCollections(baseInputTaxInvoiceLinkFinances);
				return collection.toJSON(status, "录入成功");
			}else{
				//报销单已经使用
				int processType = BaseHelpUtils.getIntValue(result, "processType");
				//日常报销
				status = -1;
				if (processType == 2 || processType == 3 || processType == 8) {
					int businessId = bean.getBusinessId();
					ProjectNormalReimbursement dao1 = new ProjectNormalReimbursement();
					dao1.setProjectNormalReimbursementId(businessId);
					dao1.load();
					BaseProjectNormalReimbursement bean2 = dao1.generateBase();
					String code = bean2.getCode();
					return collection.toJSON(status,code);
				}
				//差旅报销
				status = -1;
				if (processType == 4 || processType == 5 || processType == 9) {
					int businessId = bean.getBusinessId();
					TravelReimbursement dao1 = new TravelReimbursement();
					dao1.setTravelReimbursementId(businessId);
					dao1.load();
					BaseTravelReimbursement bean2 = dao1.generateBase();
					String code = bean2.getCode();
					return collection.toJSON(status,code);
				}
			}
		}
		return null;
	}

}
