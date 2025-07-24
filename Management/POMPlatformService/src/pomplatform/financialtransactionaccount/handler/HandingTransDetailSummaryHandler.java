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
import pomplatform.financialtransactionaccount.bean.BaseHandingTransDetailSummary;
import pomplatform.financialtransactionaccount.bean.ConditionHandingTransDetailSummary;
import pomplatform.financialtransactionaccount.query.QueryHandingTransDetailSummary;
import pomplatform.financialtransactionaccount.utils.FinancialTransactionAccountUtils;

public class HandingTransDetailSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(HandingTransDetailSummaryHandler.class);

	public static BaseCollection<BaseHandingTransDetailSummary> executeQueryHandingTransDetailSummary(ConditionHandingTransDetailSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryHandingTransDetailSummary dao = new QueryHandingTransDetailSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseHandingTransDetailSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionHandingTransDetailSummary c = new ConditionHandingTransDetailSummary();
		c.setDataFromJSON(creteria);
		if(!BaseHelpUtils.isNullOrEmpty(c.getPlateIds())) {
			//只有查看部门数据的权限
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("and g.delete_flag = 0");
			kv.setValue(String.format("and g.delete_flag = 0 and g.financial_transaction_account_id in (select financial_transaction_account_id from financial_transaction_account_link_entities where account_type = %1$s and entity_id in (select employee_id from employees where plate_id in (%2$s))) ", FinancialTransactionAccountUtils.ACCOUNT_TYPE_EMPLOYEE, c.getPlateIds()));
			KeyValuePair[] arr = {kv};
			c.setKeyValues(arr);
		}
		if(null == c.getStartDate()) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("and g.delete_flag = 0");
			kv.setValue("and 1=2 and g.delete_flag = 0");
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
		BaseCollection<BaseHandingTransDetailSummary> result = executeQueryHandingTransDetailSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseHandingTransDetailSummary> result;
		ConditionHandingTransDetailSummary c = new ConditionHandingTransDetailSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryHandingTransDetailSummary dao = new QueryHandingTransDetailSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseHandingTransDetailSummary.ALL_CAPTIONS);
			for(BaseHandingTransDetailSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


