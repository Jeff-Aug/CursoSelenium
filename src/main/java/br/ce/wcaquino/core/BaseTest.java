package br.ce.wcaquino.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {


	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException{
		
		//Ajuda a verifica em caso de erro onde foi especifficamente o erro,ou seja, em caso de nao achar o elemento talvez estejamos procurando na pagina errada
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(arquivo,new File("target/screenshot/"+testName.getMethodName()+".jgp"));
		FileUtils.copyFile(arquivo,new File("target"+File.separator+"screenshot"+File.separator+testName.getMethodName()+".jgp"));
		
		
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.KillDriver();
			
		}
	}
}
