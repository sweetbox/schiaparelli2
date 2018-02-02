package mappers;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperUser;

public class TestMapperUser {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String testValue = "{\"user\" : {\n" + "    \"id\" : \"e21c5f00-3970-11e7-bb2f-fdb38c8a4fa7\",\n"
			+ "    \"identifiers\" : [ {\n" + "      \"identifier\" : \"dkus.ucapps\"\n" + "    }, {\n"
			+ "      \"identifier\" : \"dkus.ucapps@im.thinkingphones.com\"\n" + "    } ],\n"
			+ "    \"displayName\" : \"David Kus\",\n" + "    \"ldapId\" : \"dkus.ucapps\",\n"
			+ "    \"tenant\" : \"ucapps1\",\n" + "    \"groupId\" : 964,\n" + "    \"groupName\" : \"ucapps\",\n"
			+ "    \"preferredChannel\" : \"sip:UCAPPS1-x2600\",\n" + "    \"presence\" : \"Offline\",\n"
			+ "    \"details\" : { }\n" + "  }}";

	@Test
	public void test () throws IOException {
		JsonNode jsonNode = objectMapper.readTree(testValue);
		MapperUser.read(objectMapper, jsonNode.get("user"));
	}
}
