package cs.utep.IncidentImplement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonldjava.utils.JsonUtils;


public class IncidentMapper {

	public static void main(String[] args) {
		final String numericalIncidents = "//Users//danielmejia//Documents//workspace//IncidentImplement//Complete Numeric - ELP Incidents 2014-2017.csv";
		final String personIncidents = "//Users//danielmejia//Documents//workspace//IncidentImplement//Persons Involved - ELP Incidents 2014-2017.csv";
		final String jsonFilePath = "//Users//danielmejia//Documents//workspace//IncidentImplement//";
		HashMap<Integer,Incident> incidentObjectHash=new HashMap<Integer,Incident>();  
		Queue<PersonObject> personList = new LinkedList<PersonObject>();
		try {

			BufferedReader incidentReader = new BufferedReader(new FileReader(numericalIncidents));

			String currentLine = incidentReader.readLine();
			//System.out.println(currentLine);
			String [] incidentFirstLine = currentLine.split(",");
			String [] items = null;
			ArrayList<String[]> incidentList = new ArrayList<String[]>();
			while((currentLine = incidentReader.readLine())!=null){
				//System.out.println(currentLine);
				items = currentLine.split(",");
				if(items.length>1) {
					incidentList.add(items);	
				}
			}
			incidentReader.close();


			for(int j=0;j<incidentList.size();j++) {
				Incident currentIncident = new Incident();
				for(int i=0;i<incidentFirstLine.length;i++) {
					String headingLine = incidentFirstLine[i];

					switch(headingLine) {
					case "Crash ID":
						//System.out.println(incidentList.get(j)[i]);
						currentIncident.setCrashID(incidentList.get(j)[i].replaceAll(" ", ""));
						break;
					case "isFatal":
						//System.out.println(incidentList.get(j)[i]);
						currentIncident.setIsFatal(incidentList.get(j)[i]);
						break;
					case "isCMV":
						currentIncident.setIsCMV(incidentList.get(j)[i]);
						break;
					case "isSchoolBus":
						currentIncident.setIsSchoolBus(incidentList.get(j)[i]);
						break;
					case "isRailroad":
						currentIncident.setIsRailroad(incidentList.get(j)[i]);
						break;
					case "isSchoolZone":
						currentIncident.setIsSchoolZone(incidentList.get(j)[i]);
						break;
					case "Crash Date":
						currentIncident.setCrashDate(incidentList.get(j)[i]);
						break;
					case "Crash Time":
						currentIncident.setCrashTime(incidentList.get(j)[i]);
						break;
					case "County Code":
						currentIncident.setCountyCode(incidentList.get(j)[i]);
						break;
					case "City Code":
						currentIncident.setCityCode(incidentList.get(j)[i]);
						break;
					case "isOutsideCityLimit":
						currentIncident.setIsOutsideCityLimit(incidentList.get(j)[i]);
						break;
					case "isThousandDamage":
						currentIncident.setIsThousandDamage(incidentList.get(j)[i]);
						break;
					case "Primary Roadway ID":
						currentIncident.setPrimaryRoadwayID(incidentList.get(j)[i]);
						break;
					case "Highway Number":
						currentIncident.setHighwayNumber(incidentList.get(j)[i]);
						break;
					case "Primary Road Part ID":
						currentIncident.setPrimaryRoadPartID(incidentList.get(j)[i]);
						break;
					case "Road Block Number":
						currentIncident.setRoadBlockNumber(incidentList.get(j)[i]);
						break;
					case "Primary Street":
						currentIncident.setPrimaryStreet(incidentList.get(j)[i]);
						break;
					case "isTollRoad":
						currentIncident.setIsTollRoad(incidentList.get(j)[i]);
						break;
					case "Location Speed Limit":
						currentIncident.setLocationSpeedLimit(incidentList.get(j)[i]);
						break;
					case "isConstruction":
						currentIncident.setIsConstruction(incidentList.get(j)[i]);
						break;
					case "isConstructionWorker":
						currentIncident.setIsConstructionWorker(incidentList.get(j)[i]);
						break;
					case "isIntersection":
						currentIncident.setIsIntersection(incidentList.get(j)[i]);
						break;
					case "Sec Roadway ID":
						currentIncident.setSecRoadwayID(incidentList.get(j)[i]);
						break;
					case "Sec Highway Number":
						currentIncident.setSecHighwayNumber(incidentList.get(j)[i]);
						break;
					case "Sec Road Part ID":
						currentIncident.setSecRoadPartID(incidentList.get(j)[i]);
						break;
					case "Sec Block Number":
						currentIncident.setSecBlockNumber(incidentList.get(j)[i]);
						break;
					case "Sec Street Name":
						currentIncident.setSecStreetName(incidentList.get(j)[i]);
						break;
					case "Weather Condition":
						currentIncident.setWeatherCondition(incidentList.get(j)[i]);
						break;
					case "Light Condition":
						currentIncident.setLightCondition(incidentList.get(j)[i]);
						break;
					case "Road Entrance ID":
						currentIncident.setRoadEntranceID(incidentList.get(j)[i]);
						break;
					case "Road Type ID":
						currentIncident.setRoadTypeID(incidentList.get(j)[i]);
						break;
					case "Surface Condition ID":
						currentIncident.setSurfaceConditionID(incidentList.get(j)[i]);
						break;
					case "Traffic Control ID":
						currentIncident.setTrafficControlID(incidentList.get(j)[i]);
						break;
					case "Notification Time":
						currentIncident.setNotificationTime(incidentList.get(j)[i]);
						break;
					case "Notification Arrival":
						currentIncident.setArrivalTime(incidentList.get(j)[i]);
						break;
					case "Report Date":
						currentIncident.setReportDate(incidentList.get(j)[i]);
						break;
					case "Bridge ID":
						currentIncident.setBridgeID(incidentList.get(j)[i]);
						break;
					case "Harmful Event":
						currentIncident.setHarmfulEvent(incidentList.get(j)[i]);
						break;
					case "Intersection ID":
						currentIncident.setIntersectionID(incidentList.get(j)[i]);
						break;
					case "First Harmful Event":
						currentIncident.setFirstHarmfulEvent(incidentList.get(j)[i]);
						break;
					case "Object Struck ID":
						currentIncident.setObjectStruckID(incidentList.get(j)[i]);
						break;
					case "Other Factor":
						currentIncident.setOtherFactor(incidentList.get(j)[i]);
						break;
					case "Road Closure ID":
						currentIncident.setRoadClosureID(incidentList.get(j)[i]);
						break;
					case "Road Relation":
						currentIncident.setRoadRelation(incidentList.get(j)[i]);
						break;
					case "Physical Feature 1 ID":
						currentIncident.setPhysicalFeatureOneID(incidentList.get(j)[i]);
						break;
					case "Physical Feature 2 ID":
						currentIncident.setPhysicalFeatureTwoID(incidentList.get(j)[i]);
						break;
					case "County ID":
						currentIncident.setCountyID(incidentList.get(j)[i]);
						break;
					case "City ID":
						currentIncident.setCityID(incidentList.get(j)[i]);
						break;
					case "Latitude":
						currentIncident.setLatitude(incidentList.get(j)[i]);
						break;
					case "Longitude":
						currentIncident.setLongitude(incidentList.get(j)[i]);
						break;
					case "isRural":
						currentIncident.setIsRural(incidentList.get(j)[i]);
						break;
					case "Crash Severity ID":
						currentIncident.setCrashSeverity(incidentList.get(j)[i]);
						break;
					case "Population Group":
						currentIncident.setPopulationGroup(incidentList.get(j)[i]);
						break;
					case "isLocated":
						currentIncident.setIsLocated(incidentList.get(j)[i]);
						break;
					case "Day of Week":
						currentIncident.setDayOfWeek(incidentList.get(j)[i]);
						break;
					case "Surface Type":
						currentIncident.setSurfaceType(incidentList.get(j)[i]);
						break;
					case "Serious Injury Count":
						currentIncident.setSeriousInjury(incidentList.get(j)[i]);
						break;
					case "Nonincapacitating Injury Count":
						currentIncident.setNonIncapacitatingInjury(incidentList.get(j)[i]);
						break;
					case "Possible Injury Count":
						currentIncident.setPossibleInjury(incidentList.get(j)[i]);
						break;
					case "Non Injury Count":
						currentIncident.setNonInjury(incidentList.get(j)[i]);
						break;
					case "Unknown Injury Count":
						currentIncident.setUnknownInjury(incidentList.get(j)[i]);
						break;
					case "Total Injury Count":
						currentIncident.setTotalInjury(incidentList.get(j)[i]);
						break;
					case "Death Count":
						currentIncident.setDeathCount(incidentList.get(j)[i]);
						break;
					default:
						System.out.println(headingLine);
						break;
					}


				}
				int incidentKey = Integer.parseInt(currentIncident.getCrashID());
				incidentObjectHash.put(incidentKey, currentIncident);

			}
			//System.out.println(incidentObjectHash.get(14213817).getCrashDate());



		}catch(Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}



		try {


			BufferedReader personReader = new BufferedReader(new FileReader(personIncidents));

			String currentLine = personReader.readLine();
			//System.out.println(currentLine);
			String [] personFirstLine = currentLine.split(",");
			String [] items = null;
			ArrayList<String[]> fullPersonList = new ArrayList<String[]>();
			while((currentLine = personReader.readLine())!=null){
				//System.out.println(currentLine);
				items = currentLine.split(",");
				if(items.length>1) {
					fullPersonList.add(items);	
				}

			}
			personReader.close();


			for(int j=0;j<fullPersonList.size();j++) {
				PersonObject currentPerson = new PersonObject();
				for(int i=0;i<personFirstLine.length;i++) {
					String headingLine = personFirstLine[i];
					switch(headingLine) {
					case "Crash ID":
						currentPerson.setCrashID(fullPersonList.get(j)[i]);
						break;
					case "Unit Number":
						currentPerson.setUnitNumber(fullPersonList.get(j)[i]);
						break;
					case "Person Number":
						currentPerson.setPersonNumber(fullPersonList.get(j)[i]);
						break;
					case "Person Type ID":
						currentPerson.setPersonType(fullPersonList.get(j)[i]);
						break;
					case "Person Occupant Position":
						currentPerson.setPersonPosition(fullPersonList.get(j)[i]);
						break;
					case "Person Injury Severity":
						currentPerson.setPersonInjury(fullPersonList.get(j)[i]);
						break;
					case "Person Age":
						currentPerson.setPersonAge(fullPersonList.get(j)[i]);
						break;
					case "Person Ethnicity":
						currentPerson.setPersonEthnicity(fullPersonList.get(j)[i]);
						break;
					case "Person Gender":
						currentPerson.setPersonGender(fullPersonList.get(j)[i]);
						break;
					case "Person Ejected ID":
						currentPerson.setPersonEjectID(fullPersonList.get(j)[i]);
						break;
					case "Person Restrained ID":
						currentPerson.setPersonRestraintID(fullPersonList.get(j)[i]);
						break;
					case "Person Airbag ID":
						currentPerson.setPersonAirbag(fullPersonList.get(j)[i]);
						break;
					case "Person Helmet ID":
						currentPerson.setPersonHelmet(fullPersonList.get(j)[i]);
						break;
					case "Person Sol Flag":
						currentPerson.setPersonSol(fullPersonList.get(j)[i]);
						break;
					case "Person Alcohol Speciman Type":
						currentPerson.setPersonAlcoholSpecID(fullPersonList.get(j)[i]);
						break;
					case "Person Alcohol Result ID":
						currentPerson.setPersonAlcoholResult(fullPersonList.get(j)[i]);
						break;
					case "Person BAC Test Result":
						currentPerson.setPersonBAC(fullPersonList.get(j)[i]);
						break;
					case "Person Drug Speciman Type ID":
						currentPerson.setPersonDrugSpecID(fullPersonList.get(j)[i]);
						break;
					case "Person Drug Result":
						currentPerson.setPersonDrugResult(fullPersonList.get(j)[i]);
						break;
					case "Driver Drug Category 1":
						currentPerson.setDriverDrugCategoryOne(fullPersonList.get(j)[i]);
						break;
					case "Time of Death":
						currentPerson.setPersonDeath(fullPersonList.get(j)[i]);
						break;
					case "Serious Injury":
						currentPerson.setSeriousInjury(fullPersonList.get(j)[i]);
						break;
					case "Nonincapacitating Injury":
						currentPerson.setNonincapacitatingInjury(fullPersonList.get(j)[i]);
						break;
					case "Possible Injury":
						currentPerson.setPossibleInjury(fullPersonList.get(j)[i]);
						break;
					case "Non Injury":
						currentPerson.setNonInjury(fullPersonList.get(j)[i]);
						break;
					case "Unknown Injury":
						currentPerson.setUnknownInjury(fullPersonList.get(j)[i]);
						break;
					case "Total Injury Count":
						currentPerson.setTotalInjury(fullPersonList.get(j)[i]);
						break;
					case "Death Count":
						currentPerson.setDeathCount(fullPersonList.get(j)[i]);
						break;
					case "Driver License Type":
						currentPerson.setDriversLicenseType(fullPersonList.get(j)[i]);
						break;
					case "Driver License State ID":
						currentPerson.setDriversLicenseState(fullPersonList.get(j)[i]);
						break;
					case "Driver License Class":
						currentPerson.setDriversLicenseClass(fullPersonList.get(j)[i]);
						break;
					case "Driver Zip":
						currentPerson.setDriverZipCode(fullPersonList.get(j)[i]);
						break;

					default:
						System.out.println(headingLine);
						break;
					}
				}
				personList.add(currentPerson);
			}

		}catch(Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		int count = 0;
		while(!personList.isEmpty()) {
			PersonObject tempPerson = personList.remove();
			int personCrashID = Integer.parseInt(tempPerson.getCrashID());
			incidentObjectHash.get(personCrashID).addPersonsInvolved(tempPerson);

			//System.out.println(count+"     "+personCrashID+"   "+incidentObjectHash.get(personCrashID).getCrashDate());
			count++;
			//System.out.println(incidentObjectHash.get(14213817).getCrashDate());

		}

		try {
			String jsonFileName = "Incident-PersonFull.json";


			File jsonFile = new File(jsonFileName);
			FileOutputStream fileOutJSON = new FileOutputStream(jsonFile);
			BufferedWriter jsonWriter = new BufferedWriter(new OutputStreamWriter(fileOutJSON));

			ObjectMapper mapper = new ObjectMapper();
			jsonWriter.write("[");
			for(Map.Entry<Integer, Incident> entry : incidentObjectHash.entrySet()) {
				int key = entry.getKey();
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(incidentObjectHash.get(key));
				jsonWriter.write(json +",");

				//System.out.println("JSON = " + json);
				//Incident value = entry.getValue();
				//System.out.println(key);
				//System.out.println(value.getCrashID());

			}
			jsonWriter.write("]");
			String fullJsonFilePath = jsonFilePath+jsonFileName;
			System.out.println(fullJsonFilePath);
			jsonWriter.close();
	}catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		System.out.println("DONE");
		System.out.println("FINISHED");

	}

}
