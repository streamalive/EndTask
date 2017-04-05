package helper;

public class RandomData {


    //For ALL page
    public static String getEmail() {
        return FIRST_PART_EMAIL + Randomizer.getRandomAppendix() + LASTPART_EMAIL;
    }

    //For NewAccountPage
    private static final String FIRAT_NAME = "Vasy";
    private static final String LAST_NAME = "Ivanov";
    private static final String PASSWORD = "456" + Randomizer.getRandomAppendix();
    private static final String COMPANY = "solytion" + Randomizer.getRandomAppendix();
    private static final String ADRESS = "minsk" + Randomizer.getRandomAppendix();
    private static final String ADRESS2 = "vitebsk" + Randomizer.getRandomAppendix();
    private static final String CITY = "Bor" + Randomizer.getRandomAppendix();
    private static final String POSTAL_CODE = Randomizer.getRandomAppendix();
    private static final String ADDITIONAL_INFO = "i'm tester" + Randomizer.getRandomAppendix();
    private static final String HOME_PHONE = "78-45-" + Randomizer.getRandomAppendix();
    private static final String MOBILE_PHONE = "789-78-" + Randomizer.getRandomAppendix();
    private static final String ALLIAS = "My Allias" + Randomizer.getRandomAppendix();
    private static final String FIRST_PART_EMAIL = "test";
    private static final String LASTPART_EMAIL = "@testers.com";

    public static String getFiratName() {
        return FIRAT_NAME;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getCompany() {
        return COMPANY;
    }

    public static String getAress() {
        return ADRESS;
    }

    public static String getAdress2() {
        return ADRESS2;
    }

    public static String getCity() {
        return CITY;
    }

    public static String getPostalCode() {
        return POSTAL_CODE;
    }

    public static String getAdditionalInfo() {
        return ADDITIONAL_INFO;
    }

    public static String getHomePhone() {
        return HOME_PHONE;
    }

    public static String getMobilePhone() {
        return MOBILE_PHONE;
    }

    public static String getAllias() {
        return ALLIAS;
    }

    //  ContactUsPage
    private static final String ORDER_REFERENCE = "789456";
    private static final String MESSAGE = "Testing!";
    private static final String DROPDAWN_LABEL = "Customer service";
    private static final String PATH_TO_FILE = "src\\main\\resources\\sample.txt";
    private static final String FAIL_MESSAGE = "The message cannot be blank.";

    public static String getOrderReference() {
        return ORDER_REFERENCE;
    }

    public static String getMessage() {
        return MESSAGE;
    }

    public static String getDropdawnLabel() {
        return DROPDAWN_LABEL;
    }

    public static String getPathToFile() {
        return PATH_TO_FILE;
    }

    public static String getFailMessage() {
        return FAIL_MESSAGE;
    }

}
