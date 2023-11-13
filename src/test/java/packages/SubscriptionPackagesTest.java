package packages;

import base.BaseTest;

import java.io.FileWriter;
import java.io.IOException;

public class SubscriptionPackagesTest extends BaseTest {
    FileWriter writer;
    {
        try {
            writer = new FileWriter("subscription_info.txt");
            for(int i = 0 ; i < 3 ; i++){
                homePage.countrySelectClicker();
                homePage.countrySelection();
                String packageType = homePage.getSubscriptionPackage();
                String packagePrice = homePage.getPrice();
                String packageCurrency = homePage.getCurrency();

                writer.write("Country " + i + " - Type: " + packageType + ", Price: " + packagePrice + ", Currency: " + packageCurrency + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
