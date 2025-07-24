package pomplatform.projectintegraltransferrecord.handler;

import org.apache.log4j.Logger;
import pomplatform.projectintegraltransferrecord.bean.BaseMprojectintegraltransferrecord;
import pomplatform.projectintegraltransferrecord.bean.ConditionMprojectintegraltransferrecord;
import pomplatform.projectintegraltransferrecord.query.QueryMprojectintegraltransferrecord;
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

public class MprojectintegraltransferrecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectintegraltransferrecordHandler.class);

	public static BaseCollection<BaseMprojectintegraltransferrecord> executeQueryMprojectintegraltransferrecord(ConditionMprojectintegraltransferrecord c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectintegraltransferrecord dao = new QueryMprojectintegraltransferrecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectintegraltransferrecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectintegraltransferrecord c = new ConditionMprojectintegraltransferrecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectintegraltransferrecord> result = executeQueryMprojectintegraltransferrecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectintegraltransferrecord> result;
		ConditionMprojectintegraltransferrecord c = new ConditionMprojectintegraltransferrecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectintegraltransferrecord dao = new QueryMprojectintegraltransferrecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectintegraltransferrecord.ALL_CAPTIONS);
			for(BaseMprojectintegraltransferrecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


