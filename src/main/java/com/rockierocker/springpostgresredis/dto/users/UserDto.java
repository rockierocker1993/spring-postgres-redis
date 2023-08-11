package com.rockierocker.springpostgresredis.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto extends BaseDto implements Serializable {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String name;

    private String alamat;

}
