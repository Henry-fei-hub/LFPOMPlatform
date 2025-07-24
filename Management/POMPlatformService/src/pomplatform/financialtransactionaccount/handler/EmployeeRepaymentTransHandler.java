package pomplatform.financialtransactionaccount.handler;

import org.apache.log4j.Logger;
import pomplatform.financialtransactionaccount.bean.BaseEmployeeRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.ConditionEmployeeRepaymentTrans;
import pomplatform.financialtransactionaccount.query.QueryEmployeeRepaymentTrans;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class EmployeeRepaymentTransHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeRepaymentTransHandler.class);

	public static BaseCollection<BaseEmployeeRepaymentTrans> executeQueryEmployeeRepaymentTrans(ConditionEmployeeRepaymentTrans c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeRepaymentTrans dao = new QueryEmployeeRepaymentTrans();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeRepaymentTrans> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeRepaymentTrans c = new ConditionEmployeeRepaymentTrans();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeRepaymentTrans> result = executeQueryEmployeeRepaymentTrans(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeRepaymentTrans> result;
		ConditionEmployeeRepaymentTrans c = new ConditionEmployeeRepaymentTrans();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeRepaymentTrans dao = new QueryEmployeeRepaymentTrans();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeRepaymentTrans.ALL_CAPTIONS);
			for(BaseEmployeeRepaymentTrans b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


