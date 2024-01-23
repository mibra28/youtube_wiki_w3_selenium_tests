package com.gitlab.rmarzec.pages.w3schools;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class W3SchoolsEditorPage {

    WebDriver driver;
    WaitFactory wait;

    public W3SchoolsEditorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitFactory(driver);
    }

    private final By selectElement = By.id("cars");
    private final By header = By.tagName("h1");

    public String getHeaderText() {
        return wait.waitForVisibility(header).getText();
    }

    public void switchToIframeResults() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.switchTo().frame("iframeResult");
    }

    public WebElement getSelectElement() {
        return wait.waitForVisibility(selectElement);
    }

    public void selectCarInDropdown(String option) {
        Select select = new Select(getSelectElement());
        select.selectByVisibleText(option);
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText() + ", " + selectedOption.getAttribute("value"));
    }

}




