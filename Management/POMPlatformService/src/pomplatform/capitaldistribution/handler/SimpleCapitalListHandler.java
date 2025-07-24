package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseSimpleCapitalList;
import pomplatform.capitaldistribution.bean.ConditionSimpleCapitalList;
import pomplatform.capitaldistribution.query.QuerySimpleCapitalList;
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

public class SimpleCapitalListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SimpleCapitalListHandler.class);

	public static BaseCollection<BaseSimpleCapitalList> executeQuerySimpleCapitalList(ConditionSimpleCapitalList c, KeyValuePair[] replacements ) throws Exception {
		QuerySimpleCapitalList dao = new QuerySimpleCapitalList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSimpleCapitalList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSimpleCapitalList c = new ConditionSimpleCapitalList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSimpleCapitalList> result = executeQuerySimpleCapitalList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSimpleCapitalList> result;
		ConditionSimpleCapitalList c = new ConditionSimpleCapitalList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySimpleCapitalList dao = new QuerySimpleCapitalList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSimpleCapitalList.ALL_CAPTIONS);
			for(BaseSimpleCapitalList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


