

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert2 {

	@Test
	@Ignore
	public void interacaoComAlert() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1100));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		// ocorre o click no botao de alert
		driver.findElement(By.id("alert")).click();

		// aqui ocorre a mudação de foco
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();

		// driver.quit();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}

	
	
	@Test
	@Ignore
	public void interacaoComConfirme() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1100));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		// ocorre o click no botao de alert
		driver.findElement(By.id("confirm")).click();

		// aqui ocore a mudação de foco
		Alert alert = driver.switchTo().alert();


		
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();

		driver.findElement(By.id("confirm")).click();

		// aqui ocore a mudação de foco
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();;
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
	}

	@Test
	public void interacaoComPrompt() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1100));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero",alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
	
		driver.quit();
	
	
	}
	
}
