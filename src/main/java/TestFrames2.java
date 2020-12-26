import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrames2 {

	@Test
	public void interacaoComFrames() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1200, 1100));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		//mudança de foco para clickar mno bootão
		driver.switchTo().frame("frame1");
		
		
		driver.findElement(By.id("frameButton")).click();//se for direto nesse comando sem a linha de cima ocorre um erro
		Alert alerta = driver.switchTo().alert();
		String msg = alerta.getText();
		Assert.assertEquals("Frame OK!",msg);
		alerta.accept();
		
		
		driver.switchTo().defaultContent();//aqui existe a necessidade de retomada de foco
		driver.findElement(By.id("elementosForm:nome")).sendKeys(Keys.chord(msg));
		driver.quit();
		
	}
	
	
}
