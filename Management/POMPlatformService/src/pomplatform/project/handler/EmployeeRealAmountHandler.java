package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseEmployeeRealAmount;
import pomplatform.project.bean.ConditionEmployeeRealAmount;
import pomplatform.project.query.QueryEmployeeRealAmount;
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

public class EmployeeRealAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeRealAmountHandler.class);

	public static BaseCollection<BaseEmployeeRealAmount> executeQueryEmployeeRealAmount(ConditionEmployeeRealAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeRealAmount dao = new QueryEmployeeRealAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeRealAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeRealAmount c = new ConditionEmployeeRealAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeRealAmount> result = executeQueryEmployeeRealAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeRealAmount> result;
		ConditionEmployeeRealAmount c = new ConditionEmployeeRealAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeRealAmount dao = new QueryEmployeeRealAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseEmployeeRealAmount.ALL_CAPTIONS);
			for(BaseEmployeeRealAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


