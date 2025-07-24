package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentChange;
import pomplatform.payment.query.QueryOnLoadSalaryPaymentChange;
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

public class OnLoadSalaryPaymentChangeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadSalaryPaymentChangeHandler.class);

	public static BaseCollection<BaseOnLoadSalaryPaymentChange> executeQueryOnLoadSalaryPaymentChange(ConditionOnLoadSalaryPaymentChange c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadSalaryPaymentChange dao = new QueryOnLoadSalaryPaymentChange();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadSalaryPaymentChange> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadSalaryPaymentChange c = new ConditionOnLoadSalaryPaymentChange();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadSalaryPaymentChange> result = executeQueryOnLoadSalaryPaymentChange(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadSalaryPaymentChange> result;
		ConditionOnLoadSalaryPaymentChange c = new ConditionOnLoadSalaryPaymentChange();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadSalaryPaymentChange dao = new QueryOnLoadSalaryPaymentChange();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadSalaryPaymentChange.ALL_CAPTIONS);
			for(BaseOnLoadSalaryPaymentChange b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


