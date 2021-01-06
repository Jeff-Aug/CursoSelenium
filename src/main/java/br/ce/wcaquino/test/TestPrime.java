package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TestPrime {

	
	
	private DSL dsl;

	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL();
		
	}
	
	@After
	public void finaliza(){
		//driver.quit();
		
		
	}
		
	@Test
	public void deveinteragirComRadioPrime() {
		
		//nesse tipo de itraçao nao tem ir direto no radio do button portanto deve atraves da navegação utilizando xpath
		dsl.clicarRadio(By.xpath("//input[@id='j_idt728:console:2']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt728:console:2"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt728:console:1"));
		
		
		
	}
	
	@Test
	public void deveIretagiComSelectPrime() {
		
		dsl.selecionarComboPrime("j_idt728:console", "Wii U");
	
		Assert.assertEquals("Wii U", dsl.obterTexto("j_idt728:console_label"));
		
		
	}
		
		
}
