package kihyun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Recorder {
 private static int maxscore_2048=0;
 public static int getMaxscore_2048() {
 // TODO Auto-generated method stub
 return maxscore_2048;
 }
 public static void setMaxscore(int maxscore_2048) {
 // TODO Auto-generated method stub
 Recorder.maxscore_2048=maxscore_2048;
 }
 private static FileReader fr=null;
private static BufferedReader br=null;
private static FileWriter fw=null;
private static BufferedWriter bw=null;
//      ��  
public static void getRecording()
{
 boolean flag =false;//        
 try {
 File f=new File("src/myrecording.txt");
 if(f.exists())
 { 
 fr=new FileReader(f);
 br=new BufferedReader(fr);
 String n=br.readLine();
 maxscore_2048=Integer.parseInt(n); 
 }
 else {
 flag=f.createNewFile();
 }
 }
 catch(Exception e) {
 e.printStackTrace();
 }
 finally {
 try {
 if(!flag) {
 br.close();
 fr.close();
 }
 }catch(Exception e2) {
 e2.printStackTrace();
 }
 }
 }
 //       
 public static void keepRecording()
 {
 try {
 File f=new File("src/myRecording.txt");
 fw=new FileWriter(f);
 bw=new BufferedWriter(fw);
 bw.write(maxscore_2048+"\r"
 		+ "");
 }catch(IOException e) {
 e.printStackTrace();
 }
 finally {
 try {
 bw.close();
 fw.close();
 }
 catch(IOException e) {
 e.printStackTrace();
 }
 }
 }
 } 