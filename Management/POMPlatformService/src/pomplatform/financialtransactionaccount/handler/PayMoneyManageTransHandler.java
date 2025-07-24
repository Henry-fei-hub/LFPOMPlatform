package pomplatform.financialtransactionaccount.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.financialtransactionaccount.bean.BasePayMoneyManageTrans;
import pomplatform.financialtransactionaccount.bean.ConditionPayMoneyManageTrans;
import pomplatform.financialtransactionaccount.query.QueryPayMoneyManageTrans;

public class PayMoneyManageTransHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PayMoneyManageTransHandler.class);

	public static BaseCollection<BasePayMoneyManageTrans> executeQueryPayMoneyManageTrans(ConditionPayMoneyManageTrans c, KeyValuePair[] replacements ) throws Exception {
		QueryPayMoneyManageTrans dao = new QueryPayMoneyManageTrans();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePayMoneyManageTrans> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPayMoneyManageTrans c = new ConditionPayMoneyManageTrans();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePayMoneyManageTrans> result = executeQueryPayMoneyManageTrans(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePayMoneyManageTrans> result;
		ConditionPayMoneyManageTrans c = new ConditionPayMoneyManageTrans();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPayMoneyManageTrans dao = new QueryPayMoneyManageTrans();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePayMoneyManageTrans.ALL_CAPTIONS);
			for(BasePayMoneyManageTrans b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


