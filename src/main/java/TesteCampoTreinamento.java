import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import junit.framework.Assert;

public class TesteCampoTreinamento {

	@Test
	@Ignore
	public void teste() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1100));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Pamonha com catupiry");

		Assert.assertEquals("Pamonha com catupiry",
				driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		//driver.quit();

	}

	@Test
	@Ignore 
	public void deveIntegarirComTexttArea() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("pao com margarina");

		Assert.assertEquals("pao com margarina",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		driver.quit();
	}

	@Test
	@Ignore 
	public void deveIntegarirComRadioButton() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		driver.findElement(By.id("elementosForm:sexo:0")).click();// seleciona a caixa
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());// verificar se a caixa foi
																							// slecionada

		driver.quit();
	}

	@Test
	@Ignore 
	public void deveIntegarirComChekbox() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();// seleciona a caixa
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		/// driver.quit();
	}

	@Test
	@Ignore 
	public void escolaridade() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));// retorna uma instancia do tipo
																						// webEleent

		Select combo = new Select(element);

		// combo.selectByIndex(2);//seleção por index
		// combo.selectByValue("superior");//selecão por valor
		combo.selectByVisibleText("Superior");// seleção pelo texto que esta visivel para o usuario

		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());// verifical a selecao correta

		driver.quit();
	}

	@Test
	@Ignore 
	public void VerificaExisteciaDeValores() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));

		Select combo = new Select(element);

		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontroou = false;

		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontroou = true;
				break;
			}
		}
		Assert.assertTrue(encontroou);

	}
	@Test
	@Ignore 
	public void ExisteciaDeValoresDeMultiplos() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		
		
		//marca as opções, seria o efeito de aperta o ctrl e seleciona as opções desejadas 
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		
		//verifica se as opção fica marcadas
		List<WebElement> allSelectedOptions= combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		driver.quit();
	}

	                                                                                                                               
	
	@Test
	@Ignore 
	public void InteracaoComOsBotoes() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		//driver.quit();
	
	
	}
	
	
	@Test
	
	 
	//a linhaa de cima esta informando pra nao executa esse test
	public void InteracaoComLinks() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();;//pega exatamento o que esta visivel
		//Assert.fail();//evita o esquecimento,ou seja, evita de deixa tests em aberto
	
		
		Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());
		//driver.quit();
	
	}
	
	

	
	
	@Test

	public void BuscaTextoNaPagina() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1024));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		
		//exibi todo conteudo escrito da pagina no console
		//System.out.println(	driver.findElement(By.tagName("body")).getText());
		
		
		//A parti exibi todo conteudo escrito da pagina ele procura uma frase em especifico utilizando (contains("Frase a ser buscada"))
		//porem é muito custoso esse tipó de test
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de7 Treinamento"));
		//Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3")).getText());
		
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		
	
	
	}
	
}
