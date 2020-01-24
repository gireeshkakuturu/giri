package InApp_Automation_TestCases;

import InApp_Pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class CreateAndVerifyCampaign extends BaseClass {
    @Test
    void createAndVerifyCampaign() {
        navigateToUrl("https://suite0.emarsys.net");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.selectMenu();

        CampaignPage campaignPage = new CampaignPage(driver);
        campaignPage.createNew();

        Campaign_LaunchPage campaignLaunchPage = new Campaign_LaunchPage(driver);
        campaignLaunchPage.launchCampaign();

        ApiTestPage apiTestPage = new ApiTestPage();

        String requestBody = "{\n" +
                "  \"hardware_id\": \"HWID_TEST_EN_IOS_00\",\n" +
                "  \"clicks\": [],\n" +
                "  \"viewed_messages\":[],\n" +
                "  \"events\": [\n" +
                "    {\n" +
                "      \"type\": \"internal\",\n" +
                "      \"name\": \"app:start\",\n" +
                "      \"timestamp\": \"2020-01-23T19:08:30.696Z\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            apiTestPage.sendPost(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
