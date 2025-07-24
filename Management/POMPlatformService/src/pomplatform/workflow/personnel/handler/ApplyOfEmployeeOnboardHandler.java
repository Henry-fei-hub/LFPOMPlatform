package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseApplyOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionApplyOfEmployeeOnboard;
import pomplatform.workflow.personnel.query.QueryApplyOfEmployeeOnboard;
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

public class ApplyOfEmployeeOnboardHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplyOfEmployeeOnboardHandler.class);

	public static BaseCollection<BaseApplyOfEmployeeOnboard> executeQueryApplyOfEmployeeOnboard(ConditionApplyOfEmployeeOnboard c, KeyValuePair[] replacements ) throws Exception {
		QueryApplyOfEmployeeOnboard dao = new QueryApplyOfEmployeeOnboard();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplyOfEmployeeOnboard> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplyOfEmployeeOnboard c = new ConditionApplyOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplyOfEmployeeOnboard> result = executeQueryApplyOfEmployeeOnboard(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplyOfEmployeeOnboard> result;
		ConditionApplyOfEmployeeOnboard c = new ConditionApplyOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplyOfEmployeeOnboard dao = new QueryApplyOfEmployeeOnboard();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplyOfEmployeeOnboard.ALL_CAPTIONS);
			for(BaseApplyOfEmployeeOnboard b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


