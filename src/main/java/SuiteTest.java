import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Cadastro.class,
	TestRegraCadastro.class,
	TesteCampoTreinamento.class
})
public class SuiteTest {

}
