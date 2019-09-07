import calculadora.ui.pages.CalculadoraPage;
import calculadora.ui.utils.Operations;

import core.selenium.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This class contains all tests to be performed to calculadora.org.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class BasicOperationsTest {
    private CalculadoraPage calculadoraPage;

    /**
     * Actions to be performed before the test suite execution.
     */
    @Before
    public void setUp() {
        calculadoraPage = new CalculadoraPage();
    }

    /**
     * Actions to be performed after the test suite execution.
     */
    @AfterClass
    public static void tearDown() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }

    /**
     * Verifies addition operation.
     */
    @Test
    public void basicOperations_addition() {
        calculadoraPage.operation(1, 2, Operations.ADD);
        assertThat(calculadoraPage.getResult(), is("3"));
    }

    /**
     * Verifies addition of number with more than one digit.
     */
    @Test
    public void basicOperations_addition_moreThan1Digit() {
        calculadoraPage.operation(123, 275, Operations.ADD);
        assertThat(calculadoraPage.getResult(), is("398"));
    }

    /**
     * Verifies subtraction operation.
     */
    @Test
    public void basicOperations_subtraction() {
        calculadoraPage.operation(2, 1, Operations.SUBTRACT);
        assertThat(calculadoraPage.getResult(), is("1"));
    }

    /**
     * Verifies multiplication operation.
     */
    @Test
    public void basicOperations_multiplication() {
        calculadoraPage.operation(2, 3, Operations.MULTIPLY);
        assertThat(calculadoraPage.getResult(), is("6"));
    }

    /**
     * Verifies division operation.
     */
    @Test
    public void basicOperations_division() {
        calculadoraPage.operation(9, 3, Operations.DIVIDE);
        assertThat(calculadoraPage.getResult(), is("3"));
    }

    /**
     * Verifies addition of float numbers.
     */
    @Test
    public void basicOperations_addition_floatNumbers() {
        calculadoraPage.operation(9.1, 3.2, Operations.ADD);
        assertThat(calculadoraPage.getResult(), is("12.3"));
    }

    /**
     * Verifies negative case of division. Zero as second argument.
     */
    @Test
    public void basicOperations_division_infinity() {
        calculadoraPage.operation(1, 0, Operations.DIVIDE);
        assertThat(calculadoraPage.getResult(), is("Infinity"));
    }

    /**
     * Verifies negative case of division. Zero as first argument.
     */
    @Test
    public void basicOperations_division_zero() {
        calculadoraPage.operation(0, 2, Operations.DIVIDE);
        assertThat(calculadoraPage.getResult(), is("0"));
    }

    /**
     * Verifies negative case of division. Zero as both argument.
     */
    @Test
    public void basicOperations_division_NaN() {
        calculadoraPage.operation(0, 0, Operations.DIVIDE);
        assertThat(calculadoraPage.getResult(), is("NaN"));
    }
}
