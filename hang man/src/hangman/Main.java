package hangman;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
class Hangman{
    private String []wordCollection;
    private String hiddenString; // 숨겨진 문자열(문제)
    private String meaning; // 문제(단어)의 뜻
    private StringBuffer outputString; // 플레이어의 입력에 따른 결과로 보여줄 문자열
    private StringBuffer inputStringRecord; // 플레이어가 입력한 문자들의 기록
    private int life;
    private String playerInputString; // 플레이어가 키보드로 입력한 문자
    
    Hangman() throws IOException{
        // FileInputStream(텍스트 파일에서 단어를 가져옴) + 한글 깨짐 방지
        FileInputStream file = new FileInputStream(
                "C:\\Users\\kkhkk\\eclipse-workspace/hangman.txt");
        InputStreamReader isr = new InputStreamReader(file, "MS949");
        BufferedReader br = new BufferedReader(isr);
        
        String data = br.readLine();
        wordCollection = data.split("_"); // 배열에 단어들을 삽입
        
        life=5;
 
        file.close();
        isr.close();
        br.close();
    }
    
    public void making_question(){
        draw_man();
        
        // 문제, 단어 의미 생성
        int randomNumber = (int)(Math.random() * (wordCollection.length) + 0);
        int position=wordCollection[randomNumber].indexOf("/");
        hiddenString = wordCollection[randomNumber].substring(0,position);
        meaning = wordCollection[randomNumber].substring(position+1);
        
        // 초기화
        outputString = new StringBuffer();
        for(int i=0; i<hiddenString.length(); i++){
            if(hiddenString.charAt(i) == ' '){ // 띄어쓰기일 경우
                outputString.append(" ");
            }
            else{
                outputString.append("*");
            }
        }
        inputStringRecord= new StringBuffer();
    }
    
    public String enter_string(){
        // 사용자로부터 문자 입력받음
        System.out.println(outputString);
        System.out.println("단어의 의미: "+meaning);
        System.out.println("입력한 문자:"+inputStringRecord);
        System.out.println("라이프: "+life);
        System.out.println("문자를 입력하세요.(0번: 다른 문제 보기)");
        
        Scanner sc = new Scanner(System.in);
        playerInputString = sc.next().substring(0,1);
        
        return playerInputString;
    }
    
    public void check_inputStringRecord(){
        if(inputStringRecord.indexOf(playerInputString) == -1){ // 이미 입력한 문자가 아닐 때
            inputStringRecord.append(" "+playerInputString);
            check_hiddenString();
        }
        else{ // 이미 입력한 문자일 때
            System.out.println("입력한 문자입니다.");
            draw_man();
        }
    }
    
    private void check_hiddenString(){
        boolean flag = false;
        
        // 입력한 문자가 맞는지 체크
        for(int i=0; i<hiddenString.length(); i++){
            if(hiddenString.charAt(i)==playerInputString.charAt(0)){
                flag = true;
                outputString.setCharAt(i, playerInputString.charAt(0));
            }
        }
        
        if(!flag) life--;
        
        draw_man();
    }
    
    private void draw_man(){
        switch(life){
        case 5:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("        | ");
            System.out.println("        | ");
            System.out.println("        | ");
            break;
        case 4:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("  ●     | ");
            System.out.println("        | ");
            System.out.println("        | ");
            break;
        case 3:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("  ●     | ");
            System.out.println("  |     | ");
            System.out.println("        | ");
            break;
        case 2:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("  ●     | ");
            System.out.println(" -|     | ");
            System.out.println("        | ");
            break;
        case 1:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("  ●     | ");
            System.out.println(" -|-    | ");
            System.out.println("        | ");
            break;
        case 0:
            System.out.println("  _______ ");
            System.out.println("  |     | ");
            System.out.println("  |     | ");
            System.out.println("  ●     | ");
            System.out.println(" -|-    | ");
            System.out.println("    ㅅ           | ");
        }
    }
    
    public StringBuffer getOutputString(){
        return outputString;
    }
    
    public String getHiddenString(){
        return hiddenString;
    }
    
    public String getMeaning(){
        return meaning;
    }
    
    public int getLife(){
        return life;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Hangman hangman=new Hangman();
        boolean exit=false;
        int enterNumber;
        int correctedQuestion = 0;
        
        while(!exit){
            System.out.println("1번: 문제 보기, 2번: 종료");
            enterNumber=sc.nextInt();
            if(enterNumber == 2) break;
            hangman.making_question();
            while(hangman.getOutputString().indexOf("*") != -1 && hangman.getLife() != 0){ // 단어가 모두 드러날 때 까지 or 라이프가 0이 되면
                String playerInputString = hangman.enter_string();
                System.out.println("");
                if(playerInputString.equals("0") == true)break;
                else{
                    hangman.check_inputStringRecord();
                }
            }
            System.out.println("정답: "+hangman.getHiddenString()+", 의미: "+hangman.getMeaning());
            System.out.println("");
            if(hangman.getOutputString().indexOf("*") == -1){
                System.out.println("맞춘 문제: "+(++correctedQuestion)+"\n");
            }
            if(hangman.getLife() == 0) {
                System.out.println("Game Over!"+"\n");
                break;
            }
        }
    }
}