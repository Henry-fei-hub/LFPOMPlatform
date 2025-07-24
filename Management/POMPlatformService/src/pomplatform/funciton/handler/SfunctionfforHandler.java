package pomplatform.funciton.handler;

import org.apache.log4j.Logger;
import pomplatform.funciton.bean.BaseSfunctionffor;
import pomplatform.funciton.bean.ConditionSfunctionffor;
import pomplatform.funciton.query.QuerySfunctionffor;
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

public class SfunctionfforHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SfunctionfforHandler.class);

	public static BaseCollection<BaseSfunctionffor> executeQuerySfunctionffor(ConditionSfunctionffor c, KeyValuePair[] replacements ) throws Exception {
		QuerySfunctionffor dao = new QuerySfunctionffor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSfunctionffor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSfunctionffor c = new ConditionSfunctionffor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSfunctionffor> result = executeQuerySfunctionffor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSfunctionffor> result;
		ConditionSfunctionffor c = new ConditionSfunctionffor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySfunctionffor dao = new QuerySfunctionffor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSfunctionffor.ALL_CAPTIONS);
			for(BaseSfunctionffor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


