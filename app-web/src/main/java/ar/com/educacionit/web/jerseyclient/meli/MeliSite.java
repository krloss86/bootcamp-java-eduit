package ar.com.educacionit.web.jerseyclient.meli;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"default_currency_id",
"id",
"name"
})
@Generated("jsonschema2pojo")
public class MeliSite {

	@JsonProperty("default_currency_id")
	private String defaultCurrencyId;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@Override
	public String toString() {
		return "MeliSite [defaultCurrencyId=" + defaultCurrencyId + ", id=" + id + ", name=" + name + "]";
	}
	public String getDefaultCurrencyId() {
		return defaultCurrencyId;
	}
	public void setDefaultCurrencyId(String defaultCurrencyId) {
		this.defaultCurrencyId = defaultCurrencyId;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}