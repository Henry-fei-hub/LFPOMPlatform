package pomplatform.salaryemployeeevaluationrmmor.handler;

import org.apache.log4j.Logger;
import pomplatform.salaryemployeeevaluationrmmor.bean.BaseSsalaryemployeeperformancemmeor;
import pomplatform.salaryemployeeevaluationrmmor.bean.ConditionSsalaryemployeeperformancemmeor;
import pomplatform.salaryemployeeevaluationrmmor.query.QuerySsalaryemployeeperformancemmeor;
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

public class SsalaryemployeeperformancemmeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SsalaryemployeeperformancemmeorHandler.class);

	public static BaseCollection<BaseSsalaryemployeeperformancemmeor> executeQuerySsalaryemployeeperformancemmeor(ConditionSsalaryemployeeperformancemmeor c, KeyValuePair[] replacements ) throws Exception {
		QuerySsalaryemployeeperformancemmeor dao = new QuerySsalaryemployeeperformancemmeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSsalaryemployeeperformancemmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSsalaryemployeeperformancemmeor c = new ConditionSsalaryemployeeperformancemmeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSsalaryemployeeperformancemmeor> result = executeQuerySsalaryemployeeperformancemmeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSsalaryemployeeperformancemmeor> result;
		ConditionSsalaryemployeeperformancemmeor c = new ConditionSsalaryemployeeperformancemmeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySsalaryemployeeperformancemmeor dao = new QuerySsalaryemployeeperformancemmeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSsalaryemployeeperformancemmeor.ALL_CAPTIONS);
			for(BaseSsalaryemployeeperformancemmeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


