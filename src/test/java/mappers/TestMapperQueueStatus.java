package mappers;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperQueueStatus;

public class TestMapperQueueStatus {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"tenantId\":\"ucapps1\",\"numCompleted\":0,\"weight\":0,\"serviceLevelPerf\":0.0,"
			+ "\"maxWaiting\":0,\"numAbandoned\":0,\"queuePbx\":\"ucapps1\",\"serviceLevel\":0,\"avgHoldTime\":0,"
			+ "\"name\":\"ucapps1-queue1\",\"callsWaiting\":0,\"members\":[{\"name\":\"SIP/UCAPPS1-m1823-1\","
			+ "\"location\":\"Local/UCAPPS1-m1823-1@dial-agent/nb\",\"membership\":\"dynamic\",\"penalty\":0,"
			+ "\"callsTaken\":0,\"lastCall\":0,\"paused\":true,\"status\":1,\"queue\":\"ucapps1-queue1\","
			+ "\"locationType\":\"Local\"},{\"name\":\"SIP/UCAPPS1-m2600-1\","
			+ "\"location\":\"Local/UCAPPS1-m2600-1@dial-agent/nb\",\"membership\":\"dynamic\",\"penalty\":0,"
			+ "\"callsTaken\":0,\"lastCall\":0,\"paused\":false,\"status\":1,\"queue\":\"ucapps1-queue1\","
			+ "\"locationType\":\"Local\"},{\"name\":\"SIP/UCAPPS1-x1823\","
			+ "\"location\":\"Local/UCAPPS1-x1823@dial-agent/nb\",\"membership\":\"dynamic\",\"penalty\":0,"
			+ "\"callsTaken\":0,\"lastCall\":0,\"paused\":false,\"status\":1,\"queue\":\"ucapps1-queue1\","
			+ "\"locationType\":\"Local\"}]}";


	@Test
	public void test () throws IOException {
		MapperQueueStatus.read(objectMapper, testValue);
	}
}
