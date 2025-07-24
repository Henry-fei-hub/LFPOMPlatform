package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeCost;
import pomplatform.report.bean.ConditionEmployeeCost;
import pomplatform.report.query.QueryEmployeeCost;
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

public class EmployeeCostHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeCostHandler.class);

	public static BaseCollection<BaseEmployeeCost> executeQueryEmployeeCost(ConditionEmployeeCost c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeCost dao = new QueryEmployeeCost();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeCost> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeCost c = new ConditionEmployeeCost();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeCost> result = executeQueryEmployeeCost(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeCost> result;
		ConditionEmployeeCost c = new ConditionEmployeeCost();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeCost dao = new QueryEmployeeCost();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeCost.ALL_CAPTIONS);
			for(BaseEmployeeCost b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


