package Symbol.Excuses.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Excuse {
	
	@Id
	@JsonProperty("http_code")
	private int httpCode;
	private String tag;
	private String message;

	public Excuse() {
	}

	public Excuse(int httpCode, String tag, String message) {
		this.httpCode = httpCode;
		this.tag = tag;
		this.message = message;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof Excuse))
			return false;
		Excuse excuse = (Excuse) object;
		return Objects.equals(this.getHttpCode(), excuse.getHttpCode())
				&& Objects.equals(this.getTag(), excuse.getTag())
				&& Objects.equals(this.getMessage(), excuse.getMessage());
	}

	public int hashCode() {
		return Objects.hash(this.getHttpCode(), this.getTag(), this.getMessage());
	}
	
	@Override
	public String toString() {
		return "{\"http_code\": " + httpCode + ", \"tag\": \"" + tag + "\", \"message\": \"" + message + "\"}";
	}
}