package com.pickcar.drivehistory.exception;

import com.pickcar.exception.BaseErrorCode;
import com.pickcar.exception.ErrorReason;
import org.springframework.http.HttpStatus;

public enum DriveHistoryErrorCode implements BaseErrorCode {

    //400(BAD_REQUEST)
    START_TIME_CANNOT_BE_AFTER_END_TIME(HttpStatus.BAD_REQUEST, "DH_400_1", "운행 종료 일시는 운행 시작 일시보다 빠를 수 없습니다"),

    //403(FORBIDDEN)
    TEST_403_ERROR(HttpStatus.FORBIDDEN, "DH_403_1", "테스트용 403 에러");

    private HttpStatus status;
    private String code;
    private String msg;

    DriveHistoryErrorCode(HttpStatus status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }
    public HttpStatus getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public ErrorReason getErrorReason() {
        return new ErrorReason(status.value(), code, msg);
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        return "오류에 대한 설명 구현 by drive history";
    }
}
