package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeStructureOverview1;
import pomplatform.report.bean.ConditionEmployeeStructureOverview1;
import pomplatform.report.query.QueryEmployeeStructureOverview1;
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

public class EmployeeStructureOverview1Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeStructureOverview1Handler.class);

	public static BaseCollection<BaseEmployeeStructureOverview1> executeQueryEmployeeStructureOverview1(ConditionEmployeeStructureOverview1 c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeStructureOverview1 dao = new QueryEmployeeStructureOverview1();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeStructureOverview1> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeStructureOverview1 c = new ConditionEmployeeStructureOverview1();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeStructureOverview1> result = executeQueryEmployeeStructureOverview1(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeStructureOverview1> result;
		ConditionEmployeeStructureOverview1 c = new ConditionEmployeeStructureOverview1();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeStructureOverview1 dao = new QueryEmployeeStructureOverview1();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeStructureOverview1.ALL_CAPTIONS);
			for(BaseEmployeeStructureOverview1 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


