import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		
		dsl = new DSL(driver);
		
		
	}
	public void setNome(String nome) {//todo e qualquer teste que precise escrever o nome necessariamente passa ppor aqui
		
		dsl.escrever("elementosForm:nome",nome);
		
		
	}
	public void setSobrenome(String sobrenome) {
		
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	public void setSexoMasculino() {
		
		dsl.clicarRadio("elementosForm:sexo:0");
		
	}
	
	public void setSexoFeminino() {
		
		dsl.clicarRadio("elementosForm:sexo:1");
		
	}

	public void setComidaPizza() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	

	public void setComidaVegetariana() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	

	public void setComidaCarne() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	
	

	public void setComidaFrango() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
	}
	
	
	
	public void setEscolaridade(String valor) {
		
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}

	public void setEsportes(String... esportes) {
		
		for (String esporte : esportes) {
			
			dsl.selecionarCombo("elementosForm:esportes", esporte);
		}
		
	}
	
	public void Cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String ObterResultadoCadastro() {
		
		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastro() {
		
		return dsl.obterTexto("descNome");
			
	}
	
	public String obterSobrenomeCadastro() {
		
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro() {
		
		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastro() {
		
		return dsl.obterTexto("descComida");
	}
	

	public String obterEscolaridadeCadastro() {
		
		return dsl.obterTexto("descEscolaridade");
	}
	

	public String obterEsportesCadastro() {
	
		return dsl.obterTexto("descEsportes");
	
	}


}
