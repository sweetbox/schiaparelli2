package mappers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueJoin;

public class TestMapperQueueJoin {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"queueName\":\"ucapps1-queue1\",\"count\":1,"
			+ "\"uniqueId\":\"vad-z1-call2-1517516225.233641\",\"linkedId\":\"vad-z1-call2-1517516225.233641\","
			+ "\"action\":\"JOIN\",\"position\":1,\"calleridname\":\"David Kus\",\"calleridnum\":\"+16135192600\","
			+ "\"hostname\":\"vad-z1-call2\",\"timestamp\":1517516230703}";

	@Test
	public void test () throws IOException {
		MapperQueueJoin.read(objectMapper, testValue);
	}
}
