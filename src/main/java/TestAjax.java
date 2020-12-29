import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAjax {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL(driver);
		
	}
	
	@After
	public void finaliza(){
		//driver.quit();
		
		
	}

	
	
	@Test
	public void testeAjax() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		dsl.escrever("j_idt727:name", "Test");
		//Thread.sleep(5000);
		dsl.clicarBotao("j_idt727:j_idt730");
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt727:display"), "asdfjagsd"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt807")));
		Assert.assertEquals("Test", dsl.obterTexto(("j_idt727:display")));
		
		
		
		//j_idt727:name
	}
}
