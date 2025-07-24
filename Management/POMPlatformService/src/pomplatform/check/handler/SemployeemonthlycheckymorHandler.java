package pomplatform.check.handler;

import org.apache.log4j.Logger;
import pomplatform.check.bean.BaseSemployeemonthlycheckymor;
import pomplatform.check.bean.ConditionSemployeemonthlycheckymor;
import pomplatform.check.query.QuerySemployeemonthlycheckymor;
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

public class SemployeemonthlycheckymorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeemonthlycheckymorHandler.class);

	public static BaseCollection<BaseSemployeemonthlycheckymor> executeQuerySemployeemonthlycheckymor(ConditionSemployeemonthlycheckymor c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeemonthlycheckymor dao = new QuerySemployeemonthlycheckymor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeemonthlycheckymor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeemonthlycheckymor c = new ConditionSemployeemonthlycheckymor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeemonthlycheckymor> result = executeQuerySemployeemonthlycheckymor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeemonthlycheckymor> result;
		ConditionSemployeemonthlycheckymor c = new ConditionSemployeemonthlycheckymor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeemonthlycheckymor dao = new QuerySemployeemonthlycheckymor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSemployeemonthlycheckymor.ALL_CAPTIONS);
			for(BaseSemployeemonthlycheckymor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


