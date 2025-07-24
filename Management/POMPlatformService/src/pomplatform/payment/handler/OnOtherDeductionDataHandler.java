package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnOtherDeductionData;
import pomplatform.payment.bean.ConditionOnOtherDeductionData;
import pomplatform.payment.query.QueryOnOtherDeductionData;
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

public class OnOtherDeductionDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnOtherDeductionDataHandler.class);

	public static BaseCollection<BaseOnOtherDeductionData> executeQueryOnOtherDeductionData(ConditionOnOtherDeductionData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnOtherDeductionData dao = new QueryOnOtherDeductionData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnOtherDeductionData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnOtherDeductionData c = new ConditionOnOtherDeductionData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnOtherDeductionData> result = executeQueryOnOtherDeductionData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnOtherDeductionData> result;
		ConditionOnOtherDeductionData c = new ConditionOnOtherDeductionData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnOtherDeductionData dao = new QueryOnOtherDeductionData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnOtherDeductionData.ALL_CAPTIONS);
			for(BaseOnOtherDeductionData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


