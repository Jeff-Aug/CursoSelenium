import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("C:\\Users\\denty\\Desktop\\tutorial driver\\mod3\\componentes.html");
		dsl = new DSL(driver);
		
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Wagner");
		//dsl.escrever("elementosForm:nome", "Wagner");
		page.setSobrenome("Costa");
		//dsl.escrever("elementosForm:sobrenome", "Costa");
		page.setSexoMasculino();
		//dsl.clicarRadio("elementosForm:sexo:0");
		page.setComidaPizza();
		//dsl.clicarRadio("elementosForm:comidaFavorita:2");
		page.setEscolaridade("Mestrado");
		//dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		page.setEsportes("Natacao");
		//dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		page.Cadastrar();
		//dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertEquals("Cadastrado!",page.ObterResultadoCadastro());
		Assert.assertEquals("Wagner",page.obterNomeCadastro());
		Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.Cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){
		page.setNome("Nome qualquer");
		page.Cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.Cadastrar();
		
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		page.setNome("Nome qualquer");
//		dsl.escrever("elementosForm:nome", "Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
//		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		page.setSexoFeminino();
//		dsl.clicarRadio("elementosForm:sexo:1");
		page.setComidaCarne();
		page.setComidaVegetariana();
//		dsl.clicarRadio("elementosForm:comidaFavorita:0");
//		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		page.Cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso(){
		page.setNome("Nome qualquer");
//		dsl.escrever("elementosForm:nome", "Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
//		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		page.setSexoFeminino();
//		dsl.clicarRadio("elementosForm:sexo:1");
		page.setComidaCarne();
		//dsl.clicarRadio("elementosForm:comidaFavorita:0");
		page.setEsportes("Karate","O que eh esporte?");
//		dsl.selecionarCombo("elementosForm:esportes", "Karate");
//		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		page.Cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}
