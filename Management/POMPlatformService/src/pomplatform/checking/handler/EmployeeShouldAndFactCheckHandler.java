package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseEmployeeShouldAndFactCheck;
import pomplatform.checking.bean.ConditionEmployeeShouldAndFactCheck;
import pomplatform.checking.query.QueryEmployeeShouldAndFactCheck;
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

public class EmployeeShouldAndFactCheckHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeShouldAndFactCheckHandler.class);

	public static BaseCollection<BaseEmployeeShouldAndFactCheck> executeQueryEmployeeShouldAndFactCheck(ConditionEmployeeShouldAndFactCheck c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeShouldAndFactCheck dao = new QueryEmployeeShouldAndFactCheck();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeShouldAndFactCheck> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeShouldAndFactCheck c = new ConditionEmployeeShouldAndFactCheck();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeShouldAndFactCheck> result = executeQueryEmployeeShouldAndFactCheck(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeShouldAndFactCheck> result;
		ConditionEmployeeShouldAndFactCheck c = new ConditionEmployeeShouldAndFactCheck();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeShouldAndFactCheck dao = new QueryEmployeeShouldAndFactCheck();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeShouldAndFactCheck.ALL_CAPTIONS);
			for(BaseEmployeeShouldAndFactCheck b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


