package woorifisa.goodfriends.backend.product.domain;

import lombok.experimental.SuperBuilder;
import woorifisa.goodfriends.backend.admin.domain.Admin;
import woorifisa.goodfriends.backend.global.common.BaseTimeEntity;
import woorifisa.goodfriends.backend.user.domain.User;

import javax.persistence.*;

@SuperBuilder
@Table(name = "products")
@Entity
public class Product extends BaseTimeEntity {
    // 상품 id, 유저 id(외래키), 카데고리 id(외래키), 상품 제목, 상품 상태 여부, 상품 설명, 판매 가격, 생성 일자, 수정 일자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 외래 키로 사용할 컬럼 지정
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int sellPrice;

    protected Product(){
    }
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getTitle() {
        return title;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
