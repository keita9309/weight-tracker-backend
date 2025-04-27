package com.weighttracker.app.domain.user.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	
	/** ID */
    private Long id;
	/** ユーザ名 */
    private String username;
	/** メールアドレス */
    private String email;
	/** パスワード */
    private Password password;
	/** 名前（名） */
    private String firstName;
	/** 名前（姓） */
    private String lastName;
	/** 登録日時 */
    private LocalDateTime createdAt;
	/** 更新日時 */
    private LocalDateTime updatedAt;
    
}