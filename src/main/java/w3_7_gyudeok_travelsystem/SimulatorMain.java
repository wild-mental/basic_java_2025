package w3_7_gyudeok_travelsystem;

public class SimulatorMain {
    public static void main(String[] args) {
        // 시민 : 모든 조건 충족
        Citizen my_Pass_CV = new Citizen("GyuDeok",24,"Korea", true,"Male",false,true);
        // 시민 : 여권없음
        Citizen my_NonPass_CV = new Citizen("GyuDeok",24,"Korea", false,"Male",false,true); // 여권이 없음
        // 국가 : 여행가능국
        Nation USA = new Nation("USA",false, "democracy",7);
        // 국가 : 여행가능국
        Nation Korea = new Nation("Korea",false, "democracy",13);
        // 국가 : 전쟁중 여행, 이민 불가
        Nation Russia = new Nation("Russia",true, "democracy",12);
        // 무국적자
        StatelessPerson my_Pass_SL = new StatelessPerson("hong",21,"Korea","Male", "Destitute");

        my_NonPass_CV.travel(USA); // 여행 불가능
        my_Pass_CV.travel(USA);
        my_Pass_CV.emigration(USA);  // 국적이 바뀌는 예시

        //my_Pass_SL.travel(USA);   // 여행 불가 , 시도는 가능
        my_Pass_SL.emigration(USA); // 국적획득
        //my_Pass_SL.travel(Korea); // 한국여행도 불가 -> 국적을 획득하는 순간 시민임.
    }
}
