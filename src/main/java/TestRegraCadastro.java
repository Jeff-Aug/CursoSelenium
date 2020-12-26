import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegraCadastro {
	
	private String nome;
	private String sobrenome;
	private String sexo;
	private List<String> comidas;
	private String[] esportes;
	private String msg;
	
	
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
	public void deveValidarEsportistaIndeciso(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")) {
			
			page.setSexoMasculino();
		}
		else {
			
			page.setSexoFeminino();
		}
			
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariana();

		
		page.setComidaCarne();
		page.setEsportes(esportes);
		page.Cadastrar();
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
	
	

}
