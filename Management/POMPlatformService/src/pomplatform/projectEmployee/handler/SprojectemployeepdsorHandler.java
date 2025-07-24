package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseSprojectemployeepdsor;
import pomplatform.projectEmployee.bean.ConditionSprojectemployeepdsor;
import pomplatform.projectEmployee.query.QuerySprojectemployeepdsor;
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

public class SprojectemployeepdsorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectemployeepdsorHandler.class);

	public static BaseCollection<BaseSprojectemployeepdsor> executeQuerySprojectemployeepdsor(ConditionSprojectemployeepdsor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectemployeepdsor dao = new QuerySprojectemployeepdsor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectemployeepdsor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectemployeepdsor c = new ConditionSprojectemployeepdsor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectemployeepdsor> result = executeQuerySprojectemployeepdsor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectemployeepdsor> result;
		ConditionSprojectemployeepdsor c = new ConditionSprojectemployeepdsor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectemployeepdsor dao = new QuerySprojectemployeepdsor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectemployeepdsor.ALL_CAPTIONS);
			for(BaseSprojectemployeepdsor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


