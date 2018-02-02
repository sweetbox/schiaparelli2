package com.fuze.coreuc.schiaparelli.mappers;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.StateChange;

public class MapperQueueStageChange {
	public static StateChange read(ObjectMapper mapper, String value) {
		try {
			return mapper.readValue(value, StateChange.class);
		}
		catch (IOException e) {
			return null;
		}
	}
}
