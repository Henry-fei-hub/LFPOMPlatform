package pomplatform.salarytotalrecord.handler;

import org.apache.log4j.Logger;
import pomplatform.salarytotalrecord.bean.BaseSalaryVoucherInfo;
import pomplatform.salarytotalrecord.bean.ConditionSalaryVoucherInfo;
import pomplatform.salarytotalrecord.query.QuerySalaryVoucherInfo;
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

public class SalaryVoucherInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryVoucherInfoHandler.class);

	public static BaseCollection<BaseSalaryVoucherInfo> executeQuerySalaryVoucherInfo(ConditionSalaryVoucherInfo c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryVoucherInfo dao = new QuerySalaryVoucherInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryVoucherInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryVoucherInfo c = new ConditionSalaryVoucherInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryVoucherInfo> result = executeQuerySalaryVoucherInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryVoucherInfo> result;
		ConditionSalaryVoucherInfo c = new ConditionSalaryVoucherInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryVoucherInfo dao = new QuerySalaryVoucherInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryVoucherInfo.ALL_CAPTIONS);
			for(BaseSalaryVoucherInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


