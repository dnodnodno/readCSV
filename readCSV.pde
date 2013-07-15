Table table;

PFont sysFont;
PFont f;
float angle = 0.0;

int rowCount;
String name; 
String newName;
String[] n;
PVector pos;

void setup() {

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

void readcsv(){
//	load CSV as table
	table = loadTable("5-12-2008.csv", "header");
}


void draw() {
	
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
  	angle += 0.2;
    angle -= 0.5; 
  	//popMatrix();

  	println(frameRate);
}

void mousePressed() {
	background(0);
}
