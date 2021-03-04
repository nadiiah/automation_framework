package com.skelia.nhryhor.providers;

import com.skelia.nhryhor.helpers.CSVFileReader;
import org.testng.annotations.DataProvider;
import java.util.List;

public class EmailProvider {
    private static String EMAIL_LIST = "email_list";
    private static final List<String> emailList = CSVFileReader.readFromCSVFile(EMAIL_LIST);

    @DataProvider(name = "listOfEmails")
    public static Object[][] getListOfEmails() {
        String[] emailArray = new String[emailList.size()];
        for (int i = 0; i < emailArray.length; i++) {
            emailArray[i] = emailList.get(i);
        }
        return new String[][]{emailArray};
    }
}
