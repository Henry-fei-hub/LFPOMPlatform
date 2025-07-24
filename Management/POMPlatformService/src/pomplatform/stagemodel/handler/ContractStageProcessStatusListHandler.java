package pomplatform.stagemodel.handler;

import org.apache.log4j.Logger;
import pomplatform.stagemodel.bean.BaseContractStageProcessStatusList;
import pomplatform.stagemodel.bean.ConditionContractStageProcessStatusList;
import pomplatform.stagemodel.query.QueryContractStageProcessStatusList;
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

public class ContractStageProcessStatusListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractStageProcessStatusListHandler.class);

	public static BaseCollection<BaseContractStageProcessStatusList> executeQueryContractStageProcessStatusList(ConditionContractStageProcessStatusList c, KeyValuePair[] replacements ) throws Exception {
		QueryContractStageProcessStatusList dao = new QueryContractStageProcessStatusList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractStageProcessStatusList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractStageProcessStatusList c = new ConditionContractStageProcessStatusList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractStageProcessStatusList> result = executeQueryContractStageProcessStatusList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractStageProcessStatusList> result;
		ConditionContractStageProcessStatusList c = new ConditionContractStageProcessStatusList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractStageProcessStatusList dao = new QueryContractStageProcessStatusList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractStageProcessStatusList.ALL_CAPTIONS);
			for(BaseContractStageProcessStatusList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


