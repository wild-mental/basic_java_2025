package w3_2_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PWCheckSample {
    public static void main(String[] args) {
        /*
           {
             userId1 : userPw1,
             userId2 : userPw2,
             userId3 : userPw3
             ...
             userIdN : userPwN
           }
         */
        Map<String, String> myLoginMap = new HashMap<>();
        Scanner myScanner = new Scanner(System.in);

        // Scanner 로 ID, PW 순차 입력
        // 입력시마다 키 존재, PW 일치 확인
        myLoginMap.put("userId1", "pw1");
        myLoginMap.put("userId2", "pw2");
        myLoginMap.put("userId3", "pw3");
        System.out.println(myLoginMap);

        // ID 입력받은 후, 등록되어 있는지 검사
        System.out.print("아이디를 입력하세요:");
        String idInput = myScanner.nextLine();
        // 맵 자료형 내부에 ID는 키로 관리됨, 키 Set 에서 입력된 ID 값의 포함 유무 검사
        String userPwFound = myLoginMap.get(idInput);  // 키가 없으면 null 값 반환
        if (userPwFound != null) {
            System.out.print("등록된 아이디로 확인!");
        } else {
            System.out.print("등록된 아이디가 없습니다.");
        }
        System.out.print("패스워드를 입력하세요:");
        String pwInput = myScanner.nextLine();
        // 실제로는 암호화된 인풋으로 수신될 것임
        if (
            pwInput.equals(userPwFound)  // 암호화된 값끼리 비교
        ) {
            System.out.println("패스워드 일치! 로그인 성공!");
        } else {
            System.out.println("패스워드 불일치! 로그인 실패!");
        }
    }
}
