package pomplatform.sealKeepers.handler;

import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BasesealKeepersWorkflow;
import pomplatform.sealKeepers.bean.ConditionsealKeepersWorkflow;
import pomplatform.sealKeepers.query.QuerysealKeepersWorkflow;
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

public class sealKeepersWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(sealKeepersWorkflowHandler.class);

	public static BaseCollection<BasesealKeepersWorkflow> executeQuerysealKeepersWorkflow(ConditionsealKeepersWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QuerysealKeepersWorkflow dao = new QuerysealKeepersWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasesealKeepersWorkflow> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionsealKeepersWorkflow c = new ConditionsealKeepersWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BasesealKeepersWorkflow> result = executeQuerysealKeepersWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}


	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasesealKeepersWorkflow> result;
		ConditionsealKeepersWorkflow c = new ConditionsealKeepersWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerysealKeepersWorkflow dao = new QuerysealKeepersWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasesealKeepersWorkflow.ALL_CAPTIONS);
			for(BasesealKeepersWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


