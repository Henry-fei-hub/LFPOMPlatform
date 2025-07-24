package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BasePayMoneyStatus2;
import pomplatform.reimbursementpackage.bean.ConditionPayMoneyStatus2;
import pomplatform.reimbursementpackage.query.QueryPayMoneyStatus2;
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

public class PayMoneyStatus2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PayMoneyStatus2Handler.class);

	public static BaseCollection<BasePayMoneyStatus2> executeQueryPayMoneyStatus2(ConditionPayMoneyStatus2 c, KeyValuePair[] replacements ) throws Exception {
		QueryPayMoneyStatus2 dao = new QueryPayMoneyStatus2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePayMoneyStatus2> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPayMoneyStatus2 c = new ConditionPayMoneyStatus2();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePayMoneyStatus2> result = executeQueryPayMoneyStatus2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePayMoneyStatus2> result;
		ConditionPayMoneyStatus2 c = new ConditionPayMoneyStatus2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPayMoneyStatus2 dao = new QueryPayMoneyStatus2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePayMoneyStatus2.ALL_CAPTIONS);
			for(BasePayMoneyStatus2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


