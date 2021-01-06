package br.ce.wcaquino.test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TestSincronismo {

	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		dsl = new DSL();
		
	}
	
	@After
	public void finaliza(){
		DriverFactory.KillDriver();
		
		
	}

	@Test 
	public void deveUtilizarEsperaFixa() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);// esperra o 5 segundo
		dsl.escrever("novoCampo", "Pamonha lenta");
		
	}

	@Test 
	public void deveiUtilizarEsperaImplicita() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(4	, TimeUnit.SECONDS);//espera 4 seg porrem aqui mex com o driver
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Pamonha lenta");
		driver.manage().timeouts().implicitlyWait(4	, TimeUnit.SECONDS);
		
	}

	

	@Test 
	public void deveUtilizarEsperaExplicita() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);//espera 30segundos porem se o elemento aparecer antes ta valendo
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Pamonha lenta");
	}
		
}
