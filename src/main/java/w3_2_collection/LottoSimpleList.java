package w3_2_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoSimpleList {
    public static void main(String[] args) {
        // 1. 숫자 범위 1~45 랜덤 추출기 생성
        // 추출기 자체에서 중복번호 나올 수 없게 처리해도 됨

        // 2. 6개의 숫자를 당첨번호로 저장할 수 있는 List<Integer> 생성
        // 중복 번호가 나올 경우 Pass 할 수 있는 로직 구현
        List<Integer> winNumbers = new ArrayList<>(6);
        // 메서드로 분리 가능 -> 직접 분리해보기! (extract method)
        fillNumToLottery(winNumbers);
        int pickedNum;
        Collections.sort(winNumbers);
        System.out.println("win num: " + winNumbers);

        int tryCount = 0;
        List<Integer> tryNumbers = new ArrayList<>(6);
        do {
            tryNumbers.clear();
            tryCount++;
            // 3. 6개의 숫자를 복권번호로 저장할 수 있는 List<Integer> 생성
            // 중복 번호가 나올 경우 Pass 할 수 있는 로직 구현
            // 메서드로 분리 가능 -> 직접 분리해보기! (extract method)
            fillNumToLottery(tryNumbers);
            Collections.sort(tryNumbers);
//            if (tryCount % 100_000 == 0) {
//                System.out.print("\n"+(tryCount / 100_000));
//            }
        } while (!winNumbers.equals(tryNumbers));
        // containsAll() 과 같은 메서드로 Set 자료형을 비교하는 경우에는
        // 객체 동일성만을 비교 가능
        // 객체 내부의 값 간에 비교를 해야 하는 경우
        //   -> next() 를 반복하면서 객체의 필드, 변수 참조를 실행하는 코드 필요

        System.out.println("try num: " + tryNumbers);
        System.out.println("당첨입니다! (시도횟수: " + tryCount + ")");

        // 4. 당첨번호와 복권번호를 비교할 수 있는 비교 메서드 구현
        // List 에서 순서가 달라도 비교할 수 있게 로직 구현
    }

    private static void fillNumToLottery(List<Integer> winNumbers) {
        int pickedNum;
        while (winNumbers.size() < 6) {
            pickedNum = getLottoNum();
            if (!winNumbers.contains(pickedNum)){
                winNumbers.add(pickedNum);
            }
        }
    }

    private static int getLottoNum() {
        Random myRandom = new Random();
        return myRandom.nextInt(45) + 1;
    }
    // 6. 당첨 될 때까지 뽑는 반복문 작성 (3~5번 수정)
    //    당첨 시에만 결과 출력하고, 출력문에 반복 횟수를 함께 출력
}
