package br.ufjf.dcc168.fullteaching.cursos;

import br.ufjf.dcc168.fullteaching.login.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCoursesPage {

    private WebDriver driver;


    @FindBy(css = "li.collection-item:nth-child(4) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > i:nth-child(1)")
    private WebElement editCoursesBtn;

    @FindBy(id = "input-put-course-name")
    private WebElement courseNameInput;

    @FindBy(id = "submit-post-course-btn")
    private WebElement submitBtn;





    public EditCoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public EditCoursesPage editCourses (String courseName){

        try{

            LoginTest loginTest = new LoginTest();
            loginTest.loginProfessor();

            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.elementToBeClickable(editCoursesBtn));

            editCoursesBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));





        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return this;
    }
}
