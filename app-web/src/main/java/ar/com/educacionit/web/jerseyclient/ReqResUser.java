
package ar.com.educacionit.web.jerseyclient;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "support"
})
@Generated("jsonschema2pojo")
public class ReqResUser {

    @JsonProperty("data")
    public Data data;
    @JsonProperty("support")
    public Support support;
	@Override
	public String toString() {
		return "ReqResUser [data=" + data + ", support=" + support + "]";
	}

    
}
