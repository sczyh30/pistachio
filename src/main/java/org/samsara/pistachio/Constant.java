package org.samsara.pistachio;

/**
 * Samsara Pistachio
 * Context constant class
 * @author sczyh30
 * @since 0.1.1
 */
public final class Constant {

    // API Version
    public static final String API_VERSION = "PAPIv1a1";

    // API URL
    public static final String API_LOGIN = "/api/login";
    public static final String API_GET_VERSION = "/api/v";
    public static final String API_GET_BOOK_INFO = "/api/book/";

    // API Common Error Message
    public static final String API_ERROR_MSG_UNKNOWN = "unknown_error";

    // API Common Error Code
    public static final int API_ERROR_CODE_UNKNOWN = 477;

    // Request Error Message
    public static final String RE_MSG_BOOK_NOT_FOUND = "book_not_found";
    public static final String RE_MSG_BOOK_BORROW_ERROR = "book_borrow_error";

    // Request Error Code
    public static final int RE_CODE_BOOK_NOT_FOUND = 4040;
    public static final int RE_CODE_BOOK_BORROW_ERROR = 3001;
}
