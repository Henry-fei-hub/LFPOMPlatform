package pomplatform.projectSureDateRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSureDateRecord.bean.BaseProjectSureDateRecord;
import pomplatform.projectSureDateRecord.bean.ConditionProjectSureDateRecord;
import pomplatform.projectSureDateRecord.query.QueryProjectSureDateRecord;
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

public class ProjectSureDateRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectSureDateRecordHandler.class);

	public static BaseCollection<BaseProjectSureDateRecord> executeQueryProjectSureDateRecord(ConditionProjectSureDateRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectSureDateRecord dao = new QueryProjectSureDateRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectSureDateRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectSureDateRecord c = new ConditionProjectSureDateRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectSureDateRecord> result = executeQueryProjectSureDateRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectSureDateRecord> result;
		ConditionProjectSureDateRecord c = new ConditionProjectSureDateRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectSureDateRecord dao = new QueryProjectSureDateRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectSureDateRecord.ALL_CAPTIONS);
			for(BaseProjectSureDateRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


