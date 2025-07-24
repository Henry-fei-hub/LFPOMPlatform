package pomplatform.financialtransactionaccount.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.financialtransactionaccount.bean.BaseTransDetailSummary;
import pomplatform.financialtransactionaccount.bean.ConditionTransDetailSummary;
import pomplatform.financialtransactionaccount.query.QueryTransDetailSummary;
import pomplatform.financialtransactionaccount.utils.FinancialTransactionAccountUtils;

public class TransDetailSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TransDetailSummaryHandler.class);

	public static BaseCollection<BaseTransDetailSummary> executeQueryTransDetailSummary(ConditionTransDetailSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryTransDetailSummary dao = new QueryTransDetailSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTransDetailSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTransDetailSummary c = new ConditionTransDetailSummary();
		c.setDataFromJSON(creteria);
		if(!BaseHelpUtils.isNullOrEmpty(c.getPlateIds())) {
			//只有查看部门数据的权限
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("and a.account_status = ?");
			kv.setValue(String.format("and a.account_status = ? and a.financial_transaction_account_id in (select financial_transaction_account_id from financial_transaction_account_link_entities where account_type = %1$s and entity_id in (select employee_id from employees where plate_id in (%2$s)))", FinancialTransactionAccountUtils.ACCOUNT_TYPE_EMPLOYEE, c.getPlateIds()));
			KeyValuePair[] arr = {kv};
			c.setKeyValues(arr);
		}
		if(null == c.getStartDate()) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("from financial_transaction_details where record_date < ? and delete_flag = ? group by financial_transaction_account_id");
			kv.setValue("from financial_transaction_details where record_date < ? and delete_flag = ? and 1=2 group by financial_transaction_account_id");
			KeyValuePair[] originalArr = c.getKeyValues();
			int size = 1;
			KeyValuePair[] arr = null;
			if(null != originalArr) {
				size += originalArr.length;
				arr = new KeyValuePair[size];
				for(int i = 0; i < size - 1; i++) {
					arr[i] = originalArr[i];
				}
			}else {
				arr = new KeyValuePair[size];
			}
			arr[size - 1] = kv;
			c.setKeyValues(arr);
		}else {
			c.setInitEndDate(c.getStartDate());
		}
		BaseCollection<BaseTransDetailSummary> result = executeQueryTransDetailSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTransDetailSummary> result;
		ConditionTransDetailSummary c = new ConditionTransDetailSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(!BaseHelpUtils.isNullOrEmpty(c.getPlateIds())) {
			//只有查看部门数据的权限
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("and a.account_status = ?");
			kv.setValue(String.format("and a.account_status = ? and a.financial_transaction_account_id in (select financial_transaction_account_id from financial_transaction_account_link_entities where account_type = %1$s and entity_id in (select employee_id from employees where plate_id in (%2$s)))", FinancialTransactionAccountUtils.ACCOUNT_TYPE_EMPLOYEE, c.getPlateIds()));
			KeyValuePair[] arr = {kv};
			c.setKeyValues(arr);
		}
		if(null == c.getStartDate()) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("from financial_transaction_details where record_date < ? and delete_flag = ? group by financial_transaction_account_id");
			kv.setValue("from financial_transaction_details where record_date < ? and delete_flag = ? and 1=2 group by financial_transaction_account_id");
			KeyValuePair[] originalArr = c.getKeyValues();
			int size = 1;
			KeyValuePair[] arr = null;
			if(null != originalArr) {
				size += originalArr.length;
				arr = new KeyValuePair[size];
				for(int i = 0; i < size - 1; i++) {
					arr[i] = originalArr[i];
				}
			}else {
				arr = new KeyValuePair[size];
			}
			arr[size - 1] = kv;
			c.setKeyValues(arr);
		}else {
			c.setInitEndDate(c.getStartDate());
		}
		QueryTransDetailSummary dao = new QueryTransDetailSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTransDetailSummary.ALL_CAPTIONS);
			for(BaseTransDetailSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


