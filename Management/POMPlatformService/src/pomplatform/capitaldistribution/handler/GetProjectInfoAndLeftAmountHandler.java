package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.ConditionGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.query.QueryGetProjectInfoAndLeftAmount;
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

public class GetProjectInfoAndLeftAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProjectInfoAndLeftAmountHandler.class);

	public static BaseCollection<BaseGetProjectInfoAndLeftAmount> executeQueryGetProjectInfoAndLeftAmount(ConditionGetProjectInfoAndLeftAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProjectInfoAndLeftAmount dao = new QueryGetProjectInfoAndLeftAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProjectInfoAndLeftAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProjectInfoAndLeftAmount c = new ConditionGetProjectInfoAndLeftAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProjectInfoAndLeftAmount> result = executeQueryGetProjectInfoAndLeftAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProjectInfoAndLeftAmount> result;
		ConditionGetProjectInfoAndLeftAmount c = new ConditionGetProjectInfoAndLeftAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProjectInfoAndLeftAmount dao = new QueryGetProjectInfoAndLeftAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProjectInfoAndLeftAmount.ALL_CAPTIONS);
			for(BaseGetProjectInfoAndLeftAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


