package Symbol.Excuses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import Symbol.Excuses.entity.Excuse;

public class ReadJsonFile {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static void getExcusesFromJson() {
		try {
			InputStream inputStream = new FileInputStream(new File("src/main/resources/data/data.json"));
			try {
				Excuse excuse = objectMapper.readValue(inputStream, Excuse.class);
				System.out.println(excuse);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}