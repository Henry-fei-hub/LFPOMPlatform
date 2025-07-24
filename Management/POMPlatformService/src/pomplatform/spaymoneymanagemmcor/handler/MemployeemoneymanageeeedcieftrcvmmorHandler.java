package pomplatform.spaymoneymanagemmcor.handler;

import org.apache.log4j.Logger;
import pomplatform.spaymoneymanagemmcor.bean.BaseMemployeemoneymanageeeedcieftrcvmmor;
import pomplatform.spaymoneymanagemmcor.bean.ConditionMemployeemoneymanageeeedcieftrcvmmor;
import pomplatform.spaymoneymanagemmcor.query.QueryMemployeemoneymanageeeedcieftrcvmmor;
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

public class MemployeemoneymanageeeedcieftrcvmmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeemoneymanageeeedcieftrcvmmorHandler.class);

	public static BaseCollection<BaseMemployeemoneymanageeeedcieftrcvmmor> executeQueryMemployeemoneymanageeeedcieftrcvmmor(ConditionMemployeemoneymanageeeedcieftrcvmmor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeemoneymanageeeedcieftrcvmmor dao = new QueryMemployeemoneymanageeeedcieftrcvmmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeemoneymanageeeedcieftrcvmmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeemoneymanageeeedcieftrcvmmor c = new ConditionMemployeemoneymanageeeedcieftrcvmmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeemoneymanageeeedcieftrcvmmor> result = executeQueryMemployeemoneymanageeeedcieftrcvmmor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeemoneymanageeeedcieftrcvmmor> result;
		ConditionMemployeemoneymanageeeedcieftrcvmmor c = new ConditionMemployeemoneymanageeeedcieftrcvmmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeemoneymanageeeedcieftrcvmmor dao = new QueryMemployeemoneymanageeeedcieftrcvmmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeemoneymanageeeedcieftrcvmmor.ALL_CAPTIONS);
			for(BaseMemployeemoneymanageeeedcieftrcvmmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


