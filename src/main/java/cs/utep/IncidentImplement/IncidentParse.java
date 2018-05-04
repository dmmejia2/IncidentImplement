package cs.utep.IncidentImplement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IncidentParse {

	public static void main(String[] args) {
		Queue <String> modifiedIncidentFile = new LinkedList<String>();
		final String rawDataPrefix= "//Users//danielmejia//Documents//Ph.D.//Incident Data//";
		final String modifiedDataPrefix = "//Users//danielmejia//Documents//workspace//IncidentImplement//";
		try {
			String removeColumnFile = "//Users//danielmejia//Documents//Ph.D.//CrashRemoveColumns.csv";
			String dataFile14 = rawDataPrefix + "ELP Incidents 2014//ELP Public Incidents 2014 Crash.csv";
			String dataFile15 = rawDataPrefix + "ELP Incidents 2015//ELP Public Incidents 2015 Crash.csv";
			String dataFile16 = rawDataPrefix + "ELP Incidents 2016//ELP Public Incidents 2016 Crash.csv";
			String dataFile17 = rawDataPrefix + "ELP Incidents 2017//ELP Public Incidents 2017 Crash.csv";
			Queue<String> incidentFiles = new LinkedList<String>();
			incidentFiles.add(dataFile14);
			incidentFiles.add(dataFile15);
			incidentFiles.add(dataFile16);
			incidentFiles.add(dataFile17);
			int currentYear =2014;
			while(!incidentFiles.isEmpty()) {

				BufferedReader removeReader = new BufferedReader(new FileReader(removeColumnFile));

				String currentDataFile = incidentFiles.remove();
				BufferedReader dataReader = new BufferedReader(new FileReader(currentDataFile));
				String currentLine;
				String [] deleteColumnValues = null;
				while((currentLine = removeReader.readLine())!=null){
					deleteColumnValues = currentLine.split(",");			
				}
				removeReader.close();

				List<Integer> deleteIndex = new ArrayList<Integer>();
				int count=0;
				String [] dataItems = null;
				List<String> updatedData = new ArrayList<String>();
				while((currentLine = dataReader.readLine())!=null) {
					dataItems = currentLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
					if(count==0) {
						for(int i=0; i<dataItems.length;i++) {
							for(int j=0;j<deleteColumnValues.length;j++) {
								if(dataItems[i].equals(deleteColumnValues[j])) {
									deleteIndex.add(i);
									break;
								}
							}
						}
					}
					String updatedDataLine="";
					int i=0;
					while(i<dataItems.length)	{
						for(int j=0;j<deleteIndex.size();j++) {
							if(i==deleteIndex.get(j)) {
								i++;
							}
						}
						if(i<dataItems.length && i!=dataItems.length) {
							updatedDataLine += dataItems[i];
							updatedDataLine += ",";
						}
						i++;

					}
					updatedData.add(updatedDataLine);
					count++;
				}
				dataReader.close();


				String fileName = "Modified - ELP Incidents " + Integer.toString(currentYear) + ".csv";

				File file = new File(fileName);
				FileOutputStream fileOutStream = new FileOutputStream(file);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutStream));
				for(int i=0;i<updatedData.size();i++) {
					//System.out.println(updatedData.get(i));
					writer.write(updatedData.get(i).toString());
					writer.write("\n ");
				}
				writer.close();
				modifiedIncidentFile.add(fileName);
				System.out.println("SIZE: "+updatedData.size());
				System.out.println(fileName);
				System.out.println("");
				currentYear++;
			}

			System.out.println("DONE");
		}catch(Exception e) {}

		int fileNumber=0;
		ArrayList<String[]> completeModifiedData = new ArrayList<String[]>();
		while(!modifiedIncidentFile.isEmpty()) {
			String modifiedDataFile = modifiedDataPrefix + modifiedIncidentFile.remove();
			System.out.println(modifiedDataFile);
			try {
				BufferedReader modifiedDataReader = new BufferedReader(new FileReader(modifiedDataFile));
				String currentLine;
				String [] modifiedItems = null;
				if(fileNumber!=0) {
					modifiedDataReader.readLine();
				}

				while((currentLine = modifiedDataReader.readLine())!=null){


					modifiedItems = currentLine.split(",");
					if(modifiedItems.length<2) {
						continue;
					}else {
						completeModifiedData.add(modifiedItems);
					}
				}
				modifiedDataReader.close();
				fileNumber++;
			}catch(Exception e) {}
		}


		try {
			String headingNormalization = "//Users//danielmejia//Documents//Ph.D.//IncidentHeadingNormalization.csv";
			BufferedReader headingReader = new BufferedReader(new FileReader(headingNormalization));
			String currentLine="";
			ArrayList<String[]> headingList = new ArrayList<String[]>();
			while((currentLine = headingReader.readLine())!=null) {
				headingList.add(currentLine.split(","));
			}
			headingReader.close();
			String fileName = "Complete - ELP Incidents 2014-2017.csv";

			File file = new File(fileName);
			FileOutputStream fileOutStream = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutStream));


			String fileNameNumeric = "Complete Numeric - ELP Incidents 2014-2017.csv";

			File fileNumeric = new File(fileNameNumeric);
			FileOutputStream fileOutStreamNumeric = new FileOutputStream(fileNumeric);
			BufferedWriter writerNumeric = new BufferedWriter(new OutputStreamWriter(fileOutStreamNumeric));

			for(int i=0;i<completeModifiedData.size();i++) {
				for(int j=0;j<completeModifiedData.get(i).length;j++) {
					String currentValue = completeModifiedData.get(i)[j];
					if(i==0) {
						for(int k=0;k<headingList.get(0).length;k++) {
							if(headingList.get(0)[k].equals(currentValue)){
								currentValue = headingList.get(1)[k];
								break;
							}
						}
					}
					if(currentValue.equals("SUN")) {
						currentValue = "0";
					}else if(currentValue.equals("MON")) {
						currentValue = "1";
					}else if(currentValue.equals("TUE")) {
						currentValue = "2";
					}else if(currentValue.equals("WED")) {
						currentValue = "3";
					}else if(currentValue.equals("THU")) {
						currentValue = "4";
					}else if(currentValue.equals("FRI")) {
						currentValue = "5";
					}else if(currentValue.equals("SAT")) {
						currentValue = "6";
					}


					writer.write(currentValue+",");

					if(currentValue.contains(":")&&!currentValue.contains("MM:")) {
						currentValue = parseTime(currentValue);
					}
					if(currentValue.equals("N")) {
						writerNumeric.write("0,");
					}else if(currentValue.equals("Y")) {
						writerNumeric.write("1,");
					}else {
						writerNumeric.write(currentValue+",");
					}
				}
				//System.out.println("");
				writer.write("\n ");
				writerNumeric.write("\n");
			}
			System.out.println("COMPLETE");
			writer.close();
			writerNumeric.close();

		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}







	}

	public static String parseTime(String time) {
		//System.out.println(time);
		String[] currentTime = time.split(":");
		String[] partOfDay = currentTime[1].split(" ");
		int parsedHour = Integer.parseInt(currentTime[0]);
		String updatedHour="";

		//System.out.println(partOfDay[0]);
		if(partOfDay[1].equals("PM")&&parsedHour!=12) {
			parsedHour +=12;
			updatedHour = Integer.toString(parsedHour);
		}else {
			if(parsedHour<10) {
				updatedHour = "0"+Integer.toString(parsedHour);
			}else {
				updatedHour = Integer.toString(parsedHour);
			}
		}
		String updatedTime = updatedHour+":"+partOfDay[0];
		return updatedTime;

	}

}
