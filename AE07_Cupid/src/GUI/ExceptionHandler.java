package GUI;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ExceptionHandler extends Exception {

	private Exception ex;
	
	public ExceptionHandler(Exception e) {
		this.ex = e;
	}
	
	public void handle()  {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("exception.txt"), "utf-8"))) {
	   writer.write(this.ex.getMessage());
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}



	
	
	
}
