package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseRefuseOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionRefuseOfEmployeeOnboard;
import pomplatform.workflow.personnel.query.QueryRefuseOfEmployeeOnboard;
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

public class RefuseOfEmployeeOnboardHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RefuseOfEmployeeOnboardHandler.class);

	public static BaseCollection<BaseRefuseOfEmployeeOnboard> executeQueryRefuseOfEmployeeOnboard(ConditionRefuseOfEmployeeOnboard c, KeyValuePair[] replacements ) throws Exception {
		QueryRefuseOfEmployeeOnboard dao = new QueryRefuseOfEmployeeOnboard();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRefuseOfEmployeeOnboard> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRefuseOfEmployeeOnboard c = new ConditionRefuseOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRefuseOfEmployeeOnboard> result = executeQueryRefuseOfEmployeeOnboard(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRefuseOfEmployeeOnboard> result;
		ConditionRefuseOfEmployeeOnboard c = new ConditionRefuseOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRefuseOfEmployeeOnboard dao = new QueryRefuseOfEmployeeOnboard();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRefuseOfEmployeeOnboard.ALL_CAPTIONS);
			for(BaseRefuseOfEmployeeOnboard b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


