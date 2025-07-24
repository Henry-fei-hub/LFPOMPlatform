package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseQueryLoadSalaryTotal2;
import pomplatform.payment.bean.ConditionQueryLoadSalaryTotal2;
import pomplatform.payment.query.QueryQueryLoadSalaryTotal2;
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

public class QueryLoadSalaryTotal2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(QueryLoadSalaryTotal2Handler.class);

	public static BaseCollection<BaseQueryLoadSalaryTotal2> executeQueryQueryLoadSalaryTotal2(ConditionQueryLoadSalaryTotal2 c, KeyValuePair[] replacements ) throws Exception {
		QueryQueryLoadSalaryTotal2 dao = new QueryQueryLoadSalaryTotal2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQueryLoadSalaryTotal2> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQueryLoadSalaryTotal2 c = new ConditionQueryLoadSalaryTotal2();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQueryLoadSalaryTotal2> result = executeQueryQueryLoadSalaryTotal2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQueryLoadSalaryTotal2> result;
		ConditionQueryLoadSalaryTotal2 c = new ConditionQueryLoadSalaryTotal2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryQueryLoadSalaryTotal2 dao = new QueryQueryLoadSalaryTotal2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQueryLoadSalaryTotal2.ALL_CAPTIONS);
			for(BaseQueryLoadSalaryTotal2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


