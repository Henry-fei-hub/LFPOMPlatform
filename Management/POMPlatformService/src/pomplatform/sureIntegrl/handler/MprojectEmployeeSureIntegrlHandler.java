package pomplatform.sureIntegrl.handler;

import org.apache.log4j.Logger;
import pomplatform.sureIntegrl.bean.BaseMprojectEmployeeSureIntegrl;
import pomplatform.sureIntegrl.bean.ConditionMprojectEmployeeSureIntegrl;
import pomplatform.sureIntegrl.query.QueryMprojectEmployeeSureIntegrl;
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

public class MprojectEmployeeSureIntegrlHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectEmployeeSureIntegrlHandler.class);

	public static BaseCollection<BaseMprojectEmployeeSureIntegrl> executeQueryMprojectEmployeeSureIntegrl(ConditionMprojectEmployeeSureIntegrl c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectEmployeeSureIntegrl dao = new QueryMprojectEmployeeSureIntegrl();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectEmployeeSureIntegrl> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectEmployeeSureIntegrl c = new ConditionMprojectEmployeeSureIntegrl();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectEmployeeSureIntegrl> result = executeQueryMprojectEmployeeSureIntegrl(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectEmployeeSureIntegrl> result;
		ConditionMprojectEmployeeSureIntegrl c = new ConditionMprojectEmployeeSureIntegrl();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectEmployeeSureIntegrl dao = new QueryMprojectEmployeeSureIntegrl();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectEmployeeSureIntegrl.ALL_CAPTIONS);
			for(BaseMprojectEmployeeSureIntegrl b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


