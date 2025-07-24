package pomplatform.addProjectEmpSalary.handler;

import org.apache.log4j.Logger;
import pomplatform.addProjectEmpSalary.bean.BaseMaddProjectEmpSalary;
import pomplatform.addProjectEmpSalary.bean.ConditionMaddProjectEmpSalary;
import pomplatform.addProjectEmpSalary.query.QueryMaddProjectEmpSalary;
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

public class MaddProjectEmpSalaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MaddProjectEmpSalaryHandler.class);

	public static BaseCollection<BaseMaddProjectEmpSalary> executeQueryMaddProjectEmpSalary(ConditionMaddProjectEmpSalary c, KeyValuePair[] replacements ) throws Exception {
		QueryMaddProjectEmpSalary dao = new QueryMaddProjectEmpSalary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMaddProjectEmpSalary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMaddProjectEmpSalary c = new ConditionMaddProjectEmpSalary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMaddProjectEmpSalary> result = executeQueryMaddProjectEmpSalary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMaddProjectEmpSalary> result;
		ConditionMaddProjectEmpSalary c = new ConditionMaddProjectEmpSalary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMaddProjectEmpSalary dao = new QueryMaddProjectEmpSalary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMaddProjectEmpSalary.ALL_CAPTIONS);
			for(BaseMaddProjectEmpSalary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


