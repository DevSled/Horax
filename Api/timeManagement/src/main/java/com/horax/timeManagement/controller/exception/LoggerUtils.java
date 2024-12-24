package com.horax.timeManagement.controller.exception;

import com.horax.timeManagement.api.error.ErrorMessageDto;
import com.horax.timeManagement.api.error.MultipleErrorMessageDto;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;

public class LoggerUtils {

	public static final String LOGGING_FORMAT = "[%s %s](id:%s)-> Message:%s, Trace:%s";
	public static final String LOGGING_FORMAT_MULTIPLE = "[%s %s](id:%s)-> Message:%s, Validations:%s Trace:%s";

	public static void logError(Logger logger, Exception ex, ErrorMessageDto dto) {
		logger.error(String.format(LOGGING_FORMAT, dto.getDate(), dto.getTime(), dto.getErrorIdentifier(),
				ex.getMessage(), ExceptionUtils.getStackTrace(ex)));
	}

	public static void logError(Logger logger, Exception ex, MultipleErrorMessageDto dto) {
		logger.error(String.format(LOGGING_FORMAT_MULTIPLE, dto.getDate(), dto.getTime(), dto.getErrorIdentifier(),
				ex.getMessage(), dto.getValidationMessages().toString(), ExceptionUtils.getStackTrace(ex)));
	}

	private LoggerUtils() {
	}
}
