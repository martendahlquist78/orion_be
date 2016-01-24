package info.dahlquist.app;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class DataException{

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class MissingDataException extends RuntimeException{
		private static final long serialVersionUID = 1L;

		public MissingDataException(String message) {
			super(message);
		}		
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public class InvalidDataException extends RuntimeException{
		private static final long serialVersionUID = 1L;

		public InvalidDataException(String message) {
			super(message);
		}		
	}
}