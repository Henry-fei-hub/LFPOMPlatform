package pomplatform.financialtransactionaccount.business;

import java.sql.SQLException;
import java.util.Date;

import com.pomplatform.db.bean.BaseFinancialAccountInitAmount;
import com.pomplatform.db.dao.FinancialAccountInitAmount;
import com.pomplatform.db.dao.FinancialAccountInitLog;
import com.pomplatform.db.handler.FinancialAccountInitAmountHandler;

import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.system.executor.SelectValueCache;

public class CustomFinancialAccountInitAmount extends FinancialAccountInitAmountHandler {

	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if (dao.isPrimaryKeyNull()) {
			dao.setDataFromBase(bean);
			ret = dao.save();
			bean = dao.generateBase();
		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			generateLogs(dao);
			ret = dao.update();
			bean = dao.generateBase();
		}
		return bean.toOneLineJSON(ret, null);
	}

	@Override
	public String update(String json) throws Exception {
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load()) {
			dao.setDataFromBase(bean);
			generateLogs(dao);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}
	
	private void generateLogs(FinancialAccountInitAmount dao) throws SQLException{
		if(null == dao) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		ColumnChangedData changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_CURRENCY_TYPE);
		if(null != changedData) {
			sb.append(String.format("货币类型从[%1$s]%2$s变为[%3$s]%4$s", changedData.getOriginal(), SelectValueCache.getSelectValue("system_dictionary_40", BaseHelpUtils.getString(changedData.getOriginal())), 
					changedData.getValue(), SelectValueCache.getSelectValue("system_dictionary_40", BaseHelpUtils.getString(changedData.getValue()))));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_ORIGINAL_DEBIT);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("原币借从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_ORIGINAL_CREDIT);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("原币贷从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_EXCHANGE_RATE);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("汇率从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_STANDARD_DEBIT);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("本币借从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_STANDARD_CREDIT);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("本币贷从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_SUMMARY);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("摘要从%1$s变为%2$s", changedData.getOriginal(), changedData.getValue()));
		}
		changedData = dao.getColumnChangedData(BaseFinancialAccountInitAmount.CS_OPERATOR_ID);
		if(null != changedData) {
			if(sb.length() > 0) {
				sb.append("；");
			}
			sb.append(String.format("操作人从[%1$s]%2$s变为[%3$s]%4$s", changedData.getOriginal(), SelectValueCache.getSelectValue("employees", BaseHelpUtils.getString(changedData.getOriginal())), 
					changedData.getValue(), SelectValueCache.getSelectValue("employees", BaseHelpUtils.getString(changedData.getValue()))));
		}
		if(sb.length() > 0) {
			FinancialAccountInitLog logDao = new FinancialAccountInitLog();
			logDao.setOperateTime(new Date());
			logDao.setContent(sb.toString());
			logDao.setOperatorId(dao.getOperatorId());
			logDao.save();
		}
	}
}
