package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BasePerCapitaSalaryAnalysis;
import pomplatform.report.bean.ConditionPerCapitaSalaryAnalysis;
import pomplatform.report.query.QueryPerCapitaSalaryAnalysis;
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

public class PerCapitaSalaryAnalysisHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PerCapitaSalaryAnalysisHandler.class);

	public static BaseCollection<BasePerCapitaSalaryAnalysis> executeQueryPerCapitaSalaryAnalysis(ConditionPerCapitaSalaryAnalysis c, KeyValuePair[] replacements ) throws Exception {
		QueryPerCapitaSalaryAnalysis dao = new QueryPerCapitaSalaryAnalysis();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePerCapitaSalaryAnalysis> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPerCapitaSalaryAnalysis c = new ConditionPerCapitaSalaryAnalysis();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePerCapitaSalaryAnalysis> result = executeQueryPerCapitaSalaryAnalysis(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePerCapitaSalaryAnalysis> result;
		ConditionPerCapitaSalaryAnalysis c = new ConditionPerCapitaSalaryAnalysis();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPerCapitaSalaryAnalysis dao = new QueryPerCapitaSalaryAnalysis();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePerCapitaSalaryAnalysis.ALL_CAPTIONS);
			for(BasePerCapitaSalaryAnalysis b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


