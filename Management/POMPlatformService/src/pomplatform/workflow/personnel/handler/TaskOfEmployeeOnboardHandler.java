package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseTaskOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionTaskOfEmployeeOnboard;
import pomplatform.workflow.personnel.query.QueryTaskOfEmployeeOnboard;
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

public class TaskOfEmployeeOnboardHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TaskOfEmployeeOnboardHandler.class);

	public static BaseCollection<BaseTaskOfEmployeeOnboard> executeQueryTaskOfEmployeeOnboard(ConditionTaskOfEmployeeOnboard c, KeyValuePair[] replacements ) throws Exception {
		QueryTaskOfEmployeeOnboard dao = new QueryTaskOfEmployeeOnboard();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTaskOfEmployeeOnboard> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTaskOfEmployeeOnboard c = new ConditionTaskOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTaskOfEmployeeOnboard> result = executeQueryTaskOfEmployeeOnboard(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTaskOfEmployeeOnboard> result;
		ConditionTaskOfEmployeeOnboard c = new ConditionTaskOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTaskOfEmployeeOnboard dao = new QueryTaskOfEmployeeOnboard();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTaskOfEmployeeOnboard.ALL_CAPTIONS);
			for(BaseTaskOfEmployeeOnboard b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


