package pomplatform.report.business;

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
import pomplatform.report.bean.BaseReportCapitalTotal;
import pomplatform.report.bean.ConditionReportCapitalTotal;
import pomplatform.report.query.QueryReportCapitalTotal;

public class OnDownloadReportCapitalTotal implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadReportCapitalTotal.class);

	public static BaseCollection<BaseReportCapitalTotal> executeQueryInsurance(ConditionReportCapitalTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportCapitalTotal dao = new QueryReportCapitalTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportCapitalTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportCapitalTotal c = new ConditionReportCapitalTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportCapitalTotal> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportCapitalTotal> result;
		ConditionReportCapitalTotal c = new ConditionReportCapitalTotal();
		c.setDataFromJSON(creteria);
		QueryReportCapitalTotal dao = new QueryReportCapitalTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportCapitalTotal.ALL_CAPTIONS);
			for(BaseReportCapitalTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


