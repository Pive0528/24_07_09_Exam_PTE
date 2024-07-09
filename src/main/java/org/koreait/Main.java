package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lastNumber = 0;
        System.out.println("== 명언 앱 실행 ==");
        Scanner sc = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("등록")) {         //완료
                int id = lastNumber+1;
                String getDate = Util.getNow();
                System.out.print("명언 : ");
                String text = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                Article article = new Article(id, getDate, text, author);
                articles.add(article);

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                lastNumber++;

            }

            else if (cmd.equals("목록")) {        //완료
                System.out.println("번호   /   작가   /   명언");
                System.out.println("===================================");
                for (int i = articles.size() - 1; i >= 0; i--) {
                    Article article = articles.get(i);
                    System.out.printf("%d   /   %s   /   %s\n", article.getId(), article.getText(), article.getAuthor());
                }

            }

            else if (cmd.startsWith("상세보기")) {      //완료?
                int id = Integer.parseInt(cmd.split("id=")[1]);
                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;  // 존재하는지 여부 최종판결
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                }
                else if (foundArticle != null){
                    System.out.printf("번호 : %d\n", foundArticle.getId());
                    System.out.printf("날짜 : %s\n", foundArticle.getDate());
                    System.out.printf("작가 : %s\n", foundArticle.getAuthor());
                    System.out.printf("내용 : %s\n", foundArticle.getText());
                }
            }
            else if (cmd.startsWith("삭제")) {       // 완료
                int id = Integer.parseInt(cmd.split("id=")[1]);
                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;  // 존재하는지 여부 최종판결
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                }
                else if (foundArticle != null){
                    articles.remove(foundArticle);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                }
            }

            else if (cmd.startsWith("수정")) {    //완료
                int id = Integer.parseInt(cmd.split("id=")[1]);
                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;  // 존재하는지 여부 최종판결
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                }
                else if (foundArticle != null) {
                    System.out.printf("명언(기존) :%s\n", foundArticle.getText());
                    System.out.printf("작가(기존) :%s\n", foundArticle.getAuthor());
                    System.out.printf("명언 : ");
                    String text2 = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author2 = sc.nextLine().trim();

                    foundArticle.setText(text2);
                    foundArticle.setAuthor(author2);

                    System.out.printf("%d번 명언이 수정되었습니다.\n", id);
                }

            }
        }

    }
}
