package com.anz.demoproject.constants;

public class AnzConstants {
	
	public interface ErrorConstants{
		public static final String DB_ERROR = "Database or SQL error.Please retry the connection later";
		public static final String BAD_REQUEST = "The request could not be understood by the server due to malformed syntex";
		public static final String JSON_START_STRING = "{\"message\":\"";
		public static final String JSON_END_STRING = "\"}";
		public static final String NO_CONTENT = "Data Not Available.Please retry later";
	}

}
