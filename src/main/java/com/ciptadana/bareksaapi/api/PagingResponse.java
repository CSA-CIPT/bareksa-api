package com.ciptadana.bareksaapi.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PagingResponse <T>{
    private final long total;
    private final List<T> data;
}
