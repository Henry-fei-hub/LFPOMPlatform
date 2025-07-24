package pomplatform.clocks.handler;

import org.apache.log4j.Logger;
import pomplatform.clocks.bean.BaseEmployeeFaces;
import pomplatform.clocks.bean.ConditionEmployeeFaces;
import pomplatform.clocks.query.QueryEmployeeFaces;
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

public class EmployeeFacesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeFacesHandler.class);

	public static BaseCollection<BaseEmployeeFaces> executeQueryEmployeeFaces(ConditionEmployeeFaces c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeFaces dao = new QueryEmployeeFaces();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeFaces> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeFaces c = new ConditionEmployeeFaces();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeFaces> result = executeQueryEmployeeFaces(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeFaces> result;
		ConditionEmployeeFaces c = new ConditionEmployeeFaces();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeFaces dao = new QueryEmployeeFaces();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeFaces.ALL_CAPTIONS);
			for(BaseEmployeeFaces b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


