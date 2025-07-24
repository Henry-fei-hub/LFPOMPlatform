package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridEmployeeInDepartment;
import pomplatform.selectgrid.bean.ConditionSelectGridEmployeeInDepartment;
import pomplatform.selectgrid.query.QuerySelectGridEmployeeInDepartment;
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

public class SelectGridEmployeeInDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridEmployeeInDepartmentHandler.class);

	public static BaseCollection<BaseSelectGridEmployeeInDepartment> executeQuerySelectGridEmployeeInDepartment(ConditionSelectGridEmployeeInDepartment c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridEmployeeInDepartment dao = new QuerySelectGridEmployeeInDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridEmployeeInDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridEmployeeInDepartment c = new ConditionSelectGridEmployeeInDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridEmployeeInDepartment> result = executeQuerySelectGridEmployeeInDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridEmployeeInDepartment> result;
		ConditionSelectGridEmployeeInDepartment c = new ConditionSelectGridEmployeeInDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridEmployeeInDepartment dao = new QuerySelectGridEmployeeInDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridEmployeeInDepartment.ALL_CAPTIONS);
			for(BaseSelectGridEmployeeInDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


