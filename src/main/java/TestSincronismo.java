import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSincronismo {

	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		
	}
	
	@After
	public void finaliza(){
		driver.quit();
		
		
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
		WebDriverWait wait = new WebDriverWait(driver, 30);//espera 30segundos porem se o elemento aparecer antes ta valendo
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Pamonha lenta");
	}
		
}
