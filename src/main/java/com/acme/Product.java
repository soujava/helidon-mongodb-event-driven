package com.acme;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;

import java.util.UUID;

@Embeddable(Embeddable.EmbeddableType.GROUPING)
public record Product(@Column String code, @Column String name) {

}
