package cs.utep.IncidentImplement;

import java.util.ArrayList;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;


public class Incident {

	private String crashID;
	
	private String isFatal;
	private String isCMV;
	private String isSchoolBus;
	private String isRailroad;
	private String isSchoolZone;
	private String crashDate;
	private String crashTime;
	private String countyCode;
	private String cityCode;
	private String isOutsideCityLimit;
	private String isThousandDamage;
	private String primaryRoadwayID;
	private String highwayNumber;
	private String primaryRoadPartID;
	private String roadBlockNumber;
	private String primaryStreet;
	private String isTollRoad;
	private String locationSpeedLimit;
	private String isConstruction;
	private String isConstructionWorker;
	private String isIntersection;
	private String secRoadwayID;
	private String secHighwayNumber;
	private String secRoadPartID;
	private String secBlockNumber;
	private String secStreetName;
	private String weatherCondition;
	private String lightCondition;
	private String roadEntranceID;
	private String roadTypeID;
	private String surfaceConditionID;
	private String trafficControlID;
	private String notificationTime;
	private String arrivalTime;
	private String reportDate;
	private String bridgeID;
	private String harmfulEvent;
	private String intersectionID;
	private String firstHarmfulEvent;
	private String objectStruckID;
	private String otherFactor;
	private String roadClosureID;
	private String roadRelation;
	private String physicalFeatureOneID;
	private String physicalFeatureTwoID;
	private String countyID;
	private String cityID;
	private String latitude;
	private String longitude;
	private String isRural;
	private String crashSeverity;
	private String populationGroup;
	private String isLocated;
	private String dayOfWeek;
	private String surfaceType;
	private String seriousInjury;
	private String nonIncapacitatingInjury;
	private String possibleInjury;
	private String nonInjury;
	private String unknownInjury;
	private String totalInjury;
	private String deathCount;
	private ArrayList<PersonObject> personsInvolved = new ArrayList<PersonObject>();
	
	
	
	public String getRoadTypeID() {
		return roadTypeID;
	}
	public void setRoadTypeID(String roadTypeID) {
		this.roadTypeID = roadTypeID;
	}
	//Getters
	public String getCrashID() {
		return crashID;
	}
	public String getIsFatal() {
		return isFatal;
	}
	public String getIsCMV() {
		return isCMV;
	}
	public String getIsSchoolBus() {
		return isSchoolBus;
	}
	public String getIsRailroad() {
		return isRailroad;
	}
	public String getIsSchoolZone() {
		return isSchoolZone;
	}
	public String getCrashDate() {
		return crashDate;
	}
	public String getCrashTime() {
		return crashTime;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public String getIsOutsideCityLimit() {
		return isOutsideCityLimit;
	}
	public String getIsThousandDamage() {
		return isThousandDamage;
	}
	public String getPrimaryRoadwayID() {
		return primaryRoadwayID;
	}
	public String getHighwayNumber() {
		return highwayNumber;
	}
	public String getPrimaryRoadPartID() {
		return primaryRoadPartID;
	}
	public String getRoadBlockNumber() {
		return roadBlockNumber;
	}
	public String getPrimaryStreet() {
		return primaryStreet;
	}
	public String getIsTollRoad() {
		return isTollRoad;
	}
	public String getLocationSpeedLimit() {
		return locationSpeedLimit;
	}
	public String getIsConstruction() {
		return isConstruction;
	}
	public String getIsConstructionWorker() {
		return isConstructionWorker;
	}
	public String getIsIntersection() {
		return isIntersection;
	}
	public String getSecRoadwayID() {
		return secRoadwayID;
	}
	public String getSecHighwayNumber() {
		return secHighwayNumber;
	}
	public String getSecRoadPartID() {
		return secRoadPartID;
	}
	public String getSecBlockNumber() {
		return secBlockNumber;
	}
	public String getSecStreetName() {
		return secStreetName;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public String getLightCondition() {
		return lightCondition;
	}
	public String getRoadEntranceID() {
		return roadEntranceID;
	}
	public String getSurfaceConditionID() {
		return surfaceConditionID;
	}
	public String getTrafficControlID() {
		return trafficControlID;
	}
	public String getNotificationTime() {
		return notificationTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public String getReportDate() {
		return reportDate;
	}
	public String getBridgeID() {
		return bridgeID;
	}
	public String getHarmfulEvent() {
		return harmfulEvent;
	}
	public String getIntersectionID() {
		return intersectionID;
	}
	public String getFirstHarmfulEvent() {
		return firstHarmfulEvent;
	}
	public String getObjectStruckID() {
		return objectStruckID;
	}
	public String getOtherFactor() {
		return otherFactor;
	}
	public String getRoadClosureID() {
		return roadClosureID;
	}
	public String getRoadRelation() {
		return roadRelation;
	}
	public String getPhysicalFeatureOneID() {
		return physicalFeatureOneID;
	}
	public String getPhysicalFeatureTwoID() {
		return physicalFeatureTwoID;
	}
	public String getCountyID() {
		return countyID;
	}
	public String getCityID() {
		return cityID;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public String getIsRural() {
		return isRural;
	}
	public String getCrashSeverity() {
		return crashSeverity;
	}
	public String getPopulationGroup() {
		return populationGroup;
	}
	public String getIsLocated() {
		return isLocated;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public String getSurfaceType() {
		return surfaceType;
	}
	public String getSeriousInjury() {
		return seriousInjury;
	}
	public String getNonIncapacitatingInjury() {
		return nonIncapacitatingInjury;
	}
	public String getPossibleInjury() {
		return possibleInjury;
	}
	public String getNonInjury() {
		return nonInjury;
	}
	public String getUnknownInjury() {
		return unknownInjury;
	}
	public String getTotalInjury() {
		return totalInjury;
	}
	public String getDeathCount() {
		return deathCount;
	}
	
	
	//Setters
	public void setCrashID(String crashID) {
		this.crashID = crashID;
	}
	public void setIsFatal(String isFatal) {
		this.isFatal = isFatal;
	}
	public void setIsCMV(String isCMV) {
		this.isCMV = isCMV;
	}
	public void setIsSchoolBus(String isSchoolBus) {
		this.isSchoolBus = isSchoolBus;
	}
	public void setIsRailroad(String isRailroad) {
		this.isRailroad = isRailroad;
	}
	public void setIsSchoolZone(String isSchoolZone) {
		this.isSchoolZone = isSchoolZone;
	}
	public void setCrashDate(String crashDate) {
		this.crashDate = crashDate;
	}
	public void setCrashTime(String crashTime) {
		this.crashTime = crashTime;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public void setIsOutsideCityLimit(String isOutsideCityLimit) {
		this.isOutsideCityLimit = isOutsideCityLimit;
	}
	public void setIsThousandDamage(String isThousandDamage) {
		this.isThousandDamage = isThousandDamage;
	}
	public void setPrimaryRoadwayID(String primaryRoadwayID) {
		this.primaryRoadwayID = primaryRoadwayID;
	}
	public void setHighwayNumber(String highwayNumber) {
		this.highwayNumber = highwayNumber;
	}
	public void setPrimaryRoadPartID(String primaryRoadPartID) {
		this.primaryRoadPartID = primaryRoadPartID;
	}
	public void setRoadBlockNumber(String roadBlockNumber) {
		this.roadBlockNumber = roadBlockNumber;
	}
	public void setPrimaryStreet(String primaryStreet) {
		this.primaryStreet = primaryStreet;
	}
	public void setIsTollRoad(String isTollRoad) {
		this.isTollRoad = isTollRoad;
	}
	public void setLocationSpeedLimit(String locationSpeedLimit) {
		this.locationSpeedLimit = locationSpeedLimit;
	}
	public void setIsConstruction(String isConstruction) {
		this.isConstruction = isConstruction;
	}
	public void setIsConstructionWorker(String isConstructionWorker) {
		this.isConstructionWorker = isConstructionWorker;
	}
	public void setIsIntersection(String isIntersection) {
		this.isIntersection = isIntersection;
	}
	public void setSecRoadwayID(String secRoadwayID) {
		this.secRoadwayID = secRoadwayID;
	}
	public void setSecHighwayNumber(String secHighwayNumber) {
		this.secHighwayNumber = secHighwayNumber;
	}
	public void setSecRoadPartID(String secRoadPartID) {
		this.secRoadPartID = secRoadPartID;
	}
	public void setSecBlockNumber(String secBlockNumber) {
		this.secBlockNumber = secBlockNumber;
	}
	public void setSecStreetName(String secStreetName) {
		this.secStreetName = secStreetName;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public void setLightCondition(String lightCondition) {
		this.lightCondition = lightCondition;
	}
	public void setRoadEntranceID(String roadEntranceID) {
		this.roadEntranceID = roadEntranceID;
	}
	public void setSurfaceConditionID(String surfaceConditionID) {
		this.surfaceConditionID = surfaceConditionID;
	}
	public void setTrafficControlID(String trafficControlID) {
		this.trafficControlID = trafficControlID;
	}
	public void setNotificationTime(String notificationTime) {
		this.notificationTime = notificationTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public void setBridgeID(String bridgeID) {
		this.bridgeID = bridgeID;
	}
	public void setHarmfulEvent(String harmfulEvent) {
		this.harmfulEvent = harmfulEvent;
	}
	public void setIntersectionID (String IntersectionID) {
		this.intersectionID = IntersectionID;
	}
	public void setFirstHarmfulEvent(String firstHarmfulEvent) {
		this.firstHarmfulEvent = firstHarmfulEvent;
	}
	public void setObjectStruckID(String objectStruckID) {
		this.objectStruckID = objectStruckID;
	}
	public void setOtherFactor(String otherFactor) {
		this.otherFactor = otherFactor;
	}
	public void setRoadClosureID(String roadClosureID) {
		this.roadClosureID = roadClosureID;
	}
	public void setRoadRelation(String roadRelation) {
		this.roadRelation = roadRelation;
	}
	public void setPhysicalFeatureOneID(String physicalFeatureOneID) {
		this.physicalFeatureOneID = physicalFeatureOneID;
	}
	public void setPhysicalFeatureTwoID(String physicalFeatureTwoID) {
		this.physicalFeatureTwoID = physicalFeatureTwoID;
	}
	public void setCountyID(String countyID) {
		this.countyID = countyID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setIsRural(String isRural) {
		this.isRural = isRural;
	}
	public void setCrashSeverity(String crashSeverity) {
		this.crashSeverity = crashSeverity;
	}
	public void setPopulationGroup(String populationGroup) {
		this.populationGroup = populationGroup;
	}
	public void setIsLocated(String isLocated) {
		this.isLocated = isLocated;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}
	public void setSeriousInjury(String seriousInjury) {
		this.seriousInjury = seriousInjury;
	}
	public void setNonIncapacitatingInjury(String nonIncapacitatingInjury) {
		this.nonIncapacitatingInjury = nonIncapacitatingInjury;
	}
	public void setPossibleInjury(String possibleInjury) {
		this.possibleInjury = possibleInjury;
	}
	public void setNonInjury(String nonInjury) {
		this.nonInjury = nonInjury;
	}
	public void setUnknownInjury(String unknownInjury) {
		this.unknownInjury = unknownInjury;
	}
	public void setTotalInjury(String totalInjury) {
		this.totalInjury = totalInjury;
	}
	public void setDeathCount(String deathCount) {
		this.deathCount = deathCount;
	}
	public ArrayList<PersonObject> getPersonsInvolved() {
		return personsInvolved;
	}
	public void addPersonsInvolved(PersonObject personsInvolved) {
		this.personsInvolved.add(personsInvolved);
	}
	
	
	
}
