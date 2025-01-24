package com.ciptadana.bareksaapi.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMasterMitraDTO {
    String code;
    String name;
}
