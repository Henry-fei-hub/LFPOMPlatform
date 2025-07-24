package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseFiveinsuranceSummary;
import pomplatform.payment.bean.ConditionFiveinsuranceSummary;
import pomplatform.payment.query.QueryFiveinsuranceSummary;
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

public class FiveinsuranceSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FiveinsuranceSummaryHandler.class);

	public static BaseCollection<BaseFiveinsuranceSummary> executeQueryFiveinsuranceSummary(ConditionFiveinsuranceSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryFiveinsuranceSummary dao = new QueryFiveinsuranceSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFiveinsuranceSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFiveinsuranceSummary c = new ConditionFiveinsuranceSummary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFiveinsuranceSummary> result = executeQueryFiveinsuranceSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFiveinsuranceSummary> result;
		ConditionFiveinsuranceSummary c = new ConditionFiveinsuranceSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFiveinsuranceSummary dao = new QueryFiveinsuranceSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFiveinsuranceSummary.ALL_CAPTIONS);
			for(BaseFiveinsuranceSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


