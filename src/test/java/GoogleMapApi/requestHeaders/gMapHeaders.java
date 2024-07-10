package GoogleMapApi.requestHeaders;

import java.util.HashMap;

public class gMapHeaders
{
    public static HashMap<String,String> getInitiateTransactionHeaders()
    {
        HashMap<String,String> m = new HashMap<>();
        m.put("Content-Type", "application/json");

        return m;
    }
}
