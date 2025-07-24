package pomplatform.workflow.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseReimbursementInvoiceInformation;
import com.pomplatform.db.dao.ReimbursementInvoiceInformation;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomWorkflowBusinessProcessor implements GenericProcessor  {

	@Override
	public String execute(String creteria, HttpServletRequest arg1) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case "checkInvoiceInformation":
				return checkInvoiceInformation(result);
			}
		}
		return null;
	}
	
	/**
	 * 检测发票是否已经录入
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String checkInvoiceInformation(Map<String, Object> params) throws SQLException {
		int status = 1;
		String errorMsg = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromMap(params);
		int type = BaseHelpUtils.getIntValue(params, "type");
		if(type > 0 && !BaseHelpUtils.isNullOrEmpty(bean.getInvoiceNumber())) {
			ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
			dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
			if(type == 2) {
				dao.setConditionBusinessId("<>", bean.getBusinessId());
				dao.setConditionProcessType("<>", bean.getProcessType());
			}
			if(dao.countRows() > 0) {
				status = 2;
				errorMsg = "该发票号已经有录入到系统，是否添加该发票?";
			}
		} else {
			status = -1;
			errorMsg = "参数错误";
		}
		
		return bc.toJSON(status, errorMsg);
		
	}

}
