package pomplatform.sprojectintegralsumrecordpymor.handler;

import org.apache.log4j.Logger;
import pomplatform.sprojectintegralsumrecordpymor.bean.BaseSprojectintegralsumrecordpymor;
import pomplatform.sprojectintegralsumrecordpymor.bean.ConditionSprojectintegralsumrecordpymor;
import pomplatform.sprojectintegralsumrecordpymor.query.QuerySprojectintegralsumrecordpymor;
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

public class SprojectintegralsumrecordpymorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectintegralsumrecordpymorHandler.class);

	public static BaseCollection<BaseSprojectintegralsumrecordpymor> executeQuerySprojectintegralsumrecordpymor(ConditionSprojectintegralsumrecordpymor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectintegralsumrecordpymor dao = new QuerySprojectintegralsumrecordpymor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectintegralsumrecordpymor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectintegralsumrecordpymor c = new ConditionSprojectintegralsumrecordpymor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectintegralsumrecordpymor> result = executeQuerySprojectintegralsumrecordpymor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectintegralsumrecordpymor> result;
		ConditionSprojectintegralsumrecordpymor c = new ConditionSprojectintegralsumrecordpymor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectintegralsumrecordpymor dao = new QuerySprojectintegralsumrecordpymor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectintegralsumrecordpymor.ALL_CAPTIONS);
			for(BaseSprojectintegralsumrecordpymor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


