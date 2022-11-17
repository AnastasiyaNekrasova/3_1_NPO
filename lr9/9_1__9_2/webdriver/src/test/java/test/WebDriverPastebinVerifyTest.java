package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.PastebinHomePagePF;

public class WebDriverPastebinVerifyTest {

    private WebDriver driver;
    private static final String text = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test(description = "Test creating pastebin with format")
    public void verifyTitle(){
        Assert.assertTrue(new PastebinHomePagePF(driver)
                .openPage()
                .createPastebinWithFormat(text, "how to gain dominance among developers"));
        Assert.assertFalse(new PastebinHomePagePF(driver)
                .verifyContentPaste());
    }

    @Test(description = "Test creating pastebin with format")
    public void verifyColorSyntax(){
        Assert.assertTrue(new PastebinHomePagePF(driver)
                .openPage()
                .createPastebinWithFormat(text
                        , "how to gain dominance among developers"));
        Assert.assertTrue(new PastebinHomePagePF(driver)
                .verifySyntaxColor());
    }

    @AfterTest(alwaysRun = true)
    public void browserShutdown(){
        driver.quit();
    }
}
