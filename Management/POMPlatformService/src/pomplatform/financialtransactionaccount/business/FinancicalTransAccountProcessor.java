package pomplatform.financialtransactionaccount.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity;
import com.pomplatform.db.dao.FinancialTransactionAccount;
import com.pomplatform.db.dao.FinancialTransactionAccountLinkEntity;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.financialtransactionaccount.utils.FinancialTransactionAccountUtils;

public class FinancicalTransAccountProcessor implements GenericProcessor {
    //员工是否可以报销
    private static final String EMPLOYEE_REIMBURSABLE = "employeeReimbursable";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
		case EMPLOYEE_REIMBURSABLE:
			return employeeReimbursable(params);
		default:
			break;
		}
        return null;
    }
    
    /**
     * 员工是否可以报销
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String employeeReimbursable(Map<String, Object> params) throws SQLException {
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	Integer employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
    	FinancialTransactionAccountLinkEntity entityDao = new FinancialTransactionAccountLinkEntity();
    	entityDao.setConditionAccountType("=", FinancialTransactionAccountUtils.ACCOUNT_TYPE_EMPLOYEE);
    	entityDao.setConditionEntityId("=", employeeId);
    	BaseFinancialTransactionAccountLinkEntity entityBean = entityDao.executeQueryOneRow();
    	if(null == entityBean) {
    		//如果员工ID没有跟账户关联，则可以报销
    		return bc.toJSON();
    	}else {
    		//如果员工ID与账户关联了，则需要查看该账户是否可以报销
    		FinancialTransactionAccount accountDao = new FinancialTransactionAccount();
    		accountDao.setFinancialTransactionAccountId(entityBean.getFinancialTransactionAccountId());
    		if(accountDao.load() && !accountDao.getReimbursable()) {
    			//员工不能报销
    			return bc.toJSON(-1, null);
    		}else {
    			return bc.toJSON();
    		}
    	}
	}
    
}
