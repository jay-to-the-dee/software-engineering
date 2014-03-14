package classification;
/**
 * FileIO: Basic class for data file input and output
 * @version 2000
 * @author billk
 * 
 */ 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

	BufferedReader bfr;
	BufferedWriter bfw;
	PrintWriter pw;
	String status;

	/**
	 * Construct a FileIO object
	 * @param rw a string determining whether the file is to be read from ("r") or written to ("w")
	 * @param fname name of the file
	 */
	public FileIO( String rw, String fname ) {
		status = rw;
		if ( status.equals( "r" ) ) {
			try
			{
				FileReader fr = new FileReader( fname );
				bfr = new BufferedReader( fr );
			}
			catch ( FileNotFoundException fnf )
			{
				System.out.println( "The file " + fname + " was not found" );
				System.out.println( fnf.toString() );
			}
		}
		else if ( status.equals( "w" ) ) {
			try
			{
				FileWriter fw = new FileWriter( fname );
				bfw = new BufferedWriter( fw );
				pw = new PrintWriter( bfw );
			}
			catch ( FileNotFoundException fnf )
			{
				System.out.println( "The file " + fname + " was not found" );
				System.out.println( fnf.toString() );
			}
			catch ( IOException ioe )
			{
				System.out.println( ioe.toString() );
			}
		}
		else {
			System.out.println( "Bad option for FileIO" );
		}
	}

	/**
	 * Read a line from a file
	 * @return the line as a String object
	 */
	public String readLine() {

		if (!status.equals("r")) {
			System.out.println("No file open for reading!");
			return null;
		}
		String line = null;
		try
		{
			line = bfr.readLine();
		}
		catch ( IOException ioe )
		{
			System.out.println( ioe.toString() );
		}
		return line;
	}

	/**
	 * Write a string to a file
	 * @param s the string to be written out
	 */
	public void print( String s ) {
		if (!status.equals("w")) {
			System.out.println("No file open for writing!");
			return;
		}
		pw.print( s );
		pw.flush();
	}

	/**
	 * Write a string to a file; append trailing new line
	 * @param ln the String to be written out
	 */
	public void println( String ln ) {
		if (!status.equals("w")) {
			System.out.println("No file open for writing!");
			return;
		}
		pw.println( ln );
		pw.flush();
	}

	public void close() {
		pw.close();
	}


}


