import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJanelas2 {

	@Test 
	@Ignore
	public void TestComJanelas() {//lidando com janelas extenas a pagina inicial
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1111));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		driver.findElement(By.id("buttonPopUpEasy")).click();//a parti do click no botão o foco deve mudar
		
		driver.switchTo().window("Popup");//o foco mudou para a janela cujo o nome é popup
		
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
		
		
		driver.close();
		
		//mudancao de foco
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys(Keys.chord("e agora?"));
		
		driver.quit();
		//não é sempres que conseguimos achar o indetificador da pagina
		
	}
	
	@Test 
	public void TestComJanelasSemindetificador() {//lidando com janelas extenas a pagina inicial cuja não possui indetificadores
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1111));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys(Keys.chord("Deu certo?"));
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys(Keys.chord("E agora?"));
		
		
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys(Keys.chord(" não sei"));
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys(Keys.chord("mas sera que deu msm"));
		
		driver.quit();
		
	}
}
