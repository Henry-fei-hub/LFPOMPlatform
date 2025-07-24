package pomplatform.oa.handler;

import org.apache.log4j.Logger;
import pomplatform.oa.bean.BaseScheckinfoseor;
import pomplatform.oa.bean.ConditionScheckinfoseor;
import pomplatform.oa.query.QueryScheckinfoseor;
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

public class ScheckinfoseorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScheckinfoseorHandler.class);

	public static BaseCollection<BaseScheckinfoseor> executeQueryScheckinfoseor(ConditionScheckinfoseor c, KeyValuePair[] replacements ) throws Exception {
		QueryScheckinfoseor dao = new QueryScheckinfoseor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScheckinfoseor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScheckinfoseor c = new ConditionScheckinfoseor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScheckinfoseor> result = executeQueryScheckinfoseor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScheckinfoseor> result;
		ConditionScheckinfoseor c = new ConditionScheckinfoseor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScheckinfoseor dao = new QueryScheckinfoseor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseScheckinfoseor.ALL_CAPTIONS);
			for(BaseScheckinfoseor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


