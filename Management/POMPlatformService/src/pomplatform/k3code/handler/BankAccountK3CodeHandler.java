package pomplatform.k3code.handler;

import org.apache.log4j.Logger;
import pomplatform.k3code.bean.BaseBankAccountK3Code;
import pomplatform.k3code.bean.ConditionBankAccountK3Code;
import pomplatform.k3code.query.QueryBankAccountK3Code;
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

public class BankAccountK3CodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BankAccountK3CodeHandler.class);

	public static BaseCollection<BaseBankAccountK3Code> executeQueryBankAccountK3Code(ConditionBankAccountK3Code c, KeyValuePair[] replacements ) throws Exception {
		QueryBankAccountK3Code dao = new QueryBankAccountK3Code();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBankAccountK3Code> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBankAccountK3Code c = new ConditionBankAccountK3Code();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBankAccountK3Code> result = executeQueryBankAccountK3Code(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBankAccountK3Code> result;
		ConditionBankAccountK3Code c = new ConditionBankAccountK3Code();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBankAccountK3Code dao = new QueryBankAccountK3Code();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBankAccountK3Code.ALL_CAPTIONS);
			for(BaseBankAccountK3Code b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


