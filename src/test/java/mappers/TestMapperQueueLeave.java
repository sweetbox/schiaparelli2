package mappers;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueLeave;

public class TestMapperQueueLeave {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"queueName\":\"ucapps1-queue1\",\"count\":0,"
			+ "\"uniqueId\":\"vad-z1-call2-1517515735.233575\",\"linkedId\":\"vad-z1-call2-1517515735.233575\","
			+ "\"action\":\"LEAVE\",\"position\":1,\"hostname\":\"vad-z1-call2\",\"timestamp\":1517515956518}";

	@Test
	public void test () throws IOException {
		MapperQueueLeave.read(objectMapper, testValue);
	}
}
