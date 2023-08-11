package com.rockierocker.springpostgresredis.dto.users;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;

@Data
public abstract class BaseDto {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "Asia/Jakarta")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date created;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "Asia/Jakarta")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date updated;

}
