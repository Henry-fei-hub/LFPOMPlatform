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
import pomplatform.report.bean.BaseReportSureIntegralTotal;
import pomplatform.report.bean.ConditionReportSureIntegralTotal;
import pomplatform.report.query.QueryReportSureIntegralTotal;

public class OnDownloadReportSureIntegralTotal implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadReportSureIntegralTotal.class);

	public static BaseCollection<BaseReportSureIntegralTotal> executeQueryInsurance(ConditionReportSureIntegralTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportSureIntegralTotal dao = new QueryReportSureIntegralTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportSureIntegralTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportSureIntegralTotal c = new ConditionReportSureIntegralTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportSureIntegralTotal> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportSureIntegralTotal> result;
		ConditionReportSureIntegralTotal c = new ConditionReportSureIntegralTotal();
		c.setDataFromJSON(creteria);
		QueryReportSureIntegralTotal dao = new QueryReportSureIntegralTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportSureIntegralTotal.ALL_CAPTIONS);
			for(BaseReportSureIntegralTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


