package cs.utep.IncidentImplement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PersonParse {

	public static void main(String[] args) {
		ArrayList<String[]> dataPrimaryPersonList = new ArrayList<String[]>();
		ArrayList<String[]> dataSecPersonList = new ArrayList<String[]>();
		final String rawDataPrefix= "//Users//danielmejia//Documents//Ph.D.//Incident Data//";
		try {
			String dataPersonFile14 = rawDataPrefix + "ELP Incidents 2014//ELP Public Incidents 2014 PrimaryPerson.csv";
			String dataPersonFile15 = rawDataPrefix + "ELP Incidents 2015//ELP Public Incidents 2015 PrimaryPerson.csv";
			String dataPersonFile16 = rawDataPrefix + "ELP Incidents 2016//ELP Public Incidents 2016 PrimaryPerson.csv";
			String dataPersonFile17 = rawDataPrefix + "ELP Incidents 2017//ELP Public Incidents 2017 PrimaryPerson.csv";
			Queue<String> incidentPersonFiles = new LinkedList<String>();
			incidentPersonFiles.add(dataPersonFile14);
			incidentPersonFiles.add(dataPersonFile15);
			incidentPersonFiles.add(dataPersonFile16);
			incidentPersonFiles.add(dataPersonFile17);
			int countPrimary = 0;
			while(!incidentPersonFiles.isEmpty()) {

				String currentPersonDataFile = incidentPersonFiles.remove();
				BufferedReader dataPersonReader = new BufferedReader(new FileReader(currentPersonDataFile));
				String currentLine ="";
				String[] items = new String[32];
				
				while((currentLine=dataPersonReader.readLine())!=null) {
					if(currentLine.contains("Crash_ID")&&countPrimary>0) {
						countPrimary++;
						continue;
					}
					if(countPrimary==0) {

						items = processInputString(currentLine);
					}else {
							items = processInputString(currentLine);
					}
					countPrimary++;
					dataPrimaryPersonList.add(items);
				}
				dataPersonReader.close();
			}
			//Secondary Persons Involved
			String dataSecPersonFile14 = rawDataPrefix + "ELP Incidents 2014//ELP Public Incidents 2014 Persons.csv";
			String dataSecPersonFile15 = rawDataPrefix + "ELP Incidents 2015//ELP Public Incidents 2015 Persons.csv";
			String dataSecPersonFile16 = rawDataPrefix + "ELP Incidents 2016//ELP Public Incidents 2016 Persons.csv";
			String dataSecPersonFile17 = rawDataPrefix + "ELP Incidents 2017//ELP Public Incidents 2017 Persons.csv";
			Queue<String> incidentSecPersonFiles = new LinkedList<String>();
			incidentSecPersonFiles.add(dataSecPersonFile14);
			incidentSecPersonFiles.add(dataSecPersonFile15);
			incidentSecPersonFiles.add(dataSecPersonFile16);
			incidentSecPersonFiles.add(dataSecPersonFile17);
			int count = 0;
			String[] items = new String[dataPrimaryPersonList.get(0).length];
			String[] header = new String[dataPrimaryPersonList.get(0).length];
			String[] secHeader = new String[dataPrimaryPersonList.get(0).length];

			while(!incidentSecPersonFiles.isEmpty()) {

				String currentPersonDataFile = incidentSecPersonFiles.remove();
				BufferedReader dataSecPersonReader = new BufferedReader(new FileReader(currentPersonDataFile));
				String currentLine = "";
				while((currentLine=dataSecPersonReader.readLine())!=null) {
					if(currentLine.contains("Crash_ID")&&count>0) {
						count++;
						continue;
					}
					
					String dataString = "";
					Queue<String> tempSecItem = new LinkedList<String>();
					if(count==0) {
						String[] tempHeader = currentLine.split(",");
						for(int i=0;i<items.length;i++) {
							header[i] = dataPrimaryPersonList.get(0)[i];
							dataString += header[i]+",";
						}
						for(int i=0;i<tempHeader.length;i++) {
							tempSecItem.add(tempHeader[i]);
						}
						for(int i=0;i<header.length;i++) {
							if(header[i].equals(tempSecItem.peek())){
								secHeader[i] = tempSecItem.remove();
							}else {
								secHeader[i] = "-1";
							}
						}

					}else {
						String[] currentData = currentLine.split(",");
						for(int i=0;i<currentData.length;i++) {
							tempSecItem.add(currentData[i]);
						}
						for(int i=0;i<secHeader.length;i++) {
							if(secHeader[i].equals("-1")) {
								dataString +="-1,";
							}else {
								dataString +=tempSecItem.remove()+",";
							}
						}
					}
					count++;
					dataSecPersonList.add(dataString.split(","));

				}

				dataSecPersonReader.close();
			}

			String filePeronsInvolved =  "Persons Involved - ELP Incidents 2014-2017.csv";
			File filePersons = new File(filePeronsInvolved);
			FileOutputStream fileOutPersons = new FileOutputStream(filePersons);
			BufferedWriter writerPersons = new BufferedWriter(new OutputStreamWriter(fileOutPersons));

			String headingNormalization = "//Users//danielmejia//Documents//Ph.D.//PersonHeadingNormalization.csv";
			BufferedReader headingReader = new BufferedReader(new FileReader(headingNormalization));
			String currentLine=headingReader.readLine();
			String[] headingLine = null;
			while((currentLine = headingReader.readLine())!=null) {
				headingLine = currentLine.split(",");
			}
			headingReader.close();
			for(int i=0;i<headingLine.length;i++) {
				writerPersons.write(headingLine[i]+",");
			}


			//Write Primary Persons
			writerPersons.write("\n");

			for(int i=1; i<dataPrimaryPersonList.size();i++) {
				for(int j=0;j<dataPrimaryPersonList.get(i).length;j++) {

					String currentData = dataPrimaryPersonList.get(i)[j];
					currentData = normalizeData(currentData);
					writerPersons.write(currentData +",");
				}
				writerPersons.write("\n");
			}

			//Write Secondary Persons
			for(int i=1; i<dataSecPersonList.size();i++) {
				for(int j=0;j<dataSecPersonList.get(i).length;j++) {

					String currentData = dataSecPersonList.get(i)[j];
					currentData = normalizeData(currentData);
					writerPersons.write(currentData +",");			
				}
				writerPersons.write("\n");
			}

			writerPersons.close();
			System.out.println("DONE");
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	public static String normalizeData(String data) {
		if(data.equals("N")) {
			return "0";
		}else if(data.equals("Y")) {
			return "1";
		}else if(data.equals("")) {
			return "-1";
		}else if(data.equals(" ")) {
			System.out.println("NULL");
		}
		return data;
	}
	public static String[] processInputString(String input) {
		String[] outputArray = new String[32];
		String[] temp = input.split(",");
		for(int i=0;i<outputArray.length;i++) {
			if(i<temp.length) {
				outputArray[i] = temp[i];
			}else {
				outputArray[i] = "-1";
			}

		}
		return outputArray;

	}
}
