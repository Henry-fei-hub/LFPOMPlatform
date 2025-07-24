package pomplatform.salary.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;
import pomplatform.salary.bean.BaseCalculateAnnualLeave;
import pomplatform.salary.bean.ConditionCalculateAnnualLeave;
import pomplatform.salary.query.QueryCalculateAnnualLeave;
import pomplatform.workflow.personnelbusiness.business.MyPersonnelProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculateAnnualLeaveHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CalculateAnnualLeaveHandler.class);

	public static BaseCollection<BaseCalculateAnnualLeave> executeQueryCalculateAnnualLeave(ConditionCalculateAnnualLeave c, KeyValuePair[] replacements ) throws Exception {
		QueryCalculateAnnualLeave dao = new QueryCalculateAnnualLeave();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCalculateAnnualLeave> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCalculateAnnualLeave c = new ConditionCalculateAnnualLeave();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCalculateAnnualLeave> result = executeQueryCalculateAnnualLeave(c, c.getKeyValues());
		////
		/*Date date = new Date();
		Class clazz = Class.forName("pomplatform.workflow.personnelbusiness.business.MyPersonnelProcessor");
		Method method =  clazz.getDeclaredMethod("getRemainingOvertime",int.class,Date.class);
		Object obj = clazz.newInstance();
		method.setAccessible(true);
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		List<BaseCalculateAnnualLeave> collection = result.getCollections();
		List<BaseCalculateAnnualLeave> list = new Vector<>(collection.size());
		CountDownLatch countDownLatch = new CountDownLatch(collection.size());
		for (BaseCalculateAnnualLeave cBean : collection) {
			cacheThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						cBean.setRemainingOvertime((java.math.BigDecimal)method.invoke(obj,cBean.getEmployeeId(),date));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					list.add(cBean);
					countDownLatch.countDown();
				}
			});
		}
		try {
			countDownLatch.await();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		result.setCollections(list);*/
		////
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCalculateAnnualLeave> result;
		ConditionCalculateAnnualLeave c = new ConditionCalculateAnnualLeave();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCalculateAnnualLeave dao = new QueryCalculateAnnualLeave();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCalculateAnnualLeave.ALL_CAPTIONS);
			for(BaseCalculateAnnualLeave b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		List list = new Vector<>(3);
		CountDownLatch countDownLatch = new CountDownLatch(list.size());
		for (Object cBean : list) {
			cacheThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					countDownLatch.countDown();
				}
			});
		}
		try {
			countDownLatch.await();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}


