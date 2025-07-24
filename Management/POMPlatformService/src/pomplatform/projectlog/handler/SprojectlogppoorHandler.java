package pomplatform.projectlog.handler;

import org.apache.log4j.Logger;
import pomplatform.projectlog.bean.BaseSprojectlogppoor;
import pomplatform.projectlog.bean.ConditionSprojectlogppoor;
import pomplatform.projectlog.query.QuerySprojectlogppoor;
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

public class SprojectlogppoorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectlogppoorHandler.class);

	public static BaseCollection<BaseSprojectlogppoor> executeQuerySprojectlogppoor(ConditionSprojectlogppoor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectlogppoor dao = new QuerySprojectlogppoor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectlogppoor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectlogppoor c = new ConditionSprojectlogppoor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectlogppoor> result = executeQuerySprojectlogppoor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectlogppoor> result;
		ConditionSprojectlogppoor c = new ConditionSprojectlogppoor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectlogppoor dao = new QuerySprojectlogppoor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectlogppoor.ALL_CAPTIONS);
			for(BaseSprojectlogppoor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


