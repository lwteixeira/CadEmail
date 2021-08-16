package model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Random;

public class PageCadastro {

    private String name = "Fulano Belt";
    private String nameEmail = geraEmailRandom();
    private String password = "@Teste123";
    private String userExisting = "O nome de usuário já está em uso";

    private String xpathName = "//*[@id=\"name\"]";
    private String xpathPassword = "//*[@id=\"password\"]";
    private String xpathEmail = "//*[@id=\"email-localpart\"]";
    private String xpathBtnSubmit = "//*[@id=\"accountDetailsNext\"]/div/button/span";
    private String xpathUserExisting = "//*[@id=\"id-1\"]/span";


    public String getName(){return name; }
    public String getNameEmail(){return nameEmail; }
    public String getPassword(){return password; }
    public String getUserExisting(){return userExisting; }

    public String getXpathName(){return xpathName; }
    public String getXpathPassword(){return xpathPassword; }
    public String getXpathEmail(){return xpathEmail; }
    public String getXpathBtnSubmit(){return xpathBtnSubmit; }
    public String getXpathUserExisting(){return xpathUserExisting; }

    private String geraEmailRandom(){
        // Determia as letras que poderão estar presente nas chaves
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for( int i = 0; i < 9; i++ ) {
            index = random.nextInt( letras.length() );
            armazenaChaves += letras.substring( index, index + 1 );
        }
        System.out.println( armazenaChaves );
        return armazenaChaves;
    }

}
