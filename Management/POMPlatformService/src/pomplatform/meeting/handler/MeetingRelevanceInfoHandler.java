package pomplatform.meeting.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingRelevanceInfo;
import pomplatform.meeting.bean.ConditionMeetingRelevanceInfo;
import pomplatform.meeting.query.QueryMeetingRelevanceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class MeetingRelevanceInfoHandler implements GenericQuery,  GenericDownloadProcessor {


	private static final Logger __logger = Logger.getLogger(MeetingRelevanceInfoHandler.class);


	public static BaseCollection<BaseMeetingRelevanceInfo> executeQueryMeetingRelevanceInfo(ConditionMeetingRelevanceInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryMeetingRelevanceInfo dao = new QueryMeetingRelevanceInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMeetingRelevanceInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMeetingRelevanceInfo c = new ConditionMeetingRelevanceInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMeetingRelevanceInfo> result = executeQueryMeetingRelevanceInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMeetingRelevanceInfo> result;
		ConditionMeetingRelevanceInfo c = new ConditionMeetingRelevanceInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMeetingRelevanceInfo dao = new QueryMeetingRelevanceInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMeetingRelevanceInfo.ALL_CAPTIONS);
			for(BaseMeetingRelevanceInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


