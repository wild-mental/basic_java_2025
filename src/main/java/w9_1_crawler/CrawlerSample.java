package w9_1_crawler;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerSample {
    public static void main(String[] args) {
        try {
            // 파일 경로 및 output 파일명 설정
            String currentPath = System.getProperty("user.dir");
            String resultPath = currentPath + "/crawled_data";
            String fileName = "crawling_result";
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
            String formattedDateTime = now.format(formatter);
            String extension = "md";
            String filePath = String.format("%s/%s_%s.%s", resultPath, fileName, formattedDateTime, extension);
            System.out.println(filePath);

            // file writer 준비
            FileWriter fw = new FileWriter(filePath, true);
            PrintWriter out = new PrintWriter(fw, true);

            // 크롤링 대상 사이트 경로 설정 및 연결 준비
            String URL = "https://news.hada.io/";
            int articleCnt = 0;
            for (int i=1; i<4; i++) {
                String params = "?page=" + i ;
                Connection conn = Jsoup.connect(URL+params);
                // bot 차단을 뚫기 위한 User-Agent 헤더 설정
                conn.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36");

                // 사이트 접근 및 관심 대상 콘텐츠 select
                Document doc = conn.get();
                Elements elements = doc.select(".topics .topictitle");
                for( Element element : elements ) {
                    // 선택된 콘텐츠 모두 준비된 파일에 작성
                    out.println("### " + ++articleCnt + ". " + element.text()); // title 마크 다운
                    out.println("- Link: "+element.select("a[href]").attr("href")+"\n"); // 리스트 항목 마크다운
                    System.out.println(element.text()); // 콘솔 확인
                }
            }
            System.out.println("크롤링 완료!");
        } catch (Exception e) {
            System.out.println("크롤링 실패 : ");
            e.printStackTrace();
        }
    }
}