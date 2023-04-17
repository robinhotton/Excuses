package Symbol.Excuses.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "excuses")
public class Excuse {

	@Id
	@JsonProperty("http_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int httpCode;
	@Column(nullable = true)
	private String tag;
	@Column(nullable = true)
	private String message;

	/**
	 * Le constructeur vide est obligatoire pour que Spring-Boot puisse instancier
	 * cette classe à partir des résultats de la requête de la base de données.
	 * 
	 * Si la classe ne possède pas de constructeur vide, une exception sera lancée
	 * lors de la tentative d'instanciation de l'entité.
	 */
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