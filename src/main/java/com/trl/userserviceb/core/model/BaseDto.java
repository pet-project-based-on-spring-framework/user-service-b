package com.trl.userserviceb.core.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * This class is designed to represent BasicDto.
 *
 * @author Tsyupryk Roman
 */
@Schema(name = "BaseD", description = "Object that represent base Dto.")
public abstract class BaseDto {

    @Schema(example = "100", minimum = "0", exclusiveMinimum = true,
            description = "ID of DTO.", nullable = true, implementation = Long.class)
    @Positive
    protected Long id;

    @Schema(example = "2001-01-01 10:30:00",
            description = "Create date.", implementation = LocalDateTime.class, nullable = true)
    protected LocalDateTime createdDate;

    @Schema(example = "2001-01-01 10:30:00",
            description = "Update date.", implementation = LocalDateTime.class, nullable = true)
    protected LocalDateTime updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}

