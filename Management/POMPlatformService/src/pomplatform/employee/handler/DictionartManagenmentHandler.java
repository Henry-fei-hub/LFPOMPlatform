package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseDictionartManagenment;
import pomplatform.employee.bean.ConditionDictionartManagenment;
import pomplatform.employee.query.QueryDictionartManagenment;
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

public class DictionartManagenmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DictionartManagenmentHandler.class);

	public static BaseCollection<BaseDictionartManagenment> executeQueryDictionartManagenment(ConditionDictionartManagenment c, KeyValuePair[] replacements ) throws Exception {
		QueryDictionartManagenment dao = new QueryDictionartManagenment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDictionartManagenment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDictionartManagenment c = new ConditionDictionartManagenment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDictionartManagenment> result = executeQueryDictionartManagenment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDictionartManagenment> result;
		ConditionDictionartManagenment c = new ConditionDictionartManagenment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDictionartManagenment dao = new QueryDictionartManagenment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDictionartManagenment.ALL_CAPTIONS);
			for(BaseDictionartManagenment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


