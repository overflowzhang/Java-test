import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class Demo {
	public static void main(String[] args){
		File afile = new File("src/a.txt");
		if(!afile.exists()){
			try{
				afile.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		File bfile = new File("src/b.txt");
		if(!bfile.exists()){
			try{
				bfile.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		char[] cstring = null;
		try{
			RandomAccessFile r1 = new RandomAccessFile(afile, "rw");
			String string = r1.readLine();
			cstring = string.toCharArray();
			for(int i=0;i<cstring.length;i++){
				if(cstring[i]>='A'&&cstring[i]<='Y'){
					cstring[i] = (char)(cstring[i]+1);
				}
				else if (cstring[i]=='Z') {
					cstring[i] = 'A';
				}
				else if(cstring[i]>='a'&&cstring[i]<='y'){
					cstring[i] = (char)(cstring[i]+1);
				}
				else if (cstring[i]=='z') {
					cstring[i] = 'a';
				}
				else if (cstring[i]>='2'&&cstring[i]<='9') {
					cstring[i] = (char)(107-cstring[i]);
				}
				else if (cstring[i]=='1') {
					cstring[i]='0';
				}
				else if (cstring[i]=='0') {
					cstring[i]='1';
				}
			}
			try{
				PrintStream printStream = new PrintStream(new FileOutputStream(bfile));
				printStream.println(cstring);
				printStream.close();
			}catch(IOException exception2){
				exception2.printStackTrace();
			}
			r1.close();
		}catch(IOException exception){
			exception.printStackTrace();
		}	
	}
}
