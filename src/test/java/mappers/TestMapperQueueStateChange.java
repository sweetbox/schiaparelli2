package mappers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueStageChange;

public class TestMapperQueueStateChange {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"queueName\":\"ucapps1-queue1\",\"tenantId\":\"ucapps1\","
			+ "\"userId\":\"apruner1.ucapps\",\"queueInterface\":\"UCAPPS1-x1823\",\"timestamp\":1517432123450,"
			+ "\"id\":1212,\"state\":\"UNAVAILABLE\"}";

	@Test
	public void test () throws IOException {
		MapperQueueStageChange.read(objectMapper, testValue);
	}
}
