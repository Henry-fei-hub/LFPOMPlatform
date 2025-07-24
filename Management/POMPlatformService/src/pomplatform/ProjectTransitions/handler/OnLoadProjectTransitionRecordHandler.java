package pomplatform.ProjectTransitions.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectTransitions.bean.BaseOnLoadProjectTransitionRecord;
import pomplatform.ProjectTransitions.bean.ConditionOnLoadProjectTransitionRecord;
import pomplatform.ProjectTransitions.query.QueryOnLoadProjectTransitionRecord;
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

public class OnLoadProjectTransitionRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectTransitionRecordHandler.class);

	public static BaseCollection<BaseOnLoadProjectTransitionRecord> executeQueryOnLoadProjectTransitionRecord(ConditionOnLoadProjectTransitionRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectTransitionRecord dao = new QueryOnLoadProjectTransitionRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectTransitionRecord> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectTransitionRecord c = new ConditionOnLoadProjectTransitionRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectTransitionRecord> result = executeQueryOnLoadProjectTransitionRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectTransitionRecord> result;
		ConditionOnLoadProjectTransitionRecord c = new ConditionOnLoadProjectTransitionRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectTransitionRecord dao = new QueryOnLoadProjectTransitionRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectTransitionRecord.ALL_CAPTIONS);
			for(BaseOnLoadProjectTransitionRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


