package pomplatform.trainingManagementdetailor.handler;

import org.apache.log4j.Logger;
import pomplatform.trainingManagementdetailor.bean.BaseStrainingmanagementdetailor;
import pomplatform.trainingManagementdetailor.bean.ConditionStrainingmanagementdetailor;
import pomplatform.trainingManagementdetailor.query.QueryStrainingmanagementdetailor;
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

public class StrainingmanagementdetailorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StrainingmanagementdetailorHandler.class);

	public static BaseCollection<BaseStrainingmanagementdetailor> executeQueryStrainingmanagementdetailor(ConditionStrainingmanagementdetailor c, KeyValuePair[] replacements ) throws Exception {
		QueryStrainingmanagementdetailor dao = new QueryStrainingmanagementdetailor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStrainingmanagementdetailor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStrainingmanagementdetailor c = new ConditionStrainingmanagementdetailor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStrainingmanagementdetailor> result = executeQueryStrainingmanagementdetailor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStrainingmanagementdetailor> result;
		ConditionStrainingmanagementdetailor c = new ConditionStrainingmanagementdetailor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStrainingmanagementdetailor dao = new QueryStrainingmanagementdetailor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStrainingmanagementdetailor.ALL_CAPTIONS);
			for(BaseStrainingmanagementdetailor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


