package pomplatform.employeeSalary.handler;

import org.apache.log4j.Logger;

import pomplatform.employeeSalary.bean.BaseMemployeeSalary;
import pomplatform.employeeSalary.bean.ConditionMemployeeSalary;
import pomplatform.employeeSalary.query.QueryMemployeeSalary;
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

public class MemployeeSalaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeSalaryHandler.class);

	public static BaseCollection<BaseMemployeeSalary> executeQueryMemployeeSalary(ConditionMemployeeSalary c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeSalary dao = new QueryMemployeeSalary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeSalary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeSalary c = new ConditionMemployeeSalary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeSalary> result = executeQueryMemployeeSalary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeSalary> result;
		ConditionMemployeeSalary c = new ConditionMemployeeSalary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeSalary dao = new QueryMemployeeSalary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeSalary.ALL_CAPTIONS);
			for(BaseMemployeeSalary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


