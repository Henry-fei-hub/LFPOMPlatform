package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.query.QueryLoadEmployeeForSendBonus;
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

public class LoadEmployeeForSendBonusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LoadEmployeeForSendBonusHandler.class);

	public static BaseCollection<BaseLoadEmployeeForSendBonus> executeQueryLoadEmployeeForSendBonus(ConditionLoadEmployeeForSendBonus c, KeyValuePair[] replacements ) throws Exception {
		QueryLoadEmployeeForSendBonus dao = new QueryLoadEmployeeForSendBonus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLoadEmployeeForSendBonus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLoadEmployeeForSendBonus c = new ConditionLoadEmployeeForSendBonus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLoadEmployeeForSendBonus> result = executeQueryLoadEmployeeForSendBonus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLoadEmployeeForSendBonus> result;
		ConditionLoadEmployeeForSendBonus c = new ConditionLoadEmployeeForSendBonus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLoadEmployeeForSendBonus dao = new QueryLoadEmployeeForSendBonus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLoadEmployeeForSendBonus.ALL_CAPTIONS);
			for(BaseLoadEmployeeForSendBonus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


