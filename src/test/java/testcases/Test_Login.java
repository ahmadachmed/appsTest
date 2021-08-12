package testcases;

import org.testng.annotations.Test;
import appium.Controller;
import functions.Alert;
import functions.Button;
import functions.Input;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Test_Login extends Controller {

    @Severity(SeverityLevel.MINOR)
	@Test(priority = 0, testName = "Login with incorrect mail or phone number")
	public void login_alert_username() throws InterruptedException {
		Button button = new Button(driver);
		Input input = new Input(driver);
		Alert alert = new Alert(driver);

		button.ById("tvIntroSkipText");
		button.ById("menuAccount");
		button.ById("btnLogin");
		input.ById("edtEmailOrPhoneNumber", "ahmadilham");
		input.ById("edtPassword", "password");
		button.ById("btnLogin");
		Thread.sleep(10000);
		alert.ById("tvErrorEmailOrPhoneNumber", "Please Try Again Email Is Incorrect");
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, testName = "Login with incorrect password")
	public void login_alert_password() throws InterruptedException {
		Button button = new Button(driver);
		Input input = new Input(driver);
		Alert alert = new Alert(driver);

		button.ById("tvIntroSkipText");
		button.ById("menuAccount");
		button.ById("btnLogin");
		input.ById("edtEmailOrPhoneNumber", "ahmadilham000@gmail.com");
		input.ById("edtPassword", "password");
		button.ById("btnLogin");
		Thread.sleep(10000);
		alert.ById("tvErrorPassword", "Please Try Again Password Is Incorrect");
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2, testName = "Login with not registered user")
	public void login_alert_popup() throws InterruptedException {
		Button button = new Button(driver);
		Input input = new Input(driver);
		Alert alert = new Alert(driver);

		button.ById("tvIntroSkipText");
		button.ById("menuAccount");
		button.ById("btnLogin");
		input.ById("edtEmailOrPhoneNumber", "tester@gmail.com");
		input.ById("edtPassword", "password");
		button.ById("btnLogin");
		Thread.sleep(10000);
		alert.ById("md_text_message", "Invalid, User Has Not Been Registered");
	}

    @Severity(SeverityLevel.MINOR)
    @Test(priority = 3, testName = "Success Login with valid credentials")
    public void login_success() throws InterruptedException {
        Button button = new Button(driver);
        Input input = new Input(driver);
        Alert alert = new Alert(driver);

		button.ById("tvIntroSkipText");
        button.ById("menuAccount");
        button.ById("btnLogin");
        input.ById("edtEmailOrPhoneNumber", "ahmadilham000@gmail.com");
        input.ById("edtPassword", "01101994");
        button.ById("btnLogin");
        Thread.sleep(10000);
        button.ById("menuAccount");
        alert.ById("tvTitleHeaderItem", "RAMZEY");
    }
}
