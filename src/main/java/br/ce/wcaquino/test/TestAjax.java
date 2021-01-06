package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TestAjax {

	private DSL dsl;

	@Before
	public void inicializa(){

		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
		
	}
	
	@After
	public void finaliza(){
		DriverFactory.KillDriver();
		
		
	}

	
	
	@Test
	public void testeAjax() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		dsl.escrever("j_idt727:name", "Test");
		//Thread.sleep(5000);
		dsl.clicarBotao("j_idt727:j_idt730");
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt727:display"), "asdfjagsd"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt807")));
		Assert.assertEquals("Test", dsl.obterTexto(("j_idt727:display")));
		
		
		
		//j_idt727:name
	}
}
