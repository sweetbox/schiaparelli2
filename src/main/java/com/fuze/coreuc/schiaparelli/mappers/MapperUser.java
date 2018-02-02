package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.User;

public class MapperUser {
	public static User read(ObjectMapper mapper, JsonNode node) throws IOException {
		return mapper.treeToValue(node, User.class);
	}
}
