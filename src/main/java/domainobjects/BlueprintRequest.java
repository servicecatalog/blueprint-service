package domainobjects;

import java.util.Map;

/**
 * Created by BadziakP on 2017-05-25.
 */
public class BlueprintRequest {

    private String endpoint;
    private String symbolicName;
    private String version;
    private Map<String, String> params;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getSymbolicName() {
        return symbolicName;
    }

    public void setSymbolicName(String symbolicName) {
        this.symbolicName = symbolicName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
