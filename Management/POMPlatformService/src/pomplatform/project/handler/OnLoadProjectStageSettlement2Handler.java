package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement2;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement2;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement2;
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

public class OnLoadProjectStageSettlement2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectStageSettlement2Handler.class);

	public static BaseCollection<BaseOnLoadProjectStageSettlement2> executeQueryOnLoadProjectStageSettlement2(ConditionOnLoadProjectStageSettlement2 c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectStageSettlement2 dao = new QueryOnLoadProjectStageSettlement2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectStageSettlement2> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectStageSettlement2 c = new ConditionOnLoadProjectStageSettlement2();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectStageSettlement2> result = executeQueryOnLoadProjectStageSettlement2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectStageSettlement2> result;
		ConditionOnLoadProjectStageSettlement2 c = new ConditionOnLoadProjectStageSettlement2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectStageSettlement2 dao = new QueryOnLoadProjectStageSettlement2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectStageSettlement2.ALL_CAPTIONS);
			for(BaseOnLoadProjectStageSettlement2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


