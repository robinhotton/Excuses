package Symbol.Excuses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Excuse {
    private @Id int httpCode;
    private String tag;
    private String message;

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
        if (this == object) return true;
        if (!(object instanceof Excuse)) return false;
        Excuse excuse = (Excuse) object;
        return getHttpCode() == excuse.getHttpCode() && getTag().equals(excuse.getTag()) && getMessage().equals(excuse.getMessage());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getHttpCode(), getTag(), getMessage());
    }

    @Override
    public String toString() {
        return "{\"http_code\" : " + httpCode +
                ",\"tag \": \"" + tag +
                "\",\"message \":\" " + message +
                "\"}";
    }
}