package Page;

import model.PageCadastro;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class PageCreate {

    public final int TIMEOUT = 10;
    WebDriver driver;

    public PageCreate(WebDriver driver) {this.driver = driver;}

    @FindBy(how= How.XPATH, using = "//*[@id=\"name\"]")  WebElement txtFirstName;
    @FindBy(how= How.XPATH, using ="//*[@id=\"email-localpart\"]" ) WebElement txtEmail;
    @FindBy(how= How.XPATH, using = "//*[@id=\"password\"]") WebElement txtPassword;
    @FindBy(how= How.XPATH, using = "//*[@id=\"tos\"]") WebElement ckTerms;
    @FindBy(how= How.XPATH, using = "//*[@id=\"main-submit\"]") WebElement btnSubmit;
    @FindBy(how= How.XPATH, using = "//*[@id=\"id-1\"]/span") WebElement lbUserExisting;

    public void waitFillTxtName(String strFirstName){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(strFirstName);
    }

    public void waitFillTxtEmail(String strEmail){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(strEmail);
    }

    public void waitFillTxtPassword(String strPassword){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(strPassword);
    }

    public void waitForCheckTerm(){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(ckTerms));
    }

    public void clickOnCheckTerm(){ ckTerms.click();  }

    public void waitForBtnSubmit(){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(btnSubmit));
    }

    public void clickOnBtnSubmit(){ btnSubmit.click();  }

    public String captureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

}
