import java.io.*;

public class Pager {


    public Pager(long totalCount){ // *전체 게시글 수*를 넣어준 페이지를 구현



        try {
            final int pageHaveTxt = 10; // 한 페이지당 보여지는 글의 수
            int PageNum = (int) totalCount; // 페이지의 번호
            if(totalCount != 0) {
                PageNum = 1 + (int) totalCount/pageHaveTxt; // 글의 수가 1이상이면 무조건 1 + 글의개수/page마다 가지는 글의 수
            } else {
                PageNum = 0; // 글의 개수 0이면 0임 없음
            } // PageNum 초기화
            File file = new File("property.html"); // 파일 만들어주기
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // 파일 코드 작성

            writer.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "<style>\n" +
                    "  .on{ \n" +
                    "     color:red;\n" +
                    "    }\n" +
                    "</style>\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<a href='#'>[처음]</a>\n" +
                    "<a href='#'>[이전]</a>\n" +
                    "\n");
            writer.close();
        } catch (IOException e){
        }
    }

    String html(long pageIndex) { // *현재 페이지*를 출력하는 코드

        String path = "C:\\Github\\Homework1Week4\\"+pageIndex+".html";
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // 파일 코드 작성
            //삽입
            try {
            // 읽기 전용 스트림 생성
                FileInputStream stream = new FileInputStream("C:\\Github\\Homework1Week4\\property.html");
                InputStreamReader reader =new InputStreamReader(stream,"UTF-8");
                BufferedReader in = new BufferedReader(reader);
            // 모든 내용 읽기
                int code;
                while ((code=in.read()) != -1) {
                    writer.write((char)code);
                }
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //종료
            if(pageIndex/10<1){
                for(int i=1; i<=10; i++){
                    if(i==pageIndex) {
                        writer.write(
                                "<a href='#' class='on'>"+pageIndex+"</a> \n"
                        );
                    } else {
                        writer.write(
                                "<a href='#'>"+i+"</a> \n"
                        );
                    }
                }
            } else if( pageIndex/10>=1){
                for(int i=1; i<=pageIndex%10; i++){
                    if(10+i==pageIndex) {
                        writer.write(
                                "<a href='#' class='on'>"+(10+i)+"</a> \n"
                        );
                    } else {
                        writer.write(
                                "<a href='#'>"+(10+i)+"</a> \n"
                        );
                    }
                }
            }
            writer.write(
                "\n" +
                    "<a href='#' >[다음]</a>\n" +
                    "<a href='#' >[마지막]</a>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            writer.close();
            FileInputStream stream = new FileInputStream("C:\\Github\\Homework1Week4\\"+pageIndex+".html");
            InputStreamReader reader =new InputStreamReader(stream,"UTF-8");
            BufferedReader in = new BufferedReader(reader);
            int ch;
            String txt = "";
            while((ch=in.read())!=-1){
                txt = txt+(char)ch;
            }
            System.out.print(txt);
        } catch (IOException e){

        }
        return "";
    }
}

