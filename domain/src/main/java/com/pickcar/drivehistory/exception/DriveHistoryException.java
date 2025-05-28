package com.pickcar.drivehistory.exception;

import com.pickcar.exception.GlobalException;

public class DriveHistoryException extends GlobalException {
    
    public DriveHistoryException(DriveHistoryErrorCode errorCode) {
        super(errorCode);
        //TODO: 무언가 추가 내용
    }
}
