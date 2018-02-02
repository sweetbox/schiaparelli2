package mappers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueAbandon;

public class TestMapperQueueAbandon {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"queueName\":\"ucapps1-queue1\","
			+ "\"uniqueId\":\"vad-z1-call2-1517515735.233575\",\"action\":\"ABANDON\",\"position\":1,\"holdtime\":215,"
			+ "\"originalPosition\":1,\"hostname\":\"vad-z1-call2\",\"timestamp\":1517515956517}";

	@Test
	public void test () throws IOException {
		MapperQueueAbandon.read(objectMapper, testValue);
	}
}
