package br.ce.wcaquino.core;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	

	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(By by) {
		DriverFactory.getDriver().findElement((by)).click();
	}
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	
	
	
	public boolean isRadioMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	
	public void selecionarComboPrime(String Radical,String valor) {
		
		clicarRadio(By.xpath("//*[@id='"+Radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+Radical+"_items']//li[.='"+valor+"']"));
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	
	public String obterValueElemento(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		DriverFactory.getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		DriverFactory.getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		DriverFactory.getDriver().switchTo().window(id);
	}
	
	
	
	/*******************Javascripts***************************/
	
	public Object executaJS(String cmd,Object... param) {
		
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		
		return js.executeScript(cmd, param);
		
		//js.executeScript("alert('Testando js via selenium')");
		//js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		//js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		//WebElement elemento = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		
	//	js.executeScript("arguments[0].style.border = arguments[1]", elemento,"solid 4px red");
		
		
		
	}
	
	/*******************Tabela***************************/


	public void clicarBotaoTabela(String colunaBusca,String valor, String colunaBotao) {
		//procuraa coluna do registro
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));//vai de encontra a tabela refente a esse endere�o
//		tabela.findElements("//th");//se for colocado desse jeito a busca sera iniciada desdo come�o do html
		
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontra a linha do registro
		
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		//procura coluna do botao
		
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//Clicar no botao
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha +"]/td["+ idColunaBotao +"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	
	
	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		
		int idLinha = -1;//Se o valor for de 0 pra cima significa que o valor foi encontrado,por isso o valor negativo
		for(int i=0 ; i < linhas.size(); i++ ) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	
	
	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));//.//th a busca ocorre a parti do diretorio corrente
		
		int idColuna = -1;//Se o valor for de 0 pra cima significa que o valor foi encontrado,por isso o valor negativo
				
		for(int i=0 ; i < colunas.size(); i++ ) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}


}
