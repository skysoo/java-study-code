package com.example.springdemo.utility;

import org.example.utility.concurrency.ScheduleUtil;
import org.example.utility.concurrency.SingleUtil;
import org.example.utility.exception.LambdaExceptionUtil;

import java.util.regex.Pattern;

/**
 * @author skysoo
 * @version 1.0.0
 * @since 2020-05-06 오후 4:32
 **/
public class UT {
    public static final LambdaExceptionUtil exceptionHandler = LambdaExceptionUtil.get();
    public static final ScheduleUtil schedule = ScheduleUtil.get();
    public static final SingleUtil single = SingleUtil.get();
    public static final Pattern decimalPattern = Pattern.compile("^[-]?[0-9.]+");
    public static final Pattern datePattern = Pattern.compile("(^[0-9]{8})");
    public static final Pattern timePattern = Pattern.compile("(^[0-9]{6})");
    public static final Pattern priorityPattern = Pattern.compile("^([0-9]{1})");
    public static final Pattern gwIdPattern = Pattern.compile("^([a-zA-Z0-9]{12})");
    public static final Pattern dataTypePattern = Pattern.compile("^([A-Z]{9})");
    public static final Pattern dataKndPattern = Pattern.compile("([a-zA-Z])*(_([a-zA-Z]*))+");
    public static final Pattern ipAddrPattern = Pattern.compile("([0-9]){1,3}[.]([0-9]){1,3}[.]([0-9]){1,3}[.]([0-9]{1,3})");

    /* 더미로 올라오는 댐 이미지에 대한 정규표현식 */
    public static final Pattern imageFilePattern = Pattern.compile("^[a-zA-Z0-9_-]*.(jpg|png|jpeg|bmp|dxf|pdf)$");
    /* 댐 고유 번호 (7자리 숫자 고정) */
    public static final Pattern damUniqueNumPattern = Pattern.compile("^[0-9]{7}$");
    public static final Pattern extensionPattern = Pattern.compile("^(([a-zA-Z0-9]+)([_]*)([a-zA-Z0-9]+)(.png|.jpg|.dxf|.PNG|.JPG|.DXF))");

    public UT() {
    }

}

// TODO: 2020-07-28 이전 주기 미수집 시, 1시간당 1번, 주기 ALL, 요청 및 수신, 단지 파일이 있는지만 데이터 확인은, GW upld data,