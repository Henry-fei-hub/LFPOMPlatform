package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseLoadSalaryTotal;
import pomplatform.payment.bean.ConditionLoadSalaryTotal;
import pomplatform.payment.query.QueryLoadSalaryTotal;
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

public class LoadSalaryTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LoadSalaryTotalHandler.class);

	public static BaseCollection<BaseLoadSalaryTotal> executeQueryLoadSalaryTotal(ConditionLoadSalaryTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryLoadSalaryTotal dao = new QueryLoadSalaryTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLoadSalaryTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLoadSalaryTotal c = new ConditionLoadSalaryTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLoadSalaryTotal> result = executeQueryLoadSalaryTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLoadSalaryTotal> result;
		ConditionLoadSalaryTotal c = new ConditionLoadSalaryTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLoadSalaryTotal dao = new QueryLoadSalaryTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLoadSalaryTotal.ALL_CAPTIONS);
			for(BaseLoadSalaryTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


