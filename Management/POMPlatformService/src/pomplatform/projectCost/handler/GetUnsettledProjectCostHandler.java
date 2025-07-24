package pomplatform.projectCost.handler;

import org.apache.log4j.Logger;
import pomplatform.projectCost.bean.BaseGetUnsettledProjectCost;
import pomplatform.projectCost.bean.ConditionGetUnsettledProjectCost;
import pomplatform.projectCost.query.QueryGetUnsettledProjectCost;
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

public class GetUnsettledProjectCostHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetUnsettledProjectCostHandler.class);

	public static BaseCollection<BaseGetUnsettledProjectCost> executeQueryGetUnsettledProjectCost(ConditionGetUnsettledProjectCost c, KeyValuePair[] replacements ) throws Exception {
		QueryGetUnsettledProjectCost dao = new QueryGetUnsettledProjectCost();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetUnsettledProjectCost> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetUnsettledProjectCost c = new ConditionGetUnsettledProjectCost();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetUnsettledProjectCost> result = executeQueryGetUnsettledProjectCost(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetUnsettledProjectCost> result;
		ConditionGetUnsettledProjectCost c = new ConditionGetUnsettledProjectCost();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetUnsettledProjectCost dao = new QueryGetUnsettledProjectCost();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetUnsettledProjectCost.ALL_CAPTIONS);
			for(BaseGetUnsettledProjectCost b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


