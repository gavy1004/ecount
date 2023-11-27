# ecount
-- ecount.company_info definition

CREATE TABLE `company_info` (
  `cp_idx` bigint NOT NULL AUTO_INCREMENT COMMENT '회사_코드',
  `cp_nm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '회사_상호',
  `cp_num` varchar(255) DEFAULT NULL COMMENT '회사_사업자등록번호',
  `cp_ceo_nm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '회사_대표자명',
  `cp_addr` varchar(255) DEFAULT NULL COMMENT '회사_주소',
  `cp_gb` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '회사_구분 1:간이, 2:일반, 3:국외',
  `cp_indt` datetime(6) DEFAULT NULL COMMENT '회사_등록일자',
  `cp_uddt` datetime(6) DEFAULT NULL COMMENT '회사_수정일자',
  PRIMARY KEY (`cp_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회사 정보';


-- ecount.user_info definition

CREATE TABLE `user_info` (
  `usr_idx` bigint NOT NULL AUTO_INCREMENT COMMENT '사용자_코드',
  `usr_auth` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '사용자_권한 A:관리자, U:사용자',
  `usr_id` varchar(20) DEFAULT NULL COMMENT '사용자_ID',
  `usr_pwd` varchar(255) DEFAULT NULL COMMENT '사용자_비밀번호',
  `usr_email` varchar(255) DEFAULT NULL COMMENT '사용자_이메일',
  `usr_phone` varchar(255) DEFAULT NULL COMMENT '사용자_핸드폰번호',
  `usr_nm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '사용자_이름',
  `usr_lck_cnt` int DEFAULT NULL COMMENT '사용자_잠김횟수',
  `usr_lck_dt` datetime(6) DEFAULT NULL COMMENT '사용자_잠금일',
  `usr_lck_yn` char(1) DEFAULT NULL COMMENT '사용자_잠김여부',
  `usr_indt` datetime(6) DEFAULT NULL COMMENT '사용자_등록일자',
  `usr_updt` datetime(6) DEFAULT NULL COMMENT '사용자_수정일자',
  PRIMARY KEY (`usr_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자 정보';
