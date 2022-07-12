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
	public String defaultCurrencyId;
	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	public String name;
	@Override
	public String toString() {
		return "MeliSite [defaultCurrencyId=" + defaultCurrencyId + ", id=" + id + ", name=" + name + "]";
	}

}