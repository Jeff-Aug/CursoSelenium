import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPrime {

	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL(driver);
		
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
