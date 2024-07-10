package GoogleMapApi.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class GoogleMapApiRequestPojo
{

    private String homeMobileCountryCode="91";
    private String homeMobileNetworkCode="410";;
    private String radioType = "gsm";
    private String carrier ="vodafone";
    private boolean considerIp = true;



}
