package com.gestion.velo.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockId implements Serializable {
    int storeId;
    int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockId other)) return false;
        return storeId == other.storeId && productId == other.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, productId);
    }
}