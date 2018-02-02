package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.QueueJoin;

public class MapperQueueJoin {
	public static QueueJoin read(ObjectMapper mapper, String value) throws IOException {
		return mapper.readValue(value, QueueJoin.class);
	}
}
