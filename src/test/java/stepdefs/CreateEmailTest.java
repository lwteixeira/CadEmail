package stepdefs;

import Browser.Browser;
import Page.PageCreate;
import Page.PageLogged;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import model.PageCadastro;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateEmailTest {

    ChromeOptions options;
    ChromeDriver driver;
    Browser browser;
    PageCadastro pageCad;
    WebDriverWait wait;
    static String email;

        @Dado("^que estou na pagina do provedor de email\\.$")
    public void que_estou_na_pagina_do_provedor_de_email() throws Exception
    {
            options = new ChromeOptions();
            options.addArguments("--incognito");
            browser = new Browser();
            System.setProperty(browser.WEBCHROMEDRIVE, browser.PATHCHROME);
            driver = new ChromeDriver(options);
            driver.navigate().to(browser.URLPAGE);
            wait = new WebDriverWait(driver, 60);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
    }

        @Quando("^forneco as credenciais validas para cadastro\\.$")
    public void forneco_as_credenciais_validas_para_cadastro() throws Exception{
            pageCad = new PageCadastro();
            PageCreate create = PageFactory.initElements(driver, PageCreate.class);

            create.waitFillTxtName(pageCad.getName());
            String validName = driver.findElement(By.xpath(pageCad.getXpathName())).getAttribute("value");
            assertEquals(pageCad.getName(), validName);

            email = pageCad.getNameEmail();
            create.waitFillTxtEmail(email);
            String validEmail = driver.findElement(By.xpath(pageCad.getXpathEmail())).getAttribute("value");
            assertEquals(email.toLowerCase(), validEmail);

            create.waitFillTxtPassword(pageCad.getPassword());
            String validPassword = driver.findElement(By.xpath(pageCad.getXpathPassword())).getAttribute("value");
            assertEquals(pageCad.getPassword(), validPassword);

            create.waitForCheckTerm();
            create.clickOnCheckTerm();

            //create.captureScreen();

            create.waitForBtnSubmit();
            create.clickOnBtnSubmit();

        }

        @Entao("^tenho acesso a o email criado\\.$")
    public void tenho_acesso_a_o_email_criado(){
            pageCad = new PageCadastro();
            PageLogged logged = PageFactory.initElements(driver, PageLogged.class);
            try{

                logged.waitForDivMail();
                if(driver.findElement(By.xpath("//*[@id=\"main-nav-toolbar\"]"))
                        .getAttribute("aria-expanded") == "false"){
                    logged.clickOnTxtMail();
                }

                logged.waitForBtnMail();
                logged.clickOnBtnMail();

                String mailFull = email.toLowerCase() + "@fastmail.com";
                String validMail = driver.findElement(By.xpath("//*[@id=\"v189\"]")).getAttribute("value");

                assertEquals(mailFull, validMail);

                logged.captureScreen();
            }catch (Exception e){
                logged.captureScreenErr();
            }


        }
}
