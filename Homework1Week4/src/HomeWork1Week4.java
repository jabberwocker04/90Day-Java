import java.io.FileNotFoundException;

public class HomeWork1Week4 {
    public static void main(String[] args) throws FileNotFoundException {
        long totalCount = 127; // 글의 개수
        long pageIndex = 12; // 현재 페이지 번호
        Pager pager = new Pager(totalCount); //pager에 글의 개수를 인자로 넣어줌
        System.out.println(pager.html(pageIndex)); // 현재 페이지를 출력함
    }

}
