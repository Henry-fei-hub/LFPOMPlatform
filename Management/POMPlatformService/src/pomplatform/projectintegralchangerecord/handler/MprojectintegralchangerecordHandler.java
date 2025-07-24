package pomplatform.projectintegralchangerecord.handler;

import org.apache.log4j.Logger;
import pomplatform.projectintegralchangerecord.bean.BaseMprojectintegralchangerecord;
import pomplatform.projectintegralchangerecord.bean.ConditionMprojectintegralchangerecord;
import pomplatform.projectintegralchangerecord.query.QueryMprojectintegralchangerecord;
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

public class MprojectintegralchangerecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectintegralchangerecordHandler.class);

	public static BaseCollection<BaseMprojectintegralchangerecord> executeQueryMprojectintegralchangerecord(ConditionMprojectintegralchangerecord c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectintegralchangerecord dao = new QueryMprojectintegralchangerecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectintegralchangerecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectintegralchangerecord c = new ConditionMprojectintegralchangerecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectintegralchangerecord> result = executeQueryMprojectintegralchangerecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectintegralchangerecord> result;
		ConditionMprojectintegralchangerecord c = new ConditionMprojectintegralchangerecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectintegralchangerecord dao = new QueryMprojectintegralchangerecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectintegralchangerecord.ALL_CAPTIONS);
			for(BaseMprojectintegralchangerecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


