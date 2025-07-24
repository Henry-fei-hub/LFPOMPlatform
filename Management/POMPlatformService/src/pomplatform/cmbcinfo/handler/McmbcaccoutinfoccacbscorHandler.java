package pomplatform.cmbcinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.cmbcinfo.bean.BaseMcmbcaccoutinfoccacbscor;
import pomplatform.cmbcinfo.bean.ConditionMcmbcaccoutinfoccacbscor;
import pomplatform.cmbcinfo.query.QueryMcmbcaccoutinfoccacbscor;
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

public class McmbcaccoutinfoccacbscorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McmbcaccoutinfoccacbscorHandler.class);

	public static BaseCollection<BaseMcmbcaccoutinfoccacbscor> executeQueryMcmbcaccoutinfoccacbscor(ConditionMcmbcaccoutinfoccacbscor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcmbcaccoutinfoccacbscor dao = new QueryMcmbcaccoutinfoccacbscor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcmbcaccoutinfoccacbscor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcmbcaccoutinfoccacbscor c = new ConditionMcmbcaccoutinfoccacbscor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcmbcaccoutinfoccacbscor> result = executeQueryMcmbcaccoutinfoccacbscor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcmbcaccoutinfoccacbscor> result;
		ConditionMcmbcaccoutinfoccacbscor c = new ConditionMcmbcaccoutinfoccacbscor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcmbcaccoutinfoccacbscor dao = new QueryMcmbcaccoutinfoccacbscor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcmbcaccoutinfoccacbscor.ALL_CAPTIONS);
			for(BaseMcmbcaccoutinfoccacbscor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


