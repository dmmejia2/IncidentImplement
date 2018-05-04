package cs.utep.IncidentImplement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.github.jsonldjava.core.DocumentLoader;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

public class JSONParser {
	public static void main(String[] args) throws JsonGenerationException, IOException {
		System.out.println("TEST");


		

		// Open a valid json(-ld) input file
		InputStream inputStream = new FileInputStream("/Users/danielmejia/Documents/workspace/IncidentImplement/Incident-PersonFull.json");
		//BufferedReader reader = new BufferedReader(new FileReader("/Users/danielmejia/Documents/workspace/IncidentImplement/Incident-PersonFull.json"));
		// Read the file into an Object (The type of this object will be a List, Map, String, Boolean,
		// Number or null depending on the root object in the file).
		Object jsonObject = JsonUtils.fromInputStream(inputStream);
		//Object jsonObject = JsonUtils.fromReader(reader);
		// Create a context JSON map containing prefixes and definitions
		Map context = new HashMap();
		// Customise context...
		// Create an instance of JsonLdOptions with the standard JSON-LD options
		JsonLdOptions options = new JsonLdOptions();
		//options.
		//options.
		// Customise options...
		// Call whichever JSONLD function you want! (e.g. compact)
		Object expand = JsonLdProcessor.expand(jsonObject);
		//Object compact = JsonLdProcessor.expand(jsonObject, options);
		// Print out the result (or don't, it's your call!)
		System.out.println(JsonUtils.toPrettyString(expand));

		 

	}
}
