import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class readCSV extends PApplet {

Table table;

PFont sysFont;
PFont f;
float angle = 0.0f;

int rowCount;
String name; 
String newName;
String[] n;


PVector pos;

public void setup() {

  size(1200, 1000);
  pos = new PVector(0,0);
  n = new String[5196];
  smooth();
  background(0);
  //textFont( createFont("mingliu", 60, true));
  f = createFont("mingliu",18,true);
  readcsv();
  pos.x = 0;
  pos.y = 0;
}

public void readcsv(){
//	load CSV as table
	table = loadTable("5-12-2008-04.csv", "header");

}


public void draw() {
	
 	pos.x++;
 	pos.y++;
 	//fill(#000000, 10);
 	//rect(0,0,width,height);
	//pushMatrix();
    translate(random(width), random(height));
    rotate(angle);
    fill(255,0,0);
    textSize(46);
    textFont(f);
   // rowCount = table.getRowCount();
 	//println(table.getRowCount() + " total rows in table"); 
  //  count table rows 
	rowCount = (rowCount + 1) % table.getRowCount();
	println(rowCount + "total rows in table");
//	loop through rowCount and retrieve "name" string at each row
	for(int i=0; i < rowCount; i++) {
		TableRow row = table.getRow(i);
  		int id = row.getInt("id");
   		// String age = row.getString("age");
    	name = row.getString("name");
  		n[i] = name;
	   	newName = n[i];//new String(n[i]);
    	//translate(mouseX, mouseY);
      textFont(f);
		  println(newName);
  	}

  	text(newName, 0, 0);
  	angle += 0.2f;
    angle -= 0.5f; 
  	//popMatrix();

  	println(frameRate);
/*
   for(int i=0; i < 12; i++) {
    
    
    text(csv[i][i], width/50, height/50);
    }
 */  
   


}

public void mousePressed() {
	background(0);
}
/*
class CSV {

	Table table;
	int rowCount;
	String name; 

CSV(PFont f, float x, float y) {

		table = loadTable("5-12-2008-04.csv", "header");
		//	count of table rows
		rowCount = table.getRowCount();
		//rowCount = (rowCount + 1) % table.getRowCount();
  	}


	void display() {
		//	loop through rowCount and retrieve "name" string at each row
		for(int i=0; i < rowCount; i++) {
  			TableRow row = table.getRow(i);
  			int id = row.getInt("id");
   			// String age = row.getString("age");
    		name = row.getString("name");

    		NameList.add(name);
			println(i);
			println(name);

			fill(#000000,10);
 	rect(0,0,width,height);
	
	pushMatrix();
    fill(#bada55);
      //char ch = chars.charAt(charcount);
    text(name,width/50, height/50);
  	popMatrix();
  		}
	}

}
*/
// Sketch prints:
// 3 total rows in table
// Goat (Capra hircus) has an ID of 0
// Leopard (Panthera pardus) has an ID of 1
// Zebra (Equus zebra) has an ID of 2
/*
//for importing csv files into a 2d array
//by che-wei wang

String lines[] = loadStrings("5-12-2008.csv" , "ISO-8859-1");
String [][] csv;
int csvWidth=0;

//calculate max width of csv file
for (int i=0; i < lines.length; i++) {
  String [] chars=split(lines[i],',');
  if (chars.length>csvWidth){
    csvWidth=chars.length;
  }
}

//create csv array based on # of rows and columns in csv file
csv = new String [lines.length][csvWidth];

//parse values into 2d array
for (int i=0; i < lines.length; i++) {
  String [] temp = new String [lines.length];
  temp= split(lines[i], ',');
  for (int j=0; j < temp.length; j++){
   csv[i][j]=temp[j];
  }
}

//test
println(csv[2][2]);
*/

    	//NameList.add(name);
    	//newName = NameList.get(i);
    	//println(NameList.get(i));

    //String newName = (String) NameList.get(i); //ArrayLists don't know what they store, so we remind it.
    //println(newName);
    //text(newName, width/50, height/50);

////////////////	
/*
  for (TableRow row : table.rows()) {
    
    int id = row.getInt("id");
   // String age = row.getString("age");
    name = row.getString("name");
   // println(name + " (" + age + ") has an ID of " + id);
  }
 */

 ////////////////////////////////////
///////String [][] readFile(String fileName) {
  //for importing csv files into a 2d array
  //by che-wei wang

 /* 
void csvRead(){
String lines[] = loadStrings("5-12-2008-03.csv");
  //calculate max width of csv file
  for (int i=0; i < lines.length; i++) {
    String [] chars=split(lines[i], ',');
   // if (chars.length>csvWidth) {
    //  csvWidth=chars.length;
    //}
  }

  //create csv array based on # of rows and columns in csv file
  csv = new String [lines.length][csvWidth];

  //parse values into 2d array
  for (int i=0; i < lines.length; i++) {
    String [] temp = new String [lines.length];
    temp= split(lines[i], ',');
    for (int j=0; j < temp.length; j++) {
      csv[i][j]=temp[j];
    }
  }
 // return csv;
//test
println(csv[2][2]);
}
*/
 ////////////////////////////////////
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "readCSV" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
