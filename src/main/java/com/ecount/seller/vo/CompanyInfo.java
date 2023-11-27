package com.ecount.seller.vo;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Table(appliesTo = "company_info", comment = "회사_정보")
@NoArgsConstructor
public class CompanyInfo {

    @Comment("메뉴_정보_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long cpIdx;

}
