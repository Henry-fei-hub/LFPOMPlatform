package pomplatform.projectperformance.handler;

import org.apache.log4j.Logger;
import pomplatform.projectperformance.bean.BaseContractProjectPerformance;
import pomplatform.projectperformance.bean.ConditionContractProjectPerformance;
import pomplatform.projectperformance.query.QueryContractProjectPerformance;
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

public class ContractProjectPerformanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractProjectPerformanceHandler.class);

	public static BaseCollection<BaseContractProjectPerformance> executeQueryContractProjectPerformance(ConditionContractProjectPerformance c, KeyValuePair[] replacements ) throws Exception {
		QueryContractProjectPerformance dao = new QueryContractProjectPerformance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractProjectPerformance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractProjectPerformance c = new ConditionContractProjectPerformance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractProjectPerformance> result = executeQueryContractProjectPerformance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractProjectPerformance> result;
		ConditionContractProjectPerformance c = new ConditionContractProjectPerformance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractProjectPerformance dao = new QueryContractProjectPerformance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractProjectPerformance.ALL_CAPTIONS);
			for(BaseContractProjectPerformance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


