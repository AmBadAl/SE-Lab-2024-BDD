package calculator;

import calculator.Calculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;
    private char operation;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @Given("^I have selected the operation \\+$")
    public void iHaveSelectedTheOperationAdd() {
        operation = '+';
    }

    @Given("^I have selected the operation \\*$")
    public void iHaveSelectedTheOperationMultiply() {
        operation = '*';
    }

    @Given("^I have selected the operation /$")
    public void iHaveSelectedTheOperationDivide() {
        operation = '/';
    }

    @Given("^I have selected the operation \\^$")
    public void iHaveSelectedTheOperationPower() {
        operation = '^';
    }



    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
    }

    @When("^I multiply the two values$")
    public void iMultiplyTheTwoValues() {
        result = calculator.multiply(value1, value2);
    }

    @When("^I divide the two values$")
    public void iDivideTheTwoValues() {
        result = calculator.divide(value1, value2);
    }

    @When("^I power the two values$")
    public void iPowerTheTwoValues() {
        result = calculator.power(value1, value2);
    }

    @When("^I perform the operation$")
    public void iPerformTheOperation() {
        switch (operation) {
            case '+':
                result = calculator.add(value1, value2);
                break;
            case '*':
                result = calculator.multiply(value1, value2);
                break;
            case '/':
                result = calculator.divide(value1, value2);
                break;
            case '^':
                result = calculator.power(value1, value2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }
}
