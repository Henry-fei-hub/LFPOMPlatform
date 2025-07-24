package pomplatform.cwd.handler;

import org.apache.log4j.Logger;
import pomplatform.cwd.bean.BaseScwdfilingmaintemplatetrcor;
import pomplatform.cwd.bean.ConditionScwdfilingmaintemplatetrcor;
import pomplatform.cwd.query.QueryScwdfilingmaintemplatetrcor;
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

public class ScwdfilingmaintemplatetrcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScwdfilingmaintemplatetrcorHandler.class);

	public static BaseCollection<BaseScwdfilingmaintemplatetrcor> executeQueryScwdfilingmaintemplatetrcor(ConditionScwdfilingmaintemplatetrcor c, KeyValuePair[] replacements ) throws Exception {
		QueryScwdfilingmaintemplatetrcor dao = new QueryScwdfilingmaintemplatetrcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScwdfilingmaintemplatetrcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScwdfilingmaintemplatetrcor c = new ConditionScwdfilingmaintemplatetrcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScwdfilingmaintemplatetrcor> result = executeQueryScwdfilingmaintemplatetrcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScwdfilingmaintemplatetrcor> result;
		ConditionScwdfilingmaintemplatetrcor c = new ConditionScwdfilingmaintemplatetrcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScwdfilingmaintemplatetrcor dao = new QueryScwdfilingmaintemplatetrcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScwdfilingmaintemplatetrcor.ALL_CAPTIONS);
			for(BaseScwdfilingmaintemplatetrcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


