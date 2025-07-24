package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeStructureOverview;
import pomplatform.report.bean.BaseEmployeeStructureOverview1;
import pomplatform.report.bean.ConditionEmployeeStructureOverview;
import pomplatform.report.bean.ConditionEmployeeStructureOverview1;
import pomplatform.report.query.QueryEmployeeStructureOverview;
import pomplatform.report.query.QueryEmployeeStructureOverview1;

import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeStructureOverviewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeStructureOverviewHandler.class);

	public static BaseCollection<BaseEmployeeStructureOverview> executeQueryEmployeeStructureOverview(ConditionEmployeeStructureOverview c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeStructureOverview dao = new QueryEmployeeStructureOverview();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeStructureOverview> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeStructureOverview c = new ConditionEmployeeStructureOverview();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeStructureOverview> result = executeQueryEmployeeStructureOverview(c, c.getKeyValues());
		List<BaseEmployeeStructureOverview> list = result.getCollections();
		if(BaseHelpUtils.isNullOrEmpty(list.get(list.size()-1).getA())){
			list.remove(list.size()-1);
		}
		if(list.get(18).getA()!=20) {
			BaseEmployeeStructureOverview bean = new BaseEmployeeStructureOverview();
			bean.setA(20);
			bean.setA1(0);
			bean.setRound(new BigDecimal(0));
			list.add(bean);
		}
		if(list.get(3).getA()!=3) {
			BaseEmployeeStructureOverview bean = new BaseEmployeeStructureOverview();
			bean.setA(3);
			bean.setA1(0);
			bean.setRound(new BigDecimal(0));
			list.add(bean);
		}
		System.out.println("====排序前list====="+list.toString());
		Collections.sort(list, new Comparator<BaseEmployeeStructureOverview>() {
			@Override
			public int compare(BaseEmployeeStructureOverview u1, BaseEmployeeStructureOverview u2) {
				if (u1.getA() > u2.getA()) {
					return 1;
				}
				if (u1.getA() == u2.getA()) {
					return 0;
				}
				return -1;
			}
		});
		System.out.println("====排序后list====="+list.toString());
		result.setCollections(list);
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeStructureOverview> result;
		BaseCollection<BaseEmployeeStructureOverview1> result1;
		ConditionEmployeeStructureOverview c = new ConditionEmployeeStructureOverview();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeStructureOverview dao = new QueryEmployeeStructureOverview();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;

		List<BaseEmployeeStructureOverview> list = result.getCollections();
		if(BaseHelpUtils.isNullOrEmpty(list.get(list.size()-1).getA())){
			list.remove(list.size()-1);
		}
		if(list.get(18).getA()!=20) {
			BaseEmployeeStructureOverview bean = new BaseEmployeeStructureOverview();
			bean.setA(20);
			bean.setA1(0);
			bean.setRound(new BigDecimal(0));
			list.add(bean);
		}
		if(list.get(3).getA()!=3) {
			BaseEmployeeStructureOverview bean = new BaseEmployeeStructureOverview();
			bean.setA(3);
			bean.setA1(0);
			bean.setRound(new BigDecimal(0));
			list.add(bean);
		}
		System.out.println("====排序前list====="+list.toString());
		Collections.sort(list, new Comparator<BaseEmployeeStructureOverview>() {
			@Override
			public int compare(BaseEmployeeStructureOverview u1, BaseEmployeeStructureOverview u2) {
				if (u1.getA() > u2.getA()) {
					return 1;
				}
				if (u1.getA() == u2.getA()) {
					return 0;
				}
				return -1;
			}
		});
		System.out.println("====排序后list====="+list.toString());
		result.setCollections(list);

		QueryEmployeeStructureOverview1 structureOverview1 = new QueryEmployeeStructureOverview1();
		ConditionEmployeeStructureOverview1 c1 = new ConditionEmployeeStructureOverview1();
		result1 = structureOverview1.execute( c.getKeyValues(), c1) ;

		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeStructureOverview.ALL_CAPTIONS);
			for(BaseEmployeeStructureOverview b : result.getCollections()){
				ps.println(b.toCSVString());
			}
			for(BaseEmployeeStructureOverview1 b : result1.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public static void main(String[] args) throws Exception {
		EmployeeStructureOverviewHandler handler = new EmployeeStructureOverviewHandler();
		handler.find(null);
	}

}


