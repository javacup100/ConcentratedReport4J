package javacup100.report4j.customs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javacup100.report4j.entity.AllSuites;
import javacup100.report4j.utils.time.dateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javacup100.report4j.entity.ModelFactory;
import javacup100.report4j.entity.SuiteResult;

public class ReporterImpl implements IReporter {

//    String pathName = "templates";
//    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//    final String VM_PATH=classLoader.getResource(pathName).getPath();

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		System.out.println(outputDirectory);
		List<SuiteResult> suiteList = new ArrayList<>();
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		Template template = velocityEngine.getTemplate("report.vm", "utf-8");
		VelocityContext velocityContext = new VelocityContext();
		AllSuites allSuites=new AllSuites();
		allSuites.setDate(dateUtil.toDateString(System.currentTimeMillis()));
		int totalNumber=0,passed=0,failed=0,skipped=0;
		double duration=0.0;
		for (ISuite suite : suites) {
			SuiteResult sModel = ModelFactory.getSuiteResult(suite);
			totalNumber+=sModel.getTotalNumber();
			passed+=sModel.getPassedNumber();
			failed+=sModel.getFailedNumber();
			skipped+=sModel.getSkippedNumber();
			duration+=sModel.getDuration();
			suiteList.add(sModel);
		}
		allSuites.setTotalNumber(totalNumber);
		allSuites.setPassedNumber(passed);
		allSuites.setFailedNumber(failed);
		allSuites.setSkippedNumber(skipped);
		allSuites.setDuration(duration);
		allSuites.setDurationString();
		velocityContext.put("suiteList", suiteList);
		velocityContext.put("allSuites", allSuites);
        try {
        	File targetDir=new File(outputDirectory+"/js");
			new File(outputDirectory+"/suites").mkdir();
        	File sourceDir=new File("src/main/resources/js");
				FileUtils.copyDirectory(sourceDir,targetDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputDirectory + "\\report" + ".html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		template.merge(velocityContext, writer);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File report=new File(outputDirectory + "\\report" + ".html");
		System.out.println("see the report at:"+report);

    }
}
