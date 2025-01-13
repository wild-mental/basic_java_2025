package w2_17_exception;

import java.util.Scanner;

public class SimpleTryCatchSample {
    public static void throwPartiallyHandledException() throws RuntimeException {
        boolean divisionDone = false;  // 종료 조건 flag
        int tryCount = 1;              // 시도 횟수 카운팅
        Scanner userInputScanner = new Scanner(System.in);  // 유저 입력에 따른 실행

        while(!divisionDone) {
            try {  // 예외 발생 가능성이 있는 코드 배치
                System.out.print("10을 나눌 분모 값을 입력하세요:");
                int devideBy = Integer.parseInt(userInputScanner.nextLine());
                division(10, devideBy);
                divisionDone = true;
                throw new Exception();
            }
//            catch (NumberFormatException e) {
//                System.err.println("숫자 형태 입력값만 받을 수 있습니다.");
//            }
//            catch (ArithmeticException e) {
//                // throw e;
//                System.err.println("0 으로 나눌 수 없습니다.");
//            }
            catch (
                // 여러개의 예외 타입에 대해서 동일한 내용으로 대응할 수 있을 경우 사용
                NumberFormatException | ArithmeticException e
            ) {
                System.err.println("0 또는 숫자가 아닌 값을 넣을 수 없습니다");
            }
            catch (Exception e) {
                System.err.println("알려지지 않은 예외가 발생했습니다. 다시 시도해주세요");
                throw new RuntimeException("예외를 직접 처리할 수는 없지만 추가 정보를 기입하여 thow");
            } finally {
                System.out.println("시도 횟수: " + tryCount);
                tryCount++;
                if (tryCount > 9) {
                    divisionDone = true;
                }
            }
        }
    }

//    public static void main(String[] args) throws ArithmeticException, Exception {
    public static void main(String[] args) {
        // main 메서드처럼 특정 영역의 메서드 호출 단계를 넘어서서 throws 를 수행하면 안되는 경우가 많다
        //  ex - 완결적인 하나의 기능을 제공해야 할 경우,
        //       예외 상황에서 추가적인 정보를 제공하지 않고서는 상위 호출부가 해결할 수 없는 경우
        //       => 반드시 catch 구문에서 예외상황에 대한 대응 코드를 작성해 주어야 함
        // division(10, 0);
//        try {
//            division(10, 0);
//        } catch (ArithmeticException e) {  // 하위의 구체적인 정보를 가진 예외 타입부터 catch 수행
//            System.err.println("0 으로 나눌 수 없습니다.");
//        } catch (Exception e) {            // 최상위 예외까지 전부 catch 구문에 명시하는 경우, 예외에 따른 프로그램의 부정 종료 방지 가능
//            System.err.println("알려지지 않은 동작 발생: \n" + e.getMessage());
//        }

        // 여러 메서드에서 예외 타입이 변경되어 가면서 추가 정보를 완성하며 단계적인 예외 대응을 수행할 수 있음
        try {
            throwPartiallyHandledException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static float division(int a, int b)
        throws ArithmeticException, Exception
        // Checked Exception 을 의무적으로 핸들링하는 용도로만 사용되지는 않음
        // 런타임 Exception 을 컴파일러에게 명시적으로 알려주는 효과
    {
        // throw new Exception("예상치 못한 Exception");
        return a / b;
    }
}