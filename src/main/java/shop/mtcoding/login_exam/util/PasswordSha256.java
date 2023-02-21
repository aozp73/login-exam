package shop.mtcoding.login_exam.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordSha256 {

    public static String getSalt() {
        // 1. Random, salt 생성
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[20];

        // 2. 난수 생성
        sr.nextBytes(salt);

        // 3. byte To String (10진수 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for (byte b : salt) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public static String encrypt(String planText, String salt) {

        try {

            // MessageDigest 클래스 : 임의의 size의 데이터를 취해 고정 길이의 해시 값을 출력하는 단방향 해시 기능
            // MessageDigest.getInstance(String algorithm)
            // 메소드의 인수에 알고리즘 이름을 지정함으로써 해당 알고리즘에서 해시값을 계산하는 MessageDigest를 구할 수 있음
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // update() : 지정된 바이트 데이터를 사용해 객체 내에 저장된 digest 값을 갱신
            // getBytes() : 문자열 -> byte
            md.update((planText + salt).getBytes());
            // .digest() : 패딩과 같은 최종 작업을 수행하여 해시 계산을 완료. 이 호출이 이루어진 후에 다이제스트가 재설정
            byte[] byteData = md.digest();

            StringBuffer hexString = new StringBuffer();

            // 바이트 -> 16진수로 바꿔서 append
            for (byte b : byteData) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
