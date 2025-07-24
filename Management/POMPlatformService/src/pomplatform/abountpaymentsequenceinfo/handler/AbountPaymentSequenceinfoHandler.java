package pomplatform.abountpaymentsequenceinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.abountpaymentsequenceinfo.bean.BaseAbountPaymentSequenceinfo;
import pomplatform.abountpaymentsequenceinfo.bean.ConditionAbountPaymentSequenceinfo;
import pomplatform.abountpaymentsequenceinfo.query.QueryAbountPaymentSequenceinfo;
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

public class AbountPaymentSequenceinfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AbountPaymentSequenceinfoHandler.class);

	public static BaseCollection<BaseAbountPaymentSequenceinfo> executeQueryAbountPaymentSequenceinfo(ConditionAbountPaymentSequenceinfo c, KeyValuePair[] replacements ) throws Exception {
		QueryAbountPaymentSequenceinfo dao = new QueryAbountPaymentSequenceinfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAbountPaymentSequenceinfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAbountPaymentSequenceinfo c = new ConditionAbountPaymentSequenceinfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAbountPaymentSequenceinfo> result = executeQueryAbountPaymentSequenceinfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAbountPaymentSequenceinfo> result;
		ConditionAbountPaymentSequenceinfo c = new ConditionAbountPaymentSequenceinfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAbountPaymentSequenceinfo dao = new QueryAbountPaymentSequenceinfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAbountPaymentSequenceinfo.EXPORT_CAPTIONS);
			for(BaseAbountPaymentSequenceinfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


