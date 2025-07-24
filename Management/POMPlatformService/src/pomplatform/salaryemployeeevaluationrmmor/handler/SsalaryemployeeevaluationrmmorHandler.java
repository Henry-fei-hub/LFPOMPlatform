package pomplatform.salaryemployeeevaluationrmmor.handler;

import org.apache.log4j.Logger;
import pomplatform.salaryemployeeevaluationrmmor.bean.BaseSsalaryemployeeevaluationrmmor;
import pomplatform.salaryemployeeevaluationrmmor.bean.ConditionSsalaryemployeeevaluationrmmor;
import pomplatform.salaryemployeeevaluationrmmor.query.QuerySsalaryemployeeevaluationrmmor;
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

public class SsalaryemployeeevaluationrmmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SsalaryemployeeevaluationrmmorHandler.class);

	public static BaseCollection<BaseSsalaryemployeeevaluationrmmor> executeQuerySsalaryemployeeevaluationrmmor(ConditionSsalaryemployeeevaluationrmmor c, KeyValuePair[] replacements ) throws Exception {
		QuerySsalaryemployeeevaluationrmmor dao = new QuerySsalaryemployeeevaluationrmmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSsalaryemployeeevaluationrmmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSsalaryemployeeevaluationrmmor c = new ConditionSsalaryemployeeevaluationrmmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSsalaryemployeeevaluationrmmor> result = executeQuerySsalaryemployeeevaluationrmmor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSsalaryemployeeevaluationrmmor> result;
		ConditionSsalaryemployeeevaluationrmmor c = new ConditionSsalaryemployeeevaluationrmmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySsalaryemployeeevaluationrmmor dao = new QuerySsalaryemployeeevaluationrmmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSsalaryemployeeevaluationrmmor.ALL_CAPTIONS);
			for(BaseSsalaryemployeeevaluationrmmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


