package mappers;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueSummary;

public class TestMapperQueueSummary {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"actionid\":\"378277428_2940#\",\"queue\":\"ucapps1-queue1\","
			+ "\"holdtime\":\"0\",\"loggedin\":\"3\",\"event\":\"QueueSummary\",\"callers\":\"0\","
			+ "\"queuePbx\":\"ucapps1\",\"dateReceived\":1517491333470,\"longestholdtime\":\"0\",\"available\":\"2\","
			+ "\"talktime\":\"0\"}";


	@Test
	public void test () throws IOException {
		MapperQueueSummary.read(objectMapper, testValue);
	}
}
