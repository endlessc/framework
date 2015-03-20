package com.mftour.utils;

import java.nio.charset.Charset;

public class ByteUtils {

    public static byte[] int2bytes(int i) {
        byte[] bt = new byte[4];
        bt[0] = (byte) (0xff & i);
        bt[1] = (byte) ((0xff00 & i) >> 8);
        bt[2] = (byte) ((0xff0000 & i) >> 16);
        bt[3] = (byte) ((0xff000000 & i) >> 24);
        return bt;
    }

    /**
     * byte to int
     *
     * @param bytes
     * @return
     */
    public static int bytes2int(byte[] bytes) {
        int num = bytes[0] & 0xFF;
        num |= ((bytes[1] << 8) & 0xFF00);
        num |= ((bytes[2] << 16) & 0xFF0000);
        num |= ((bytes[3] << 24) & 0xFF000000);
        return num;
    }


    public static long networkByteOrderToLong(byte[] buf, int start, int count) {
        if (count > 8) {
            throw new IllegalArgumentException(
                    "Cannot handle more than 8 bytes");
        }
        long result = 0;
        for (int i = 0; i < count; i++) {
            result <<= 8;
            result |= (buf[start + i] & 0xff);
        }

        return result;
    }


    public static byte[] longToNetworkByteOrder(long num, int count) {

        if (count > 8) {
            throw new IllegalArgumentException(
                    "Cannot handle more than 8 bytes");
        }
        byte[] buf = new byte[count];
        int start = 0;
        for (int i = count - 1; i >= 0; i--) {
            buf[start + i] = (byte) (num & 0xff);
            num >>>= 8;
        }
        return buf;
    }

    public static long bytesToUint(byte[] array) {
        return ((long) (array[3] & 0xff))
                | ((long) (array[2] & 0xff)) << 8
                | ((long) (array[1] & 0xff)) << 16
                | ((long) (array[0] & 0xff)) << 24;
    }

    public static long bytesToUint(byte[] array, int offset) {
        return ((long) (array[3 + offset] & 0xff))
                | ((long) (array[2 + offset] & 0xff)) << 8
                | ((long) (array[1 + offset] & 0xff)) << 16
                | ((long) (array[0 + offset] & 0xff)) << 24;
    }

    public static byte[] stringGBKToNetworkByteOrder(String msg, int count) {
        byte[] buf = new byte[count];
        byte[] strBytes = msg.getBytes(Charset.forName("GBK"));
        for (int i = 0; i < count; i++) {
            if (i < strBytes.length)
                buf[i] = strBytes[i];
            else
                buf[i] = 0;
        }
        return buf;
    }

    public static String networkByteOrderToGBKString(byte[] buf, int offset, int count) {
        byte[] str = new byte[count];

        int i = 0;
        for (i = 0; i < count && buf[i + offset] != 0; i++) {
            str[i] = buf[i + offset];
        }

        byte[] str1 = new byte[i];
        for (int j = 0; j < str1.length; j++) {
            str1[j] = str[j];
        }

        return new String(str1, Charset.forName("GBK"));
    }

    public static String networkByteOrderToUTF8String(byte[] buf, int offset) {
        int l = buf.length - offset;
        byte[] str = new byte[l];

        int i = 0;
        for (i = 0; i < l && buf[i + offset] != 0; i++) {
            str[i] = buf[i + offset];
        }

        return new String(str, Charset.forName("UTF-8"));
    }

    public static void putByte(byte b[], byte s, int index) {
        b[index] = s;
    }

    // ///////////////////////////////////////////////////////
    public static void putBigEndianInt(byte[] bb, int x, int index) {
        bb[index + 0] = (byte) (x >> 24);
        bb[index + 1] = (byte) (x >> 16);
        bb[index + 2] = (byte) (x >> 8);
        bb[index + 3] = (byte) (x >> 0);
    }

    // /////////////////////////////////////////////////////////
    public static void putBigEndianLong(byte[] bb, long x, int index) {
        bb[index + 0] = (byte) (x >> 56);
        bb[index + 1] = (byte) (x >> 48);
        bb[index + 2] = (byte) (x >> 40);
        bb[index + 3] = (byte) (x >> 32);
        bb[index + 4] = (byte) (x >> 24);
        bb[index + 5] = (byte) (x >> 16);
        bb[index + 6] = (byte) (x >> 8);
        bb[index + 7] = (byte) (x >> 0);
    }

    public static void putReverseBytesInt(byte[] bb, int x, int index) {
        bb[index + 3] = (byte) (x >> 24);
        bb[index + 2] = (byte) (x >> 16);
        bb[index + 1] = (byte) (x >> 8);
        bb[index + 0] = (byte) (x >> 0);
    }

    public static void putLittleEndianLong(byte[] bb, long x, int index) {
        bb[index + 7] = (byte) (x >> 56);
        bb[index + 6] = (byte) (x >> 48);
        bb[index + 5] = (byte) (x >> 40);
        bb[index + 4] = (byte) (x >> 32);
        bb[index + 3] = (byte) (x >> 24);
        bb[index + 2] = (byte) (x >> 16);
        bb[index + 1] = (byte) (x >> 8);
        bb[index + 0] = (byte) (x >> 0);
    }

    public static void putLittleEndianBytesShort(byte b[], short s, int index) {
        b[index] = (byte) (s >> 0);
        b[index + 1] = (byte) (s >> 8);
    }

    public static void putBigEndianShort(byte b[], short s, int index) {
        b[index] = (byte) (s >> 8);
        b[index + 1] = (byte) (s >> 0);
    }


    public static int getUnsignedByte(byte data) {
        //将data字节型数据转换为0~255 (0xFF 即BYTE)。
        return data & 0x0FF;
    }

    public static int getUnsignedByte(short data) {
        //将data字节型数据转换为0~65535 (0xFFFF 即 WORD)。
        return data & 0x0FFFF;
    }

    public static long getUnsignedInt(int data) {
        //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
        return data & 0x0FFFFFFFF;
    }

    //byte[]型数据转成int[]型数据
    public static int[] byteToInt(byte[] content, int offset, int length) {

        int[] result = new int[length >> 2];//除以2的n次方 == 右移n位 即 content.length / 4 == content.length >> 2
        for (int i = 0, j = offset; j < offset + length; i++, j += 4) {
            result[i] = getUnsignedByte(content[j + 3]) | getUnsignedByte(content[j + 2]) << 8 |
                    getUnsignedByte(content[j + 1]) << 16 | (int) content[j] << 24;
        }
        return result;
    }


    /**
     * Returns a hexadecimal representation of the given byte array.
     *
     * @param bytes the array to output to an hex string
     * @return the hex representation as a string
     */
    public static String Byte2Hex(byte[] bytes) {
        return Byte2Hex(bytes, null);
    }

    /**
     * Returns a hexadecimal representation of the given byte array.
     *
     * @param bytes     the array to output to an hex string
     * @param separator the separator to use between each byte in the output
     *                  string. If null no char is inserted between each byte value.
     * @return the hex representation as a string
     */
    public static String Byte2Hex(byte[] bytes, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String code = Integer.toHexString(bytes[i] & 0xFF);
            if ((bytes[i] & 0xFF) < 16) {
                sb.append('0');
            }

            sb.append(code);

            if (separator != null && i < bytes.length - 1) {
                sb.append(separator);
            }
        }

        return sb.toString();
    }

    /**
     * Converts a hex string representation to a byte array.
     *
     * @param hex the string holding the hex values
     * @return the resulting byte array
     */
    public static byte[] Hex2Byte(String hex) {
        byte[] bts = new byte[hex.length() / 2];
        for (int i = 0; i < bts.length; i++) {
            bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return bts;
    }


    public static void main(String[] args) {
        long L184 = 1218937181227192819L;
        byte[] buf = longToNetworkByteOrder(L184, 8);

        long result = networkByteOrderToLong(buf, 0, 8);
        System.out.println(result == L184);

        int i184 = 875836468;

        System.out.println("**吃**".contains("*"));

    }

}
