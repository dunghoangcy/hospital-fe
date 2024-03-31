package com.lsd.web.exception;

public interface ErrorCode {
    String ERROR_MESSAGE_DEFAULT_EN = "An error occurred. Please try again later";
    String ERROR_MESSAGE_DEFAULT_VN = "Đã có lỗi xảy ra. Vui lòng thử lại sau";
    String SUCCESS = "LSD-00-00";
    String UN_AUTHORIZED = "LSD-00-401";
    String FORBIDDEN = "LSD-00-403";
    String NOT_FOUND = "LSD-00-404";
    String INTERNAL_SERVER = "LSD-00-500";
    String GATEWAY_TIMEOUT = "LSD-00-504";
    String REQUEST_BAD = "LSD-00-400";
    String DATE_VALID = "LSD-00-20";
    public static final String ERROR_PAGE = "Page phải lớn hơn hoặc bằng 0";
    public static final String ERROR_PAGE_SIZE = "PageSize phải lớn hơn hoặc bằng 1";

    String NOT_NULL="LSD-01-400";
    String IS_NUMBER="LSD-02-400";
    String LIMIT_CHARACTER="LSD-03-400";
    String INVALID_DATE="LSD-04-400";



}
