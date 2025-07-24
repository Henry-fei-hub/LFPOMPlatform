package delicacy.oa.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.oa.bean.BaseMclasstypecior;
import delicacy.oa.bean.ConditionMclasstypecior;
import delicacy.oa.query.QueryMclasstypecior;

public class MclasstypeciorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MclasstypeciorHandler.class);

	public static BaseCollection<BaseMclasstypecior> executeQueryMclasstypecior(ConditionMclasstypecior c, KeyValuePair[] replacements ) throws Exception {
		QueryMclasstypecior dao = new QueryMclasstypecior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMclasstypecior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMclasstypecior c = new ConditionMclasstypecior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMclasstypecior> result = executeQueryMclasstypecior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMclasstypecior> result;
		ConditionMclasstypecior c = new ConditionMclasstypecior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMclasstypecior dao = new QueryMclasstypecior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMclasstypecior.ALL_CAPTIONS);
			for(BaseMclasstypecior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


