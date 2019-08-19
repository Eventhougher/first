package com.until;

public class StringUntil {
    public static boolean isNoNull(String str){
        return (str!=null&&!"".equals(str));
    }

    public static Integer str2Int(String str,Integer defValue){
        if(isNoNull(str)){
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defValue;
    }
    public static Double str2double(String str,Double defValue){
        if(isNoNull(str)){
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defValue;
    }
}
