package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.QueueSummary;

public class MapperQueueSummary {
	public static QueueSummary read(ObjectMapper mapper, String value) throws IOException {
		return mapper.readValue(value, QueueSummary.class);
	}
}
