import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cadastro {
	

		@Test
		
		public void interacaoComAlert() {

			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 1100));
			driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

			
			driver.findElement(By.id("elementosForm:nome")).sendKeys(Keys.chord("Jefferson Augusto"));
			Assert.assertEquals("Jefferson Augusto",driver.findElement(By.id("elementosForm:nome")).getAttribute("value") );
			
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(Keys.chord("Nunes"));
			Assert.assertEquals("Nunes",driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value") );
			
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			
			Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

			
			driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
			Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

			WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
			
			Select elemento = new Select(escolaridade);
			elemento.selectByVisibleText("Superior");
			Assert.assertEquals("Superior", elemento.getFirstSelectedOption().getText());

			driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(Keys.chord("O presente usuario necessita necessariamente de doce de jaca"));
			
			
			WebElement element = driver.findElement(By.id("elementosForm:esportes"));
			
			
			//marca as opções, seria o efeito de aperta o ctrl e seleciona as opções desejadas 
			Select combo = new Select(element);
			combo.selectByVisibleText("Natacao");
			combo.selectByVisibleText("Corrida");
			//combo.selectByVisibleText("O que eh esporte?");
			
			
			//verifica se as opção fica marcadas
			List<WebElement> allSelectedOptions= combo.getAllSelectedOptions();
			Assert.assertEquals(2, allSelectedOptions.size());
			
			
			/*
			elemento.deselectByVisibleText("Natacao");
			elemento.deselectByVisibleText("Corrida");
			elemento.deselectByVisibleText("Karate");
			
			List<WebElement> allSelectedOptions= elemento.getAllSelectedOptions();
			Assert.assertEquals(3, allSelectedOptions.size());
			
			*/
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			/*

			// aqui ocorre a mudação de foco
			Alert alert = driver.switchTo().alert();

			String texto = alert.getText();

			// driver.quit();
			Assert.assertEquals("Alert Simples", texto);
			alert.accept();

			driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);*/
			//driver.quit();
		
	}
}
