

import java.util.List;

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



public class TesteCampoTreinamento2 {
	
	private  WebDriver driver;	
	private DSL2 dsl;
	
	
	@Before //estou dizendo para o junit "Antes de cada teste a ser executado execute esse comando"
	public void inicializar() {
		
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 1111));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		dsl = new DSL2(driver);	
		
		
	}
	
	@After
	public void finalizar() {
		
		
		driver.quit();
	}
	
	@Test
 	public void teste() {
		
		
		dsl.escrever("elementosForm:nome", "Pamonha com catupiry");

		Assert.assertEquals("Pamonha com catupiry",dsl.obterValorCampo("elementosForm:nome"));
	}

	
	
	@Test 
	public void deveIntegarirComTexttArea() {

		dsl.escrever("elementosForm:sugestoes", "pao com margarina");

		Assert.assertEquals("pao com margarina",dsl.obterValorCampo("elementosForm:sugestoes"));

	}

	@Test
	
	public void deveIntegarirComRadioButton() {

		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());// verificar se a caixa foi

	}

	@Test
	
	public void deveIntegarirComChekbox() {


		//driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();// seleciona a caixa
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));

		/// driver.quit();
	}

	@Test

	public void escolaridade() {


		/*WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));// retorna uma instancia do tipo
																						// webEleent

		Select combo = new Select(element);
*/
		// combo.selectByIndex(2);//seleção por index
		// combo.selectByValue("superior");//selecão por valor
		//combo.selectByVisibleText("Superior");// seleção pelo texto que esta visivel para o usuario
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		
		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));// verifical a selecao correta

		
	}

	@Test
	public void VerificaExisteciaDeValores() {


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
	public void ExisteciaDeValoresDeMultiplos() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes","Corrida" );
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		
		//marca as opções, seria o efeito de aperta o ctrl e seleciona as opções desejadas 
		//combo.selectByVisibleText("Natacao");
		//combo.selectByVisibleText("Corrida");
		//combo.selectByVisibleText("O que eh esporte?");
		
		
		//verifica se as opção fica marcadas
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions= combo.getAllSelectedOptions();

		
		Assert.assertEquals(3, allSelectedOptions.size());
	}

	                                                                                                                               
	
	@Test
	public void InteracaoComOsBotoes() {
		
		dsl.clicarBotao("buttonSimple");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		//driver.quit();
	
	
	}
	
	
	@Test
	
	//a linhaa de cima esta informando pra nao executa esse test
	public void InteracaoComLinks() {

		
		dsl.clicarLinks("Voltar");
		//driver.findElement(By.linkText("Voltar")).click();;//pega exatamento o que esta visivel
		//Assert.fail();//evita o esquecimento,ou seja, evita de deixa tests em aberto
	
		
//		Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());
		Assert.assertEquals("Voltou!",dsl.obterText("resultado"));
		//driver.quit();
	
	}
	
	

	
	
	@Test

	public void BuscaTextoNaPagina() {
		inicializar();
		
		//exibi todo conteudo escrito da pagina no console
		//System.out.println(	driver.findElement(By.tagName("body")).getText());
		
		
		//A parti exibi todo conteudo escrito da pagina ele procura uma frase em especifico utilizando (contains("Frase a ser buscada"))
		//porem é muito custoso esse tipó de test
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de7 Treinamento"));
		Assert.assertEquals("Campo de Treinamento",dsl.obterText(By.tagName("h3")));
		
		
//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterText(By.className("facilAchar")));

		
	
	
	}
	
}
