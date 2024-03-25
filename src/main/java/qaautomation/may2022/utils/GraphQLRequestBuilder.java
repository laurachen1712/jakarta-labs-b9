package qaautomation.may2022.utils;

public class GraphQLRequestBuilder {

	public org.json.JSONObject json;

	public GraphQLRequestBuilder() {
		json = new org.json.JSONObject();
	}

	public void setQuery(String query) {
		json.put("query", query);
	}

	public void setVariables(String variables) {
		json.put("variables", variables);
	}

	public String getJSONString() {
		return json.toString();
	}

}
