package pomplatform.stagemodel.handler;

import org.apache.log4j.Logger;
import pomplatform.stagemodel.bean.BaseStageContractInfoList;
import pomplatform.stagemodel.bean.ConditionStageContractInfoList;
import pomplatform.stagemodel.query.QueryStageContractInfoList;
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

public class StageContractInfoListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StageContractInfoListHandler.class);

	public static BaseCollection<BaseStageContractInfoList> executeQueryStageContractInfoList(ConditionStageContractInfoList c, KeyValuePair[] replacements ) throws Exception {
		QueryStageContractInfoList dao = new QueryStageContractInfoList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStageContractInfoList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStageContractInfoList c = new ConditionStageContractInfoList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStageContractInfoList> result = executeQueryStageContractInfoList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStageContractInfoList> result;
		ConditionStageContractInfoList c = new ConditionStageContractInfoList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStageContractInfoList dao = new QueryStageContractInfoList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStageContractInfoList.ALL_CAPTIONS);
			for(BaseStageContractInfoList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


