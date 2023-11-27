package com.ecount.seller.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(appliesTo = "user_info", comment = "사용자_정보")
public class UserInfo implements UserDetails {

    @Comment("사용자_정보_테이블_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrIdx;

    @Comment("사용자_권한")
    private String usrAuth;

    @Comment("사용자_ID")
    @Column(nullable = false, length = 20)
    private String usrId;

    @Comment("사용자_비밀번호")
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String usrPwd;

    @Comment("사용자_이메일")
    private String usrEmail;

    @Comment("사용자_핸드폰번호")
    private String usrPhone;

    @Comment("사용자_이름")
    @Column(nullable = false, length = 20)
    private String usrNm;

    @Comment("사용자_잠김횟수")
    @Column
    private int usrLckCnt;

    @Comment("사용자_잠김여부")
    @Column
    private String usrLckYn;

    @Comment("사용자_잠금일")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime usrLckDt;

    @Comment("사용자_등록일자")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime usrIndt;

    @Comment("사용자_수정일자")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime usrUpdt;

    @Transient
    private Collection<? extends GrantedAuthority> role;

    public Long getUsrIdx() {
        return usrIdx;
    }

    public void setUsrIdx(Long usrIdx) {
        this.usrIdx = usrIdx;
    }

    public String getUsrAuth() {
        return usrAuth;
    }

    public void setUsrAuth(String usrAuth) {
        this.usrAuth = usrAuth;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPhone() {
        return usrPhone;
    }

    public void setUsrPhone(String usrPhone) {
        this.usrPhone = usrPhone;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public int getUsrLckCnt() {
        return usrLckCnt;
    }

    public void setUsrLckCnt(int usrLckCnt) {
        this.usrLckCnt = usrLckCnt;
    }

    public String getUsrLckYn() {
        return usrLckYn;
    }

    public void setUsrLckYn(String usrLckYn) {
        this.usrLckYn = usrLckYn;
    }

    public LocalDateTime getUsrLckDt() {
        return usrLckDt;
    }

    public void setUsrLckDt(LocalDateTime usrLckDt) {
        this.usrLckDt = usrLckDt;
    }

    public LocalDateTime getUsrIndt() {
        return usrIndt;
    }

    public void setUsrIndt(LocalDateTime usrIndt) {
        this.usrIndt = usrIndt;
    }

    public LocalDateTime getUsrUpdt() {
        return usrUpdt;
    }

    public void setUsrUpdt(LocalDateTime usrUpdt) {
        this.usrUpdt = usrUpdt;
    }

    public Collection<? extends GrantedAuthority> getRole() {
        return role;
    }

    public void setRole(Collection<? extends GrantedAuthority> role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return this.usrPwd;
    }

    @Override
    public String getUsername() {
        return this.usrId;
    }

    // 계정이 만료 되었는지 (true: 만료X)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.usrLckYn.equals("Y");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
