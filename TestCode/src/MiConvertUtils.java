///*
// * Copyright (c) 2021 MIBANK, Inc.
// * All right reserved.
// * This software is the confidential and proprietary information of MIBANK, Inc.
// * You shall not disclose such Confidential Information and
// * shall use it only in accordance with the terms of the license agreement
// * you entered into with MIBANK.
// *
// * Revision History
// * Author Date Description
// * ------------------ -------------- ------------------
// * CHAD 21. 11. 9. 오후 8:15
// */
//
//import mi.mibank.constant.BankNameEnum;
//import mi.mibank.constant.MiCommonEnum;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.text.DecimalFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 변환 유틸리티
// */
//public class MiConvertUtils {
//
//    /**
//     * 전화번호에 하이픈을 추가한다
//     *
//     * @param phoneNumber 전화번호 01041119733
//     * @return 010-4111-9733
//     */
//    public static String addHyphen2PhoneNumber(String phoneNumber) {
//        String formatNum = "";
//
//        phoneNumber = phoneNumber.replaceAll("-", "");
//
//        if (phoneNumber.length() == 11) {
//            formatNum = phoneNumber.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
//        } else if (phoneNumber.length() == 10) {
//            if (phoneNumber.startsWith("02")) {
//                formatNum = phoneNumber.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "$1-$2-$3");
//            } else {
//                formatNum = phoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
//            }
//        } else {
//            if (phoneNumber.startsWith("02")) {
//                formatNum = phoneNumber.replaceAll("(\\d{2})(\\d{3})(\\d{4})", "$1-$2-$3");
//            }
//        }
//        return formatNum;
//    }
//
//    /**
//     * 은행코드를 한글 은행명으로 변환한다
//     *
//     * @param bankCd the bank cd
//     * @return the string
//     */
//    public static String bankCd2Name(String bankCd) {
//        for (BankNameEnum e : BankNameEnum.values()) {
//            if (bankCd.equals(e.getValueString1())) {
//                return e.getValueString2();
//            }
//        }
//        return "";
//    }
//
//    /**
//     * 주민번호 앞자리를 8자리 생년월일로 변환
//     *
//     * @param birth 주민번호 앞자리
//     * @return 8자리 생년월일
//     */
//    public static LocalDate birth2LocalDate(String birth) {
//        return LocalDate.parse(birth2YYYYMMDD(birth), DateTimeFormatter.ofPattern("yyyyMMdd"));
//    }
//
//    /**
//     * 주민번호 앞자리를 8자리 생년월일로 변환
//     *
//     * @param birth 주민번호 앞자리
//     * @return 8자리 생년월일
//     */
//    public static String birth2YYYYMMDD(String birth) {
//        String birthYearStr = birth.substring(0, 2);
//        String birthDate    = "";
//
//        if (StringUtils.isNumeric(birthYearStr)) {
//            Integer birthYear   = Integer.valueOf(birthYearStr);
//            Integer currentYear = Integer.valueOf(DateTimeFormatter.ofPattern("yy").format(LocalDate.now()));
//
//            if (birthYear > currentYear) {
//                birthDate = "19".concat(birth);
//            } else {
//                birthDate = "20".concat(birth);
//            }
//            return birthDate;
//        }
//        return "";
//    }
//
//    /**
//     * 주민번호 앞자리 + 주민번호 뒷자리 첫번째 숫자 => 8자리 생년월일로 변환
//     *
//     * @param birth 주민번호 앞자리
//     * @param sid   주민번호 뒷자리 첫번째 숫자
//     * @return 8자리 생년월일
//     */
//    public static String birth2YYYYMMDDWSid(String birth, String sid) {
//
//        switch (sid) {
//            case "0":
//            case "9":
//                birth = "18" + birth;
//                break;
//            case "1":
//            case "2":
//            case "5":
//            case "6":
//                birth = "19" + birth;
//                break;
//            case "3":
//            case "4":
//            case "7":
//            case "8":
//                birth = "20" + birth;
//                break;
//        }
//        return birth;
//    }
//
//    /**
//     * 주민번호 뒷 6자리 마스킹처리
//     *
//     * @param ssn the ssn
//     * @return the string
//     */
//    public static String maskSsn(String ssn) {
//        return ssn.replaceAll("(.{6}$)", "******");
//    }
//
//    /**
//     * 숫자 단위 한글로 표시
//     *
//     * @param value   대상숫자
//     * @param isPrice 금액여부
//     * @return 154조7826억3만2346원 / 1조7826억3만2346
//     */
//    public static String number2KorFormat(Double value, boolean isPrice) {
//        if (value == null || 0 == value) {
//            return "-";
//        }
//
//        DecimalFormat d = new DecimalFormat("#,####");
//
//        String[] unit = new String[]{"", "만", "억", "조"};
//        String[] str  = d.format(value).split(",");
//
//        String result = "";
//
//        int cnt = 0;
//
//        for (int i = str.length; i > 0; i--) {
//            if (Integer.parseInt(str[i - 1]) != 0) {
//                result = String.valueOf(Integer.parseInt(str[i - 1])) + unit[cnt] + result;
//            }
//            cnt++;
//        }
//
//        if (isPrice) {
//            return result + "원";
//        } else {
//            return result;
//        }
//    }
//
//    /**
//     * Request Header에 있는 값을 모두 소문자로 변환한다
//     *
//     * @param request the request
//     * @return map map
//     */
//    public static Map<String, String> reqHeader2LowerCase(HttpServletRequest request) {
//        //헤더정보 전체보기
//        Enumeration<String> headerNames = request.getHeaderNames();
//        Map<String, String> headerMap   = new HashMap<>();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            String val  = request.getHeader(name);
//            headerMap.put(name.toLowerCase(), val);
//        }
//        return headerMap;
//    }
//
//    /**
//     * 주민번호 뒷자리 첫번째 숫자를 성별 숫자코드로 바꾼다
//     *
//     * @param sid 주민번호 뒷자리 첫번째 숫자
//     * @return 성별숫자코드(1 : 남자, 2 : 여자) string
//     */
//    public static String sid2GenderDigit(String sid) {
//        int sidInt = Integer.parseInt(sid);
//        // 2로 나누어 떨어지면 여자, 아니면 남자
//        if (sidInt % 2 == 0) {
//            return String.valueOf(MiCommonEnum.여.getValueInteger());
//        } else {
//            return String.valueOf(MiCommonEnum.남.getValueInteger());
//        }
//    }
//
//    /**
//     * 주민번호 뒷자리 첫번째 숫자를 성별 문자코드로 바꾼다
//     *
//     * @param sid 주민번호 뒷자리 첫번째 숫자
//     * @return 성별문자코드(M : 남자, F : 여자) string
//     */
//    public static String sid2GenderString(String sid) {
//        int sidInt = Integer.parseInt(sid);
//        if (sidInt % 2 == 0) {
//            return MiCommonEnum.여.getValueString();
//        } else {
//            return MiCommonEnum.남.getValueString();
//        }
//    }
//}
