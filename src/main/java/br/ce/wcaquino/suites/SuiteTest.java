package br.ce.wcaquino.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;

import br.ce.wcaquino.test.TestRegraCadastro;
import br.ce.wcaquino.test.TesteCampoTreinamento;

@RunWith(Suite.class)
@SuiteClasses({
	//Cadastro.class,
	TestRegraCadastro.class,
	TesteCampoTreinamento.class
})
public class SuiteTest {
	
	@AfterClass 
	public static void finalizaTudo() {
		
		DriverFactory.KillDriver();
	}




}
