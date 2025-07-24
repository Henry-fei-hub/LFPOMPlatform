package pomplatform.projectteambuild.handler;

import org.apache.log4j.Logger;
import pomplatform.projectteambuild.bean.BaseMprojectEmployeeGrades;
import pomplatform.projectteambuild.bean.ConditionMprojectEmployeeGrades;
import pomplatform.projectteambuild.query.QueryMprojectEmployeeGrades;
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

public class MprojectEmployeeGradesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectEmployeeGradesHandler.class);

	public static BaseCollection<BaseMprojectEmployeeGrades> executeQueryMprojectEmployeeGrades(ConditionMprojectEmployeeGrades c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectEmployeeGrades dao = new QueryMprojectEmployeeGrades();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectEmployeeGrades> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectEmployeeGrades c = new ConditionMprojectEmployeeGrades();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectEmployeeGrades> result = executeQueryMprojectEmployeeGrades(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectEmployeeGrades> result;
		ConditionMprojectEmployeeGrades c = new ConditionMprojectEmployeeGrades();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectEmployeeGrades dao = new QueryMprojectEmployeeGrades();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectEmployeeGrades.ALL_CAPTIONS);
			for(BaseMprojectEmployeeGrades b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


