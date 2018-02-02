package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;

public class MapperQueueStatus {
	public static QueueStatus read(ObjectMapper mapper, String value) throws IOException {
		return mapper.readValue(value, QueueStatus.class);
	}
}
