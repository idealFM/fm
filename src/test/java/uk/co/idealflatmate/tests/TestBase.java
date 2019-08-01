package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import uk.co.idealflatmate.appmanager.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners({ScreenshotListener.class})
public class TestBase {

    public final VerificationHelper verificationHelper = new VerificationHelper();
    public final AuthorHeaderMenuHelper authorizationHelper = new AuthorHeaderMenuHelper();
    public final PaymentsHelper paymentsHelper = new PaymentsHelper();
    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();
    public final MessageHelper messageHelper = new MessageHelper();
    public final MatchingHelper matchingHelper = new MatchingHelper();
    public final EmailHelper emailHelper = new EmailHelper();
    public final HomePageHelper homePageHelper = new HomePageHelper();
    public final FooterHelper footerHelper = new FooterHelper();
    public final AreaPageHelper areaPageHelper = new AreaPageHelper();
    public final SearchHelper searchHelper = new SearchHelper();
    public final HelperBase helperBase = new HelperBase();
    public final SignUpHelper signUpHelper = new SignUpHelper();
    public final SearchHelperFM searchHelperFM = new SearchHelperFM();
    public final BuddyUpHelper buddyUpHelper = new BuddyUpHelper();
    public final PopUpHelper popUpHelper = new PopUpHelper();


    /*@BeforeGroups
    public void setupGroup() {
        ChromeDriverManager.getInstance().setup();
        // FirefoxDriverManager.getInstance().setup();
        // EdgeDriverManager.getInstance().setup();
        //Configuration.browser = "webdriver";
        Configuration.browser = "chrome";
        // Configuration.browser = "firefox";
        //  Configuration.browser = "edge";

        // Configuration.assertionMode = Configuration.AssertionMode.SOFT;

        Configuration.timeout = 10000;
        //open("https://www.idealflatmate.co.uk/");
        HelperBase.closeAdvPopUp();
        //open("http://front.idealflatmate.demo.devplatform2.com");

        open("http://front.idealflatmate4test.demo.devplatform2.com");

    }
    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        Resource.File screenshot = Screenshots.getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }*/

    @BeforeSuite

    public void setupClass() {
        //ChromeDriverManager.getInstance().setup();
        init("chrome");


        //WebDriverManager.chromedriver().setup();
        // Configuration.browser = "chrome";

        //WebDriverManager.firefoxdriver().setup();
        //Configuration.browser = "firefox";

        //WebDriverManager.edgedriver().setup();
        //Configuration.browser = "edge";

        //WebDriverManager.safaridr().setup();
       // FirefoxDriverManager.getInstance().setup();
       // EdgeDriverManager.getInstance().setup();
        //Configuration.browser = "webdriver";



        //this.browser = Configuration.browser;

        //Configurations.startmaximized=true;
        //Configuration.browser = "firefox";
        //WebDriverManager.edgedriver().setup();
        //Configuration.browser = "edge";

       // Configuration.assertionMode = Configuration.AssertionMode.SOFT;

        Configuration.timeout = 3000;
        open("http://front.idealflatmate4test.demo.devplatform2.com");
        //HelperBase.closeAdvPopUp();



        }

        public void init(String br) {

            if(br.equals("chrome")){
                Configuration.browser = br;
                WebDriverManager.chromedriver().setup();
            }else if(br.equals("firefox")) {
                Configuration.browser = br;
                WebDriverManager.firefoxdriver().setup();
            }

        }


    @AfterSuite
    public void tearDown() {
        //screenshot("screenshotFail1");
        closeWebDriver();
        

    }




    public VerificationHelper getVerificationHelper() { return verificationHelper; }

    public MessageHelper getMessageHelper() { return messageHelper;    }

    public AuthorHeaderMenuHelper getAuthorizationHelper() {
        return authorizationHelper;
    }

    public AddPropertyHelper getAddPropertyHelper() {
        return addPropertyHelper;
    }

    public PopUpHelper getPopUpHelper() {
        return popUpHelper;
    }

    public PaymentsHelper getPaymentsHelper() {
        return paymentsHelper;
    }

    public static void newPage(String relativeOrAbsoluteUrl) {

        closeWebDriver();
        //WebDriverManager.chromedriver().setup();
        //Configuration.browser = "chrome";
        open(relativeOrAbsoluteUrl);
    }

    public void clearCache() {
        clearBrowserCache();
    }


}