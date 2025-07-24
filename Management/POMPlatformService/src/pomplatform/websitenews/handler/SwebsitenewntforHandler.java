package pomplatform.websitenews.handler;

import org.apache.log4j.Logger;
import pomplatform.websitenews.bean.BaseSwebsitenewntfor;
import pomplatform.websitenews.bean.ConditionSwebsitenewntfor;
import pomplatform.websitenews.query.QuerySwebsitenewntfor;
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

public class SwebsitenewntforHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SwebsitenewntforHandler.class);

	public static BaseCollection<BaseSwebsitenewntfor> executeQuerySwebsitenewntfor(ConditionSwebsitenewntfor c, KeyValuePair[] replacements ) throws Exception {
		QuerySwebsitenewntfor dao = new QuerySwebsitenewntfor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSwebsitenewntfor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSwebsitenewntfor c = new ConditionSwebsitenewntfor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSwebsitenewntfor> result = executeQuerySwebsitenewntfor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSwebsitenewntfor> result;
		ConditionSwebsitenewntfor c = new ConditionSwebsitenewntfor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySwebsitenewntfor dao = new QuerySwebsitenewntfor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSwebsitenewntfor.ALL_CAPTIONS);
			for(BaseSwebsitenewntfor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


