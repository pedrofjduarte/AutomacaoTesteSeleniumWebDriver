package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao(){
        driver.get("http://qazando.com.br/");
        Assert.assertEquals("Não acessou a aplicação!", true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo( 0, 11000 )");
        Thread.sleep(2000);
    }

    public void preencheEmail(){
        driver.findElement(By.id("email")).sendKeys("pedroj@qazando.com.br");
    }

    public void clickGanharDesconto(){
        driver.findElement(By.id("button")).click();
    }

    public void verificarCupomDesconto(){
        String textoCupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        Assert.assertEquals("O Cupom está errado!","QAZANDO15OFF", textoCupom);
    }
}
