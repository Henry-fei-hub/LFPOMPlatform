package pomplatform.subContractInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.subContractInfo.bean.BaseProjectCostList;
import pomplatform.subContractInfo.bean.ConditionProjectCostList;
import pomplatform.subContractInfo.query.QueryProjectCostList;
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

public class ProjectCostListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectCostListHandler.class);

	public static BaseCollection<BaseProjectCostList> executeQueryProjectCostList(ConditionProjectCostList c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectCostList dao = new QueryProjectCostList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectCostList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectCostList c = new ConditionProjectCostList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectCostList> result = executeQueryProjectCostList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectCostList> result;
		ConditionProjectCostList c = new ConditionProjectCostList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectCostList dao = new QueryProjectCostList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectCostList.ALL_CAPTIONS);
			for(BaseProjectCostList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


