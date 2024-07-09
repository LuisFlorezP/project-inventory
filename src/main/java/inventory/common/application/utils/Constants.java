package inventory.common.application.utils;

import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class Constants {

    private Constants() {
        throw new IllegalStateException(EXCEPTION_UTILITY_CLASS);
    }

    public static final String EXCEPTION_UTILITY_CLASS = "Utility class";
    public static final String TITLE = "Inventory";
    public static final String TERMS_OF_SERVICE = "http://swagger.io/terms/";
    public static final String NAME_LICENSE = "Apache 2.0";
    public static final String URL_LICENSE = "http://springdoc.org";
    public static final String APP_DESCRIPTION = "Backend to project inventory.";
    public static final String APP_VERSION = "1.0.0";

    public static final String SUCCESS_CATEGORY_MESSAGE = "Successful category process";

    public static final String NOT_FOUND_CATEGORY = "Category not found for the provided ID.";

    public static final String RQ_UUID = "rqUuid";

    public static final String LOG_START_HANDLER = ">>> Start >>> ";
    public static final String LOG_END_HANDLER = "<<< End <<< ";
    public static final String LOG_ERROR = ">>> ERROR >>> ";
}
