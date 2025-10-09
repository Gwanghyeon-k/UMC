package com.umc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_favorite_store")
@Getter @Setter
public class UserFavoriteStore {
    @EmbeddedId
    private UserFavoriteStoreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embeddable
    @Getter @Setter
    public static class UserFavoriteStoreId {
        @Column(name = "user_id")
        private Long userId;

        @Column(name = "store_id")
        private Long storeId;
    }
}