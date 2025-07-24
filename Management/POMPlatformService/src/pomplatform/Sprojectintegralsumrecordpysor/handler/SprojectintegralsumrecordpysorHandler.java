package pomplatform.Sprojectintegralsumrecordpysor.handler;

import org.apache.log4j.Logger;
import pomplatform.Sprojectintegralsumrecordpysor.bean.BaseSprojectintegralsumrecordpysor;
import pomplatform.Sprojectintegralsumrecordpysor.bean.ConditionSprojectintegralsumrecordpysor;
import pomplatform.Sprojectintegralsumrecordpysor.query.QuerySprojectintegralsumrecordpysor;
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

public class SprojectintegralsumrecordpysorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectintegralsumrecordpysorHandler.class);

	public static BaseCollection<BaseSprojectintegralsumrecordpysor> executeQuerySprojectintegralsumrecordpysor(ConditionSprojectintegralsumrecordpysor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectintegralsumrecordpysor dao = new QuerySprojectintegralsumrecordpysor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectintegralsumrecordpysor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectintegralsumrecordpysor c = new ConditionSprojectintegralsumrecordpysor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectintegralsumrecordpysor> result = executeQuerySprojectintegralsumrecordpysor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectintegralsumrecordpysor> result;
		ConditionSprojectintegralsumrecordpysor c = new ConditionSprojectintegralsumrecordpysor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectintegralsumrecordpysor dao = new QuerySprojectintegralsumrecordpysor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectintegralsumrecordpysor.ALL_CAPTIONS);
			for(BaseSprojectintegralsumrecordpysor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


