import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class Cadastro2 {

	private WebDriver driver;
	private DSL dsl;

	@Before // estou dizendo para o junit "Antes de cada teste a ser executado execute esse
			// comando"
	public void inicializar() {

		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1111));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		dsl = new DSL(driver);

	}

	@After
	public void finalizar() {
		driver.quit();
	}

	@Test

	public void interacaoComAlert() {

		dsl.escrever("elementosForm:nome", "Jefferson Augusto");
		// driver.findElement(By.id("elementosForm:nome")).sendKeys(Keys.chord("Jefferson
		// Augusto"));
		Assert.assertEquals("Jefferson Augusto", dsl.obterValorCampo("elementosForm:nome"));
		// Assert.assertEquals("Jefferson
		// Augusto",driver.findElement(By.id("elementosForm:nome")).getAttribute("value")
		// );

		dsl.escrever("elementosForm:Sobrenome", "Nunes");
		// driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(Keys.chord("Nunes"));
		Assert.assertEquals("Nunes", dsl.obterValorCampo("elementosForm:sobrenome"));
		// Assert.assertEquals("Nunes",driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value")
		// );

		dsl.clicarBotao("elementosForm:comidaFavorita:0");
		// driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

		dsl.clicarBotao("elementosForm:sexo:0");
		// driver.findElement(By.id("elementosForm:sexo:0")).click();

		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

		dsl.clicarBotao("elementosForm:comidaFavorita:2");
		//driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		
		
		/***************************************************************************************/
		
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		//WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select elemento = new Select(escolaridade);

		//elemento.selectByVisibleText("Superior");
		//Assert.assertEquals("Superior", elemento.getFirstSelectedOption().getText());

		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		//dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.escrever("elementosForm:sugestoes", "O presente usuario necessita necessariamente de doce de jaca");
		
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(Keys.chord("O presente usuario necessita necessariamente de doce de jaca"));

		///WebElement element = driver.findElement(By.id("elementosForm:esportes"));

		// marca as opções, seria o efeito de aperta o ctrl e seleciona as opções
		// desejadas
		
		//Select combo = new Select(element);
		//combo.selectByVisibleText("Natacao");
		//combo.selectByVisibleText("Corrida");
		// combo.selectByVisibleText("O que eh esporte?");

		// verifica se as opção fica marcadas
		//List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		//Assert.assertEquals(2, allSelectedOptions.size());

		/*
		 * elemento.deselectByVisibleText("Natacao");
		 * elemento.deselectByVisibleText("Corrida");
		 * elemento.deselectByVisibleText("Karate");
		 * 
		 * List<WebElement> allSelectedOptions= elemento.getAllSelectedOptions();
		 * Assert.assertEquals(3, allSelectedOptions.size());
		 * 
		 */
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));// verifica se o
																										// bloco inicia
																										// com
																										// Cadastrado
																										// -->
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Augusto"));// verifica se o bloco
																								// termina com Augusto
																								// --> Sufixo
		Assert.assertEquals("Sobrenome: Nunes", driver.findElement(By.id("descSobreNome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: O presente usuario necessita necessariamente de doce de jaca",
				driver.findElement(By.id("descSugestoes")).getText());
		/*
		 * 
		 * // aqui ocorre a mudação de foco Alert alert = driver.switchTo().alert();
		 * 
		 * String texto = alert.getText();
		 * 
		 * // driver.quit(); Assert.assertEquals("Alert Simples", texto);
		 * alert.accept();
		 * 
		 * driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		 */
		// driver.quit();

	}
}
