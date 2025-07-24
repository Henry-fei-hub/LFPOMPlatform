package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseProjectSubsidyDetail;
import pomplatform.account.bean.ConditionProjectSubsidyDetail;
import pomplatform.account.query.QueryProjectSubsidyDetail;
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

public class ProjectSubsidyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectSubsidyDetailHandler.class);

	public static BaseCollection<BaseProjectSubsidyDetail> executeQueryProjectSubsidyDetail(ConditionProjectSubsidyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectSubsidyDetail dao = new QueryProjectSubsidyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectSubsidyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectSubsidyDetail c = new ConditionProjectSubsidyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectSubsidyDetail> result = executeQueryProjectSubsidyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectSubsidyDetail> result;
		ConditionProjectSubsidyDetail c = new ConditionProjectSubsidyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectSubsidyDetail dao = new QueryProjectSubsidyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectSubsidyDetail.ALL_CAPTIONS);
			for(BaseProjectSubsidyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


