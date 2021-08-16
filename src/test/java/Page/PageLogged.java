package Page;

import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class PageLogged {

    public final int TIMEOUT = 10;
    WebDriver driver;

    public PageLogged(WebDriver driver) {this.driver = driver;}

    @FindBy(how= How.XPATH, using = "//*[@id=\"v189\"]") WebElement txtEmail;
    @FindBy(how= How.XPATH, using = "//*[@id=\"v9\"]/ul[1]/li[1]/a") WebElement btnMail; //*[@id="v23"]/ul[1]/li[1]/a
    @FindBy(how= How.XPATH, using = "//*[@id=\"main-nav-toolbar\"]") WebElement divEmail;

    public void waitForDivMail(){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(divEmail));
    }

    public void waitForTxtMail(){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(txtEmail));
    }

    public void waitForBtnMail(){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(btnMail));
    }

    public void clickOnTxtMail(){txtEmail.click(); }

    public void clickOnBtnMail(){btnMail.click(); }

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

    public String captureScreenErr() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + "ERRO__" + source.getName() ;
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException ex) {
            path = "Failed to capture screenshot: " + ex.getMessage();
        }
        return path;
    }
}
