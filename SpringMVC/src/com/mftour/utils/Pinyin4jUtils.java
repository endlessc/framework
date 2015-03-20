package com.mftour.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4jUtils {

    /**
     * 将汉字转换为全拼
     *
     * @param src 字符串
     * @return String
     */
    public static String getPinYin(String src) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder sb = new StringBuilder();

        try {
            for (char ch : src.toCharArray()) {
                // 判断能否为汉字字符
                if (Character.toString(ch).matches("[\\u4E00-\\u9FA5]+")) {
                    sb.append(PinyinHelper.toHanyuPinyinStringArray(ch, format)[0]);// 取出该汉字全拼的第一种读音并连接到字符串t4后
                } else {
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                    sb.append(Character.toString(ch));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 提取每个汉字的首字母
     *
     * @param str 字符串
     * @return String
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {

            char word = str.charAt(j);
            if (!Character.toString(word).matches("[\\u4E00-\\u9FA5]+"))
                continue;
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    public static void main(String[] args) {
        String cnStr = "汉庭（天坛店）";
        System.out.println(getPinYin(cnStr));
        System.out.println(getPinYinHeadChar(cnStr));
    }
}
