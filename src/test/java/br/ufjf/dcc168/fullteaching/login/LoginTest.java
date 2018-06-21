package br.ufjf.dcc168.fullteaching.login;

import br.ufjf.dcc168.fullteaching.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    static ArrayList<String[]> listaEquival = new ArrayList<String[]>();
    @BeforeClass
    public static void beforeClass(){

        String[] tupla = new String [2];
        tupla[0] = "teacher@gmail.com";
        tupla[1] = "pass";
        listaEquival.add(tupla);

        tupla[0] = "student2@gmail.com";
        tupla[1] = "pass";
        listaEquival.add(tupla);

        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

    @Test
    public void loginProfessor()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("teacher@gmail.com","pass");
        assertTrue(loginPage.isLogged());
    }

    @Test
    public void loginAluno()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("student2@gmail.com", "pass");
        assertTrue(loginPage.isLogged());


    }

    @Test
    public void loginUsuarioInvalido()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("usuario_qualquer@gmail.com", "123456");
        assertFalse(loginPage.isLogged());
    }

    @Test
    public void loginClasseEquivalencia()
    {

        Random rd = new Random();
        int pos = rd.nextInt(listaEquival.size());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(listaEquival.get(pos)[0], listaEquival.get(pos)[1]);
        assertFalse(loginPage.isLogged());
    }

}
