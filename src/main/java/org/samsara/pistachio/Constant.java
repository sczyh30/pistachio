package org.samsara.pistachio;

/**
 * Samsara Pistachio
 * Context constant class
 * @author sczyh30
 * @since 0.1.1
 */
public final class Constant {

    // API Version
    public static final String API_VERSION = "PAPIv1a2";


    public static final int API_PROCESS_LEVEL_ADMIN = 2;
    public static final int API_PROCESS_LEVEL_COMMON = 1;
    public static final int API_PROCESS_LEVEL_NO= 0;
    public static final int API_PROCESS_LEVEL_EB = 7;

    // API URL
    public static final String API_LOGIN = "/api/login";
    public static final String API_GET_VERSION = "/api/v";
    public static final String API_GET_BOOK_INFO = "/api/book/";

    // API Common Error Message
    public static final String API_ERROR_MSG_UNKNOWN = "unknown_error";

    // API Common Error Code
    public static final int API_ERROR_CODE_UNKNOWN = 3477;

    // Request Error Message
    public static final String RE_MSG_BOOK_NOT_FOUND = "book_not_found";
    public static final String RE_MSG_BOOK_BORROW_ERROR = "book_borrow_error";

    // Request Error Code
    public static final int RE_CODE_BOOK_NOT_FOUND = 4040;

    // Borrow Status Message
    public static final String BRS_STATUS_IS = "borrow_status_having";
    public static final String BRS_STATUS_WAIT = "borrow_status_waiting";
    public static final String BRS_STATUS_DONE = "borrow_status_return_done";
    public static final String BRS_STATUS_NO = "borrow_status_none";
    public static final String BRS_STATUS_OVERDUE = "borrow_status_overdue";

    public static final int BRS_STATUS_CODE_IS = 1;
    public static final int BRS_STATUS_CODE_WAIT = 5;
    public static final int BRS_STATUS_CODE_DONE = 2;
    public static final int BRS_STATUS_CODE_NO = 3;
    public static final int BRS_STATUS_CODE_OVERDUE = 4;

    // Book Process Code(667_ good, 34__ bad)
    public static final int BOOK_INFO_REMOVE_SUCCESS = 6675;
    public static final int BOOK_INFO_ADD_SUCCESS = 6676;
    public static final int BOOK_INFO_UPDATE_SUCCESS = 6677;

    public static final int BOOK_INFO_PROCESS_FAILURE = 3402;


    // Borrow Service Code (33__ bad, 666_ good)
    public static final int BOOK_BRS_PROCESS_SUCCESS = 6666;

    public static final int BOOK_BORROWING_DUPLICATE = 3301;
    public static final int BOOK_BRS_PROCESS_FAILURE = 3302;
    public static final int BOOK_BORROWING_EMPTY_NO_PRESENT = 3311;
    public static final int BOOK_USER_ENTRY_NOT_BORROWED = 3317;
}
