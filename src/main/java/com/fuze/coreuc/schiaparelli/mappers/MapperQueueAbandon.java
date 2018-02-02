package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.QueueAbandon;
import com.fuze.coreuc.schiaparelli.models.QueueLeave;

public class MapperQueueAbandon {
	public static QueueAbandon read(ObjectMapper mapper, String value) throws IOException {
		return mapper.readValue(value, QueueAbandon.class);
	}
}
