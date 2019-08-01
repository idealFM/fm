package uk.co.idealflatmate.tests;

public class TestExcel  {
/*
    private String sTestCaseName;

    private int iTestCaseRow;





    @Test(dataProvider = "Authentication")

    public void testExcel2(String sUserName, String sPassword) {
        $(byXpath("//nav//ul[contains(@class, 'nav navbar-nav navbar-right ')]/li[contains(., 'Login')]")).click();

        $("input#loginform-username").click();

        $("input#loginform-username").sendKeys(sUserName);

        System.out.println(sUserName);



    }



    @DataProvider

    public Object[][] Authentication() throws Exception{

        // Setting up the Test Data Excel file

        ExcelUtils.setExcelFile("C:\\Users\\lukhovytskyi\\Documents\\GitHub\\idealflatmate2\\src\\test\\resources\\TestData1.xls","Sheet1");

        sTestCaseName = this.toString();

        // From above method we get long test case name including package and class name etc.

        // The below method will refine your test case name, exactly the name use have used

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

        // Fetching the Test Case row number from the Test Data Sheet

        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\lukhovytskyi\\Documents\\GitHub\\idealflatmate2\\src\\test\\resources\\TestData1.xls","Sheet1",iTestCaseRow);

        return (testObjArray);





        @DataProvider
        public Object[][] testData1(Method method, String sheet){
            ExcelReader excelReader = new ExcelReader();
            excelReader.setExcelFile(config.getProperty("C:\\Users\\lukhovytskyi\\Documents\\GitHub\\idealflatmate2\\src\\test\\resources\\TestData.xlsx"), sheet);
            List rowsNo = excelReader.getRowContains(method.getName(), 0);
            return excelReader.getTableArray(rowsNo);
        }

        @Test(dataProvider = "testData1")
        public void userLogin(List data) {
            data.get(0);
            data.get(1);


        }

*/
}

