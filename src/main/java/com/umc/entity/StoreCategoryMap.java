package com.umc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "store_category_map")
@Getter @Setter
public class StoreCategoryMap {
    @EmbeddedId
    private StoreCategoryMapId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private StoreCategory category;

    @Embeddable
    @Getter @Setter
    public static class StoreCategoryMapId {
        @Column(name = "store_id")
        private Long storeId;

        @Column(name = "category_id")
        private Long categoryId;
    }
}