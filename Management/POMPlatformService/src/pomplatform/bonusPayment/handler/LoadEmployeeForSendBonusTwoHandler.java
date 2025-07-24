package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.query.QueryLoadEmployeeForSendBonusTwo;
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

public class LoadEmployeeForSendBonusTwoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LoadEmployeeForSendBonusTwoHandler.class);

	public static BaseCollection<BaseLoadEmployeeForSendBonusTwo> executeQueryLoadEmployeeForSendBonusTwo(ConditionLoadEmployeeForSendBonusTwo c, KeyValuePair[] replacements ) throws Exception {
		QueryLoadEmployeeForSendBonusTwo dao = new QueryLoadEmployeeForSendBonusTwo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLoadEmployeeForSendBonusTwo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLoadEmployeeForSendBonusTwo c = new ConditionLoadEmployeeForSendBonusTwo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLoadEmployeeForSendBonusTwo> result = executeQueryLoadEmployeeForSendBonusTwo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLoadEmployeeForSendBonusTwo> result;
		ConditionLoadEmployeeForSendBonusTwo c = new ConditionLoadEmployeeForSendBonusTwo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLoadEmployeeForSendBonusTwo dao = new QueryLoadEmployeeForSendBonusTwo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLoadEmployeeForSendBonusTwo.ALL_CAPTIONS);
			for(BaseLoadEmployeeForSendBonusTwo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


