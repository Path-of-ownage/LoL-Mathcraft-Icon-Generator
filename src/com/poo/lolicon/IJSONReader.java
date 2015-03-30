package com.poo.lolicon;

import java.util.List;

public interface IJSONReader {
	List<Object[]> readJSONArray(String arrayObject, String... fields);
}
