package pomplatform.stage.handler;

import org.apache.log4j.Logger;
import pomplatform.stage.bean.BaseOnLoadMainProjectStageByParentId;
import pomplatform.stage.bean.ConditionOnLoadMainProjectStageByParentId;
import pomplatform.stage.query.QueryOnLoadMainProjectStageByParentId;
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

public class OnLoadMainProjectStageByParentIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMainProjectStageByParentIdHandler.class);

	public static BaseCollection<BaseOnLoadMainProjectStageByParentId> executeQueryOnLoadMainProjectStageByParentId(ConditionOnLoadMainProjectStageByParentId c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMainProjectStageByParentId dao = new QueryOnLoadMainProjectStageByParentId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMainProjectStageByParentId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMainProjectStageByParentId c = new ConditionOnLoadMainProjectStageByParentId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMainProjectStageByParentId> result = executeQueryOnLoadMainProjectStageByParentId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMainProjectStageByParentId> result;
		ConditionOnLoadMainProjectStageByParentId c = new ConditionOnLoadMainProjectStageByParentId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMainProjectStageByParentId dao = new QueryOnLoadMainProjectStageByParentId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMainProjectStageByParentId.ALL_CAPTIONS);
			for(BaseOnLoadMainProjectStageByParentId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


