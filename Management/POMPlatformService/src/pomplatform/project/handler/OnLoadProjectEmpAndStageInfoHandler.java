package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectEmpAndStageInfo;
import pomplatform.project.bean.ConditionOnLoadProjectEmpAndStageInfo;
import pomplatform.project.query.QueryOnLoadProjectEmpAndStageInfo;
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

public class OnLoadProjectEmpAndStageInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectEmpAndStageInfoHandler.class);

	public static BaseCollection<BaseOnLoadProjectEmpAndStageInfo> executeQueryOnLoadProjectEmpAndStageInfo(ConditionOnLoadProjectEmpAndStageInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectEmpAndStageInfo dao = new QueryOnLoadProjectEmpAndStageInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectEmpAndStageInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectEmpAndStageInfo c = new ConditionOnLoadProjectEmpAndStageInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectEmpAndStageInfo> result = executeQueryOnLoadProjectEmpAndStageInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectEmpAndStageInfo> result;
		ConditionOnLoadProjectEmpAndStageInfo c = new ConditionOnLoadProjectEmpAndStageInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectEmpAndStageInfo dao = new QueryOnLoadProjectEmpAndStageInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectEmpAndStageInfo.ALL_CAPTIONS);
			for(BaseOnLoadProjectEmpAndStageInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


