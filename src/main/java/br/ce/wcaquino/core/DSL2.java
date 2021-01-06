package br.ce.wcaquino.core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//metodo responsavel pela escrita no campo
public class DSL2 {

	private WebDriver driver;

	public DSL2(WebDriver driver) {

		this.driver = driver;
	}

	public void escrever(String id_campo, String texto) {

		driver.findElement(By.id(id_campo)).sendKeys(texto);

	}

	public String obterValorCampo(String id_campo) {

		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	// resposavel por clicar botaao que veio atraves do id
	public void clicarRadio(String id) {

		driver.findElement(By.id(id)).click();// seleciona a caixa

	}

	public boolean isRadioMarcado(String id) {

		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);

	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public void clicarBotao(String id) {

		driver.findElement(By.id(id)).click();

	}

	public void clicarLinks(String link) {

		driver.findElement(By.linkText(link)).click();

	}

	public String obterText(By by) {

		return driver.findElement(by).getText();
	}

	public String obterText(String id) {

		return obterText(By.id(id));

	}
}