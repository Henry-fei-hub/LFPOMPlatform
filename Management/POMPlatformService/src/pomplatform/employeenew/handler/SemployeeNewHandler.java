package pomplatform.employeenew.handler;

import org.apache.log4j.Logger;
import pomplatform.employeenew.bean.BaseSemployeeNew;
import pomplatform.employeenew.bean.ConditionSemployeeNew;
import pomplatform.employeenew.query.QuerySemployeeNew;
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

public class SemployeeNewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeeNewHandler.class);

	public static BaseCollection<BaseSemployeeNew> executeQuerySemployeeNew(ConditionSemployeeNew c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeeNew dao = new QuerySemployeeNew();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeeNew> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeeNew c = new ConditionSemployeeNew();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeeNew> result = executeQuerySemployeeNew(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeeNew> result;
		ConditionSemployeeNew c = new ConditionSemployeeNew();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeeNew dao = new QuerySemployeeNew();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSemployeeNew.ALL_CAPTIONS);
			for(BaseSemployeeNew b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


