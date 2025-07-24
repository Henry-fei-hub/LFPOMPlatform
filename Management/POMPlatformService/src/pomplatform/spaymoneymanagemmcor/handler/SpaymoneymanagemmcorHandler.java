package pomplatform.spaymoneymanagemmcor.handler;

import org.apache.log4j.Logger;
import pomplatform.spaymoneymanagemmcor.bean.BaseSpaymoneymanagemmcor;
import pomplatform.spaymoneymanagemmcor.bean.ConditionSpaymoneymanagemmcor;
import pomplatform.spaymoneymanagemmcor.query.QuerySpaymoneymanagemmcor;
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

public class SpaymoneymanagemmcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpaymoneymanagemmcorHandler.class);

	public static BaseCollection<BaseSpaymoneymanagemmcor> executeQuerySpaymoneymanagemmcor(ConditionSpaymoneymanagemmcor c, KeyValuePair[] replacements ) throws Exception {
		QuerySpaymoneymanagemmcor dao = new QuerySpaymoneymanagemmcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpaymoneymanagemmcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpaymoneymanagemmcor c = new ConditionSpaymoneymanagemmcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpaymoneymanagemmcor> result = executeQuerySpaymoneymanagemmcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpaymoneymanagemmcor> result;
		ConditionSpaymoneymanagemmcor c = new ConditionSpaymoneymanagemmcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpaymoneymanagemmcor dao = new QuerySpaymoneymanagemmcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpaymoneymanagemmcor.ALL_CAPTIONS);
			for(BaseSpaymoneymanagemmcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


