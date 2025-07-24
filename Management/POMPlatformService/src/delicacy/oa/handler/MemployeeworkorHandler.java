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
import delicacy.oa.bean.BaseMemployeeworkor;
import delicacy.oa.bean.ConditionMemployeeworkor;
import delicacy.oa.query.QueryMemployeeworkor;

public class MemployeeworkorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeworkorHandler.class);

	public static BaseCollection<BaseMemployeeworkor> executeQueryMemployeeworkor(ConditionMemployeeworkor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeworkor dao = new QueryMemployeeworkor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeworkor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeworkor c = new ConditionMemployeeworkor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeworkor> result = executeQueryMemployeeworkor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeworkor> result;
		ConditionMemployeeworkor c = new ConditionMemployeeworkor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeworkor dao = new QueryMemployeeworkor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeworkor.ALL_CAPTIONS);
			for(BaseMemployeeworkor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


